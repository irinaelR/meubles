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
 * @author ITU
 */
public class Volume {
    int IdVolume ; 
    String NomVolume;
    int nbrePersonne;

    public Volume(int IdVolume, String NomVolume) {
        this.IdVolume = IdVolume;
        this.NomVolume = NomVolume;
    }

    public Volume() {
    }

    public Volume(int IdVolume) {
        this.IdVolume = IdVolume;
    }

    public int getIdVolume() {
        return IdVolume;
    }

    public void setIdVolume(int IdVolume) {
        this.IdVolume = IdVolume;
    }
    
    public void setIdVolume(String IdVolume) {
        setIdVolume(Integer.parseInt(IdVolume));
    }

    public String getNomVolume() {
        return NomVolume;
    }

    public void setNomVolume(String NomVolume) {
        this.NomVolume = NomVolume;
    }

    public int getNbrePersonne() {
        return nbrePersonne;
    }

    public void setNbrePersonne(int nbrePersonne) {
        this.nbrePersonne = nbrePersonne;
    }
    
    public void setNbrePersonne(String nbrePersonne) {
        setNbrePersonne(Integer.parseInt(nbrePersonne));
    }
    
    
    
 
//    
      public List<Volume> select(Connection con) throws Exception {  
        Connexion con1=new Connexion();
        Connection connecte= con;
        if(connecte==null){
            connecte=con1.Connect();
        }
        Statement statement = connecte.createStatement();
        List<Volume> liste = new ArrayList<Volume>();
        String sql = "select * from volume";
        try {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Volume temp = new Volume();
                temp.setIdVolume(resultSet.getInt("idVolume"));
                temp.setNomVolume(resultSet.getString("nomVolume"));
                liste.add(temp);
            }
        } catch (Exception e) {
            throw new Exception(" problem dans Volume/select(c) ");
        }finally{
            if(con== null){    connecte.close();    }
        }
        return liste;
        
    }
//
    public void insert(Connection con) throws Exception {
        Connexion con1=new Connexion();
        Connection connecte= con;
        try{
            if(connecte==null){
                connecte=con1.Connect();
            }
        
            String requette="insert into volume(nomVolume) values ('"+getNomVolume()+"');";
            System.out.println(requette);
            Statement stat=connecte.createStatement();
            stat.executeUpdate(requette);
            
        }catch(Exception e){ 
            throw new Exception(" il y a erreur dans : Volume/insert(con)");
        }finally{
            if(con== null){    connecte.close();    }
        }
    }
    
    public void insertNombrePersonne(Connection con) throws Exception {
        Connexion con1=new Connexion();
        Connection connecte= con;
        try{
            if(connecte==null){
                connecte=con1.Connect();
            }
        
            String requette="insert into NOMBREPERSONNEPARTAILLE(IDTAILLE, NBPERS) values ("+getIdVolume()+"," + getNbrePersonne() + ");";
            System.out.println(requette);
            Statement stat=connecte.createStatement();
            stat.executeUpdate(requette);
            
        }catch(Exception e){ 
            System.out.println(e);
            throw new Exception(" il y a erreur dans : Volume/insertNombrePersonne(con)");
        }finally{
            if(con== null){    connecte.close();    }
        }
    }
    
    public void insertionEmployerParTaille(Connection con, TypeEmploye typeEmploye) throws Exception {
        Connexion con1=new Connexion();
        Connection connecte= con;

        if(connecte==null){
            connecte=con1.Connect();
        }

        String requette="insert into typePersonneParTaille(idTaille,idEmp,nb) values (" + getIdVolume() +  "," + typeEmploye.getIdType() +  "," + getNbrePersonne() +");";
        System.out.println(requette);
        Statement stat=connecte.createStatement();
        stat.executeUpdate(requette);

        if(con== null){    connecte.close();    }
    }
    
//    
    public static void main(String[] args){
        try {
            Volume vol = new Volume();
            vol.IdVolume = 1;
            vol.NomVolume = "Boost";
            vol.nbrePersonne = 3;
            
            vol.insertNombrePersonne(null);
            
            TypeEmploye te = new TypeEmploye(1, "sqflmj");
            vol.insertionEmployerParTaille(null, te);
            
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
