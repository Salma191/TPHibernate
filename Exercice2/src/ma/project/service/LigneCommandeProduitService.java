/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.project.service;

import java.util.List;
import ma.project.dao.IDao;
import ma.project.entities.LigneCommandeProduit;
import ma.project.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class LigneCommandeProduitService implements IDao<LigneCommandeProduit>{
    @Override
    public boolean create(LigneCommandeProduit o) {
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.save(o);
            tx.commit(); 
            return true;
        } catch (HibernateException ex) {
            if(tx != null)
                tx.rollback();
            return false;
        }finally{
            if(session != null)
                session.close();
        }
    }

    @Override
    public boolean delete(LigneCommandeProduit o) {
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.delete(o);
            tx.commit();
            return true;
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
            return false;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public boolean update(LigneCommandeProduit o) {
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.update(o);
            tx.commit();
            return true;
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
            return false;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<LigneCommandeProduit> getAll() {
        List <LigneCommandeProduit> lignecommandeproduits = null;
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            lignecommandeproduits = session.createQuery("from LigneCommandeProduit ").list();
            tx.commit();
            return lignecommandeproduits;
        } catch (HibernateException ex) {
            if(tx != null)
                tx.rollback();
            return lignecommandeproduits;
        } finally {
            if(session != null)
                session.close();
        }
    }

    @Override
    public LigneCommandeProduit getById(int id) {
       LigneCommandeProduit lignecommandeproduit = null;
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            lignecommandeproduit = (LigneCommandeProduit) session.get(LigneCommandeProduit.class, id);
            tx.commit();
            return lignecommandeproduit;
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
            return lignecommandeproduit;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
    
}
