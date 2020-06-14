package asw.instagnam.ricetteseguite.domain.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import asw.instagnam.ricetteseguite.domain.compkeys.ConnessioneId;

@Entity 
@IdClass(ConnessioneId.class)
@Data @NoArgsConstructor
public class Connessione {

	@Id
	private String follower;
	@Id
	private String followed;

	public Connessione(String follower, String followed) {
		this(); 
		this.follower = follower; 
		this.followed = followed; 
	}
}
