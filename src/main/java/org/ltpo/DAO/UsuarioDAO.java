package org.ltpo.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.ltpo.models.Usuario;

import java.util.List;

public class UsuarioDAO {

    private EntityManagerFactory emf;
    private EntityManager em;

    public UsuarioDAO(){
        emf = Persistence.createEntityManagerFactory("usuarioPU");
        em = emf.createEntityManager();
    }

    //Método para salvar um novo Usuario
    public void salvar(Usuario usuario) {
        try {
            em.getTransaction().begin();
            em.persist(usuario);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        }
    }

    //Método para buscar todos os Usuarios
    public List<Usuario> buscarTodos(){
        return em.createQuery("SELECT u FROM Usuario u", Usuario.class).getResultList();
    }
    
    //Método para buscar Usuario por ID
    public  Usuario buscarPorId(int id){
        return em.find(Usuario.class, id);
    }

    //Fechar conexão com o banco
    public void fechar(){
        em.close();
        emf.close();
    }
}
