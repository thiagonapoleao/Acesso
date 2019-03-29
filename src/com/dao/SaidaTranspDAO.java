/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.bean.SaidaTransp;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author thiago.napoleao
 */
public class SaidaTranspDAO{
    
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
    
    
    public void insert(SaidaTransp saidatransp) {
        EntityManager entityManager = getEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(saidatransp);
            entityManager.getTransaction().commit();
        }catch(Exception e) {
            entityManager.getTransaction().rollback();
        }finally {
            entityManager.close();
        }
    }
    
    
    public void remove(SaidaTransp saidatransp) {
        EntityManager entityManager = getEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(saidatransp);
            entityManager.getTransaction().commit();
        }catch(Exception e) {
            entityManager.getTransaction().rollback();
        }finally{
            entityManager.close();
        }
    }
    
    
    public List<SaidaTransp> findAll() {
        try {
            EntityManager entityManager = getEntityManager();
            Query query = entityManager.createQuery("SELECT e FROM SaidaTransp e");
            List<SaidaTransp> saidatransp = query.getResultList();
            entityManager.close();
            return saidatransp;
        }catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    
    public List<SaidaTransp> findByData(String data) {
        try {
            EntityManager entityManager = getEntityManager();
            Query query = entityManager.createQuery("from SaidaTransp e where e.data = :data");
            query.setParameter("data", data);
            List<SaidaTransp> entrada_transportadora = query.getResultList();
            entityManager.close();
            return entrada_transportadora;
        }catch(Exception e) {
            System.out.println("erro");
            e.printStackTrace();
            return null;
        }
    }
    
    
    public SaidaTransp update(SaidaTransp erro) {
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
