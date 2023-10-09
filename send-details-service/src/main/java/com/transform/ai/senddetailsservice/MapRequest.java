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

    private final SendDetailsRequest sendDetailsRequest;

    @Autowired
    public MapRequest() {
        this.sendDetailsRequest = new SendDetailsRequest();
    }

    public SendDetailsRequest createRequest(User user) {
        String firstName = user.getFirstName();
        String lastName = user.getLastName();
        String id = String.valueOf(user.getId());

        sendDetailsRequest.setFirstName(firstName);
        sendDetailsRequest.setLastName(lastName);
        sendDetailsRequest.setId(id);

        logger.info("Created SendDetailsRequest: {}", sendDetailsRequest);

        return sendDetailsRequest;
    }
}
