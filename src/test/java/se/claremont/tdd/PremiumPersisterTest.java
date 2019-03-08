package se.claremont.tdd;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import se.claremont.util.DatabaseClient;

import static org.mockito.ArgumentMatchers.matches;

public class PremiumPersisterTest {

    PremiumPersister pp = new PremiumPersister();
    DatabaseClient dbClient = Mockito.mock(DatabaseClient.class);

    @Before
    public void setup() {
        pp.setDbClient(dbClient);
    }

    @Test
    public void premiumPersisterTest() {
        pp.writeToDatabase(
                new VehiclePremium()
                        .setInsurancePremium(1500)
                        .setLicensePlate("ABC123")
        );

        Mockito.verify(
                dbClient,
                Mockito.times(1)
        ).executeStatement(matches("INSERT INTO.*"));
    }
}
