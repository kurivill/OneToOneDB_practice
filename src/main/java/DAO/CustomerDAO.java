package DAO;

import entity.Clinic;
import jakarta.persistence.*;

import util.creds_provider;
import entity.Customer;

public class CustomerDAO {

    public void addCustomer(Customer customer) {
        EntityManager em = creds_provider.getEmf().createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(customer);
            em.getTransaction().commit();
            System.out.println("Customer added successfully");
        } finally {
            em.close();
        }
    }

    public Customer getCustomer(Long id) {
        EntityManager em = creds_provider.getEmf().createEntityManager();
        try {
            return em.find(Customer.class, id);
        } finally {
            em.close();
        }
    }

    public void updateCustomer(Customer customer) {
        EntityManager em = creds_provider.getEmf().createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(customer);
            em.getTransaction().commit();
            System.out.println("Customer updated successfully");
        } finally {
            em.close();
        }
    }

    public void deleteCustomer(Long id) {
        EntityManager em = creds_provider.getEmf().createEntityManager();
        try {
            em.getTransaction().begin();
            Customer customer = em.find(Customer.class, id);
            if (customer != null) {
                em.remove(customer);
                System.out.println("Customer deleted successfully");
            }
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public void addCustomerToClinic(Customer customer, Clinic clinic) {
        EntityManager em = creds_provider.getEmf().createEntityManager();
        try {
            em.getTransaction().begin();
            customer = em.merge(customer);
            clinic = em.merge(clinic);
            clinic.getCustomers().add(customer);
            customer.getClinics().add(clinic);
            em.getTransaction().commit();
            System.out.println("Customer added to clinic successfully");
        } finally {
            em.close();
        }
    }

    public void removeCustomerFromClinic(Customer customer, Clinic clinic) {
        EntityManager em = creds_provider.getEmf().createEntityManager();
        try {
            em.getTransaction().begin();
            customer = em.merge(customer);
            clinic = em.merge(clinic);
            clinic.removeCustomer(customer);
            em.getTransaction().commit();
            System.out.println("Customer removed from clinic successfully");
        } finally {
            em.close();
        }
    }
}
