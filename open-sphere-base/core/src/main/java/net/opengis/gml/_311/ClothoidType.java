//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.2-147 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.01.26 at 02:04:22 PM MST 
//


package net.opengis.gml._311;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * A clothoid, or Cornu's spiral, is plane
 *    curve whose curvature is a fixed function of its length.
 *    In suitably chosen co-ordinates it is given by Fresnel's
 *    integrals.
 * 
 *     x(t) = 0-integral-t cos(AT*T/2)dT    
 *     
 *     y(t) = 0-integral-t sin(AT*T/2)dT
 *    
 *    This geometry is mainly used as a transition curve between
 *    curves of type straight line to circular arc or circular arc
 *    to circular arc. With this curve type it is possible to 
 *    achieve a C2-continous transition between the above mentioned
 *    curve types. One formula for the Clothoid is A*A = R*t where
 *    A is constant, R is the varying radius of curvature along the
 *    the curve and t is the length along and given in the Fresnel 
 *    integrals.
 * 
 * <p>Java class for ClothoidType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ClothoidType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.opengis.net/gml}AbstractCurveSegmentType">
 *       &lt;sequence>
 *         &lt;element name="refLocation">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element ref="{http://www.opengis.net/gml}AffinePlacement"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="scaleFactor" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="startParameter" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="endParameter" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ClothoidType", propOrder = {
    "refLocation",
    "scaleFactor",
    "startParameter",
    "endParameter"
})
public class ClothoidType
    extends AbstractCurveSegmentType
{

    @XmlElement(required = true)
    protected ClothoidType.RefLocation refLocation;
    @XmlElement(required = true)
    protected BigDecimal scaleFactor;
    protected double startParameter;
    protected double endParameter;

    /**
     * Gets the value of the refLocation property.
     * 
     * @return
     *     possible object is
     *     {@link ClothoidType.RefLocation }
     *     
     */
    public ClothoidType.RefLocation getRefLocation() {
        return refLocation;
    }

    /**
     * Sets the value of the refLocation property.
     * 
     * @param value
     *     allowed object is
     *     {@link ClothoidType.RefLocation }
     *     
     */
    public void setRefLocation(ClothoidType.RefLocation value) {
        this.refLocation = value;
    }

    /**
     * Gets the value of the scaleFactor property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getScaleFactor() {
        return scaleFactor;
    }

    /**
     * Sets the value of the scaleFactor property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setScaleFactor(BigDecimal value) {
        this.scaleFactor = value;
    }

    /**
     * Gets the value of the startParameter property.
     * 
     */
    public double getStartParameter() {
        return startParameter;
    }

    /**
     * Sets the value of the startParameter property.
     * 
     */
    public void setStartParameter(double value) {
        this.startParameter = value;
    }

    /**
     * Gets the value of the endParameter property.
     * 
     */
    public double getEndParameter() {
        return endParameter;
    }

    /**
     * Sets the value of the endParameter property.
     * 
     */
    public void setEndParameter(double value) {
        this.endParameter = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element ref="{http://www.opengis.net/gml}AffinePlacement"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "affinePlacement"
    })
    public static class RefLocation {

        @XmlElement(name = "AffinePlacement", required = true)
        protected AffinePlacementType affinePlacement;

        /**
         * The "refLocation" is an affine mapping 
         *           that places  the curve defined by the Fresnel Integrals  
         *           into the co-ordinate reference system of this object.
         * 
         * @return
         *     possible object is
         *     {@link AffinePlacementType }
         *     
         */
        public AffinePlacementType getAffinePlacement() {
            return affinePlacement;
        }

        /**
         * Sets the value of the affinePlacement property.
         * 
         * @param value
         *     allowed object is
         *     {@link AffinePlacementType }
         *     
         */
        public void setAffinePlacement(AffinePlacementType value) {
            this.affinePlacement = value;
        }

    }

}
