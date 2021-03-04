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
public class user {
    
    private SimpleIntegerProperty id;
    private SimpleStringProperty nom;
    private SimpleStringProperty prenom;
    private SimpleStringProperty numtel;
    private SimpleStringProperty adresse;
    private SimpleStringProperty password;
    private SimpleStringProperty photo;
    private SimpleStringProperty role;

    public user() {
    }

    
    public user(int id, String nom, String prenom , String numtel , String adresse , String password , String photo ,String role) {
        this.id = new SimpleIntegerProperty(id);
        this.nom = new SimpleStringProperty(nom);
        this.prenom = new SimpleStringProperty(prenom);
        this.numtel = new SimpleStringProperty(numtel);
        this.adresse = new SimpleStringProperty(adresse);
        this.password = new SimpleStringProperty(password);
        this.photo = new SimpleStringProperty(photo);
        this.role = new SimpleStringProperty(role);
    }

    public user(String nom, String prenom , String numtel , String adresse , String password , String photo ,String role) {
        this.nom = new SimpleStringProperty(nom);
        this.prenom = new SimpleStringProperty(prenom);
        this.numtel = new SimpleStringProperty(numtel);
        this.adresse = new SimpleStringProperty(adresse);
        this.password = new SimpleStringProperty(password);
        this.photo = new SimpleStringProperty(photo);
        this.role = new SimpleStringProperty(role);
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
    public void setNumtel(String numtel) {
        this.numtel = new SimpleStringProperty(numtel);
    }
    public String getnumtel() {
        return numtel.get();  
    }
    public SimpleStringProperty getNumtelProperty(){
        return numtel;
    }
    public void setAdresse(String adresse) {
        this.adresse = new SimpleStringProperty(adresse);
    }
    public String getadresse() {
        return adresse.get();  
    }
    public SimpleStringProperty getAdresseProperty(){
        return adresse;
    }
    public void setPassword(String password) {
        this.password = new SimpleStringProperty(password);
    }
    public String getpassword() {
        return password.get();  
    }
    public SimpleStringProperty getPasswordProperty(){
        return password;
    }
    public void setPhoto(String photo) {
        this.photo = new SimpleStringProperty(photo);
    }
    public String getphoto() {
        return photo.get();  
    }
    public SimpleStringProperty getPhotoProperty(){
        return photo;
    }
    public void setRole(String role) {
        this.role = new SimpleStringProperty(role);
    }
    public String getrole() {
        return role.get();  
    }
    public SimpleStringProperty getRoleProperty(){
        return role;
    }
    
    @Override
    public String toString() {
        return "Personne{" + "id=" + id.get() + ", nom=" + nom.get() + ", prenom=" + prenom.get() + '}';
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
        final user other = (user) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
    
}
