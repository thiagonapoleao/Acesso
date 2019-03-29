/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.bean.SaidaVe;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author thiago.napoleao
 */
public class SaidaVeDAO {
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
    
    
    public void insert(SaidaVe saidave) {
        EntityManager entityManager = getEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(saidave);
            entityManager.getTransaction().commit();
        }catch(Exception e) {
            entityManager.getTransaction().rollback();
        }finally {
            entityManager.close();
        }
    }
    
    
    public void remove(SaidaVe saidave) {
        EntityManager entityManager = getEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(saidave);
            entityManager.getTransaction().commit();
        }catch(Exception e) {
            entityManager.getTransaction().rollback();
        }finally{
            entityManager.close();
        }
    }
    
    
       public List<SaidaVe> findAll() { //este metodo retorna todos os registros da tabela
        try {
            EntityManager entityManager = getEntityManager();
            Query query = entityManager.createQuery("SELECT e FROM SaidaVe e");// em  SELECT e FROM Motorista e  "Motorista" precisa representar o mesmo nome da classe
            List<SaidaVe> prestador_servco = query.getResultList();
            entityManager.close();
            return prestador_servco;
        }catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public SaidaVe findById(int id) {
        EntityManager entityManager = getEntityManager();
        SaidaVe saidave = null;
        try {
            saidave = entityManager.find(SaidaVe.class, id);
        }finally {
            entityManager.close();
        }
        
        return saidave;
    }
    
    public SaidaVe update(SaidaVe saidave) {
        EntityManager entityManager = getEntityManager();
        try {
            entityManager.getTransaction().begin();
            saidave= entityManager.merge(saidave);
            entityManager.getTransaction().commit();
        }catch(Exception e) {
            entityManager.getTransaction().rollback();
        }finally{
            entityManager.close();
        }
        return saidave;
    }
    
     public List<SaidaVe> findByCodigo(int codigo) {
        try {
            EntityManager entityManager = getEntityManager();
            Query query = entityManager.createQuery("from SaidaVe e where e.codigo = :codigo");
            query.setParameter("codigo", codigo);
            List<SaidaVe> saidaves = query.getResultList();
            entityManager.close();
            return saidaves;
        }catch(Exception e) {
            System.out.println("erro");
            e.printStackTrace();
            return null;
        }
    }

   public List<SaidaVe> findByCpf(String cpf) {
        try {
            EntityManager entityManager = getEntityManager();
            Query query = entityManager.createQuery("from SaidaVe e where e.cpf = :cpf");
            query.setParameter("cpf", cpf);
            List<SaidaVe> prestador_servico = query.getResultList();
            entityManager.close();
            return prestador_servico;
        }catch(Exception e) {
            System.out.println("erro");
            e.printStackTrace();
            return null;
        }
    }
        public List<SaidaVe> findByPlaca(String placa) {
        try {
            EntityManager entityManager = getEntityManager();
            Query query = entityManager.createQuery("from SaidaVe e where e.placa = :placa");
            query.setParameter("placa", placa);
            List<SaidaVe> prestador_servico = query.getResultList();
            entityManager.close();
            return prestador_servico;
        }catch(Exception e) {
            System.out.println("erro");
            e.printStackTrace();
            return null;
        }
    }
   
    public List<SaidaVe> findByData(String data) {
        try {
            EntityManager entityManager = getEntityManager();
            Query query = entityManager.createQuery("from SaidaVe e where e.data = :data");
            query.setParameter("data", data);
            List<SaidaVe> saida_veiculo = query.getResultList();
            entityManager.close();
            return saida_veiculo;
        }catch(Exception e) {
            System.out.println("erro");
            e.printStackTrace();
            return null;
        }
    }

}
