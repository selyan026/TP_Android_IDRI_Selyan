package iut.dam.powerhome;

import java.io.Serializable;

public class Appliance implements Serializable {
    private int id;
    private String name;
    private String reference;
    private int wattage;

    public Appliance(int id, String name, String reference, int wattage) {
        this.id = id;
        this.name = name;
        this.reference = reference;
        this.wattage = wattage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public int getWattage() {
        return wattage;
    }

    public void setWattage(int wattage) {
        this.wattage = wattage;
    }
}
