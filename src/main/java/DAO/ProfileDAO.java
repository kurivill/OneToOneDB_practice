package DAO;

import jakarta.persistence.*;
import entity.BasicProfile;
import entity.Customer;

import util.creds_provider;

public class ProfileDAO {

    public void addProfile(BasicProfile profile) {
        EntityManager em = creds_provider.getEmf().createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(profile);
            em.getTransaction().commit();
            System.out.println("Profile added successfully");
        } finally {
            em.close();
        }
    }

    public void updateProfile(BasicProfile profile) {
        EntityManager em = creds_provider.getEmf().createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(profile);
            em.getTransaction().commit();
            System.out.println("Profile updated successfully");
        } finally {
            em.close();
        }
    }

    public BasicProfile getProfile(Long id) {
        EntityManager em = creds_provider.getEmf().createEntityManager();
        try {
            return em.find(BasicProfile.class, id);
        } finally {
            em.close();
        }
    }

    public void deleteProfile(Long id) {
        EntityManager em = creds_provider.getEmf().createEntityManager();
        try {
            em.getTransaction().begin();
            BasicProfile profile = em.find(BasicProfile.class, id);
            if (profile != null) {
                em.remove(profile);
                System.out.println("Profile deleted successfully");
            }
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }


}
