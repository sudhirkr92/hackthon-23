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
        String firstName = user.getFirstName();
        String lastName = user.getLastName();
        String id = String.valueOf(user.getId());

        logger.info("Creating SendDetailsRequest with firstName: {}, lastName: {}, id: {}", firstName, lastName, id);

        SendDetailsRequest sendDetailsRequest = new SendDetailsRequest();
        sendDetailsRequest.setFirstName(firstName);
        sendDetailsRequest.setLastName(lastName);
        sendDetailsRequest.setId(id);

        return sendDetailsRequest;
    }
}
