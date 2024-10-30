package TrabalhoJava.BancoDeDados.Models;

import TrabalhoJava.Entidades.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import java.util.List;

public class PedidoRepositorio {

    public void salvar(Entidades.Pedido pedido) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(pedido);
        tx.commit();
        em.close();
    }

    public List<Entidades.Pedido> listar() {
        EntityManager em = JPAUtil.getEntityManager();
        List<Entidades.Pedido> pedidos = em.createQuery("SELECT p FROM Pedido p", Entidades.Pedido.class).getResultList();
        em.close();
        return pedidos;
    }

    public void deletar(int id) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Entidades.Pedido pedido = em.find(Entidades.Pedido.class, id);
        if (pedido != null) {
            em.remove(pedido);
        }
        tx.commit();
        em.close();
    }

    public void atualizar(Entidades.Pedido pedido) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.merge(pedido);
        tx.commit();
        em.close();
    }
}
