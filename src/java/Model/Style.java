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
public class Style {
    int idStyle;
    String nomStyle;

    public int getIdStyle() {
        return idStyle;
    }

    public void setIdStyle(int idStyle) {
        this.idStyle = idStyle;
    }

    public String getNomStyle() {
        return nomStyle;
    }

    public void setNomStyle(String nomStyle) {
        this.nomStyle = nomStyle;
    }
    
    public Style() {
        
    }

    public Style(int idStyle, String nomStyle) {
        this.idStyle = idStyle;
        this.nomStyle = nomStyle;
    }

    public List<Style> select(Connection c) throws SQLException {
        Statement statement = c.createStatement();
        List<Style> liste = new ArrayList<Model.Style>();
        String sql = "select * from style";

        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            Style temp = new Style();
            temp.setIdStyle(resultSet.getInt("idStyle"));
            temp.setNomStyle(resultSet.getString("nomStyle"));

            liste.add(temp);
        }

        return liste;
    }

    public void insert(Connection c) throws SQLException {
        PreparedStatement preparedStatement = c.prepareStatement("insert into style(idStyle,nomStyle) values(?, ?)");
        preparedStatement.setInt(1,getIdStyle());
        preparedStatement.setString(2,getNomStyle());

        preparedStatement.executeUpdate();
    }

    public List<Style> select(Connection c, int id) throws SQLException {
        Statement statement = c.createStatement();
        List<Style> liste = new ArrayList<Model.Style>();
        String sql = "select * from style where idStyle=" + id;

        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            Style temp = new Style();
            temp.setIdStyle(resultSet.getInt("idStyle"));
            temp.setNomStyle(resultSet.getString("nomStyle"));

            liste.add(temp);
        }

        return liste;
    }

}
