/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mstore.dao;

import mstore.entity.Product ;
import mstore.JDBC.Connjdbc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author metal
 */
public class ProductDao implements Idao<Product> {
    private static ProductDao instance ;
    private Statement st;
    private ResultSet rs;
    
    private ProductDao(){
        Connjdbc cs=Connjdbc.getInstance();
        try {
            st=cs.getCnx().createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static ProductDao getInstance(){
    
        if(instance==null) 
            instance=new ProductDao();
        return instance;
}
    @Override
    public void AddProduct(Product p){
        
        String req="insert into product (Image,Label,Price,Date,Type,Negociation,Description) values ('"+p.getImage()+"', '"+p.getLabel()+"','"+p.getPrice()+"','"+p.getDate()+"','"+p.getType()+"','"+p.getNegociation()+"','"+p.getDescription()+"')";
        try {
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void DeleteProduct(Product r) {
        String req="delete from product where id="+r.getID();
        Product p=displayById(r.getID());
        
          if(p!=null)
              try {
           
            st.executeUpdate(req);
             
        } catch (SQLException ex) {
            Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, ex);
        }else System.out.println("Product does not exist");
    }

    @Override
    public boolean UpdateProduct(Product p) {
        String qry = "UPDATE product SET Image = '"+p.getImage()+"', Label = '"+p.getLabel()+"', Price = '"+p.getPrice()+"', Date = '"+p.getDate()+"', Type = '"+p.getType()+"', Negociation = '"+p.getNegociation()+"', Description = '"+p.getDescription()+"' WHERE id = "+p.getID();
        
        try {
            if (st.executeUpdate(qry) > 0) {
                return true;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public Product displayById(int id) {
        String req="select * from product where id ="+id;
           Product p=new Product();
        try {
            rs=st.executeQuery(req);
           // while(rs.next()){
            rs.next();
                p.setID(rs.getInt("id"));
                p.setImage(rs.getString("Image"));
                p.setLabel(rs.getString("Label"));
                p.setPrice(rs.getDouble("Price"));
                p.setDate(rs.getDate("Date"));
                p.setType(rs.getString("Type"));
                p.setNegociation(rs.getString("Negociation"));
                p.setDescription(rs.getString("Description"));
            //}  
        } catch (SQLException ex) {
            Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    return p;
    }

    @Override
    public ObservableList<Product> displayAll() {
        String req="select * from product";
        ObservableList<Product> list=FXCollections.observableArrayList();   
        
        try {
            rs=st.executeQuery(req);
            while(rs.next()){
                Product p=new Product();
                p.setID(rs.getInt("id"));
                p.setImage(rs.getString("Image"));
                p.setLabel(rs.getString("Label"));
                p.setPrice(rs.getDouble("Price"));
                p.setDate(rs.getDate("Date"));
                p.setType(rs.getString("Type"));
                p.setNegociation(rs.getString("Negociation"));
                p.setDescription(rs.getString("Description"));
                list.add(p);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}