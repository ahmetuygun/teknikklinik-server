package com.example.polls.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.polls.payload.OfferResponse;
import com.example.polls.security.CurrentUser;
import com.example.polls.security.UserPrincipal;
import com.example.polls.service.RequestService;

/**
 * Created by rajeevkumarsingh on 20/11/17.
 */

@RestController
@RequestMapping("/api/offer")
public class RequestController {

    @Autowired
    RequestService requestService;

    @GetMapping("/{deviceId}/{defectId}")
    public OfferResponse getOfferListByDeviceId(
                                    @PathVariable Integer deviceId, @PathVariable Integer defectId) {
        return requestService.getOffersByDeviceId(deviceId,defectId);
    }

}
