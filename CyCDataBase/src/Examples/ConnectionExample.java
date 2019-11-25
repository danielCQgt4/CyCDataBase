package Examples;

import Connections.*;
import Controllers.GeneralProcedures;
import Controllers.Idb;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ConnectionExample {

    public static void main(String[] args) {
        if (testConnection()) {
            testCRUD();
        }
    }

    public static boolean testConnection() {
        IConnect db = MySQL.newDataBaseConnection("user", "password");
        //IConnect db = MsSQL.newDataBaseConnection("user", "password");
        //IConnect db = Orcl.newDataBaseConnection("user", "password");
        db.setHost("ip.ip.ip.ip", "dbName", null); //null as default port, int like 3306 for MySQL
        JOptionPane.showMessageDialog(null, IConnect.getConnection() != null ? "Connection successfully" : "Connection failure");
        return IConnect.getConnection() != null;
    }

    public static void testCRUD() {
        Model model = new Model("model");
        boolean inserted = GeneralProcedures.insert(model, 1);
        ArrayList<Idb> dataModel = GeneralProcedures.sql(model, 1);
        boolean updated = GeneralProcedures.update(model, 1);
        boolean deleted = GeneralProcedures.delete(model, 1);
        System.out.println("inserted = " + inserted + "\nupdated = " + updated + "\ndeleted + " + deleted);
        for (Idb dataModel1 : dataModel) {
            System.out.println(((Model) dataModel1).getIdModel());
        }
    }

    public static void runDirectly() {
        String dml = "insert into [tableName] values ([value1],[value2],...)";
        boolean finish = GeneralProcedures.runDML(dml);
        System.out.println("The result is " + (finish ? "success" : "fail"));
    }
}
