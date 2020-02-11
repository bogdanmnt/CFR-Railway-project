package ro.enered.cfr;
import java.util.ArrayList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ro.enered.cfr.controllers.StationController;
import ro.enered.cfr.controllers.UserController;
import ro.enered.cfr.controllers.VagonController;
import ro.enered.cfr.entities.Station;
import ro.enered.cfr.entities.Vagon;
@SpringBootApplication
@CrossOrigin(origins="*")
@RestController
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class CfrApplication {
	public static void main(String[] args) {
		SpringApplication.run(CfrApplication.class, args);
	}
	
	@RequestMapping(value="/user/login", method=RequestMethod.POST)
	public ResponseEntity<?> loginUser(@RequestParam(value="email") String email,
			@RequestParam(value="password") String password){
		
		UserController uc = new UserController();
		if(uc.verifyLogin(email, password) == true){
			return ResponseEntity.ok("ok");
		}
		else
			return ResponseEntity.ok("nok");
		
	}
	
	@RequestMapping(value="/stations/get", method=RequestMethod.GET, produces="application/json")
	public ResponseEntity<?> getStations(){
		ArrayList<Station> stationList = new ArrayList<Station>();
		StationController sc= new StationController();
		stationList = sc.getStations();
		return ResponseEntity.ok(stationList);
	}
	
	@RequestMapping(value="/stations/remove", method=RequestMethod.POST)
	public ResponseEntity<?> removeStation(@RequestParam(value="stationId") int stationId){
		
		StationController sc= new StationController();
		sc.removeStation(stationId);
		return ResponseEntity.ok("removed");
	}
	
	@RequestMapping(value="station/create", method=RequestMethod.POST)
	public ResponseEntity<?> createStation(@RequestParam(value="name") String name,
			@RequestParam(value="stationLng") double lng,
			@RequestParam(value="stationLat") double lat){
		Station statie = new Station();
		statie.setLng(lng);
		statie.setLat(lat);
		statie.setName(name);
		
		StationController sc= new StationController();
		sc.createStation(statie);
		return ResponseEntity.ok("created");
	}
	
	
	@RequestMapping(value="/vagoane/get", method=RequestMethod.GET, produces="application/json")
	public ResponseEntity<?> getVagoane(){
		ArrayList<Vagon> vagonList = new ArrayList<Vagon>();
		VagonController vc= new VagonController();
		vagonList = vc.getVagoane();
		return ResponseEntity.ok(vagonList);
	}
	
	@RequestMapping(value="/vagoane/remove", method=RequestMethod.POST)
	public ResponseEntity<?> removeVagon(@RequestParam(value="vagonId") int vagonId){
		
		VagonController vc= new VagonController();
		vc.removeVagon(vagonId);
		return ResponseEntity.ok("removed");}
	
	@RequestMapping(value="vagoane/create", method=RequestMethod.POST)
	public ResponseEntity<?> vagonCreare (@RequestParam(value="nrLocuri") int nrLocuri,
			@RequestParam(value="clasa") int clasa,
			@RequestParam(value="pret") double pret){
		Vagon vagoane = new Vagon();
		vagoane.setNrLocuri(nrLocuri);
		vagoane.setClasa(clasa);
		vagoane.setPret (pret);
		
		VagonController vc= new VagonController();
		vc.createVagon(vagoane);
		return ResponseEntity.ok("created");
	}
}
