package entity;

import jakarta.persistence.*;


@Entity
@Table(name="profiles")
public class BasicProfile {

    @Id
    private long customerId;

    private int birthYear;
    private int weightInKg;
    private int heightInCm;

    @OneToOne
    @MapsId
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public BasicProfile() {}

    public BasicProfile(int birthYear, int weightInKg, int heightInCm) {
        this.birthYear = birthYear;
        this.weightInKg = weightInKg;
        this.heightInCm = heightInCm;
    }

    public long getProfileId() {
        return customerId;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public int getWeightInKg() {
        return weightInKg;
    }

    public void setWeightInKg(int weightInKg) {
        this.weightInKg = weightInKg;
    }

    public int getHeightInCm() {
        return heightInCm;
    }

    public void setHeightInCm(int heightInCm) {
        this.heightInCm = heightInCm;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
        if (customer != null && customer.getBasicProfile() != this) {
            customer.setBasicProfile(this);
        }
    }
}
