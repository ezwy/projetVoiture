/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entities.Voiture;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ying Enzweiler
 */
public class DAOVoiture implements Serializable {

    Connection conn = null;
    
    public DAOVoiture(){
        
    }

    public boolean connection() {
        String url = "jdbc:mysql://localhost:3306/cnam";
        String JDBC_DRIVER = "com.mysql.jdbc.Driver";
        String user = "user1";
        String pass = "user1";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, pass);
            return true;
        } catch (ClassNotFoundException e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } finally {
        }
        return false;
    }

    public List<Voiture> getAll(){
        List<Voiture> voitures = new ArrayList<Voiture>();
        PreparedStatement pstmt = null;
        String query = "select id, marque, modele, "
                + "couleur, immatriculation "
                + "from canm.Voiture";
        try {
            pstmt = conn.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                String id = rs.getString("id");
                String marque = rs.getString("marque");
                String modele = rs.getString("modele");
                String couleur = rs.getString("couleur");
                String immatriculation = rs.getString("immatriculation");
                Voiture voiture = new Voiture(id, marque, modele, couleur, immatriculation);
                voitures.add(voiture);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(pstmt);
        }
        return voitures;
    }

    public boolean delete(String id) {
        try {

            this.conn.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE
            ).executeUpdate(
                    "DELETE FROM Voiture WHERE id = " + id
            );
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
         
        }
        return false;
    }
    
    public void close(){
        
    }

    public void close(Statement stmt){
        
    }
    
    public void close(ResultSet rset){
        
    }
    public void close(PreparedStatement pstmt){
        
    }
}
