/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.bean.Transportadora;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author thiago.napoleao
 */
public class TransportadoraDAO {
    
    
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
    
    
    public void insert(Transportadora transportadora) {
        EntityManager entityManager = getEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(transportadora);
            entityManager.getTransaction().commit();
        }catch(Exception e) {
            entityManager.getTransaction().rollback();
        }finally {
            entityManager.close();
        }
    }
    
    
    public void remove(Transportadora transportadora) {
        EntityManager entityManager = getEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(transportadora);
            entityManager.getTransaction().commit();
        }catch(Exception e) {
            entityManager.getTransaction().rollback();
        }finally{
            entityManager.close();
        }
    }
    
    
    public List<Transportadora> findAll() {
        try {
            EntityManager entityManager = getEntityManager();
            Query query = entityManager.createQuery("SELECT e FROM Transportadora e");
            List<Transportadora> transportadora = query.getResultList();
            entityManager.close();
            return transportadora;
        }catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    
    
    public Transportadora update(Transportadora transportadora) {
        EntityManager entityManager = getEntityManager();
        try {
            entityManager.getTransaction().begin();
            transportadora= entityManager.merge(transportadora);
            entityManager.getTransaction().commit();
        }catch(Exception e) {
            entityManager.getTransaction().rollback();
        }finally{
            entityManager.close();
        }
        return transportadora;
    }

   public List<Transportadora> findByData(String data) {
        try {
            EntityManager entityManager = getEntityManager();
            Query query = entityManager.createQuery("from Transportadora e where e.data = :data");
            query.setParameter("data", data);
            List<Transportadora> transportadora = query.getResultList();
            entityManager.close();
            return transportadora;
        }catch(Exception e) {
            System.out.println("erro");
            e.printStackTrace();
            return null;
        }
    }
    
    public List<Transportadora> findByCodigo(int codigo) {
        try {
            EntityManager entityManager = getEntityManager();
            Query query = entityManager.createQuery("from Transportadora e where e.codigo = :codigo");
            query.setParameter("codigo", codigo);
            List<Transportadora> transportadoras = query.getResultList();
            entityManager.close();
            return transportadoras;
        }catch(Exception e) {
            System.out.println("erro");
            e.printStackTrace();
            return null;
        }
    }
    
 public List<Transportadora> findByPlaca(String placa) {
        try {
            EntityManager entityManager = getEntityManager();
            Query query = entityManager.createQuery("from Transportadora e where e.placa = :placa");
            query.setParameter("placa", placa);
            List<Transportadora> transportadora = query.getResultList();
            entityManager.close();
            return transportadora;
        }catch(Exception e) {
            System.out.println("erro");
            e.printStackTrace();
            return null;
        }
    }
    
 
  public List<Transportadora> findById(int id) {
        try {
            EntityManager entityManager = getEntityManager();
            Query query = entityManager.createQuery("from Transportadora e where e.id = :id");
            query.setParameter("id", id);
            List<Transportadora> transportadoras = query.getResultList();
            entityManager.close();
            return transportadoras;
        }catch(Exception e) {
            System.out.println("erro");
            e.printStackTrace();
            return null;
        }
    }
    
}
