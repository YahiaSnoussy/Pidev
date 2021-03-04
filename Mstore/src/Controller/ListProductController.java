/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mstore.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import mstore.dao.ProductDao;
import mstore.entity.Product;

/**
 * FXML Controller class
 *
 * @author metal
 */
public class ListProductController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TableView<Product> products;
    @FXML
    private TableColumn<Product, String> Image ;
    @FXML
    private TableColumn<Product, String> Label ;

    @FXML
    private Label IDLabel;
    @FXML
    private Label LabelLabel;
    @FXML
    private Label PriceLabel;
    @FXML
    private Label DateLabel;
    @FXML
    private Label TypeLabel;
    @FXML
    private Label NegociationLabel;
    @FXML
    private Label DescriptionLabel;
    @FXML
    private Button Btn_update ;
    @FXML
    private Button Btn_delete ;
    
    private ListData listdata = new ListData();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        products.setItems(listdata.getProduct());
        Image.setCellValueFactory(cell -> cell.
                getValue().getImageProperty());
        Label.setCellValueFactory(cell -> cell.
                getValue().getLabelProperty());
        products.setOnMouseClicked(event->{
        IDLabel.setText(String.valueOf(listdata.getProduct()
                .get(products.getSelectionModel().getSelectedIndex())
                .getID()));
        LabelLabel.setText(listdata.getProduct()
                .get(products.getSelectionModel().getSelectedIndex())
                .getLabel());
        PriceLabel.setText(String.valueOf(listdata.getProduct()
               .get(products.getSelectionModel().getSelectedIndex())
                .getPrice()));
        //DateLabel.setText(listdata.getProduct()
              // .get(products.getSelectionModel().getSelectedIndex())
             //   .getDate());
        TypeLabel.setText(listdata.getProduct()
                .get(products.getSelectionModel().getSelectedIndex())
                .getType());
        NegociationLabel.setText(listdata.getProduct()
                .get(products.getSelectionModel().getSelectedIndex())
                .getNegociation());
        DescriptionLabel.setText(listdata.getProduct()
                .get(products.getSelectionModel().getSelectedIndex())
                .getDescription());
        
        
    });  
        Btn_update.setOnAction(event->{
            try {
                System.out.println("testttttttttttttt");
                Parent pagePieChart=FXMLLoader.load(getClass().getResource("/mstore/view/Update.fxml"));
                Scene scene=new Scene(pagePieChart);
                Stage stage=(Stage) ((Node) event.getSource())
                        .getScene()
                        .getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(ListProductController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        Btn_delete.setOnAction(event->{
            Product p = new Product(Integer.parseInt(IDLabel.getText()));
            ProductDao pdao = ProductDao.getInstance();
            pdao.DeleteProduct(p);
        });
    
}
}
