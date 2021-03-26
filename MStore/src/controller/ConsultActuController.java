/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.web.WebView;

/**
 * FXML Controller class
 *
 * @author willy
 */
public class ConsultActuController implements Initializable {

    @FXML
    private WebView actu;
    @FXML
    private TextField comment;
    @FXML
    private Button comEnvoyer;
    @FXML
    private Button imprimer;
    @FXML
    private Button partager;
    @FXML
    private Button like;
    @FXML
    private TextField searchTxt;
    @FXML
    private Button btnSearch;

    /**
     * Initializes the controller class.
     */
    //private ListData listdata = new ListData();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       // actu.set
    }    
    
}
