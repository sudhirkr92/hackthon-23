package com.transform.ai.senddetailsservice;

import com.backend.transform.ai.services.senddetails.SendDetailsRequest;
import io.swagger.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MapRequest {
    
    private static final Logger logger = LoggerFactory.getLogger(MapRequest.class);
    
    @Autowired
    public MapRequest() {}
    
    public SendDetailsRequest createRequest(User user) {
        SendDetailsRequest sendDetailsRequest = new SendDetailsRequest();
        sendDetailsRequest.setFirstName(user.getFirstName());
        sendDetailsRequest.setLastName(user.getLastName());
        sendDetailsRequest.setId(String.valueOf(user.getId()));
        logger.info("Created SendDetailsRequest: {}", sendDetailsRequest);
        return sendDetailsRequest;
    }
}
