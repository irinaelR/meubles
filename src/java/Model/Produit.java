/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author ITU
 */
public class Produit {
    int IdCategorie ;
    int  IdStyle ;
    int  IdVolume ;
    String NomCategorie ;
    String NomStyle;
    String NomVolume;
    double Quantite;

    public Produit(int IdCategorie, int IdStyle, int IdVolume, String NomCategorie, String NomStyle, String NomVolume, double Quantite) {
        this.IdCategorie = IdCategorie;
        this.IdStyle = IdStyle;
        this.IdVolume = IdVolume;
        this.NomCategorie = NomCategorie;
        this.NomStyle = NomStyle;
        this.NomVolume = NomVolume;
        this.Quantite = Quantite;
    }
    
    

    public Produit(int IdCategorie, int IdStyle, int IdVolume, String NomCategorie, String NomStyle, String NomVolume) {
        this.IdCategorie = IdCategorie;
        this.IdStyle = IdStyle;
        this.IdVolume = IdVolume;
        this.NomCategorie = NomCategorie;
        this.NomStyle = NomStyle;
        this.NomVolume = NomVolume;
    }

    public int getIdCategorie() {
        return IdCategorie;
    }

    public void setIdCategorie(int IdCategorie) {
        this.IdCategorie = IdCategorie;
    }

    public int getIdStyle() {
        return IdStyle;
    }

    public void setIdStyle(int IdStyle) {
        this.IdStyle = IdStyle;
    }

    public int getIdVolume() {
        return IdVolume;
    }

    public void setIdVolume(int IdVolume) {
        this.IdVolume = IdVolume;
    }

    public String getNomCategorie() {
        return NomCategorie;
    }

    public void setNomCategorie(String NomCategorie) {
        this.NomCategorie = NomCategorie;
    }

    public String getNomStyle() {
        return NomStyle;
    }

    public void setNomStyle(String NomStyle) {
        this.NomStyle = NomStyle;
    }

    public String getNomVolume() {
        return NomVolume;
    }

    public void setNomVolume(String NomVolume) {
        this.NomVolume = NomVolume;
    }

    public Produit() {
    }

    public double getQuantite() {
        return Quantite;
    }

    public void setQuantite(double Quantite) {
        this.Quantite = Quantite;
    }

    
    
    
}
