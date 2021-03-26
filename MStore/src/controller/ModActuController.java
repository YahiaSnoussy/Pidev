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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.web.HTMLEditor;

/**
 * FXML Controller class
 *
 * @author willy
 */
public class ModActuController implements Initializable {

    @FXML
    private HTMLEditor actuView;
    @FXML
    private Button modBtn;
    @FXML
    private TextField searchTxt;
    @FXML
    private Button btnSearch;
    @FXML
    private TableView<Actualite> listTab;
    @FXML
    private Button supBtn;
    @FXML
    private TableColumn<Actualite, String> id_col;
    @FXML
    private TableColumn<Actualite, String> cat_col;
    @FXML
    private TableColumn<Actualite, String> date_col;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
     //private ListData listdata = new ListData();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //listTab.setItems(listdata.getActu());
        //id_col.setCellValueFactory(cell -> cell.getValue().getID_Actu());
       // id_col.setCellValueFactory(cell -> cell.getValue().);
        supBtn.setOnAction(event -> { 
            Actualite A = new Actualite(actuView.getHtmlText());
            ActuDao Adao = ActuDao.getInstance();
            Adao.delete(A);
        
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Actualité supprimée avec succés!");
        alert.show();
        //nom.setText("");
        //prenom.setText("");
        });
        
        modBtn.setOnAction(event -> { 
            Actualite A = new Actualite(actuView.getHtmlText());
            ActuDao Adao = ActuDao.getInstance();
            Adao.update(A);
        
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Actualité modifiee avec succés!");
        alert.show();
        });
    }    
    
}
