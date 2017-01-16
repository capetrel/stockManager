package gesionStock;

import java.util.*;

/**
 * Created by capetrel on 28/04/2016.
 */
public class StockArticle {
    private String nomStock;
    private HashMap<String, Article> listeArticles;

    public StockArticle(String nomStock) {
        this.nomStock = nomStock;
        listeArticles = new HashMap<String, Article>();
    }

    public void AfficherNomUnArticle (String nom){
        if(listeArticles.containsKey(nom.toLowerCase())) {
            Article article1 = listeArticles.get(nom.toLowerCase());
            System.out.println(article1.getNom());
        }
    }

    public void ajouterQuantiteExemplaireNomTaille (int quantite, String nom, Taille taille){
        // ajoute un x article avec une taille dans hashmap Article (valeur) qui est dans hasmap ListeArticles.
        if(listeArticles.containsKey(nom.toLowerCase())) {
            Article unArticle = listeArticles.get(nom.toLowerCase());
            unArticle.ajoutQuantite1Taille(quantite, taille);
        }

    }

    public void creerNewArticle (String nom, double prix){
        Article article = new Article(nom, prix);
        listeArticles.put(article.getNom().toLowerCase(), article);
    }
    public  void creerNewArticle(Article article)  {// polymorphisme parametrique meme methode mais pas meme parametre
        listeArticles.put(article.getNom().toLowerCase(), article);
    }

    public int CalculTailleStock () {
        int compteur = 0;
        Collection<Article> tousMesArticles = listeArticles.values(); //retourne les valeur du hashmap dans une collection
        // recuperer le nbexemplaire de tous les articles.
        for (Article unArticle : tousMesArticles) {// boulcer sur tous les article du stock
            compteur += unArticle.totalArticle();// pour un article recuperer le nbexemplaire + additinner tous les nbexemplaire (compteur)
        }
        return compteur;
    }

    public double CalculValeurStock () {
        double compteurPrix = 0;
        // On recupère tous les articles
        Collection<Article> totalPrix = listeArticles.values();

        // Pour chaque article
        for (Article unArticle : totalPrix){
            // On recupère son prix
            double prixUnitaire = unArticle.getPrix();
            // le nombre d'exemplaire
            int nbExemplaire = unArticle.totalArticle();

            // valeur du stock pour 1 article
            double valeurStockArticle = prixUnitaire * nbExemplaire;

            // cumul du montant stock total
            compteurPrix += valeurStockArticle;
        }
        return compteurPrix;
    }

    public String getNomStock() {
        return nomStock;
    }

    public void setNomStock(String nomStock) {
        this.nomStock = nomStock;

    }

    public List<Article> getArticleSorted()   {
        // On recuppère tous les artices
        Collection<Article> tousLesArticles = listeArticles.values();
        // On construit une List à partir de la collection
        ArrayList<Article> list = new ArrayList<Article>(tousLesArticles);
        // On trie la liste nouvellement crée.
        Collections.sort(list, new Comparator<Article>() {
            @Override
            public int compare(Article article1, Article article2) {
                // Si article1.nom = A et article2.nom = B alors compareTo return -1 A est avant B
                // Sinon si les deux sont A return 0, exactmeent identique
                return article1.getNom().compareTo(article2.getNom());
            }
        });
        return list;
    }

    //méthode qui prend un tableau de mots clés qui affiche tous les articles du stock
    //qui contiennent en tant que sous chaine dans leur nom un de ces mots.


    public String toString () {
        return nomStock+"\n"+
                listeArticles +"\n"+
                CalculTailleStock()+"\n"+
                CalculValeurStock();
    }
}
