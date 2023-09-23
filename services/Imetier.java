package JavaMiniArchitecture.services;

import java.util.ArrayList;

import JavaMiniArchitecture.models.Article;
import JavaMiniArchitecture.models.Categorie;
import JavaMiniArchitecture.models.Unite;

public interface Imetier {

  void addCategorie(Categorie categorie);

 
  ArrayList<Categorie> listerCategorie();

  void modifierCategorie(Categorie categorie, String nouveauLibelle);

 
  void supprimerCategorie(Categorie categorie);

 
  void addArticle(Article article, Categorie categorie, ArrayList<Unite> unites);

  ArrayList<Article> listerArticle();

  void modifierArticle(Article article, String libelle, int quantite, double prix);

  void SupprimerArticle(Article article);

  void addUnite(Unite unite);

  Categorie trouverCategorieParLibelle(String libelle);

  Article trouverArticleParLibelle(String libelle);

  ArrayList<Unite> listerUnite();

}// end interface IService
