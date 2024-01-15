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
 * @author nicol
 */
public class Stock {
    int idMatiere;
    double quantiteRestant;
    String nomMatiere;
    
    public int getIdMatiere() {
        return idMatiere;
    }
    public void setIdMatiere(int idMatiere) {
        this.idMatiere = idMatiere;
    }
    public double getQuantiteRestant() {
        return quantiteRestant;
    }
    public void setQuantiteRestant(double quantiteRestant) {
        this.quantiteRestant = quantiteRestant;
    }
    public String getNomMatiere() {
        return nomMatiere;
    }
    public void setNomMatiere(String nomMatiere) {
        this.nomMatiere = nomMatiere;
    }
    
    public Stock() {}
    
    public Stock(int idMatiere, int quantiteRestant, String nomMatiere) {
        this.idMatiere = idMatiere;
        this.quantiteRestant = quantiteRestant;
        this.nomMatiere = nomMatiere;
    }
    
    public List<Stock> listeResteStock(Connection con) throws Exception {
        Connexion con1=new Connexion();
        Connection connecte= con;
        if(connecte==null){
            connecte=con1.Connect();
        }
        Statement statement = connecte.createStatement();
        List<Stock> liste = new ArrayList<Model.Stock>();
        String sql = "select * from resteStock";
        try {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Stock temp = new Stock();
                temp.setIdMatiere(resultSet.getInt("idMatiere"));
                temp.setQuantiteRestant(resultSet.getDouble("reste"));
                temp.setNomMatiere(resultSet.getString("nomMatiere"));
                liste.add(temp);
            }
        } catch (Exception e) {
            throw new Exception(" problem dans Stock/select(c) " + e);
        }finally{
            if(con== null){    connecte.close();    }
        }
        return liste;
    }
    
    public void insertionEntree(Connection con) throws Exception {
        Connexion con1=new Connexion();
        Connection connecte= con;
        try{
            if(connecte==null){
                connecte=con1.Connect();
            }
        
            String requette="insert into mouvementStock(idMatiere,entree) values (" + getIdMatiere() + "," + getQuantiteRestant() + ");";
            System.out.println(requette);
            Statement stat=connecte.createStatement();
            stat.executeUpdate(requette);
            
        }catch(Exception e){ 
            throw new Exception(" il y a erreur dans : Categorie/insert(con)");
        }finally{
            if(con== null){    connecte.close();    }
        }
    }
    
    public void insertionSortie(Connection con) throws Exception {
        Connexion con1=new Connexion();
        Connection connecte= con;
        try{
            if(connecte==null){
                connecte=con1.Connect();
            }
        
            String requette="insert into mouvementStock(idMatiere,sortie) values (" + getIdMatiere() + "," + getQuantiteRestant() + ");";
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
            Connexion connexion = new Connexion();
            Connection con = connexion.Connect();
            Stock stock= new Stock(1, 6, "");
            
            stock.insertionEntree(null);
            stock.insertionSortie(null);

            
            List<Stock> listeStocks = new Stock().listeResteStock(null);
            for(int i=0 ; i<listeStocks.size() ; i++){
                System.out.println(listeStocks.get(i).idMatiere + " : " + listeStocks.get(i).getNomMatiere());
            }
            
            con.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    public boolean verifierStock(double quantite,int idMatiere, List<Stock> stocks) throws Exception {
        for (int i = 0; i < stocks.size(); i++) {
            if(stocks.get(i).getIdMatiere() == idMatiere) {
                if (stocks.get(i).getQuantiteRestant() < quantite) {
                    return true;
                } else {
                    throw new Exception("Stock insuffisant pour " + stocks.get(i).getNomMatiere() + " Il manque " + (quantite - stocks.get(i).getQuantiteRestant()));
                }
            } 
        }
        
        return false;
    }
    
    public void insertionCommande(Connection con, int idProduit, double quantite) throws Exception{
        Connexion con1=new Connexion();
        Connection connecte= con;
        
        try{
            if(connecte==null){
                connecte=con1.Connect();
            }
            
            List<Matiere> matieres = new Matiere().listeMatiereParProduit(connecte, idProduit);
            List<Stock> stocks = listeResteStock(connecte);
        
            for (int i = 0; i < matieres.size(); i++) {
                double quantiteTotale = matieres.get(i).getQuantite()*quantite;
                if (verifierStock(quantiteTotale,matieres.get(i).getIdMatiere(), stocks)) {
                    Stock tempStock = new Stock();
                    tempStock.setIdMatiere(matieres.get(i).getIdMatiere());
                    tempStock.setQuantiteRestant(quantiteTotale);
                    
                    tempStock.insertionSortie(connecte);
                }
            }
            
        }catch(Exception e){ 
            connecte.rollback();
            throw new Exception(" il y a erreur dans : Categorie/insert(con)");
        }finally{
            if(con== null){    connecte.close();    }
        }
    }
}
