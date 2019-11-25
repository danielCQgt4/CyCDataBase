package Connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public abstract class IConnect {

    public static String host;
    public static String usu;
    public static String pass;
    public static String dbName;
    public static Connection conn;
    public static String classForName;
    public static String errorMSG = "Cannot connect with the server.\nTry again.";
    
    public abstract void setHost(String host, String dbName, Object obj);

    public static Connection getConnection(){
        if (conn == null) {
            return createConnection();
        }
        return conn;
    }
    
    private static Connection createConnection() {
        try {
            Class.forName(classForName);
            conn = DriverManager.getConnection(IConnect.host, IConnect.usu, IConnect.pass);
            return conn;
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null,errorMSG);
            return null;
        }
    }

    public void setConfig(String host, String usu, String pass, String dbName) {
        IConnect.dbName = dbName;
        IConnect.host = host;
        IConnect.usu = usu;
        IConnect.pass = pass;
    }

    public static void setErrorMSG(String errorMSG) {
        IConnect.errorMSG = errorMSG;
    }
}
