package test.employees;

import main.employees.OfficeEmployee;
import main.subclasses.Address;
import main.subclasses.Experience;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class OfficeEmployeeTest {
    private OfficeEmployee employeeExperienced;
    private OfficeEmployee employeeNotExperienced;

    @Before
    public void setUp() throws Exception {
        employeeExperienced = new OfficeEmployee(
                "Jan",
                "Kowalski",
                48,
                "Księgowy",
                112,
                "Chłodna",
                21,
                37,
                "Gdańsk",
                137
        );
        employeeNotExperienced = new OfficeEmployee(
                "Adam",
                "Nowak",
                48,
                "Zimna",
                1,
                3,
                "Bydgoszcz",
                111
        );
    }

    @Test
    public void testIntelligenceException() {
        Exception thrown = Assertions.assertThrows(
                Exception.class,
                () -> new OfficeEmployee(
                        "Jan",
                        "Kowalski",
                        48,
                        "Księgowy",
                        112,
                        "Chłodna",
                        21,
                        37,
                        "Gdańsk",
                        59
                ),
                "Value of intelligence must be between 70 and 150"
        );

        Assertions.assertEquals(thrown.getMessage(), "Value of intelligence must be between 70 and 150");
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
    public void testGetOfficeId() {
        Assertions.assertTrue(employeeExperienced.getOfficeId().matches("([a-f0-9]{8}(-[a-f0-9]{4}){4}[a-f0-9]{8})"));
    }

    @Test
    public void testGetIntelligence() {
        Assertions.assertEquals(137, employeeExperienced.getIntelligence());
    }

    @Test
    public void testValueExperienced() {
        Assertions.assertEquals(1278.21, employeeExperienced.value());
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
                        "\n\tStanowisko => Księgowy" +
                        "\n\tOkres (lata) => 9.33" +
                        "\nAdres miejsca pracy: " +
                        "\n\tUlica => Chłodna" +
                        "\n\tNumer budynku => 21" +
                        "\n\tNumer lokalu => 37" +
                        "\n\tMiasto => Gdańsk" +
                        "\nNumer stanowiska biurowego => " + employeeExperienced.getOfficeId() +
                        "\nInteligencja => 137" +
                        "\nWartość dla korporacji => 1278.21" ,
                employeeExperienced.toString()
        );
    }
}
