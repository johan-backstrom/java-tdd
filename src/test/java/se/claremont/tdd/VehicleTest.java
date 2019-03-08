package se.claremont.tdd;

import org.junit.Assert;
import org.junit.Test;

public class VehicleTest {

    @Test
    public void carIsWorth90PercentOfNewPrice() {

        Vehicle myVehicle = new Vehicle(
                "Volvo",
                2019,
                100000,
                Vehicle.Condition.mint
        );

        Assert.assertEquals(
                90000,
                myVehicle.calculatePrice()
        );
    }

    @Test
    public void carDecreases20percentInValueEachYear() {

        Vehicle myVehicle = new Vehicle(
                "Volvo",
                2018,
                100000,
                Vehicle.Condition.mint
        );

        Assert.assertEquals(
                72000,
                myVehicle.calculatePrice()
        );
    }

    @Test
    public void carDecreases20percentInValueEachYearWithTwoYears() {

        Vehicle myVehicle = new Vehicle(
                "Volvo",
                2017,
                100000,
                Vehicle.Condition.mint
        );

        Assert.assertEquals(
                57600,
                myVehicle.calculatePrice()
        );

    }

    @Test
    public void carInUsedConditionDecreases1000InValue() {

        Vehicle myVehicle = new Vehicle(
                "Volvo",
                2019,
                100000,
                Vehicle.Condition.used
        );

        Assert.assertEquals(
                89000,
                myVehicle.calculatePrice()
        );

    }

    @Test
    public void carInCrapdConditionDecreases2000InValue() {

        Vehicle myVehicle = new Vehicle(
                "Volvo",
                2019,
                100000,
                Vehicle.Condition.crap
        );

        Assert.assertEquals(
                88000,
                myVehicle.calculatePrice()
        );
    }

    @Test
    public void ferrariIncreases20000InValue() {

        Vehicle myVehicle = new Vehicle(
                "Ferrari",
                2019,
                100000,
                Vehicle.Condition.mint
        );

        Assert.assertEquals(
                110000,
                myVehicle.calculatePrice()
        );

    }

    @Test
    public void lamboIncreases10000InValue() {

        Vehicle myVehicle = new Vehicle(
                "Lamborghini",
                2019,
                100000,
                Vehicle.Condition.mint
        );

        Assert.assertEquals(
                100000,
                myVehicle.calculatePrice()
        );

    }

    @Test
    public void carIsNeverWorthLessThan0() {

        Vehicle myVehicle = new Vehicle(
                "Volvo",
                2019,
                1000,
                Vehicle.Condition.crap
        );

        Assert.assertEquals(
                0,
                myVehicle.calculatePrice()
        );

    }

    @Test
    public void premiumForvolvo() {
        Vehicle v = new Vehicle(
                "volvo",
                2019,
                400000,
                Vehicle.Condition.crap);

        Assert.assertEquals(
                4000,
                v.getPremium().getInsurancePremium()
        );
    }

    @Test
    public void decreasesEachYear(){
        Vehicle v = new Vehicle(
                "volvo",
                2018,
                400000,
                Vehicle.Condition.crap);

        Assert.assertEquals(
                3200,
                v.getPremium().getInsurancePremium()
        );
    }

    @Test
    public void mercedesTest(){
        Vehicle v = new Vehicle(
                "Mercedes",
                2019,
                400000,
                Vehicle.Condition.mint);

        Assert.assertEquals(
                4500,
                v.getPremium().getInsurancePremium()
        );
    }

    @Test
    public void priceIsNeverUnder3000(){
        Vehicle v = new Vehicle(
                "Volvo",
                2019,
                1000,
                Vehicle.Condition.mint);

        Assert.assertEquals(
                3000,
                v.getPremium().getInsurancePremium()
        );
    }

}
