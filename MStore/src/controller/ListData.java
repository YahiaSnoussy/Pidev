/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Dao.ActuDao;
import entity.Actualite;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author willy
 */
class ListData {
    private ObservableList<Actualite> actualite=FXCollections.observableArrayList();

    public ListData() {
        
        ActuDao pdao=ActuDao.getInstance();
        actualite= (ObservableList<Actualite>) pdao.displayAll();
        System.out.println(actualite);
    }
    
    public ObservableList<Actualite> getActu(){
        return actualite;
    }
    
}
