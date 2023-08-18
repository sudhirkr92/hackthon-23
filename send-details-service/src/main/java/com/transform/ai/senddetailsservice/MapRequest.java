package com.transform.ai.senddetailsservice;


import com.backend.transform.ai.services.senddetails.SendDetailsRequest;
import io.swagger.model.AppApiResponse;
import io.swagger.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MapRequest {
    private static final Logger log = LoggerFactory.getLogger(MapRequest.class);

    //private final SendDetailsRequest sendDetailsRequest;

    @Autowired
    public MapRequest() {
        //this.abc = abc;
        //this.sendDetailsRequest = sendDetailsRequest;
    }

    public SendDetailsRequest createRequest(User user){

        log.info("MapRequest IN |||||||||||||||||||||||||||||||||||||||||||||||||||||||||");

        SendDetailsRequest sendDetailsRequest = new SendDetailsRequest();
        sendDetailsRequest.setFirstName(user.getFirstName());
        sendDetailsRequest.setLastName(user.getLastName());
        sendDetailsRequest.setId(user.getId().toString());

        log.info("MapRequest OUT ||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        return sendDetailsRequest;
    }
}
