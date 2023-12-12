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

/**
 *
 * @author nicol
 */
public class Categorie {
    int idCategorie;
    String nomCategorie;

    public int getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(int idCategorie) {
        this.idCategorie = idCategorie;
    }

    public String getNomCategorie() {
        return nomCategorie;
    }

    public void setNomCategorie(String nomCategorie) {
        this.nomCategorie = nomCategorie;
    }
    
    public Categorie() {
        
    }

    public Categorie(int idCategorie, String nomCategorie) {
        this.idCategorie = idCategorie;
        this.nomCategorie = nomCategorie;
    }

    public List<Categorie> select(Connection c) throws SQLException {
        
        Statement statement = c.createStatement();
        List<Categorie> liste = new ArrayList<Model.Categorie>();
        String sql = "select * from categorie";

        try {
            ResultSet resultSet = statement.executeQuery(sql);
            
            while (resultSet.next()) {
                Categorie temp = new Categorie();
                temp.setIdCategorie(resultSet.getInt("idCategorie"));
                temp.setNomCategorie(resultSet.getString("nomCategorie"));

                liste.add(temp);
            }
        } catch (SQLException e) {
            
        }

        return liste;
    }

    public void insert(Connection c) throws SQLException {
        PreparedStatement preparedStatement = c.prepareStatement("insert into categorie(idCategorie,nomCategorie) values(?, ?)");
        preparedStatement.setInt(1,getIdCategorie());
        preparedStatement.setString(2,getNomCategorie());

        preparedStatement.executeUpdate();
    }
}
