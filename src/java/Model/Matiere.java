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
public class Matiere {
    int idMatiere;
    String nomMatiere;

    public int getIdMatiere() {
        return idMatiere;
    }

    public void setIdMatiere(int idMatiere) {
        this.idMatiere = idMatiere;
    }

    public String getNomMatiere() {
        return nomMatiere;
    }

    public void setNomMatiere(String nomMatiere) {
        this.nomMatiere = nomMatiere;
    }

    public Matiere() {
        
    }

    public Matiere(int idMatiere, String nomMatiere) {
        this.idMatiere = idMatiere;
        this.nomMatiere = nomMatiere;
    }

    public List<Matiere> select(Connection c) throws SQLException {
        Statement statement = c.createStatement();
        List<Matiere> liste = new ArrayList<Model.Matiere>();
        String sql = "select * from matiere";

        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            Matiere temp = new Matiere();
            temp.setIdMatiere(resultSet.getInt("idMatiere"));
            temp.setNomMatiere(resultSet.getString("nomMatiere"));

            liste.add(temp);
        }

        return liste;
    }

    public void insert(Connection c) throws SQLException {
        PreparedStatement preparedStatement = c.prepareStatement("insert into matiere(idMatiere,nomMatiere) values(?, ?)");
        preparedStatement.setInt(1,getIdMatiere());
        preparedStatement.setString(2,getNomMatiere());

        preparedStatement.executeUpdate();
    }
}
