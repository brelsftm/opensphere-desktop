//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.01.26 at 12:20:39 PM MST 
//


package net.opengis.wms._111;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "UserDefinedSymbolization")
public class UserDefinedSymbolization {

    @XmlAttribute(name = "SupportSLD")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String supportSLD;
    @XmlAttribute(name = "UserLayer")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String userLayer;
    @XmlAttribute(name = "UserStyle")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String userStyle;
    @XmlAttribute(name = "RemoteWFS")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String remoteWFS;

    /**
     * Gets the value of the supportSLD property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSupportSLD() {
        if (supportSLD == null) {
            return "0";
        } else {
            return supportSLD;
        }
    }

    /**
     * Sets the value of the supportSLD property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSupportSLD(String value) {
        this.supportSLD = value;
    }

    /**
     * Gets the value of the userLayer property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserLayer() {
        if (userLayer == null) {
            return "0";
        } else {
            return userLayer;
        }
    }

    /**
     * Sets the value of the userLayer property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserLayer(String value) {
        this.userLayer = value;
    }

    /**
     * Gets the value of the userStyle property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserStyle() {
        if (userStyle == null) {
            return "0";
        } else {
            return userStyle;
        }
    }

    /**
     * Sets the value of the userStyle property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserStyle(String value) {
        this.userStyle = value;
    }

    /**
     * Gets the value of the remoteWFS property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRemoteWFS() {
        if (remoteWFS == null) {
            return "0";
        } else {
            return remoteWFS;
        }
    }

    /**
     * Sets the value of the remoteWFS property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRemoteWFS(String value) {
        this.remoteWFS = value;
    }

}
