/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mstore.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import mstore.dao.ProductDao;
import mstore.entity.Product;

/**
 * FXML Controller class
 *
 * @author metal
 */
public class AddProductController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private Button finish;
    @FXML
    private TextField LabelText;
    @FXML
    private TextField PriceText;
    @FXML
    private TextField ImageText;
    @FXML
    private TextArea DescriptionText ;
    @FXML 
    private CheckBox Type ;
    @FXML
    private RadioButton Negociation ;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        finish.setOnAction(event -> {
            
            Product p = new Product(LabelText.getText(), PriceText.getText(), ImageText.getText(), DescriptionText.getText(), Type.getText(), Negociation.getText());
            ProductDao pdao = ProductDao.getInstance();
            pdao.insert(p);
        
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Personne insérée avec succés!");
        alert.show();
        nom.setText("");
        prenom.setText("");
        });
    }    
    
}
