package main;

import main.employees.ManualEmployee;
import main.employees.OfficeEmployee;
import main.employees.Tradesman;
import main.register.Register;

public class Main {
    public static void main(String[] args) throws Exception {
        Register register = new Register(
                new ManualEmployee(
                        "Maciej",
                        "Witkowski",
                        21,
                        "Zimna",
                        2,
                        7,
                        "Gdańsk",
                        75

                ),
                new OfficeEmployee(
                        "Jan",
                        "Wilk",
                        18,
                        "Junior Java Developer",
                        3,
                        "Chłodna",
                        1,
                        21,
                        "Bydgoszcz",
                        128

                ),
                new Tradesman(
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
                )
        );
        register.addEmployee(new Tradesman(
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
        ));
        register.addEmployee(new Tradesman(
                "Adam",
                "Graczyk",
                26,
                "Junior Java Developer",
                24,
                "Lipna",
                21,
                37,
                "Opole",
                "WYSOKA",
                48
        ));
        register.addEmployee(new Tradesman(
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
        ));

        register.display();
        register.displayByCity("Opole");
    }

}
