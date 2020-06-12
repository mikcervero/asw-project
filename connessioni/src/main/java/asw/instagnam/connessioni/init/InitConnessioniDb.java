package asw.instagnam.connessioni.init;

import asw.instagnam.connessioni.domain.ConnessioniService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class InitConnessioniDb implements CommandLineRunner {

	@Autowired
	private ConnessioniService connessioniService;

	public void run(String[] args) {
		connessioniService.createConnessione("Cristiano", "Gennaro");
		connessioniService.createConnessione("Gennaro", "Cristiano");
		connessioniService.createConnessione("Paolo", "Cristiano");
		connessioniService.createConnessione("Paolo", "Gennaro");
		connessioniService.createConnessione("Anna", "Antonino");
		connessioniService.createConnessione("Anna", "Benedetta");
	}

}