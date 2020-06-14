package asw.instagnam.ricette.domain.repositories;

import asw.instagnam.ricette.domain.entities.RicettaCompleta;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface RicetteRepository extends CrudRepository<RicettaCompleta, Long> {

	public Collection<RicettaCompleta> findAll();
    public boolean existsByAutoreAndTitolo(String autore, String titolo);
	public Collection<RicettaCompleta> findAllByAutore(String autore);
	public RicettaCompleta findByUuid(Long id);

}

