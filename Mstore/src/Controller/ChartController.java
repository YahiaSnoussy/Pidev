/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.PersonneDao;
import Entities.Personne;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;

/**
 * FXML Controller class
 *
 * @author Hayou
 */
public class ChartController implements Initializable {
@FXML
    private PieChart pieChart;
    ObservableList<PieChart.Data> list=FXCollections.
            observableArrayList();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    PersonneDao pdao=PersonneDao.getInstance();
        List<Personne> pers=pdao.displayAllList();
        for(Personne p:pers) {
            list.addAll(
                new PieChart.Data(p.getNom(), 12.0)             
        );
        }
        pieChart.setAnimated(true);
        pieChart.setData(list);
        
    }    
    
}
