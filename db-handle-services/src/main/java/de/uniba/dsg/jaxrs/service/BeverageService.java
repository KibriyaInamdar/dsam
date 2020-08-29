package de.uniba.dsg.jaxrs.service;

import de.uniba.dsg.jaxrs.db.DB;
import de.uniba.dsg.jaxrs.model.Beverage;
import de.uniba.dsg.jaxrs.model.Bottle;
import de.uniba.dsg.jaxrs.model.Crate;

import java.util.List;
import java.util.concurrent.Semaphore;

public class BeverageService {
    private static final Semaphore sem = new Semaphore(1);
    public static  BeverageService instance ;

    private final DB db;

    public BeverageService() {
        this.db=new DB();
    }

    public static BeverageService getInstance() {
        {
            try {
                sem.acquireUninterruptibly();
                if (BeverageService.instance == null) {
                    BeverageService.instance = new BeverageService();
                }
            } finally {
                sem.release();
            }
            return BeverageService.instance;
        }
    }

    public List<Bottle> getAllBottles(){
        return this.db.getAllBottles();
    }

    public List<Crate> getAllCrates(){
        return this.db.getAllCrates();
    }

    public Beverage getAllBeverages(){
        Beverage beverage = new Beverage();
        beverage.setBottleList(getAllBottles());
        beverage.setCrateList(getAllCrates());
        return beverage;
    }

    public Bottle addBottle(Bottle bottle) {
        return this.db.addBottle(bottle);
    }

    public Crate addCrate(Crate crate) {
        return this.db.addCrate(crate);
    }

    public Bottle getBottle( int id){
        return this.db.getBottle(id);
    }
    public Crate getCrate(final int id){
        return this.db.getCrate(id);
    }

    public Bottle updateBottle(int id, Bottle bottle) {
        return this.db.updateBottle(id,bottle);
    }

    public Crate updateCrate(int id, Crate crate) {
        return this.db.updateCrate(id,crate);
    }

    public boolean deleteBottle(int id) {
        return this.db.deleteBottle(id);
    }

    public boolean deleteCrate(int id) {
        return this.db.deleteCrate(id);
    }
}
