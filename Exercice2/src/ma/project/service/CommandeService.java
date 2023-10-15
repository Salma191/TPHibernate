/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.project.service;

import java.util.Date;
import java.util.List;
import ma.project.dao.IDao;
import ma.project.entities.Commande;
import ma.project.entities.Commande;
import ma.project.entities.LigneCommandeProduit;
import ma.project.entities.Produit;
import ma.project.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class CommandeService implements IDao<Commande>{
    @Override
    public boolean create(Commande o) {
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
    public boolean delete(Commande o) {
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
    public boolean update(Commande o) {
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
    public List<Commande> getAll() {
        List <Commande> commandes = null;
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            commandes = session.createQuery("from Commande ").list();
            tx.commit();
            return commandes;
        } catch (HibernateException ex) {
            if(tx != null)
                tx.rollback();
            return commandes;
        } finally {
            if(session != null)
                session.close();
        }
    }

    @Override
    public Commande getById(int id) {
       Commande commande = null;
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            commande = (Commande) session.get(Commande.class, id);
            tx.commit();
            return commande;
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
            return commande;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
    public List<LigneCommandeProduit> getLigneCommandeProduit(int id) {
        List <LigneCommandeProduit> ligneCommandeProduits = null;
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            ligneCommandeProduits = session.createQuery("select lc from LigneCommandeProduit lc where lc.commande.id = :id").setParameter("id", id).list();
            tx.commit();
            return ligneCommandeProduits;
        } catch (HibernateException ex) {
            if(tx != null)
                tx.rollback();
            return ligneCommandeProduits;
        } finally {
            if(session != null)
                session.close();
        }
    }
    
    public void getproduitCommandes(int id) {
        
        Commande c = this.getById(id);
        System.out.print("Commande : "+ c.getId() +"         " + "Date : "+ c.getDate()+'\n');
        System.out.print("Listes des produits :\n");
        System.out.printf("%-10s %-10s %-10s\n", "Reference", "Prix", "Quantite");
        for(LigneCommandeProduit ligne: this.getLigneCommandeProduit(id)){
            Produit produit = ligne.getProduit();
            int quantite = ligne.getQuantity();
            System.out.printf("%-10s %-10s %-10d\n", produit.getReference(), produit.getPrix() + " DH", quantite);
        }
        
    }
    public List<Produit> getProduitsCommandesEntreDates(Date dateDebut, Date dateFin) {
        List<Produit> produits = null;
        Session session = null;
        Transaction tx = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();

            // Utilisez une requête pour obtenir les produits commandés entre les deux dates
            produits = session.createQuery("SELECT c.produits FROM Commande c WHERE c.dateCommande BETWEEN :dateDebut AND :dateFin")
                    .setParameter("dateDebut", dateDebut)
                    .setParameter("dateFin", dateFin)
                    .list();

            tx.commit();
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
            ex.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }

        return produits;
    }
}
