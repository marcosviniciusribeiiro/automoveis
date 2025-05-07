package org.ltpo.DAO;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.ltpo.models.Modelo;

import java.util.List;


public class ModeloDAO {

        private EntityManagerFactory emf;
        private EntityManager em;

        public ModeloDAO(){
            emf = Persistence.createEntityManagerFactory("modelPU");
            em = emf.createEntityManager();
        }

        //Método para salvar um novo usuário
        public void salvar(Modelo modelo) {
            try {

                em.getTransaction().begin();
                em.persist(modelo);
                em.getTransaction().commit();
            } catch (Exception e) {
                if (em.getTransaction().isActive()) {
                    em.getTransaction().rollback();
                }
            }
        }


    //Método para buscar todos os usuários
    public List<Modelo> buscarTodos(){
        return em.createQuery("SELECT m FROM Modelo m", Modelo.class).getResultList();
    }


        //Método para buscar usuário por ID
        public  Modelo buscarPorId(int id){
            return em.find(Modelo.class, id);
        }

        //Fechar conexão com o banco
        public void fechar(){
            em.close();
            emf.close();
        }
    }

