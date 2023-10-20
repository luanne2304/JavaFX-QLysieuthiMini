/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlysieuthimain.DTO;

/**
 *
 * @author luans
 */
public class DTO_Admin_SanPham {

    public DTO_Admin_SanPham() {
    }

    public DTO_Admin_SanPham(int ID_Sp, String Ten_Sp, int ID_Loai, String Ten_loai, double Gia, int Sluong, int ID_Donvitinh, String Donvitinh, Boolean Trangthai) {
        this.ID_Sp = ID_Sp;
        this.Ten_Sp = Ten_Sp;
        this.ID_Loai = ID_Loai;
        this.Ten_loai = Ten_loai;
        this.Gia = Gia;
        this.Sluong = Sluong;
        this.ID_Donvitinh = ID_Donvitinh;
        this.Donvitinh = Donvitinh;
        this.Trangthai = Trangthai;
    }

    public int getID_Sp() {
        return ID_Sp;
    }

    public void setID_Sp(int ID_Sp) {
        this.ID_Sp = ID_Sp;
    }

    public String getTen_Sp() {
        return Ten_Sp;
    }

    public void setTen_Sp(String Ten_Sp) {
        this.Ten_Sp = Ten_Sp;
    }

    public int getID_Loai() {
        return ID_Loai;
    }

    public void setID_Loai(int ID_Loai) {
        this.ID_Loai = ID_Loai;
    }

    public String getTen_loai() {
        return Ten_loai;
    }

    public void setTen_loai(String Ten_loai) {
        this.Ten_loai = Ten_loai;
    }

    public double getGia() {
        return Gia;
    }

    public void setGia(double Gia) {
        this.Gia = Gia;
    }

    public int getSluong() {
        return Sluong;
    }

    public void setSluong(int Sluong) {
        this.Sluong = Sluong;
    }

    public int getID_Donvitinh() {
        return ID_Donvitinh;
    }

    public void setID_Donvitinh(int ID_Donvitinh) {
        this.ID_Donvitinh = ID_Donvitinh;
    }

    public String getDonvitinh() {
        return Donvitinh;
    }

    public void setDonvitinh(String Donvitinh) {
        this.Donvitinh = Donvitinh;
    }

    public Boolean getTrangthai() {
        return Trangthai;
    }

    public void setTrangthai(Boolean Trangthai) {
        this.Trangthai = Trangthai;
    }
    private int ID_Sp;
    private String Ten_Sp;
    private int ID_Loai;
    private String Ten_loai;
    private double  Gia;
    private int  Sluong;
    private int  ID_Donvitinh;
    private String Donvitinh;
    private Boolean  Trangthai;
}
