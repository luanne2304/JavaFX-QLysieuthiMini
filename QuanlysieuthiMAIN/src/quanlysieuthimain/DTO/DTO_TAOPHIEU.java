/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlysieuthimain.DTO;

/**
 *
 * @author luans
 */
public class DTO_TAOPHIEU {

    public DTO_TAOPHIEU() {
    }

    public DTO_TAOPHIEU(int ID_Sp, String Ten_Sp, int Sluong, double Gia) {
        this.ID_Sp = ID_Sp;
        this.Ten_Sp = Ten_Sp;
        this.Sluong = Sluong;
        this.Gia = Gia;
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

    public double getGia() {
        return Gia;
    }

    public void setGia(double Gia) {
        this.Gia = Gia;
    }
    private int ID_Sp;
    private String Ten_Sp;
    private int Sluong;
    private double Gia;

}
