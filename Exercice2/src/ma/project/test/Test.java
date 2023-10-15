/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.project.test;

import java.util.Date;
import java.util.List;
import ma.project.entities.Categorie;
import ma.project.entities.Commande;
import ma.project.entities.LigneCommandeProduit;
import ma.project.entities.Produit;
import ma.project.service.CategorieService;
import ma.project.service.CommandeService;
import ma.project.service.LigneCommandeProduitService;
import ma.project.service.ProduitService;
import ma.project.util.HibernateUtil;


public class Test {

    public static void main(String[] args) {
        ProduitService ps = new ProduitService();
        CategorieService cs = new CategorieService();
        CommandeService cms = new CommandeService();
        LigneCommandeProduitService ls = new LigneCommandeProduitService();
        
        Categorie ct1 = new Categorie("fff2", "kkk");
        Categorie ct2 = new Categorie("ujk76", "wee");
        Categorie ct3 = new Categorie("ass2", "cv");
        Categorie ct4 = new Categorie("lkk87", "mn");
        Categorie ct5 = new Categorie("gfh34", "hjk");
        cs.create(ct1);
        cs.create(ct2);
        cs.create(ct3);
        cs.create(ct4);
        cs.create(ct5);
        
        Produit pd1 = new Produit("dde", 3563, ct2);
        Produit pd2 = new Produit("ert", 8646, ct1);
        Produit pd3 = new Produit("ass2", 2000, ct1);
        ps.create(pd1);
        ps.create(pd2);
        ps.create(pd3);
        
        Commande cm1 = new Commande(new Date());
        Commande cm2 = new Commande(new Date());
        cms.create(cm1);
        cms.create(cm2);
        
        ls.create(new LigneCommandeProduit(7689, pd2, cm2));
        ls.create(new LigneCommandeProduit(6768, pd1, cm2));
        
        Categorie categorieRecherchee = ct1; 
        List<Produit> produitsDeLaCategorie = ps.getProduitsByCategorie(categorieRecherchee);

        for (Produit produit : produitsDeLaCategorie) {
            System.out.println("Reference du produit : " + produit.getReference());
            System.out.println("Prix du produit : " + produit.getPrix());
    }
            
       
        cms.getproduitCommandes(2);
        

        
    }

}
