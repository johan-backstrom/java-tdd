package se.claremont.tdd;

import org.junit.Assert;
import org.junit.Test;

public class VehicleParserTest {

    VehicleParser vp = new VehicleParser();

    @Test
    public void parseTest() {
        String vehicle = "HEF934;Volvo;v70;2014;395000;used";
        Assert.assertEquals(
                395000,
                vp.createFromString(vehicle).getNewPrice()
        );
    }
}
