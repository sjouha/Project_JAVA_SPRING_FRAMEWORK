package dwfsd.tps;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ResourceBundle;

@SpringBootApplication
public class ProjectApplication {

	private final static Logger LOGGER = LoggerFactory.getLogger(ProjectApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(ProjectApplication.class, args);



		LOGGER.debug("Application Started.....");
		LOGGER.info("Access URL DWFSD : http://localhost:8083/api/");


	}

}
