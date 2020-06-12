package asw.instagnam.ricetteseguite.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

/* Ricetta, in formato breve. */ 
@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Ricetta {

	@Id
	private Long id; 
	private String autore; 
	private String titolo; 

}
