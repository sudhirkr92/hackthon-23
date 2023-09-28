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
    
    private static final Logger logger = LoggerFactory.getLogger(MapResponse.class);
    
    @Autowired
    public MapResponse() {}
    
    public AppApiResponse getApiResponse(User user, SendDetailsResponse sendDetailsResponse) {
        AppApiResponse appApiResponse = new AppApiResponse();
        
        appApiResponse.setCode(user.getId().intValue());
        
        String message = user.getFirstName() + " " + user.getLastName() + " "
                + sendDetailsResponse.getMessage() + " " + user.getUsername() + " " + user.getEmailId();
        
        appApiResponse.setMessage(message);
        appApiResponse.setType("SUCCESS");
        
        logger.info("Mapped response: {}", appApiResponse.toString());
        
        return appApiResponse;
    }
}
