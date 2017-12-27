package org.TFM.Clients.DAO;

import java.util.ArrayList;

import org.TFM.Clients.Entities.Enfant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EnfantRepository extends JpaRepository<Enfant, Long>{

	@Query("select e from Enfant e")
	public Page<Enfant> findPageEnfant(Pageable pageable);

	@Query("select e from Enfant e ")
	public ArrayList<Enfant> findEnfant();

	
	/* Les commandes d*/

	
}
