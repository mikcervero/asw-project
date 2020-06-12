package asw.instagnam.ricetteseguite.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity 
@Data @NoArgsConstructor
public class Connessione {

	@Id
	@GeneratedValue
	private Long id;

	private String follower;
	private String followed;

	public Connessione(String followed, String follower) {
		this.followed = followed;
		this.follower = follower;
	}
}
