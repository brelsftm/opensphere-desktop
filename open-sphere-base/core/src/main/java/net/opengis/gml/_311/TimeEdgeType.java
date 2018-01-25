//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.2-147 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.01.26 at 02:04:22 PM MST 
//


package net.opengis.gml._311;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Type declaration of the element "TimeEdge".
 * 
 * <p>Java class for TimeEdgeType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TimeEdgeType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.opengis.net/gml}AbstractTimeTopologyPrimitiveType">
 *       &lt;sequence>
 *         &lt;element name="start" type="{http://www.opengis.net/gml}TimeNodePropertyType"/>
 *         &lt;element name="end" type="{http://www.opengis.net/gml}TimeNodePropertyType"/>
 *         &lt;element name="extent" type="{http://www.opengis.net/gml}TimePeriodPropertyType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TimeEdgeType", propOrder = {
    "start",
    "end",
    "extent"
})
public class TimeEdgeType
    extends AbstractTimeTopologyPrimitiveType
{

    @XmlElement(required = true)
    protected TimeNodePropertyType start;
    @XmlElement(required = true)
    protected TimeNodePropertyType end;
    protected TimePeriodPropertyType extent;

    /**
     * Gets the value of the start property.
     * 
     * @return
     *     possible object is
     *     {@link TimeNodePropertyType }
     *     
     */
    public TimeNodePropertyType getStart() {
        return start;
    }

    /**
     * Sets the value of the start property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimeNodePropertyType }
     *     
     */
    public void setStart(TimeNodePropertyType value) {
        this.start = value;
    }

    /**
     * Gets the value of the end property.
     * 
     * @return
     *     possible object is
     *     {@link TimeNodePropertyType }
     *     
     */
    public TimeNodePropertyType getEnd() {
        return end;
    }

    /**
     * Sets the value of the end property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimeNodePropertyType }
     *     
     */
    public void setEnd(TimeNodePropertyType value) {
        this.end = value;
    }

    /**
     * Gets the value of the extent property.
     * 
     * @return
     *     possible object is
     *     {@link TimePeriodPropertyType }
     *     
     */
    public TimePeriodPropertyType getExtent() {
        return extent;
    }

    /**
     * Sets the value of the extent property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimePeriodPropertyType }
     *     
     */
    public void setExtent(TimePeriodPropertyType value) {
        this.extent = value;
    }

}
