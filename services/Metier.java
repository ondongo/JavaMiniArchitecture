package services;

import java.util.ArrayList;

import models.Article;
import models.Categorie;
import models.Unite;

public class Metier implements Imetier {

    ArrayList<Categorie> tabCategories = new ArrayList<Categorie>();

    ArrayList<Article> tabArticles = new ArrayList<Article>();

    ArrayList<Unite> tabUnites = new ArrayList<Unite>();

    // Ajouter une categorie

    @Override
    public void addCategorie(Categorie categorie) {
        // TODO Auto-generated method stub
        tabCategories.add(categorie);
    }

    // Lister une categorie

    @Override
    public ArrayList<Categorie> listerCategorie() {
        return tabCategories;
    }

    //
    @Override
    public void supprimerCategorie(Categorie categorie) {
        // TODO Auto-generated method stub

        tabCategories.remove(categorie);

    }

    @Override
    public Categorie trouverCategorieParLibelle(String libelle) {

        for (Categorie categorie : tabCategories) {
            if (categorie.getLibelle().equals(libelle)) {
                return categorie;
            }
        }
        return null;
    }

    @Override
    public void modifierCategorie(Categorie categorie, String nouveauLibelle) {
        categorie.setLibelle(nouveauLibelle);
    }

    @Override
    public void addUnite(Unite unite) {
        // TODO Auto-generated method stub
        tabUnites.add(unite);
    }

    @Override
    public void addArticle(Article article, Categorie categorie, ArrayList<Unite> unites) {
        article.setCategorie(categorie);
        article.setTabUnites(unites);
        tabArticles.add(article);
    }

    // Lister les articles

    @Override
    public ArrayList<Article> listerArticle() {
        return tabArticles;
    }

    @Override
    public void SupprimerArticle(Article article) {
        // TODO Auto-generated method stub

        tabArticles.remove(article);
        ;
    }

    @Override
    public void modifierArticle(Article article, String Newlibelle, int Newquantite, double Newprix) {
        article.setLibelle(Newlibelle);
        article.setQuantite(Newquantite);
        article.setPrix(Newprix);
    }

    @Override
    public ArrayList<Unite> listerUnite() {
        return tabUnites;
    }

    @Override
    public Article trouverArticleParLibelle(String libelle) {

        for (Article article : tabArticles) {
            if (article.getLibelle().equals(libelle)) {
                return article;
            }
        }
        return null;
    }


}