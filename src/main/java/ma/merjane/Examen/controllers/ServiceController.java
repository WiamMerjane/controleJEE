package ma.merjane.Examen.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ma.merjane.Examen.entities.Service1;
import ma.merjane.Examen.service.ServiceService;

@RestController
@RequestMapping("/api/services")

public class ServiceController {
	
	@Autowired
	private ServiceService ServiceService;
	

	@GetMapping
	public List<Service1> findAllService(){
		return ServiceService.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> findById(@PathVariable Long id) {
		Service1 Service = ServiceService.findById(id);
		if(Service == null) {
			return new ResponseEntity<Object>("Service with ID " + id + " not found", HttpStatus.BAD_REQUEST);
		}
		else {
			return ResponseEntity.ok(Service);
		}
	}
	
	@PostMapping
	public Service1 createService(@RequestBody Service1 Service) {
		Service.setId(0L);
		return ServiceService.create(Service);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateService(@PathVariable Long id,@RequestBody Service1 Service) {
//		Service Service = ServiceService.findById(id);
		if(ServiceService.findById(id) == null) {
			return new ResponseEntity<Object>("Service with ID " + id + " not found", HttpStatus.BAD_REQUEST);
		}
		else {
			Service.setId(id);
			return ResponseEntity.ok(ServiceService.update(Service));
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteService(@PathVariable Long id){
		Service1 Service = ServiceService.findById(id);
		if(Service == null) {
			return new ResponseEntity<Object>("Service with ID " + id + " not found", HttpStatus.BAD_REQUEST);
		}
		else {
			ServiceService.delete(Service);
			return ResponseEntity.ok("Service has been deleted");
		}
	}


}
