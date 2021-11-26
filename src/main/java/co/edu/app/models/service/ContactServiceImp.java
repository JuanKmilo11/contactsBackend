package co.edu.app.models.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.app.models.entity.Contact;
import co.edu.app.models.entity.repository.IContactRepository;

@Service
public class ContactServiceImp implements IContactServices {

	@Autowired
	private IContactRepository repository;
	
	@Override
	@Transactional(readOnly=true)
	public Iterable<Contact> findAll() {
		return repository.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Optional<Contact> findById(Long id) {
		return repository.findById(id);
	}

	@Override
	@Transactional
	public Contact save(Contact contacto) {
		return repository.save(contacto);
	}

	@Override
	@Transactional
	public void deletebyId(Long id) {
		repository.deleteById(id);
	}
}
