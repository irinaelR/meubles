/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import connexion.Connexion;
import java.sql.Connection;
import java.time.LocalDate;
import java.sql.Date;
import java.sql.Statement;

/**
 *
 * @author nicol
 */
public class Employe {
    String nomEmploye;
    Date date;
    int anneeExperience;
    double tauxHoraire;

    public String getNomEmploye() {
        return nomEmploye;
    }

    public void setNomEmploye(String nomEmploye) {
        this.nomEmploye = nomEmploye;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    public void setDate(String date)throws Exception {
        this.date = Utilitaire.stringEnDate(date);
    }

    public int getAnneeExperience() {
        return anneeExperience;
    }

    public void setAnneeExperience(int anneeExperience) {
        this.anneeExperience = anneeExperience;
    }
    
    public void setAnneeExperience(String anneeExperience) {
        setAnneeExperience(Integer.parseInt(anneeExperience));
    }

    public double getTauxHoraire() {
        return tauxHoraire;
    }

    public void setTauxHoraire(double tauxHoraire) {
        this.tauxHoraire = tauxHoraire;
    }
    
    public void setTauxHoraire(String tauxHoraire) {
        setTauxHoraire(Double.parseDouble(tauxHoraire));
    }

    public Employe() {
    }
    
    

    public Employe(String nomEmploye, Date date, int anneeExperience, double tauxHoraire) {
        this.nomEmploye = nomEmploye;
        this.date = date;
        this.anneeExperience = anneeExperience;
        this.tauxHoraire = tauxHoraire;
    }
    
    public void insert(Connection con) throws Exception {
        Connexion con1=new Connexion();
        Connection connecte= con;
        try{
            if(connecte==null){
                connecte=con1.Connect();
            }
        
            String requette="insert into employe(nomEmploye,dateEmbauche, tauxHoraire, anneeexperience) values ('" + getNomEmploye() + "','" + Utilitaire.dateEnString(getDate()) + "'," +  getAnneeExperience() + "," + getTauxHoraire() + ");";
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
            Employe employe = new Employe();
            employe.setAnneeExperience(0);
            employe.setDate("2024-12-2");
            employe.setTauxHoraire(2.5);
            employe.setNomEmploye("Kevin");
            
            employe.insert(null);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
   
    
}


