/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlysieuthimain.DTO;

/**
 *
 * @author luans
 */
public class DTO_CTPNhap {

    public DTO_CTPNhap() {
    }

    public DTO_CTPNhap(int ID_Phieunhap, int ID_Sanpham, int Soluong, double TongGiaNhap, String Ten_Sanpham) {
        this.ID_Phieunhap = ID_Phieunhap;
        this.ID_Sanpham = ID_Sanpham;
        this.Soluong = Soluong;
        this.TongGiaNhap = TongGiaNhap;
        this.Ten_Sanpham = Ten_Sanpham;
    }

    public int getID_Phieunhap() {
        return ID_Phieunhap;
    }

    public void setID_Phieunhap(int ID_Phieunhap) {
        this.ID_Phieunhap = ID_Phieunhap;
    }

    public int getID_Sanpham() {
        return ID_Sanpham;
    }

    public void setID_Sanpham(int ID_Sanpham) {
        this.ID_Sanpham = ID_Sanpham;
    }

    public int getSoluong() {
        return Soluong;
    }

    public void setSoluong(int Soluong) {
        this.Soluong = Soluong;
    }

    public double getTongGiaNhap() {
        return TongGiaNhap;
    }

    public void setTongGiaNhap(double TongGiaNhap) {
        this.TongGiaNhap = TongGiaNhap;
    }

    public String getTen_Sanpham() {
        return Ten_Sanpham;
    }

    public void setTen_Sanpham(String Ten_Sanpham) {
        this.Ten_Sanpham = Ten_Sanpham;
    }


    private int ID_Phieunhap;
    private int ID_Sanpham;
    private int Soluong;
    private double TongGiaNhap;
    private String Ten_Sanpham;
}
