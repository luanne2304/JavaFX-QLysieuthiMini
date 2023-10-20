/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlysieuthimain.DTO;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author luans
 */
public class DTO_KH {
    private final IntegerProperty ID_KH;
    private final StringProperty Ten_KH;
    private final StringProperty SDT;
    private final DoubleProperty  Tichluy;

    
    public DTO_KH()
    {
        ID_KH = new SimpleIntegerProperty(this, "ID_KH");
        Ten_KH = new SimpleStringProperty(this, "Ten_KH");
        SDT = new SimpleStringProperty(this, "SDT");
        Tichluy = new SimpleDoubleProperty(this, "Tichluy");

    }
    
    public DTO_KH(int id, String ten, String sdt,double tichluy){
        ID_KH= new SimpleIntegerProperty(id);
        Ten_KH=new SimpleStringProperty(ten);
        SDT= new SimpleStringProperty(sdt);
        Tichluy=new SimpleDoubleProperty(tichluy);

    }
    
    public IntegerProperty propertyID_KH() { return ID_KH; }
    public Integer getID_KH() { return ID_KH.get(); }
    public void setID_KH(Integer item) { ID_KH.set(item); }
    
    public StringProperty propertyTen_KH() { return Ten_KH; }
    public String getTen_KH() { return Ten_KH.get(); }
    public void setTen_KH(String item) { Ten_KH.set(item); }
    
    public StringProperty propertySDT() { return SDT; }
    public String getSDT() { return SDT.get(); }
    public void setSDT(String item) { SDT.set(item); }
    
    public DoubleProperty propertyTichluy() { return Tichluy; }
    public Double getTichluy() { return Tichluy.get(); }
    public void setTichluy(Double item) { Tichluy.set(item); }
      
}
