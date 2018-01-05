package org.TFM.Programe.DAO;

import java.util.List;

import org.TFM.Formateur.Entities.Formateur;
import org.TFM.Programe.Entities.Presence;
import org.TFM.Programe.Entities.Seance;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PresenceRepository extends JpaRepository<Presence, Long>{



}
