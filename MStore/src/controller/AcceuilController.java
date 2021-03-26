/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author willy
 */
public class AcceuilController implements Initializable {

    @FXML
    private Button btnAjout;
    @FXML
    private Button btnConsult;
    @FXML
    private Button btnMod;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        btnAjout.setOnAction(event -> {

            try {
                Parent page1 = FXMLLoader.load(getClass().getResource("/view/ajoutActu.fxml"));
                Scene scene = new Scene(page1);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(AjoutActuController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        btnConsult.setOnAction(event -> {
            try {
                Parent page2 = FXMLLoader.load(getClass().getResource("/view/consultActu.fxml"));
                Scene scene = new Scene(page2);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (Exception ex) {
                   System.out.println(ex + " hhh"); 
                   ex.printStackTrace();
            }
        });
        
        btnMod.setOnAction(event -> {
            try {
                Parent page3 = FXMLLoader.load(getClass().getResource("/view/modActu.fxml"));
                Scene scene = new Scene(page3);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(ModActuController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        
    }    
    
}
