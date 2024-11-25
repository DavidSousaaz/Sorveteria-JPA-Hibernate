package controller;

import Model.*;
import Util.*;

import javax.persistence.*;
import java.util.*;

public class ClienteController {

    public void salvarCliente(Cliente cliente) {
        EntityManager em = HibernateUtil.getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.merge(cliente);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) transaction.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public Cliente buscarClientePorNome(String nome) {
        EntityManager em = HibernateUtil.getEntityManager();
        try {
            return em.createQuery("SELECT c FROM tb_cliente c WHERE c.nome = :nome", Cliente.class)
                    .setParameter("nome", nome)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null; // Retorna null se nenhum resultado for encontrado
        } finally {
            em.close();
        }
    }

    public Cliente buscarClientePorId(Long id) {
        EntityManager em = HibernateUtil.getEntityManager();
        try {
            return em.find(Cliente.class, id);
        } finally {
            em.close();
        }
    }

    public List<Cliente> listarTodosClientes() {
        EntityManager em = HibernateUtil.getEntityManager();
        try {
            return em.createQuery("from tb_cliente", Cliente.class).getResultList();
        } finally {
            em.close();
        }
    }

    public void deletarCliente(Long id) {
        EntityManager em = HibernateUtil.getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            Cliente cliente = em.find(Cliente.class, id);
            if (cliente != null) {
                em.remove(cliente);
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
