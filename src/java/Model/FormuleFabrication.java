/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.List;
import connexion.*;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author ITU
 */
public class FormuleFabrication {
    int IdTailleParCategorie;
    List<Matiere> ListeMatiere;

    public int getIdTailleParCategorie() {
        return IdTailleParCategorie;
    }

    public void setIdTailleParCategorie(int IdTailleParCategorie) {
        this.IdTailleParCategorie = IdTailleParCategorie;
    }

    public void setIdTailleParCategorie(String IdTailleParCategorie) {
        setIdTailleParCategorie(Integer.parseInt(IdTailleParCategorie)) ;
    }

    
    
    public FormuleFabrication(int IdTailleParCategorie) {
        this.IdTailleParCategorie = IdTailleParCategorie;
    }

    public FormuleFabrication(int IdTailleParCategorie, List<Matiere> ListeMatiere) {
        this.IdTailleParCategorie = IdTailleParCategorie;
        this.ListeMatiere = ListeMatiere;
    }
    
    
    

    public void insert(Connection con , Matiere matiere) throws Exception {
        Connexion con1=new Connexion();
        Connection connecte= con;
        try{
            if(connecte==null){
                connecte=con1.Connect();
            }
        
            String requette="insert into formuleFabrication(idtc , idmatiere , quantite) values ("+this.IdTailleParCategorie+" , "+matiere.getIdMatiere()+" , "+ matiere.getQuantite()+");";
            System.out.println(requette);
            Statement stat=connecte.createStatement();
            stat.executeUpdate(requette);
            
        }catch(Exception e){ 
            throw new Exception(" il y a erreur dans : FormuleFabrication/insert(con)");
        }finally{
            if(con== null){    connecte.close();    }
        }
    }
    
    public void creationListeMatiere(String[] idMatieres , String[] quantitesStr ) {
        this.ListeMatiere= new ArrayList<>();
        if(idMatieres!=null && quantitesStr!=null){
            for(int i=0 ; i< idMatieres.length ; i++){
                Matiere matiere = new Matiere();
                matiere.setIdMatiere(idMatieres[i]);
                matiere.setQuantite(quantitesStr[i]);
                this.ListeMatiere.add(matiere);
            }
        }
    }
    
    public void insertionFormule(Connection con)throws Exception {
        Connexion con1=new Connexion();
        Connection connecte= con;
        try{
            if(connecte==null){
                connecte=con1.Connect();
            }
        
          for(int i=0 ; i< this.ListeMatiere.size() ; i++){
              insert(connecte , this.ListeMatiere.get(i));
          }
            
        }catch(Exception e){ 
            connecte.rollback();
            throw new Exception(" il y a erreur dans : FormuleFabrication/insert(con)");
        }finally{
            if(con== null){    connecte.close();    }
        }
    }

    public FormuleFabrication() {
    }
    
    
    public static void main(String[] args){
        try {
        Connexion connexion = new Connexion();
        Connection con = connexion.Connect();
        
        
        
        FormuleFabrication cat= new FormuleFabrication(1);
        Matiere matiere = new Matiere(1 , 300);
        cat.insert(null, matiere);
//        cat.setNomCategorie("rams");
//        cat.insert(null);
//        List<FormuleFabrication> liste = cat.select(con);
//        for(int i=0 ; i<liste.size() ; i++){
//            System.out.println(liste.get(i).getNomCategorie());
//        }
//        con.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    
}
