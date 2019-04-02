package se.claremont;

import org.junit.Assert;
import org.junit.Test;
import se.claremont.util.FileReadingUtility;

public class FileReadingUtilityTest {

    @Test
    public void readFile() {

        Assert.assertEquals(
                2,
                FileReadingUtility.readFileLinesFromResources("cars.txt").size()

        );
    }
}
