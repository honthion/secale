package com.ibeesaas.ribbon_test.web;

import com.ibeesaas.ribbon_test.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.HashMap;

@RestController
@RequestMapping(value = "/get")
public class GetController {
    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "/m11", method = RequestMethod.GET)
    public Object getM11() {
        return restTemplate.getForEntity("http://HELLO-SERVICE/user?name={name}", User.class, "honthion").getBody();
    }

    @RequestMapping(value = "/m12", method = RequestMethod.GET)
    public Object getM12() {
        HashMap<String, String> map = new HashMap<>();
        map.put("name", "honthion");
        return restTemplate.getForEntity("http://HELLO-SERVICE/user?name={name}", User.class, map).getBody();
    }

    @RequestMapping(value = "/m13", method = RequestMethod.GET)
    public Object getM13() {
        UriComponents uriComponents = UriComponentsBuilder.fromUriString("http://HELLO-SERVICE/user?name={name}").build().expand(" honthion").encode();
        URI uri = uriComponents.toUri();
        return restTemplate.getForEntity(uri, User.class).getBody();
    }


    @RequestMapping(value = "/m23", method = RequestMethod.GET)
    public Object getM23() {
        UriComponents uriComponents = UriComponentsBuilder.fromUriString("http://HELLO-SERVICE/user?name={name}").build().expand(" honthion").encode();
        URI uri = uriComponents.toUri();
        return restTemplate.getForObject(uri, User.class);
    }
}

  
