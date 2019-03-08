package se.claremont.tdd;

import org.junit.Assert;
import org.junit.Test;
import se.claremont.util.StringUtility;

public class StringUtilityTest {

    @Test
    public void cameCaseTest(){

        // Setup
        StringUtility myStringUtility = new StringUtility();
        String inputData = "Hej jag heter Johan";

        // Exekvering
        String camelCasedText = myStringUtility.camelCase(inputData);

        // Validering
        Assert.assertEquals(
                "HejJagHeterJohan",
                camelCasedText
        );
    }

    @Test
    public void reverseTest(){
        // Setup
        StringUtility myStringUtility = new StringUtility();
        String inputData = "Johan";

        // Exekvering
        String camelCasedText = myStringUtility.reverse(inputData);

        // Validering
        Assert.assertEquals(
                "nahoJ",
                camelCasedText
        );
    }

    @Test
    public void reverseTestNull(){
        // Setup
        StringUtility myStringUtility = new StringUtility();
        String inputData = "";

        // Exekvering
        String camelCasedText = myStringUtility.reverse(inputData);

        // Validering
        Assert.assertEquals(
                "",
                camelCasedText
        );
    }

}
