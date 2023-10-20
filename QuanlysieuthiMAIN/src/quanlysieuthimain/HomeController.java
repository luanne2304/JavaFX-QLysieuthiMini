/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package quanlysieuthimain;

import static java.lang.Double.parseDouble;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.MouseEvent;
import javafx.util.StringConverter;
import quanlysieuthimain.DTO.DTO_KH;
import quanlysieuthimain.DTO.DTO_Loai;
import quanlysieuthimain.DTO.DTO_Sanpham;
import quanlysieuthimain.DTO.DTO_TaoHD;
import java.util.logging.Logger;
import java.util.logging.Level;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableRow;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import quanlysieuthimain.DTO.DTO_CTHD;
import quanlysieuthimain.DTO.DTO_CTPNhap;
import quanlysieuthimain.DTO.DTO_CTPXuat;
import quanlysieuthimain.DTO.DTO_Hoadon;
import quanlysieuthimain.DTO.DTO_Magiam;
import quanlysieuthimain.DTO.DTO_Phieunhap;
import quanlysieuthimain.DTO.DTO_Phieuxuat;
import quanlysieuthimain.DTO.DTO_TAOPHIEU;

/**
 * FXML Controller class
 *
 * @author luans
 */
public class HomeController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private Button BTN_QUANLY;
    
    @FXML
    private Label Util_LB_INFO;

    @FXML
    private TableColumn<DTO_Phieunhap, Integer> DSPN_Col_IDNhansu;

    @FXML
    private TableColumn<DTO_Phieunhap, Integer> DSPN_Col_IDphieu;

    @FXML
    private TableColumn<DTO_CTPNhap, Integer> DSPN_Col_IDsp;

    @FXML
    private TableColumn<DTO_Phieunhap, Date> DSPN_Col_Ngay;

    @FXML
    private TableColumn<DTO_CTPNhap, Integer> DSPN_Col_Sluong;

    @FXML
    private TableColumn<DTO_CTPNhap, String> DSPN_Col_TenSP;

    @FXML
    private TableColumn<DTO_Phieunhap, Double> DSPN_Col_TongChi;

    @FXML
    private TableColumn<DTO_CTPNhap, Double> DSPN_Col_Tongdongia;

    @FXML
    private DatePicker DSPN_DP_denngay;

    @FXML
    private DatePicker DSPN_DP_tungay;

    @FXML
    private TextField DSPN_TF_TimPN;

    @FXML
    private TextField DSPN_TF_Tongchi;

    @FXML
    private TableView<DTO_CTPNhap> DSPN_TV_CCPN;

    @FXML
    private TableView<DTO_Phieunhap> DSPN_TV_PN;

    @FXML
    private TableColumn<DTO_Phieuxuat, Integer> DSPX_Col_IDNhansu;

    @FXML
    private TableColumn<DTO_Phieuxuat, Integer> DSPX_Col_IDphieu;

    @FXML
    private TableColumn<DTO_CTPXuat, Integer> DSPX_Col_IDsp;

    @FXML
    private TableColumn<DTO_Phieuxuat, Date> DSPX_Col_Ngay;

    @FXML
    private TableColumn<DTO_CTPXuat, Integer> DSPX_Col_Sluong;

    @FXML
    private TableColumn<DTO_CTPXuat, String> DSPX_Col_TenSP;

    @FXML
    private TableColumn<DTO_Phieuxuat, Double> DSPX_Col_TongThu;

    @FXML
    private TableColumn<DTO_CTPXuat, Double> DSPX_Col_Tongdongia;

    @FXML
    private DatePicker DSPX_DP_denngay;

    @FXML
    private DatePicker DSPX_DP_tungay;

    @FXML
    private TextField DSPX_TF_TimPX;

    @FXML
    private TextField DSPX_TF_TongThu;

    @FXML
    private TableView<DTO_CTPXuat> DSPX_TV_CTPX;

    @FXML
    private TableView<DTO_Phieuxuat> DSPX_TV_PX;

    @FXML
    private TableColumn<DTO_KH, Integer> KH_Col_IDKH;

    @FXML
    private TableColumn<DTO_KH, String> KH_Col_SDT;

    @FXML
    private TableColumn<DTO_KH, String> KH_Col_TenKH;

    @FXML
    private TableColumn<DTO_KH, Double> KH_Col_Tichluy;

    @FXML
    private TextField KH_TF_SDT;

    @FXML
    private TextField KH_TF_Ten;

    @FXML
    private TextField KH_TF_TimKH;

    @FXML
    private TableView<DTO_KH> KH_TV_DsachKH;

    @FXML
    private ToggleGroup Phieu;

    @FXML
    private ToggleGroup PTTT;

    @FXML
    private TableColumn<DTO_Hoadon, Integer> QLHD_Col_IDHD;

    @FXML
    private TableColumn<DTO_Hoadon, Integer> QLHD_Col_IDKH;

    @FXML
    private TableColumn<DTO_Hoadon, Integer> QLHD_Col_IDNS;

    @FXML
    private TableColumn<DTO_Hoadon, Integer> QLHD_Col_IDMagiam;

    @FXML
    private TableColumn<DTO_CTHD, Integer> QLHD_Col_IDSP;

    @FXML
    private TableColumn<DTO_Hoadon, Date> QLHD_Col_Ngay;

    @FXML
    private TableColumn<DTO_CTHD, Integer> QLHD_Col_Sluong;

    @FXML
    private TableColumn<DTO_CTHD, String> QLHD_Col_TenSP;

    @FXML
    private TableColumn<DTO_Hoadon, Double> QLHD_Col_Thanhtien;

    @FXML
    private TableColumn<DTO_Hoadon, String> QLHD_Col_Thanhtoan;

    @FXML
    private TableColumn<DTO_CTHD, Double> QLHD_Col_Tongdongia;

    @FXML
    private TableColumn<DTO_Hoadon, Double> QLHD_Col_Tongtien;

    @FXML
    private DatePicker QLHD_DP_Denngay;

    @FXML
    private DatePicker QLHD_DP_Tungay;

    @FXML
    private TextField QLHD_TF_Doanhthu;

    @FXML
    private TextField QLHD_TF_TimHD;

    @FXML
    private TableView<DTO_CTHD> QLHD_TV_CTHD;

    @FXML
    private TableView<DTO_Hoadon> QLHD_TV_HD;

    @FXML
    private ComboBox<DTO_Sanpham> THD_CbB_TenSP;

    @FXML
    private ComboBox<DTO_Loai> THD_CbB_LoaiSP;

    @FXML
    private ComboBox<DTO_Magiam> THD_CbB_Magiam;

    @FXML
    private TableColumn<DTO_TaoHD, Double> THD_Col_Dongia;

    @FXML
    private TableColumn<DTO_TaoHD, String> THD_Col_Donvitinh;

    @FXML
    private TableColumn<DTO_TaoHD, Integer> THD_Col_IDsp;

    @FXML
    private TableColumn<DTO_TaoHD, Integer> THD_Col_Sl;

    @FXML
    private TableColumn<DTO_TaoHD, String> THD_Col_TenSP;

    @FXML
    private TableColumn<DTO_TaoHD, Double> THD_Col_Tongdongia;

    @FXML
    private Spinner<Integer> THD_Spn_SL;

    @FXML
    private TextField THD_TF_Magiam;

    @FXML
    private TextField THD_TF_SDTKH;

    @FXML
    private TextField THD_TF_Tongtien;

    @FXML
    private TableView<DTO_TaoHD> THD_TV_ChitietHD;

    @FXML
    private ComboBox<DTO_Loai> TPNX_CbB_LoaiSP;

    @FXML
    private ComboBox<DTO_Sanpham> TPNX_CbB_TenSP;

    @FXML
    private TableColumn<DTO_Sanpham, Double> TPNX_Col_GIA;

    @FXML
    private TableColumn<DTO_Sanpham, Integer> TPNX_Col_IDSP;

    @FXML
    private TableColumn<DTO_Sanpham, Integer> TPNX_Col_Sluong;

    @FXML
    private TableColumn<DTO_Sanpham, String> TPNX_Col_TENSP;

    @FXML
    private TableColumn<DTO_TAOPHIEU, Double> TPNX_Col_TaoPhieuGia;

    @FXML
    private TableColumn<DTO_TAOPHIEU, Integer> TPNX_Col_TaoPhieuSluong;

    @FXML
    private TableColumn<DTO_TAOPHIEU, String> TPNX_Col_TaoPhieuTenSP;

    @FXML
    private TableColumn<DTO_Sanpham, Boolean> TPNX_Col_Trangthai;

    @FXML
    private RadioButton TPNX_RdB_Nhap;

    @FXML
    private RadioButton TPNX_RdB_Xuat;

    @FXML
    private Spinner<Integer> TPNX_Spn_Sluong;

    @FXML
    private TextField TPNX_TF_Gia;

    @FXML
    private TextField TPNX_TF_TimSP;

    @FXML
    private TableView<DTO_Sanpham> TPNX_TV_DsachSP;

    @FXML
    private TableView<DTO_TAOPHIEU> TPNX_TV_TaoPhieu;

    @FXML
    private TabPane TP_HD;

    @FXML
    private TabPane TP_KH;

    @FXML
    private TabPane TP_PhieuNX;

    

    @FXML
    void Onclick_Btn_Logout(ActionEvent event) {
        
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
            Scene scene = new Scene(root);

            // Set the Login scene on the primary stage and show it
            primaryStage.setScene(scene);
            primaryStage.setTitle("Login Screen");
            
            primaryStage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    void DSPX_TimPX(KeyEvent event) {
        String timhd = DSPX_TF_TimPX.getText().toLowerCase();
        FilteredList<DTO_Phieuxuat> filteredData = new FilteredList<>(lstPXuat, p -> true);
        filteredData.setPredicate(hd -> {
            // Nếu không có từ khóa tìm kiếm, hiển thị tất cả dữ liệu
            
            lstCTPXuat.clear();
            DSPX_TV_CTPX.setItems(lstCTPXuat);
            
            if (timhd == null || timhd.isEmpty()) {
                return true;
            }

            if (String.valueOf(hd.getID_Phieuxuat()).toLowerCase().contains(timhd)
                    || String.valueOf(hd.getID_Nhansu()).toLowerCase().contains(timhd)
                    || String.valueOf(hd.getNgayxuat()).toLowerCase().contains(timhd)) {
                return true;
            }

            return false;
        });
        // Tạo một SortedList để sắp xếp dữ liệu và áp dụng bộ lọc tìm kiếm
        SortedList<DTO_Phieuxuat> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(DSPX_TV_PX.comparatorProperty());
        DSPX_TV_PX.setItems(sortedData);
    }

    @FXML
    void onClick_Btn_LocPhieuXuat(ActionEvent event) {
        if (DSPX_DP_tungay.getValue() != null && DSPX_DP_denngay.getValue() != null) {
            lstCTPXuat.clear();
            DSPX_TV_CTPX.setItems(lstCTPXuat);
            String tu = DSPX_DP_tungay.getValue().toString();
            String den = DSPX_DP_denngay.getValue().toString();
            LoadTablePXuat(tu, den);
        }
    }

    @FXML
    void onClick_Btn_LammoiPhieuXuat(ActionEvent event) {
        LoadTablePXuat(null, null);
        lstCTPXuat.clear();
        DSPX_TV_CTPX.setItems(lstCTPXuat);
    }

    @FXML
    void DSPN_TimPN(KeyEvent event) {
        String timhd = DSPN_TF_TimPN.getText().toLowerCase();
        FilteredList<DTO_Phieunhap> filteredData = new FilteredList<>(lstPNhap, p -> true);
        filteredData.setPredicate(hd -> {
            
            lstCTPNhap.clear();
            DSPN_TV_CCPN.setItems(lstCTPNhap);
            
            // Nếu không có từ khóa tìm kiếm, hiển thị tất cả dữ liệu
            if (timhd == null || timhd.isEmpty()) {
                return true;
            }

            if (String.valueOf(hd.getID_Phieunhap()).toLowerCase().contains(timhd)
                    || String.valueOf(hd.getID_Nhansu()).toLowerCase().contains(timhd)
                    || String.valueOf(hd.getNgaynhap()).toLowerCase().contains(timhd)) {
                return true;
            }

            return false;
        });
        // Tạo một SortedList để sắp xếp dữ liệu và áp dụng bộ lọc tìm kiếm
        SortedList<DTO_Phieunhap> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(DSPN_TV_PN.comparatorProperty());
        DSPN_TV_PN.setItems(sortedData);
    }

    @FXML
    void onClick_Btn_LammoiPhieuNhap(ActionEvent event) {
        LoadTablePNhap(null, null);
        lstCTPNhap.clear();
        DSPN_TV_CCPN.setItems(lstCTPNhap);
    }

    @FXML
    void onClick_Btn_LocPhieuNhap(ActionEvent event) {
        if (DSPN_DP_tungay.getValue() != null && DSPN_DP_denngay.getValue() != null) {
            lstCTPNhap.clear();
            DSPN_TV_CCPN.setItems(lstCTPNhap);
            String tu = DSPN_DP_tungay.getValue().toString();
            String den = DSPN_DP_denngay.getValue().toString();
            LoadTablePNhap(tu, den);
        }
    }

    @FXML
    void TPNX_TimSP(KeyEvent event) {
        String timhd = TPNX_TF_TimSP.getText().toLowerCase();
        FilteredList<DTO_Sanpham> filteredData = new FilteredList<>(lstSanphamTPNX, p -> true);
        filteredData.setPredicate(hd -> {
            // Nếu không có từ khóa tìm kiếm, hiển thị tất cả dữ liệu
            if (timhd == null || timhd.isEmpty()) {
                return true;
            }

            if (String.valueOf(hd.getID_Sp()).toLowerCase().contains(timhd)
                    || hd.getTen_Sp().toLowerCase().contains(timhd)) {
                return true;
            }

            return false;
        });
        // Tạo một SortedList để sắp xếp dữ liệu và áp dụng bộ lọc tìm kiếm
        SortedList<DTO_Sanpham> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(TPNX_TV_DsachSP.comparatorProperty());
        TPNX_TV_DsachSP.setItems(sortedData);
    }

    @FXML
    void onSelectedLoai_TPNX(ActionEvent event) {
        DTO_Loai selectedLoai = TPNX_CbB_LoaiSP.getValue();
        if (selectedLoai != null) {
            int IDLoai = selectedLoai.getID_Loai();
            try {
                TPNX_CbB_TenSP.getItems().clear();
                String sql = "SELECT * FROM sanpham Where ID_Loai = ? ";
                pst = con.prepareStatement(sql);
                pst.setInt(1, IDLoai);
                ResultSet rs = pst.executeQuery();
                while (rs.next()) {
                    int ID_Sp = rs.getInt("ID_Sp");
                    String Ten_Sp = rs.getString("Ten_Sp");
                    int ID_Loai = rs.getInt("ID_Loai");
                    double Gia = rs.getDouble("Gia");
                    int Sluong = rs.getInt("Sluong");
                    int ID_Donvitinh = rs.getInt("ID_Donvitinh");
                    boolean Trangthai = rs.getBoolean("Trangthai");
                    DTO_Sanpham item = new DTO_Sanpham(ID_Sp, Ten_Sp, ID_Loai, Gia, Sluong, ID_Donvitinh, Trangthai);
                    TPNX_CbB_TenSP.getItems().add(item);
                    TPNX_CbB_TenSP.setCellFactory(param -> new ListCell<DTO_Sanpham>() {
                        @Override
                        protected void updateItem(DTO_Sanpham item, boolean empty) {
                            super.updateItem(item, empty);
                            if (empty || item == null) {
                                setText(null);
                            } else {
                                setText(item.getTen_Sp());
                            }
                        }
                    });
                    TPNX_CbB_TenSP.setConverter(new StringConverter<DTO_Sanpham>() {
                        @Override
                        public String toString(DTO_Sanpham item) {
                            if (item == null) {
                                return null;
                            } else {
                                return item.getTen_Sp();
                            }
                        }

                        @Override
                        public DTO_Sanpham fromString(String string) {
                            // Not used
                            return null;
                        }
                    });
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    void onClick_Btn_TaoPhieu(ActionEvent event) {
        RadioButton selectedRadioButton = (RadioButton) Phieu.getSelectedToggle();
        String selectedValue = selectedRadioButton.getText();
        double tongtien = 0;
        if (!lstTPhieu.isEmpty()) {
            try {
                if (selectedValue.equals("Phiếu nhập")) {
                    String sql1 = "INSERT INTO phieunhap(ID_Nhansu,Ngaynhap,TongChi) VALUES (?,CURDATE(),0)";
                    pst = con.prepareStatement(sql1);
                    pst.setInt(1, userID);
                    pst.executeUpdate();

                    String sql2 = "SELECT LAST_INSERT_ID()";
                    pst = con.prepareStatement(sql2);
                    ResultSet rs2 = pst.executeQuery();
                    String idphieu = "aa";
                    if (rs2.next()) {
                        idphieu = rs2.getString("LAST_INSERT_ID()");
                    }

                    for (DTO_TAOPHIEU item : lstTPhieu) {
                        int tempIDsp = item.getID_Sp();
                        int tempSl = item.getSluong();
                        double tempTien = item.getGia();
                        String sql3 = "INSERT INTO chitietphieunhap(ID_Phieunhap,ID_Sanpham,Soluong,TongGiaNhap) VALUES (?,?,?,?)";
                        pst = con.prepareStatement(sql3);
                        pst.setString(1, idphieu);
                        pst.setInt(2, tempIDsp);
                        pst.setInt(3, tempSl);
                        pst.setDouble(4, tempTien);
                        pst.executeUpdate();
                        tongtien = tongtien + tempTien;
                    }
                    String sql4 = "Update phieunhap set TongChi =? where ID_Phieunhap=? ";
                    pst = con.prepareStatement(sql4);
                    pst.setDouble(1, tongtien);
                    pst.setString(2, idphieu);
                    pst.executeUpdate();
                    try {
                        String sql5 = "{CALL sp_xacnhanPhieunhap(?)}";
                        pst = con.prepareStatement(sql5);
                        pst.setString(1, idphieu);
                        pst.executeUpdate();
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Thông báo");
                        alert.setHeaderText("Tạo phiếu thành công!");
                        alert.setContentText("Tổng chi tiêu là: " + tongtien);
                        LoadTablePNhap(null, null);
                        alert.showAndWait();
                        lstTPhieu.clear();
                        LoadTableTPhieu();
                        LoadTableDsachSP_TPNX();
                    } catch (SQLException e) {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("LỖI");
                        alert.setHeaderText("Ko rõ lỗi");
                        alert.showAndWait();
                    }
                } else {
                    int countSL=0;
                    String messSL="";
                    for (DTO_TAOPHIEU item : lstTPhieu) {
                            int tempIDsp = item.getID_Sp();
                            int tempSl = item.getSluong();
                            String sql = "Select * from sanpham where ID_Sp=? and Sluong>=? ";
                            pst = con.prepareStatement(sql);
                            pst.setInt(1, tempIDsp);
                            pst.setInt(2, tempSl);
                            ResultSet rsSL =pst.executeQuery();
                            if(!rsSL.next()){
                                countSL=1;
                                messSL +="Sản phẩm: "+item.getTen_Sp()+" ko đủ sô lượng trong kho!\n";
                            }
                    }
                    if(countSL==1){
                        Alert alert = new Alert(Alert.AlertType.WARNING);
                        alert.setTitle("Thông báo");
                        alert.setHeaderText("Lỗi số lượng");
                        alert.setContentText(messSL);
                        alert.showAndWait();
                        return;
                    }
                    String sql1 = "INSERT INTO phieuxuat(ID_Nhansu,Ngayxuat,TongThu) VALUES (1,CURDATE(),0)";
                    pst = con.prepareStatement(sql1);
                    pst.executeUpdate();

                    String sql2 = "SELECT LAST_INSERT_ID()";
                    pst = con.prepareStatement(sql2);
                    ResultSet rs2 = pst.executeQuery();
                    String idphieu = "aa";
                    if (rs2.next()) {
                        idphieu = rs2.getString("LAST_INSERT_ID()");
                    }

                    for (DTO_TAOPHIEU item : lstTPhieu) {
                        int tempIDsp = item.getID_Sp();
                        int tempSl = item.getSluong();
                        double tempTien = item.getGia();
                        String sql3 = "INSERT INTO chitietphieuxuat(ID_Phieuxuat,ID_Sanpham,Soluong,TongGiaXuat) VALUES (?,?,?,?)";
                        pst = con.prepareStatement(sql3);
                        pst.setString(1, idphieu);
                        pst.setInt(2, tempIDsp);
                        pst.setInt(3, tempSl);
                        pst.setDouble(4, tempTien);
                        pst.executeUpdate();
                        tongtien = tongtien + tempTien;
                    }
                    String sql4 = "Update phieuxuat set TongThu =? where ID_Phieuxuat=? ";
                    pst = con.prepareStatement(sql4);
                    pst.setDouble(1, tongtien);
                    pst.setString(2, idphieu);
                    pst.executeUpdate();
                    try {
                        String sql5 = "{CALL sp_xacnhanPhieuxuat(?)}";
                        pst = con.prepareStatement(sql5);
                        pst.setString(1, idphieu);
                        pst.executeUpdate();
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Thông báo");
                        alert.setHeaderText("Tạo phiếu thành công!");
                        alert.setContentText("Tổng tiền thu là: " + tongtien);
                        alert.showAndWait();
                        lstTPhieu.clear();
                        LoadTableTPhieu();
                        LoadTablePXuat(null, null);
                        LoadTableDsachSP_TPNX();
                    } catch (SQLException e) {
                        String sql6 = "DELETE FROM chitietphieuxuat WHERE ID_Phieuxuat=?";
                        pst = con.prepareStatement(sql6);
                        pst.setString(1, idphieu);
                        pst.executeUpdate();
                        String sql7 = "DELETE FROM phieuxuat WHERE ID_Phieuxuat=?";
                        pst = con.prepareStatement(sql7);
                        pst.setString(1, idphieu);
                        pst.executeUpdate();
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Thông báo");
                        alert.setHeaderText("Tạo phiếu Thất bại!");
                        alert.setContentText("Số lượng hàng trong kho ko đủ để xuất ");
                        alert.showAndWait();
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
        }
    }

    @FXML
    void onClick_Btn_themSPvaoPhieu(ActionEvent event) {

        DTO_Sanpham selectedSP = TPNX_CbB_TenSP.getValue();
        if (selectedSP != null) {
            if (!TPNX_TF_Gia.getText().isEmpty()) {
                int IDSP = selectedSP.getID_Sp();
                String Ten_sp = selectedSP.getTen_Sp();
                int Sluong = TPNX_Spn_Sluong.getValue();
                double gia = parseDouble(TPNX_TF_Gia.getText());
                DTO_TAOPHIEU item = new DTO_TAOPHIEU(IDSP, Ten_sp, Sluong, gia);
                lstTPhieu.removeIf(check -> check.getID_Sp() == IDSP);
                lstTPhieu.add(item);
                lstTPhieu.removeIf(check -> check.getSluong() == 0);
                LoadTableTPhieu();
            }
        }
    }

    @FXML
    void QLHD_TimHD(KeyEvent event) {
        String timhd = QLHD_TF_TimHD.getText().toLowerCase();
        FilteredList<DTO_Hoadon> filteredData = new FilteredList<>(lstHD, p -> true);
        filteredData.setPredicate(hd -> {
            // Nếu không có từ khóa tìm kiếm, hiển thị tất cả dữ liệu
            lstCTHD.clear();
            QLHD_TV_CTHD.setItems(lstCTHD);
            
            if (timhd == null || timhd.isEmpty()) {
                return true;
            }

            if (String.valueOf(hd.getID_Hoadon()).toLowerCase().contains(timhd)
                    || hd.getNgaylap().toString().toLowerCase().contains(timhd)
                    || String.valueOf(hd.getID_Nhansu()).toLowerCase().contains(timhd)
                    || String.valueOf(hd.getID_KH()).toLowerCase().contains(timhd)) {
                return true;
            }

            return false;
        });
        // Tạo một SortedList để sắp xếp dữ liệu và áp dụng bộ lọc tìm kiếm
        SortedList<DTO_Hoadon> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(QLHD_TV_HD.comparatorProperty());
        QLHD_TV_HD.setItems(sortedData);
    }

    @FXML
    void onClick_Btn_LammoiHD(ActionEvent event) {
        LoadTableHD(null, null);
        lstCTHD.clear();
        QLHD_TV_CTHD.setItems(lstCTHD);
    }

    @FXML
    void onClick_Btn_LocHD(ActionEvent event) {
        if (QLHD_DP_Tungay.getValue() != null && QLHD_DP_Denngay.getValue() != null) {
            lstCTHD.clear();
            QLHD_TV_CTHD.setItems(lstCTHD);
            String tu = QLHD_DP_Tungay.getValue().toString();
            String den = QLHD_DP_Denngay.getValue().toString();
            LoadTableHD(tu, den);
        }
    }

    @FXML
    void KH_TimKH(KeyEvent event) {
        String timkh = KH_TF_TimKH.getText().toLowerCase();
        FilteredList<DTO_KH> filteredData = new FilteredList<>(lstKH, p -> true);
        filteredData.setPredicate(kh -> {
            // Nếu không có từ khóa tìm kiếm, hiển thị tất cả dữ liệu
            if (timkh == null || timkh.isEmpty()) {
                return true;
            }

            if (kh.getTen_KH().toLowerCase().contains(timkh)
                    || kh.getID_KH().toString().toLowerCase().contains(timkh)
                    || kh.getSDT().toLowerCase().contains(timkh)) {
                return true;
            }

            return false;
        });
        // Tạo một SortedList để sắp xếp dữ liệu và áp dụng bộ lọc tìm kiếm
        SortedList<DTO_KH> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(KH_TV_DsachKH.comparatorProperty());
        KH_TV_DsachKH.setItems(sortedData);
    }

    @FXML
    void Onclick_Btn_CapnhatKH(ActionEvent event) {
        String name, sdt;
        name = KH_TF_Ten.getText();
        sdt = KH_TF_SDT.getText();
        int counterror = 0;
        String msg_error = "";
        myIndex = KH_TV_DsachKH.getSelectionModel().getSelectedIndex();
        if (myIndex != -1) {
            id = Integer.parseInt(String.valueOf(KH_TV_DsachKH.getItems().get(myIndex).getID_KH()));
        }

        if (name.isEmpty()) {
            counterror = 1;
            msg_error = msg_error + "Tên khách hàng không được để trống!\n";
        } else if (!name.matches("^[\\p{L} '-]+$")) {
            counterror = 1;
            msg_error = msg_error + "Tên khách hàng phải không được chứa số và kí tự đặc biệt!\n";
        }
        // Kiểm tra số điện thoại không được để trống
        if (sdt.isEmpty()) {
            counterror = 1;
            msg_error = msg_error + "Số điện thoại không được để trống!\n";
        } else if (isPhoneNumberExists(sdt, id)) {
            counterror = 1;
            msg_error = msg_error + "Số điện thoại phải là duy nhất!\n";
        } else if (sdt.length() != 10) {
            counterror = 1;
            msg_error = msg_error + "Số điện thoại không hợp lệ!\n";
        } else if (!sdt.matches("[0-9]+")) {
            counterror = 1;
            msg_error = msg_error + "Số điện thoại phải không được chứa chữ và kí tự đặc biệt!\n";
        }

        if (counterror == 0)
        try {
            pst = con.prepareStatement("UPDATE khachhang SET Ten_KH=?,SDT=? WHERE ID_KH=?");
            pst.setString(1, name);
            pst.setString(2, sdt);
            pst.setInt(3, id);
            pst.executeUpdate();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Thông báo");

            alert.setHeaderText("Cập nhật Khách hàng");
            alert.setContentText("Thành cônggg!");
            alert.showAndWait();
            lstKH.clear();
            LoadTableKH();

            KH_TF_Ten.setText("");
            KH_TF_SDT.setText("");
            KH_TF_Ten.requestFocus();
        } catch (SQLException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        } else {
            // Hiển thị thông báo lỗi nếu có
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Lỗi");
            alert.setHeaderText("cập nhật khách hàng");
            alert.setContentText(msg_error);
            alert.showAndWait();
        }
    }

    @FXML
    void Onclick_Btn_ThemKH(ActionEvent event) {
        String name, sdt;
        name = KH_TF_Ten.getText();
        sdt = KH_TF_SDT.getText();
        int counterror = 0;
        String msg_error = "";
        if (name.isEmpty()) {
            counterror = 1;
            msg_error = msg_error + "Tên khách hàng không được để trống!\n";
        } else if (!name.matches("^[\\p{L} '-]+$")) {
            counterror = 1;
            msg_error = msg_error + "Tên khách hàng phải không được chứa số và kí tự đặc biệt!\n";
        }
        // Kiểm tra số điện thoại không được để trống
        if (sdt.isEmpty()) {
            counterror = 1;
            msg_error = msg_error + "Số điện thoại không được để trống!\n";
        } else if (isPhoneNumberExists(sdt)) {
            counterror = 1;
            msg_error = msg_error + "Số điện thoại phải là duy nhất!\n";
        } else if (sdt.length() != 10) {
            counterror = 1;
            msg_error = msg_error + "Số điện thoại không hợp lệ!\n";
        } else if (!sdt.matches("[0-9]+")) {
            counterror = 1;
            msg_error = msg_error + "Số điện thoại phải không được chứa chữ và kí tự đặc biệt!\n";
        }

        if (counterror == 0) {
            try {
                pst = con.prepareStatement("INSERT INTO khachhang(Ten_KH,SDT,Tichluy) VALUES (?,?,0)");
                pst.setString(1, name);
                pst.setString(2, sdt);
                pst.executeUpdate();

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Thông báo");

                alert.setHeaderText("Thêm Khách hàng");
                alert.setContentText("Thành cônggg!");
                alert.showAndWait();
                lstKH.clear();
                LoadTableKH();

                KH_TF_Ten.setText("");
                KH_TF_SDT.setText("");
                KH_TF_Ten.requestFocus();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } else {
            // Hiển thị thông báo lỗi nếu có
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Lỗi");
            alert.setHeaderText("Thêm khách hàng");
            alert.setContentText(msg_error);
            alert.showAndWait();
        }
    }

    @FXML
    void onClickTabHD(ActionEvent event) {
        hidetabNS();
        TP_HD.setVisible(true);
    }

    @FXML
    void onClick_Admin(ActionEvent event) {
        try {
            ((Node) event.getSource()).getScene().getWindow().hide();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Admin.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);
            AdminController adminController = loader.getController();
            adminController.setUserID(userID, userName,admin);
            stage.setScene(scene);
            stage.setTitle("Admin Screen");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onClickTabKH(ActionEvent event) {
        hidetabNS();
        TP_KH.setVisible(true);
    }

    @FXML
    void onClickTabPhieu(ActionEvent event) {
        hidetabNS();
        TP_PhieuNX.setVisible(true);
    }

    @FXML
    void onClickThanhtoan(ActionEvent event) {
        double tongtien = 0;
        RadioButton selectedRadioButton = (RadioButton) PTTT.getSelectedToggle();
        String selectedValue = selectedRadioButton.getText();
        if (!lstTHD.isEmpty()) {
            try {
                String sql = "select * from khachhang where SDT =?";
                pst = con.prepareStatement(sql);
                pst.setString(1, THD_TF_SDTKH.getText());
                ResultSet rs = pst.executeQuery();
                if (rs.next()) {
                    
                    DTO_Magiam selected = THD_CbB_Magiam.getValue();
                    int countSL=0;
                    String messSL="";
                    if (selected != null) {
                        for (DTO_TaoHD item : lstTHD) {
                                int tempIDsp = item.getID_Sp();
                                int tempSl = item.getSluong();
                                String sql3 = "Select * from sanpham where ID_Sp=? and Sluong>=? ";
                                pst = con.prepareStatement(sql3);
                                pst.setInt(1, tempIDsp);
                                pst.setInt(2, tempSl);
                                ResultSet rsSL =pst.executeQuery();
                                if(!rsSL.next()){
                                    countSL=1;
                                    messSL +="Sản phẩm: "+item.getTen_Sp()+" ko đủ sô lượng trong kho!\n";
                                }
                        }
                        if(countSL==1){
                            Alert alert = new Alert(Alert.AlertType.WARNING);
                            alert.setTitle("Thông báo");
                            alert.setHeaderText("Lỗi số lượng!");
                            alert.setContentText(messSL);
                            alert.showAndWait();
                            return;
                        }
                        try {
                            String sql1;
                            if (selectedValue.equals("Tiền mặt")) {
                                sql1 = "INSERT INTO hoadon(ID_Nhansu,ID_KH,ID_Magiam,ID_Phuongthucthanhtoan,Ngaylap,Tongtien,Thanhtien) "
                                        + " VALUES (?,?,?,1,CURDATE(),0,0)";
                            } else {
                                sql1 = "INSERT INTO hoadon(ID_Nhansu,ID_KH,ID_Magiam,ID_Phuongthucthanhtoan,Ngaylap,Tongtien,Thanhtien) "
                                        + " VALUES (?,?,?,2,CURDATE(),0,0)";
                            }
                            int IDKH = rs.getInt("ID_KH");
                            pst = con.prepareStatement(sql1);
                            pst.setInt(1, userID);
                            pst.setInt(2, IDKH);
                            pst.setInt(3, selected.getID_Magiam());
                            pst.executeUpdate();

                            String sql2 = "SELECT LAST_INSERT_ID()";
                            pst = con.prepareStatement(sql2);
                            ResultSet rs2 = pst.executeQuery();
                            String idhd = "aa";
                            if (rs2.next()) {
                                idhd = rs2.getString("LAST_INSERT_ID()");
                            }

                            for (DTO_TaoHD item : lstTHD) {
                                int tempIDsp = item.getID_Sp();
                                int tempSl = item.getSluong();
                                double tempTien = item.getTongdongia();
                                String sql3 = "INSERT INTO chitiethoadon(ID_Hoadon,ID_Sanpham,Sluong,TongDonGia) "
                                        + "VALUES (?,?,?,?)";
                                pst = con.prepareStatement(sql3);
                                pst.setString(1, idhd);
                                pst.setInt(2, tempIDsp);
                                pst.setInt(3, tempSl);
                                pst.setDouble(4, tempTien);
                                pst.executeUpdate();
                                tongtien = tongtien + tempTien;
                            }

                            double thanhtien = tongtien - tongtien * selected.getChietkhau() / 100;
                            String sql4 = "Update hoadon set Tongtien =?,Thanhtien = ? where ID_Hoadon=? ";
                            pst = con.prepareStatement(sql4);
                            pst.setDouble(1, tongtien);
                            pst.setDouble(2, thanhtien);
                            pst.setString(3, idhd);
                            pst.executeUpdate();

                            String sql5 = "Update khachhang set Tichluy =TichLuy+? where ID_KH=? ";
                            pst = con.prepareStatement(sql5);
                            pst.setDouble(1, thanhtien);
                            pst.setDouble(2, IDKH);
                            pst.executeUpdate();

                        try {
                            String sql6 = "{CALL sp_xacnhanTHANHTOAN(?)}";
                            pst = con.prepareStatement(sql6);
                            pst.setString(1, idhd);
                            pst.executeUpdate();
                            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setTitle("Thông báo");
                            alert.setHeaderText("Thanh toán thành công ");
                            alert.setContentText("Tổng tiền là: " + thanhtien);
                            alert.showAndWait();
                            lstTHD.clear();
                            LoadTableTHD();
                            LoadTableHD(null, null);
                            THD_TF_Tongtien.setText("0");
                            THD_TF_SDTKH.setText("");
                            LoadTableDsachSP_TPNX();
                        } catch (SQLException e) {
                            String sql6 = "DELETE FROM chitiethoadon WHERE ID_Hoadon=?";
                            pst = con.prepareStatement(sql6);
                            pst.setString(1, idhd);
                            pst.executeUpdate();
                            String sql7 = "DELETE FROM hoadon WHERE ID_Hoadon=?";
                            pst = con.prepareStatement(sql7);
                            pst.setString(1, idhd);
                            pst.executeUpdate();
                            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setTitle("Thông báo");
                            alert.setHeaderText("Tạo Hóa đơn Thất bại!");
                            alert.setContentText("Số lượng hàng trong kho ko đủ!");
                            alert.showAndWait();
                        }
//                            Alert alert = new Alert(Alert.AlertType.INFORMATION);
//                            alert.setTitle("Thông báo");
//                            alert.setHeaderText("Thanh toán thành công ");
//                            alert.setContentText("Tổng tiền là: " + thanhtien);
//                            alert.showAndWait();
//                            lstTHD.clear();
//                            LoadTableTHD();
//                            LoadTableHD(null, null);
//                            THD_TF_Tongtien.setText("0");
//                            THD_TF_SDTKH.setText("");
//                            LoadTableDsachSP_TPNX();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    } else {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Thông báo");
                        alert.setHeaderText("Vui lòng chọn mã giảm");
                        alert.showAndWait();
                    }

                } else {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Thông báo");
                    alert.setHeaderText("Sai thông tin");
                    alert.setContentText("SDT khách hàng ko tồn tại!");
                    alert.showAndWait();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Thông báo");
            alert.setHeaderText("Ko có SP trong Hóa đơn");
            alert.showAndWait();
        }
    }

    @FXML
    void onClickThemSPvaoHD(ActionEvent event) {

        DTO_Sanpham selectedSP = THD_CbB_TenSP.getValue();
        if (selectedSP != null) {
            int IDSP = selectedSP.getID_Sp();
            try {
                String sql = "SELECT * FROM sanpham, donvitinh Where sanpham.ID_Donvitinh=donvitinh.ID_Donvitinh and ID_Sp = ? ";
                pst = con.prepareStatement(sql);
                pst.setInt(1, IDSP);
                ResultSet rs = pst.executeQuery();
                if (rs.next()) {
                    int ID_Sp = rs.getInt("ID_Sp");
                    String Ten_Sp = rs.getString("Ten_Sp");
                    int Sluong = THD_Spn_SL.getValue();
                    double Gia = rs.getDouble("Gia");
                    String Donvitinh = rs.getString("Donvitinh");
                    double Tongdongia = Sluong * Gia;

                    DTO_TaoHD item = new DTO_TaoHD(ID_Sp, Ten_Sp, Sluong, Donvitinh, Gia, Tongdongia);
                    lstTHD.removeIf(check -> check.getID_Sp() == ID_Sp);
                    lstTHD.add(item);
                    lstTHD.removeIf(check -> check.getSluong() == 0);
                    LoadTableTHD();
                    double totalAmount = 0;
                    for (DTO_TaoHD CTHD : lstTHD) {
                        totalAmount += CTHD.getTongdongia();
                    }
                    THD_TF_Tongtien.setText(String.valueOf(totalAmount));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    void onClickselectValueLoai(ActionEvent event) {
        DTO_Loai selectedLoai = THD_CbB_LoaiSP.getValue();
        if (selectedLoai != null) {
            int IDLoai = selectedLoai.getID_Loai();
            try {
                THD_CbB_TenSP.getItems().clear();
                String sql = "SELECT * FROM sanpham Where ID_Loai = ? and Trangthai=1 ";
                pst = con.prepareStatement(sql);
                pst.setInt(1, IDLoai);
                ResultSet rs = pst.executeQuery();
                while (rs.next()) {
                    int ID_Sp = rs.getInt("ID_Sp");
                    String Ten_Sp = rs.getString("Ten_Sp");
                    int ID_Loai = rs.getInt("ID_Loai");
                    double Gia = rs.getDouble("Gia");
                    int Sluong = rs.getInt("Sluong");
                    int ID_Donvitinh = rs.getInt("ID_Donvitinh");
                    boolean Trangthai = rs.getBoolean("Trangthai");

                    DTO_Sanpham item = new DTO_Sanpham(ID_Sp, Ten_Sp, ID_Loai, Gia, Sluong, ID_Donvitinh, Trangthai);
                    THD_CbB_TenSP.getItems().add(item);
                    THD_CbB_TenSP.setCellFactory(param -> new ListCell<DTO_Sanpham>() {
                        @Override
                        protected void updateItem(DTO_Sanpham item, boolean empty) {
                            super.updateItem(item, empty);
                            if (empty || item == null) {
                                setText(null);
                            } else {
                                setText(item.getTen_Sp());
                            }
                        }
                    });
                    THD_CbB_TenSP.setConverter(new StringConverter<DTO_Sanpham>() {
                        @Override
                        public String toString(DTO_Sanpham item) {
                            if (item == null) {
                                return null;
                            } else {
                                return item.getTen_Sp();
                            }
                        }

                        @Override
                        public DTO_Sanpham fromString(String string) {
                            // Not used
                            return null;
                        }
                    });
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    //--------------------------------------------------------------------------
    ObservableList<DTO_TaoHD> lstTHD = FXCollections.observableArrayList();
    ObservableList<DTO_KH> lstKH = FXCollections.observableArrayList();
    ObservableList<DTO_Hoadon> lstHD = FXCollections.observableArrayList();
    ObservableList<DTO_CTHD> lstCTHD = FXCollections.observableArrayList();
    ObservableList<DTO_Sanpham> lstSanphamTPNX = FXCollections.observableArrayList();
    ObservableList<DTO_TAOPHIEU> lstTPhieu = FXCollections.observableArrayList();
    ObservableList<DTO_Phieunhap> lstPNhap = FXCollections.observableArrayList();
    ObservableList<DTO_CTPNhap> lstCTPNhap = FXCollections.observableArrayList();
    ObservableList<DTO_Phieuxuat> lstPXuat = FXCollections.observableArrayList();
    ObservableList<DTO_CTPXuat> lstCTPXuat = FXCollections.observableArrayList();
    
    
    private Stage primaryStage;

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    Connection con;
    PreparedStatement pst;
    int myIndex;
    int id;

    int userID;
    String userName;
    boolean admin;

    public void setUserID(int userID, String userName,boolean admin) {
        Util_LB_INFO.setText(userName);
        this.userID = userID;
        this.userName = userName;
        this.admin =admin;
        BTN_QUANLY.setDisable(!admin);
    }
    
    private boolean isPhoneNumberExists(String sdt, int id) {
        try {
            pst = con.prepareStatement("SELECT * FROM khachhang WHERE SDT = ? AND ID_KH != ?");
            pst.setString(1, sdt);
            pst.setInt(2, id);
            ResultSet rs = pst.executeQuery();
            return rs.next(); // Nếu có kết quả trả về, tức là số điện thoại đã tồn tại trong cơ sở dữ liệu (trừ số điện thoại cùng ID)
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    private boolean isPhoneNumberExists(String sdt) {
        try {
            pst = con.prepareStatement("SELECT * FROM khachhang WHERE SDT = ?");
            pst.setString(1, sdt);
            ResultSet rs = pst.executeQuery();
            return rs.next(); // Nếu có kết quả trả về, tức là số điện thoại đã tồn tại trong cơ sở dữ liệu
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public void LoadTableTHD() {
        THD_Col_IDsp.setCellValueFactory(new PropertyValueFactory<>("ID_Sp"));
        THD_Col_TenSP.setCellValueFactory(new PropertyValueFactory<>("Ten_Sp"));
        THD_Col_Sl.setCellValueFactory(new PropertyValueFactory<>("Sluong"));
        THD_Col_Donvitinh.setCellValueFactory(new PropertyValueFactory<>("DonViTinh"));
        THD_Col_Dongia.setCellValueFactory(new PropertyValueFactory<>("Dongia"));
        THD_Col_Tongdongia.setCellValueFactory(new PropertyValueFactory<>("Tongdongia"));
        THD_TV_ChitietHD.setItems(lstTHD);
    }

    public void LoadTableTPhieu() {
        TPNX_Col_TaoPhieuTenSP.setCellValueFactory(new PropertyValueFactory<>("Ten_Sp"));
        TPNX_Col_TaoPhieuSluong.setCellValueFactory(new PropertyValueFactory<>("Sluong"));
        TPNX_Col_TaoPhieuGia.setCellValueFactory(new PropertyValueFactory<>("Gia"));
        TPNX_TV_TaoPhieu.setItems(lstTPhieu);
    }

    public void LoadTableKH() {
        try {
            pst = con.prepareStatement("select * from khachhang where not ID_KH=0");
            ResultSet rs = pst.executeQuery();
            {
                while (rs.next()) {
                    DTO_KH kh = new DTO_KH();
                    kh.setID_KH(rs.getInt("ID_KH"));
                    kh.setTen_KH(rs.getString("Ten_KH"));
                    kh.setSDT(rs.getString("SDT"));
                    kh.setTichluy(rs.getDouble("Tichluy"));
                    lstKH.add(kh);
                }
            }
            KH_TV_DsachKH.setItems(lstKH);
            KH_Col_IDKH.setCellValueFactory(new PropertyValueFactory<>("ID_KH"));
            KH_Col_TenKH.setCellValueFactory(new PropertyValueFactory<>("Ten_KH"));
            KH_Col_SDT.setCellValueFactory(new PropertyValueFactory<>("SDT"));
            KH_Col_Tichluy.setCellValueFactory(new PropertyValueFactory<>("Tichluy"));
        } catch (SQLException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }

        KH_TV_DsachKH.setRowFactory(tv -> {
            TableRow<DTO_KH> myRow = new TableRow<>();
            myRow.setOnMouseClicked(event
                    -> {
                if (event.getClickCount() == 1 && (!myRow.isEmpty())) {
                    myIndex = KH_TV_DsachKH.getSelectionModel().getSelectedIndex();
                    id = Integer.parseInt(String.valueOf(KH_TV_DsachKH.getItems().get(myIndex).getID_KH()));
                    KH_TF_Ten.setText(KH_TV_DsachKH.getItems().get(myIndex).getTen_KH());
                    KH_TF_SDT.setText(KH_TV_DsachKH.getItems().get(myIndex).getSDT());

                }
            });
            return myRow;
        });
    }

    public void LoadTableHD(String tu, String den) {
        try {
            String sql;
            ResultSet rs;
            double doanhthu = 0;
            lstHD.clear();
            if (tu == null || den == null) {
                sql = "select * from hoadon h, phuongthucthanhtoan p where h.ID_Phuongthucthanhtoan=p.ID_Phuongthucthanhtoan";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
            } else {
                sql = "select * from hoadon h, phuongthucthanhtoan p "
                        + "where h.ID_Phuongthucthanhtoan=p.ID_Phuongthucthanhtoan AND Ngaylap >= ? AND Ngaylap <= ?";
                pst = con.prepareStatement(sql);
                pst.setString(1, tu);
                pst.setString(2, den);
                rs = pst.executeQuery();
            }

            {
                while (rs.next()) {
                    DTO_Hoadon hd = new DTO_Hoadon();
                    hd.setID_Hoadon(rs.getInt("ID_Hoadon"));
                    hd.setID_Nhansu(rs.getInt("ID_Nhansu"));
                    hd.setID_KH(rs.getInt("ID_KH"));
                    hd.setID_Magiam(rs.getInt("ID_Magiam"));
                    hd.setNgaylap(rs.getDate("Ngaylap"));
                    hd.setPhuongthucthanhtoan(rs.getString("Ten_Phuongthucthanhtoan"));
                    hd.setTongtien(rs.getDouble("Tongtien"));
                    hd.setThanhtien(rs.getDouble("Thanhtien"));
                    lstHD.add(hd);
                    doanhthu = doanhthu + rs.getDouble("Thanhtien");
                }
            }
            QLHD_TF_Doanhthu.setText(String.valueOf(doanhthu));
            QLHD_TV_HD.setItems(lstHD);
            QLHD_Col_IDHD.setCellValueFactory(new PropertyValueFactory<>("ID_Hoadon"));
            QLHD_Col_IDNS.setCellValueFactory(new PropertyValueFactory<>("ID_Nhansu"));
            QLHD_Col_IDKH.setCellValueFactory(new PropertyValueFactory<>("ID_KH"));
            QLHD_Col_IDMagiam.setCellValueFactory(new PropertyValueFactory<>("ID_Magiam"));
            QLHD_Col_Thanhtoan.setCellValueFactory(new PropertyValueFactory<>("Phuongthucthanhtoan"));
            QLHD_Col_Ngay.setCellValueFactory(new PropertyValueFactory<>("Ngaylap"));
            QLHD_Col_Tongtien.setCellValueFactory(new PropertyValueFactory<>("Tongtien"));
            QLHD_Col_Thanhtien.setCellValueFactory(new PropertyValueFactory<>("Thanhtien"));

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        QLHD_TV_HD.setRowFactory(tv -> {
            TableRow<DTO_Hoadon> myRow = new TableRow<>();
            myRow.setOnMouseClicked(event
                    -> {
                if (event.getClickCount() == 1 && (!myRow.isEmpty())) {
                    myIndex = QLHD_TV_HD.getSelectionModel().getSelectedIndex();
                    id = Integer.parseInt(String.valueOf(QLHD_TV_HD.getItems().get(myIndex).getID_Hoadon()));
                    LoadTableCTHD(id);
                }
            });
            return myRow;
        });
    }

    public void LoadTablePNhap(String tu, String den) {
        try {
            String sql;
            ResultSet rs;
            double chitieu = 0;
            lstPNhap.clear();
            if (tu == null || den == null) {
                sql = "select * from phieunhap";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
            } else {
                sql = "select * from phieunhap where  Ngaynhap >= ? AND Ngaynhap <= ?";
                pst = con.prepareStatement(sql);
                pst.setString(1, tu);
                pst.setString(2, den);
                rs = pst.executeQuery();
            }

            {
                while (rs.next()) {
                    DTO_Phieunhap item = new DTO_Phieunhap();
                    item.setID_Phieunhap(rs.getInt("ID_Phieunhap"));
                    item.setID_Nhansu(rs.getInt("ID_Nhansu"));
                    item.setNgaynhap(rs.getDate("Ngaynhap"));
                    item.setTongChi(rs.getDouble("TongChi"));
                    lstPNhap.add(item);
                    chitieu = chitieu + rs.getDouble("TongChi");
                }
            }
            DSPN_TF_Tongchi.setText(String.valueOf(chitieu));
            DSPN_TV_PN.setItems(lstPNhap);
            DSPN_Col_IDphieu.setCellValueFactory(new PropertyValueFactory<>("ID_Phieunhap"));
            DSPN_Col_IDNhansu.setCellValueFactory(new PropertyValueFactory<>("ID_Nhansu"));
            DSPN_Col_Ngay.setCellValueFactory(new PropertyValueFactory<>("Ngaynhap"));
            DSPN_Col_TongChi.setCellValueFactory(new PropertyValueFactory<>("TongChi"));

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        DSPN_TV_PN.setRowFactory(tv -> {
            TableRow<DTO_Phieunhap> myRow = new TableRow<>();
            myRow.setOnMouseClicked(event
                    -> {
                if (event.getClickCount() == 1 && (!myRow.isEmpty())) {
                    myIndex = DSPN_TV_PN.getSelectionModel().getSelectedIndex();
                    id = Integer.parseInt(String.valueOf(DSPN_TV_PN.getItems().get(myIndex).getID_Phieunhap()));
                    LoadTableCTPNhap(id);
                }
            });
            return myRow;
        });
    }

    public void LoadTableCTPNhap(int idphieu) {
        try {
            lstCTPNhap.clear();
            pst = con.prepareStatement("select s.ID_Sp ,Ten_Sp, c.Soluong, TongGiaNhap "
                    + "from chitietphieunhap c, sanpham s where c.ID_Sanpham=s.ID_Sp and ID_Phieunhap=?");
            pst.setInt(1, idphieu);
            ResultSet rs = pst.executeQuery();
            {
                while (rs.next()) {
                    DTO_CTPNhap item = new DTO_CTPNhap();
                    item.setID_Sanpham(rs.getInt("ID_Sp"));
                    item.setTen_Sanpham(rs.getString("Ten_Sp"));
                    item.setSoluong(rs.getInt("Soluong"));
                    item.setTongGiaNhap(rs.getDouble("TongGiaNhap"));
                    lstCTPNhap.add(item);
                }
            }
            DSPN_TV_CCPN.setItems(lstCTPNhap);
            DSPN_Col_IDsp.setCellValueFactory(new PropertyValueFactory<>("ID_Sanpham"));
            DSPN_Col_TenSP.setCellValueFactory(new PropertyValueFactory<>("Ten_Sanpham"));
            DSPN_Col_Sluong.setCellValueFactory(new PropertyValueFactory<>("Soluong"));
            DSPN_Col_Tongdongia.setCellValueFactory(new PropertyValueFactory<>("TongGiaNhap"));

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public void LoadTablePXuat(String tu, String den) {
        try {
            String sql;
            ResultSet rs;
            double thunhap = 0;
            lstPXuat.clear();
            if (tu == null || den == null) {
                sql = "select * from phieuxuat";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
            } else {
                sql = "select * from phieuxuat where  Ngayxuat >= ? AND Ngayxuat <= ?";
                pst = con.prepareStatement(sql);
                pst.setString(1, tu);
                pst.setString(2, den);
                rs = pst.executeQuery();
            }

            {
                while (rs.next()) {
                    DTO_Phieuxuat item = new DTO_Phieuxuat();
                    item.setID_Phieuxuat(rs.getInt("ID_Phieuxuat"));
                    item.setID_Nhansu(rs.getInt("ID_Nhansu"));
                    item.setNgayxuat(rs.getDate("Ngayxuat"));
                    item.setTongThu(rs.getDouble("TongThu"));
                    lstPXuat.add(item);
                    thunhap = thunhap + rs.getDouble("TongThu");
                }
            }
            DSPX_TF_TongThu.setText(String.valueOf(thunhap));
            DSPX_TV_PX.setItems(lstPXuat);
            DSPX_Col_IDphieu.setCellValueFactory(new PropertyValueFactory<>("ID_Phieuxuat"));
            DSPX_Col_IDNhansu.setCellValueFactory(new PropertyValueFactory<>("ID_Nhansu"));
            DSPX_Col_Ngay.setCellValueFactory(new PropertyValueFactory<>("Ngayxuat"));
            DSPX_Col_TongThu.setCellValueFactory(new PropertyValueFactory<>("TongThu"));

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        DSPX_TV_PX.setRowFactory(tv -> {
            TableRow<DTO_Phieuxuat> myRow = new TableRow<>();
            myRow.setOnMouseClicked(event
                    -> {
                if (event.getClickCount() == 1 && (!myRow.isEmpty())) {
                    myIndex = DSPX_TV_PX.getSelectionModel().getSelectedIndex();
                    id = Integer.parseInt(String.valueOf(DSPX_TV_PX.getItems().get(myIndex).getID_Phieuxuat()));
                    LoadTableCTPXuat(id);
                }
            });
            return myRow;
        });
    }

    public void LoadTableCTPXuat(int idphieu) {
        try {
            lstCTPXuat.clear();
            pst = con.prepareStatement("select s.ID_Sp ,Ten_Sp, c.Soluong, TongGiaXuat "
                    + "from chitietphieuxuat c, sanpham s where c.ID_Sanpham=s.ID_Sp and ID_Phieuxuat=?");
            pst.setInt(1, idphieu);
            ResultSet rs = pst.executeQuery();
            {
                while (rs.next()) {
                    DTO_CTPXuat item = new DTO_CTPXuat();
                    item.setID_Sanpham(rs.getInt("ID_Sp"));
                    item.setTen_Sanpham(rs.getString("Ten_Sp"));
                    item.setSoluong(rs.getInt("Soluong"));
                    item.setTongGiaXuat(rs.getDouble("TongGiaXuat"));
                    lstCTPXuat.add(item);
                }
            }
            DSPX_TV_CTPX.setItems(lstCTPXuat);
            DSPX_Col_IDsp.setCellValueFactory(new PropertyValueFactory<>("ID_Sanpham"));
            DSPX_Col_TenSP.setCellValueFactory(new PropertyValueFactory<>("Ten_Sanpham"));
            DSPX_Col_Sluong.setCellValueFactory(new PropertyValueFactory<>("Soluong"));
            DSPX_Col_Tongdongia.setCellValueFactory(new PropertyValueFactory<>("TongGiaXuat"));

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public void LoadTableCTHD(int idhd) {
        try {
            lstCTHD.clear();
            pst = con.prepareStatement("select s.ID_Sp ,Ten_Sp, c.Sluong, TongDonGia "
                    + "from chitiethoadon c, sanpham s where c.ID_Sanpham=s.ID_Sp and ID_Hoadon=?");
            pst.setInt(1, idhd);
            ResultSet rs = pst.executeQuery();
            {
                while (rs.next()) {
                    DTO_CTHD cthd = new DTO_CTHD();
                    cthd.setID_Sanpham(rs.getInt("ID_Sp"));
                    cthd.setTen_Sanpham(rs.getString("Ten_Sp"));
                    cthd.setSluong(rs.getInt("Sluong"));
                    cthd.setTongDonGia(rs.getDouble("TongDonGia"));
                    lstCTHD.add(cthd);
                }
            }
            QLHD_TV_CTHD.setItems(lstCTHD);
            QLHD_Col_IDSP.setCellValueFactory(new PropertyValueFactory<>("ID_Sanpham"));
            QLHD_Col_TenSP.setCellValueFactory(new PropertyValueFactory<>("Ten_Sanpham"));
            QLHD_Col_Sluong.setCellValueFactory(new PropertyValueFactory<>("Sluong"));
            QLHD_Col_Tongdongia.setCellValueFactory(new PropertyValueFactory<>("TongDonGia"));

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public void LoadTableDsachSP_TPNX() {
        try {
            lstSanphamTPNX.clear();
            pst = con.prepareStatement("select * from sanpham ");
            ResultSet rs = pst.executeQuery();
            {
                while (rs.next()) {
                    int ID_Sp = rs.getInt("ID_Sp");
                    String Ten_Sp = rs.getString("Ten_Sp");
                    int ID_Loai = rs.getInt("ID_Loai");
                    double Gia = rs.getDouble("Gia");
                    int Sluong = rs.getInt("Sluong");
                    int ID_Donvitinh = rs.getInt("ID_Donvitinh");
                    boolean Trangthai = rs.getBoolean("Trangthai");
                    DTO_Sanpham sp = new DTO_Sanpham(ID_Sp, Ten_Sp, ID_Loai, Gia, Sluong, ID_Donvitinh, Trangthai);
                    lstSanphamTPNX.add(sp);
                }
            }
            TPNX_TV_DsachSP.setItems(lstSanphamTPNX);
            TPNX_Col_IDSP.setCellValueFactory(new PropertyValueFactory<>("ID_Sp"));
            TPNX_Col_TENSP.setCellValueFactory(new PropertyValueFactory<>("Ten_Sp"));
            TPNX_Col_GIA.setCellValueFactory(new PropertyValueFactory<>("Gia"));
            TPNX_Col_Sluong.setCellValueFactory(new PropertyValueFactory<>("Sluong"));
            TPNX_Col_Trangthai.setCellValueFactory(new PropertyValueFactory<>("Trangthai"));

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public void THD_bindingMagiam() {
        try {
            String sql = "SELECT * FROM magiam Where Trangthai=1";
            pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("ID_Magiam");
                String name = rs.getString("Ten_Magiam");
                int chietkhau = rs.getInt("Chietkhau");
                boolean trangthai = rs.getBoolean("Trangthai");
                DTO_Magiam item = new DTO_Magiam(id, name, chietkhau, trangthai);
                THD_CbB_Magiam.getItems().add(item);
                THD_CbB_Magiam.setCellFactory(param -> new ListCell<DTO_Magiam>() {
                    @Override
                    protected void updateItem(DTO_Magiam item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty || item == null) {
                            setText(null);
                        } else {
                            setText(item.getTen_Magiam() + " - " + item.getChietkhau() + "%");
                        }
                    }
                });
                THD_CbB_Magiam.setConverter(new StringConverter<DTO_Magiam>() {
                    @Override
                    public String toString(DTO_Magiam item) {
                        if (item == null) {
                            return null;
                        } else {
                            return item.getTen_Magiam() + " - " + item.getChietkhau() + "%";
                        }
                    }

                    @Override
                    public DTO_Magiam fromString(String string) {
                        // Not used
                        return null;
                    }
                });
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void THD_bindingLoai() {
        try {
            String sql = "SELECT * FROM loai";
            pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("ID_Loai");
                String name = rs.getString("Ten_Loai");
                DTO_Loai item = new DTO_Loai(id, name);
                THD_CbB_LoaiSP.getItems().add(item);
                THD_CbB_LoaiSP.setCellFactory(param -> new ListCell<DTO_Loai>() {
                    @Override
                    protected void updateItem(DTO_Loai item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty || item == null) {
                            setText(null);
                        } else {
                            setText(item.getTen_Loai());
                        }
                    }
                });
                THD_CbB_LoaiSP.setConverter(new StringConverter<DTO_Loai>() {
                    @Override
                    public String toString(DTO_Loai item) {
                        if (item == null) {
                            return null;
                        } else {
                            return item.getTen_Loai();
                        }
                    }

                    @Override
                    public DTO_Loai fromString(String string) {
                        // Not used
                        return null;
                    }
                });
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void TPNX_bindingLoai() {
        try {
            String sql = "SELECT * FROM loai";
            pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("ID_Loai");
                String name = rs.getString("Ten_Loai");
                DTO_Loai item = new DTO_Loai(id, name);
                TPNX_CbB_LoaiSP.getItems().add(item);
                TPNX_CbB_LoaiSP.setCellFactory(param -> new ListCell<DTO_Loai>() {
                    @Override
                    protected void updateItem(DTO_Loai item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty || item == null) {
                            setText(null);
                        } else {
                            setText(item.getTen_Loai());
                        }
                    }
                });
                TPNX_CbB_LoaiSP.setConverter(new StringConverter<DTO_Loai>() {
                    @Override
                    public String toString(DTO_Loai item) {
                        if (item == null) {
                            return null;
                        } else {
                            return item.getTen_Loai();
                        }
                    }

                    @Override
                    public DTO_Loai fromString(String string) {
                        // Not used
                        return null;
                    }
                });
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void hidetabNS() {
        TP_HD.setVisible(false);
        TP_KH.setVisible(false);
        TP_PhieuNX.setVisible(false);
    }

    public void Connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/sieuthimini", "root", "");
        } catch (ClassNotFoundException ex) {

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Connect();
        THD_bindingLoai();

        LoadTableTHD();
        LoadTableKH();
        LoadTableHD(null, null);
        LoadTableDsachSP_TPNX();
        TPNX_bindingLoai();
        LoadTablePNhap(null, null);
        LoadTablePXuat(null, null);
        THD_bindingMagiam();
        THD_TF_Tongtien.setText("0");

        //spinner THD
        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 20);
        valueFactory.setValue(1);
        THD_Spn_SL.setValueFactory(valueFactory);
        THD_Spn_SL.getEditor().setTextFormatter(new TextFormatter<Integer>(change -> {
            String sluong = THD_Spn_SL.getEditor().getText();
            if (sluong.isEmpty()) {
                THD_Spn_SL.getValueFactory().setValue(0);
            }
            String newText = change.getControlNewText();
            if (newText.matches("\\d*")) {
                return change;
            }
            return null;
        }));

        SpinnerValueFactory<Integer> valueFactory2 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 400);
        valueFactory2.setValue(1);
        TPNX_Spn_Sluong.setValueFactory(valueFactory2);
        TPNX_Spn_Sluong.getEditor().setTextFormatter(new TextFormatter<Integer>(change -> {
            String sluong = TPNX_Spn_Sluong.getEditor().getText();
            if (sluong.isEmpty()) {
                TPNX_Spn_Sluong.getValueFactory().setValue(0);
            }
            String newText = change.getControlNewText();
            if (newText.matches("\\d*")) {
                return change;
            }
            return null;
        }));

        TPNX_TF_Gia.setText("0");
        TPNX_TF_Gia.setTextFormatter(new TextFormatter<>(change -> {
            String newText = change.getControlNewText();
            if (newText.matches("\\d*")) {
                return change;
            }
            return null;
        }));
    }
}
