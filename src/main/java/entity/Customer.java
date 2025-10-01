package entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;
    private String firstName;
    private String lastName;
    @OneToOne(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    // Poistaa profiilin, jos se irrotetaan asiakkaasta.
    private BasicProfile basicProfile;

    @ManyToMany(mappedBy = "customers", cascade = CascadeType.MERGE)
    private Set<Clinic> clinics = new HashSet<>();

    public Customer() {}

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Long getId() {
        return customerId;
    }

    public String getName() {
        return firstName;
    }

    public void setName(String name) {
        this.firstName = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public BasicProfile getBasicProfile() {
        return basicProfile;
    }

    public void setBasicProfile(BasicProfile basicProfile) {
        this.basicProfile = basicProfile;
        if (basicProfile != null) {
            basicProfile.setCustomer(this);
        }
    }

    public void addClinic(Clinic clinic) {
        clinics.add(clinic);
        clinic.getCustomers().add(this);
    }

    public void removeClinic(Clinic clinic) {
        clinics.remove(clinic);
        clinic.getCustomers().remove(this);
    }

    public Set<Clinic> getClinics() {
        return clinics;
    }

    public void setClinics(Set<Clinic> clinics) {
        this.clinics = clinics;
    }

}
