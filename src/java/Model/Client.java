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
import java.sql.Date;

/**
 *
 * @author nicol
 */
public class Client {
    int idClient;
    String nom;
    String prenom;
    Date dtn;
    int genre;

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }
    
    public void setIdClient(String idClient) {
        setIdClient(Integer.parseInt(idClient));
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Date getDtn() {
        return dtn;
    }

    public void setDtn(Date dtn) {
        this.dtn = dtn;
    }
    
    public void setDtn(String dtn) throws Exception{
        setDtn(Utilitaire.stringEnDate(dtn));
    }

    public int getGenre() {
        return genre;
    }

    public void setGenre(int genre) {
        this.genre = genre;
    }
    
    public void setGenre(String genre) {
        setGenre(Integer.parseInt(genre));
    }

    public List<Client> select(Connection con) throws Exception {
        Connexion con1=new Connexion();
        Connection connecte= con;
        if(connecte==null){
            connecte=con1.Connect();
        }
        Statement statement = connecte.createStatement();
        List<Client> liste = new ArrayList<Model.Client>();
        String sql = "select * from client";

        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            Client temp = new Client();
            temp.setIdClient(resultSet.getInt("idClient"));
            temp.setNom(resultSet.getString("nomClient"));
            temp.setDtn(resultSet.getDate("dtn"));
            temp.setGenre(resultSet.getInt("idgenre"));

            
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
        
            String requette="insert into client(nomClient,prenomClient, dtn , idgenre) values ('"+getNom()+"','"+getPrenom()+"' ,'" + Utilitaire.dateEnString(dtn) + "' ," + getGenre() + ");";
            System.out.println(requette);
            Statement stat=connecte.createStatement();
            stat.executeUpdate(requette);
            
        }catch(Exception e){ 
            throw new Exception(" il y a erreur dans : client/insert(con)");
        }finally{
            if(con== null){    connecte.close();    }
        }
    }
    
    public static void main(String[] args) {
        try {
            List<Client> genres = new Client().select(null);
            for (int i = 0; i < genres.size(); i++) {
                System.out.println(genres.get(i).nom);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
