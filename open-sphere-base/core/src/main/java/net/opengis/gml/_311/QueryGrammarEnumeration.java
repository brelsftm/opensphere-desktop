//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.2-147 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.01.26 at 02:04:22 PM MST 
//


package net.opengis.gml._311;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for QueryGrammarEnumeration.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="QueryGrammarEnumeration">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="xpath"/>
 *     &lt;enumeration value="xquery"/>
 *     &lt;enumeration value="other"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "QueryGrammarEnumeration")
@XmlEnum
public enum QueryGrammarEnumeration {

    @XmlEnumValue("xpath")
    XPATH("xpath"),
    @XmlEnumValue("xquery")
    XQUERY("xquery"),
    @XmlEnumValue("other")
    OTHER("other");
    private final String value;

    QueryGrammarEnumeration(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static QueryGrammarEnumeration fromValue(String v) {
        for (QueryGrammarEnumeration c: QueryGrammarEnumeration.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
