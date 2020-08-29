package de.uniba.dsg.jaxrs.controller;

import de.uniba.dsg.jaxrs.model.Bottle;
import de.uniba.dsg.jaxrs.model.Crate;
import de.uniba.dsg.jaxrs.service.BeverageService;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
@RequestMapping("updateBeverage")
public class UpdateBeverage {

    private static final Logger logger = Logger.getLogger("updateBeverage");

    @PutMapping("bottle/{bottle-id}")
    public Bottle updateBottle(@PathVariable("bottle-id") int id, @RequestBody Bottle bottle) {
        System.out.println("update bottle in DB");
        return BeverageService.instance.updateBottle(id, bottle);
    }

    @PutMapping("crate/{crate-id}")
    public Crate updateCrate(@PathVariable("crate-id") int id, @RequestBody Crate crate) {
        System.out.println("update crate in DB");
        return BeverageService.instance.updateCrate(id, crate);
    }
}
