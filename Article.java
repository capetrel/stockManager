package gesionStock;

import java.util.Collection;
import java.util.HashMap;

/**
 * Created by capetrel on 28/04/2016.
 */
public class Article {
    private String nom;
    private double prix;
    private HashMap<Taille, Integer> listeQttTaille;

    public Article(String nom, double prix) {
        this.nom = nom;
        this.prix = prix;
        this.listeQttTaille = new HashMap<Taille, Integer>();

    }

    public void afficherListetaille () {
        //recupere la valeur dans hashmap qui contient la classe Taille
        System.out.println(listeQttTaille.keySet());
    }

    public void ajoutTaille (Taille tailleArticles){
        //insere une valeur dans hashmap qui contient classe Taille
        listeQttTaille.put(tailleArticles, 0);
    }

    public void ajoutQuantite1Taille (int quantite, Taille taille){
        // ajoute un x article avec une taille dans hashmap
        listeQttTaille.put(taille, quantite);

    }

    public void soustraireQuantite1Taille (int quantite, Taille taille){
        // soustrait une quantité x situé à la clé Taille
        int ancienneQte = listeQttTaille.get(taille); // récupérer la valeur (nbExemplaire) de la Clé dans une variable
        listeQttTaille.put(taille, ancienneQte-quantite); // on applique une soustraction a cet variable la met (put) dans le tableau

    }

    public int nbExemplaire1taille (Taille nbExemplaire){
        return listeQttTaille.get(nbExemplaire);
    }

    public int totalArticle(){
        int compteur = 0;
        Collection<Integer> collection = listeQttTaille.values();
        for(Integer i : collection) {
            compteur += i;
        }
        return compteur;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    @Override
    public String toString() {
        return nom + "\n" +
                prix + "\n" +
                listeQttTaille;
    }
}
