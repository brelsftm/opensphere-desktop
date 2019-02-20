package io.opensphere.core.pipeline;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;

/**
 * Detects what scale factor is currently set for the display on high dpi monitors.
 */
public class ScaleDetector
{
    /**
     * The current dpi scale on the current monitor.
     */
    private final float myDPIScale;

    /**
     * Constructor.
     */
    public ScaleDetector()
    {
        double screenHeight = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        int gdHeight = gd.getDisplayMode().getHeight();
        myDPIScale = (float)(gdHeight /  screenHeight);
    }
    /**
     * Gets the currently set scale for this monitor.
     * @return The scale.
     */
    public float getScale()
    {
        return myDPIScale;
    }
}
