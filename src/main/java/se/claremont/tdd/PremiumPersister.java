package se.claremont.tdd;

import se.claremont.util.DatabaseClient;

public class PremiumPersister {

    DatabaseClient dbClient;

    public PremiumPersister setDbClient(DatabaseClient dbClient) {
        this.dbClient = dbClient;
        return this;
    }

    public void writeToDatabase(VehiclePremium v){
        dbClient.executeStatement(
                "INSERT INTO InsurancePremium VALUES ('" + v.getLicensePlate() + "', " + String.valueOf(v.getInsurancePremium()) + ");"
        );
    }

}
