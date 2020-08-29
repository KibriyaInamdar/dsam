package de.uniba.dsg.jaxrs.model.dto;

import de.uniba.dsg.jaxrs.model.Crate;

import javax.xml.bind.annotation.*;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "crate")
@XmlType(propOrder = {"id", "bottle", "noOfBottles","price","inStock"})
public class CrateDTO {
    private int id;
    @XmlElement(required = true)
    private BottleDTO bottle;
    private int noOfBottles;
    private double price;
    private int inStock;

    public CrateDTO(){}

    public CrateDTO(Crate crate){
        this.id=crate.getId();
        this.bottle=BottleDTO.marshall(crate.getBottle());
        this.noOfBottles=crate.getNoOfBottles();
        this.price=crate.getPrice();
        this.inStock=crate.getInStock();
    }

    public static CrateDTO marshall(final Crate crate) {
        return new CrateDTO(crate);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BottleDTO getBottle() {
        return bottle;
    }

    public void setBottle(BottleDTO bottle) {
        this.bottle = bottle;
    }

    public int getNoOfBottles() {
        return noOfBottles;
    }

    public void setNoOfBottles(int noOfBottles) {
        this.noOfBottles = noOfBottles;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getInStock() {
        return inStock;
    }

    public void setInStock(int inStock) {
        this.inStock = inStock;
    }


    public static List<CrateDTO> marshallPagination(final List<Crate> crateList) {
        final ArrayList<CrateDTO> crates = new ArrayList<>();
        for (final Crate crate : crateList) {
            crates.add(new CrateDTO(crate));
        }
        return crates;
    }
}
