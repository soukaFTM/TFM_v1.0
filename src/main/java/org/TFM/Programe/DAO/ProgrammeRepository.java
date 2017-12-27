package org.TFM.Programe.DAO;

import org.TFM.Clients.Entities.Client;
import org.TFM.Programe.Entities.Programme;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProgrammeRepository extends JpaRepository<Programme, Long> {
	@Query("select c from Programme c ")
	public Page<Programme> findPageProgramme(Pageable pageable);
}
