package Examples;

import Controllers.*;
import java.sql.*;

public class Model implements Idb {

    private String idModel;
    //dbConfig
    private final String TABLE_NAME = "modelTable";

    public Model() {
    }

    public Model(String idModel) {
        this.idModel = idModel;
    }

    public String getIdModel() {
        return idModel;
    }

    public void setIdModel(String idModel) {
        this.idModel = idModel;
    }
    
    @Override
    public String getInsert(int number) {
        switch (number) {
            case 1:
                return "insert into " + this.TABLE_NAME + " (idModel) values (" + this.getValues(1) + ");";
            default:
                return "insert into " + this.TABLE_NAME + " values (" + this.getValues(1) + ");";
        }
    }

    @Override
    public String getUpdate(int number) {
        switch (number) {
            case 1:
                return "update " + this.TABLE_NAME + " set idModel = " + this.getValues(3);
            default:
                return "update " + this.TABLE_NAME + " set idModel = " + this.getValues(4);
        }
    }

    @Override
    public String getDelete(int number) {
        switch (number) {
            case 1:
                return "delete from " + this.TABLE_NAME + " where " + this.getValues(4) + ";";
            default:
                return "delete from " + this.TABLE_NAME + " where " + this.getValues(4) + ";";
        }
    }

    @Override
    public String getSQL(int number) {
        /*This should be related directly with getObject(rs,number).
         * The [number] between this and getObject(rs,number) should be the same
         */
        switch (number) {
            case 1:
                return "select idModel from " + this.TABLE_NAME;
            default:
                return "select * from " + this.TABLE_NAME;
        }
    }

    @Override
    public Idb getObject(ResultSet rs, int number) throws SQLException {
        switch (number) {
            case 1:
                return new Model(rs.getString("idModel"));
            default:
                return new Model(rs.getString(1));
        }
    }

    @Override
    public boolean runDML(int number) {
        switch (number) {
            case 1:
                return GeneralProcedures.runDML("call addModel(" + this.getValues(2) + ")");
            default:
                return GeneralProcedures.runDML("call deleteModel(" + this.getValues(2) + ")");
        }
    }

    @Override
    public String getValues(int number) {
        switch (number) {
            case 1:
                return "idModel = " + this.idModel;
            case 2:
                return this.idModel;
            case 3:
                return "idModel = " + this.idModel + "where idModel = " + this.idModel; //Like the pk
            case 4:
                return "idModel != [someValue] and ...";
            default:
                return "idModel = " + this.idModel;
        }
    }

}
