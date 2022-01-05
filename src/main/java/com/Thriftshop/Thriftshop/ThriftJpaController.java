/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Thriftshop.Thriftshop;

import com.Thriftshop.Thriftshop.exceptions.NonexistentEntityException;
import com.Thriftshop.Thriftshop.exceptions.PreexistingEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author muham
 */
public class ThriftJpaController implements Serializable {

    public ThriftJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.Thriftshop_Thriftshop_jar_0.0.1-SNAPSHOTPU");

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public ThriftJpaController() {
    }
    

    public void create(Thrift thrift) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(thrift);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findThrift(thrift.getId()) != null) {
                throw new PreexistingEntityException("Thrift " + thrift + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Thrift thrift) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            thrift = em.merge(thrift);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = thrift.getId();
                if (findThrift(id) == null) {
                    throw new NonexistentEntityException("The thrift with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Thrift thrift;
            try {
                thrift = em.getReference(Thrift.class, id);
                thrift.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The thrift with id " + id + " no longer exists.", enfe);
            }
            em.remove(thrift);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Thrift> findThriftEntities() {
        return findThriftEntities(true, -1, -1);
    }

    public List<Thrift> findThriftEntities(int maxResults, int firstResult) {
        return findThriftEntities(false, maxResults, firstResult);
    }

    private List<Thrift> findThriftEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Thrift.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Thrift findThrift(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Thrift.class, id);
        } finally {
            em.close();
        }
    }

    public int getThriftCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Thrift> rt = cq.from(Thrift.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
