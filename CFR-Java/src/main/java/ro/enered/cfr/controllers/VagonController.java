package ro.enered.cfr.controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import ro.enered.apartments.utils.DBConnection;
import ro.enered.cfr.entities.Vagon;

public class VagonController {

	
	public ArrayList<Vagon> getVagoane(){
		
		 ArrayList<Vagon> vagonase = new ArrayList<Vagon>();
		 Connection con = DBConnection.getConnection();
		try{
			PreparedStatement ps = con.prepareStatement("SELECT * FROM Vagoane");
			ResultSet rs= ps.executeQuery();
			while (rs.next()){
				Vagon vg= new Vagon();
				vg.setId(rs.getInt(1));
				vg.setNrLocuri(rs.getInt(2));
				vg.setClasa(rs.getInt(3));
				vg.setPret(rs.getDouble(4));  
				vagonase.add(vg);
			}
		} catch(Exception e){}
		return vagonase;
	}
	
	
	public void removeVagon(int vagonId){
		
		 Connection con = DBConnection.getConnection();
		 try{
			 PreparedStatement ps= con.prepareStatement("DELETE FROM Vagoane WHERE ID=?");
			 ps.setInt(1, vagonId);
			 ps.executeUpdate();
			 
		 }catch(Exception e){ }
		
	}
	
	public void createVagon(Vagon vagoane){
		Connection con = DBConnection.getConnection();
		try{
			PreparedStatement ps = con.prepareStatement("INSERT INTO Vagoane(Nr_locuri,Clasa,Pret) VALUES"
					+ "(?,?,?)");
			ps.setInt(1, vagoane.getNrLocuri());
			ps.setInt(2, vagoane.getClasa());
			ps.setDouble(3, vagoane.getPret());
			ps.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
			
		}
	}
	
}
