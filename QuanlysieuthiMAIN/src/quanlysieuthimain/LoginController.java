/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package quanlysieuthimain;

import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;

/**
 *
 * @author luans
 */
public class LoginController implements Initializable {
    
    @FXML
    private TextField TF_AccLogin;
    @FXML
    private PasswordField PF_PassLogin;
    @FXML
    private Label LB_NotiLogin;
    @FXML
    private Button btnLogin;
    @FXML
    private void OnClick_BTN_Login(ActionEvent event) {

        try{
        String sql = "SELECT t.* , n.Ten_Nhansu FROM taikhoan t, nhansu n WHERE t.ID_Nhansu = n.ID_Nhansu and Ten_taikhoan = ? AND Matkhau = ?";
            pst = con.prepareStatement(sql);
            pst.setString(1, TF_AccLogin.getText());
            pst.setString(2, PF_PassLogin.getText());

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                if (rs.getBoolean("Trangthai")==true){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Thông báo");
                alert.setHeaderText("Đăng nhập tài khoản");
                alert.setContentText("Đăng nhập thành công!");
                alert.showAndWait();
                HomeScreen(rs.getInt("ID_Nhansu"),rs.getString("Ten_Nhansu"),rs.getBoolean("Quyen"));
                }
                else{
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Thông báo");
                alert.setHeaderText("Đăng nhập tài khoản");
                alert.setContentText("Tài khoản tạm ngừng hoạt động!");
                alert.showAndWait();
                }
            }
            else{
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Thông báo");
                alert.setHeaderText("Đăng nhập tài khoản");
                alert.setContentText("Tài khoản hoặc mật khẩu không chính xác!");
                alert.showAndWait();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    Connection con;
    PreparedStatement pst;
    
    
    public void HomeScreen(int id, String name,boolean trangthai) {
        
        try {
            btnLogin.getScene().getWindow().hide();
            Stage stage= (Stage) btnLogin.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Home.fxml"));
            Parent root = loader.load();
//            HomeController homeController = loader.getController();
//            homeController.setStage(primaryStage);
            Scene scene = new Scene(root);
            HomeController homeController = loader.getController();
            homeController.setPrimaryStage((Stage) btnLogin.getScene().getWindow());
            homeController.setUserID(id,name,trangthai);
            stage.setScene(scene);
            stage.setTitle("Home Screen");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void Connect()
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/sieuthimini","root","");
        } catch (ClassNotFoundException ex) {

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Connect();
    }    
    
}
