package de.uniba.dsg.jaxrs.controller;

import de.uniba.dsg.jaxrs.model.Bottle;
import de.uniba.dsg.jaxrs.model.Crate;
import de.uniba.dsg.jaxrs.service.BeverageService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
@RequestMapping("deleteBeverage")
public class DeleteBeverage {

    private static final Logger logger = Logger.getLogger("updateBeverage");

    @DeleteMapping("bottle/{bottle-id}")
    public Boolean deleteBottle(@PathVariable("bottle-id") int id) {
        System.out.println("delete bottle from DB");
        return BeverageService.instance.deleteBottle(id);
    }

    @DeleteMapping("crate/{crate-id}")
    public Boolean deleteCrate(@PathVariable("crate-id") int id) {
        System.out.println("delete crate from DB");
        return BeverageService.instance.deleteCrate(id);
    }
}
