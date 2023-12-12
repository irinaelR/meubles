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

    public int getIdMatiere() {
        return idMatiere;
    }

    public void setIdMatiere(int idMatiere) {
        this.idMatiere = idMatiere;
    }

    public String getNomMatiere() {
        return nomMatiere;
    }

    public void setNomMatiere(String nomMatiere) {
        this.nomMatiere = nomMatiere;
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
        Statement statement = con.createStatement();
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
    
    public static void main(String[] args){
        try {
        Connexion connexion = new Connexion();
        Connection con = connexion.Connect();
        Matiere cat= new Matiere();
        cat.setNomMatiere("rams");
        cat.insert(null);
        List<Matiere> liste = cat.select(con);
        for(int i=0 ; i<liste.size() ; i++){
            System.out.println(liste.get(i).getNomMatiere());
        }
        con.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
