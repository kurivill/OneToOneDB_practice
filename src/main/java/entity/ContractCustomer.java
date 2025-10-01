package entity;

import jakarta.persistence.*;


import java.time.LocalDate;


@Entity
public class ContractCustomer extends Customer {

    private LocalDate startDate = LocalDate.now();
    private LocalDate endDate;

    public ContractCustomer() {}

    public ContractCustomer(String name, String lastName, LocalDate endDate) {
        super(name, lastName);
        this.endDate = endDate;
    }
}
