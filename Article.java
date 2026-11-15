package TechSttoreTP4 ;
public class Article {
    private int id;
    private String nom;
    private String reference;
    private double prix;
    private static int compteur = 0;
    public Article(String nom, double prix) {

        compteur++;
        this.id = compteur;

        this.nom = nom;
        this.prix = prix;

        this.reference = genererReference(nom, id);
    }
    
    private String genererReference(String nom, int id) {

        String resultat = "";
        String nomSansEspaces = nom.replace(" ", "");

        for (int i = 0; i < nomSansEspaces.length(); i++) {

            if (i % 5 == 0) {
                resultat = resultat + nomSansEspaces.charAt(i);
            }
        }

        return resultat + id;
    }

    
    public int getId() {
        return id;
    }

    public String getReference() {
        return reference;
    }

    public String getNom() {
        return nom;
    }

    public double getPrix() {
        return prix;
    }
    public void setReference(String reference) {
        this.reference = reference;
    }

    public void setNom(String nom) {
        this.nom = nom;
        this.reference = genererReference(nom, id);
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public void modifier(String nom) {
        this.nom = nom;
        this.reference = genererReference(nom, id);
    }
    public void modifier(String nom, double prix) {

        this.nom = nom;
        this.prix = prix;

        this.reference = genererReference(nom, id);
    }
    public String toString() {

        return "id=" + id
                + ", nom=" + nom
                + ", reference=" + reference
                + ", prix=" + prix;
    }
}



