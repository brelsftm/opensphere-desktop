//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.01.26 at 12:20:39 PM MST 
//


package net.opengis.wms._111;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "contactPerson",
    "contactOrganization"
})
@XmlRootElement(name = "ContactPersonPrimary")
public class ContactPersonPrimary {

    @XmlElement(name = "ContactPerson", required = true)
    protected String contactPerson;
    @XmlElement(name = "ContactOrganization", required = true)
    protected String contactOrganization;

    /**
     * Gets the value of the contactPerson property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContactPerson() {
        return contactPerson;
    }

    /**
     * Sets the value of the contactPerson property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContactPerson(String value) {
        this.contactPerson = value;
    }

    /**
     * Gets the value of the contactOrganization property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContactOrganization() {
        return contactOrganization;
    }

    /**
     * Sets the value of the contactOrganization property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContactOrganization(String value) {
        this.contactOrganization = value;
    }

}
