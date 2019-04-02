package se.claremont.util;

import se.claremont.VehiclePremium;

import java.util.HashMap;
import java.util.Map;

public class DatabaseClient {

    private static Map<String, Integer> theFakeDatabase = new HashMap<>();

    public static void writeToDatabase(VehiclePremium v) {

        theFakeDatabase.put(v.getLicensePlate(), v.getInsurancePremium());

    }

    public static VehiclePremium readFromDatabase(String licensePlate) {

        if(!theFakeDatabase.containsKey(licensePlate)){
            throw new RuntimeException("Premium not found");
        }

        return new VehiclePremium()
                .setLicensePlate(licensePlate)
                .setInsurancePremium(theFakeDatabase.get(licensePlate));
    }
}
