/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mstore.controller;

import mstore.entity.produit;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author Asus
 */
public class AfficherController implements Initializable {
    @FXML
    private TableView<produit> produitTable;
    @FXML
    private TableColumn<produit, String> NomColonne;
    @FXML
    private TableColumn<produit, String> PrixColonne;
    @FXML
    private Button Viderpanier ;
    @FXML
    private Button Validerachat ;

    private ListData listdata = new ListData();

  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        produitTable.setItems(listdata.getproduit());
        NomColonne.setCellValueFactory(cell -> cell.
                getValue().getNomProperty());
        PrixColonne.setCellValueFactory(cell -> cell.
                getValue().getprixProperty());
        
      
        
    }

 
}
