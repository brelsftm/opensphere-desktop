package io.opensphere.mantle.icon.chooser.view;

import java.util.List;
import java.util.Map;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ListChangeListener.Change;
import javafx.collections.ObservableList;
import javafx.collections.transformation.SortedList;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane.TabDragPolicy;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;

import org.apache.commons.lang3.StringUtils;

import io.opensphere.core.util.AwesomeIconSolid;
import io.opensphere.core.util.collections.New;
import io.opensphere.core.util.fx.FxIcons;
import io.opensphere.core.util.fx.OSTab;
import io.opensphere.core.util.fx.OSTabPane;
import io.opensphere.core.util.fx.tabpane.skin.TabEditPhase;
import io.opensphere.core.util.lang.Pair;
import io.opensphere.mantle.icon.IconRecord;
import io.opensphere.mantle.icon.chooser.model.IconChooserModel;
import io.opensphere.mantle.icon.chooser.model.IconModel;

/** An panel on which the icon may be selected by the user. */
public class IconSelectionPanel extends BorderPane
{
    /** The default zoom level. */
    private static final int DEFAULT_ICON_SCALE = 60;

    /** The model in which state is maintained. */
    final IconModel myPanelModel;

    /** The tab pane in which icons for each set are rendered. */
    private final OSTabPane myIconTabs;

    /** The detail panel in which information about an icon is displayed. */
    private final IconDetail myDetailPane;

    /** The slider in which icon zoom is managed. */
    private final Slider myZoomControlPane;

    /** The component in which set controls are managed. */
    private final Node mySetControlPane;

    /** A dictionary of tabs of icons, organized by icon set. */
    private final Map<String, Pair<Tab, IconGridView>> myTabs;

    /** A flag used to track the sorting state of the editor. */
    private transient boolean mySorting;

    /** The model to which the icon chooser is bound. */
    private final IconChooserModel myIconChooserModel;

    /**
     * Keeps track of the previously selected cell for rendering purposes.
     */
    private final ObjectProperty<IconGridCell> myPreviousSelectedCellProperty;

    /**
     * The collection name for the default collection.
     */
    private final String myDefaultCollection;

    /**
     * Creates a new component bound to the supplied model.
     *
     * @param panelModel the model through which state is maintained.
     */
    public IconSelectionPanel(final IconModel panelModel)
    {
        myPanelModel = panelModel;
        myIconChooserModel = myPanelModel.getModel();
        myIconChooserModel.getIconRecords().addListener(this::onChanged);
        myDetailPane = new IconDetail(panelModel, this::refresh);

        final HBox box = new HBox(5);
        final Label iconScaleLabel = new Label("Icon Scale:");
        box.getChildren().add(iconScaleLabel);

        myZoomControlPane = new Slider(20, 150, DEFAULT_ICON_SCALE);
        myZoomControlPane.setTooltip(new Tooltip("Adjust the size of the displayed icons"));
        box.getChildren().add(myZoomControlPane);

        final Label scaleReset = FxIcons.createClearIcon(AwesomeIconSolid.TIMES, Color.ORANGERED, 14);
        scaleReset.setOnMouseClicked(e -> myPanelModel.tileWidthProperty().set(DEFAULT_ICON_SCALE));
        scaleReset.setAlignment(Pos.CENTER);
        box.getChildren().add(scaleReset);

        HBox.setHgrow(myZoomControlPane, Priority.ALWAYS);
        HBox.setHgrow(iconScaleLabel, Priority.NEVER);
        HBox.setHgrow(scaleReset, Priority.NEVER);

        myPanelModel.tileWidthProperty().bindBidirectional(myZoomControlPane.valueProperty());

        mySetControlPane = new SearchControlBar(panelModel);

        final SortedList<String> collectionNames = myIconChooserModel.getCollectionNames().sorted();
        myDefaultCollection = collectionNames.get(0);

        myIconTabs = new OSTabPane();
        myIconTabs.tabDragPolicyProperty().set(TabDragPolicy.REORDER);
        myIconTabs.newTabAction().set(e -> createSet());
        myTabs = New.map();

        myPreviousSelectedCellProperty = new SimpleObjectProperty<>();
        addTabs(collectionNames);
        myIconChooserModel.getCollectionNames().addListener((final ListChangeListener.Change<? extends String> c) ->
        {
            c.next();
            List<? extends String> added = c.getAddedSubList();

            if (myIconTabs.getTabs().filtered(tab -> added.contains(tab.getText())).isEmpty())
            {
                addTabs(added);
            }
        });

        myIconTabs.getTabs().addListener((final ListChangeListener.Change<? extends Tab> c) ->
        {
            if (!mySorting)
            {
                mySorting = true;
                FXCollections.sort(myIconTabs.getTabs(), (o1, o2) -> o1.getText().compareTo(o2.getText()));
                mySorting = false;
            }
        });

        myPanelModel.getCustomizationModel().sourceProperty().addListener((obs, ov, nv) ->
        {
            String source = myPanelModel.getCustomizationModel().sourceProperty().get();
            if (StringUtils.isNotBlank(source))
            {
                Tab toSelect = myTabs.get(source).getFirstObject();
                myIconTabs.selectionModelProperty().get().select(toSelect);
            }
        });

        final AnchorPane anchorPane = new AnchorPane(mySetControlPane, myIconTabs, box);

        AnchorPane.setRightAnchor(mySetControlPane, Double.valueOf(0.0));
        AnchorPane.setLeftAnchor(mySetControlPane, Double.valueOf(0.0));
        AnchorPane.setTopAnchor(mySetControlPane, Double.valueOf(0.0));

        AnchorPane.setRightAnchor(myIconTabs, Double.valueOf(0.0));
        AnchorPane.setLeftAnchor(myIconTabs, Double.valueOf(0.0));
        AnchorPane.setTopAnchor(myIconTabs, Double.valueOf(30.0));
        AnchorPane.setBottomAnchor(myIconTabs, Double.valueOf(15.0));

        AnchorPane.setRightAnchor(box, Double.valueOf(0.0));
        AnchorPane.setLeftAnchor(box, Double.valueOf(0.0));
        AnchorPane.setBottomAnchor(box, Double.valueOf(0.0));

        setCenter(anchorPane);
        setRight(myDetailPane);

        myPanelModel.searchTextProperty().addListener((obs, ov, nv) ->
        {
            refresh();
        });
    }

    /**
     * Helper to avoid code duplication. Adds tabs when collections are updated,
     * or the window is initialized.
     *
     * @param collectionNames List of collections to create tabs for.
     */
    private void addTabs(List<? extends String> collectionNames)
    {
        for (final String collection : collectionNames)
        {
            IconGridView content;
            if (StringUtils.equalsIgnoreCase(IconRecord.FAVORITES_COLLECTION, collection))
            {
                content = new IconGridView(myPanelModel, r -> r.favoriteProperty().get(), myPreviousSelectedCellProperty);
            }
            else
            {
                content = new IconGridView(myPanelModel, r -> r.collectionNameProperty().get().equals(collection),
                        myPreviousSelectedCellProperty);
            }

            final Tab tab = new Tab(collection, content);

            content.displayProperty().addListener((obs, ov, nv) ->
            {
                if (nv.booleanValue())
                {
                    myIconTabs.getTabs().add(tab);
                }
                else
                {
                    myIconTabs.getTabs().remove(tab);
                }
            });

            myTabs.put(collection, new Pair<>(tab, content));
            if (content.displayProperty().get())
            {
                myIconTabs.getTabs().add(tab);
            }
        }
    }

    /** An event handler used to create and add a new icon set. */
    private void createSet()
    {
        final OSTab tab = new OSTab("<New Icon Set>");
        myIconTabs.getTabs().add(myIconTabs.getTabs().size(), tab);
        myIconTabs.getSelectionModel().select(tab);
        tab.textProperty().addListener((obs, oldV, newV) ->
        {
            if (tab.getTabEditPhase().equals(TabEditPhase.PERSISTING))
            {
                IconGridView content = new IconGridView(myPanelModel, r -> r.collectionNameProperty().get().equals(newV),
                        myPreviousSelectedCellProperty);
                tab.setContent(content);
                myTabs.put(newV, new Pair<>(tab, content));

                myIconChooserModel.addCollectionName(newV);
            }
        });
        tab.tabEditPhaseProperty().set(TabEditPhase.EDITING);
    }

    /**
     * Gets the value of the {@link #myDetailPane} field.
     *
     * @return the value of the myDetailPane field.
     */
    public IconDetail getDetailPane()
    {
        return myDetailPane;
    }

    /** Refreshes the content on all of the tabs. */
    private void refresh()
    {
        myPanelModel.getIconRegistry().iconStateChanged();
    }

    /**
     * Occurs when an icon is added. Ensures the tab of the icon that was added
     * is in focus.
     *
     * @param c The changed records.
     */
    private void onChanged(Change<? extends IconRecord> c)
    {
        while (c.next())
        {
            if (c.wasAdded())
            {
                List<? extends IconRecord> adds = c.getAddedSubList();
                if (!adds.isEmpty())
                {
                    IconRecord added = adds.get(0);
                    String collectionName = added.collectionNameProperty().get();
                    Pair<Tab, IconGridView> tabAndGrid = myTabs.get(collectionName);
                    if (tabAndGrid != null)
                    {
                        myIconTabs.selectionModelProperty().get().select(tabAndGrid.getFirstObject());
                        myPanelModel.selectedRecordProperty().set(added);
                    }
                }
                break;
            }
            else if (!c.getRemoved().isEmpty())
            {
                IconRecord removed = c.getRemoved().get(0);
                String collectionName = removed.collectionNameProperty().get();
                IconGridView gridView = myTabs.get(collectionName).getSecondObject();
                ObservableList<IconRecord> icons = myPanelModel.getModel().getIconRecords(gridView.getPredicate());
                int size = icons.size();
                if (size > 0)
                {
                    myPanelModel.selectedRecordProperty().set(icons.get(size - 1));
                }
                else
                {
                    IconGridView defautlGridView = myTabs.get(myDefaultCollection).getSecondObject();
                    ObservableList<IconRecord> defaults = myPanelModel.getModel().getIconRecords(defautlGridView.getPredicate());
                    myPanelModel.selectedRecordProperty().set(defaults.get(0));
                }
            }
        }
    }
}
