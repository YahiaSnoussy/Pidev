/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.PersonneDao;
import Entities.Personne;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Hayou
 */
public class AjouterPersonneController implements Initializable {

    @FXML
    private Button btn;
    @FXML
    private TextField nom;
    @FXML
    private TextField prenom;
     @FXML
    private TextField role;
      @FXML
    private TextField email;
       @FXML
    private TextField password;
        @FXML
    private TextField photo;
         @FXML
    private TextField num;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO     
        btn.setOnAction(event -> {
            
            Personne p = new Personne(nom.getText(), prenom.getText(), role.getText()
            , email.getText(), password.getText(), photo.getText(), num.getText());
            PersonneDao pdao = PersonneDao.getInstance();
            pdao.insert(p);
        
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Personne insérée avec succés!");
        alert.show();
        nom.setText("");
        prenom.setText("");
         role.setText("");
        email.setText("");
         password.setText("");
        photo.setText("");
        num.setText("");
        
        });
}}