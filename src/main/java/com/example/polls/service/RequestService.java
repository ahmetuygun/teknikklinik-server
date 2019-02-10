package com.example.polls.service;

import com.example.polls.exception.BadRequestException;
import com.example.polls.exception.ResourceNotFoundException;
import com.example.polls.model.*;
import com.example.polls.payload.OfferRO;
import com.example.polls.payload.OfferResponse;
import com.example.polls.payload.PagedResponse;
import com.example.polls.payload.PollRequest;
import com.example.polls.payload.PollResponse;
import com.example.polls.payload.VoteRequest;
import com.example.polls.repository.OfferRepository;
import com.example.polls.repository.PollRepository;
import com.example.polls.repository.UserRepository;
import com.example.polls.repository.VoteRepository;
import com.example.polls.security.UserPrincipal;
import com.example.polls.util.AppConstants;
import com.example.polls.util.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class RequestService {

    @Autowired
    private OfferRepository offerRepository;
    
    private static final Logger logger = LoggerFactory.getLogger(RequestService.class);
    
    public OfferResponse getOffersByDeviceId(Integer deviceId, Integer defectId) {
    	
    	try {
    		OfferResponse offerResponse= new OfferResponse();
        	List<OfferRO> offers= new ArrayList<OfferRO>();

        	 List<Offer>  oferList = offerRepository.findByDeviceId(deviceId,defectId);
        	 
        	 for (Offer offer : oferList) {
        		 OfferRO offerRo = new OfferRO();
        		 offerRo.setDefectName(offer.getDefect().getName());
        		 offerRo.setPrice(offer.getPrice());
        		 offerRo.setId(offer.getId());	
        		 offerRo.setDefectId(offer.getDefect().getId());
        		 offerRo.setDeviceId(offer.getDevice().getId());
        		 offers.add(offerRo);
    		}
        	 
        	 offerResponse.setOfers(offers);
    		return offerResponse;  	
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
    }

    
}
