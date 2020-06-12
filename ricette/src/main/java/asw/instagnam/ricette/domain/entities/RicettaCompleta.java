package asw.instagnam.ricette.domain.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/* Ricetta, in formato completo. */ 
@Entity 
@Data @NoArgsConstructor
public class RicettaCompleta {

	@Id 
	@GeneratedValue
	private Long id; 
	private String autore; 
	private String titolo; 
	private String preparazione; 
	
	public RicettaCompleta(String autore, String titolo, String preparazione) {
		this(); 
		this.autore = autore; 
		this.titolo = titolo; 
		this.preparazione = preparazione; 
	}
	
}
