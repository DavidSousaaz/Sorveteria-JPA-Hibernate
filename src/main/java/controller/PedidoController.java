package controller;

import Model.*;
import Util.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class PedidoController {

    public void salvarPedido(Pedido pedido) {
        EntityManager em = HibernateUtil.getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.merge(pedido); // merge substitui saveOrUpdate
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) transaction.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public Pedido buscarPedidoPorId(Long id) {
        EntityManager em = HibernateUtil.getEntityManager();
        try {
            // Usando JOIN FETCH para garantir que os itens sejam carregados com o pedido
            return em.createQuery("SELECT p FROM tb_pedido p LEFT JOIN FETCH p.itens WHERE p.id = :id", Pedido.class)
                    .setParameter("id", id)
                    .getSingleResult(); // Para garantir que um único resultado seja retornado
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            em.close();
        }
    }

    public List<Pedido> listarTodosPedidos() {
        EntityManager em = HibernateUtil.getEntityManager();
        try {
            return em.createQuery("from tb_pedido", Pedido.class).getResultList();
        } finally {
            em.close();
        }
    }

    public void deletarPedido(Long id) {
        EntityManager em = HibernateUtil.getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            Pedido pedido = em.find(Pedido.class, id);
            if (pedido != null) {
                em.remove(pedido);
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
