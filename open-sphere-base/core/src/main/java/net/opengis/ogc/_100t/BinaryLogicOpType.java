//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.02.22 at 10:22:41 AM MST 
//


package net.opengis.ogc._100t;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for BinaryLogicOpType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BinaryLogicOpType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.opengis.net/ogc}BinaryLogicOpType">
 *       &lt;redefine>
 *         &lt;complexType name="BinaryLogicOpType">
 *           &lt;complexContent>
 *             &lt;extension base="{http://www.opengis.net/ogc}LogicOpsType">
 *               &lt;choice maxOccurs="unbounded" minOccurs="2">
 *                 &lt;element ref="{http://www.opengis.net/ogc}comparisonOps"/>
 *                 &lt;element ref="{http://www.opengis.net/ogc}spatialOps"/>
 *                 &lt;element ref="{http://www.opengis.net/ogc}logicOps"/>
 *               &lt;/choice>
 *             &lt;/extension>
 *           &lt;/complexContent>
 *         &lt;/complexType>
 *       &lt;/redefine>
 *       &lt;attribute name="description" type="{http://www.w3.org/2001/XMLSchema}token" />
 *       &lt;attribute name="namehint" type="{http://www.w3.org/2001/XMLSchema}token" />
 *       &lt;attribute name="hint" type="{http://www.w3.org/2001/XMLSchema}token" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BinaryLogicOpType")
public class BinaryLogicOpType
    extends OriginalBinaryLogicOpType
{

    @XmlAttribute(name = "description")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String description;
    @XmlAttribute(name = "namehint")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String namehint;
    @XmlAttribute(name = "hint")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String hint;

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    public boolean isSetDescription() {
        return (this.description!= null);
    }

    /**
     * Gets the value of the namehint property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNamehint() {
        return namehint;
    }

    /**
     * Sets the value of the namehint property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNamehint(String value) {
        this.namehint = value;
    }

    public boolean isSetNamehint() {
        return (this.namehint!= null);
    }

    /**
     * Gets the value of the hint property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHint() {
        return hint;
    }

    /**
     * Sets the value of the hint property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHint(String value) {
        this.hint = value;
    }

    public boolean isSetHint() {
        return (this.hint!= null);
    }

}
