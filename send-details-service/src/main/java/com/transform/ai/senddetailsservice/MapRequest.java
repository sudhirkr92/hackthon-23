package com.transform.ai.senddetailsservice;

import com.backend.transform.ai.services.senddetails.SendDetailsRequest;
import io.swagger.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MapRequest {

    private static final Logger LOGGER = LoggerFactory.getLogger(MapRequest.class);

    private final SendDetailsRequest sendDetailsRequest;

    @Autowired
    public MapRequest(SendDetailsRequest sendDetailsRequest) {
        this.sendDetailsRequest = sendDetailsRequest;
    }

    public void createRequest(User user) {
        LOGGER.info("Creating request for User: {}", user);

        sendDetailsRequest.setFirstName(user.getFirstName());
        sendDetailsRequest.setLastName(user.getLastName());
        sendDetailsRequest.setId(String.valueOf(user.getId()));

        LOGGER.info("Request created: {}", sendDetailsRequest);
    }
}
