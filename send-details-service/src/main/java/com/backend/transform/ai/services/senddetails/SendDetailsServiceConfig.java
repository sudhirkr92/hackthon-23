package com.backend.transform.ai.services.senddetails;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.binding.soap.SoapBinding;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.transport.http.HTTPConduit;
import org.apache.cxf.transports.http.configuration.HTTPClientPolicy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.soap.SOAPBinding;

@Configuration
public class SendDetailsServiceConfig {
    private static final Logger log = LoggerFactory.getLogger(SendDetailsServiceConfig.class);

    private String sendDetailsBackendUrl;
    private int connectionTimeout;
    private int receiveTimeout;
    public int getConnectionTimeout() {
        return connectionTimeout;
    }
    public int getReceiveTimeout() {
        return receiveTimeout;
    }
    public String getSendDetailsBackendUrl() {
        return sendDetailsBackendUrl;
    }

    @Bean(name = "sendDetailsEndpointProxy")
    public SendDetailsEndpoint sendDetailsEndpointProxy() {

        JaxWsProxyFactoryBean jaxWsProxyFactoryBean = new JaxWsProxyFactoryBean();
        jaxWsProxyFactoryBean.setServiceClass(SendDetailsEndpoint.class);
        jaxWsProxyFactoryBean.setAddress("http://localhost:8088/v1/SendDetailsService");
        jaxWsProxyFactoryBean.setBindingId(SOAPBinding.SOAP12HTTP_BINDING);
        Client client = (Client) jaxWsProxyFactoryBean.create();
        HTTPConduit httpConduit = (HTTPConduit) client.getConduit();

        HTTPClientPolicy httpClientPolicy = new HTTPClientPolicy();
        httpClientPolicy.setConnectionTimeout(2000);
        httpClientPolicy.setReceiveTimeout(2000);
        httpConduit.setClient(httpClientPolicy);
        return (SendDetailsEndpoint) client;
    }

}
