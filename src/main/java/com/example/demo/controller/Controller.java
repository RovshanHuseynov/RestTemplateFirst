package com.example.demo.controller;

import com.example.demo.model.Post;
import com.example.demo.service.RestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    private final RestService restService;

    public Controller(@Autowired RestService restService) {
        this.restService = restService;
    }

    @RequestMapping("/get")
    public Post test(){
        return restService.getPostWithUrlParameters();
    }
}
