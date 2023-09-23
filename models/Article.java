package models;

import java.util.ArrayList;

public class Article {

    protected int id;
    private String libelle;
    private int quantite;
    private double prix;


    public String getLibelle() {
        return libelle;
    }




    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }




      private ArrayList<Unite> tabUnites =new ArrayList<Unite>();


      public ArrayList<Unite> getTabUnites() {
        return tabUnites;
    }




    public void setTabUnites(ArrayList<Unite> tabUnites) {
        this.tabUnites = tabUnites;
    }




    public int getQuantite() {
        return quantite;
    }




    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }


    public double getPrix() {
        return prix;
    }




    public void setPrix(double prix) {
        this.prix = prix;
    }




    private static int nbre;



    private Categorie categorie;

    public Article(String libelle, int quantite, double prix) {
        nbre++;
        id = nbre;
        this.libelle = libelle;
        this.quantite = quantite;
        this.prix = prix;
    }




    public Categorie getCategorie() {
        return categorie;
    }




    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }




    public Article( ) {
        nbre++;
        id=nbre;
      
    }




    @Override
    public String toString() {
        return "Article [id=" + id + ", libelle=" + libelle + ", quantite=" + quantite + ", prix=" + prix
                + ", tabUnites=" + tabUnites + ", categorie=" + categorie + "]";
    }




  

   
    
    
    
    
}