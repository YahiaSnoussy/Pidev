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
 * @author riadh
 */
public class moderator {
     private SimpleIntegerProperty pswd;
    private SimpleStringProperty nom;
    private SimpleStringProperty prenom;

    public moderator() {
    }

    
    public moderator(int pswd, String nom, String prenom) {
        this.pswd = new SimpleIntegerProperty(pswd);
        this.nom = new SimpleStringProperty(nom);
        this.prenom = new SimpleStringProperty(prenom);
    }

    public moderator(String nom, String prenom) {
        this.nom = new SimpleStringProperty(nom);
        this.prenom = new SimpleStringProperty(prenom);
    }
    public int getPswd() {
        return pswd.get();
    }

    public void setPswd(int pswd) {
        this.pswd = new SimpleIntegerProperty(pswd);
    }

    public String getNom() {
        return nom.get();
    }

    public void setNom(String nom) {
        this.nom = new SimpleStringProperty(nom);
    }

    public String getPrenom() {
        return prenom.get();
    }
    public SimpleStringProperty getNomProperty(){
        return nom;
    }
    public SimpleStringProperty getPrenomProperty(){
        return prenom;
    }
    public void setPrenom(String prenom) {
        this.prenom = new SimpleStringProperty(prenom);
    }

    @Override
    public String toString() {
        return "moderator{" + "id=" + pswd.get() + ", nom=" + nom.get() + ", prenom=" + prenom.get() + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.pswd);
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
        final moderator other = (moderator) obj;
        if (!Objects.equals(this.pswd, other.pswd)) {
            return false;
        }
        return true;
    }
    
}
