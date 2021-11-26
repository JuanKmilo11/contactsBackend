package co.edu.app.models.entity.repository;

import org.springframework.data.repository.CrudRepository;

import co.edu.app.models.entity.Contact;

public interface IContactRepository extends CrudRepository<Contact, Long> {

	
	
}
