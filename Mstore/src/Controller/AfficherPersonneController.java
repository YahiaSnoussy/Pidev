/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entities.Personne;
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
 * @author Hayou
 */
public class AfficherPersonneController implements Initializable {

    @FXML
    private TableView<Personne> personsTable;
    @FXML
    private TableColumn<Personne, Integer> IdColonne;
    @FXML
    private TableColumn<Personne, String> NomColonne;
    @FXML
    private TableColumn<Personne, String> PrenomColonne;
    @FXML
    private TableColumn<Personne, String> RoleColonne;
    @FXML
    private TableColumn<Personne, String> EmailColonne;
    @FXML
    private TableColumn<Personne, String> PasswordColonne;
    @FXML
    private TableColumn<Personne, String> PhotoColonne;
    @FXML
    private TableColumn<Personne, String> Num_telColonne;
     @FXML
    private TableColumn<Personne, String> UpdateColonne;
    @FXML
    private TableColumn<Personne, String> DeleteColonne;
    
    @FXML
    private Button btn_chart;
    
     private ListData listdata = new ListData();
     
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
         personsTable.setItems(listdata.getPersons());
        
        NomColonne.setCellValueFactory(cell -> cell.
                getValue().getNomProperty());
        PrenomColonne.setCellValueFactory(cell -> cell.
                getValue().getPrenomProperty());
        RoleColonne.setCellValueFactory(cell -> cell.
                getValue().getRoleProperty());
        EmailColonne.setCellValueFactory(cell -> cell.
                getValue().getEmailProperty());
        PasswordColonne.setCellValueFactory(cell -> cell.
                getValue().getPasswordProperty());
        PhotoColonne.setCellValueFactory(cell -> cell.
                getValue().getPhotoProperty());
        Num_telColonne.setCellValueFactory(cell -> cell.
                getValue().getNum_telephoneProperty());
        
        
       
    
 btn_chart.setOnAction(event->{
            try {
                System.out.println("Liste des personnes");
                Parent pagePieChart=FXMLLoader.load(getClass().getResource("/mstore/view/Chart.fxml"));
                Scene scene=new Scene(pagePieChart);
                Stage stage=(Stage) ((Node) event.getSource())
                        .getScene()
                        .getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(AfficherPersonneController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }
    
    
}
