package zw.co.nbs.gatewayservicecharges.Connection.api;

import java.sql.Connection;
import java.sql.ResultSet;

public interface gatewayDbConn {
    ResultSet executeQuery(String sqlString);
    // void closeConnection(Connection conn);
    void openConn() throws Exception;
    void closeConnection(Connection conn);
}
