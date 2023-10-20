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
public class DTO_Phieunhap {

    public DTO_Phieunhap() {
    }

    public DTO_Phieunhap(int ID_Phieunhap, int ID_Nhansu, Date Ngaynhap, double TongChi) {
        this.ID_Phieunhap = ID_Phieunhap;
        this.ID_Nhansu = ID_Nhansu;
        this.Ngaynhap = Ngaynhap;
        this.TongChi = TongChi;
    }

    public int getID_Phieunhap() {
        return ID_Phieunhap;
    }

    public void setID_Phieunhap(int ID_Phieunhap) {
        this.ID_Phieunhap = ID_Phieunhap;
    }

    public int getID_Nhansu() {
        return ID_Nhansu;
    }

    public void setID_Nhansu(int ID_Nhansu) {
        this.ID_Nhansu = ID_Nhansu;
    }

    public Date getNgaynhap() {
        return Ngaynhap;
    }

    public void setNgaynhap(Date Ngaynhap) {
        this.Ngaynhap = Ngaynhap;
    }

    public double getTongChi() {
        return TongChi;
    }

    public void setTongChi(double TongChi) {
        this.TongChi = TongChi;
    }
    private int ID_Phieunhap;
    private int ID_Nhansu;
    private Date Ngaynhap;
    private double TongChi;
}
