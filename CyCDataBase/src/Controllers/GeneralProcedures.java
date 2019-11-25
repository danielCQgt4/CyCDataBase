package Controllers;

import Connections.IConnect;
import java.sql.*;
import java.util.ArrayList;

public class GeneralProcedures {

    public static boolean insert(Idb model, int number) {
        return runDML(model.getInsert(number));
    }

    public static boolean update(Idb model, int number) {
        return runDML(model.getUpdate(number));
    }

    public static boolean delete(Idb model, int number) {
        return runDML(model.getDelete(number));
    }

    public static ArrayList<Idb> sql(Idb model, int number) {
        ArrayList<Idb> datas = new ArrayList<>();
        try {
            ResultSet rs = getData(model.getSQL(number));
            while (rs.next()) {
                Idb data = model.getObject(rs, number);
                datas.add(data);
            }
        } catch (Exception e) {
            System.out.println(e + " --> /\"" + model.getSQL(number) + "\"");
        }
        return datas;
    }

    public static ResultSet getData(String sql) {
        try {
            Statement st = IConnect.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            return rs;
        } catch (Exception e) {
            System.out.println(e + " --> /\"" + sql + "\"");
            return null;
        }
    }

    public static boolean runDML(String dml) {
        try {
            PreparedStatement pps = IConnect.getConnection().prepareStatement(dml);
            int run = pps.executeUpdate();
            System.out.println(run + " --> /\"" + dml + "\"");
            return run != 0;
        } catch (Exception e) {
            System.out.println(e + " --> /\"" + dml + "\"");
            return false;
        }
    }
}
