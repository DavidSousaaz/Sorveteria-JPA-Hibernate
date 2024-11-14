import javax.persistence.EntityManager;

import Model.Cliente;
import Util.HibernateUtil;

public class TesteRegistroTabelaCliente {
    public static void main(String[] args) {
        EntityManager em = HibernateUtil.getEntityManager();

        try {
            em.getTransaction().begin();

            // Adicionando um cliente
            Cliente cliente = new Cliente();
            cliente.setNome("Pedrão do crack");
            cliente.setTelefone("1234-5678");
            cliente.setEmail("pedro@sorveteria.com");
            em.persist(cliente);

            em.getTransaction().commit();

            System.out.println("Cliente salvo com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
            HibernateUtil.close();
        }
    }
}
