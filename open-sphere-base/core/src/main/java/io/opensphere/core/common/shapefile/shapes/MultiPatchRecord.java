/**
 *
 */
package io.opensphere.core.common.shapefile.shapes;

import java.awt.geom.Point2D;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public class MultiPatchRecord extends PolygonZRecord
{
    /* Byte Position Field Value Type Order Byte 0 Shape Type 31 Integer Little
     * Byte 4 Box Box Double[4] Little Byte 36 NumParts NumParts Integer Little
     * Byte 40 NumPoints NumPoints Integer Little Byte 44 Parts Parts
     * Integer[NumParts] Little Byte 44 PartTypes PartTypes Integer[NumParts]
     * Little Byte XX Points Points Point[NumPoints] Little
     *
     * The "Z" adds" Byte Y Zmin Zmin Double Little Byte Y+8 Zmax Zmax Double
     * Little Byte Y+16 Zarray Zarray Double[NumPoints] Little
     *
     * Where Point = Double, Double (x,y)
     *
     * The "M" adds" Byte Y Mmin Mmin Double Little Byte Y+8 Mmax Mmax Double
     * Little Byte Y+16 Marray Marray Double[NumPoints] Little */

    public enum PartType
    {
        TRAINGLE_STRIP(0), TRANGLE_FAN(1), OUTER_RING(2), INNER_RING(3), FIRST_RING(4), RING(5);

        private int value;

        private PartType(int value)
        {
            this.value = value;
        }

        public int getValue()
        {
            return value;
        }

        public static PartType getType(int value)
        {
            PartType returnType = TRAINGLE_STRIP;
            switch (value)
            {
                case 1:
                    returnType = TRANGLE_FAN;
                    break;
                case 2:
                    returnType = OUTER_RING;
                    break;
                case 3:
                    returnType = INNER_RING;
                    break;
                case 4:
                    returnType = FIRST_RING;
                    break;
                case 5:
                    returnType = RING;
                    break;
            }
            return returnType;
        }
    }

    protected PartType[] partTypes;

    /**
     *
     */
    public MultiPatchRecord()
    {
        shapeType = 31;
    }

    @Override
    public int getContentLengthInWords()
    {
        return 30 + 2 * (parts == null ? 0 : parts.length) + 10 * (points == null ? 0 : points.length)
                + 2 * (partTypes == null ? 0 : partTypes.length) + 8 + 4 * (measurements == null ? 0 : measurements.length) + 8
                + 4 * (zValues == null ? 0 : zValues.length);
    }

    public MultiPatchRecord(PartType partType, List<Point2D.Double> partPointList, List<Double> zList,
            List<Double> partMeasurementList)
    {
        this();

        if (partPointList == null || partMeasurementList == null)
        {
            throw new NullPointerException();
        }

        if (partPointList.size() == 0)
        {
            throw new IllegalArgumentException("List must contain data!");
        }

        if (partPointList.size() != partMeasurementList.size())
        {
            throw new IllegalArgumentException("Point and Measurment List Must be the same size!");
        }

        if (partPointList.size() != zList.size())
        {
            throw new IllegalArgumentException("Point and Z List Must be the same size!");
        }

        addPart(partPointList, zList, partMeasurementList);
    }

    public PartType[] getPartTypes()
    {
        return partTypes;
    }

    @Override
    public void addPart(List<Point2D.Double> partPointList)
    {
        ArrayList<Double> measList = new ArrayList<>(partPointList.size());
        for (int i = 0; i < partPointList.size(); i++)
        {
            measList.add(0.0);
        }

        addPart(partPointList, measList);
    }

    @Override
    public void addPart(List<Point2D.Double> partPointList, List<Double> partMeasurementList)
    {
        ArrayList<Double> zList = new ArrayList<>(partPointList.size());
        for (int i = 0; i < partPointList.size(); i++)
        {
            zList.add(0.0);
        }

        addPart(partPointList, zList, partMeasurementList);
    }

    @Override
    public void addPart(List<Point2D.Double> partPointList, List<Double> zList, List<Double> partMeasurementList)
    {
        addPart(PartType.TRANGLE_FAN, partPointList, zList, partMeasurementList);
    }

    public void addPart(PartType partType, List<Point2D.Double> partPointList, List<Double> zList,
            List<Double> partMeasurementList)
    {
        if (partPointList == null || partMeasurementList == null)
        {
            throw new NullPointerException();
        }

        if (partPointList.size() != partMeasurementList.size())
        {
            throw new IllegalArgumentException("Point and Measurment List Must be the same size!");
        }

        // If we don't already have a bounding box
        // the create one and prep it for new bounds.
        if (box == null)
        {
            box = new double[4];
            // Xmin
            box[0] = Double.MAX_VALUE;
            // Ymin
            box[1] = Double.MAX_VALUE;
            // Xmax
            box[2] = Double.MIN_VALUE;
            // Ymax
            box[3] = Double.MIN_VALUE;
        }

        // If we don't already have a measurement set
        // prep the min/max
        if (measurements == null)
        {
            measurementMin = Double.MAX_VALUE;
            measurementMax = Double.MIN_VALUE;
        }

        // If we don't already have a z record set
        // prep the min/max
        if (zValues == null)
        {
            zMin = Double.MAX_VALUE;
            zMax = Double.MIN_VALUE;
        }

        numParts++;
        numPoints += partPointList.size();

        // Take care of the points array, rebuilding it if necessary.
        int nextPartIndex = 0;
        if (points == null)
        {
            points = new Point2D.Double[partPointList.size()];
            for (int i = 0; i < partPointList.size(); i++)
            {
                points[i] = partPointList.get(i);

                if (points[i].getX() < box[0])
                {
                    box[0] = points[i].getX();
                }

                if (points[i].getY() < box[1])
                {
                    box[1] = points[i].getY();
                }

                if (points[i].getX() > box[2])
                {
                    box[2] = points[i].getX();
                }

                if (points[i].getY() > box[3])
                {
                    box[3] = points[i].getY();
                }
            }
        }
        else
        {

            Point2D.Double[] points2 = new Point2D.Double[points.length + partPointList.size()];
            System.arraycopy(points, 0, points2, 0, points.length);

            for (int i = 0; i < partPointList.size(); i++)
            {
                points2[i + points.length] = partPointList.get(i);

                // Also amend the bounding box if necessary
                if (points2[i + points.length].getX() < box[0])
                {
                    box[0] = points2[i + points.length].getX();
                }

                if (points2[i + points.length].getY() < box[1])
                {
                    box[1] = points2[i + points.length].getY();
                }

                if (points2[i + points.length].getX() > box[2])
                {
                    box[2] = points2[i + points.length].getX();
                }

                if (points2[i + points.length].getY() > box[3])
                {
                    box[3] = points2[i + points.length].getY();
                }
            }

            points = points2;
        }

        // Take care of the parts types array, rebuilding it if necessary
        if (partTypes == null)
        {
            partTypes = new PartType[1];
            partTypes[0] = partType;
        }
        else
        {
            PartType[] partsTypes2 = new PartType[parts.length + 1];
            System.arraycopy(partTypes, 0, partsTypes2, 0, partTypes.length);

            partsTypes2[partsTypes2.length - 1] = partType;
        }

        // Take care of the parts array, rebuilding it if necessary
        if (parts == null)
        {
            parts = new int[1];
            parts[0] = 0;
        }
        else
        {
            int[] parts2 = new int[parts.length + 1];
            System.arraycopy(parts, 0, parts2, 0, parts.length);

            parts2[parts2.length - 1] = nextPartIndex;
        }

        // Take care of the measurements array, rebuild if necessary
        if (measurements == null)
        {
            measurements = new double[partMeasurementList.size()];
            for (int i = 0; i < partMeasurementList.size(); i++)
            {
                measurements[i] = partMeasurementList.get(i);

                if (measurements[i] < measurementMin)
                {
                    measurementMin = measurements[i];
                }

                if (measurements[i] > measurementMax)
                {
                    measurementMax = measurements[i];
                }
            }
        }
        else
        {
            double[] meas2 = new double[measurements.length + 1];
            System.arraycopy(measurements, 0, meas2, 0, measurements.length);

            for (int i = 0; i < partMeasurementList.size(); i++)
            {
                meas2[i + measurements.length] = partMeasurementList.get(i);

                // Also amend the bounding range if necessary
                if (measurements[i + measurements.length] < measurementMin)
                {
                    measurementMin = measurements[i + measurements.length];
                }

                if (measurements[i + measurements.length] > measurementMax)
                {
                    measurementMax = measurements[i + measurements.length];
                }
            }
            measurements = meas2;
        }

        // Take care of the measurements array, rebuild if necessary
        if (zValues == null)
        {
            zValues = new double[zList.size()];
            for (int i = 0; i < zList.size(); i++)
            {
                zValues[i] = zList.get(i);

                if (zValues[i] < zMin)
                {
                    zMin = zValues[i];
                }

                if (zValues[i] > zMax)
                {
                    zMax = zValues[i];
                }
            }
        }
        else
        {
            double[] meas2 = new double[zValues.length + 1];
            System.arraycopy(zValues, 0, meas2, 0, zValues.length);

            for (int i = 0; i < zList.size(); i++)
            {
                meas2[i + zValues.length] = zList.get(i);

                // Also amend the bounding range if necessary
                if (zValues[i + zValues.length] < zMin)
                {
                    zMin = zValues[i + zValues.length];
                }

                if (zValues[i + zValues.length] > zMax)
                {
                    zMax = zValues[i + zValues.length];
                }
            }
            zValues = meas2;
        }
    }

    @Override
    public boolean parseRecord(ByteBuffer buffer)
    {
        boolean returnValue = true;
        if (!parseRecordType(buffer))
        {
            // Log
            returnValue = false;
        }
        else if (getShapeType() != ShapeType.MULTIPATCH.getValue())
        {
            // Log
            returnValue = false;
        }
        else
        {
            box = new double[4];
            for (int i = 0; i < 4; i++)
            {
                box[i] = buffer.getDouble();
            }
            numParts = buffer.getInt();
            numPoints = buffer.getInt();
            parts = new int[numParts];
            for (int i = 0; i < numParts; i++)
            {
                parts[i] = buffer.getInt();
            }

            partTypes = new PartType[numParts];
            for (int i = 0; i < numParts; i++)
            {
                partTypes[i] = PartType.getType(buffer.getInt());
            }

            points = new Point2D.Double[numPoints];
            for (int i = 0; i < numPoints; i++)
            {
                points[i] = new Point2D.Double();
                points[i].x = buffer.getDouble();
                points[i].y = buffer.getDouble();
            }
            zMin = buffer.getDouble();
            zMax = buffer.getDouble();
            zValues = new double[numPoints];
            for (int i = 0; i < numPoints; i++)
            {
                zValues[i] = buffer.getDouble();
            }
            measurementMin = buffer.getDouble();
            measurementMax = buffer.getDouble();
            measurements = new double[numPoints];
            for (int i = 0; i < numPoints; i++)
            {
                measurements[i] = buffer.getDouble();
            }
        }
        return returnValue;
    }

    @Override
    public boolean writeRecord(ByteBuffer buffer)
    {
        boolean returnValue = true;
        if (!super.writeRecord(buffer))
        {
            // Log
            returnValue = false;
        }
        else if (getShapeType() != ShapeType.MULTIPATCH.getValue())
        {
            // Log
            returnValue = false;
        }
        else
        {
            for (int i = 0; i < 4; i++)
            {
                buffer.putDouble(box[i]);
            }
            buffer.putInt(numParts);
            buffer.putInt(numPoints);
            for (int i = 0; i < numParts; i++)
            {
                buffer.putInt(parts[i]);
            }
            for (int i = 0; i < numParts; i++)
            {
                buffer.putInt(partTypes[i].getValue());
            }
            for (int i = 0; i < numPoints; i++)
            {
                buffer.putDouble(points[i].x);
                buffer.putDouble(points[i].y);
            }

            buffer.putDouble(zMin);
            buffer.putDouble(zMax);
            for (int i = 0; i < numPoints; i++)
            {
                buffer.putDouble(zValues[i]);
            }

            buffer.putDouble(measurementMin);
            buffer.putDouble(measurementMax);
            for (int i = 0; i < numPoints; i++)
            {
                buffer.putDouble(measurements[i]);
            }

        }
        return returnValue;
    }

    @Override
    public String toString()
    {
        return super.toString();
    }
}
