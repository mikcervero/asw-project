package asw.instagnam.connessioni.domain.repositories;

import asw.instagnam.connessioni.domain.entities.Connessione;

import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface ConnessioniRepository extends CrudRepository<Connessione, Long> {

	public Collection<Connessione> findAll();
    public boolean existsByFollowerAndFollowed(String follower, String followed);
	public Collection<Connessione> findAllByFollower(String follower);
	public Connessione findByUuid(Long id);
}

