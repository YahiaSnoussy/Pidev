/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entities.Personne;
import java.util.List;



/**
 *
 * @author Hayou
 * 
 *  
 */
public interface IPersonne<Personne> {
    
  public void insert(Personne p);
    public void delete(Personne p);
    public List<Personne> displayAll();
    public Personne displayById(int id);
    
    public boolean update(Personne os);
    
}
