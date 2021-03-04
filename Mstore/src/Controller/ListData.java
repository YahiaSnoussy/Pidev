/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mstore.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import mstore.dao.ProductDao;
import mstore.entity.Product;

/**
 *
 * @author metal
 */
public class ListData {
    private ObservableList<Product> product=FXCollections.observableArrayList();

    public ListData() {
        ProductDao pdao=ProductDao.getInstance();
        product= pdao.displayAll();
        System.out.println(product);
    }
    
    public ObservableList<Product> getProduct(){
        return product;
    }
}
