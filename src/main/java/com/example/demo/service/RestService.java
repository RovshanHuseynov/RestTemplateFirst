package com.example.demo.service;

import com.example.demo.model.Post;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Service
public class RestService {
    private final RestTemplate restTemplate;

    public RestService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    // GET Request
    public String getPostsPlainJSON(){
        System.out.println("go");
        String url = "https://jsonplaceholder.typicode.com/posts";
        return this.restTemplate.getForObject(url, String.class);
    }

    // Get Response as Object
    public Post[] getPostsAsObject(){
        String url = "https://jsonplaceholder.typicode.com/posts";
        return this.restTemplate.getForObject(url, Post[].class);
    }

    // URL Parameters
    public Post getPostWithUrlParameters(){
        String url = "https://jsonplaceholder.typicode.com/posts/{id}";
        return this.restTemplate.getForObject(url, Post.class, 1);
    }

    // Response Handing
    public Post getPostWithResponseHandling(){
        String url = "https://jsonplaceholder.typicode.com/posts/{id}";
        ResponseEntity<Post> response = this.restTemplate.getForEntity(url, Post.class, 1);

        if(response.getStatusCode() == HttpStatus.OK){
            return response.getBody();
        }
        else{
            return null;
        }
    }

    // Custom Request Headers
    public Post getPostWithCustomHeaders(){
        String url = "https://jsonplaceholder.typicode.com/posts/{id}";

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.set("x-request-source", "desktop");

        HttpEntity request = new HttpEntity(headers);
        ResponseEntity<Post> response = this.restTemplate.exchange(url, HttpMethod.GET, request, Post.class, 1);
        if(response.getStatusCode() == HttpStatus.OK){
            return response.getBody();
        }
        else{
            return null;
        }
    }


}
