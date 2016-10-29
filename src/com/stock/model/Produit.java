/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stock.model;


/**
 *
 * @author narcisse
 */
public class Produit {
    
    private int idPdt;
    private String nomPdt;
    private int qtePdt;
    private double prixPdt;
    private String dateExpiration;
    private String ville;

    public Produit() {
    }

    public Produit(int idPdt, String nomPdt, int qtePdt, int prixPdt, String dateExpiration,String ville) {
        this.idPdt = idPdt;
        this.nomPdt = nomPdt;
        this.qtePdt = qtePdt;
        this.prixPdt = prixPdt;
        this.dateExpiration = dateExpiration;
        this.ville=ville;
    }

    public int getIdPdt() {
        return idPdt;
    }

    public void setIdPdt(int idPdt) {
        this.idPdt = idPdt;
    }

    public String getNomPdt() {
        return nomPdt;
    }

    public void setNomPdt(String nomPdt) {
        this.nomPdt = nomPdt;
    }

    public int getQtePdt() {
        return qtePdt;
    }

    public void setQtePdt(int qtePdt) {
        this.qtePdt = qtePdt;
    }

    public double getPrixPdt() {
        return prixPdt;
    }

    public void setPrixPdt(double prixPdt) {
        this.prixPdt = prixPdt;
    }

    public String getDateExpiration() {
        return dateExpiration;
    }

    public void setDateExpiration(String dateExpiration) {
        this.dateExpiration = dateExpiration;
    }
    public void setVille(String ville){
     this.ville=ville;
    }
    public String getVille(){
     return this.ville;
    }
       
    
}
