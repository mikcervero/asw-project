package asw.instagnam.connessioni.domain.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;


@Entity 
@IdClass(ConnessioneId.class)
@Data @NoArgsConstructor
public class Connessione {

	private Long uuid;
	@Id 
	private String follower;
	@Id
	private String followed; 
	
	public Connessione(Long id, String follower, String followed) {
		this();
		this.uuid = id;
		this.follower = follower; 
		this.followed = followed; 
	}
	
}
