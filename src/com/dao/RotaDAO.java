/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;


import com.bean.Rota;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author thiago.napoleao
 */
public class RotaDAO {
    
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
    
    
    public void insert(Rota rota) {
        EntityManager entityManager = getEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(rota);
            entityManager.getTransaction().commit();
        }catch(Exception e) {
            entityManager.getTransaction().rollback();
        }finally {
            entityManager.close();
        }
    }
    
    
    public void remove(Rota rota) {
        EntityManager entityManager = getEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(rota);
            entityManager.getTransaction().commit();
        }catch(Exception e) {
            entityManager.getTransaction().rollback();
        }finally{
            entityManager.close();
        }
    }
    
    
     public List<Rota> findAll() { //este metodo retorna todos os registros da tabela
        try {
            EntityManager entityManager = getEntityManager();
            Query query = entityManager.createQuery("SELECT e FROM Rota e");// em  SELECT e FROM Rota e  "Rota" precisa representar o mesmo nome da classe
            List<Rota> rotas = query.getResultList();
            entityManager.close();
            return rotas;
        }catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public Rota findById(int id) {
        EntityManager entityManager = getEntityManager();
        Rota rota = null;
        try {
            rota = entityManager.find(Rota.class, id);
        }finally {
            entityManager.close();
        }
        
        return rota;
    }
    
    public Rota update(Rota rota) {
        EntityManager entityManager = getEntityManager();
        try {
            entityManager.getTransaction().begin();
            rota= entityManager.merge(rota);
            entityManager.getTransaction().commit();
        }catch(Exception e) {
            entityManager.getTransaction().rollback();
        }finally{
            entityManager.close();
        }
        return rota;
    }
    
    public List<Rota> findByCodigo(int codigo) {
        try {
            EntityManager entityManager = getEntityManager();
            Query query = entityManager.createQuery("from Rota e where e.codigo = :codigo");
            query.setParameter("codigo", codigo);
            List<Rota> rotas = query.getResultList();
            entityManager.close();
            return rotas;
        }catch(Exception e) {
            System.out.println("erro");
            e.printStackTrace();
            return null;
        }
    }

  

    
}
