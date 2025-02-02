package io.opensphere.mantle.icon.chooser.view;

import java.util.List;

import javafx.beans.binding.Bindings;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

import io.opensphere.core.util.AwesomeIconSolid;
import io.opensphere.core.util.fx.FXUtilities;
import io.opensphere.core.util.fx.FxIcons;
import io.opensphere.core.util.image.IconUtil.IconType;
import io.opensphere.mantle.icon.IconProvider;
import io.opensphere.mantle.icon.IconSourceFactory;
import io.opensphere.mantle.icon.chooser.controller.IconRemover;
import io.opensphere.mantle.icon.chooser.model.IconModel;

/** An HBox containing display size controls, view style, and filter options. */
public class SearchControlBar extends HBox
{
    /** The bar to enter text to filter icon results. */
    private final TextField mySearchField;

    /** The menu button used to add icons. */
    private final MenuButton myAddIconsButton;

    /**
     * The remove icons button.
     */
    private final Button myRemoveButton;

    /**
     * Removes the selected icon from the icon manager.
     */
    private final IconRemover myIconRemover;

    /**
     * The icon model.
     */
    private final IconModel myModel;

    /**
     * Creates the top menu bar of the icon manager UI.
     *
     * @param panelModel the current UI model.
     */
    public SearchControlBar(IconModel panelModel)
    {
        myModel = panelModel;
        mySearchField = new TextField();
        mySearchField.setOnKeyTyped(e ->
        {
            if (e.getCharacter().charAt(0) == KeyCode.ESCAPE.getCode())
            {
                panelModel.searchTextProperty().set("");
            }
        });

        Label searchIcon = FxIcons.createClearIcon(AwesomeIconSolid.SEARCH, Color.LIGHTGREY, 16);
        searchIcon.setPadding(new Insets(0, 5, 0, 0));
        searchIcon.visibleProperty().bind(Bindings.equal("", mySearchField.textProperty()));

        Label clearIcon = FxIcons.createClearIcon(AwesomeIconSolid.TIMES_CIRCLE, Color.LIGHTGREY, 16);
        clearIcon.setPadding(new Insets(0, 5, 0, 0));
        clearIcon.setOnMouseClicked(e -> mySearchField.textProperty().set(""));
        clearIcon.disableProperty().bind(Bindings.equal("", mySearchField.textProperty()));
        clearIcon.visibleProperty().bind(Bindings.notEqual("", mySearchField.textProperty()));

        StackPane sp = new StackPane(mySearchField, searchIcon, clearIcon);
        HBox.setHgrow(sp, Priority.ALWAYS);
        StackPane.setAlignment(searchIcon, Pos.CENTER_RIGHT);
        StackPane.setAlignment(clearIcon, Pos.CENTER_RIGHT);

        mySearchField.textProperty().bindBidirectional(panelModel.searchTextProperty());

        Label addIcon = FxIcons.createClearIcon(AwesomeIconSolid.PLUS, Color.LIME, 16);
        myAddIconsButton = new MenuButton("Add Icons", addIcon);
        myAddIconsButton.setMinSize(Region.USE_PREF_SIZE, Region.USE_PREF_SIZE);

        for (var iconSource : IconSourceFactory.getInstance().getIconSources())
        {
            MenuItem item = new MenuItem("Add " + iconSource.getName(),
                    FxIcons.createClearIcon(AwesomeIconSolid.PLUS_CIRCLE, Color.LIGHTGREY, 12));
            item.onActionProperty().set(e ->
            {
                if (iconSource.getUserInput(this))
                {
                    List<IconProvider> iconProviders = iconSource.getIconProviders(panelModel.getToolbox());
                    panelModel.getIconRegistry().addIcons(iconProviders, this);
                }
            });
            myAddIconsButton.getItems().add(item);
        }

        myRemoveButton = FXUtilities.newIconButton(IconType.CLOSE, Color.RED);
        myIconRemover = new IconRemover(panelModel);
        myRemoveButton.setOnAction((e) ->
        {
            myIconRemover.deleteIcons();
        });
        enableDisableDelete();
        myModel.selectedRecordProperty().addListener((e) ->
        {
            enableDisableDelete();
        });

        getChildren().addAll(sp, myAddIconsButton, myRemoveButton);

        setAlignment(javafx.geometry.Pos.TOP_CENTER);
    }

    /**
     * Enables or disables the remove button depending on if the icon selected
     * is a user imported icon.
     */
    void enableDisableDelete()
    {
        if (myModel.selectedRecordProperty().get() == null
                || myModel.selectedRecordProperty().get().imageURLProperty().get() == null
                || myModel.selectedRecordProperty().get().imageURLProperty().get().toString().startsWith("jar:file:")
                || myModel.selectedRecordProperty().get().imageURLProperty().get().toString().contains("/target/classes/images/"))
        {
            // This is not a user imported icon, it is a system provided icon do
            // not delete.
            myRemoveButton.setDisable(true);
            myRemoveButton.setTooltip(new Tooltip("Only user imported icons can be removed."));
        }
        else
        {
            myRemoveButton.setDisable(false);
            myRemoveButton.setTooltip(new Tooltip("Remove selected icons."));
        }
    }
}
