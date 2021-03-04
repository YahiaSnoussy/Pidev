/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mstore.entity;

import java.util.Date;
import java.util.Objects;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author metal
 */
public class Product {
    private SimpleIntegerProperty ID ;
    private SimpleStringProperty Image ;
    private SimpleStringProperty Label ;
    private SimpleDoubleProperty Price ;
    private Date Date ;
    private SimpleStringProperty Type;
    private SimpleStringProperty Negociation ;
    private SimpleStringProperty Description ;

    public Product(SimpleIntegerProperty ID, SimpleStringProperty Image, SimpleStringProperty Label, SimpleDoubleProperty Price, Date Date, SimpleStringProperty Type, SimpleStringProperty Negociation, SimpleStringProperty Description) {
        this.ID = ID;
        this.Image = Image;
        this.Label = Label;
        this.Price = Price;
        this.Date = Date;
        this.Type = Type;
        this.Negociation = Negociation;
        this.Description = Description;
    }

    


    public Product() {
    }

    public int getID() {
        return ID.get();
    }

    public void setID(int ID) {
        this.ID = new SimpleIntegerProperty(ID);
    }

    public String getImage() {
        return Image.get();
    }

    public void setImage(String Image) {
        this.Image = new SimpleStringProperty(Image);
    }
    public SimpleStringProperty getImageProperty(){
        return Image;
    }

    public String getLabel() {
        return Label.get();
    }

    public void setLabel(String Label) {
        this.Label = new SimpleStringProperty(Label);
    }
    public SimpleStringProperty getLabelProperty(){
        return Label;
    }

    public double getPrice() {
        return Price.get();
    }

    public void setPrice(double Price) {
        this.Price = new SimpleDoubleProperty(Price);
    }

    public SimpleDoubleProperty getPriceProperty(){
        return Price;
    }
    public Date getDate() {
        return Date;
    }

    public void setDate(Date Date) {
        this.Date = Date;
    }

    public String getDescription() {
        return Description.get();
    }

    public void setDescription(String Description) {
        this.Description = new SimpleStringProperty(Description);
    }

    public SimpleStringProperty getDescriptionProperty(){
        return Image;
    }
    public String getType() {
        return Type.get();
    }

    public void setType(String Type) {
        this.Type = new SimpleStringProperty(Type);
    }

    public SimpleStringProperty getTypeProperty(){
        return Type;
    }
    public void setNegociation(String Negociation) {
        this.Negociation = new SimpleStringProperty(Negociation);
    }

    public String getNegociation() {
        return Negociation.get();
    }

    public SimpleStringProperty getNegociationProperty(){
        return Negociation;
    }
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.ID);
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
        final Product other = (Product) obj;
        if (!Objects.equals(this.ID, other.ID)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Product{"+"id"+ID+ ", Image=" + Image+", Label=" + Label+ ", Price=" + Price+ ", Date=" + Date+", Type=" + Type+", Negociation=" + Negociation+", Description=" + Description+'}';
    }

    
}
