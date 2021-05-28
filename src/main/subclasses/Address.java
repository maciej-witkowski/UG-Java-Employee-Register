package main.subclasses;

public class Address {
    private final String street;
    private final Integer buildingNumber;
    private final Integer apartmentNumber;
    private final String city;

    public Address(String street, Integer buildingNumber, Integer apartmentNumber, String city) {
        this.street = street;
        this.buildingNumber = buildingNumber;
        this.apartmentNumber = apartmentNumber;
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public Integer getBuildingNumber() {
        return buildingNumber;
    }

    public Integer getApartmentNumber() {
        return apartmentNumber;
    }

    public String getCity() {
        return city;
    }
}
