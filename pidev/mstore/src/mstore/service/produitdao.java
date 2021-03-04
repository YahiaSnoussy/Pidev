/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mstore.service;
import mstore.entity.produit;
import mstore.BD.BD;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Asus
 */
public class produitdao implements msinterface<produit>{
    private static produitdao instance;
    private Statement st;
    private ResultSet rs;
    private produitdao() {
        BD cs=BD.getInstance();
        try {
            st=cs.getCnx().createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(produitdao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(produit o) {
        String req="delete from personne where id="+o.getId();
        produit p=displayById(o.getId());
        
          if(p!=null)
              try {
           
            st.executeUpdate(req);
             
        } catch (SQLException ex) {
            Logger.getLogger(produitdao.class.getName()).log(Level.SEVERE, null, ex);
        }else System.out.println("n'existe pas");
        
    }

    @Override
    public List<produit> displayAll() {
        String req="select * from personne";
        List<produit> list=new ArrayList<>();
        
        try {
            rs=st.executeQuery(req);
            while(rs.next()){
                produit p=new produit();
                p.setId(rs.getInt(1));
                p.setNom(rs.getString("nom"));
                p.setprix(rs.getInt(3));
                list.add(p);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(produitdao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public produit displayById(int id) {
        String req="select * from produit where id ="+id;
           produit p=new produit();
        try {
            rs=st.executeQuery(req);
           // while(rs.next()){
            rs.next();
                p.setId(rs.getInt("id"));
                p.setNom(rs.getString("nom"));
                p.setprix(rs.getInt("prix"));
            //}  
        } catch (SQLException ex) {
            Logger.getLogger(produitdao.class.getName()).log(Level.SEVERE, null, ex);
        }
    return p;
    }

    @Override
    public void insert(produit o) {
        String req="insert into personne (nom,prenom) values ('"+o.getNom()+"','"+o.getprix()+"')";
        try {
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(produitdao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public boolean update(produit p) {
         String qry = "UPDATE personne SET nom = '"+p.getNom()+"', prenom = '"+p.getprix()+"' WHERE id = "+p.getId();
        
        try {
            if (st.executeUpdate(qry) > 0) {
                return true;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(produitdao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    public static produitdao getInstance(){
        if(instance==null) 
            instance=new produitdao();
        return instance;
    }

}
