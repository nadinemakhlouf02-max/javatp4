package TechSttoreTP4;
import java.util.ArrayList;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Adresse a1 = new Adresse("Monastir", 5000);
        Adresse a2 = new Adresse("Ben Arous", 1133);
        Adresse a3 = new Adresse("Ben Arous", 1145);

        System.out.println(a1);
        System.out.println(a2);
        System.out.println(a3);

        Personne p1 = new Personne(
            "01111111", "Khaled", "Jassem",
            "bejaaa", 8160
        );

        Personne p2 = new Personne(
            "02222222", "Sassi", "Ghayth", a1
        );

        System.out.println(p1);
        System.out.println(p2);

        p1.setNom("Ali");
        p1.setPrenom("Ahmed");
        p1.setAdresse(a2);

        System.out.println("Après modification :");
        System.out.println(p1);

        ArrayList<String> noms = new ArrayList<String>();
        ArrayList<Double> prix = new ArrayList<Double>();
        ArrayList<Long> quantites = new ArrayList<Long>();

        
        noms.add("Micro Casque 588 Filaire");
        prix.add(9.900);
        quantites.add(5L);
        
        Stock stock =new Stock(noms, prix, quantites);
        int choix;

        do {

            System.out.println("\n========== GESTION DU STOCK TECHSTORE ==========");
            System.out.println("0 - Ajouter un article");
            System.out.println("1 - Augmenter la quantité d'un article");
            System.out.println("2 - Modifier un article");
            System.out.println("3 - Supprimer un article");
            System.out.println("4 - Consulter le stock");
            System.out.println("5 - Quitter");

            System.out.print("Donner votre choix : ");
            choix = sc.nextInt();
            sc.nextLine();

            switch (choix) {

                
                case 0:

                    System.out.print("Donner le nom : ");
                    String nom = sc.nextLine();

                    System.out.print("Donner le prix : ");
                    double p = sc.nextDouble();

                    System.out.print("Donner la quantité : ");
                    long q = sc.nextLong();
                    sc.nextLine();

                    if (p >= 0 && q >= 0) {

                        stock.ajouterArticle(nom, p, q);

                        System.out.println("Article ajouté avec succès !");
                    } else {

                        System.out.println("Valeurs invalides !");
                    }

                    break;
                case 1:

                    System.out.print("Donner la référence : ");
                    String ref1 = sc.nextLine();

                    System.out.print("Donner la quantité à ajouter : ");
                    long q1 = sc.nextLong();
                    sc.nextLine();

                    Element e1 = stock.trouverArticle(ref1);

                    if (e1 != null && q1 > 0) {

                        stock.incrementerQuantiteArticle(ref1, q1);

                        System.out.println("Quantité augmentée !");
                    } else {

                        System.out.println("Article inexistant ou quantité invalide !");
                    }

                    break;

                
                case 2:

                    System.out.print("Donner la référence : ");
                    String ref2 = sc.nextLine();

                    Element e2 = stock.trouverArticle(ref2);

                    if (e2 != null) {

                        System.out.print("Nouveau nom : ");
                        String nouveauNom = sc.nextLine();

                        System.out.print("Nouveau prix : ");
                        double nouveauPrix = sc.nextDouble();

                        System.out.print("Nouvelle quantité : ");
                        long nouvelleQuantite = sc.nextLong();
                        sc.nextLine();

                        if (nouveauPrix >= 0 && nouvelleQuantite >= 0) {

                            stock.modifierArticle(
                                ref2,
                                nouveauNom,
                                nouveauPrix,
                                nouvelleQuantite
                            );

                            System.out.println("Article modifié !");
                        } else {

                            System.out.println("Valeurs invalides !");
                        }

                    } else {

                        System.out.println("Article introuvable !");
                    }

                    break;

                
                case 3:

                    System.out.print("Donner la référence : ");
                    String ref3 = sc.nextLine();

                    Element e3 = stock.trouverArticle(ref3);

                    if (e3 != null) {

                        stock.supprimerArticle(ref3);

                        System.out.println("Article supprimé !");
                    } else {

                        System.out.println("Article introuvable !");
                    }

                    break;

                case 4:

                    System.out.println("Liste des articles :");

                    System.out.println(stock);

                    System.out.println(
                        "Nombre d'articles : " + stock.getArticleNb()
                    );

                    break;

                
                case 5:

                    System.out.println("Fin du programme !");
                    break;

                default:

                    System.out.println("Choix invalide !");
            }

        } while (choix != 5);

    }
}
