/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import connexion.*;

/**
 *
 * @author nicol
 */
public class Categorie {
    int idCategorie;
    String nomCategorie;

    public int getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(int idCategorie) {
        this.idCategorie = idCategorie;
    }

    public String getNomCategorie() {
        return nomCategorie;
    }

    public void setNomCategorie(String nomCategorie) {
        this.nomCategorie = nomCategorie;
    }
    
    public Categorie() {}

    public Categorie(int idCategorie, String nomCategorie) {
        this.idCategorie = idCategorie;
        this.nomCategorie = nomCategorie;
    }

    public List<Categorie> select(Connection con) throws Exception {  
        Connexion con1=new Connexion();
        Connection connecte= con;
        if(connecte==null){
            connecte=con1.Connect();
        }
        Statement statement = connecte.createStatement();
        List<Categorie> liste = new ArrayList<Model.Categorie>();
        String sql = "select * from categorie";
        try {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Categorie temp = new Categorie();
                temp.setIdCategorie(resultSet.getInt("idCategorie"));
                temp.setNomCategorie(resultSet.getString("nomCategorie"));
                liste.add(temp);
            }
        } catch (Exception e) {
            throw new Exception(" problem dans Categorie/select(c) ");
        }finally{
            if(con != null){    connecte.close();    }
        }
        return liste;
    }

    public void insert(Connection con) throws Exception {
        Connexion con1=new Connexion();
        Connection connecte= con;
        try{
            if(connecte==null){
                connecte=con1.Connect();
            }
        
            String requette="insert into categorie(nomCategorie) values ('"+getNomCategorie()+"');";
            System.out.println(requette);
            Statement stat=connecte.createStatement();
            stat.executeUpdate(requette);
            
        }catch(Exception e){ 
            throw new Exception(" il y a erreur dans : Categorie/insert(con)");
        }finally{
            if(con== null){    connecte.close();    }
        }
    }
    
    public static void main(String[] args){
        try {
        Connexion connexion = new Connexion();
        Connection con = connexion.Connect();
        Categorie cat= new Categorie();
        cat.setNomCategorie("rams");
        cat.insert(null);
        List<Categorie> liste = cat.select(con);
        for(int i=0 ; i<liste.size() ; i++){
            System.out.println(liste.get(i).getNomCategorie());
        }
        con.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
