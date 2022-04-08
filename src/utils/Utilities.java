package utils;

import java.sql.*;

public class Utilities {

    public static void updateResultSet(ResultSet rs, String field, String oldValue, String newValue) throws SQLException {
        if(!newValue.equals(oldValue) && !newValue.equals("")){
            rs.updateString(field,newValue);
        }
    }

    public static void printResult(ResultSet rs) throws SQLException {
        ResultSetMetaData rsmd = rs.getMetaData();
        int columnsNumber = rsmd.getColumnCount();
        while (rs.next()) {
            for (int i = 1; i <= columnsNumber; i++) {
                String columnValue = rs.getString(i);
                System.out.println(rsmd.getColumnName(i) + ": " + columnValue);
            }
        }
    }

    public static void verifyBatchOperation(BatchUpdateException batchEx){
        for (int result : batchEx.getUpdateCounts()){
            if(result >= 0){
                System.out.println("Sentencia ejecutada con éxito");
            } else if(result == Statement.SUCCESS_NO_INFO){
                System.out.println("Sentencia ejecutada con éxito pero sin información de filas afectadas");
            } else if(result == Statement.EXECUTE_FAILED){
                System.out.println("Sentencia fallida");
            }
        }
    }
}
