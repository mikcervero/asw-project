package asw.instagnam.ricette.domain.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

/* Ricetta, in formato breve. */ 
@Data @NoArgsConstructor
public class Ricetta {

	private Long uuid; 
	private String autore; 
	private String titolo; 
	
	public Ricetta(RicettaCompleta r) {
		this.uuid = r.getUuid(); 
		this.autore = r.getAutore(); 
		this.titolo = r.getTitolo(); 
	}
	
}

