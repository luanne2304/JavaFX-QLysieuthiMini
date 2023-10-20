/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlysieuthimain.DTO;

/**
 *
 * @author luans
 */
public class DTO_TaoHD {
 
    private int ID_Sp;
    private String Ten_Sp;
    private int Sluong;
    private String DonViTinh;
    private double Dongia;
    private double Tongdongia;
    
    public DTO_TaoHD(int ID_Sp, String Ten_Sp, int Sluong, String DonViTinh, double Dongia, double Tongdongia) {
        this.ID_Sp = ID_Sp;
        this.Ten_Sp = Ten_Sp;
        this.Sluong = Sluong;
        this.DonViTinh = DonViTinh;
        this.Dongia = Dongia;
        this.Tongdongia = Tongdongia;
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

    public int getSluong() {
        return Sluong;
    }

    public void setSluong(int Sluong) {
        this.Sluong = Sluong;
    }

    public String getDonViTinh() {
        return DonViTinh;
    }

    public void setDonViTinh(String DonViTinh) {
        this.DonViTinh = DonViTinh;
    }

    public double getDongia() {
        return Dongia;
    }

    public void setDongia(double Dongia) {
        this.Dongia = Dongia;
    }

    public double getTongdongia() {
        return Tongdongia;
    }

    public void setTongdongia(double Tongdongia) {
        this.Tongdongia = Tongdongia;
    }

}
