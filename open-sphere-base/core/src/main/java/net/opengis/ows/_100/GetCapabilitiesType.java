//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.2-147 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.01.26 at 02:04:22 PM MST 
//


package net.opengis.ows._100;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * XML encoded GetCapabilities operation request. This operation allows clients to retrieve service metadata about a specific service instance. In this XML encoding, no "request" parameter is included, since the element name specifies the specific operation. This base type shall be extended by each specific OWS to include the additional required "service" attribute, with the correct value for that OWS. 
 * 
 * <p>Java class for GetCapabilitiesType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetCapabilitiesType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AcceptVersions" type="{http://www.opengis.net/ows}AcceptVersionsType" minOccurs="0"/>
 *         &lt;element name="Sections" type="{http://www.opengis.net/ows}SectionsType" minOccurs="0"/>
 *         &lt;element name="AcceptFormats" type="{http://www.opengis.net/ows}AcceptFormatsType" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="updateSequence" type="{http://www.opengis.net/ows}UpdateSequenceType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetCapabilitiesType", propOrder = {
    "acceptVersions",
    "sections",
    "acceptFormats"
})
public class GetCapabilitiesType {

    @XmlElement(name = "AcceptVersions")
    protected AcceptVersionsType acceptVersions;
    @XmlElement(name = "Sections")
    protected SectionsType sections;
    @XmlElement(name = "AcceptFormats")
    protected AcceptFormatsType acceptFormats;
    @XmlAttribute(name = "updateSequence")
    protected String updateSequence;

    /**
     * Gets the value of the acceptVersions property.
     * 
     * @return
     *     possible object is
     *     {@link AcceptVersionsType }
     *     
     */
    public AcceptVersionsType getAcceptVersions() {
        return acceptVersions;
    }

    /**
     * Sets the value of the acceptVersions property.
     * 
     * @param value
     *     allowed object is
     *     {@link AcceptVersionsType }
     *     
     */
    public void setAcceptVersions(AcceptVersionsType value) {
        this.acceptVersions = value;
    }

    /**
     * Gets the value of the sections property.
     * 
     * @return
     *     possible object is
     *     {@link SectionsType }
     *     
     */
    public SectionsType getSections() {
        return sections;
    }

    /**
     * Sets the value of the sections property.
     * 
     * @param value
     *     allowed object is
     *     {@link SectionsType }
     *     
     */
    public void setSections(SectionsType value) {
        this.sections = value;
    }

    /**
     * Gets the value of the acceptFormats property.
     * 
     * @return
     *     possible object is
     *     {@link AcceptFormatsType }
     *     
     */
    public AcceptFormatsType getAcceptFormats() {
        return acceptFormats;
    }

    /**
     * Sets the value of the acceptFormats property.
     * 
     * @param value
     *     allowed object is
     *     {@link AcceptFormatsType }
     *     
     */
    public void setAcceptFormats(AcceptFormatsType value) {
        this.acceptFormats = value;
    }

    /**
     * Gets the value of the updateSequence property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUpdateSequence() {
        return updateSequence;
    }

    /**
     * Sets the value of the updateSequence property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUpdateSequence(String value) {
        this.updateSequence = value;
    }

}
