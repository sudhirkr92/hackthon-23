package com.transform.ai.senddetailsservice;


import com.backend.transform.ai.services.senddetails.SendDetailsRequest;
import com.backend.transform.ai.services.senddetails.SendDetailsResponse;
import com.backend.transform.ai.services.senddetails.SendDetailsService;
import io.swagger.model.AppApiResponse;
import io.swagger.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MainFlow {
    private static final Logger log = LoggerFactory.getLogger(MainFlow.class);

    private final MapRequest mapRequest;

    private final MapResponse mapResponse;

    private final SendDetailsService sendDetailsService;

    @Autowired
    public MainFlow(MapRequest mapRequest, MapResponse mapResponse, SendDetailsService sendDetailsService) {
        this.mapRequest = mapRequest;
        this.mapResponse = mapResponse;
        this.sendDetailsService = sendDetailsService;
    }

    public AppApiResponse getApiResponse(User user){

        log.info("MainFlow IN |||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        AppApiResponse appApiResponse;
        log.info("MainFlow MapRequest IN ||||||||||||||||||||||||||||||||||||||||||||||||");
        SendDetailsRequest sendDetailsRequest = mapRequest.createRequest(user);
        log.info("MainFlow MapRequest OUT |||||||||||||||||||||||||||||||||||||||||||||||");
        log.info("MainFlow-SendDetailsRequest |||||||||||||||||||||||||||||||||||||||||||");
        System.out.println("==============================================================================");
        System.out.println(sendDetailsRequest.getId());
        System.out.println(sendDetailsRequest.getFirstName());
        System.out.println(sendDetailsRequest.getLastName());
        System.out.println("==============================================================================");
        log.info("MainFlow SendDetailsService IN ||||||||||||||||||||||||||||||||||||||||");
        SendDetailsResponse sendDetailsResponse = sendDetailsService.invokeBackendService(sendDetailsRequest);
        log.info("MainFlow SendDetailsService OUT |||||||||||||||||||||||||||||||||||||||");
        log.info("MainFlow MapResponse IN |||||||||||||||||||||||||||||||||||||||||||||||");
        appApiResponse = mapResponse.getApiResponse(user,sendDetailsResponse);
        log.info("MainFlow MapResponse OUT ||||||||||||||||||||||||||||||||||||||||||||||");
        return appApiResponse;
    }
}
