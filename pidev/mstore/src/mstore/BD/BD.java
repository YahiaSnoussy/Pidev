/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mstore.BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Asus
 */
public class BD {
    private String url="jdbc:mysql://127.0.0.1:3306/esprit";
    private String login="root";
    private String pwd="root";
    private Connection cnx;
    private static BD instance;

    public Connection getCnx() {
        return cnx;
    }
    
    
    private BD() {
        try {
            cnx=DriverManager.getConnection(url, login, pwd);
        } catch (SQLException ex) {
            Logger.getLogger(BD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
   public static BD getInstance(){
       
       if(instance==null)
           instance=new BD();
       return instance;
   }
    
}
