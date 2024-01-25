/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

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
public class Genre {
    int idGenre;
    String nomGenre;
    
    public int getIdGenre() {
        return idGenre;
    }

    public void setIdGenre(int idGenre) {
        this.idGenre = idGenre;
    }
    
    public void setIdGenre(String idGenre) {
        setIdGenre(Integer.parseInt(idGenre));
    }

    public String getNomGenre() {
        return nomGenre;
    }

    public void setNomGenre(String nomGenre) {
        this.nomGenre = nomGenre;
    }
    
    
    public List<Genre> select(Connection con) throws Exception {
        Connexion con1=new Connexion();
        Connection connecte= con;
        if(connecte==null){
            connecte=con1.Connect();
        }
        Statement statement = connecte.createStatement();
        List<Genre> liste = new ArrayList<Model.Genre>();
        String sql = "select * from genre";

        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            Genre temp = new Genre();
            temp.setIdGenre(resultSet.getInt("idGenre"));
            temp.setNomGenre(resultSet.getString("nomGenre"));
            
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
        
            String requette="insert into Genre(nomGenre) values ('"+getNomGenre()+"');";
            System.out.println(requette);
            Statement stat=connecte.createStatement();
            stat.executeUpdate(requette);
            
        }catch(Exception e){ 
            throw new Exception(" il y a erreur dans : Categorie/insert(con)");
        }finally{
            if(con== null){    connecte.close();    }
        }
    }
    
    public static void main(String[] args) {
        try {
            List<Genre> genres = new Genre().select(null);
            for (int i = 0; i < genres.size(); i++) {
                System.out.println(genres.get(i).nomGenre);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
