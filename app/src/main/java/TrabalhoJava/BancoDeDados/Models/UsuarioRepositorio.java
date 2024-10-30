package TrabalhoJava.BancoDeDados.Models;

import TrabalhoJava.Entidades.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import java.util.List;

public class UsuarioRepositorio {

    public void salvar(Usuario usuario) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(usuario);
        tx.commit();
        em.close();
    }

    public List<Usuario> listar() {
        EntityManager em = JPAUtil.getEntityManager();
        List<Usuario> usuarios = em.createQuery("SELECT u FROM Usuario u", Usuario.class).getResultList();
        em.close();
        return usuarios;
    }

    public void deletar(String username) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Usuario usuario = em.find(Usuario.class, username);
        if (usuario != null) {
            em.remove(usuario);
        }
        tx.commit();
        em.close();
    }

    public void atualizar(Usuario usuario) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.merge(usuario);
        tx.commit();
        em.close();
    }
}
