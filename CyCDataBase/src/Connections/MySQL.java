package Connections;

public class MySQL extends IConnect {

    public static MySQL mysql;
    
    private MySQL(){}
    
    @Override
    public void setHost(String host, String dbName, Object obj) {
        int port = 3306;
        if (obj != null && obj instanceof Integer) {
            port = Integer.parseInt(obj.toString());
        }
        IConnect.host = "jdbc:mysql://" + host + ":"+port+"/" + dbName + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false";
    }

    public static IConnect newDataBaseConnection(String usu, String pass) {
        IConnect.usu = usu;
        IConnect.pass = pass;
        IConnect.classForName = "com.mysql.cj.jdbc.Driver";
        if (mysql == null) {
            return new MySQL();
        }
        return mysql;
    }

}
