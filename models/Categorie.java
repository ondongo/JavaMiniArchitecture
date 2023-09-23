package models;

import java.util.ArrayList;

public class Categorie {

    // Attributs de categorie
    private int id;

    private String libelle;

    private int nbre;

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNbre() {
        return nbre;
    }

    public void setNbre(int nbre) {
        this.nbre = nbre;
    }

    // constructor
    public Categorie() {
        nbre++;
        id = nbre;
    }

    // one to many
    private ArrayList<Article> tabArticles = new ArrayList<Article>();

    public Categorie(String libelle) {

        nbre++;
        id = nbre;
        this.libelle = libelle;
    }

    public ArrayList<Article> getTabArticles() {
        return tabArticles;
    }

    public void setTabArticles(ArrayList<Article> tabArticles) {
        this.tabArticles = tabArticles;
    }

    @Override
    public String toString() {
        return "Categorie [id=" + id + ", libelle=" + libelle + "]";
    }

}
