package de.uniba.dsg.jaxrs.controller;

import de.uniba.dsg.jaxrs.model.Beverage;
import de.uniba.dsg.jaxrs.model.Bottle;
import de.uniba.dsg.jaxrs.model.Crate;
import de.uniba.dsg.jaxrs.service.BeverageService;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
@RequestMapping("addbeverage")
public class AddBeverage {

    private static final Logger logger = Logger.getLogger("addBeverages");

    @PostMapping("bottle")
    public Bottle addBottle(@RequestBody Bottle bottle) {
        System.out.println("Get all bottles from DB");
        return BeverageService.instance.addBottle(bottle);
    }

    @PostMapping("crate")
    public Crate addCrate(@RequestBody Crate crate) {
        System.out.println("Get all bottles from DB");
        return BeverageService.instance.addCrate(crate);
    }
}
