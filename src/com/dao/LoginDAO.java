/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.bean.Login;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author thiago.napoleao
 */
public class LoginDAO {
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
    
    
    public void insert(Login login) {
        EntityManager entityManager = getEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(login);
            entityManager.getTransaction().commit();
        }catch(Exception e) {
            entityManager.getTransaction().rollback();
        }finally {
            entityManager.close();
        }
    }
    
    
    public void remove(Login login) {
        EntityManager entityManager = getEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(login);
            entityManager.getTransaction().commit();
        }catch(Exception e) {
            entityManager.getTransaction().rollback();
        }finally{
            entityManager.close();
        }
    }
    
    
    public List<Login> findAll() { //este metodo retorna todos os registros da tabela
        try {
            EntityManager entityManager = getEntityManager();
            Query query = entityManager.createQuery("SELECT e FROM Login e");// em  SELECT e FROM Login e  "Login" precisa representar o mesmo nome da classe
            List<Login> logins = query.getResultList();
            entityManager.close();
            return logins;
        }catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public Login findById(int id) {
        EntityManager entityManager = getEntityManager();
        Login login = null;
        try {
            login = entityManager.find(Login.class, id);
        }finally {
            entityManager.close();
        }
        
        return login;
    }
    
    public Login update(Login login) {
        EntityManager entityManager = getEntityManager();
        try {
            entityManager.getTransaction().begin();
            login= entityManager.merge(login);
            entityManager.getTransaction().commit();
        }catch(Exception e) {
            entityManager.getTransaction().rollback();
        }finally{
            entityManager.close();
        }
        return login;
    }
    
    public List<Login> findByCodigo(int codigo) {
        try {
            EntityManager entityManager = getEntityManager();
            Query query = entityManager.createQuery("from Login e where e.codigo = :codigo");
            query.setParameter("codigo", codigo);
            List<Login> logins = query.getResultList();
            entityManager.close();
            return logins;
        }catch(Exception e) {
            System.out.println("erro");
            e.printStackTrace();
            return null;
        }
    }
    
    
    public List<Login> findByCpf(String cpf) {
        try {
            EntityManager entityManager = getEntityManager();
            Query query = entityManager.createQuery("from Login e where e.cpf = :cpf");
            query.setParameter("cpf", cpf);
            List<Login> logins = query.getResultList();
            entityManager.close();
            return logins;
        }catch(Exception e) {
            System.out.println("erro");
            e.printStackTrace();
            return null;
        }
    }

  
    public List<Login> login(String user, String pass) {
        try {
            EntityManager entityManager = getEntityManager();
        
            Query query = entityManager.createQuery("from Login e where e.user = :user and e.password = :pass");
            query.setParameter("user", user); 
            query.setParameter("pass", pass); 

            List<Login> login = query.getResultList();
            entityManager.close();
            return login;
        }catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    
    
}
