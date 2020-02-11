package ro.enered.cfr.controllers;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import ro.enered.apartments.utils.DBConnection;

public class UserController {
	public boolean verifyLogin(String email, String password){
		
		Connection con  = DBConnection.getConnection(); 	
		try{
		PreparedStatement ps = con.prepareStatement("SELECT * FROM Users WHERE Email=? AND Password=?");
		ps.setString(1, email);
		ps.setString(2, password);
		ResultSet rs = ps.executeQuery();
		if(rs.next())
			return true; 	
		}
		catch(Exception e)
		{	
			}
		
		return false;
	}	
	
}
