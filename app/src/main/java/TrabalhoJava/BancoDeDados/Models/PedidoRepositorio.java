package TrabalhoJava.BancoDeDados.Models;

import TrabalhoJava.Entidades.Pedido;
import javax.persistence.*;
import java.util.List;

public class PedidoRepositorio {

    public void salvar(Pedido pedido) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(pedido);
        tx.commit();
        em.close();
    }

    public static List<Pedido> listar() {
        EntityManager em = JPAUtil.getEntityManager();
        List<Pedido> pedidos = em.createQuery("SELECT p FROM Pedido p", Pedido.class).getResultList();
        em.close();
        return pedidos;
    }

    public void deletar(int id) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Pedido pedido = em.find(Pedido.class, id);
        if (pedido != null) {
            em.remove(pedido);
        }
        tx.commit();
        em.close();
    }

    public void atualizar(Pedido pedido) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.merge(pedido);
        tx.commit();
        em.close();
    }
}
