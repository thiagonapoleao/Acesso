/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.bean.SaidTransp;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author thiago.napoleao
 */
public class SaidTranspDAO {
    
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
    
    
    public void insert(SaidTransp saidtransp) {
        EntityManager entityManager = getEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(saidtransp);
            entityManager.getTransaction().commit();
        }catch(Exception e) {
            entityManager.getTransaction().rollback();
        }finally {
            entityManager.close();
        }
    }
    
    
    public void remove(SaidTransp saidtransp) {
        EntityManager entityManager = getEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(saidtransp);
            entityManager.getTransaction().commit();
        }catch(Exception e) {
            entityManager.getTransaction().rollback();
        }finally{
            entityManager.close();
        }
    }
    
    
    public List<SaidTransp> findAll() {
        try {
            EntityManager entityManager = getEntityManager();
            Query query = entityManager.createQuery("SELECT e FROM SaidTransp e");
            List<SaidTransp> saidtransp = query.getResultList();
            entityManager.close();
            return saidtransp;
        }catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    
    public List<SaidTransp> findByData(String data) {
        try {
            EntityManager entityManager = getEntityManager();
            Query query = entityManager.createQuery("from SaidTransp e where e.data = :data");
            query.setParameter("data", data);
            List<SaidTransp> saida_transportadora = query.getResultList();
            entityManager.close();
            return saida_transportadora;
        }catch(Exception e) {
            System.out.println("erro");
            e.printStackTrace();
            return null;
        }
    }
    
    
    public SaidTransp update(SaidTransp erro) {
        EntityManager entityManager = getEntityManager();
        try {
            entityManager.getTransaction().begin();
            erro = entityManager.merge(erro);
            entityManager.getTransaction().commit();
        }catch(Exception e) {
            entityManager.getTransaction().rollback();
        }finally{
            entityManager.close();
        }
        return erro;
    }
    

}
