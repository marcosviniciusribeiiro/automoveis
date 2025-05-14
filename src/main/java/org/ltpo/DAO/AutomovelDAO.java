package org.ltpo.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import org.ltpo.models.Automovel;

import java.util.List;

public class AutomovelDAO {
    private EntityManagerFactory emf;
    private EntityManager em;

    public AutomovelDAO(){
        emf = Persistence.createEntityManagerFactory("automovelPU");
        em = emf.createEntityManager();
    }

    //Método para salvar um novo automovel
    public void salvar(Automovel automovel) {
        try {
            em.getTransaction().begin();
            em.persist(automovel);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        }
    }
    //Método para buscar todos os automoveis
    public List<Automovel> buscarTodos(){
        return  em.createQuery("SELECT a FROM Automovel a", Automovel.class).getResultList();
    }
    //Método para buscar automovel por ID
    public Automovel buscarPorId(int id){
        return em.find(Automovel.class, id);
    }

    //Fechar conexão com o banco
    public void fechar(){
        em.close();
        emf.close();
    }
}
