/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.project.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class LigneCommandeProduit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int quantity;
    
    @ManyToOne
    @JoinColumn(name ="produit_id")
    private Produit produit;
    
    @ManyToOne
    @JoinColumn(name = "commande_id")
    private Commande commande;

    public LigneCommandeProduit() {
    }

    public LigneCommandeProduit(int quantity) {
        this.quantity = quantity;
    }



    public int getQuantity() {
        return quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    


    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


    public Produit getProduit() {
        return produit;
    }


    public void setProduit(Produit produit) {
        this.produit = produit;
    }


    public Commande getCommande() {
        return commande;
    }


    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    public LigneCommandeProduit(int quantity, Produit produit, Commande commande) {
        this.quantity = quantity;
        this.produit = produit;
        this.commande = commande;
    }
    
    
}
