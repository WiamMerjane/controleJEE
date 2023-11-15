package ma.merjane.Examen.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import ma.merjane.Examen.dao.IDao;
import ma.merjane.Examen.entities.Employe;
import ma.merjane.Examen.repositories.EmployeRepository;

@Service
public class EmployeService  implements IDao<Employe>{
	
	@Autowired
	private EmployeRepository employeRepository;


	@Override
	public Employe create(Employe o) {
		return employeRepository.save(o);
	}

	@Override
	public boolean delete(Employe o) {
		try {
			employeRepository.delete(o);
			return true;
		}
		catch(Exception ex) {
			return false;
		}
	}

	@Override
	public Employe update(Employe o) {
		return employeRepository.save(o);

	}

	@Override
	public List<Employe> findAll() {
		return employeRepository.findAll();

	}

	@Override
	public Employe findById(Long id) {
		return employeRepository.findById(id).orElse(null);

	}

}
