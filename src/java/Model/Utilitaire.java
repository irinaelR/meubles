/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.text.SimpleDateFormat;
import java.sql.Date;

/**
 *
 * @author nicol
 */
public class Utilitaire {
    public static String dateEnString(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String resultat = dateFormat.format(date);
        return resultat;
    }
    
    public static Date stringEnDate(String date) throws Exception {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date dateUtil = dateFormat.parse(date);
        Date resultat = new Date(dateUtil.getTime());
        return resultat;
    }
}
