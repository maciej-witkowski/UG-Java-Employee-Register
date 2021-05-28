package test.employees;

import main.employees.Tradesman;
import main.subclasses.Address;
import main.subclasses.Effectiveness;
import main.subclasses.Experience;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class TradesmanTest {
    private Tradesman employeeExperienced;
    private Tradesman employeeNotExperienced;

    @Before
    public void setUp() throws Exception {
        employeeExperienced = new Tradesman(
                "Jan",
                "Kowalski",
                48,
                "Asystent sprzedaży",
                112,
                "Chłodna",
                21,
                37,
                "Gdańsk",
                "WYSOKA",
                35
        );
        employeeNotExperienced = new Tradesman(
                "Adam",
                "Nowak",
                48,
                "Zimna",
                1,
                3,
                "Bydgoszcz",
                "NISKA",
                18
        );
    }

    @Test
    public void testProvisionAmountException() {
        Exception thrown = Assertions.assertThrows(
                Exception.class,
                () -> new Tradesman(
                        "Jan",
                        "Kowalski",
                        48,
                        "Asystent sprzedaży",
                        112,
                        "Chłodna",
                        21,
                        37,
                        "Gdańsk",
                        "ŚREDNIA",
                        -58
                ),
                "Value of provision amount must be between 0 and 100"
        );

        Assertions.assertEquals(thrown.getMessage(), "Value of provision amount must be between 0 and 100");
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
    public void testGetEffectiveness() { Assertions.assertTrue(employeeExperienced.getEffectiveness() instanceof Effectiveness); }

    @Test
    public void testGetProvisionAmount() {
        Assertions.assertEquals(35, employeeExperienced.getProvisionAmount());
    }

    @Test
    public void testValueExperienced() {
        Assertions.assertEquals(1119.6, employeeExperienced.value());
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
                        "\n\tStanowisko => Asystent sprzedaży" +
                        "\n\tOkres (lata) => 9.33" +
                        "\nAdres miejsca pracy: " +
                        "\n\tUlica => Chłodna" +
                        "\n\tNumer budynku => 21" +
                        "\n\tNumer lokalu => 37" +
                        "\n\tMiasto => Gdańsk" +
                        "\nSkuteczność => WYSOKA" +
                        "\nWysokość prowizji => 35%" +
                        "\nWartość dla korporacji => 1119.6" ,
                employeeExperienced.toString()
        );
    }
}
