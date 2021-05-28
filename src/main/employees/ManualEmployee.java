package main.employees;

import main.interfaces.EmployeeValue;

final public class ManualEmployee extends Employee implements EmployeeValue {
    private final Integer physicalStrength;

    public ManualEmployee(
            String firstName,
            String lastName,
            Integer age,
            String position,
            Integer monthsOfExperience,
            String addressStreet,
            Integer addressBuildingNumber,
            Integer addressApartmentNumber,
            String addressCity,
            Integer physicalStrength
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
        if (physicalStrength < 1 || physicalStrength > 100) {
            throw new Exception("Value of physical strength must be between 1 and 100");
        }
        this.physicalStrength = physicalStrength;
    }

    public ManualEmployee(
            String firstName,
            String lastName,
            Integer age,
            String addressStreet,
            Integer addressBuildingNumber,
            Integer addressApartmentNumber,
            String addressCity,
            Integer physicalStrength
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
        if (physicalStrength < 1 || physicalStrength > 100) {
            throw new Exception("Value of physical strength must be between 1 and 100");
        }
        this.physicalStrength = physicalStrength;
    }

    public Integer getPhysicalStrength() {
        return physicalStrength;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nSiła fizyczna => " + physicalStrength +
                "\nWartość dla korporacji => " + value();
    }

    @Override
    public Double value() {
        double scale = Math.pow(10, 2);
        return Math.round((getExperience().getYearsOfExperience() * physicalStrength / getAge()) * scale) / scale;
    }
}
