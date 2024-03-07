package zw.co.nbs.gatewayservicecharges.Connection.Impl;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import zw.co.nbs.gatewayservicecharges.Connection.api.gatewayDbConn;

import java.sql.*;

@Slf4j
@NoArgsConstructor
public class gatewayDbConnImpl implements gatewayDbConn {
    public static Connection conn;

    @Value("${spring.datasource.driver-class-name}")
    private String jdbcClassName;

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;


    @Override
    public void openConn() throws Exception {
        if (conn == null || conn.isClosed()) {
            try {
                log.debug("Connecting to :{}, {}, {}", url, username, password);
                Class.forName(jdbcClassName);
                conn = DriverManager.getConnection(url, username, password);
                log.info("connection to database successful....");
            } catch (SQLException | ClassNotFoundException e) {
                log.error("{}", e);
                log.error("Failed to establish a database connection to :::" + url + ":::  {}", e.getMessage());
            }
        }
    }
    public ResultSet executeQuery(String sqlString) {
        ResultSet rs = null;
        try {
            log.debug(sqlString);
            openConn();
            Statement sttmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            sttmt.executeQuery(sqlString);
            rs = sttmt.getResultSet();
        } catch (Exception ex) {
            log.error("SQL Query Error", ex);
        }
        return rs;
    }
    public void closeConnection(Connection conn) {
        try {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    log.error("Failed to close connection.  {}", ex.getMessage());
                }
            }
        } catch (Exception ignored) {
        }
    }
}
