/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author Hayou
 */
public class Personne {
 
     private int id;
    private String nom;
    private String prenom;
    private String role;
    private String email;
    private String password;
    private String photo;
    private String Num_telephone;

    public Personne() {
    }

    public Personne(int id) {
        this.id = id;
    }

    public Personne(int id, String nom, String prenom, String role, String email, String password, String photo, String Num_telephone) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.role = role;
        this.email = email;
        this.password = password;
        this.photo = photo;
        this.Num_telephone = Num_telephone;
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o); //To change body of generated methods, choose Tools | Templates.
    }

    public String getEmail() {
        return email;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getNum_telephone() {
        return Num_telephone;
    }

    public String getPassword() {
        return password;
    }

    public String getPhoto() {
        return photo;
    }

    public String getPrenom() {
        return prenom;
    }

    @Override
    public int hashCode() {
        return super.hashCode(); //To change body of generated methods, choose Tools | Templates.
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setNum_telephone(String Num_telephone) {
        this.Num_telephone = Num_telephone;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); //To change body of generated methods, choose Tools | Templates.
    }

    

    

}
