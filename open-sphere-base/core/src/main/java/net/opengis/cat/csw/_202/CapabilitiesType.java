//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.01.22 at 02:23:57 PM MST 
//


package net.opengis.cat.csw._202;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import net.opengis.ogc._110.FilterCapabilities;
import net.opengis.ows._100.CapabilitiesBaseType;


/**
 * This type extends ows:CapabilitiesBaseType defined in OGC-05-008 
 *          to include information about supported OGC filter components. A 
 *          profile may extend this type to describe additional capabilities.
 * 
 * <p>Java class for CapabilitiesType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CapabilitiesType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.opengis.net/ows}CapabilitiesBaseType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.opengis.net/ogc}Filter_Capabilities"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CapabilitiesType", propOrder = {
    "filterCapabilities"
})
public class CapabilitiesType
    extends CapabilitiesBaseType
{

    @XmlElement(name = "Filter_Capabilities", namespace = "http://www.opengis.net/ogc", required = true)
    protected FilterCapabilities filterCapabilities;

    /**
     * Gets the value of the filterCapabilities property.
     * 
     * @return
     *     possible object is
     *     {@link FilterCapabilities }
     *     
     */
    public FilterCapabilities getFilterCapabilities() {
        return filterCapabilities;
    }

    /**
     * Sets the value of the filterCapabilities property.
     * 
     * @param value
     *     allowed object is
     *     {@link FilterCapabilities }
     *     
     */
    public void setFilterCapabilities(FilterCapabilities value) {
        this.filterCapabilities = value;
    }

}
