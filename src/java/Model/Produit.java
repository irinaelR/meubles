/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import connexion.Connexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ITU
 */
public class Produit {
    int Idtcs;
    int IdCategorie ;
    int  IdStyle ;
    int  IdVolume ;
    String NomCategorie ;
    String NomStyle;
    String NomVolume;
    double Quantite;
    double prix;

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
    
    public int getIdtcs() {
        return Idtcs;
    }
    public void setIdtcs(int idtcs) {
        Idtcs = idtcs;
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

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }


    public List<Produit> getProduitAvecPrix(Connection con) throws Exception {
        Connexion con1=new Connexion();
        Connection connecte= con;
        if(connecte==null){
            connecte=con1.Connect();
        }
        Statement statement = connecte.createStatement();
        List<Produit> liste = new ArrayList<Model.Produit>();
        String sql = "select * from coutmeuble";

        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            Produit produit= new Produit();
            produit.setNomStyle(resultSet.getString("nomstyle"));
            produit.setNomCategorie(resultSet.getString("nomcategorie"));
            produit.setNomVolume(resultSet.getString("nomvolume"));
            produit.setQuantite(resultSet.getDouble("quantite"));   
            produit.setPrix(resultSet.getDouble("cout"));
            liste.add(produit);
        }
        
        if(con== null){    connecte.close();    }

        return liste;
    }
    
    public List<Produit> getProduitAvecPrix(Connection con, String min, String max) throws Exception {
        Connexion con1=new Connexion();
        Connection connecte= con;
        if(connecte==null){
            connecte=con1.Connect();
        }
        Statement statement = connecte.createStatement();
        List<Produit> liste = new ArrayList<Model.Produit>();
        String sql = "select * from coutmeuble where cout <= " + max + " AND cout >= " + min;
        System.out.print(sql);
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            Produit produit= new Produit();
            produit.setNomStyle(resultSet.getString("nomstyle"));
            produit.setNomCategorie(resultSet.getString("nomcategorie"));
            produit.setNomVolume(resultSet.getString("nomvolume"));
            produit.setPrix(resultSet.getDouble("cout"));
            liste.add(produit);
        }
        
        if(con== null){    connecte.close();    }

        return liste;
    }
    
    public List<Produit> selectProduit(Connection con) throws Exception{
        Connexion con1=new Connexion();
        Connection connecte= con;
        if(connecte==null){
            connecte=con1.Connect();
        }
        Statement statement = connecte.createStatement();
        List<Produit> liste = new ArrayList<Model.Produit>();
        String sql = "select * from produit";
        System.out.print(sql);
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            Produit produit= new Produit();
            produit.setIdtcs(resultSet.getInt("idtcs"));
            produit.setIdStyle(resultSet.getInt("idStyle"));
            produit.setIdVolume(resultSet.getInt("idVolume"));
            produit.setNomStyle(resultSet.getString("nomstyle"));
            produit.setNomCategorie(resultSet.getString("nomcategorie"));
            produit.setNomVolume(resultSet.getString("nomvolume"));
            liste.add(produit);
        }
        
        if(con== null){    connecte.close();    }

        return liste;
    }
    
    public static void main(String[] args) {
        try {
            Connexion connexion = new Connexion();
            Connection con = connexion.Connect();
           
            
            List<Produit> listeMatiere = new Produit().selectProduit(null);
            for(int i=0 ; i<listeMatiere.size() ; i++){
                System.out.println(listeMatiere.get(i).NomCategorie);
            }
            
            con.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
}
