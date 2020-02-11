package ro.enered.cfr.controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import ro.enered.cfr.entities.Station;
import ro.enered.cfr.entities.Vagon;
import ro.enered.utils.DBConnection;

public class StationController {

	public ArrayList<Station> getStations(){
		
		 ArrayList<Station> statii = new ArrayList<Station>();
		 Connection con = DBConnection.getConnection();
		try{
			PreparedStatement ps = con.prepareStatement("SELECT * FROM Stations");
			ResultSet rs= ps.executeQuery();
			while (rs.next()){
				Station st= new Station();
				st.setId(rs.getInt(1));
				st.setName(rs.getString(2));
				st.setLng(rs.getDouble(3));
				st.setLat(rs.getDouble(4));  
				statii.add(st);
			}
		} catch(Exception e){}
		return statii;
	}
	
	public void removeStation(int stationId){
		
		 Connection con = DBConnection.getConnection();
		 try{
			 PreparedStatement ps= con.prepareStatement("DELETE FROM Stations WHERE ID=?");
			 ps.setInt(1, stationId);
			 ps.executeUpdate();
			 
		 }catch(Exception e){ }
		
	}
	
	public void createStation(Station statie){
			Connection con = DBConnection.getConnection();
			try{
				PreparedStatement ps = con.prepareStatement("INSERT INTO Stations(Name,Lng,Lat) VALUES"
						+ "(?,?,?)");
				ps.setString(1, statie.getName());
				ps.setDouble(2, statie.getLat());
				ps.setDouble(3, statie.getLat());
				ps.executeUpdate();
				
			}catch(Exception e){
				e.printStackTrace();
				
			}
		
		
	}
	
	
}
