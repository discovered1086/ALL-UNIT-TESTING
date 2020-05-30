package com.kingshuk.testing.testingwithranga.model.utility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public interface BaseConnection {
	// list of methods
	Connection getMyConnection() throws Exception;

	void closeConnection(Connection con);

	void closeStatement();

	void closePreparedStatement(PreparedStatement ps);

	void closeCallableStatement();

	void closeResultset(ResultSet rs);
}
