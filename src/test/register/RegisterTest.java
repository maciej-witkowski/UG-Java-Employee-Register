package test.register;

import main.employees.ManualEmployee;
import main.employees.OfficeEmployee;
import main.employees.Tradesman;
import main.register.Register;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.Arrays;

public class RegisterTest {
    private Register register;
    private ManualEmployee manual;
    private OfficeEmployee office;
    private Tradesman tradesman;

    @Before
    public void setUp() throws Exception {
        manual = new ManualEmployee(
                "Maciej",
                "Witkowski",
                21,
                "Zimna",
                2,
                7,
                "Gdańsk",
                75

        );
        office = new OfficeEmployee(
                "Jan",
                "Wilk",
                18,
                "Junior Java Developer",
                3,
                "Chłodna",
                1,
                21,
                "Opole",
                128

        );

        tradesman = new Tradesman(
                "Adam",
                "Nowak",
                52,
                "Junior Java Developer",
                50,
                "Lipna",
                21,
                37,
                "Opole",
                "WYSOKA",
                48
        );
        register = new Register(manual, office, tradesman);
    }

    @Test
    public void testGetRegister() {
        Assertions.assertEquals(3, register.getRegister().size());
    }

    @Test
    public void testAddEmployee() {
        register.addEmployee(office);

        Assertions.assertEquals(4, register.getRegister().size());
    }

    @Test
    public void testAddEmployees() {
        register.addEmployees(tradesman, manual);

        Assertions.assertEquals(5, register.getRegister().size());
    }

    @Test
    public void testRemoveEmployee() {
        register.removeEmployee(office.getId());

        Assertions.assertEquals(2, register.getRegister().size());
    }

    @Test
    public void testSortedDisplay() throws Exception {
        Tradesman nowaczyk_2yearsExp_30yearsOld = new Tradesman(
                "Adam",
                "Nowaczyk",
                30,
                "Junior Java Developer",
                24,
                "Lipna",
                21,
                37,
                "Opole",
                "WYSOKA",
                48
        );

        Tradesman graczyk_2yearsExp_26yearsOld = new Tradesman(
                "Adam",
                "Graczyk",
                26,
                "Junior Java Developer",
                24,
                "Lipna",
                21,
                37,
                "Warszawa",
                "WYSOKA",
                48
        );

        Tradesman adamek_2yearsExp_26yearsOld = new Tradesman(
                "Adam",
                "Adamek",
                26,
                "Junior Java Developer",
                24,
                "Lipna",
                21,
                37,
                "Opole",
                "WYSOKA",
                48
        );

        register.getRegister().add(graczyk_2yearsExp_26yearsOld);
        register.getRegister().add(nowaczyk_2yearsExp_30yearsOld);
        register.getRegister().add(adamek_2yearsExp_26yearsOld);

        Assertions.assertEquals(new ArrayList<>(Arrays.asList(
            adamek_2yearsExp_26yearsOld,
                graczyk_2yearsExp_26yearsOld,
                nowaczyk_2yearsExp_30yearsOld,
                tradesman,
                office,
                manual
        )), register.display());
    }

    @Test
    public void testDisplayByCity() {
        Assertions.assertEquals(2, register.displayByCity("Opole").size());
    }
}
