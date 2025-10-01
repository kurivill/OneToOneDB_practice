package DAO;

import entity.Clinic;
import jakarta.persistence.*;

import util.creds_provider;


public class ClinicDAO {

    public void addClinic(Clinic clinic) {
        EntityManager em = creds_provider.getEmf().createEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(clinic);
            em.getTransaction().commit();
            System.out.println("Clinic added successfully");
        } finally {
            em.close();
        }
    }

    public void updateClinic(Clinic clinic) {
        EntityManager em = creds_provider.getEmf().createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(clinic);
            em.getTransaction().commit();
            System.out.println("Clinic updated successfully");
        } finally {
            em.close();
        }
    }

    public Clinic getClinic(Long id) {
        EntityManager em = creds_provider.getEmf().createEntityManager();
        try {
            return em.find(Clinic.class, id);
        } finally {
            em.close();
        }
    }

    public void deleteClinic(Long id) {
        EntityManager em = creds_provider.getEmf().createEntityManager();
        try {
            em.getTransaction().begin();
            Clinic clinic = em.find(Clinic.class, id);
            if (clinic != null) {
                em.remove(clinic);
                System.out.println("Clinic deleted successfully");
            }
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }


}
