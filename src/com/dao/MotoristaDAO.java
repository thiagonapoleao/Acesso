/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.bean.Motorista;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author thiago.napoleao
 * 
 */
public class MotoristaDAO {
  
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
    
    
    public void insert(Motorista motorista) {
        EntityManager entityManager = getEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(motorista);
            entityManager.getTransaction().commit();
        }catch(Exception e) {
            entityManager.getTransaction().rollback();
        }finally {
            entityManager.close();
        }
    }
    
    
    public void remove(Motorista motorista) {
        EntityManager entityManager = getEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(motorista);
            entityManager.getTransaction().commit();
        }catch(Exception e) {
            entityManager.getTransaction().rollback();
        }finally{
            entityManager.close();
        }
    }
    
    
    public List<Motorista> findAll() { //este metodo retorna todos os registros da tabela
        try {
            EntityManager entityManager = getEntityManager();
            Query query = entityManager.createQuery("SELECT e FROM Motorista e");// em  SELECT e FROM Motorista e  "Motorista" precisa representar o mesmo nome da classe
            List<Motorista> motoristas = query.getResultList();
            entityManager.close();
            return motoristas;
        }catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public Motorista findById(int id) {
        EntityManager entityManager = getEntityManager();
        Motorista motorista = null;
        try {
            motorista = entityManager.find(Motorista.class, id);
        }finally {
            entityManager.close();
        }
        
        return motorista;
    }
    
    public Motorista update(Motorista motorista) {
        EntityManager entityManager = getEntityManager();
        try {
            entityManager.getTransaction().begin();
            motorista= entityManager.merge(motorista);
            entityManager.getTransaction().commit();
        }catch(Exception e) {
            entityManager.getTransaction().rollback();
        }finally{
            entityManager.close();
        }
        return motorista;
    }
    
    public List<Motorista> findByCodigo(int codigo) {
        try {
            EntityManager entityManager = getEntityManager();
            Query query = entityManager.createQuery("from Motorista e where e.codigo = :codigo");
            query.setParameter("codigo", codigo);
            List<Motorista> motoristas = query.getResultList();
            entityManager.close();
            return motoristas;
        }catch(Exception e) {
            System.out.println("erro");
            e.printStackTrace();
            return null;
        }
    }
    
    
    public List<Motorista> findByCpf(String cpf) {
        try {
            EntityManager entityManager = getEntityManager();
            Query query = entityManager.createQuery("from Motorista e where e.cpf = :cpf");
            query.setParameter("cpf", cpf);
            List<Motorista> motoristas = query.getResultList();
            entityManager.close();
            return motoristas;
        }catch(Exception e) {
            System.out.println("erro");
            e.printStackTrace();
            return null;
        }
    }

  
    
    
}
