package TechSttoreTP4;
import TechSttoreTP4.Article;
public class Element {

	private Article article;
    private long quantite;
    public Element(Article article, long quantite) {

        this.article = article;
        if (quantite >= 0) {
            this.quantite = quantite;
        } else {
            this.quantite = 0;
        }
    }

    
    public Element(String nom, double prix, long quantite) {

        this.article = new Article(nom, prix);

        if (quantite >= 0) {
            this.quantite = quantite;
        } else {
            this.quantite = 0;
        }
    }


    public Article getArticle() {
        return article;
    }

    public long getQuantite() {
        return quantite;
    }

    public String getReferenceArticle() {
        return article.getReference();
    }

    public String getNomArticle() {
        return article.getNom();
    }

    public double getPrixArticle() {
        return article.getPrix();
    }

  
    public void setArticle(Article article) {
        this.article = article;
    }

    public void setQuantite(long quantite) {

        if (quantite >= 0) {
            this.quantite = quantite;
        }
    }

    
    public void incrementerQuantite(long qte) {

        if (qte > 0) {
            quantite = quantite + qte;
        }
    }

   
    public void decrementerQuantite(long qte) {

        if (qte > 0 && qte <= quantite) {
            quantite = quantite - qte;
        }
    }

   
    public void modifier(String nom, double prix, long quantite) {

        if (quantite >= 0) {

            this.article = new Article(nom, prix);
            this.quantite = quantite;
        }
    }


    public boolean equals(String reference) {

        return this.article.getReference().equals(reference);
    }


    public boolean equals(Article article) {

        return this.article.getReference()
                .equals(article.getReference());
    }

   
    public String toString() {

        return "Element [article=" + article
                + ", quantite=" + quantite + "]";
    }
}
