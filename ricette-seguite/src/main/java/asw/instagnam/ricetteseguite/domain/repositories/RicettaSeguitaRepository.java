package asw.instagnam.ricetteseguite.domain.repositories;

import asw.instagnam.ricetteseguite.domain.entities.RicettaSeguita;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RicettaSeguitaRepository extends JpaRepository<RicettaSeguita, Long> {
	
	List<RicettaSeguita> findAllByFollower(String follower);
	
}