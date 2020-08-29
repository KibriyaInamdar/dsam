
package de.uniba.dsg.jaxrs.controller;

        import de.uniba.dsg.jaxrs.model.Beverage;
        import de.uniba.dsg.jaxrs.model.Bottle;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RestController;
        import org.springframework.web.client.RestTemplate;


        import java.util.Collections;
        import java.util.List;
        import java.util.logging.Logger;

//@Path("bottles"
@RestController
public class BeverageResource {
    private static final Logger logger = Logger.getLogger("BeverageResource");

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/beverage")
    public Beverage getBeverages() {

    System.out.println("http://db-handle-service/getbeverage/beverage/");
        Beverage beverage = restTemplate.getForObject("http://db-handle-service/getbeverage/beverage/", Beverage.class);

        return beverage;
    }

}
