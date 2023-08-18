package com.backend.transform.ai.services.senddetails;


import com.transform.ai.senddetailsservice.MapRequest;
import com.transform.ai.senddetailsservice.MapResponse;
import io.swagger.model.AppApiResponse;
import io.swagger.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

@Service
public class SendDetailsService extends WebServiceGatewaySupport {
    private static final Logger log = LoggerFactory.getLogger(SendDetailsService.class);

    private final SendDetailsEndpoint sendDetailsEndpoint;

    @Autowired
    public SendDetailsService(SendDetailsEndpoint sendDetailsEndpoint) {
        this.sendDetailsEndpoint = sendDetailsEndpoint;
    }

    public SendDetailsResponse invokeBackendService(SendDetailsRequest sendDetailsRequest){

        log.info("SendDetailsService IN |||||||||||||||||||||||||||||||||||||||||||||||||");
        SendDetailsResponse sendDetailsResponse = null;

        try {
            sendDetailsResponse = sendDetailsEndpoint.sendDetails(sendDetailsRequest);
            log.info("SendDetailsService-Response||||||||||||||||||||||||||||||||||||||||||||");
            System.out.println("==============================================================================");
            System.out.println(sendDetailsResponse.getMessage());
            System.out.println("==============================================================================");
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.info("SendDetailsService OUT ||||||||||||||||||||||||||||||||||||||||||||||||");
        return sendDetailsResponse;
    }
}
