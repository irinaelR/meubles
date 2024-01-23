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
public class ProfilActuel {
    String nomEmployer;
    String nomProfil;
    double tauxHoraire;

    public String getNomEmployer() {
        return nomEmployer;
    }

    public void setNomEmployer(String nomEmployer) {
        this.nomEmployer = nomEmployer;
    }

    public String getNomProfil() {
        return nomProfil;
    }

    public void setNomProfil(String nomProfil) {
        this.nomProfil = nomProfil;
    }

    public double getTauxHoraire() {
        return tauxHoraire;
    }

    public void setTauxHoraire(double tauxHoraire) {
        this.tauxHoraire = tauxHoraire;
    }

    public ProfilActuel() {
    }

    public ProfilActuel(String nomEmployer, String nomProfil, double tauxHoraire) {
        this.nomEmployer = nomEmployer;
        this.nomProfil = nomProfil;
        this.tauxHoraire = tauxHoraire;
    }
    
    public List<ProfilActuel> select(Connection con) throws Exception {
        Connexion con1=new Connexion();
        Connection connecte= con;
        if(connecte==null){
            connecte=con1.Connect();
        }
        Statement statement = connecte.createStatement();
        List<ProfilActuel> liste = new ArrayList<Model.ProfilActuel>();
        String sql = "select * from profilActuel";

        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            ProfilActuel temp = new ProfilActuel();
            temp.setNomEmployer(resultSet.getString("nomEmploye"));
            temp.setNomProfil(resultSet.getString("nomProfil"));
            temp.setTauxHoraire(resultSet.getDouble("salaire"));

            liste.add(temp);
        }
        
        if(con== null){    connecte.close();    }

        return liste;
    }
}
