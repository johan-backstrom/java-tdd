package se.claremont.tdd;

import se.claremont.util.FileReadingUtility;

public class FileProcessor {

    PremiumPersister premiumPersister;
    VehicleParser vehicleParser;

    public FileProcessor setPremiumPersister(PremiumPersister premiumPersister) {
        this.premiumPersister = premiumPersister;
        return this;
    }

    public FileProcessor setVehicleParser(VehicleParser vehicleParser) {
        this.vehicleParser = vehicleParser;
        return this;
    }

    public void processFile(String file){
        FileReadingUtility.readFileLinesFromResources(file)
                .stream()
                .map(vehicleString -> vehicleParser.createFromString(vehicleString))
                .map(vehicle -> vehicle.getPremium())
                .forEach(premium -> premiumPersister.writeToDatabase(premium));
    }
}
