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
public class DTO_Phieuxuat {

    public DTO_Phieuxuat() {
    }

    public DTO_Phieuxuat(int ID_Phieuxuat, int ID_Nhansu, Date Ngayxuat, double TongThu) {
        this.ID_Phieuxuat = ID_Phieuxuat;
        this.ID_Nhansu = ID_Nhansu;
        this.Ngayxuat = Ngayxuat;
        this.TongThu = TongThu;
    }

    public int getID_Phieuxuat() {
        return ID_Phieuxuat;
    }

    public void setID_Phieuxuat(int ID_Phieuxuat) {
        this.ID_Phieuxuat = ID_Phieuxuat;
    }

    public int getID_Nhansu() {
        return ID_Nhansu;
    }

    public void setID_Nhansu(int ID_Nhansu) {
        this.ID_Nhansu = ID_Nhansu;
    }

    public Date getNgayxuat() {
        return Ngayxuat;
    }

    public void setNgayxuat(Date Ngayxuat) {
        this.Ngayxuat = Ngayxuat;
    }

    public double getTongThu() {
        return TongThu;
    }

    public void setTongThu(double TongThu) {
        this.TongThu = TongThu;
    }
    private int ID_Phieuxuat;
    private int ID_Nhansu;
    private Date Ngayxuat;
    private double TongThu;
}
