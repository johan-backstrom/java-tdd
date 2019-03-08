package se.claremont.tdd;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import se.claremont.util.DatabaseClient;

public class FileProcessorTest {

    private String connectionString = "jdbc:h2:mem:test;MODE=MYSQL;DB_CLOSE_DELAY=-1;DATABASE_TO_UPPER=false;";
    private DatabaseClient databaseClient = new DatabaseClient(connectionString, "sa", "");

    private FileProcessor fileProcessor = new FileProcessor();
    private PremiumPersister pp = new PremiumPersister();
    private VehicleParser vp = new VehicleParser();

    @Before
    public void setUpSchemaAndObjects() {

        databaseClient.executeStatement(
                "CREATE TABLE InsurancePremium(licensePlate char(6), insurancePremium int);"
        );

        pp.setDbClient(databaseClient);

        fileProcessor
                .setPremiumPersister(pp)
                .setVehicleParser(vp);

    }

    @After
    public void cleanup() {
        databaseClient.executeStatement(
                "DROP ALL OBJECTS;"
        );
    }

    @Test
    public void readFileProcessAndWriteToDB() {

        fileProcessor.processFile("cars.txt");

        Assert.assertEquals(
                2,
                databaseClient.select(
                        "SELECT * FROM InsurancePremium",
                        VehiclePremium.class
                ).size()
        );
    }

}
