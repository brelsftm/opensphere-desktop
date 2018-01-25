//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.02.22 at 10:22:41 AM MST 
//


package com.bitsys.fade.mist.state.v4;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 *         A collection of areas used to exclude data from query operations.
 *       
 * 
 * <p>Java class for ExclusionAreasType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ExclusionAreasType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="exclusionArea" type="{http://www.bit-sys.com/mist/state/v4}ExclusionAreaType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ExclusionAreasType", propOrder = {
    "exclusionArea"
})
public class ExclusionAreasType {

    protected List<ExclusionAreaType> exclusionArea;

    /**
     * Gets the value of the exclusionArea property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the exclusionArea property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getExclusionArea().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ExclusionAreaType }
     * 
     * 
     */
    public List<ExclusionAreaType> getExclusionArea() {
        if (exclusionArea == null) {
            exclusionArea = new ArrayList<ExclusionAreaType>();
        }
        return this.exclusionArea;
    }

    public boolean isSetExclusionArea() {
        return ((this.exclusionArea!= null)&&(!this.exclusionArea.isEmpty()));
    }

    public void unsetExclusionArea() {
        this.exclusionArea = null;
    }

}
