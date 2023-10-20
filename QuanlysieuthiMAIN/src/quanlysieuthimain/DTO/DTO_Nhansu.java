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
public class DTO_Nhansu {

    public DTO_Nhansu() {
    }

    public DTO_Nhansu(int ID_Nhansu, String Ten_Nhansu, String SDT, String Mail, String CCCD, Date Ngayvaolam, Date Ngaysinh, String TenChucvu, boolean Trangthai) {
        this.ID_Nhansu = ID_Nhansu;
        this.Ten_Nhansu = Ten_Nhansu;
        this.SDT = SDT;
        this.Mail = Mail;
        this.CCCD = CCCD;
        this.Ngayvaolam = Ngayvaolam;
        this.Ngaysinh = Ngaysinh;
        this.TenChucvu = TenChucvu;
        this.Trangthai = Trangthai;
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

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getMail() {
        return Mail;
    }

    public void setMail(String Mail) {
        this.Mail = Mail;
    }

    public String getCCCD() {
        return CCCD;
    }

    public void setCCCD(String CCCD) {
        this.CCCD = CCCD;
    }

    public Date getNgayvaolam() {
        return Ngayvaolam;
    }

    public void setNgayvaolam(Date Ngayvaolam) {
        this.Ngayvaolam = Ngayvaolam;
    }

    public Date getNgaysinh() {
        return Ngaysinh;
    }

    public void setNgaysinh(Date Ngaysinh) {
        this.Ngaysinh = Ngaysinh;
    }

    public String getTenChucvu() {
        return TenChucvu;
    }

    public void setTenChucvu(String TenChucvu) {
        this.TenChucvu = TenChucvu;
    }

    public boolean isTrangthai() {
        return Trangthai;
    }

    public void setTrangthai(boolean Trangthai) {
        this.Trangthai = Trangthai;
    }
    private int ID_Nhansu;
    private String Ten_Nhansu;
    private String SDT;
    private String Mail;
    private String CCCD;
    private Date Ngayvaolam;
    private Date Ngaysinh;
    private String TenChucvu;
    private boolean Trangthai;
}
