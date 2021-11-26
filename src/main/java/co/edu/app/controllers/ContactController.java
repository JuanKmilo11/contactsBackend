package co.edu.app.controllers;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.edu.app.models.entity.Contact;
import co.edu.app.models.service.IContactServices;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})
public class ContactController {
	
	@Autowired
	private IContactServices service;
	
	@GetMapping
	public ResponseEntity<?> toList(){
		return ResponseEntity.ok().body(service.findAll());
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<?> view(@PathVariable Long id){
		Optional<Contact> contact = service.findById(id);
		if(contact.isEmpty()) {
			return ResponseEntity.notFound().build();
		}	
		return ResponseEntity.ok(contact.get());
	}

	@PostMapping("/{id}")
	public ResponseEntity<?> edit(@RequestBody Contact contact, @PathVariable Long id){
		Optional<Contact> o = service.findById(id);
		if(o.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		Contact contactDb = o.get();
		
		contactDb.setFirstName(contact.getFirstName());
		contactDb.setLastName(contact.getLastName());
		contactDb.setEmail(contact.getEmail());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(contactDb));
		
	}
	
	
	@PostMapping
	public ResponseEntity<?> save(@RequestBody Contact contact){
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(contact));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		service.deletebyId(id);
		return ResponseEntity.noContent().build();
	}

}
