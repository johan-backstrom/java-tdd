package se.claremont;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DatabaseClientTest {

    private String connectionString = "jdbc:h2:mem:test;MODE=MYSQL;DB_CLOSE_DELAY=-1;DATABASE_TO_UPPER=false;";
    private DatabaseClient databaseClient = new DatabaseClient(connectionString, "sa", "");

    @Before
    public void setUpSchema(){
        databaseClient.executeStatement(
                "CREATE TABLE InsurancePremium(licensePlate char(6), insurancePremium int);"
        );
    }

    @After
    public void cleanup(){
        databaseClient.executeStatement(
                "DROP ALL OBJECTS;"
        );
    }

    @Test
    public void myFirstDBTest(){
        Assert.assertTrue(true);
    }
}
