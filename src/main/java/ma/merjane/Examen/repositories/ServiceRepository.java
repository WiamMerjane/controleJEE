package ma.merjane.Examen.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.merjane.Examen.entities.Service1;

@Repository
public interface ServiceRepository extends JpaRepository <Service1,Long> {


}
