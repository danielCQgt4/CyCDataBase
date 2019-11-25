package Connections;

public class MsSQL extends IConnect {

    public static MsSQL mysql;

    private MsSQL() {
    }

    @Override
    public void setHost(String host, String dbName, Object obj) {
        int port = 1433;
        if (obj != null && obj instanceof Integer) {
            port = Integer.parseInt(obj.toString());
        }
        IConnect.host = "jdbc:sqlserver://" + host + ":"+port+";databaseName=" + dbName;
        //+ ";integratedSecurity=true;encrypt=true;trustServerCertificate=true;trustStore=storeName;trustStorePassword=storePassword;hostNameInCertificate=hostName";
//useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false
    }

    public static IConnect newDataBaseConnection(String usu, String pass) {
        IConnect.usu = usu;
        IConnect.pass = pass;
        IConnect.classForName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        if (mysql == null) {
            return new MsSQL();
        }
        return mysql;
    }

}
