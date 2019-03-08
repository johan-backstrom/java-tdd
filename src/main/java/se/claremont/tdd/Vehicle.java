package se.claremont.tdd;

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

    public int calculatePrice(){

        // Initial reduction requirement
        int price = newPrice * 9 / 10;

        // Age requirement
        double reduction = Math.pow(
                (double)8/10,
                2019 - yearOfManufacturing
        );
        price = (int)(price * reduction);

        // Condition requirement
        switch(condition){
            case used:
                price -= 1000;
                break;
            case crap:
                price -= 2000;
                break;
        }

        // Brand requirement
        switch(make){
            case "Ferrari":
                price += 20000;
                break;
            case "Lamborghini":
                price += 10000;
                break;
        }

        // never less than 0
        price = price < 0 ? 0 : price;

        // Finished
        return price;
    }

    public VehiclePremium getPremium(){
        double premium = newPrice / 100;

        premium = premium * Math.pow(0.8, 2019 - yearOfManufacturing);

        if("Mercedes".equals(make)){
            premium += 500;
        }

        if(premium < 3000){
            premium = 3000;
        }

        VehiclePremium vp = new VehiclePremium();
        vp.setInsurancePremium((int)premium);
        vp.setLicensePlate(licensePlate);
        return vp;
    }

    public enum Condition{
        mint,
        used,
        crap
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public int getYearOfManufacturing() {
        return yearOfManufacturing;
    }

    public void setYearOfManufacturing(int yearOfManufacturing) {
        this.yearOfManufacturing = yearOfManufacturing;
    }

    public int getNewPrice() {
        return newPrice;
    }

    public void setNewPrice(int newPrice) {
        this.newPrice = newPrice;
    }

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }
}