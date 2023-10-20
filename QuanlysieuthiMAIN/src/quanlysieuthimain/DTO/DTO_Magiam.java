/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlysieuthimain.DTO;

/**
 *
 * @author luans
 */
public class DTO_Magiam {

    public DTO_Magiam() {
    }

    public DTO_Magiam(int ID_Magiam, String Ten_Magiam, int Chietkhau, boolean Trangthai) {
        this.ID_Magiam = ID_Magiam;
        this.Ten_Magiam = Ten_Magiam;
        this.Chietkhau = Chietkhau;
        this.Trangthai = Trangthai;
    }

    public int getID_Magiam() {
        return ID_Magiam;
    }

    public void setID_Magiam(int ID_Magiam) {
        this.ID_Magiam = ID_Magiam;
    }

    public String getTen_Magiam() {
        return Ten_Magiam;
    }

    public void setTen_Magiam(String Ten_Magiam) {
        this.Ten_Magiam = Ten_Magiam;
    }

    public int getChietkhau() {
        return Chietkhau;
    }

    public void setChietkhau(int Chietkhau) {
        this.Chietkhau = Chietkhau;
    }

    public boolean isTrangthai() {
        return Trangthai;
    }

    public void setTrangthai(boolean Trangthai) {
        this.Trangthai = Trangthai;
    }


    private int ID_Magiam;
    private String Ten_Magiam;
    private int Chietkhau;
    private boolean Trangthai;
}
