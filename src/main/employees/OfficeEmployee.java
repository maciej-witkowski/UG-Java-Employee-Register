package main.employees;

import main.interfaces.EmployeeValue;

import java.util.UUID;

final public class OfficeEmployee extends Employee implements EmployeeValue {
    private final String officeId = UUID.randomUUID().toString();
    private final Integer intelligence;

    public OfficeEmployee(
            String firstName,
            String lastName,
            Integer age,
            String position,
            Integer monthsOfExperience,
            String addressStreet,
            Integer addressBuildingNumber,
            Integer addressApartmentNumber,
            String addressCity,
            Integer intelligence
    ) throws Exception {
        super(
            firstName,
            lastName,
            age,
            position,
            monthsOfExperience,
            addressStreet,
            addressBuildingNumber,
            addressApartmentNumber,
            addressCity
        );
        if (intelligence < 70 || intelligence > 150) {
            throw new Exception("Value of intelligence must be between 70 and 150");
        }
        this.intelligence = intelligence;
    }

    public OfficeEmployee(
            String firstName,
            String lastName,
            Integer age,
            String addressStreet,
            Integer addressBuildingNumber,
            Integer addressApartmentNumber,
            String addressCity,
            Integer intelligence
    ) throws Exception {
        super(
                firstName,
                lastName,
                age,
                addressStreet,
                addressBuildingNumber,
                addressApartmentNumber,
                addressCity
        );
        if (intelligence < 70 || intelligence > 150) {
            throw new Exception("Value of intelligence must be between 70 and 150");
        }
        this.intelligence = intelligence;
    }

    public String getOfficeId() {
        return officeId;
    }

    public Integer getIntelligence() {
        return intelligence;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nNumer stanowiska biurowego => " + officeId +
                "\nInteligencja => " + intelligence +
                "\nWartość dla korporacji => " + value();
    }

    @Override
    public Double value() {
        double scale = Math.pow(10, 2);
        return Math.round((getExperience().getYearsOfExperience() * intelligence) * scale) / scale;
    }
}
