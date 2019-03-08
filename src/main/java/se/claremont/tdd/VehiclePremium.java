package se.claremont.tdd;

public class VehiclePremium {

    private String licensePlate;
    private int insurancePremium;

    public String getLicensePlate() {
        return licensePlate;
    }

    public VehiclePremium setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
        return this;
    }

    public int getInsurancePremium() {
        return insurancePremium;
    }

    public VehiclePremium setInsurancePremium(int insurancePremium) {
        this.insurancePremium = insurancePremium;
        return this;
    }
}
