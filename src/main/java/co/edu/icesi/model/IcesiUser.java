package co.edu.icesi.model;

import java.util.Objects;

public class IcesiUser {

    private String firstName;
    private String lastName;
    private long salary;
    private boolean active;
    private IcesiAddress address;


    public IcesiUser() {
    }

    public IcesiUser(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public IcesiUser(String firstName, String lastName, IcesiAddress address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public IcesiAddress getAddress() {
        return address;
    }

    public void setAddress(IcesiAddress address) {
        this.address = address;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IcesiUser icesiUser = (IcesiUser) o;
        return salary == icesiUser.salary && active == icesiUser.active && Objects.equals(firstName, icesiUser.firstName) && Objects.equals(lastName, icesiUser.lastName) && Objects.equals(address, icesiUser.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, salary, active, address);
    }
}
