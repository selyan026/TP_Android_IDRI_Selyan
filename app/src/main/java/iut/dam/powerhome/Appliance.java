package iut.dam.powerhome;

import java.io.Serializable;

public class Appliance implements Serializable {
    private int id;
    private String name;
    private String reference;
    private int power;

    public Appliance(int id, String name, String reference, int power) {
        this.id = id;
        this.name = name;
        this.reference = reference;
        this.power = power;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getReference() {
        return reference;
    }

    public int getPower() {
        return power;
    }
}