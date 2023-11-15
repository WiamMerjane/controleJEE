package ma.merjane.Examen.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ma.merjane.Examen.entities.Employe;


@Repository

public interface EmployeRepository extends JpaRepository <Employe,Long>{
	
//	@Query("select s from Employe s where s.employe")
//	public List<Employe> findStudentsByFiliere(Employe employe);

}
