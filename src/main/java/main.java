import entity.*;
import DAO.*;

import java.time.LocalDate;

public class main {

    public static void main(String[] args) {

        Customer customer = new Customer("Jaska", "Jokunen");
        BasicProfile profile = new BasicProfile(2000, 75, 180);
        customer.setBasicProfile(profile);
        Clinic clinic = new Clinic("Helsinki");
        CustomerDAO customerdao = new CustomerDAO();
        ClinicDAO clinicdao = new ClinicDAO();
        clinicdao.addClinic(clinic);
        customerdao.addCustomer(customer);
        customerdao.addCustomerToClinic(customer, clinic);


        Customer customer2 = new Customer("Matti", "Meikäläinen");
        BasicProfile profile2 = new BasicProfile(1990, 70, 178);
        customer2.setBasicProfile(profile2);
        customerdao.addCustomer(customer2);
        Clinic clinic2 = new Clinic("Espoo");
        clinicdao.addClinic(clinic2);
        customerdao.addCustomerToClinic(customer2, clinic2);
        customerdao.addCustomerToClinic(customer2, clinic);

        ContractCustomer contractCustomer = new ContractCustomer("Teppo", "Testaaja", LocalDate.now().plusMonths(6));
        BasicProfile profile3 = new BasicProfile(1985, 85, 185);
        contractCustomer.setBasicProfile(profile3);
        customerdao.addCustomer(contractCustomer);
        customerdao.addCustomerToClinic(contractCustomer, clinic);


    }
}
