//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.01.26 at 12:20:41 PM MST 
//


package net.opengis.wms_130;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="CRS" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="minx" use="required" type="{http://www.w3.org/2001/XMLSchema}double" />
 *       &lt;attribute name="miny" use="required" type="{http://www.w3.org/2001/XMLSchema}double" />
 *       &lt;attribute name="maxx" use="required" type="{http://www.w3.org/2001/XMLSchema}double" />
 *       &lt;attribute name="maxy" use="required" type="{http://www.w3.org/2001/XMLSchema}double" />
 *       &lt;attribute name="resx" type="{http://www.w3.org/2001/XMLSchema}double" />
 *       &lt;attribute name="resy" type="{http://www.w3.org/2001/XMLSchema}double" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "BoundingBox")
public class BoundingBox {

    @XmlAttribute(name = "CRS", required = true)
    protected String crs;
    @XmlAttribute(required = true)
    protected double minx;
    @XmlAttribute(required = true)
    protected double miny;
    @XmlAttribute(required = true)
    protected double maxx;
    @XmlAttribute(required = true)
    protected double maxy;
    @XmlAttribute
    protected Double resx;
    @XmlAttribute
    protected Double resy;

    /**
     * Gets the value of the crs property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCRS() {
        return crs;
    }

    /**
     * Sets the value of the crs property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCRS(String value) {
        this.crs = value;
    }

    /**
     * Gets the value of the minx property.
     * 
     */
    public double getMinx() {
        return minx;
    }

    /**
     * Sets the value of the minx property.
     * 
     */
    public void setMinx(double value) {
        this.minx = value;
    }

    /**
     * Gets the value of the miny property.
     * 
     */
    public double getMiny() {
        return miny;
    }

    /**
     * Sets the value of the miny property.
     * 
     */
    public void setMiny(double value) {
        this.miny = value;
    }

    /**
     * Gets the value of the maxx property.
     * 
     */
    public double getMaxx() {
        return maxx;
    }

    /**
     * Sets the value of the maxx property.
     * 
     */
    public void setMaxx(double value) {
        this.maxx = value;
    }

    /**
     * Gets the value of the maxy property.
     * 
     */
    public double getMaxy() {
        return maxy;
    }

    /**
     * Sets the value of the maxy property.
     * 
     */
    public void setMaxy(double value) {
        this.maxy = value;
    }

    /**
     * Gets the value of the resx property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getResx() {
        return resx;
    }

    /**
     * Sets the value of the resx property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setResx(Double value) {
        this.resx = value;
    }

    /**
     * Gets the value of the resy property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getResy() {
        return resy;
    }

    /**
     * Sets the value of the resy property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setResy(Double value) {
        this.resy = value;
    }

}
