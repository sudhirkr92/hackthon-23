
package com.backend.transform.ai.services.senddetails;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.backend.transform.ai.services.senddetails package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _SendDetailsRequest_QNAME = new QName("http://ai.transform.backend.com/services/senddetails", "SendDetailsRequest");
    private final static QName _SendDetailsResponse_QNAME = new QName("http://ai.transform.backend.com/services/senddetails", "SendDetailsResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.backend.transform.ai.services.senddetails
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SendDetailsRequest }
     * 
     */
    public SendDetailsRequest createSendDetailsRequest() {
        return new SendDetailsRequest();
    }

    /**
     * Create an instance of {@link SendDetailsResponse }
     * 
     */
    public SendDetailsResponse createSendDetailsResponse() {
        return new SendDetailsResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SendDetailsRequest }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SendDetailsRequest }{@code >}
     */
    @XmlElementDecl(namespace = "http://ai.transform.backend.com/services/senddetails", name = "SendDetailsRequest")
    public JAXBElement<SendDetailsRequest> createSendDetailsRequest(SendDetailsRequest value) {
        return new JAXBElement<SendDetailsRequest>(_SendDetailsRequest_QNAME, SendDetailsRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SendDetailsResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SendDetailsResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://ai.transform.backend.com/services/senddetails", name = "SendDetailsResponse")
    public JAXBElement<SendDetailsResponse> createSendDetailsResponse(SendDetailsResponse value) {
        return new JAXBElement<SendDetailsResponse>(_SendDetailsResponse_QNAME, SendDetailsResponse.class, null, value);
    }

}
