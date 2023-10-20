/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlysieuthimain.DTO;

/**
 *
 * @author luans
 */
public class DTO_Donvitinh {

    public DTO_Donvitinh() {
    }

    public DTO_Donvitinh(int ID_Donvitinh, String Donvitinh) {
        this.ID_Donvitinh = ID_Donvitinh;
        this.Donvitinh = Donvitinh;
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
    private int ID_Donvitinh;
    private String Donvitinh;
}
