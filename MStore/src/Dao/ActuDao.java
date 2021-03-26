/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import entity.Actualite;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.ConnexionSingleton;

/**
 *
 * @author willy
 */
public class ActuDao implements Idao <Actualite>{
     private static ActuDao instance;
     private Statement st;
     private ResultSet rs;
    private ActuDao() {
        ConnexionSingleton cs=ConnexionSingleton.getInstance();
        try {
            st=cs.getCnx().createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(ActuDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static ActuDao getInstance(){
        if(instance==null) 
            instance=new ActuDao();
        return instance;
    }


    @Override
    public void insert(Actualite A) {
       //String req= "insert into actualite (body,date) values ('"+A.getID_Actu()+"','"+A.getID_Personne()+"','"+A.getDate()+"','"+A.getBody()+"','"+A.getCategorie()+"')";
       String req= "insert into actulites (body,date,categorie) values ('"+A.getBody()+"','"+A.getDate()+"','"+A.getCategorie()+"')";

       try {
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(ActuDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List displayAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Actualite o) {
    String req="delete from actulite where body="+o.getID_Actu();
        Actualite A= displayById (o.getID_Actu());
        
          if(A!=null)
              try {
           
            st.executeUpdate(req);
             
        } catch (SQLException ex) {
            Logger.getLogger(ActuDao.class.getName()).log(Level.SEVERE, null, ex);
        }else System.out.println("n'existe pas");
}

    @Override
    public boolean update(Actualite A) {
        String qry = "UPDATE actulite SET body = '"+A.getBody()+"' WHERE id = "+A.getID_Actu();
        
        try {
            if (st.executeUpdate(qry) > 0) {
                return true;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ActuDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
        
    }
    
    @Override
    public Actualite displayById(int id) {
           String req="select * from actulite where id ="+id;
           Actualite p=new Actualite();
        try {
            rs=st.executeQuery(req);
           // while(rs.next()){
            rs.next();
                p.setID_Actu(rs.getInt("id"));
                p.setID_Personne(rs.getInt("id_per"));
                
                //p.setPrenom(rs.getString("prenom"));
            //}  
        } catch (SQLException ex) {
            Logger.getLogger(ActuDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    return p;
    }

    
    
}
