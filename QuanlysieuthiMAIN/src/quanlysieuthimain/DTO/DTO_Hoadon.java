/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlysieuthimain.DTO;

import java.util.Date;

/**
 *
 * @author luans
 */
public class DTO_Hoadon {

    public DTO_Hoadon(int ID_Hoadon, int ID_Nhansu, int ID_KH, int ID_Magiam, String Phuongthucthanhtoan, Date Ngaylap, double Tongtien, double Thanhtien) {
        this.ID_Hoadon = ID_Hoadon;
        this.ID_Nhansu = ID_Nhansu;
        this.ID_KH = ID_KH;
        this.ID_Magiam = ID_Magiam;
        this.Phuongthucthanhtoan = Phuongthucthanhtoan;
        this.Ngaylap = Ngaylap;
        this.Tongtien = Tongtien;
        this.Thanhtien = Thanhtien;
    }

    public DTO_Hoadon() {
    }

    public int getID_Hoadon() {
        return ID_Hoadon;
    }

    public void setID_Hoadon(int ID_Hoadon) {
        this.ID_Hoadon = ID_Hoadon;
    }

    public int getID_Nhansu() {
        return ID_Nhansu;
    }

    public void setID_Nhansu(int ID_Nhansu) {
        this.ID_Nhansu = ID_Nhansu;
    }

    public int getID_KH() {
        return ID_KH;
    }

    public void setID_KH(int ID_KH) {
        this.ID_KH = ID_KH;
    }

    public int getID_Magiam() {
        return ID_Magiam;
    }

    public void setID_Magiam(int ID_Magiam) {
        this.ID_Magiam = ID_Magiam;
    }

    public String getPhuongthucthanhtoan() {
        return Phuongthucthanhtoan;
    }

    public void setPhuongthucthanhtoan(String Phuongthucthanhtoan) {
        this.Phuongthucthanhtoan = Phuongthucthanhtoan;
    }

    public Date getNgaylap() {
        return Ngaylap;
    }

    public void setNgaylap(Date Ngaylap) {
        this.Ngaylap = Ngaylap;
    }

    public double getTongtien() {
        return Tongtien;
    }

    public void setTongtien(double Tongtien) {
        this.Tongtien = Tongtien;
    }

    public double getThanhtien() {
        return Thanhtien;
    }

    public void setThanhtien(double Thanhtien) {
        this.Thanhtien = Thanhtien;
    }

  
    private int ID_Hoadon;
    private int ID_Nhansu;
    private int ID_KH;
    private int ID_Magiam;
    private String Phuongthucthanhtoan;
    private Date Ngaylap;
    private double Tongtien;
    private double Thanhtien;
    

    

    
    

  

}
