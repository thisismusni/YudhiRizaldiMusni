package PBO_I_172055;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class koneksiDB 
{
    static Connection koneksi;
    public static String nmaAdmin;
    public static Connection DCCkoneksi()
    {
        try 
        {
            koneksi = DriverManager.getConnection("jdbc:mysql://localhost:8889/SIAKA_172055","root","root");
        }
        catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(null, "Koneksi Database Gagal "+e.toString());
        }
        
        return koneksi;
    }
}
