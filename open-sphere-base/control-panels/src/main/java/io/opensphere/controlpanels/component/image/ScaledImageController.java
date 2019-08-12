package io.opensphere.controlpanels.component.image;

import java.awt.Image;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * The controller that will calculate where and how big to draw the image so
 * that it scales and keeps the aspect ratio.
 */
public class ScaledImageController implements PropertyChangeListener
{
    /**
     * The model.
     */
    private final ScaledImageModel myModel;

    /**
     * Constructs a new controller.
     *
     * @param model The model used by the component.
     */
    public ScaledImageController(ScaledImageModel model)
    {
        myModel = model;
    }

    public void propertyChange(PropertyChangeEvent evt)
    {
        if (evt.getPropertyName().equals(ScaledImageModel.WIDTH_PROP))
        {
            calculateImageDrawBounds();
        }
        if (evt.getPropertyName().equals(ScaledImageModel.HEIGHT_PROP))
        {
            calculateImageDrawBounds();
        }
    }

    /**
     * Calculates the x and y coordinates to draw the image and the height and
     * width to draw the image.
     */
    private void calculateImageDrawBounds()
    {
        Image image = myModel.getImage();

        myModel.setX(0);
        myModel.setY(0);
        myModel.setImageHeight(0);
        myModel.setImageWidth(0);

        if (image != null)
        {
            int imageWidth = image.getWidth(null);
            int imageHeight = image.getHeight(null);

            myModel.setImageHeight(imageHeight);
            myModel.setImageWidth(imageWidth);

            float imageAspect = (float)imageWidth / imageHeight;

            int compHeight = myModel.getHeight();
            int compWidth = myModel.getWidth();

            if (compHeight != 0 && compWidth != 0)
            {
                float compAspect = (float)compWidth / compHeight;

                float scaleRatio = 0f;
                if (imageAspect < compAspect)
                {
                    // this means that we need to scale to the components height
                    scaleRatio = (float)compHeight / imageHeight;
                }
                else
                {
                    // this means we need to scale to the components width
                    scaleRatio = (float)compWidth / imageWidth;
                }

                int newHeight = (int)(imageHeight * scaleRatio);
                int newWidth = (int)(imageWidth * scaleRatio);

                // Now center the image
                int diff = newHeight - compHeight;
                int yOffset = -1 * diff / 2;

                diff = newWidth - compWidth;
                int xOffset = -1 * diff / 2;

                myModel.setImageHeight(newHeight);
                myModel.setImageWidth(newWidth);
                myModel.setX(xOffset);
                myModel.setY(yOffset);
            }
        }
    }

}
