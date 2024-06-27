package com.aipo.url.service;

import com.aipo.url.model.UrlResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class URLService {

    @Autowired
    RestTemplate restTemplate;


    public UrlResponse checkUrlJIra(String baseUrl) {
        UrlResponse urlResponse = new UrlResponse();
        boolean isReachable = isURLReachable(baseUrl);

        System.out.println("Is URL reachable? " + isReachable);
        String urlStatus;
        if (isReachable){
            urlStatus = "up";
            urlResponse.setHttpStatus(HttpStatus.OK);
        } else {
            urlStatus = "down";
            urlResponse.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        urlResponse.setUrlStatus(urlStatus);
        return urlResponse;
    }

    public boolean isURLReachable(String url){
        try {
            ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
            return responseEntity.getStatusCode().is2xxSuccessful();
        } catch (Exception e) {
            log.info("Error: ", e);
            return false;
        }
    }

}
