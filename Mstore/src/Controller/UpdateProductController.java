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
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import mstore.dao.ProductDao;
import mstore.entity.Product;

/**
 * FXML Controller class
 *
 * @author metal
 */
public class UpdateProductController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private Button update;
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
    private ListData listdata = new ListData();
    @FXML
    private TableView<Product> products;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        LabelText.setText(listdata.getProduct()
                .get(products.getSelectionModel().getSelectedIndex())
                .getLabel());
        PriceText.setText(String.valueOf(listdata.getProduct()
               .get(products.getSelectionModel().getSelectedIndex())
                .getPrice()));
        Type.setText(listdata.getProduct()
               .get(products.getSelectionModel().getSelectedIndex())
                .getType());
        Negociation.setText(listdata.getProduct()
                .get(products.getSelectionModel().getSelectedIndex())
                .getNegociation());
        DescriptionText.setText(listdata.getProduct()
                .get(products.getSelectionModel().getSelectedIndex())
                .getDescription());
        ImageText.setText(listdata.getProduct()
                .get(products.getSelectionModel().getSelectedIndex())
                .getImage());
        
        
        
        
        // TODO
        update.setOnAction(event -> {
            
            Product p = new Product(LabelText.getText(), PriceText.getText(), ImageText.getText(), DescriptionText.getText(), Type.getText(), Negociation.getText());
            ProductDao pdao = ProductDao.getInstance();
            pdao.UpdateProduct(p);
        
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Product was added successfully!");
        alert.show();
        LabelText.setText("");
        PriceText.setText("");
        ImageText.setText("");
        DescriptionText.setText("");
        Type.setText("");
        Negociation.setText("");
        });
    }    
    
}
