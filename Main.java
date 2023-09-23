import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import models.Article;
import models.Categorie;
import models.Unite;
import services.Metier;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static Metier service = new Metier();
    static int choix;

    public static void main(String[] args) {
        do {

            choix = menu();
            switch (choix) {

                /*
                 * =====================Ajout Categories====================
                 * ======================================================
                 * ======================================================
                 */
                case 1:
                    // service.flushEcran();
                    System.out.println("entrez le libelle de la categorie");
                    String libelle = scanner.nextLine();
                    // verifier si nomComplet est saisi correctement
                    if (libelle.length() > 0) {
                        Categorie categorie = new Categorie(libelle);
                        service.addCategorie(categorie);
                        System.out.println("categorie ajouté");
                    } else {
                        System.out.println("nom invalide");
                        choix = 1;
                    }
                    break;

                /*
                 * =====================lister categories====================
                 * ======================================================
                 * ======================================================
                 */
                case 2:
                    // service.flushEcran();
                    System.out.println("liste des categories");

                    ArrayList<Categorie> newListe = service.listerCategorie();

                    for (Categorie categorie : newListe) {
                        System.out.println(categorie);
                    }
                    break;
                /*
                 * =====================Modifier catgeorie===================
                 * ======================================================
                 * ======================================================
                 */
                case 3:
                    // service.flushEcran();
                    System.out.println("Entrez le libellé de la catégorie à modifier :");
                    String libelleAModifier = scanner.nextLine();
                    if (libelleAModifier.length() > 0) {
                        Categorie categorieAModifier = service.trouverCategorieParLibelle(libelleAModifier);

                        if (categorieAModifier != null) {
                            System.out.println("Catégorie actuelle :");
                            System.out.println("Nom : " + categorieAModifier.getLibelle());

                            // Saisissez les nouvelles valeurs pour la catégorie si nécessaire.
                            System.out.println("Entrez le nouveau libelle de la catégorie :");
                            String nouveauNom = scanner.nextLine();

                            service.modifierCategorie(categorieAModifier, nouveauNom);
                            System.out.println("Catégorie modifiée !");
                        } else {
                            System.out.println("Catégorie introuvable avec le libellé spécifié.");
                        }
                    } else {
                        System.out.println("Libellé invalide.");
                        choix = 1;
                    }
                    break;

                /*
                 * ====================Supprimer categorie====================
                 * ======================================================
                 * ======================================================
                 */
                case 4:
                    System.out.println("Entrez le libellé de la catégorie à supprimer :");
                    String libelleASupprimer = scanner.nextLine();

                    if (libelleASupprimer.length() > 0) {

                        Categorie categorieASupprimer = service.trouverCategorieParLibelle(libelleASupprimer);

                        if (categorieASupprimer != null) {
                            // Affichez les détails de la catégorie à supprimer
                            System.out.println("Catégorie à supprimer :");
                            System.out.println("Nom : " + categorieASupprimer.getLibelle());

                            // Demandez confirmation à l'utilisateur
                            System.out.println("Êtes-vous sûr de vouloir supprimer cette catégorie ? (Oui/Non)");
                            String confirmation = scanner.nextLine();
                            if (confirmation.equalsIgnoreCase("oui")) {
                                service.supprimerCategorie(categorieASupprimer);
                                System.out.println("Catégorie supprimée !");
                            } else {
                                System.out.println("Suppression annulée.");
                            }
                        } else {
                            System.out.println("Catégorie introuvable avec le libellé spécifié.");
                        }
                    } else {
                        System.out.println("Libellé invalide.");
                        choix = 1;
                    }
                    break;

                /*
                 * =====================Ajout Unite====================
                 * ======================================================
                 * ======================================================
                 */
                case 5:
                    // service.flushEcran();
                    System.out.println("entrez le libelle de l unite ");
                    String libelleUnite = scanner.nextLine();
                    // verifier si nomComplet est saisi correctement
                    if (libelleUnite.length() > 0) {
                        Unite unite = new Unite(libelleUnite);
                        service.addUnite(unite);
                        System.out.println("unite ajouté");
                    } else {
                        System.out.println("nom invalide");
                        choix = 1;
                    }
                    break;
                /*
                 * =====================Lister unite====================
                 * ======================================================
                 * ======================================================
                 */
                case 6:
                    // service.flushEcran();
                    System.out.println("liste unites ");

                    ArrayList<Unite> newListeUnite = service.listerUnite();

                    for (Unite unite : newListeUnite) {
                        System.out.println(unite);
                    }
                    break;

                /*
                 * =====================Ajout Complet Article====================
                 * ======================================================
                 * ======================================================
                 */
                case 7:
                    System.out.println("Ajouter un nouvel article :");

                    System.out.println("Entrez le libellé de l'article :");
                    String libelleArticle = scanner.nextLine();

                    System.out.println("Entrez la quantité en stock de l'article :");
                    int quantiteArticle = scanner.nextInt();

                    System.out.println("Entrez le prix de l'article :");
                    double prixArticle = scanner.nextDouble();

                    // Affichez la liste des catégories existantes
                    ArrayList<Categorie> listeDeCategories = service.listerCategorie();

                    System.out.println("Liste des catégories existantes :");
                    for (int i = 0; i < listeDeCategories.size(); i++) {
                        Categorie categorie = listeDeCategories.get(i);
                        System.out.println((i + 1) + ". " + categorie.getLibelle());
                    }

                    System.out.println("Entrez le numéro de la catégorie pour l'article :");
                    int numeroCategorie = scanner.nextInt();

                    // Vérifiez si le numéro de catégorie est valide
                    if (numeroCategorie > 0 && numeroCategorie <= listeDeCategories.size()) {
                        Categorie categorie = listeDeCategories.get(numeroCategorie - 1);

                        // Affichez la liste des unités disponibles à choisir
                        ArrayList<Unite> listeUnitesDisponibles = service.listerUnite();

                        System.out.println("Liste des unités disponibles :");
                        for (int i = 0; i < listeUnitesDisponibles.size(); i++) {
                            Unite unite = listeUnitesDisponibles.get(i);
                            System.out.println((i + 1) + ". " + unite.getLibelle());
                        }

                        // Créez une liste pour les nouvelles unités associées à l'article
                        ArrayList<Unite> nouvellesUnites = new ArrayList<>();

                        // Demandez à l'utilisateur de saisir les numéros des unités associées à
                        // l'article
                        scanner.nextLine();
                        System.out.println(
                                "Entrez les numéros des unités associées à l'article (séparés par des espaces) :");
                        String numerosUnites = scanner.nextLine();
                        String[] numerosUnitesArray = numerosUnites.split(" ");

                        for (String numero : numerosUnitesArray) {
                            int indexUnite = Integer.parseInt(numero);
                            if (indexUnite > 0 && indexUnite <= listeUnitesDisponibles.size()) {
                                nouvellesUnites.add(listeUnitesDisponibles.get(indexUnite - 1));
                            }
                        }

                        Article nouvelArticle = new Article(libelleArticle, quantiteArticle, prixArticle);

                        // Appelez la méthode de service pour ajouter le nouvel article avec les
                        // informations saisies
                        service.addArticle(nouvelArticle, categorie, nouvellesUnites);
                        System.out.println("Article ajouté avec succès !");
                    } else {
                        System.out.println("Numéro de catégorie invalide.");
                    }

                    break;

                /*
                 * =====================Lister Article====================
                 * ======================================================
                 * ======================================================
                 */
                case 8:
                    // service.flushEcran();
                    System.out.println("liste les articles");

                    ArrayList<Article> newListeArticles = service.listerArticle();

                    for (Article art : newListeArticles) {
                        System.out.println(art);
                    }
                    break;

                /*
                 * =====================Modifier Article====================
                 * ======================================================
                 * ======================================================
                 */
                case 9:
                    System.out.println("Modifier un article :");

                    System.out.println("Entrez le libellé de l'article que vous souhaitez modifier :");
                    String libelleArticleAModifier = scanner.nextLine();

                    // Recherchez l'article correspondant (vous devrez implémenter cette logique)
                    Article articleAModifier = service.trouverArticleParLibelle(libelleArticleAModifier);

                    if (articleAModifier != null) {
                        System.out.println("Article actuel :");
                        System.out.println("Libellé : " + articleAModifier.getLibelle());
                        System.out.println("Quantité en stock : " + articleAModifier.getQuantite());
                        System.out.println("Prix : " + articleAModifier.getPrix());

                        System.out.println("Entrez le nouveau libellé de l'article :");
                        String nouveauLibelleArticle = scanner.nextLine();

                        System.out.println("Entrez la nouvelle quantité en stock de l'article :");
                        int nouvelleQuantiteStock = scanner.nextInt();

                        System.out.println("Entrez le nouveau prix de l'article :");
                        double nouveauPrix = scanner.nextDouble();

                        service.modifierArticle(articleAModifier, nouveauLibelleArticle, nouvelleQuantiteStock,
                                nouveauPrix);
                        System.out.println("Article modifié avec succès !");
                    } else {
                        System.out.println("Article introuvable avec le libellé spécifié.");
                    }

                    break;

                /*
                 * =====================Supprimer Article====================
                 * ======================================================
                 * ======================================================
                 */

                case 10:
                    System.out.println("Supprimer un article :");

                    System.out.println("Entrez le libellé de l'article que vous souhaitez supprimer :");
                    String libelleArticleASupprimer = scanner.nextLine();

                    // Recherchez l'article correspondant (vous devrez implémenter cette logique)
                    Article articleASupprimer = service.trouverArticleParLibelle(libelleArticleASupprimer);

                    if (articleASupprimer != null) {
                        System.out.println("Article actuel :");
                        System.out.println("Libellé : " + articleASupprimer.getLibelle());
                        System.out.println("Quantité en stock : " + articleASupprimer.getQuantite());
                        System.out.println("Prix : " + articleASupprimer.getPrix());

                        System.out.println("Êtes-vous sûr de vouloir supprimer cet article ? (Oui/Non)");
                        String confirmation = scanner.nextLine();

                        if (confirmation.equalsIgnoreCase("oui")) {
                            // Supprimez l'article (vous devrez implémenter cette logique)
                            service.SupprimerArticle(articleASupprimer);
                            System.out.println("Article supprimé avec succès !");
                        } else {
                            System.out.println("Suppression annulée.");
                        }
                    } else {
                        System.out.println("Article introuvable avec le libellé spécifié.");
                    }
                    break;

                    case 11 : 
                        clearConsole();

            }

        } while (choix != 12);

    }

    public static int menu() {

        System.out.println("1-Ajouter une categorie");
        System.out.println("2-lister les categorie");
        System.out.println("3-Modifier une categorie");
        System.out.println("4-supprimer une categorie");
        System.out.println("5- ajouter une unite ");
        System.out.println("6-lister les unites");
        System.out.println("7- ajouter un article");
        System.out.println("8-lister les articles");
        System.out.println("9-Modifier un article");
        System.out.println("10-supprimer un article");
        System.out.println("11-Clear");
        System.out.println("12-Quitter");

        System.out.println("Faites votre choix : ");
        try {
            choix = Integer.parseInt(scanner.nextLine());
            return choix;
        } catch (Exception e) {
            // service.flushEcran();
            System.out.println("\n");
            System.out.println(" Erreur");
            System.out.println("\n");
            return choix = 11;
        }

    }

    private static void clearConsole() {
        String os = System.getProperty("os.name").toLowerCase();

        try {
            ProcessBuilder processBuilder;
            if (os.contains("win")) {
                // Si vous utilisez Windows
                processBuilder = new ProcessBuilder("cmd", "/c", "cls");
            } else {
                // Si vous utilisez Linux ou macOS
                processBuilder = new ProcessBuilder("clear");
            }
            Process process = processBuilder.inheritIO().start();
            process.waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
