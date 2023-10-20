/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlysieuthimain.DTO;

/**
 *
 * @author luans
 */
public class DTO_CbBNhansu {

    public DTO_CbBNhansu() {
    }

    public DTO_CbBNhansu(int ID_Nhansu, String Ten_Nhansu) {
        this.ID_Nhansu = ID_Nhansu;
        this.Ten_Nhansu = Ten_Nhansu;
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
    private int ID_Nhansu;
    private String Ten_Nhansu;
}
