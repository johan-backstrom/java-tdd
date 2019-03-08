package se.claremont.tdd;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import se.claremont.util.DatabaseClient;

public class DatabaseClientTest {

    private String connectionString = "jdbc:h2:mem:test;MODE=MYSQL;DB_CLOSE_DELAY=-1;DATABASE_TO_UPPER=false;";
    private DatabaseClient databaseClient = new DatabaseClient(connectionString, "sa", "");

    @Before
    public void setUpSchema() {
        databaseClient.executeStatement(
                "CREATE TABLE InsurancePremium(licensePlate char(6), insurancePremium int);"
        );
    }

    @After
    public void cleanup() {
        databaseClient.executeStatement(
                "DROP ALL OBJECTS;"
        );
    }

    @Test
    public void myFirstDBTest() {
        Assert.assertTrue(true);
    }

    @Test
    public void writeToDB() {

        VehiclePremium vp = new VehiclePremium();
        vp.setLicensePlate("ABC123");
        vp.setInsurancePremium(1500);
        databaseClient.executeStatement(
                "INSERT INTO InsurancePremium VALUES ('ABC123', 666);"
        );

        Assert.assertEquals(
                1,
                databaseClient.select(
                        "SELECT * FROM InsurancePremium",
                        VehiclePremium.class
                ).size()
        );
    }


}
