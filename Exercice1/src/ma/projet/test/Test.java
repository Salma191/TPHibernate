package ma.projet.test;

import java.util.Date;
import ma.projet.entities.Produit;
import ma.projet.service.ProduitService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Test {

    public static void main(String[] args) throws ParseException {
        System.out.println("---------------------------------------------------------");
        ProduitService p = new ProduitService();
///Q 8-1 
//        Produit produit1 = new Produit("add","add",new Date(),50,"add");
//        p.create(produit1);

///Q 8-2    
//     for (Produit prod : p.findAll()) {
//            System.out.println("Nom du produit : " + prod.getMarque());
//        }
///Q 8-3
//        Produit retour_produit = p.findById(2);
//        System.out.println(retour_produit);
//Q 8-4
        // p.delete(p.findById(3));
//Q 8-5
//        Produit produit_trouve=p.findById(1);
//        produit_trouve.setPrix(50000);
//        p.update(produit_trouve);
//Q 8-6
//        for (Produit prod : p.findAll()) {
//            if (prod.getPrix() > 100) {
//                System.out.println("les produits avec les prix superieurs a 100 sont :");
//                if (prod.getPrix() > 100) {
//                    System.out.println("le produits numero :"+prod.getId());
//                }
//            }
//        }        
//Q 8-7
//        Scanner sc = new Scanner(System.in);
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//
//        System.out.println("entrer date debut intervalle sous cette forme yyyy-MM-dd");
//        String datedebut = sc.nextLine();
//        Date datedebutFormat = dateFormat.parse(datedebut);
//
//        System.out.println("entrer date fin intervalle sous cette forme yyyy-MM-dd");
//        String datefin = sc.nextLine();
//        Date datefinFormat = dateFormat.parse(datefin);
//
//        System.out.println(" la liste des produits Commander entre " + datedebut + "et" + datefin + " sont:");
//        for (Produit prod : p.findAll()) {
//            if (prod.getDateAchat().after(datedebutFormat) && prod.getDateAchat().before(datefinFormat)) {
//                System.out.println("le produit:" + prod.getId());
//            }
//        }

    }

}
