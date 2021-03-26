/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.ConnexionSingleton;

/**
 *
 * @author willy
 */
public class Actualite {
    private int ID_Actu;
    private int ID_Personne;
    private String date;
    private String body;
    private String categorie;

    public Actualite(String date, String body) {
        this.date = date;
        this.body = body;
    }

    public Actualite() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Actualite(String body) {
        this.body=body;
    }

    public Actualite(String date, String body, String categorie) {
         this.date = date;
         this.body = body;
         this.categorie=categorie;
    }
    
    
    
    
    
    public int getID_Actu() {
        return ID_Actu ;
    }

    public void setID_Actu(int ID_Actu) {
        this.ID_Actu = ID_Actu;
    }

    public int getID_Personne() {
        return ID_Personne;
    }

    public void setID_Personne(int ID_Personne) {
        this.ID_Personne = ID_Personne;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }
    Connection cnx = ConnexionSingleton.getInstance().getCnx();
    
    public List<Actualite> getListActu() {
        List<Actualite> list = new ArrayList<>();
        String requete = "SELECT * from actulite ";

        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(requete);
            while (rs.next()) {
                Actualite A = new Actualite();
                A.setID_Actu(rs.getInt(1));
                A.setID_Personne(rs.getInt(2));
                A.setBody(rs.getString(3));
                A.setCategorie(rs.getString(4));
                A.setDate(rs.getString(5));

                list.add(A);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Actualite.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }
    
    
}
