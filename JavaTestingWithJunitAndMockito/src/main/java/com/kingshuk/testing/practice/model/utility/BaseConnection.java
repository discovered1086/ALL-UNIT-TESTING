package com.kingshuk.testing.practice.model.utility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public interface BaseConnection {
	// list of methods
	public Connection getMyConnection() throws Exception;

	public void closeConnection(Connection con);

	public void closeStatement();

	public void closePreparedStatement(PreparedStatement ps);

	public void closeCallableStatement();

	public void closeResultset(ResultSet rs);
}
