package test.employees;

import main.employees.ManualEmployee;
import main.subclasses.Address;
import main.subclasses.Experience;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class ManualEmployeeTest {
    private ManualEmployee employeeExperienced;
    private ManualEmployee employeeNotExperienced;

    @Before
    public void setUp() throws Exception {
        employeeExperienced = new ManualEmployee(
                "Jan",
                "Kowalski",
                48,
                "Magazynier",
                112,
                "Chłodna",
                21,
                37,
                "Gdańsk",
                80
        );
        employeeNotExperienced = new ManualEmployee(
                "Adam",
                "Nowak",
                48,
                "Zimna",
                1,
                3,
                "Bydgoszcz",
                58
        );
    }

    @Test
    public void testPhysicalStrengthException() {
        Exception thrown = Assertions.assertThrows(
                Exception.class,
                () -> new ManualEmployee(
                        "Jan",
                        "Kowalski",
                        48,
                        "Magazynier",
                        112,
                        "Chłodna",
                        21,
                        37,
                        "Gdańsk",
                        150
                ),
                "Value of physical strength must be between 1 and 100"
        );

        Assertions.assertEquals(thrown.getMessage(), "Value of physical strength must be between 1 and 100");
    }

    @Test
    public void testGetId() {
        Assertions.assertTrue(employeeExperienced.getId().matches("([a-f0-9]{8}(-[a-f0-9]{4}){4}[a-f0-9]{8})"));
    }

    @Test
    public void testGetFirstName() {
        Assertions.assertEquals("Jan", employeeExperienced.getFirstName());
    }

    @Test
    public void testGetLastName() {
        Assertions.assertEquals("Kowalski", employeeExperienced.getLastName());
    }

    @Test
    public void testGetAge() {
        Assertions.assertEquals(48, employeeExperienced.getAge());
    }

    @Test
    public void testGetExperience() {
        Assertions.assertTrue(employeeExperienced.getExperience() instanceof Experience);
    }

    @Test
    public void testIfExperienceNotMentionedPosition() {
        Assertions.assertNull(employeeNotExperienced.getExperience().getPosition());
    }

    @Test
    public void testIfExperienceNotMentionedYearsOfExperience() {
        Assertions.assertEquals(0, employeeNotExperienced.getExperience().getYearsOfExperience());
    }

    @Test
    public void testGetAddress() {
        Assertions.assertTrue(employeeExperienced.getAddress() instanceof Address);
    }

    @Test
    public void testGetPhysicalStrength() {
        Assertions.assertEquals(80, employeeExperienced.getPhysicalStrength());
    }

    @Test
    public void testValueExperienced() {
        Assertions.assertEquals(15.55, employeeExperienced.value());
    }

    @Test
    public void testValueNotExperienced() {
        Assertions.assertEquals(0, employeeNotExperienced.value());
    }

    @Test
    public void testToStringExperienced() {
        Assertions.assertEquals(
                "Numer ID => "+ employeeExperienced.getId() +
                "\nImię i nazwisko => Jan Kowalski" +
                "\nWiek => 48" +
                "\nDoświadczenie:" +
                    "\n\tStanowisko => Magazynier" +
                    "\n\tOkres (lata) => 9.33" +
                "\nAdres miejsca pracy: " +
                "\n\tUlica => Chłodna" +
                "\n\tNumer budynku => 21" +
                "\n\tNumer lokalu => 37" +
                "\n\tMiasto => Gdańsk" +
                "\nSiła fizyczna => 80" +
                "\nWartość dla korporacji => 15.55" ,
                employeeExperienced.toString()
        );
    }
}
