/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlysieuthimain.DTO;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
/**
 *
 * @author luans
 */
public class DTO_Taikhoan {

    public DTO_Taikhoan() {
    }

    public DTO_Taikhoan(int ID_Taikhoan, String Ten_Taikhoan, String Matkhau, int ID_Nhansu, String Ten_Nhansu, boolean Quyen, boolean Trangthai) {
        this.ID_Taikhoan = ID_Taikhoan;
        this.Ten_Taikhoan = Ten_Taikhoan;
        this.Matkhau = Matkhau;
        this.ID_Nhansu = ID_Nhansu;
        this.Ten_Nhansu = Ten_Nhansu;
        this.Quyen = Quyen;
        this.Trangthai = Trangthai;
    }

    public int getID_Taikhoan() {
        return ID_Taikhoan;
    }

    public void setID_Taikhoan(int ID_Taikhoan) {
        this.ID_Taikhoan = ID_Taikhoan;
    }

    public String getTen_Taikhoan() {
        return Ten_Taikhoan;
    }

    public void setTen_Taikhoan(String Ten_Taikhoan) {
        this.Ten_Taikhoan = Ten_Taikhoan;
    }

    public String getMatkhau() {
        return Matkhau;
    }

    public void setMatkhau(String Matkhau) {
        this.Matkhau = Matkhau;
    }

    public int getID_Nhansu() {
        return ID_Nhansu;
    }

    public void setID_Nhansu(int ID_Nhansu) {
        this.ID_Nhansu = ID_Nhansu;
    }

    public String getTen_Nhansu() {
        return Ten_Nhansu;
    }

    public void setTen_Nhansu(String Ten_Nhansu) {
        this.Ten_Nhansu = Ten_Nhansu;
    }

    public boolean isQuyen() {
        return Quyen;
    }

    public void setQuyen(boolean Quyen) {
        this.Quyen = Quyen;
    }

    public boolean isTrangthai() {
        return Trangthai;
    }

    public void setTrangthai(boolean Trangthai) {
        this.Trangthai = Trangthai;
    }
    private int ID_Taikhoan;
    private String Ten_Taikhoan;
    private String Matkhau;
    private int ID_Nhansu;
    private String Ten_Nhansu;
    private boolean  Quyen;
    private boolean Trangthai;
    

}
