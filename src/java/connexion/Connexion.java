/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package connexion;
import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author ITU
 */
public class Connexion {
    public Connection Connect()throws Exception, ClassNotFoundException
    {
        Class.forName("org.postgresql.Driver");
        // Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/projetmeuble","postgres","fehizoro");
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/projetmeuble","postgres","olafienby7"); // test Irina
        return con;
    }
    public static void main(String[] args){
        try {
            System.out.println("->>>>"+new Connexion().Connect());
        } catch(Exception e){
            System.out.println(e);
        }
    }
}
