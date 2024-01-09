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
import java.sql.*;
import connexion.*;


/**
 *
 * @author ITU
 */
public class TailleParCategorieParStyle {
    int IdTailleCategorieParStyle;
    int IdCategorie;
    int IdStyle;
    int IdVolume;

    public TailleParCategorieParStyle(int IdTailleCategorieParStyle, int IdCategorie, int IdStyle, int IdVolume) {
        this.IdTailleCategorieParStyle = IdTailleCategorieParStyle;
        this.IdCategorie = IdCategorie;
        this.IdStyle = IdStyle;
        this.IdVolume = IdVolume;
    } 

    public TailleParCategorieParStyle(int IdCategorie, int IdStyle, int IdVolume) {
        this.IdCategorie = IdCategorie;
        this.IdStyle = IdStyle;
        this.IdVolume = IdVolume;
    }

   

    public TailleParCategorieParStyle() {
    }

    public int getIdTailleCategorieParStyle() {
        return IdTailleCategorieParStyle;
    }

    public void setIdTailleCategorieParStyle(int IdTailleCategorieParStyle) {
        this.IdTailleCategorieParStyle = IdTailleCategorieParStyle;
    }

    public int getIdCategorie() {
        return IdCategorie;
    }

    public void setIdCategorie(int IdCategorie) {
        this.IdCategorie = IdCategorie;
    }
    
     public void setIdCategorie(String IdCategorie) {
        setIdCategorie(Integer.parseInt(IdCategorie));
    }

    public int getIdStyle() {
        return IdStyle;
    }

    public void setIdStyle(int IdStyle) {
        this.IdStyle = IdStyle;
    }
    
    public void setIdStyle(String IdStyle) {
        setIdStyle(Integer.parseInt(IdStyle));
    }

    public int getIdVolume() {
        return IdVolume;
    }

    public void setIdVolume(int IdVolume) {
        this.IdVolume = IdVolume;
    }
    
     public void setIdVolume(String IdVolume) {
        setIdVolume( Integer.parseInt(IdVolume));
    }
    
    
    
    
    public List<TailleParCategorieParStyle> select(Connection con) throws Exception {  
        Connexion con1=new Connexion();
        Connection connecte= con;
        if(connecte==null){
            connecte=con1.Connect();
        }
        Statement statement = connecte.createStatement();
        List<TailleParCategorieParStyle> liste = new ArrayList<Model.TailleParCategorieParStyle>();
        String sql = "select * from tailleParCategorieParStyle";
        try {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                TailleParCategorieParStyle temp = new TailleParCategorieParStyle();
                temp.setIdCategorie(resultSet.getInt("idCategorie"));
                temp.setIdStyle(resultSet.getInt("idStyle"));
                temp.setIdVolume(resultSet.getInt("idVolume"));
                liste.add(temp);
                
            }
        } catch (Exception e) {
            throw new Exception(" problem dans tailleParCategorieParStyle/select(c) ");
        }finally{
            if(con== null){    connecte.close();    }
        }
        return liste;
    }
    
    public void verifierExistence(Connection con)throws Exception {
        Connexion con1=new Connexion();
        Connection connecte= con;
        if(connecte==null){
            connecte=con1.Connect();
        }
        Statement statement = connecte.createStatement();
     
        String sql = "select count(*) as compte from tailleParCategorieParStyle where idcategorie="+this.IdCategorie+" and idstyle="+this.IdStyle+" and idvolume="+this.IdVolume+" ";
        System.out.println(sql);
        try {
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) { 
               int resultat = resultSet.getInt("compte");
               if(resultat !=0){
                   throw new Exception(" ce produit existe deja !");
               }
            }
        } catch (Exception e) {
            throw new Exception(e +" problem dans tailleParCategorieParStyle/verifierExist(c) ");
        }finally{
            if(con== null){    connecte.close();    }
        }
    }
    
     public int getIdTcs(Connection con)throws Exception {
        Connexion con1=new Connexion();
        Connection connecte= con;
        if(connecte==null){
            connecte=con1.Connect();
        }
        Statement statement = connecte.createStatement();
     
        String sql = "select idtcs from tailleParCategorieParStyle where idcategorie="+this.IdCategorie+" and idstyle="+this.IdStyle+" and idvolume="+this.IdVolume+" ";
        System.out.println(sql);
        try {
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) { 
               int resultat = resultSet.getInt("idtcs");
               if(resultat !=0){
                   return resultat;
               }
            }
        } catch (Exception e) {
            throw new Exception(e +" problem dans tailleParCategorieParStyle/verifierExist(c) ");
        }finally{
            if(con== null){    connecte.close();    }
        }
        throw new Exception(" ce produit n'existe pas ");
    }

    public void insert(Connection con) throws Exception {
        Connexion con1=new Connexion();
        Connection connecte= con;
        try{
            if(connecte==null){
                connecte=con1.Connect();
            }
            verifierExistence(connecte);
            String requette="insert into tailleParCategorieParStyle(  idcategorie , idstyle , idvolume ) values ("+ this.IdCategorie+" , "+this.IdStyle+" , "+ this.IdVolume+");";
            System.out.println(requette);
            Statement stat=connecte.createStatement();
            stat.executeUpdate(requette);
            
        }catch(Exception e){ 
           System.out.println(e);
            throw new Exception("    il y a erreur dans : Categorie/insert(con)");
        }finally{
            if(con== null){    connecte.close();    }
        }
    }
    
    public void insertions(Connection con , String idCategorie , String idStyle , String[] listeIdVolume)throws Exception {
        Connexion con1=new Connexion();
        Connection connecte= con;
        try{
            if(connecte==null){
                connecte=con1.Connect();
            }
             if(listeIdVolume!=null){
              for(int i=0 ; i<listeIdVolume.length ; i++){
                    TailleParCategorieParStyle t = new TailleParCategorieParStyle();
                    t.setIdCategorie(idCategorie);
                    t.setIdStyle(idStyle);
                    t.setIdVolume(listeIdVolume[i]);
                    t.insert(connecte);
              }
          }
        }catch(Exception e){ 
            connecte.rollback();
            throw new Exception(" erreur dans TailleParCategorieParStyle/insertions");
        }finally{
            if(con== null){    connecte.close();    }
        }
    }
    
    
    
    
    
    public static void main(String[] args){
        try {
        Connexion connexion = new Connexion();
        Connection con = connexion.Connect();
        TailleParCategorieParStyle cat= new TailleParCategorieParStyle(1 , 1 , 1);
        System.out.println(cat.getIdTcs(null));
//        cat.setNomCategorie("rams");
//        cat.insert(null);
//        List<TailleParCategorieParStyle> liste = cat.select(con);
//        for(int i=0 ; i<liste.size() ; i++){
//            System.out.println(liste.get(i).getIdCategorie()+"   "+liste.get(i).getIdStyle()+"   "+liste.get(i).getIdVolume()+"   ");
//        }
//        con.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
