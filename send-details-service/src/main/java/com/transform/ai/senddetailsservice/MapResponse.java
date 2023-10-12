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
    public MapResponse() {
    }

    public AppApiResponse getApiResponse(User user, SendDetailsResponse sendDetailsResponse) {
        LOGGER.info("Mapping User and SendDetailsResponse to AppApiResponse");

        AppApiResponse appApiResponse = new AppApiResponse();

        appApiResponse.setCode(user.getId().intValue());

        StringBuilder messageBuilder = new StringBuilder();
        messageBuilder.append(user.getFirstName()).append(" ").append(user.getLastName());
        messageBuilder.append(" ").append(sendDetailsResponse.getMessage());
        messageBuilder.append(" and email-id: ").append(user.getEmail());
        messageBuilder.append(" with username: ").append(user.getUserName());

        appApiResponse.setMessage(messageBuilder.toString());
        appApiResponse.setType("SUCCESS");

        return appApiResponse;
    }
}
