/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.project.entities;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;


@Entity
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String reference;
    private float prix;
    @ManyToOne
    private Categorie categorie;
    
    @ManyToMany(mappedBy = "produits")
    private List<Commande> commandes ;
    
   

    public Produit() {
    }

    public Produit(String reference, float prix, Categorie categorie) {
        this.reference = reference;
        this.prix = prix;
        this.categorie = categorie;
    }


   
    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Produit{" + "id=" + id + ", reference=" + reference + ", prix=" + prix + ", categorie=" + categorie + '}';
    }


    public void setId(int id) {
        this.id = id;
    }

    
    public String getReference() {
        return reference;
    }


    public void setReference(String reference) {
        this.reference = reference;
    }


    public float getPrix() {
        return prix;
    }

    
    public void setPrix(float prix) {
        this.prix = prix;
    }


    public Categorie getCategorie() {
        return categorie;
    }

    
    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }
    
    
    
}
