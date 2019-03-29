/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.bean.PrestadorServ;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author thiago.napoleao
 */
public class PrestadorServDAO {
    
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
    
    
    public void insert(PrestadorServ prestadorserv) {
        EntityManager entityManager = getEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(prestadorserv);
            entityManager.getTransaction().commit();
        }catch(Exception e) {
            entityManager.getTransaction().rollback();
        }finally {
            entityManager.close();
        }
    }
    
    
    public void remove(PrestadorServ prestadorserv) {
        EntityManager entityManager = getEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(prestadorserv);
            entityManager.getTransaction().commit();
        }catch(Exception e) {
            entityManager.getTransaction().rollback();
        }finally{
            entityManager.close();
        }
    }
    
    
       public List<PrestadorServ> findAll() { //este metodo retorna todos os registros da tabela
        try {
            EntityManager entityManager = getEntityManager();
            Query query = entityManager.createQuery("SELECT e FROM PrestadorServ e");// em  SELECT e FROM Motorista e  "Motorista" precisa representar o mesmo nome da classe
            List<PrestadorServ> prestador_servco = query.getResultList();
            entityManager.close();
            return prestador_servco;
        }catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public PrestadorServ findById(int id) {
        EntityManager entityManager = getEntityManager();
        PrestadorServ prestadorserv = null;
        try {
            prestadorserv = entityManager.find(PrestadorServ.class, id);
        }finally {
            entityManager.close();
        }
        
        return prestadorserv;
    }
    
    public PrestadorServ update(PrestadorServ prestadorserv) {
        EntityManager entityManager = getEntityManager();
        try {
            entityManager.getTransaction().begin();
            prestadorserv= entityManager.merge(prestadorserv);
            entityManager.getTransaction().commit();
        }catch(Exception e) {
            entityManager.getTransaction().rollback();
        }finally{
            entityManager.close();
        }
        return prestadorserv;
    }
    
     public List<PrestadorServ> findByCodigo(int codigo) {
        try {
            EntityManager entityManager = getEntityManager();
            Query query = entityManager.createQuery("from PrestadorServ e where e.codigo = :codigo");
            query.setParameter("codigo", codigo);
            List<PrestadorServ> prestadorservs = query.getResultList();
            entityManager.close();
            return prestadorservs;
        }catch(Exception e) {
            System.out.println("erro");
            e.printStackTrace();
            return null;
        }
    }

   public List<PrestadorServ> findByCpf(String cpf) {
        try {
            EntityManager entityManager = getEntityManager();
            Query query = entityManager.createQuery("from PrestadorServ e where e.cpf = :cpf");
            query.setParameter("cpf", cpf);
            List<PrestadorServ> prestador_servico = query.getResultList();
            entityManager.close();
            return prestador_servico;
        }catch(Exception e) {
            System.out.println("erro");
            e.printStackTrace();
            return null;
        }
    }


   
    
}
