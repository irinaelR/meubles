/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import connexion.Connexion;
import java.sql.Connection;
import java.sql.Statement;

/**
 *
 * @author nicol
 */
public class Profil {
    int idProfil;
    int experienceMin;
    int niveau;
    String nomProfil;
    int ExperienceMax;

    public int getIdProfil() {
        return idProfil;
    }

    public void setIdProfil(int idProfil) {
        this.idProfil = idProfil;
    }

    public int getExperienceMin() {
        return experienceMin;
    }

    public void setExperienceMin(int experienceMin) {
        this.experienceMin = experienceMin;
    }
    
    public void setExperienceMin(String experienceMin) {
        setExperienceMin(Integer.parseInt(experienceMin));
    }

    public int getNiveau() {
        return niveau;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }
    
    public void setNiveau(String niveau) {
        setNiveau(Integer.parseInt(niveau));
    }

    public String getNomProfil() {
        return nomProfil;
    }

    public void setNomProfil(String nomProfil) {
        this.nomProfil = nomProfil;
    }

    public int getExperienceMax() {
        return ExperienceMax;
    }

    public void setExperienceMax(int ExperienceMax) {
        this.ExperienceMax = ExperienceMax;
    }
    
    public void setExperienceMax(String ExperienceMax) {
        setExperienceMax(Integer.parseInt(ExperienceMax));
    }

    public Profil() {
    }
    
    

    public Profil(int idProfil, int experienceMin, int niveau, String nomProfil, int ExperienceMax) {
        this.idProfil = idProfil;
        this.experienceMin = experienceMin;
        this.niveau = niveau;
        this.nomProfil = nomProfil;
        this.ExperienceMax = ExperienceMax;
    }
    
    public void insert(Connection con) throws Exception {
        Connexion con1=new Connexion();
        Connection connecte= con;
        try{
            if(connecte==null){
                connecte=con1.Connect();
            }
        
            String requette="insert into profil(experienceMin, niveau, nomProfil, experienceMax) values (" + getExperienceMin() + "," + getNiveau()+ ",'" + getNomProfil()+ "'," + getExperienceMax() + ");";
            System.out.println(requette);
            Statement stat=connecte.createStatement();
            stat.executeUpdate(requette);
            
        }catch(Exception e){ 
            throw new Exception(" il y a erreur dans : Profil/insert(con)");
        }finally{
            if(con== null){    connecte.close();    }
        }
    }
    
    public static void main(String[] args) {
        Profil profil = new Profil();
        profil.setExperienceMax(1);
        profil.setExperienceMin(1);
        profil.setNiveau(1);
        profil.setNomProfil("James");
        
        try {
            profil.insert(null);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
}
