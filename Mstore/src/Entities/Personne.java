/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Hayou
 */
public class Personne {
 
     private SimpleIntegerProperty id;
    private SimpleStringProperty nom;
    private SimpleStringProperty prenom;
    private SimpleStringProperty role;
    private SimpleStringProperty email;
    private SimpleStringProperty password;
    private SimpleStringProperty photo;
    private SimpleStringProperty Num_telephone;

    public Personne() {
    }

    public Personne(SimpleIntegerProperty id, SimpleStringProperty nom, SimpleStringProperty prenom, SimpleStringProperty role, SimpleStringProperty email, SimpleStringProperty password, SimpleStringProperty photo, SimpleStringProperty Num_telephone) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.role = role;
        this.email = email;
        this.password = password;
        this.photo = photo;
        this.Num_telephone = Num_telephone;
    }

    public Personne(String text, String text0, String text1, String text2, String text3, String text4, String text5) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o); //To change body of generated methods, choose Tools | Templates.
    }

   

    public Integer getId() {
        return id.get(); 
    }

    
    public String getNom() {
        return nom.get();
    }
     public String getPrenom() {
        return prenom.get();
    }
     public String getRole() {
        return role.get();
    }
     public String getEmail() {
        return email.get();
    }
      public String getPassword() {
        return password.get();
    }
       public String getPhoto() {
        return photo.get();
    }
        public String getNum_telephone() {
        return Num_telephone.get();
    }
        
      public SimpleStringProperty getEmailProperty() {
        return email;
    }
     public SimpleStringProperty getNomProperty() {
        return nom;
    }
    public SimpleStringProperty getNum_telephoneProperty() {
        return Num_telephone;
    }

    public SimpleStringProperty getPasswordProperty() {
        return password;
    }

    public SimpleStringProperty getPhotoProperty() {
        return photo;
    }

    public SimpleStringProperty getPrenomProperty() {
        return prenom;
    }

    public SimpleStringProperty getRoleProperty() {
        return role;
    }

    @Override
    public int hashCode() {
        return super.hashCode(); //To change body of generated methods, choose Tools | Templates.
    }

    public void setEmail(String email) {
        this.email = new SimpleStringProperty(email);
    }

    public void setId(Integer id) {
        this.id = new SimpleIntegerProperty(id);
    }

    public void setNom(String nom) {
        this.nom = new SimpleStringProperty(nom);
    }

    public void setNum_telephone(String Num_telephone) {
        this.Num_telephone = new SimpleStringProperty(Num_telephone);
    }

    public void setPassword(String password) {
        this.password = new SimpleStringProperty(password);
    }

    public void setPhoto(String photo) {
        this.photo = new SimpleStringProperty(photo);
    }

    public void setPrenom(String prenom) {
        this.prenom = new SimpleStringProperty(prenom);
    }

    public void setRole(String role) {
        this.role = new SimpleStringProperty(role);
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }
    
    

   

    

}
