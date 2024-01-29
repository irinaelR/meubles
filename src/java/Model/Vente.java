/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Model.Genre;
import java.sql.Date;
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
public class Vente {
    int idProduit;
    int idClient;
    Date date;
    int genre;
    int quantite;
    
    public int getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(int idProduit) {
        this.idProduit = idProduit;
    }
    
    public void setIdProduit(String idProduit) {
        setIdProduit(Integer.parseInt(idProduit));
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }
    
    public void setIdClient(String idClient) {
        setIdClient(Integer.parseInt(idClient));
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    public void setDate(String date)throws Exception {
        setDate(Utilitaire.stringEnDate(date));
    }

    public int getGenre() {
        return genre;
    }

    public void setGenre(int genre) {
        this.genre = genre;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
    public void setQuantite(String quantite) {
        this.quantite = Integer.parseInt(quantite);
    }
   
    public void insert(Connection con) throws Exception {
        Connexion con1=new Connexion();
        Connection connecte= con;
        try{
            if(connecte==null){
                connecte=con1.Connect();
            }
        
            String requette="insert into vente(idProduit,idClient,date,quantite) values ("+ getIdProduit() +  "," +  getIdClient() +",'" + getDate() + "'," + getQuantite() + ")";
            System.out.println(requette);
            Statement stat=connecte.createStatement();
            stat.executeUpdate(requette);
            
        }catch(Exception e){ 
            throw new Exception(" il y a erreur dans : Categorie/insert(con)");
        }finally{
            if(con== null){    connecte.close();    }
        }
    }

    public List<Vente> select(Connection con) throws Exception {
        Connexion con1=new Connexion();
        Connection connecte= con;
        if(connecte==null){
            connecte=con1.Connect();
        }
        Statement statement = connecte.createStatement();
        List<Vente> liste = new ArrayList<Model.Vente>();
        String sql = "select * from vente";

        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            Vente temp = new Vente();
            temp.setIdProduit(resultSet.getInt("idProduit"));
            temp.setIdClient(resultSet.getInt("idClient"));
            temp.setDate(resultSet.getDate("date"));
            temp.setQuantite(resultSet.getInt("quantite"));
            
            liste.add(temp);
        }
        
        if(con== null){    connecte.close();    }

        return liste;
    }
    

    public int[] statistiqueVente() throws Exception {
    
        int[] rep = new int[2];
        int homme = 0;
        int femme = 0;

        Connexion con1=new Connexion();
        Connection connecte= con1.Connect();

        Statement statement = connecte.createStatement();
        String sql = "select * from venteAvecGenre";

        if (idProduit > 0 ){
            sql = sql + " where idProduit=" + getIdProduit();
        }
        System.out.println(sql);

        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            if(resultSet.getInt("genre") == 1) {
                homme ++;
            } else {
                femme ++;
            }
        }
        
        connecte.close();

        rep[0] = homme;
        rep[1] = femme;
        return rep;
        
    }
    
    public static void main(String[] args) {
        try {
            List<Vente> ventes = new Vente().select(null);
            for (int i = 0; i < ventes.size(); i++) {
                System.out.println(ventes.get(i).getIdClient());
            }
            
            Vente vente = new Vente();
            vente.setDate("2024-12-12");
            vente.setGenre(1);
            vente.setIdClient(1);
            vente.setQuantite(5);
            vente.setIdProduit(1);
            
            vente.insert(null);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
}
