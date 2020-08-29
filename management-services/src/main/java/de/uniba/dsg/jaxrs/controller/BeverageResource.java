package de.uniba.dsg.jaxrs.controller;

import de.uniba.dsg.jaxrs.model.Beverage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Logger;


@RestController
public class BeverageResource {
    private static final Logger logger = Logger.getLogger("BeverageResource");

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/beverage")
    public Beverage getBeverages() {
        Beverage beverage = restTemplate.getForObject("http://db-handle-service/beverage", Beverage.class);
        return beverage;
    }



}
