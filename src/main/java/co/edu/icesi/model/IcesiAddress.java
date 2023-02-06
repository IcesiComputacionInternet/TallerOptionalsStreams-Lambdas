package co.edu.icesi.model;

import java.util.Objects;

public class IcesiAddress {

    private String street;
    private String number;
    private String description;

    public IcesiAddress(String street, String number) {
        this.street = street;
        this.number = number;
    }

    public IcesiAddress() {
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IcesiAddress that = (IcesiAddress) o;
        return Objects.equals(street, that.street) && Objects.equals(number, that.number) && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(street, number, description);
    }
}
