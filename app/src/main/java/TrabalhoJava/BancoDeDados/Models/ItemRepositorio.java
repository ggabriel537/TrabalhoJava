package TrabalhoJava.BancoDeDados.Models;

import TrabalhoJava.Entidades.Item;

import javax.persistence.*;
import java.util.List;

public class ItemRepositorio {

    public static void salvar(Item item) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(item);
        tx.commit();
        em.close();
    }

    public static List<Item> listar() {
        EntityManager em = JPAUtil.getEntityManager();
        List<Item> items = em.createQuery("SELECT i FROM item i", Item.class).getResultList();
        em.close();
        return items;
    }

    public void deletar(int id) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Item item = em.find(Item.class, id);
        if (item != null) {
            em.remove(item);
        }
        tx.commit();
        em.close();
    }

    public void atualizar(Item item) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.merge(item);
        tx.commit();
        em.close();
    }
}
