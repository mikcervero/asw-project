package asw.instagnam.ricette.domain.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;


/* Ricetta, in formato completo. */ 
@Entity
@IdClass(RicettaId.class)
@Data @NoArgsConstructor
public class RicettaCompleta {

	private Long uuid;
	@Id 
	private String autore;
	@Id
	private String titolo; 
	private String preparazione; 
	
	public RicettaCompleta(Long id, String autore, String titolo, String preparazione) {
		this();
		this.uuid = id;
		this.autore = autore; 
		this.titolo = titolo; 
		this.preparazione = preparazione; 
	}
	
}
