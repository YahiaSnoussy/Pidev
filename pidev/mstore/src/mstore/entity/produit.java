/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mstore.entity;



import java.util.Objects;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author wiemhjiri
 */
public class produit {
    
    private SimpleIntegerProperty id;
    private SimpleStringProperty nom;
    private SimpleIntegerProperty prix;

    public produit() {
    }

    
    public produit(int id, String nom, Integer prix) {
        this.id = new SimpleIntegerProperty(id);
        this.nom = new SimpleStringProperty(nom);
        this.prix = new SimpleIntegerProperty(prix);
    }

    public produit(String nom, Integer prix) {
        this.nom = new SimpleStringProperty(nom);
        this.prix = new SimpleIntegerProperty(prix);
    }
    public int getId() {
        return id.get();
    }

    public void setId(int id) {
        this.id = new SimpleIntegerProperty(id);
    }

    public String getNom() {
        return nom.get();
    }

    public void setNom(String nom) {
        this.nom = new SimpleStringProperty(nom);
    }

    public Integer getprix() {
        return prix.get();
    }
    public SimpleStringProperty getNomProperty(){
        return nom;
    }
    public SimpleIntegerProperty getprixProperty(){
        return prix;
    }
    public void setprix(Integer prix) {
        this.prix = new SimpleIntegerProperty(prix);
    }

    @Override
    public String toString() {
        return "Produit{" + "id=" + id.get() + ", nom=" + nom.get() + ", prenom=" + prix.get() + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final produit other = (produit) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
    
}

