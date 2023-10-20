/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlysieuthimain.DTO;

/**
 *
 * @author luans
 */
public class DTO_PhuongthucTT {

    public DTO_PhuongthucTT() {
    }

    public DTO_PhuongthucTT(int ID_Phuongthucthanhtoan, String Ten_Phuongthucthanhtoan) {
        this.ID_Phuongthucthanhtoan = ID_Phuongthucthanhtoan;
        this.Ten_Phuongthucthanhtoan = Ten_Phuongthucthanhtoan;
    }

    public int getID_Phuongthucthanhtoan() {
        return ID_Phuongthucthanhtoan;
    }

    public void setID_Phuongthucthanhtoan(int ID_Phuongthucthanhtoan) {
        this.ID_Phuongthucthanhtoan = ID_Phuongthucthanhtoan;
    }

    public String getTen_Phuongthucthanhtoan() {
        return Ten_Phuongthucthanhtoan;
    }

    public void setTen_Phuongthucthanhtoan(String Ten_Phuongthucthanhtoan) {
        this.Ten_Phuongthucthanhtoan = Ten_Phuongthucthanhtoan;
    }
    private int ID_Phuongthucthanhtoan;
    private String Ten_Phuongthucthanhtoan;
}
