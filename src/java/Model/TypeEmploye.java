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
 * @author nicol
 */
public class TypeEmploye {
    int idType;
    String nomType;
    int nombre;

    public int getIdType() {
        return idType;
    }

    public void setIdType(int idType) {
        this.idType = idType;
    }

    public String getNomType() {
        return nomType;
    }

    public void setNomType(String nomType) {
        this.nomType = nomType;
    }

    public int getNombre() {
        return nombre;
    }

    public void setNombre(int nombre) {
        this.nombre = nombre;
    }
    
    

    public TypeEmploye() {
        
    }
    
    public TypeEmploye(int idType, String nomType) {
        this.idType = idType;
        this.nomType = nomType;
    }
    
    
    public List<TypeEmploye> select(Connection con) throws Exception {
        Connexion con1=new Connexion();
        Connection connecte= con;
        if(connecte==null){
            connecte=con1.Connect();
        }
        Statement statement = connecte.createStatement();
        List<TypeEmploye> liste = new ArrayList<Model.TypeEmploye>();
        String sql = "select * from typeEmploye";

        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            TypeEmploye te= new TypeEmploye();
            te.setIdType(resultSet.getInt("id"));
            te.setNomType(resultSet.getString("nomEmploye"));
            liste.add(te);
        }
        
        if(con== null){    connecte.close();    }

        return liste;
    }
    
      public void insertTypeEmploye(Connection con) throws Exception {
        Connexion con1=new Connexion();
        Connection connecte= con;

        if(connecte==null){
            connecte=con1.Connect();
        }

        String requette="insert into typeEmploye(nomEmploye) values ('" + this.nomType+"');";
        System.out.println(requette);
        Statement stat=connecte.createStatement();
        stat.executeUpdate(requette);

        if(con== null){    connecte.close();    }
    }
    
    
    public void insert(Connection con, int idVolume) throws Exception {
        Connexion con1=new Connexion();
        Connection connecte= con;

        if(connecte==null){
            connecte=con1.Connect();
        }

        String requette="insert into typePersonneParTaille(idTaille,idEmp,nb) values (" + idVolume +  "," + getIdType() +  "," + getNombre() +");";
        System.out.println(requette);
        Statement stat=connecte.createStatement();
        stat.executeUpdate(requette);

        if(con== null){    connecte.close();    }
    }
    
    public static void main(String[] args) {
        TypeEmploye te = new TypeEmploye();
        te.idType = 1;
        te.nomType = "Wow";
        te.nombre = 4;
        
        try {
            te.insertTypeEmploye(null);
//            List<TypeEmploye> liste = te.select(null);
//            for (TypeEmploye typeEmploye : liste) {
//                System.out.println(typeEmploye.getNomType());
//            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
}
