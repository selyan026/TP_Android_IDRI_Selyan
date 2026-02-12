package iut.dam.powerhome;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Habitat implements Serializable {
    private int id;
    private String residentName;
    private int floor;
    private double area;
    private List<Appliance> appliances;

    public Habitat(int id, String residentName, int floor, double area) {
        this.id = id;
        this.residentName = residentName;
        this.floor = floor;
        this.area = area;
        this.appliances = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getResidentName() {
        return residentName;
    }

    public void setResidentName(String residentName) {
        this.residentName = residentName;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public List<Appliance> getAppliances() {
        return appliances;
    }

    public void setAppliances(List<Appliance> appliances) {
        this.appliances = appliances;
    }

    public void addAppliance(Appliance appliance) {
        this.appliances.add(appliance);
    }

    public int getApplianceCount() {
        return appliances.size();
    }
}
