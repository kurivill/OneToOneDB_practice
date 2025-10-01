package entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Clinic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clinicId;
    private String location;

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(
        name = "clinic_customers",
        joinColumns = @JoinColumn(name = "clinicId"),
        inverseJoinColumns = @JoinColumn(name = "customerId")
    )
    private Set<Customer> customers = new HashSet<Customer>();

    public Clinic() {}

    public Clinic(String location) {
        this.location = location;
    }
    public Long getId() {
        return clinicId;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }

    public Set<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Set<Customer> customers) {
        this.customers = customers;
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
        customer.getClinics().add(this);
    }

    public void removeCustomer(Customer customer) {
        customers.remove(customer);
        customer.getClinics().remove(this);
    }

}
