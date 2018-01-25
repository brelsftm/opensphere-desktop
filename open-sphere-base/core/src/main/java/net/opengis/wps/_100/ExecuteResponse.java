//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.01.26 at 12:40:25 PM MST 
//


package net.opengis.wps._100;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.opengis.net/wps/1.0.0}ResponseBaseType">
 *       &lt;sequence>
 *         &lt;element name="Process" type="{http://www.opengis.net/wps/1.0.0}ProcessBriefType"/>
 *         &lt;element name="Status" type="{http://www.opengis.net/wps/1.0.0}StatusType"/>
 *         &lt;element name="DataInputs" type="{http://www.opengis.net/wps/1.0.0}DataInputsType" minOccurs="0"/>
 *         &lt;element name="OutputDefinitions" type="{http://www.opengis.net/wps/1.0.0}OutputDefinitionsType" minOccurs="0"/>
 *         &lt;element name="ProcessOutputs" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Output" type="{http://www.opengis.net/wps/1.0.0}OutputDataType" maxOccurs="unbounded"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attribute name="serviceInstance" use="required" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
 *       &lt;attribute name="statusLocation" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "process",
    "status",
    "dataInputs",
    "outputDefinitions",
    "processOutputs"
})
@XmlRootElement(name = "ExecuteResponse")
public class ExecuteResponse
    extends ResponseBaseType
{

    @XmlElement(name = "Process", required = true)
    protected ProcessBriefType process;
    @XmlElement(name = "Status", required = true)
    protected StatusType status;
    @XmlElement(name = "DataInputs")
    protected DataInputsType dataInputs;
    @XmlElement(name = "OutputDefinitions")
    protected OutputDefinitionsType outputDefinitions;
    @XmlElement(name = "ProcessOutputs")
    protected ExecuteResponse.ProcessOutputs processOutputs;
    @XmlAttribute(required = true)
    @XmlSchemaType(name = "anyURI")
    protected String serviceInstance;
    @XmlAttribute
    @XmlSchemaType(name = "anyURI")
    protected String statusLocation;

    /**
     * Gets the value of the process property.
     * 
     * @return
     *     possible object is
     *     {@link ProcessBriefType }
     *     
     */
    public ProcessBriefType getProcess() {
        return process;
    }

    /**
     * Sets the value of the process property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProcessBriefType }
     *     
     */
    public void setProcess(ProcessBriefType value) {
        this.process = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link StatusType }
     *     
     */
    public StatusType getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link StatusType }
     *     
     */
    public void setStatus(StatusType value) {
        this.status = value;
    }

    /**
     * Gets the value of the dataInputs property.
     * 
     * @return
     *     possible object is
     *     {@link DataInputsType }
     *     
     */
    public DataInputsType getDataInputs() {
        return dataInputs;
    }

    /**
     * Sets the value of the dataInputs property.
     * 
     * @param value
     *     allowed object is
     *     {@link DataInputsType }
     *     
     */
    public void setDataInputs(DataInputsType value) {
        this.dataInputs = value;
    }

    /**
     * Gets the value of the outputDefinitions property.
     * 
     * @return
     *     possible object is
     *     {@link OutputDefinitionsType }
     *     
     */
    public OutputDefinitionsType getOutputDefinitions() {
        return outputDefinitions;
    }

    /**
     * Sets the value of the outputDefinitions property.
     * 
     * @param value
     *     allowed object is
     *     {@link OutputDefinitionsType }
     *     
     */
    public void setOutputDefinitions(OutputDefinitionsType value) {
        this.outputDefinitions = value;
    }

    /**
     * Gets the value of the processOutputs property.
     * 
     * @return
     *     possible object is
     *     {@link ExecuteResponse.ProcessOutputs }
     *     
     */
    public ExecuteResponse.ProcessOutputs getProcessOutputs() {
        return processOutputs;
    }

    /**
     * Sets the value of the processOutputs property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExecuteResponse.ProcessOutputs }
     *     
     */
    public void setProcessOutputs(ExecuteResponse.ProcessOutputs value) {
        this.processOutputs = value;
    }

    /**
     * Gets the value of the serviceInstance property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServiceInstance() {
        return serviceInstance;
    }

    /**
     * Sets the value of the serviceInstance property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServiceInstance(String value) {
        this.serviceInstance = value;
    }

    /**
     * Gets the value of the statusLocation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatusLocation() {
        return statusLocation;
    }

    /**
     * Sets the value of the statusLocation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatusLocation(String value) {
        this.statusLocation = value;
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
     *         &lt;element name="Output" type="{http://www.opengis.net/wps/1.0.0}OutputDataType" maxOccurs="unbounded"/>
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
        "output"
    })
    public static class ProcessOutputs {

        @XmlElement(name = "Output", required = true)
        protected List<OutputDataType> output;

        /**
         * Gets the value of the output property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the output property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getOutput().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link OutputDataType }
         * 
         * 
         */
        public List<OutputDataType> getOutput() {
            if (output == null) {
                output = new ArrayList<OutputDataType>();
            }
            return this.output;
        }

    }

}
