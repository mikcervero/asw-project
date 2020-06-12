package asw.instagnam.connessioni.rest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateConnessioneRequest {

	private String follower; 
	private String followed; 

}

