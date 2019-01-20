/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mypractice.unittesting.mockito.utility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author kingshuk
 */
public interface BaseConnection
{
    //list of methods
    public  Connection getMyConnection() throws Exception;
    public void closeConnection(Connection con);
    public void closeStatement();
    public void closePreparedStatement(PreparedStatement ps);
    public void closeCallableStatement();
    public void closeResultset(ResultSet rs);
}
