/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlysieuthimain.DTO;

/**
 *
 * @author luans
 */
public class DTO_CTPXuat {

    public DTO_CTPXuat() {
    }

    public DTO_CTPXuat(int ID_Phieuxuat, int ID_Sanpham, int Soluong, double TongGiaXuat, String Ten_Sanpham) {
        this.ID_Phieuxuat = ID_Phieuxuat;
        this.ID_Sanpham = ID_Sanpham;
        this.Soluong = Soluong;
        this.TongGiaXuat = TongGiaXuat;
        this.Ten_Sanpham = Ten_Sanpham;
    }

    public int getID_Phieuxuat() {
        return ID_Phieuxuat;
    }

    public void setID_Phieuxuat(int ID_Phieuxuat) {
        this.ID_Phieuxuat = ID_Phieuxuat;
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

    public double getTongGiaXuat() {
        return TongGiaXuat;
    }

    public void setTongGiaXuat(double TongGiaXuat) {
        this.TongGiaXuat = TongGiaXuat;
    }

    public String getTen_Sanpham() {
        return Ten_Sanpham;
    }

    public void setTen_Sanpham(String Ten_Sanpham) {
        this.Ten_Sanpham = Ten_Sanpham;
    }
    private int ID_Phieuxuat;
    private int ID_Sanpham;
    private int Soluong;
    private double TongGiaXuat;
    private String Ten_Sanpham;
}
