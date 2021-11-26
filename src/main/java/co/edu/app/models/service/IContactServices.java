package co.edu.app.models.service;

import java.util.Optional;

import co.edu.app.models.entity.Contact;

public interface IContactServices {
	
	public Iterable<Contact> findAll();
	public Optional<Contact> findById(Long id);
	public Contact save(Contact contacto);
	public void deletebyId(Long id);
		

	
}
