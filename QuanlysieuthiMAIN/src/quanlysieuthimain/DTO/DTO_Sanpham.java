/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlysieuthimain.DTO;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author luans
 */
public class DTO_Sanpham {
    private final IntegerProperty ID_Sp;
    private final StringProperty Ten_Sp;
    private final IntegerProperty ID_Loai;
    private final DoubleProperty  Gia;
    private final IntegerProperty  Sluong;
    private final IntegerProperty  ID_Donvitinh;
    private final BooleanProperty  Trangthai;
    
    public DTO_Sanpham()
    {
        ID_Sp = new SimpleIntegerProperty(this, "ID_Sp");
        Ten_Sp = new SimpleStringProperty(this, "Ten_Sp");
        ID_Loai = new SimpleIntegerProperty(this, "ID_Loai");
        Gia = new SimpleDoubleProperty(this, "Gia");
        Sluong = new SimpleIntegerProperty(this, "Sluong");
        ID_Donvitinh = new SimpleIntegerProperty(this, "ID_Donvitinh");
        Trangthai = new SimpleBooleanProperty(this, "Trangthai");
    }
    
    public DTO_Sanpham(int id, String ten, int loai,double price, int sl,int dvt,boolean status){
        ID_Sp= new SimpleIntegerProperty(id);
        Ten_Sp=new SimpleStringProperty(ten);
        ID_Loai= new SimpleIntegerProperty(loai);
        Gia=new SimpleDoubleProperty(price);
        Sluong= new SimpleIntegerProperty(sl);
        ID_Donvitinh=new SimpleIntegerProperty(dvt);
        Trangthai= new SimpleBooleanProperty(status);

    }
    
    public IntegerProperty propertyID_Sp() { return ID_Sp; }
    public Integer getID_Sp() { return ID_Sp.get(); }
    public void setID_Sp(Integer item) { ID_Sp.set(item); }
    
    public StringProperty propertyTen_Sp() { return Ten_Sp; }
    public String getTen_Sp() { return Ten_Sp.get(); }
    public void setTen_Sp(String item) { Ten_Sp.set(item); }
    
    public IntegerProperty propertyID_Loai() { return ID_Loai; }
    public Integer getID_Loai() { return ID_Loai.get(); }
    public void setID_Loai(Integer item) { ID_Loai.set(item); }
    
    public DoubleProperty propertyGia() { return Gia; }
    public Double getGia() { return Gia.get(); }
    public void setGia(Double item) { Gia.set(item); }
    
    public IntegerProperty propertySluong() { return Sluong; }
    public Integer getSluong() { return Sluong.get(); }
    public void setSluong(Integer item) { Sluong.set(item); }
    
    public IntegerProperty propertyID_Donvitinh() { return ID_Donvitinh; }
    public Integer getID_Donvitinh() { return ID_Donvitinh.get(); }
    public void setID_Donvitinh(Integer item) { ID_Donvitinh.set(item); }
    
    public BooleanProperty propertyTrangthai() { return Trangthai; }
    public Boolean getTrangthai() { return Trangthai.get(); }
    public void setTrangthai(Boolean item) { Trangthai.set(item); }
}
