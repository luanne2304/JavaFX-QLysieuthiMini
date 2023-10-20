/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlysieuthimain.DTO;

/**
 *
 * @author luans
 */
public class DTO_CTHD {

    public DTO_CTHD(int ID_Sanpham, String Ten_Sanpham, int Sluong, double TongDonGia) {
        this.ID_Sanpham = ID_Sanpham;
        this.Ten_Sanpham = Ten_Sanpham;
        this.Sluong = Sluong;
        this.TongDonGia = TongDonGia;
    }

    public DTO_CTHD() {
    }

    public int getID_Sanpham() {
        return ID_Sanpham;
    }

    public void setID_Sanpham(int ID_Sanpham) {
        this.ID_Sanpham = ID_Sanpham;
    }

    public String getTen_Sanpham() {
        return Ten_Sanpham;
    }

    public void setTen_Sanpham(String Ten_Sanpham) {
        this.Ten_Sanpham = Ten_Sanpham;
    }

    public int getSluong() {
        return Sluong;
    }

    public void setSluong(int Sluong) {
        this.Sluong = Sluong;
    }

    public double getTongDonGia() {
        return TongDonGia;
    }

    public void setTongDonGia(double TongDonGia) {
        this.TongDonGia = TongDonGia;
    }
    private int ID_Sanpham;
    private String Ten_Sanpham;
    private int Sluong;
    private double TongDonGia;
}
