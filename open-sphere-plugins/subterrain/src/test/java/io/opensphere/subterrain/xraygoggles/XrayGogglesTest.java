package io.opensphere.subterrain.xraygoggles;

import static org.junit.Assert.assertNotNull;

import javax.swing.JMenu;

import org.easymock.EasyMock;
import org.easymock.EasyMockSupport;
import org.junit.Test;

import io.opensphere.core.Toolbox;
import io.opensphere.core.control.ui.MenuBarRegistry;
import io.opensphere.core.control.ui.UIRegistry;
import io.opensphere.core.util.swing.EventQueueUtilities;

/**
 * Unit test for {@link XrayGoggles}.
 */
public class XrayGogglesTest
{
    /**
     * Tests the xray goggles.
     */
    @Test
    public void test()
    {
        EasyMockSupport support = new EasyMockSupport();

        UIRegistry uiRegistry = createUIRegistry(support);
        Toolbox toolbox = createToolbox(support, uiRegistry);

        support.replayAll();

        XrayGoggles goggles = new XrayGoggles(toolbox);

        assertNotNull(goggles.getTransformer());

        EventQueueUtilities.runOnEDTAndWait(() ->
        {
        });

        support.verifyAll();
    }

    /**
     * Creates an easy mocked toolbox.
     *
     * @param support Used to create the mock.
     * @param uiRegistry A mocked uiRegistry.
     * @return The mocked toolbox.
     */
    private Toolbox createToolbox(EasyMockSupport support, UIRegistry uiRegistry)
    {
        Toolbox toolbox = support.createNiceMock(Toolbox.class);
        EasyMock.expect(toolbox.getUIRegistry()).andReturn(uiRegistry);

        return toolbox;
    }

    /**
     * Creates an easy mocked {@link UIRegistry}.
     *
     * @param support Used to create the mock.
     * @return The mocked {@link UIRegistry}.
     */
    private UIRegistry createUIRegistry(EasyMockSupport support)
    {
        JMenu viewMenu = new JMenu("View");
        MenuBarRegistry menuBarRegistry = support.createMock(MenuBarRegistry.class);
        EasyMock.expect(menuBarRegistry.getMenu(MenuBarRegistry.MAIN_MENU_BAR, MenuBarRegistry.VIEW_MENU)).andReturn(viewMenu);

        UIRegistry uiRegistry = support.createMock(UIRegistry.class);
        EasyMock.expect(uiRegistry.getMenuBarRegistry()).andReturn(menuBarRegistry);

        return uiRegistry;
    }
}
