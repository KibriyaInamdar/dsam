package de.uniba.dsg.jaxrs.model;

import java.util.List;

public class Beverage {
    private List<Bottle> bottleList;
    private List<Crate> crateList;

    public Beverage(){}

    public List<Bottle> getBottleList() {
        return bottleList;
    }

    public void setBottleList(List<Bottle> bottleList) {
        this.bottleList = bottleList;
    }

    public List<Crate> getCrateList() {
        return crateList;
    }

    public void setCrateList(List<Crate> crateList) {
        this.crateList = crateList;
    }
}
