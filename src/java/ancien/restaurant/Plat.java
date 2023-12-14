package restaurant;

import util.annotation.Champ;
import util.annotation.Servlet;
import util.annotation.Sql;

@Servlet(servletName = "insert", page = "commander.jsp")
@Sql(nom = "Plat")
public class Plat {
    @Champ(nom = "Numero")
    int id;
    @Sql(nom = "nom")
    @Champ(nom = "Nom")
    String nom;
    @Sql(nom = "prixNormal")
    @Champ(nom = "Prix normal")
    Double prixNormal;

    @Sql(nom = "prixIntermediaire")
    @Champ(nom = "Prix pour un Intermediaire")
    Double prixIntermediaire;
    @Sql(nom = "prixDeRevient")
    @Champ(nom = "Prix de revient")
    Double prixDeRevient;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int exempleId() {
        return 1;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String exempleNom() {
        return "Steak";
    }

    public Double getPrixNormal() {
        return prixNormal;
    }

    public void setPrixNormal(Double prixNormal) {
        this.prixNormal = prixNormal;
    }

    public void setPrixNormal(String prixNormal) {
        setPrixNormal(Double.valueOf(prixNormal));
    }

    public Double exemplePrixNormal() {
        return 10000.0;
    }

    public Double getPrixIntermediaire() {
        return prixIntermediaire;
    }

    public void setPrixIntermediaire(Double prixIntermediaire) {
        this.prixIntermediaire = prixIntermediaire;
    }

    public Double exemplePrixIntermediaire() {
        return 9000.0;
    }

    public void setPrixIntermediaire(String prixIntermediaire) {
        setPrixIntermediaire(prixIntermediaire);
    }

    public Double getPrixDeRevient() {
        return prixDeRevient;
    }

    public void setPrixDeRevient(Double prixDeRevient) {
        this.prixDeRevient = prixDeRevient;
    }

    public void setPrixDeRevient(String prixRevient) {
        setPrixDeRevient(Double.valueOf(prixRevient));
    }

    public Double exemplePrixDeRevient() {
        return 5000.0;
    }
}
