package se.claremont;

public class Vehicle {

    private String make;
    private int yearOfManufacturing;
    private int newPrice;
    private Condition condition;
    private String licensePlate;

    public Vehicle(String make, int yearOfManufacturing, int newPrice, Condition condition){
        this.make = make;
        this.condition = condition;
        this.newPrice = newPrice;
        this.yearOfManufacturing = yearOfManufacturing;
    }

    public enum Condition{
        mint,
        used,
        crap
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public Vehicle setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
        return this;
    }

    public String getMake() {
        return make;
    }

    public Vehicle setMake(String make) {
        this.make = make;
        return this;
    }

    public int getYearOfManufacturing() {
        return yearOfManufacturing;
    }

    public Vehicle setYearOfManufacturing(int yearOfManufacturing) {
        this.yearOfManufacturing = yearOfManufacturing;
        return this;
    }

    public int getNewPrice() {
        return newPrice;
    }

    public Vehicle setNewPrice(int newPrice) {
        this.newPrice = newPrice;
        return this;
    }

    public Condition getCondition() {
        return condition;
    }

    public Vehicle setCondition(Condition condition) {
        this.condition = condition;
        return this;
    }
}