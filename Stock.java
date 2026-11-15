package TechSttoreTP4;
import java.util.ArrayList;

public class Stock{

    private ArrayList<Element> articleList;

    
    public Stock() {

        articleList = new ArrayList<Element>();
    }

    public Stock(ArrayList<Element> articleList) {

        this.articleList = articleList;
    }

    public Stock(ArrayList<String> noms,
                 ArrayList<Double> prix,
                 ArrayList<Long> quantites) {

        articleList = new ArrayList<Element>();

        if (noms.size() == prix.size()
                && noms.size() == quantites.size()) {

            for (int i = 0; i < noms.size(); i++) {

                Element e = new Element(
                    noms.get(i),
                    prix.get(i),
                    quantites.get(i)
                );

                articleList.add(e);
            }
        }
    }

    public ArrayList<Element> getArticleList() {
        return articleList;
    }

    public int getArticleNb() {
        return articleList.size();
    }

    public void setArticleList(ArrayList<Element> articleList) {
        this.articleList = articleList;
    }

    public void ajouterArticle(Article article, long quantite) {

        if (article != null && quantite >= 0) {

            Element e = new Element(article, quantite);

            articleList.add(e);
        }
    }

    public void ajouterArticle(String nom, double prix,
                               long quantite) {

        if (quantite >= 0) {

            Element e = new Element(nom, prix, quantite);

            articleList.add(e);
        }
    }

    public Element trouverArticle(String reference) {

        for (int i = 0; i < articleList.size(); i++) {

            Element e = articleList.get(i);

            if (e.equals(reference)) {
                return e;
            }
        }

        return null;
    }

    public void modifierArticle(String reference,
                                String nom,
                                double prix,
                                long quantite) {

        Element e = trouverArticle(reference);

        if (e != null) {

            e.modifier(nom, prix, quantite);
        }
    }

    public void supprimerArticle(String reference) {

        Element e = trouverArticle(reference);

        if (e != null) {

            articleList.remove(e);
        }
    }

    public void incrementerQuantiteArticle(String reference,
                                           long quantite) {

        Element e = trouverArticle(reference);

        if (e != null) {

            e.incrementerQuantite(quantite);
        }
    }

    public void decrementerQuantiteArticle(String reference,
                                           long quantite) {

        Element e = trouverArticle(reference);

        if (e != null) {

            e.decrementerQuantite(quantite);
        }
    }

    public String toString() {

        String resultat = "";

        for (int i = 0; i < articleList.size(); i++) {

            resultat = resultat + articleList.get(i) + "\n";
        }

        return resultat;
    }
}


