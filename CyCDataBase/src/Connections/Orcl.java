package Connections;

public class Orcl extends IConnect{

    public static Orcl mysql;

    private Orcl() {
    }

    @Override
    public void setHost(String host, String dbName, Object obj) {
        int port = 1521;
        if (obj != null && obj instanceof Integer) {
            port = Integer.parseInt(obj.toString());
        }
        IConnect.host = "jdbc:oracle:thin:@" + host + ":"+port+":" + dbName + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false";
    }

    public static IConnect newDataBaseConnection(String usu, String pass) {
        IConnect.usu = usu;
        IConnect.pass = pass;
        IConnect.classForName = "oracle.jdbc.driver.OracleDriver";
        if (mysql == null) {
            return new Orcl();
        }
        return mysql;
    }
}
