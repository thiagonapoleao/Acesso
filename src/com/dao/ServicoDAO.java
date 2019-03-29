/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;



import com.bean.Servico;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author thiago.napoleao
 */
public class ServicoDAO {
    
    
     private EntityManager getEntityManager() {
        EntityManagerFactory factory = null;
        EntityManager entityManager = null;
        
        try {
            factory = Persistence.createEntityManagerFactory("TratativaPU");
            entityManager = factory.createEntityManager();
        }catch(Exception e) {
            e.printStackTrace();
        }
        
        return entityManager;
    }
    
    
    public void insert(Servico servico) {
        EntityManager entityManager = getEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(servico);
            entityManager.getTransaction().commit();
        }catch(Exception e) {
            entityManager.getTransaction().rollback();
        }finally {
            entityManager.close();
        }
    }
    
    
    public void remove(Servico servico) {
        EntityManager entityManager = getEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(servico);
            entityManager.getTransaction().commit();
        }catch(Exception e) {
            entityManager.getTransaction().rollback();
        }finally{
            entityManager.close();
        }
    }
    
    
    public List<Servico> findAll() {
        try {
            EntityManager entityManager = getEntityManager();
            Query query = entityManager.createQuery("SELECT e FROM Servico e");
            List<Servico> servico = query.getResultList();
            entityManager.close();
            return servico;
        }catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public List<Servico> findById(int id) {
        try {
            EntityManager entityManager = getEntityManager();
            Query query = entityManager.createQuery("from Servico e where e.id = :id");
            query.setParameter("id", id);
            List<Servico> servico = query.getResultList();
            entityManager.close();
            return servico;
        }catch(Exception e) {
            System.out.println("erro");
            e.printStackTrace();
            return null;
        }
    }
    
    
    public Servico update(Servico servico) {
        EntityManager entityManager = getEntityManager();
        try {
            entityManager.getTransaction().begin();
            servico= entityManager.merge(servico);
            entityManager.getTransaction().commit();
        }catch(Exception e) {
            entityManager.getTransaction().rollback();
        }finally{
            entityManager.close();
        }
        return servico;
    }

   public List<Servico> findByData(String data) {
        try {
            EntityManager entityManager = getEntityManager();
            Query query = entityManager.createQuery("from Servico e where e.data = :data");
            query.setParameter("data", data);
            List<Servico> servico = query.getResultList();
            entityManager.close();
            return servico;
        }catch(Exception e) {
            System.out.println("erro");
            e.printStackTrace();
            return null;
        }
    }
    
    

    
    
}
