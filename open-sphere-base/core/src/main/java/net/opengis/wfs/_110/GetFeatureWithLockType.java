//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.2-147 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.01.26 at 02:04:22 PM MST 
//


package net.opengis.wfs._110;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 *             A GetFeatureWithLock request operates identically to a
 *             GetFeature request expect that it attempts to lock the
 *             feature instances in the result set and includes a lock
 *             identifier in its response to a client.  A lock identifier
 *             is an identifier generated by a Web Feature Service that 
 *             a client application can use, in subsequent operations,
 *             to reference the locked set of feature instances.
 *          
 * 
 * <p>Java class for GetFeatureWithLockType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetFeatureWithLockType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.opengis.net/wfs}BaseRequestType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.opengis.net/wfs}Query" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *       &lt;attribute name="expiry" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" default="5" />
 *       &lt;attribute name="resultType" type="{http://www.opengis.net/wfs}ResultTypeType" default="results" />
 *       &lt;attribute name="outputFormat" type="{http://www.w3.org/2001/XMLSchema}string" default="text/xml; subtype=gml/3.1.1" />
 *       &lt;attribute name="maxFeatures" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *       &lt;attribute name="traverseXlinkDepth" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="traverseXlinkExpiry" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetFeatureWithLockType", propOrder = {
    "query"
})
public class GetFeatureWithLockType
    extends BaseRequestType
{

    @XmlElement(name = "Query", required = true)
    protected List<QueryType> query;
    @XmlAttribute(name = "expiry")
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger expiry;
    @XmlAttribute(name = "resultType")
    protected ResultTypeType resultType;
    @XmlAttribute(name = "outputFormat")
    protected String outputFormat;
    @XmlAttribute(name = "maxFeatures")
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger maxFeatures;
    @XmlAttribute(name = "traverseXlinkDepth")
    protected String traverseXlinkDepth;
    @XmlAttribute(name = "traverseXlinkExpiry")
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger traverseXlinkExpiry;

    /**
     * Gets the value of the query property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the query property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getQuery().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link QueryType }
     * 
     * 
     */
    public List<QueryType> getQuery() {
        if (query == null) {
            query = new ArrayList<QueryType>();
        }
        return this.query;
    }

    /**
     * Gets the value of the expiry property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getExpiry() {
        if (expiry == null) {
            return new BigInteger("5");
        } else {
            return expiry;
        }
    }

    /**
     * Sets the value of the expiry property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setExpiry(BigInteger value) {
        this.expiry = value;
    }

    /**
     * Gets the value of the resultType property.
     * 
     * @return
     *     possible object is
     *     {@link ResultTypeType }
     *     
     */
    public ResultTypeType getResultType() {
        if (resultType == null) {
            return ResultTypeType.RESULTS;
        } else {
            return resultType;
        }
    }

    /**
     * Sets the value of the resultType property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResultTypeType }
     *     
     */
    public void setResultType(ResultTypeType value) {
        this.resultType = value;
    }

    /**
     * Gets the value of the outputFormat property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOutputFormat() {
        if (outputFormat == null) {
            return "text/xml; subtype=gml/3.1.1";
        } else {
            return outputFormat;
        }
    }

    /**
     * Sets the value of the outputFormat property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOutputFormat(String value) {
        this.outputFormat = value;
    }

    /**
     * Gets the value of the maxFeatures property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getMaxFeatures() {
        return maxFeatures;
    }

    /**
     * Sets the value of the maxFeatures property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setMaxFeatures(BigInteger value) {
        this.maxFeatures = value;
    }

    /**
     * Gets the value of the traverseXlinkDepth property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTraverseXlinkDepth() {
        return traverseXlinkDepth;
    }

    /**
     * Sets the value of the traverseXlinkDepth property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTraverseXlinkDepth(String value) {
        this.traverseXlinkDepth = value;
    }

    /**
     * Gets the value of the traverseXlinkExpiry property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getTraverseXlinkExpiry() {
        return traverseXlinkExpiry;
    }

    /**
     * Sets the value of the traverseXlinkExpiry property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setTraverseXlinkExpiry(BigInteger value) {
        this.traverseXlinkExpiry = value;
    }

}
