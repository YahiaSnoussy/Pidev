/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Dao.ActuDao;
import entity.Actualite;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.web.HTMLEditor;

/**
 * FXML Controller class
 *
 * @author willy
 */
public class AjoutActuController implements Initializable {

    @FXML
    private HTMLEditor bodyActu;
    @FXML
    private DatePicker dateActu;
    @FXML
    private Button pubActu;
    @FXML
    private TextField categorie;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        pubActu.setOnAction(event -> { 
            Actualite A = new Actualite(dateActu.getValue().toString(), bodyActu.getHtmlText(), categorie.getText());
            ActuDao Adao = ActuDao.getInstance();
            Adao.insert(A);
        
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Actualité insérée avec succés!");
        alert.show();
        //nom.setText("");
        //prenom.setText("");
        });
    }    
    
}
