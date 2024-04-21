package Homework.src;
import org.junit.Assert;
import org.junit.Test;


public class assignment2GPTTest {
    public assignment2GPTTest() {
    }

    @Test
    public void testIsQuantityValid() {

        Assert.assertTrue(Assignment2_20220808025.isQuantityValid(5));
        Assert.assertFalse(Assignment2_20220808025.isQuantityValid(-1));
        Assert.assertFalse(Assignment2_20220808025.isQuantityValid(0));
    }

    @Test
    public void testIsWeightValid() {
        Assert.assertTrue(Assignment2_20220808025.isWeightValid(20, 20));
        Assert.assertFalse(Assignment2_20220808025.isWeightValid(-20, 20));
        Assert.assertFalse(Assignment2_20220808025.isWeightValid(-20, 150));
    }

    @Test
    public void testGradeLetter() {
        Assert.assertEquals("AA", Assignment2_20220808025.gradeLetter(95.5));
        Assert.assertEquals("BA", Assignment2_20220808025.gradeLetter(85.0));
        Assert.assertEquals("FD", Assignment2_20220808025.gradeLetter(36.5));
    }

    @Test
    public void testGpaPoints() {
        Assert.assertEquals(4.0, Assignment2_20220808025.gpaPoints(95.5), 0.001);
        Assert.assertEquals(3.0, Assignment2_20220808025.gpaPoints(78.0), 0.001);
        Assert.assertEquals(0.0, Assignment2_20220808025.gpaPoints(25.5), 0.001);
    }

    @Test
    public void testStatus() {
        Assert.assertEquals("passed", Assignment2_20220808025.status(95.0));
        Assert.assertEquals("conditionally passed", Assignment2_20220808025.status(50.1));
        Assert.assertEquals("failed", Assignment2_20220808025.status(23.0));
    }
}
