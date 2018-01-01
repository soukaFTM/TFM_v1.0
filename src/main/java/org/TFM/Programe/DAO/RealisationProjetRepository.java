package org.TFM.Programe.DAO;

import org.TFM.Programe.Entities.Groupe;
import org.TFM.Programe.Entities.Programme;
import org.TFM.Programe.Entities.RealisationProjet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RealisationProjetRepository extends JpaRepository<RealisationProjet, Long> {

}
