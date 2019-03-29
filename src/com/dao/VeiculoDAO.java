/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;


import com.bean.Veiculo;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author thiago.napoleao
 */
public class VeiculoDAO {
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
    
    
    public void insert(Veiculo veiculo) {
        EntityManager entityManager = getEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(veiculo);
            entityManager.getTransaction().commit();
        }catch(Exception e) {
            entityManager.getTransaction().rollback();
        }finally {
            entityManager.close();
        }
    }
    
    
    public void remove(Veiculo veiculo) {
        EntityManager entityManager = getEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(veiculo);
            entityManager.getTransaction().commit();
        }catch(Exception e) {
            entityManager.getTransaction().rollback();
        }finally{
            entityManager.close();
        }
    }
    
    
   public List<Veiculo> findAll() { //este metodo retorna todos os registros da tabela
        try {
            EntityManager entityManager = getEntityManager();
            Query query = entityManager.createQuery("SELECT e FROM Veiculo e");// em  SELECT e FROM Rota e  "Rota" precisa representar o mesmo nome da classe
            List<Veiculo> veiculos = query.getResultList();
            entityManager.close();
            return veiculos;
        }catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public Veiculo findById(int id) {
        EntityManager entityManager = getEntityManager();
        Veiculo veiculo = null;
        try {
            veiculo = entityManager.find(Veiculo.class, id);
        }finally {
            entityManager.close();
        }
        
        return veiculo;
    }
    
    public Veiculo update(Veiculo veiculo) {
        EntityManager entityManager = getEntityManager();
        try {
            entityManager.getTransaction().begin();
            veiculo= entityManager.merge(veiculo);
            entityManager.getTransaction().commit();
        }catch(Exception e) {
            entityManager.getTransaction().rollback();
        }finally{
            entityManager.close();
        }
        return veiculo;
    }
    
      public List<Veiculo> findByCodigo(int codigo) {
        try {
            EntityManager entityManager = getEntityManager();
            Query query = entityManager.createQuery("from Veiculo e where e.codigo = :codigo");
            query.setParameter("codigo", codigo);
            List<Veiculo> veiculos = query.getResultList();
            entityManager.close();
            return veiculos;
        }catch(Exception e) {
            System.out.println("erro");
            e.printStackTrace();
            return null;
        }
    }

    
    
}
