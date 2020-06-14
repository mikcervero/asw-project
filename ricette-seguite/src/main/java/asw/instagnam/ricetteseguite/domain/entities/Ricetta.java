package asw.instagnam.ricetteseguite.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import asw.instagnam.ricetteseguite.domain.compkeys.RicettaId;


/* Ricetta, in formato breve. */ 
@Entity
@IdClass(RicettaId.class)
@Data @NoArgsConstructor @AllArgsConstructor
public class Ricetta {

	private Long id; 

	@Id
	private String autore;
	@Id
	private String titolo; 
	 

}
