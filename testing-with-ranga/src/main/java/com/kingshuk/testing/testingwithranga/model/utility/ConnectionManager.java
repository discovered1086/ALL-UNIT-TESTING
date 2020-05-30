package com.kingshuk.testing.testingwithranga.model.utility;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.sql.*;

@Getter
@Setter
public class ConnectionManager implements BaseConnection, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -367117343703416863L;
	private String connectionDriver="oracle.jdbc.driver.OracleDriver";
    private String url="jdbc:oracle:thin:@192.168.0.8:1521:";
    private String dbname="mydatabase";
    private String username="servlet_training";
    private String password="Iofdtiger#16";

    public ConnectionManager() {

    }

    public ConnectionManager(String connectionDriver, String url, String dbname, String username, String password) {
        this.connectionDriver = connectionDriver;
        this.url = url;
        this.dbname = dbname;
        this.username = username;
        this.password = password;
    }

    public Connection getMyConnection() throws ClassNotFoundException, SQLException {
        Connection mmcon;
        try {
            Class.forName(connectionDriver);
            mmcon = DriverManager.getConnection(url + dbname, username, password);
            System.out.println( "connection created");
        } catch (ClassNotFoundException ex) {
            throw new ClassNotFoundException("the driver manager class cannot be found");
        } catch (SQLException sqe) {
            throw new SQLException("error while acquiring the connection");
        }

        return mmcon;                                         //return the connection object.

    }


    public void closeResultset(ResultSet rs) {
        try {
            if (!rs.isClosed()) {
                rs.close();
            }
        } catch (SQLException sql) {
            throw new RuntimeException("Result set could not be closed");
        }
    }

    public void closeConnection(Connection con) {
        try {
            if (!con.isClosed()) {
                con.close();

            }
        } catch (SQLException ex) {
            throw new RuntimeException("error occurred while closing the connection");
        }
    }

    public void closeStatement() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void closePreparedStatement(PreparedStatement ps) {
        try {
            if (!ps.isClosed()) {
                ps.close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException("error occurred while closing the connection");
        }
    }

    public void closeCallableStatement() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
