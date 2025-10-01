import entity.*;
import DAO.*;

public class main {

    public static void main(String[] args) {

        Customer customer = new Customer("Jaska", "Jokunen");
        Clinic clinic = new Clinic("Helsinki");
        CustomerDAO customerdao = new CustomerDAO();
        ClinicDAO clinicdao = new ClinicDAO();
        clinicdao.addClinic(clinic);
        customerdao.addCustomer(customer);
        customerdao.addCustomerToClinic(customer, clinic);

        BasicProfile profile = new BasicProfile(2000, 75, 180, customer);

        ProfileDAO profileDAO = new ProfileDAO();

        profileDAO.addProfile(profile);

        Customer customer2 = new Customer("Matti", "Meikäläinen");
        customerdao.addCustomer(customer2);
        Clinic clinic2 = new Clinic("Espoo");
        clinicdao.addClinic(clinic2);
        customerdao.addCustomerToClinic(customer2, clinic2);
        customerdao.addCustomerToClinic(customer2, clinic);

        BasicProfile profile2 = new BasicProfile(1990, 70, 178, customer2);

        profileDAO.addProfile(profile2);

    }
}
