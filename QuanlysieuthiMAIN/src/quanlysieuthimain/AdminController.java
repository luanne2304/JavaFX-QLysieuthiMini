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
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import quanlysieuthimain.DTO.DTO_Admin_SanPham;
import quanlysieuthimain.DTO.DTO_CbBNhansu;
import quanlysieuthimain.DTO.DTO_Donvitinh;
import quanlysieuthimain.DTO.DTO_Loai;
import quanlysieuthimain.DTO.DTO_Magiam;
import quanlysieuthimain.DTO.DTO_Nhansu;
import quanlysieuthimain.DTO.DTO_Taikhoan;

/**
 * FXML Controller class
 *
 * @author luans
 */
public class AdminController implements Initializable {

    @FXML
    private CheckBox MG_ChB_Trangthai;

    @FXML
    private TableColumn<DTO_Magiam, Double> MG_Col_Chietkhau;

    @FXML
    private TableColumn<DTO_Magiam, Integer> MG_Col_ID;

    @FXML
    private TableColumn<DTO_Magiam, String> MG_Col_Ten;

    @FXML
    private TableColumn<DTO_Magiam, Boolean> MG_Col_Trangthai;

    @FXML
    private TextField MG_TF_Ten;

    @FXML
    private Spinner<Integer> MG_Spn_Chietkhau;

    @FXML
    private TableView<DTO_Magiam> MG_TV_MG;

    @FXML
    private CheckBox NS_ChB_Trangthai;

    @FXML
    private TableColumn<DTO_Nhansu, String> NS_Col_CCCD;

    @FXML
    private TableColumn<DTO_Nhansu, String> NS_Col_Chucvu;

    @FXML
    private TableColumn<DTO_Nhansu, Integer> NS_Col_IDNS;

    @FXML
    private TableColumn<DTO_Nhansu, String> NS_Col_Mail;

    @FXML
    private TableColumn<DTO_Nhansu, Date> NS_Col_Ngaylam;

    @FXML
    private TableColumn<DTO_Nhansu, Date> NS_Col_Ngaysinh;

    @FXML
    private TableColumn<DTO_Nhansu, String> NS_Col_SDT;

    @FXML
    private TableColumn<DTO_Nhansu, String> NS_Col_TenNS;

    @FXML
    private TableColumn<DTO_Nhansu, Boolean> NS_Col_Trangthai;

    @FXML
    private DatePicker NS_DP_Ngaylam;

    @FXML
    private DatePicker NS_DP_Ngaysinh;

    @FXML
    private TextField NS_TF_CCCD;

    @FXML
    private TextField NS_TF_Chucvu;

    @FXML
    private TextField NS_TF_Mail;

    @FXML
    private TextField NS_TF_SDT;

    @FXML
    private TextField NS_TF_TenNS;

    @FXML
    private TableView<DTO_Nhansu> NS_TV_NS;

    @FXML
    private ComboBox<DTO_Donvitinh> SP_CbB_Donvitinh;

    @FXML
    private ComboBox<DTO_Loai> SP_CbB_Loai;

    @FXML
    private CheckBox SP_ChB_Trangthai;

    @FXML
    private TableColumn<DTO_Admin_SanPham, String> SP_Col_Donvitinh;

    @FXML
    private TableColumn<DTO_Admin_SanPham, Double> SP_Col_GIa;

    @FXML
    private TableColumn<DTO_Admin_SanPham, Integer> SP_Col_IDSP;

    @FXML
    private TableColumn<DTO_Admin_SanPham, Integer> SP_Col_Sluong;

    @FXML
    private TableColumn<DTO_Admin_SanPham, String> SP_Col_TenLoai;

    @FXML
    private TableColumn<DTO_Admin_SanPham, String> SP_Col_TenSP;

    @FXML
    private TableColumn<DTO_Admin_SanPham, Boolean> SP_Col_Trangthai;

    @FXML
    private TextField SP_TF_Gia;

    @FXML
    private TextField SP_TF_TenSP;
    
    @FXML
    private TextField SP_TF_TimSP;

    @FXML
    private TableView<DTO_Admin_SanPham> SP_TV_SP;

    @FXML
    private ComboBox<DTO_CbBNhansu> TK_CbB_NS;

    @FXML
    private CheckBox TK_ChB_Admin;

    @FXML
    private CheckBox TK_ChB_Trangthai;

    @FXML
    private TableColumn<DTO_Taikhoan, Boolean> TK_Col_Admin;

    @FXML
    private TableColumn<DTO_Taikhoan, Integer> TK_Col_IDTK;

    @FXML
    private TableColumn<DTO_Taikhoan, String> TK_Col_MK;

    @FXML
    private TableColumn<DTO_Taikhoan, String> TK_Col_TenNS;

    @FXML
    private TableColumn<DTO_Taikhoan, String> TK_Col_TenTK;

    @FXML
    private TableColumn<DTO_Taikhoan, Boolean> TK_Col_Trangthai;

    @FXML
    private TextField TK_TF_Mk;

    @FXML
    private TextField TK_TF_TenTK;
    
    @FXML
    private Button ID_BTN_HOME;
    
    @FXML
    private TableView<DTO_Taikhoan> TK_TV_TK;

    @FXML
    void Util_onclick_Home(ActionEvent event) {
        try {
            ((Node) event.getSource()).getScene().getWindow().hide();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Home.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);
            HomeController homeController = loader.getController();
            homeController.setPrimaryStage((Stage) ID_BTN_HOME.getScene().getWindow());
            homeController.setUserID(userID, userName,admin);
            stage.setScene(scene);
            stage.setTitle("Home Screen");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
    @FXML
    void MG_onclick_Capnhat(ActionEvent event) {
        String Ten = MG_TF_Ten.getText();
        int Chietkhau = MG_Spn_Chietkhau.getValue();
        boolean Trangthai = MG_ChB_Trangthai.isSelected();
        int counterror = 0;
        String msg_error = "";
        myIndex = MG_TV_MG.getSelectionModel().getSelectedIndex();
        if (myIndex != -1) {
            id = Integer.parseInt(String.valueOf(MG_TV_MG.getItems().get(myIndex).getID_Magiam()));
        } else {
            counterror = 1;
            msg_error = msg_error + "Vui lòng không được để trống!\n";
        }
        if (Ten.isEmpty()) {
            counterror = 1;
            msg_error = msg_error + "Tên mã giảm không được để trống!\n";
        } else if (isMagiamExists(Ten, id)) {
            counterror = 1;
            msg_error = msg_error + "Tên mã giảm đã trùng!\n";
        }
        if (counterror == 0) {
            try {
                pst = con.prepareStatement("UPDATE magiam set Ten_Magiam=?,Chietkhau=?,Trangthai=? where ID_Magiam=?");
                pst.setString(1, Ten);
                pst.setInt(2, Chietkhau);
                pst.setBoolean(3, Trangthai);
                pst.setInt(4, id);
                pst.executeUpdate();

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Thông báo");

                alert.setHeaderText("Cập nhật Mã giảm");
                alert.setContentText("Thành cônggg!");
                alert.showAndWait();
                lstMGiam.clear();
                LoadTableMGiam();
                MG_Spn_Chietkhau.getValueFactory().setValue(0);
                MG_TF_Ten.setText("");
                MG_ChB_Trangthai.setSelected(false);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } else {
            // Hiển thị thông báo lỗi nếu có
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Lỗi");
            alert.setHeaderText("Cập nhật mã giảm");
            alert.setContentText(msg_error);
            alert.showAndWait();
        }
    }

    @FXML
    void MG_onclick_them(ActionEvent event) {
        String Ten = MG_TF_Ten.getText();
        int Chietkhau = MG_Spn_Chietkhau.getValue();
        boolean Trangthai = MG_ChB_Trangthai.isSelected();
        int counterror = 0;
        String msg_error = "";
        if (Ten.isEmpty()) {
            counterror = 1;
            msg_error = msg_error + "Tên mã giảm không được để trống!\n";
        } else if (isMagiamExists(Ten)) {
            counterror = 1;
            msg_error = msg_error + "Tên mã giảm không được phép trùng!\n";
        }
        if (counterror == 0) {
            try {
                pst = con.prepareStatement("INSERT INTO magiam(Ten_Magiam,Chietkhau,Trangthai) "
                        + "VALUES (?,?,?)");
                pst.setString(1, Ten);
                pst.setInt(2, Chietkhau);
                pst.setBoolean(3, Trangthai);
                pst.executeUpdate();

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Thông báo");

                alert.setHeaderText("Thêm Mã giảm");
                alert.setContentText("Thành cônggg!");
                alert.showAndWait();
                lstMGiam.clear();
                LoadTableMGiam();
                MG_Spn_Chietkhau.getValueFactory().setValue(0);
                MG_TF_Ten.setText("");
                MG_ChB_Trangthai.setSelected(false);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } else {
            // Hiển thị thông báo lỗi nếu có
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Lỗi");
            alert.setHeaderText("Thêm mã giảm");
            alert.setContentText(msg_error);
            alert.showAndWait();
        }
    }



    @FXML
    void TK_onclick_Capnhat(ActionEvent event) {
        DTO_CbBNhansu selected = TK_CbB_NS.getValue();
        String Tentk = TK_TF_TenTK.getText();
        String Mk = TK_TF_Mk.getText(); // Sửa lấy mật khẩu từ TK_TF_Mk.getText()
        int IDNS = 0;
        boolean Admin = TK_ChB_Admin.isSelected();
        boolean Trangthai = TK_ChB_Trangthai.isSelected();
        int counterror = 0;
        String msg_error = "";
        myIndex = TK_TV_TK.getSelectionModel().getSelectedIndex();
        if (myIndex != -1) {
            id = Integer.parseInt(String.valueOf(TK_TV_TK.getItems().get(myIndex).getID_Taikhoan()));
        } else {
            counterror = 1;
            msg_error = msg_error + "Vui lòng chọn dòng!\n";
        }
        if (selected == null) {
            counterror = 1;
            msg_error = msg_error + "Vui lòng không để trống nhân sự!\n";
        } else {
            IDNS = selected.getID_Nhansu();
        }
        if (Tentk.isEmpty()) {
            counterror = 1;
            msg_error = msg_error + "Tài khoản không được để trống!\n";
        } else if (isAccountExists(Tentk, id)) {
            counterror = 1;
            msg_error = msg_error + "Tài khoản bị trùng!\n";
        }
        if (Mk.isEmpty()) {
            counterror = 1;
            msg_error = msg_error + "Mật khẩu không được để trống!\n";
        } else if (Mk.length() < 8) {
            counterror = 1;
            msg_error = msg_error + "Mật khẩu ít nhất 8 ký tự!\n";
        }
        if (counterror == 0) {
            try {
                pst = con.prepareStatement("UPDATE taikhoan set Ten_Taikhoan=?,Matkhau=?,ID_Nhansu=?,Quyen=?,Trangthai=? where ID_Taikhoan=?");
                pst.setString(1, Tentk);
                pst.setString(2, Mk);
                pst.setInt(3, IDNS);
                pst.setBoolean(4, Admin);
                pst.setBoolean(5, Trangthai);
                pst.setInt(6, id);

                pst.executeUpdate();

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Thông báo");

                alert.setHeaderText("Cập nhật Tài khoản");
                alert.setContentText("Thành cônggg!");
                alert.showAndWait();
                lstTK.clear();
                LoadTableTK();
                TK_CbB_NS.setValue(null);
                TK_TF_TenTK.setText("");
                TK_TF_Mk.setText("");
                TK_ChB_Admin.setSelected(false);
                TK_ChB_Trangthai.setSelected(false);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Lỗi");
            alert.setHeaderText("Cập nhật Tài khoản");
            alert.setContentText(msg_error);
            alert.showAndWait();
        }
    }

    @FXML
    void TK_onclick_Them(ActionEvent event) {
        DTO_CbBNhansu selected = TK_CbB_NS.getValue();
        String Tentk = TK_TF_TenTK.getText();
        String Mk = TK_TF_Mk.getText();
        int IDNS = (selected != null) ? selected.getID_Nhansu() : 0;
        boolean Admin = TK_ChB_Admin.isSelected();
        boolean Trangthai = TK_ChB_Trangthai.isSelected();

        int counterror = 0;
        String msg_error = "";

        if (selected == null) {
            counterror = 1;
            msg_error = msg_error + "Vui lòng không để trống!\n";
        } else if (Tentk.isEmpty()) {
            counterror = 1;
            msg_error = msg_error + "Tài khoản không được để trống!\n";
        } else if (isAccountExists(Tentk)) {
            counterror = 1;
            msg_error = msg_error + "Tài khoản đã tồn tại!\n";
        } else if (Mk.length() < 8 || Mk.isEmpty()) {
            counterror = 1;
            msg_error = msg_error + "Mật khẩu ít nhất 8 ký tự!\n";
        }

        if (counterror == 0) {
            try {
                pst = con.prepareStatement("INSERT INTO taikhoan(Ten_Taikhoan,Matkhau,ID_Nhansu,Quyen,Trangthai) "
                        + "VALUES (?,?,?,?,?)");
                pst.setString(1, Tentk);
                pst.setString(2, Mk);
                pst.setInt(3, IDNS);
                pst.setBoolean(4, Admin);
                pst.setBoolean(5, Trangthai);
                pst.executeUpdate();

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Thông báo");
                alert.setHeaderText("Thêm Tài khoản");
                alert.setContentText("Thành công!");
                alert.showAndWait();

                lstTK.clear();
                LoadTableTK();
                TK_CbB_NS.setValue(null);
                TK_TF_TenTK.setText("");
                TK_TF_Mk.setText("");
                TK_ChB_Admin.setSelected(false);
                TK_ChB_Trangthai.setSelected(false);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Lỗi");
            alert.setHeaderText("Thêm Tài khoản");
            alert.setContentText(msg_error);
            alert.showAndWait();
        }
    }


    @FXML
    void NS_onClick_Capnhat(ActionEvent event) {
        String TenNS = NS_TF_TenNS.getText();
        String SDT = NS_TF_SDT.getText();
        String Mail = NS_TF_Mail.getText();
        String CCCD = NS_TF_CCCD.getText();
        String TenChucvu = NS_TF_Chucvu.getText();
        boolean Trangthai = NS_ChB_Trangthai.isSelected();
        myIndex = NS_TV_NS.getSelectionModel().getSelectedIndex();

        String Ngaysinh = "";
        String Ngaylam = "";
        LocalDate dob = NS_DP_Ngaysinh.getValue();
        LocalDate dow = NS_DP_Ngaysinh.getValue();
        int counterror = 0;
        String msg_error = "";
        if (myIndex != -1) {
            id = Integer.parseInt(String.valueOf(NS_TV_NS.getItems().get(myIndex).getID_Nhansu()));
        } else {
            counterror = 1;
            msg_error = "Vui lòng chọn dòng!\n";
        }
        if (TenNS.isEmpty()) {
            counterror = 1;
            msg_error = msg_error + "Tên người dùng không được phép trống!\n";
        } else if (!TenNS.matches("^[\\p{L} '-]+$")) {
            counterror = 1;
            msg_error = msg_error + "Tên người dùng không chứa số và ký tự đặc biệt\n";
        }
        if (SDT.isEmpty()) {
            counterror = 1;
            msg_error = msg_error + "Số điện thoại không được phép trống!\n";
        } else if (isPhoneNumberExists(SDT, id)) {
            counterror = 1;
            msg_error = msg_error + "Số điện thoại đã tồn  tại\n";
        } else if (!SDT.matches("\\d{1,10}")) {
            counterror = 1;
            msg_error = msg_error + "Số điện thoại phải là 12 số\n";
        }
        if (Mail.isEmpty()) {
            counterror = 1;
            msg_error = msg_error + "Mail không được phép trống!\n";
        }
        if (CCCD.isEmpty()) {
            counterror = 1;
            msg_error = msg_error + "Căn cước công dân không được phép trống!\n";
        } else if (isCCCDExists(CCCD, id)) {
            counterror = 1;
            msg_error = msg_error + "Căn cước công dân đã tồn  tại\n";
        } else if (!CCCD.matches("\\d{1,12}")) {
            counterror = 1;
            msg_error = msg_error + "Căn cước công dân phải là 12 số\n";
        }
        if (NS_DP_Ngaylam.getValue() != null && NS_DP_Ngaysinh.getValue() != null) {
            Period age = Period.between(dob, LocalDate.now());
            if (age.getYears() < 16) {
                counterror = 1;
                msg_error = msg_error + "Độ tuổi không được phép dưới 16 tuổi!\n";
            } else {
                Ngaylam = NS_DP_Ngaylam.getValue().toString();
                Ngaysinh = NS_DP_Ngaysinh.getValue().toString();
            }
        } else {
            counterror = 1;
            msg_error = msg_error + "Ngày không được phép trống!\n";
        }
        if (TenChucvu.isEmpty()) {
            counterror = 1;
            msg_error = msg_error + "Tên chức vụ không được phép trống!\n";
        } else if (!TenChucvu.matches("^[\\p{L} '-]+$")) {
            counterror = 1;
            msg_error = msg_error + "Tên chức  không chứa số và ký tự đặc biệt\n";
        }
        if (counterror == 0) {
            try {
                pst = con.prepareStatement("UPDATE nhansu set Ten_Nhansu=?,SDT=?,Mail=?,CCCD=?,Ngayvaolam=?,Ngaysinh=?,TenChucvu=?,Trangthai=? where ID_Nhansu=?");
                pst.setString(1, TenNS);
                pst.setString(2, SDT);
                pst.setString(3, Mail);
                pst.setString(4, CCCD);
                pst.setString(5, Ngaylam);
                pst.setString(6, Ngaysinh);
                pst.setString(7, TenChucvu);
                pst.setBoolean(8, Trangthai);
                pst.setInt(9, id);
                pst.executeUpdate();

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Thông báo");

                alert.setHeaderText("Cập nhật Nhân sự");
                alert.setContentText("Thành cônggg!");
                alert.showAndWait();
                TK_bindingNhansu();
                lstNS.clear();
                LoadTableNS();
                NS_DP_Ngaylam.setValue(null);
                NS_DP_Ngaysinh.setValue(null);
                NS_TF_TenNS.setText("");
                NS_TF_SDT.setText("");
                NS_TF_Mail.setText("");
                NS_TF_CCCD.setText("");
                NS_TF_Chucvu.setText("");
                NS_ChB_Trangthai.setSelected(false);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } else {
            // Hiển thị thông báo lỗi nếu có
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Lỗi");
            alert.setHeaderText("Cập nhật nhân sự");
            alert.setContentText(msg_error);
            alert.showAndWait();
        }

    }

    @FXML
    void NS_onClick_Them(ActionEvent event) {
        String TenNS = NS_TF_TenNS.getText();
        String SDT = NS_TF_SDT.getText();
        String Mail = NS_TF_Mail.getText();
        String CCCD = NS_TF_CCCD.getText();
        String TenChucvu = NS_TF_Chucvu.getText();
        boolean Trangthai = NS_ChB_Trangthai.isSelected();
        myIndex = NS_TV_NS.getSelectionModel().getSelectedIndex();

        String Ngaysinh = "";
        String Ngaylam = "";
        LocalDate dob = NS_DP_Ngaysinh.getValue();
        LocalDate dow = NS_DP_Ngaysinh.getValue();
        int counterror = 0;
        String msg_error = "";

        if (TenNS.isEmpty()) {
            counterror = 1;
            msg_error = msg_error + "Tên người dùng không được phép trống!\n";
        } else if (!TenNS.matches("^[\\p{L} '-]+$")) {
            counterror = 1;
            msg_error = msg_error + "Tên người dùng không chứa số và ký tự đặc biệt\n";
        }
        if (SDT.isEmpty()) {
            counterror = 1;
            msg_error = msg_error + "Số điện thoại không được phép trống!\n";
        } else if (isPhoneNumberExists(SDT)) {
            counterror = 1;
            msg_error = msg_error + "Số điện thoại đã tồn  tại\n";
        } else if (!SDT.matches("\\d{1,10}")) {
            counterror = 1;
            msg_error = msg_error + "Số điện thoại phải là 12 số\n";
        }
        if (Mail.isEmpty()) {
            counterror = 1;
            msg_error = msg_error + "Mail không được phép trống!\n";
        }
        if (CCCD.isEmpty()) {
            counterror = 1;
            msg_error = msg_error + "Căn cước công dân không được phép trống!\n";
        } else if (isCCCDExists(CCCD)) {
            counterror = 1;
            msg_error = msg_error + "Căn cước công dân đã tồn  tại\n";
        } else if (!CCCD.matches("\\d{1,12}")) {
            counterror = 1;
            msg_error = msg_error + "Căn cước công dân phải là 12 số\n";
        }
        if (NS_DP_Ngaylam.getValue() != null && NS_DP_Ngaysinh.getValue() != null) {
            Period age = Period.between(dob, LocalDate.now());
            if (age.getYears() < 16) {
                counterror = 1;
                msg_error = msg_error + "Độ tuổi không được phép dưới 16 tuổi!\n";
            } else {
                Ngaylam = NS_DP_Ngaylam.getValue().toString();
                Ngaysinh = NS_DP_Ngaysinh.getValue().toString();
            }
        } else {
            counterror = 1;
            msg_error = msg_error + "Ngày không được phép trống!\n";
        }
        if (TenChucvu.isEmpty()) {
            counterror = 1;
            msg_error = msg_error + "Tên chức vụ không được phép trống!\n";
        } else if (!TenChucvu.matches("^[\\p{L} '-]+$")) {
            counterror = 1;
            msg_error = msg_error + "Tên chức  không chứa số và ký tự đặc biệt\n";
        }
        // Nếu có lỗi, hiển thị thông báo và không thực hiện thêm nhân sự
        if (counterror == 0) {
            try {
                // Thêm nhân sự vào cơ sở dữ liệu
                pst = con.prepareStatement("INSERT INTO nhansu(Ten_Nhansu, SDT, Mail, CCCD, Ngayvaolam, Ngaysinh, TenChucvu, Trangthai) "
                        + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
                pst.setString(1, TenNS);
                pst.setString(2, SDT);
                pst.setString(3, Mail);
                pst.setString(4, CCCD);
                pst.setDate(5, java.sql.Date.valueOf(Ngaylam));
                pst.setDate(6, java.sql.Date.valueOf(Ngaysinh));
                pst.setString(7, TenChucvu);
                pst.setBoolean(8, Trangthai);
                pst.executeUpdate();

                // Hiển thị thông báo thành công
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Thông báo");
                alert.setHeaderText("Thêm Nhân sự");
                alert.setContentText("Thành công!");
                alert.showAndWait();
                TK_bindingNhansu();
                // Cập nhật bảng nhân sự và làm sạch trường nhập liệu
                lstNS.clear();
                LoadTableNS();
                NS_DP_Ngaylam.setValue(null);
                NS_DP_Ngaysinh.setValue(null);
                NS_TF_TenNS.setText("");
                NS_TF_SDT.setText("");
                NS_TF_Mail.setText("");
                NS_TF_CCCD.setText("");
                NS_TF_Chucvu.setText("");
                NS_ChB_Trangthai.setSelected(false);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Lỗi");
            alert.setHeaderText("Thêm nhân sự");
            alert.setContentText(msg_error);
            alert.showAndWait();
        }
    }



    @FXML
    void SP_TimSP(KeyEvent event) {
        String tim = SP_TF_TimSP.getText().toLowerCase();
        FilteredList<DTO_Admin_SanPham> filteredData = new FilteredList<>(lstSP, p -> true);
        filteredData.setPredicate(item -> {
            // Nếu không có từ khóa tìm kiếm, hiển thị tất cả dữ liệu
            if (tim == null || tim.isEmpty()) {
                return true;
            }

            if (String.valueOf(item.getID_Sp()).toLowerCase().contains(tim)
                    || item.getTen_Sp().toLowerCase().contains(tim)
                    || item.getDonvitinh().toLowerCase().contains(tim)
                    || item.getTen_loai().toLowerCase().contains(tim)){
                return true;
            }

            return false;
        });
        // Tạo một SortedList để sắp xếp dữ liệu và áp dụng bộ lọc tìm kiếm
        SortedList<DTO_Admin_SanPham> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(SP_TV_SP.comparatorProperty());
        SP_TV_SP.setItems(sortedData);

    }
    
    @FXML
    void SP_onClick_Capnhat(ActionEvent event) {
        DTO_Loai selectedLoai = SP_CbB_Loai.getValue();
        DTO_Donvitinh selectedDVT = SP_CbB_Donvitinh.getValue();
        if (selectedLoai != null && selectedDVT != null) {
            String TenSP = SP_TF_TenSP.getText();
            double gia = 0.0; // Initialize gia to 0.0
            try {
                gia = parseDouble(SP_TF_Gia.getText());
            } catch (NumberFormatException e) {
                // If gia cannot be parsed to a double, it means the field is empty or invalid.
                // Display an error message and return from the function.
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Lỗi");
                alert.setHeaderText("Cập nhật Sản Phẩm");
                alert.setContentText("Vui lòng nhập giá sản phẩm!");
                alert.showAndWait();
                return;
            }
            int IDLoai = selectedLoai.getID_Loai();

            int IDDVT = selectedDVT.getID_Donvitinh();
            boolean Trangthai = SP_ChB_Trangthai.isSelected();
            myIndex = SP_TV_SP.getSelectionModel().getSelectedIndex();
            id = Integer.parseInt(String.valueOf(SP_TV_SP.getItems().get(myIndex).getID_Sp()));
            if (isProductExists(TenSP, id)) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Lỗi");
                alert.setHeaderText("Cập nhật Sản Phẩm");
                alert.setContentText("Tên sản phẩm không được trùng!");
                alert.showAndWait();
            } else {
                try {
                    pst = con.prepareStatement("UPDATE sanpham set Ten_Sp=?,ID_Loai=?,Gia=?,ID_Donvitinh=?,Trangthai=? where ID_Sp=? ");

                    pst.setString(1, TenSP);
                    pst.setInt(2, IDLoai);
                    pst.setDouble(3, gia);
                    pst.setInt(4, IDDVT);
                    pst.setBoolean(5, Trangthai);
                    pst.setInt(6, id);
                    pst.executeUpdate();

                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Thông báo");

                    alert.setHeaderText("Cập nhật Sản phẩm");
                    alert.setContentText("Thành cônggg!");
                    alert.showAndWait();
                    lstSP.clear();
                    LoadTableSP();
                    SP_CbB_Donvitinh.setValue(null);
                    SP_CbB_Loai.setValue(null);
                    SP_TF_TenSP.setText("");
                    SP_TF_Gia.setText("");
                    SP_ChB_Trangthai.setSelected(false);
                } catch (SQLException ex) {
                    ex.printStackTrace();

                }
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Lỗi");
            alert.setHeaderText("Cập nhật Sản Phẩm");
            alert.setContentText("Vui lòng chọn dòng!");
            alert.showAndWait();
        }
    }

    @FXML
    void SP_onClick_Them(ActionEvent event) {
        DTO_Loai selectedLoai = SP_CbB_Loai.getValue();
        DTO_Donvitinh selectedDVT = SP_CbB_Donvitinh.getValue();
        String TenSP = SP_TF_TenSP.getText();
        
        double gia = 0.0;
        try {
                gia = parseDouble(SP_TF_Gia.getText());
            } catch (NumberFormatException e) {
                // If gia cannot be parsed to a double, it means the field is empty or invalid.
                // Display an error message and return from the function.
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Lỗi");
                alert.setHeaderText("Cập nhật Sản Phẩm");
                alert.setContentText("Vui lòng nhập giá sản phẩm!");
                alert.showAndWait();
                return;
            }
        int counterror = 0;
        String msg_error = "";

        // Kiểm tra loại sản phẩm và đơn vị tính đã được chọn hay chưa
        if (selectedLoai == null) {
            counterror = 1;
            msg_error = msg_error + "Vui lòng chọn loại sản phẩm!\n";
        }
        if (selectedDVT == null) {
            counterror = 1;
            msg_error = msg_error + "Vui lòng chọn đơn vị tính!\n";
        }

        // Kiểm tra tên sản phẩm không được để trống và phải duy nhất
        if (TenSP.isEmpty()) {
            counterror = 1;
            msg_error = msg_error + "Tên sản phẩm không được để trống!\n";
        } else if (isProductExists(TenSP)) {
            counterror = 1;
            msg_error = msg_error + "Tên sản phẩm đã tồn tại!\n";
        }

        // Kiểm tra giá sản phẩm không được để trống và phải là số
        if (counterror == 0) {
            try {
                // Thực hiện việc thêm thông tin sản phẩm vào cơ sở dữ liệu...
                pst = con.prepareStatement("INSERT INTO sanpham(Ten_Sp,ID_Loai,Gia,Sluong,ID_Donvitinh,Trangthai) "
                        + "VALUES (?,?,?,?,?,?)");
                pst.setString(1, TenSP);
                pst.setInt(2, selectedLoai.getID_Loai());
                pst.setDouble(3, gia);
                pst.setInt(4, 0);
                pst.setInt(5, selectedDVT.getID_Donvitinh());
                pst.setBoolean(6, SP_ChB_Trangthai.isSelected());
                pst.executeUpdate();

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Thông báo");
                alert.setHeaderText("Thêm Sản phẩm");
                alert.setContentText("Thành công!");
                alert.showAndWait();

                lstSP.clear();
                LoadTableSP();
                SP_CbB_Donvitinh.setValue(null);
                SP_CbB_Loai.setValue(null);
                SP_TF_TenSP.setText("");
                SP_TF_Gia.setText("");
                SP_ChB_Trangthai.setSelected(false);

            } catch (SQLException ex) {
                Logger.getLogger(HomeController.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            // Hiển thị thông báo lỗi nếu có
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Lỗi");
            alert.setHeaderText("Thêm sản phẩm");
            alert.setContentText(msg_error);
            alert.showAndWait();
        }
    }



    ObservableList<DTO_Admin_SanPham> lstSP = FXCollections.observableArrayList();
    ObservableList<DTO_Nhansu> lstNS = FXCollections.observableArrayList();
    ObservableList<DTO_Taikhoan> lstTK = FXCollections.observableArrayList();
    ObservableList<DTO_CbBNhansu> lstCbBNhansu = FXCollections.observableArrayList();
    ObservableList<DTO_Magiam> lstMGiam = FXCollections.observableArrayList();
    Connection con;
    PreparedStatement pst;
    int myIndex;
    int id;

    int userID;
    String userName;
    boolean admin;

    public void setUserID(int userID, String userName,boolean admin) {
        this.userID = userID;
        this.userName = userName;
        this.admin = admin;
    }
    
    
    private boolean isAccountExists(String name) {
        try {
            pst = con.prepareStatement("SELECT * FROM taikhoan WHERE Ten_Taikhoan = ?");
            pst.setString(1, name);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return true;
            } else {
                return false;// Nếu có kết quả trả về, tức là tên khách hàng đã tồn tại trong cơ sở dữ liệu
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    private boolean isAccountExists(String Tentk, int id) {
        try {
            pst = con.prepareStatement("SELECT * FROM taikhoan WHERE Ten_Taikhoan = ? AND NOT ID_Taikhoan = ?");
            pst.setString(1, Tentk);
            pst.setInt(2, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return true;
            } else {
                return false;// Nếu có kết quả trả về, tức là tên khách hàng đã tồn tại trong cơ sở dữ liệu
            } // Nếu có kết quả trả về, tức là tên khách hàng đã tồn tại trong cơ sở dữ liệu
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
    private boolean isProductExists(String Ten_Sp, int id) {
        try {
            pst = con.prepareStatement("SELECT * FROM sanpham WHERE Ten_Sp = ? and NOT ID_Sp = ?");
            pst.setString(1, Ten_Sp);
            pst.setInt(2, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return true;
            }
            return false;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    private boolean isProductExists(String Ten_Sp) {
        try {
            pst = con.prepareStatement("SELECT * FROM sanpham WHERE Ten_Sp = ?");
            pst.setString(1, Ten_Sp);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return true;
            }
            return false;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
    // Hàm kiểm tra số điện thoại tồn tại trong cơ sở dữ liệu
    private boolean isPhoneNumberExists(String sdt) {
        try {
            pst = con.prepareStatement("SELECT * FROM nhansu WHERE SDT = ?");
            pst.setString(1, sdt);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return true;
            }
            return false;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    private boolean isCCCDExists(String cccd) {
        try {
            pst = con.prepareStatement("SELECT * FROM nhansu WHERE CCCD = ?");
            pst.setString(1, cccd);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return true;
            }
            return false;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    // Hàm kiểm tra số điện thoại tồn tại trong cơ sở dữ liệu
    private boolean isPhoneNumberExists(String sdt, int id) {
        try {
            pst = con.prepareStatement("SELECT * FROM nhansu WHERE SDT = ? AND NOT ID_Nhansu  = ?");
            pst.setString(1, sdt);
            pst.setInt(2, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return true;
            }
            return false;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    private boolean isCCCDExists(String cccd, int id) {
        try {
            pst = con.prepareStatement("SELECT * FROM nhansu WHERE CCCD = ? AND NOT ID_Nhansu  = ?");
            pst.setString(1, cccd);
            pst.setInt(2, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return true;
            }
            return false;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
    private boolean isMagiamExists(String Ten) {
        try {
            pst = con.prepareStatement("SELECT * FROM magiam WHERE Ten_Magiam = ?");
            pst.setString(1, Ten);
            ResultSet rs = pst.executeQuery();
            return rs.next(); // Nếu có kết quả trả về, tức là tên khách hàng đã tồn tại trong cơ sở dữ liệu
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    private boolean isMagiamExists(String Ten, int id) {
        try {
            pst = con.prepareStatement("SELECT * FROM magiam WHERE Ten_Magiam = ? AND NOT ID_Magiam = ?");
            pst.setString(1, Ten);
            pst.setInt(2, id);
            ResultSet rs = pst.executeQuery();
            return rs.next(); // Nếu có kết quả trả về, tức là tên khách hàng đã tồn tại trong cơ sở dữ liệu
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    

    public void LoadTableMGiam() {
        try {
            pst = con.prepareStatement("SELECT * FROM magiam where not ID_Magiam=1");
            ResultSet rs = pst.executeQuery();
            {
                while (rs.next()) {
                    int ID_Magiam = rs.getInt("ID_Magiam");
                    String Ten_Magiam = rs.getString("Ten_Magiam");
                    int Chietkhau = rs.getInt("Chietkhau");
                    boolean Trangthai = rs.getBoolean("Trangthai");
                    DTO_Magiam sp = new DTO_Magiam(ID_Magiam, Ten_Magiam, Chietkhau, Trangthai);
                    lstMGiam.add(sp);
                }
            }
            MG_TV_MG.setItems(lstMGiam);
            MG_Col_ID.setCellValueFactory(new PropertyValueFactory<>("ID_Magiam"));
            MG_Col_Ten.setCellValueFactory(new PropertyValueFactory<>("Ten_Magiam"));
            MG_Col_Chietkhau.setCellValueFactory(new PropertyValueFactory<>("Chietkhau"));
            MG_Col_Trangthai.setCellValueFactory(new PropertyValueFactory<>("Trangthai"));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        MG_TV_MG.setRowFactory(tv -> {
            TableRow<DTO_Magiam> myRow = new TableRow<>();
            myRow.setOnMouseClicked(event
                    -> {
                if (event.getClickCount() == 1 && (!myRow.isEmpty())) {
                    myIndex = MG_TV_MG.getSelectionModel().getSelectedIndex();
                    id = Integer.parseInt(String.valueOf(MG_TV_MG.getItems().get(myIndex).getID_Magiam()));
                    MG_TF_Ten.setText(MG_TV_MG.getItems().get(myIndex).getTen_Magiam());
                    MG_Spn_Chietkhau.getValueFactory().setValue((MG_TV_MG.getItems().get(myIndex).getChietkhau()));
                    MG_ChB_Trangthai.setSelected(MG_TV_MG.getItems().get(myIndex).isTrangthai());
                }
            });
            return myRow;
        });
    }

    public void LoadTableTK() {
        try {
            pst = con.prepareStatement("SELECT t.* , n.Ten_Nhansu FROM taikhoan t, nhansu n WHERE t.ID_Nhansu = n.ID_Nhansu");
            ResultSet rs = pst.executeQuery();
            {
                while (rs.next()) {
                    int ID_Taikhoan = rs.getInt("ID_Taikhoan");
                    String Ten_Taikhoan = rs.getString("Ten_Taikhoan");
                    String Matkhau = rs.getString("Matkhau");
                    int ID_Nhansu = rs.getInt("ID_Nhansu");
                    String Ten_Nhansu = rs.getString("Ten_Nhansu");
                    boolean Quyen = rs.getBoolean("Quyen");
                    boolean Trangthai = rs.getBoolean("Trangthai");
                    DTO_Taikhoan sp = new DTO_Taikhoan(ID_Taikhoan, Ten_Taikhoan, Matkhau, ID_Nhansu, Ten_Nhansu, Quyen, Trangthai);
                    lstTK.add(sp);
                }
            }
            TK_TV_TK.setItems(lstTK);
            TK_Col_IDTK.setCellValueFactory(new PropertyValueFactory<>("ID_Taikhoan"));
            TK_Col_TenTK.setCellValueFactory(new PropertyValueFactory<>("Ten_Taikhoan"));
            TK_Col_MK.setCellValueFactory(new PropertyValueFactory<>("Matkhau"));
            TK_Col_TenNS.setCellValueFactory(new PropertyValueFactory<>("Ten_Nhansu"));
            TK_Col_Admin.setCellValueFactory(new PropertyValueFactory<>("Quyen"));
            TK_Col_Trangthai.setCellValueFactory(new PropertyValueFactory<>("Trangthai"));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        TK_TV_TK.setRowFactory(tv -> {
            TableRow<DTO_Taikhoan> myRow = new TableRow<>();
            myRow.setOnMouseClicked(event
                    -> {
                if (event.getClickCount() == 1 && (!myRow.isEmpty())) {
                    myIndex = TK_TV_TK.getSelectionModel().getSelectedIndex();
                    id = Integer.parseInt(String.valueOf(TK_TV_TK.getItems().get(myIndex).getID_Taikhoan()));
                    TK_TF_TenTK.setText(TK_TV_TK.getItems().get(myIndex).getTen_Taikhoan());
                    TK_TF_Mk.setText(TK_TV_TK.getItems().get(myIndex).getMatkhau());
                    DTO_CbBNhansu temp = new DTO_CbBNhansu(TK_TV_TK.getItems().get(myIndex).getID_Nhansu(), String.valueOf(TK_TV_TK.getItems().get(myIndex).getTen_Nhansu()));
                    TK_CbB_NS.setValue(temp);
                    TK_ChB_Admin.setSelected(TK_TV_TK.getItems().get(myIndex).isQuyen());
                    TK_ChB_Trangthai.setSelected(TK_TV_TK.getItems().get(myIndex).isTrangthai());
                }
            });
            return myRow;
        });
    }

    public void LoadTableSP() {
        try {
            pst = con.prepareStatement("select s.* ,d.Donvitinh, l.Ten_Loai from sanpham s,donvitinh d, loai l where s.ID_Loai=l.ID_Loai and s.ID_Donvitinh=d.ID_Donvitinh");
            ResultSet rs = pst.executeQuery();
            {
                while (rs.next()) {
                    int ID_Sp = rs.getInt("ID_Sp");
                    String Ten_Sp = rs.getString("Ten_Sp");
                    int ID_Loai = rs.getInt("ID_Loai");
                    String Ten_Loai = rs.getString("Ten_Loai");
                    double Gia = rs.getDouble("Gia");
                    int Sluong = rs.getInt("Sluong");
                    int ID_Donvitinh = rs.getInt("ID_Donvitinh");
                    String Donvitinh = rs.getString("Donvitinh");
                    boolean Trangthai = rs.getBoolean("Trangthai");
                    DTO_Admin_SanPham sp = new DTO_Admin_SanPham(ID_Sp, Ten_Sp, ID_Loai, Ten_Loai, Gia, Sluong, ID_Donvitinh, Donvitinh, Trangthai);
                    lstSP.add(sp);
                }
            }
            SP_TV_SP.setItems(lstSP);
            SP_Col_IDSP.setCellValueFactory(new PropertyValueFactory<>("ID_Sp"));
            SP_Col_TenSP.setCellValueFactory(new PropertyValueFactory<>("Ten_Sp"));
            SP_Col_TenLoai.setCellValueFactory(new PropertyValueFactory<>("Ten_loai"));
            SP_Col_GIa.setCellValueFactory(new PropertyValueFactory<>("Gia"));
            SP_Col_Sluong.setCellValueFactory(new PropertyValueFactory<>("Sluong"));
            SP_Col_Donvitinh.setCellValueFactory(new PropertyValueFactory<>("Donvitinh"));
            SP_Col_Trangthai.setCellValueFactory(new PropertyValueFactory<>("Trangthai"));

        } catch (SQLException ex) {
            Logger.getLogger(HomeController.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

        SP_TV_SP.setRowFactory(tv -> {
            TableRow<DTO_Admin_SanPham> myRow = new TableRow<>();
            myRow.setOnMouseClicked(event
                    -> {
                if (event.getClickCount() == 1 && (!myRow.isEmpty())) {
                    myIndex = SP_TV_SP.getSelectionModel().getSelectedIndex();
                    id = Integer.parseInt(String.valueOf(SP_TV_SP.getItems().get(myIndex).getID_Sp()));
                    SP_TF_TenSP.setText(SP_TV_SP.getItems().get(myIndex).getTen_Sp());
                    SP_TF_Gia.setText(String.valueOf(SP_TV_SP.getItems().get(myIndex).getGia()));
                    DTO_Loai temp = new DTO_Loai(SP_TV_SP.getItems().get(myIndex).getID_Loai(), String.valueOf(SP_TV_SP.getItems().get(myIndex).getTen_loai()));
                    SP_CbB_Loai.setValue(temp);
                    DTO_Donvitinh temp2 = new DTO_Donvitinh(SP_TV_SP.getItems().get(myIndex).getID_Donvitinh(), String.valueOf(SP_TV_SP.getItems().get(myIndex).getDonvitinh()));
                    SP_CbB_Donvitinh.setValue(temp2);
                    SP_ChB_Trangthai.setSelected(SP_TV_SP.getItems().get(myIndex).getTrangthai());
                }
            });
            return myRow;
        });
    }

    public void LoadTableNS() {
        try {
            pst = con.prepareStatement("select * from nhansu");
            ResultSet rs = pst.executeQuery();
            {
                while (rs.next()) {
                    int ID_NS = rs.getInt("ID_Nhansu");
                    String Ten_NS = rs.getString("Ten_Nhansu");
                    String SDT = rs.getString("SDT");
                    String Mail = rs.getString("Mail");
                    String CCCD = rs.getString("CCCD");
                    Date Ngayvaolam = rs.getDate("Ngayvaolam");
                    Date Ngaysinh = rs.getDate("Ngaysinh");
                    String TenChucvu = rs.getString("TenChucvu");
                    boolean Trangthai = rs.getBoolean("Trangthai");
                    DTO_Nhansu ns = new DTO_Nhansu(ID_NS, Ten_NS, SDT, Mail, CCCD, Ngayvaolam, Ngaysinh, TenChucvu, Trangthai);
                    lstNS.add(ns);
                }
            }
            NS_TV_NS.setItems(lstNS);
            NS_Col_IDNS.setCellValueFactory(new PropertyValueFactory<>("ID_Nhansu"));
            NS_Col_TenNS.setCellValueFactory(new PropertyValueFactory<>("Ten_Nhansu"));
            NS_Col_SDT.setCellValueFactory(new PropertyValueFactory<>("SDT"));
            NS_Col_Mail.setCellValueFactory(new PropertyValueFactory<>("Mail"));
            NS_Col_CCCD.setCellValueFactory(new PropertyValueFactory<>("CCCD"));
            NS_Col_Ngaylam.setCellValueFactory(new PropertyValueFactory<>("Ngayvaolam"));
            NS_Col_Ngaysinh.setCellValueFactory(new PropertyValueFactory<>("Ngaysinh"));
            NS_Col_Chucvu.setCellValueFactory(new PropertyValueFactory<>("TenChucvu"));
            NS_Col_Trangthai.setCellValueFactory(new PropertyValueFactory<>("Trangthai"));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        NS_TV_NS.setRowFactory(tv -> {
            TableRow<DTO_Nhansu> myRow = new TableRow<>();
            myRow.setOnMouseClicked(event
                    -> {
                if (event.getClickCount() == 1 && (!myRow.isEmpty())) {
                    myIndex = NS_TV_NS.getSelectionModel().getSelectedIndex();
                    id = Integer.parseInt(String.valueOf(NS_TV_NS.getItems().get(myIndex).getID_Nhansu()));
                    NS_TF_TenNS.setText(NS_TV_NS.getItems().get(myIndex).getTen_Nhansu());
                    NS_TF_SDT.setText(String.valueOf(NS_TV_NS.getItems().get(myIndex).getSDT()));
                    NS_TF_Mail.setText(NS_TV_NS.getItems().get(myIndex).getMail());
                    NS_TF_CCCD.setText(String.valueOf(NS_TV_NS.getItems().get(myIndex).getCCCD()));
                    java.util.Date utilDateValue = NS_TV_NS.getItems().get(myIndex).getNgayvaolam();
                    java.sql.Date sqlDateValue = new java.sql.Date(utilDateValue.getTime());
                    LocalDate localDate = sqlDateValue.toLocalDate();
                    NS_DP_Ngaylam.setValue(localDate);
                    java.util.Date utilDateValue2 = NS_TV_NS.getItems().get(myIndex).getNgaysinh();
                    java.sql.Date sqlDateValue2 = new java.sql.Date(utilDateValue2.getTime());
                    LocalDate localDate2 = sqlDateValue2.toLocalDate();
                    NS_DP_Ngaysinh.setValue(localDate2);
                    NS_TF_Chucvu.setText(NS_TV_NS.getItems().get(myIndex).getTenChucvu());
                    NS_ChB_Trangthai.setSelected(NS_TV_NS.getItems().get(myIndex).isTrangthai());
                }
            });
            return myRow;
        });
    }

    public void TK_bindingNhansu() {
        try {
            TK_CbB_NS.getItems().clear();
            String sql = "SELECT * FROM nhansu";
            pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int iditem = rs.getInt("ID_Nhansu");
                String name = rs.getString("Ten_Nhansu");
                DTO_CbBNhansu item = new DTO_CbBNhansu(iditem, name);
                TK_CbB_NS.getItems().add(item);
                TK_CbB_NS.setCellFactory(param -> new ListCell<DTO_CbBNhansu>() {
                    @Override
                    protected void updateItem(DTO_CbBNhansu item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty || item == null) {
                            setText(null);
                        } else {
                            setText("ID: "+item.getID_Nhansu()+ " - " + item.getTen_Nhansu());
                        }
                    }
                });
                TK_CbB_NS.setConverter(new StringConverter<DTO_CbBNhansu>() {
                    @Override
                    public String toString(DTO_CbBNhansu item) {
                        if (item == null) {
                            return null;
                        } else {
                            return "ID: "+item.getID_Nhansu()+ " - " + item.getTen_Nhansu();
                        }
                    }

                    @Override
                    public DTO_CbBNhansu fromString(String string) {
                        // Not used
                        return null;
                    }
                });
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void SP_bindingLoai() {
        try {
            
            String sql = "SELECT * FROM loai";
            pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int iditem = rs.getInt("ID_Loai");
                String name = rs.getString("Ten_Loai");
                DTO_Loai item = new DTO_Loai(iditem, name);
                SP_CbB_Loai.getItems().add(item);
                SP_CbB_Loai.setCellFactory(param -> new ListCell<DTO_Loai>() {
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
                SP_CbB_Loai.setConverter(new StringConverter<DTO_Loai>() {
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

    public void SP_bindingDonvitinh() {
        try {
            SP_CbB_Donvitinh.setValue(null);
            String sql = "SELECT * FROM donvitinh";
            pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int iditem = rs.getInt("ID_Donvitinh");
                String name = rs.getString("Donvitinh");
                DTO_Donvitinh item = new DTO_Donvitinh(iditem, name);
                SP_CbB_Donvitinh.getItems().add(item);
                SP_CbB_Donvitinh.setCellFactory(param -> new ListCell<DTO_Donvitinh>() {
                    @Override
                    protected void updateItem(DTO_Donvitinh item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty || item == null) {
                            setText(null);
                        } else {
                            setText(item.getDonvitinh());
                        }
                    }
                });
                SP_CbB_Donvitinh.setConverter(new StringConverter<DTO_Donvitinh>() {
                    @Override
                    public String toString(DTO_Donvitinh item) {
                        if (item == null) {
                            return null;
                        } else {
                            return item.getDonvitinh();
                        }
                    }

                    @Override
                    public DTO_Donvitinh fromString(String string) {
                        // Not used
                        return null;
                    }
                });
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
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
        // TODO
        Connect();
        LoadTableSP();
        LoadTableNS();
        LoadTableTK();
        LoadTableMGiam();
        SP_bindingLoai();
        SP_bindingDonvitinh();
        TK_bindingNhansu();
        SP_TF_Gia.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*(\\.\\d*)?")) {
                SP_TF_Gia.setText(oldValue);
            }
        });

        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100);
        valueFactory.setValue(0);
        MG_Spn_Chietkhau.setValueFactory(valueFactory);
        MG_Spn_Chietkhau.getEditor().setTextFormatter(new TextFormatter<Integer>(change -> {
            String sluong = MG_Spn_Chietkhau.getEditor().getText();
            if (sluong.isEmpty()) {
                MG_Spn_Chietkhau.getValueFactory().setValue(0);
            }
            String newText = change.getControlNewText();
            if (newText.matches("\\d*")) {
                return change;
            }
            return null;
        }));

    }

}
