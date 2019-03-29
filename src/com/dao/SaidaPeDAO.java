/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.bean.SaidaPe;
import com.bean.SaidaPe;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author thiago.napoleao
 */
public class SaidaPeDAO {
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
    
    
    public void insert(SaidaPe saidape) {
        EntityManager entityManager = getEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(saidape);
            entityManager.getTransaction().commit();
        }catch(Exception e) {
            entityManager.getTransaction().rollback();
        }finally {
            entityManager.close();
        }
    }
    
    
    public void remove(SaidaPe saidape) {
        EntityManager entityManager = getEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(saidape);
            entityManager.getTransaction().commit();
        }catch(Exception e) {
            entityManager.getTransaction().rollback();
        }finally{
            entityManager.close();
        }
    }
    
    
       public List<SaidaPe> findAll() { //este metodo retorna todos os registros da tabela
        try {
            EntityManager entityManager = getEntityManager();
            Query query = entityManager.createQuery("SELECT e FROM SaidaPe e");// em  SELECT e FROM Motorista e  "Motorista" precisa representar o mesmo nome da classe
            List<SaidaPe> saida_prestador = query.getResultList();
            entityManager.close();
            return saida_prestador;
        }catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public SaidaPe findById(int id) {
        EntityManager entityManager = getEntityManager();
        SaidaPe saidape = null;
        try {
            saidape = entityManager.find(SaidaPe.class, id);
        }finally {
            entityManager.close();
        }
        
        return saidape;
    }
    
    public SaidaPe update(SaidaPe saidape) {
        EntityManager entityManager = getEntityManager();
        try {
            entityManager.getTransaction().begin();
            saidape= entityManager.merge(saidape);
            entityManager.getTransaction().commit();
        }catch(Exception e) {
            entityManager.getTransaction().rollback();
        }finally{
            entityManager.close();
        }
        return saidape;
    }
    
     public List<SaidaPe> findByCodigo(int codigo) {
        try {
            EntityManager entityManager = getEntityManager();
            Query query = entityManager.createQuery("from SaidaPe e where e.codigo = :codigo");
            query.setParameter("codigo", codigo);
            List<SaidaPe> saida_prestador = query.getResultList();
            entityManager.close();
            return saida_prestador;
        }catch(Exception e) {
            System.out.println("erro");
            e.printStackTrace();
            return null;
        }
    }

   public List<SaidaPe> findByCpf(String cpf) {
        try {
            EntityManager entityManager = getEntityManager();
            Query query = entityManager.createQuery("from SaidaPe e where e.cpf = :cpf");
            query.setParameter("cpf", cpf);
            List<SaidaPe> prestador_servico = query.getResultList();
            entityManager.close();
            return prestador_servico;
        }catch(Exception e) {
            System.out.println("erro");
            e.printStackTrace();
            return null;
        }
    }
        public List<SaidaPe> findByPlaca(String placa) {
        try {
            EntityManager entityManager = getEntityManager();
            Query query = entityManager.createQuery("from SaidaPe e where e.placa = :placa");
            query.setParameter("placa", placa);
            List<SaidaPe> prestador_servico = query.getResultList();
            entityManager.close();
            return prestador_servico;
        }catch(Exception e) {
            System.out.println("erro");
            e.printStackTrace();
            return null;
        }
    }
   
    public List<SaidaPe> findByData(String data) {
        try {
            EntityManager entityManager = getEntityManager();
            Query query = entityManager.createQuery("from SaidaPe e where e.data = :data");
            query.setParameter("data", data);
            List<SaidaPe> saida_prestador = query.getResultList();
            entityManager.close();
            return saida_prestador;
        }catch(Exception e) {
            System.out.println("erro");
            e.printStackTrace();
            return null;
        }
    }
 }