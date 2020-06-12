package asw.instagnam.ricetteseguite.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class RicettaSeguita {
	
	@Id
	@GeneratedValue
	private Long id;
	private String follower; 
	private Long idRicetta; 
	private String autoreRicetta; 
	private String titoloRicetta;

	public RicettaSeguita(String follower, Long idRicetta, String autoreRicetta, String titoloRicetta) {
		super();
		this.follower = follower;
		this.idRicetta = idRicetta;
		this.autoreRicetta = autoreRicetta;
		this.titoloRicetta = titoloRicetta;
	}

	public Ricetta getRicetta(){
		return new Ricetta(idRicetta, autoreRicetta, titoloRicetta);
	}
}