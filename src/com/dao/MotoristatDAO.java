/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.bean.Motoristat;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author thiago.napoleao
 */
public class MotoristatDAO {
  
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
    
    
    public void insert(Motoristat motoristat) {
        EntityManager entityManager = getEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(motoristat);
            entityManager.getTransaction().commit();
        }catch(Exception e) {
            entityManager.getTransaction().rollback();
        }finally {
            entityManager.close();
        }
    }
    
    
    public void remove(Motoristat motoristat) {
        EntityManager entityManager = getEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(motoristat);
            entityManager.getTransaction().commit();
        }catch(Exception e) {
            entityManager.getTransaction().rollback();
        }finally{
            entityManager.close();
        }
    }
    
    
       public List<Motoristat> findAll() { //este metodo retorna todos os registros da tabela
        try {
            EntityManager entityManager = getEntityManager();
            Query query = entityManager.createQuery("SELECT e FROM Motoristat e");// em  SELECT e FROM Motorista e  "Motorista" precisa representar o mesmo nome da classe
            List<Motoristat> motoristas = query.getResultList();
            entityManager.close();
            return motoristas;
        }catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public Motoristat findById(int id) {
        EntityManager entityManager = getEntityManager();
        Motoristat motoristat = null;
        try {
            motoristat = entityManager.find(Motoristat.class, id);
        }finally {
            entityManager.close();
        }
        
        return motoristat;
    }
    
    public Motoristat update(Motoristat motoristat) {
        EntityManager entityManager = getEntityManager();
        try {
            entityManager.getTransaction().begin();
            motoristat= entityManager.merge(motoristat);
            entityManager.getTransaction().commit();
        }catch(Exception e) {
            entityManager.getTransaction().rollback();
        }finally{
            entityManager.close();
        }
        return motoristat;
    }
    
     public List<Motoristat> findByCodigo(String codigo) {
        try {
            EntityManager entityManager = getEntityManager();
            Query query = entityManager.createQuery("from Motoristat e where e.codigo = :codigo");
            query.setParameter("codigo", codigo);
            List<Motoristat> motoristats = query.getResultList();
            entityManager.close();
            return motoristats;
        }catch(Exception e) {
            System.out.println("erro");
            e.printStackTrace();
            return null;
        }
    }

  public List<Motoristat> findByCpf(String cpf) {
        try {
            EntityManager entityManager = getEntityManager();
            Query query = entityManager.createQuery("from Motoristat e where e.cpf = :cpf");
            query.setParameter("cpf", cpf);
            List<Motoristat> motoristas = query.getResultList();
            entityManager.close();
            return motoristas;
        }catch(Exception e) {
            System.out.println("erro");
            e.printStackTrace();
            return null;
        }
    }

   public List<Motoristat> findByPlaca(String placa) {
        try {
            EntityManager entityManager = getEntityManager();
            Query query = entityManager.createQuery("from Motoristat e where e.placa = :placa");
            query.setParameter("placa", placa);
            List<Motoristat> motoristas = query.getResultList();
            entityManager.close();
            return motoristas;
        }catch(Exception e) {
            System.out.println("erro");
            e.printStackTrace();
            return null;
        }
    }
   
    }

  
    
    


