package com.aipo.url.controller;

import com.aipo.url.service.URLService;
import com.aipo.url.model.UrlResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class URLController {

    @Autowired
    URLService urlService;

    @GetMapping("/aipo/url-checking")
    public ResponseEntity<UrlResponse> checkURl(@RequestParam String url) {
        UrlResponse response = urlService.checkUrlJIra(url);
        return new ResponseEntity<>(response, response.getHttpStatus());
    }
}
