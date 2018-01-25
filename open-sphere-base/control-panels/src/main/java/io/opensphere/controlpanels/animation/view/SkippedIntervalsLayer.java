package io.opensphere.controlpanels.animation.view;

import java.awt.Color;

import io.opensphere.controlpanels.animation.model.AnimationModel;
import io.opensphere.core.util.AwesomeIcon;
import io.opensphere.core.util.ColorUtilities;
import io.opensphere.core.util.swing.FontAwesomeIcon;

/**
 * Layer for skipped intervals.
 */
class SkippedIntervalsLayer extends IntervalsLayer
{
    /**
     * Constructor.
     *
     * @param animationModel the animation model
     */
    public SkippedIntervalsLayer(AnimationModel animationModel)
    {
        super(animationModel, animationModel.getSkippedIntervals(), "skip", "skipped",
                new FontAwesomeIcon(AwesomeIcon.ICON_BAN, Color.RED), Color.BLACK,
                ColorUtilities.opacitizeColor(Color.BLACK, 64));
    }
}
