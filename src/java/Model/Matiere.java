/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import connexion.Connexion;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nicol
 */
public class Matiere {
    int idMatiere;
    String nomMatiere;
    double Quantite;
    double prix;

    public Matiere(int idMatiere, double Quantite) {
        this.idMatiere = idMatiere;
        this.Quantite = Quantite;
    }
    
    public double getQuantite() {
        return Quantite;
    }

    public void setQuantite(double Quantite) {
        this.Quantite = Quantite;
    }
    
    public void setQuantite(String Quantite) {
        setQuantite(Double.parseDouble(Quantite));
    }
    
    public int getIdMatiere() {
        return idMatiere;
    }

    public void setIdMatiere(int idMatiere) {
        this.idMatiere = idMatiere;
    }
    
    public void setIdMatiere(String idMatiere) {
        setIdMatiere(Integer.parseInt(idMatiere));
    }

    public String getNomMatiere() {
        return nomMatiere;
    }

    public void setNomMatiere(String nomMatiere) {
        this.nomMatiere = nomMatiere;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }
    
    public void setPrix(String str) {
        setPrix(Double.parseDouble(str));
    }

    public Matiere() {
        
    }

    public Matiere(int idMatiere, String nomMatiere) {
        this.idMatiere = idMatiere;
        this.nomMatiere = nomMatiere;
    }

    public List<Matiere> select(Connection con) throws Exception {
        Connexion con1=new Connexion();
        Connection connecte= con;
        if(connecte==null){
            connecte=con1.Connect();
        }
        Statement statement = connecte.createStatement();
        List<Matiere> liste = new ArrayList<Model.Matiere>();
        String sql = "select * from matiere";

        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            Matiere temp = new Matiere();
            temp.setIdMatiere(resultSet.getInt("idMatiere"));
            temp.setNomMatiere(resultSet.getString("nomMatiere"));

            liste.add(temp);
        }
        
        if(con== null){    connecte.close();    }

        return liste;
    }

    public void insert(Connection con) throws Exception {
        Connexion con1=new Connexion();
        Connection connecte= con;
        try{
            if(connecte==null){
                connecte=con1.Connect();
            }
        
            String requette="insert into matiere(nomMatiere) values ('"+getNomMatiere()+"');";
            System.out.println(requette);
            Statement stat=connecte.createStatement();
            stat.executeUpdate(requette);
            
        }catch(Exception e){ 
            throw new Exception(" il y a erreur dans : Categorie/insert(con)");
        }finally{
            if(con== null){    connecte.close();    }
        }
    }
    
    public List<Produit> selectProduitUtiliseMatiere(Connection con)throws Exception {
     Connexion con1=new Connexion();
        Connection connecte= con;
        if(connecte==null){
            connecte=con1.Connect();
        }
        Statement statement = con.createStatement();
        List<Produit> liste = new ArrayList<Model.Produit>();
        String sql = "select nomcategorie , nomstyle , nomvolume , quantite from FORMULEAVECSTYLECATEGORIE where idMatiere="+this.idMatiere+" ";

        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            Produit produit= new Produit();
            produit.setNomStyle(resultSet.getString("nomstyle"));
            produit.setNomCategorie(resultSet.getString("nomcategorie"));
            produit.setNomVolume(resultSet.getString("nomvolume"));
            produit.setQuantite(resultSet.getDouble("quantite"));            
            liste.add(produit);
        }
        
        if(con== null){    connecte.close();    }

        return liste;
    }
    
    public void insertMatiereAvecPrix(Connection con) throws Exception {
        Connexion con1=new Connexion();
        Connection connecte= con;
        try{
            if(connecte==null){
                connecte=con1.Connect();
            }
        
            String requette="insert into prixmateriel(idMatiere, prix) values ('"+getIdMatiere()+ "'," + getPrix() + ");";
            System.out.println(requette);
            Statement stat=connecte.createStatement();
            stat.executeUpdate(requette);
            
        }catch(Exception e){ 
            throw new Exception(" il y a erreur dans : Categorie/insert(con)");
        }finally{
            if(con== null){    connecte.close();    }
        }
        
    }
    
    public List<Matiere> listeMatiereParProduit(Connection con, int idProduit) throws Exception {
        Connexion con1=new Connexion();
        Connection connecte= con;
        if(connecte==null){
            connecte=con1.Connect();
        }
        Statement statement = connecte.createStatement();
        List<Matiere> liste = new ArrayList<Model.Matiere>();
        String sql = "select * from formuleAvecStyleCategorie where idtcs=" + idProduit;

        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            Matiere temp = new Matiere();
            temp.setIdMatiere(resultSet.getInt("idMatiere"));
            temp.setNomMatiere(resultSet.getString("nomMatiere"));

            liste.add(temp);
        }
        
        if(con== null){    connecte.close();    }

        return liste;
    }
    
    public static void main(String[] args){
        try {
            Connexion connexion = new Connexion();
            Connection con = connexion.Connect();
            Matiere cat= new Matiere();
            cat.setIdMatiere(1);
            
            
            List<Matiere> listeMatiere = cat.listeMatiereParProduit(con,1);
            for(int i=0 ; i<listeMatiere.size() ; i++){
                System.out.println(listeMatiere.get(i).idMatiere);
            }
            
            con.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }
   
}
