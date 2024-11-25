package controller;

import Model.*;
import Util.*;

import javax.persistence.*;
import java.util.*;

public class SorveteController {

    public void salvarSorvete(Sorvete sorvete) {
        EntityManager em = HibernateUtil.getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.merge(sorvete);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) transaction.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public Sorvete buscarSorvetePorId(Long id) {
        EntityManager em = HibernateUtil.getEntityManager();
        try {
            return em.find(Sorvete.class, id);
        } finally {
            em.close();
        }
    }

    public List<Sorvete> listarTodosSorvetes() {
        EntityManager em = HibernateUtil.getEntityManager();
        try {
            return em.createQuery("from tb_sorvete", Sorvete.class).getResultList();
        } finally {
            em.close();
        }
    }

    public void deletarSorvete(Long id) {
        EntityManager em = HibernateUtil.getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            Sorvete sorvete = em.find(Sorvete.class, id);
            if (sorvete != null) {
                em.remove(sorvete);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) transaction.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}
