package asw.instagnam.ricetteseguite.domain.repositories;

import asw.instagnam.ricetteseguite.domain.entities.Ricetta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RicettaRepository extends JpaRepository<Ricetta, Long> {
    List<Ricetta> findAllByAutore(String autore);

}

