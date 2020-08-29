package de.uniba.dsg.jaxrs.controller;

import de.uniba.dsg.jaxrs.model.Beverage;
import de.uniba.dsg.jaxrs.model.Bottle;
import de.uniba.dsg.jaxrs.model.Crate;
import de.uniba.dsg.jaxrs.service.BeverageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("getbeverage")
public class GetBeverages {

    private static final Logger logger = Logger.getLogger("getBeverages");

    @GetMapping("beverage")
    public Beverage getAllBottles() {
        System.out.println("Get all beverages from DB");
        return BeverageService.getInstance().getAllBeverages();
    }
}
