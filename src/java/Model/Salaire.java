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
public class Salaire {
    int idTypeEmploye;
    double valeur;

    public int getIdTypeEmploye() {
        return idTypeEmploye;
    }

    public void setIdTypeEmploye(int idTypeEmploye) {
        this.idTypeEmploye = idTypeEmploye;
    }

    public double getValeur() {
        return valeur;
    }

    public void setValeur(double valeur) {
        this.valeur = valeur;
    }
    
    public void setIdTypeEmploye(String idTypeEmploye ) {
        setIdTypeEmploye(Integer.parseInt(idTypeEmploye));
    }
    
    public void setValeur(String valeur) {
        setValeur(Double.parseDouble(valeur));
    }
    
    public Salaire() {
        
    }

    public Salaire(int idTypeEmploye, double valeur) {
        this.idTypeEmploye = idTypeEmploye;
        this.valeur = valeur;
    }
    
    public List<Salaire> select(Connection con) throws Exception {
        Connexion con1=new Connexion();
        Connection connecte= con;
        if(connecte==null){
            connecte=con1.Connect();
        }
        Statement statement = connecte.createStatement();
        List<Salaire> liste = new ArrayList<Model.Salaire>();
        String sql = "select * from salaireParHeure";

        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            Salaire te= new Salaire();
            te.setIdTypeEmploye(resultSet.getInt("idTypeEmploye"));
            te.setValeur(resultSet.getDouble("valeur"));
            liste.add(te);
        }
        
        if(con== null){    connecte.close();    }

        return liste;
    }
    
    public void insert(Connection con) throws Exception {
        Connexion con1=new Connexion();
        Connection connecte= con;

        if(connecte==null){
            connecte=con1.Connect();
        }

        String requette="insert into salaireParHeure(idTypeEmploye, valeur) values ("+getIdTypeEmploye()+"," + getValeur() +  ");";
        System.out.println(requette);
        Statement stat=connecte.createStatement();
        stat.executeUpdate(requette);

        if(con== null){    connecte.close();    }
    }
    
    public static void main(String[] args) {
        Salaire salaire = new Salaire(1, 2);
        try {
            List<Salaire> salaires = new Salaire().select(null);
            
            for (Salaire salaire1 : salaires) {
                System.out.println(salaire1.getIdTypeEmploye() + salaire1.getValeur());
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
}
