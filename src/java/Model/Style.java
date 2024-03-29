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
public class Style {
    int idStyle;
    String nomStyle;
    double nombreHeure;

    public int getIdStyle() {
        return idStyle;
    }

    public void setIdStyle(int idStyle) {
        this.idStyle = idStyle;
    }
    
    public void setIdStyle(String idStyle) {
        setIdStyle(Integer.parseInt(idStyle));
    }

    public String getNomStyle() {
        return nomStyle;
    }

    public void setNomStyle(String nomStyle) {
        this.nomStyle = nomStyle;
    }

    public double getNombreHeure() {
        return nombreHeure;
    }

    public void setNombreHeure(double nombreHeure) {
        this.nombreHeure = nombreHeure;
    }
    
    public void setNombreHeure(String nombreHeure) {
        setNombreHeure(Double.parseDouble(nombreHeure));
    }
    
    
    public Style() {}

    public Style(int idStyle, String nomStyle) {
        this.idStyle = idStyle;
        this.nomStyle = nomStyle;
    }

    public List<Style> select(Connection con) throws Exception {
        Connexion con1=new Connexion();
        Connection connecte= con;
        if(connecte==null){
            connecte=con1.Connect();
        }
        Statement statement = connecte.createStatement();
        List<Style> liste = new ArrayList<Model.Style>();
        String sql = "select * from style";
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            Style temp = new Style();
            temp.setIdStyle(resultSet.getInt("idStyle"));
            temp.setNomStyle(resultSet.getString("nomStyle"));

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
        
            String requette="insert into style(nomStyle) values ('"+getNomStyle()+"');";
            System.out.println(requette);
            Statement stat=connecte.createStatement();
            stat.executeUpdate(requette);
            
        }catch(Exception e){ 
            throw new Exception(" il y a erreur dans : Categorie/insert(con)");
        }finally{
            if(con== null){    connecte.close();    }
        }
    }
    
    public void insertNombreHeure(Connection con) throws Exception {
        Connexion con1=new Connexion();
        Connection connecte= con;
        try{
            if(connecte==null){
                connecte=con1.Connect();
            }
        
            String requette="insert into nbHoraireParStyle(idStyle, nbHeures) values (" + getIdStyle() + "," + getNombreHeure() + ");";
            System.out.println(requette);
            Statement stat=connecte.createStatement();
            stat.executeUpdate(requette);
            
        }catch(Exception e){ 
            throw new Exception(" il y a erreur dans : Categorie/insertNombreHeure(con)");
        }finally{
            if(con== null){    connecte.close();    }
        }
    }
    
    public List<Matiere> listeMatiereParStyle(Connection con) throws Exception{
        Connexion con1=new Connexion();
        Connection connecte= con;
        if(connecte==null){
            connecte=con1.Connect();
        }
        Statement statement = connecte.createStatement();
        List<Matiere> liste = new ArrayList<Model.Matiere>();
        String sql = "select idMatiere , nomMatiere from matiere";
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
    
    public void ajouterMatiere(Connection con , int idMatiere) throws Exception{
        Connexion con1=new Connexion();
        Connection connecte= con;
        try{
            if(connecte==null){
                connecte=con1.Connect();
            }
            String requette="insert into matiereParStyle(idStyle , idMatiere) values ("+getIdStyle()+" , "+idMatiere+");";
            
            Statement stat=connecte.createStatement();
            stat.executeUpdate(requette);
            
        }catch(Exception e){ 
            throw new Exception(" il y a erreur dans : Categorie/insert(con)");
        }finally{
            if(con== null){    connecte.close();    }
        }
        
    }
    
    

    public List<Style> selectById(Connection con, int id) throws Exception {
          Connexion con1=new Connexion();
        Connection connecte= con;
        if(connecte==null){
            connecte=con1.Connect();
        }
        Statement statement = connecte.createStatement();
        List<Style> liste = new ArrayList<Model.Style>();
        String sql = "select * from style where idStyle=" + id;

        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            Style temp = new Style();
            temp.setIdStyle(resultSet.getInt("idStyle"));
            temp.setNomStyle(resultSet.getString("nomStyle"));

            liste.add(temp);
        }
        
        if(con== null){    connecte.close();    }
        
        return liste;
    }
     public static void main(String[] args){
        try {
            Style style = new Style();
            style.idStyle = 2;
            style.nomStyle = "Aaaa";
            style.nombreHeure = 10;
            
            style.insertNombreHeure(null);
        }catch(Exception e){
            System.out.println(e);
        }
    }

}
