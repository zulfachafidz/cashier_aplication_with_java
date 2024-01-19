/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package koneksi;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author zulfa
 */
public class koneksi {
    private String url="jdbc:mysql://localhost/dbwaroenkpeteng";
    private String username = "root";
    private String pass = "";
    private String port = "3306";
    private Connection con;
    
    public void connect(){
        try {
            con = (Connection) DriverManager.getConnection(url, username,pass);
            System.out.println("Koneksi Berhasil");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    public Connection getCon(){
            return con;
        }
}
