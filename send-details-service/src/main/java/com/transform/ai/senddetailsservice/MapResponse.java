package com.transform.ai.senddetailsservice;

import com.backend.transform.ai.services.senddetails.SendDetailsResponse;
import io.swagger.model.AppApiResponse;
import io.swagger.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MapResponse {

    private static final Logger LOGGER = LoggerFactory.getLogger(MapResponse.class);

    @Autowired
    public MapResponse() {}

    public AppApiResponse getApiResponse(User user, SendDetailsResponse sendDetailsResponse) {
        AppApiResponse appApiResponse = new AppApiResponse();
        appApiResponse.setCode(user.getId().intValue());
        appApiResponse.setMessage(user.getFirstName() + " " + user.getLastName() + " " +
                sendDetailsResponse.getMessage() + " with username: " + user.getUsername() +
                " and email-id: " + user.getEmail());
        appApiResponse.setType("SUCCESS");

        return appApiResponse;
    }
}
