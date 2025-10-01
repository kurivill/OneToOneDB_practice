package entity;

import jakarta.persistence.*;

@Entity
public class ContractCustomer extends Customer {

    private String contractDetails;

    public ContractCustomer() {}

    public ContractCustomer(String name, String email, String contractDetails) {
        super(name, email);
        this.contractDetails = contractDetails;
    }

    public String getContractDetails() {
        return contractDetails;
    }

    public void setContractDetails(String contractDetails) {
        this.contractDetails = contractDetails;
    }
}
