package asw.instagnam.ricetteseguite.domain.repositories;

import asw.instagnam.ricetteseguite.domain.entities.RicettaSeguita;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface RicettaSeguitaRepository extends CrudRepository<RicettaSeguita, Long> {
	
	public Collection<RicettaSeguita> findAllByFollower(String follower);
	

}
