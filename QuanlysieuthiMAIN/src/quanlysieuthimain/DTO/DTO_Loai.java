/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlysieuthimain.DTO;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author luans
 */
public class DTO_Loai {
    private final IntegerProperty ID_Loai;
    private final StringProperty Ten_Loai;
    
    public DTO_Loai()
    {
        ID_Loai = new SimpleIntegerProperty(this, "ID_Loai");
        Ten_Loai = new SimpleStringProperty(this, "Ten_Loai");
    }
    
    public DTO_Loai(int ID,String NAME)
    {
        ID_Loai= new SimpleIntegerProperty(ID);
        Ten_Loai=new SimpleStringProperty(NAME);
    }
    
    public IntegerProperty propertyID_Loai() { return ID_Loai; }
    public Integer getID_Loai() { return ID_Loai.get(); }
    public void setID_Loai(Integer item) { ID_Loai.set(item); }
    
    public StringProperty propertyTen_Loai() { return Ten_Loai; }
    public String getTen_Loai() { return Ten_Loai.get(); }
    public void setTen_Loai(String item) { Ten_Loai.set(item); }
    
}
