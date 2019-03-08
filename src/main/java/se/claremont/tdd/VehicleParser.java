package se.claremont.tdd;

public class VehicleParser {

    public Vehicle createFromString(String vehicleText) {
        String[] values = vehicleText.split(";");
        return new Vehicle(
                values[1],
                Integer.valueOf(values[3]),
                Integer.valueOf(values[4]),
                Vehicle.Condition.valueOf(values[5]));
    }
}
