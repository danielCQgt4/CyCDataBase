package Controllers;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface Idb {

    public abstract String getValues(int number);

    public abstract String getInsert(int number);

    public abstract String getUpdate(int number);

    public abstract String getDelete(int number);

    public abstract String getSQL(int number);

    public abstract Idb getObject(ResultSet rs, int number) throws SQLException;

    public abstract boolean runDML(int number);

}
