package main.employees;

import main.subclasses.Address;
import main.subclasses.Experience;

import java.util.UUID;

abstract public class Employee {
    private final String id = UUID.randomUUID().toString();
    private final String firstName;
    private final String lastName;
    private final Integer age;
    private final Experience experience;
    private final Address address;

    public Employee(
        String firstName,
        String lastName,
        Integer age,
        String position,
        Integer monthsOfExperience,
        String addressStreet,
        Integer addressBuildingNumber,
        Integer addressApartmentNumber,
        String addressCity
    ) throws Exception {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.experience = new Experience(position, monthsOfExperience);
        this.address = new Address(addressStreet, addressBuildingNumber, addressApartmentNumber, addressCity);
    }

    public Employee(
            String firstName,
            String lastName,
            Integer age,
            String addressStreet,
            Integer addressBuildingNumber,
            Integer addressApartmentNumber,
            String addressCity
    ) throws Exception {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.experience = new Experience(null, 0);
        this.address = new Address(addressStreet, addressBuildingNumber, addressApartmentNumber, addressCity);
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getAge() {
        return age;
    }

    public Experience getExperience() {
        return experience;
    }

    public Address getAddress() {
        return address;
    }

    public String toString() {
        return "Numer ID => " + id +
                "\nImię i nazwisko => " + firstName + ' ' + lastName +
                "\nWiek => " + age +
                "\nDoświadczenie" + (experience.getYearsOfExperience() > 0 ?
                        ":\n\tStanowisko => " + experience.getPosition() +
                        "\n\tOkres (lata) => " + experience.getYearsOfExperience() :
                        " => Brak") +
                "\nAdres miejsca pracy: " +
                    "\n\tUlica => " + address.getStreet() +
                    "\n\tNumer budynku => " + address.getBuildingNumber() +
                    "\n\tNumer lokalu => " + address.getApartmentNumber() +
                    "\n\tMiasto => " + address.getCity();
    }
}
