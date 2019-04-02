package se.claremont;

import org.junit.Assert;
import org.junit.Test;
import se.claremont.util.DatabaseClient;

public class DatabaseClientTest {

    @Test
    public void getDataFromDatabase(){
        VehiclePremium vp = new VehiclePremium();
        vp.setLicensePlate("ABC123");
        vp.setInsurancePremium(666);

        DatabaseClient.writeToDatabase(vp);

        Assert.assertEquals(
                666,
                DatabaseClient.readFromDatabase("ABC123").getInsurancePremium()
        );

    }
}
