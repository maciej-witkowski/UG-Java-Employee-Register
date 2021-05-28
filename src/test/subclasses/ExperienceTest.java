package test.subclasses;

import main.subclasses.Experience;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class ExperienceTest {
    private Experience experience;

    @Before
    public void setUp() throws Exception {
        experience = new Experience("Grafik komputerowy", 30);
    }

    @Test
    public void testMonthsOfExperienceException() {
        Exception thrown = Assertions.assertThrows(
                Exception.class,
                () -> new Experience("Grafik komputerowy", -6),
                "Value of months cannot be less than 0"
        );

        Assertions.assertEquals(thrown.getMessage(), "Value of months cannot be less than 0");
    }

    @Test
    public void testGetPosition() {
        Assertions.assertEquals("Grafik komputerowy", experience.getPosition());
    }

    @Test
    public void testGetYearsOfExperience() {
        Assertions.assertEquals(2.5, experience.getYearsOfExperience());
    }
}
