/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mstore.controller;

import mstore.entity.produit;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import mstore.service.produitdao;



/**
 *
 * @author wiemhjiri
 */
public class ListData {
    
     /**
     * The data as an observable list of Persons.
     */
    
    private ObservableList<produit> produit=FXCollections.observableArrayList();

    public ListData() {
        
        produitdao pdao=produitdao.getInstance();
        produit= pdao.displayAll();
        System.out.println(produit);
    }
    
    public ObservableList<produit> getproduit(){
        return produit;
    }
   
}
