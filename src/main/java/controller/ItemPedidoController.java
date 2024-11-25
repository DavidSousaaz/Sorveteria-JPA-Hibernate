package controller;

import Model.*;
import Util.*;

import javax.persistence.*;
import java.util.*;

public class ItemPedidoController {

    public void salvarItemPedido(ItemPedido itemPedido) {
        EntityManager em = HibernateUtil.getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.merge(itemPedido);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) transaction.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public ItemPedido buscarItemPedidoPorId(Long id) {
        EntityManager em = HibernateUtil.getEntityManager();
        try {
            return em.find(ItemPedido.class, id);
        } finally {
            em.close();
        }
    }

    public List<ItemPedido> listarTodosItensPedido() {
        EntityManager em = HibernateUtil.getEntityManager();
        try {
            return em.createQuery("from tb_itemPedido", ItemPedido.class).getResultList();
        } finally {
            em.close();
        }
    }

    public void deletarItemPedido(Long id) {
        EntityManager em = HibernateUtil.getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            ItemPedido itemPedido = em.find(ItemPedido.class, id);
            if (itemPedido != null) {
                em.remove(itemPedido);
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
