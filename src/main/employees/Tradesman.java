package main.employees;

import main.interfaces.EmployeeValue;
import main.subclasses.Effectiveness;

final public class Tradesman extends Employee implements EmployeeValue {
    private final Effectiveness effectiveness;
    private final Integer provisionAmount;

    public Tradesman(
            String firstName,
            String lastName,
            Integer age,
            String position,
            Integer monthsOfExperience,
            String addressStreet,
            Integer addressBuildingNumber,
            Integer addressApartmentNumber,
            String addressCity,
            String effectiveness,
            Integer provisionAmount
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
        if (provisionAmount < 0 || provisionAmount > 100) {
            throw new Exception("Value of provision amount must be between 0 and 100");
        }
        this.effectiveness = new Effectiveness(effectiveness);
        this.provisionAmount = provisionAmount;
    }

    public Tradesman(
            String firstName,
            String lastName,
            Integer age,
            String addressStreet,
            Integer addressBuildingNumber,
            Integer addressApartmentNumber,
            String addressCity,
            String effectiveness,
            Integer provisionAmount
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
        if (provisionAmount < 0 || provisionAmount > 100) {
            throw new Exception("Value of provision amount must be between 0 and 100");
        }
        this.effectiveness = new Effectiveness(effectiveness);
        this.provisionAmount = provisionAmount;
    }

    public Effectiveness getEffectiveness() {
        return effectiveness;
    }

    public Integer getProvisionAmount() {
        return provisionAmount;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nSkuteczność => " + effectiveness.getEffectiveness() +
                "\nWysokość prowizji => " + provisionAmount + "%" +
                "\nWartość dla korporacji => " + value();
    }

    @Override
    public Double value() {
        double scale = Math.pow(10, 2);
        return Math.round((getExperience().getYearsOfExperience() * effectiveness.getValue()) * scale) / scale;
    }
}
