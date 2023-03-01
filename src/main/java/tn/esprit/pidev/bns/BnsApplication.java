package tn.esprit.pidev.bns;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;
import tn.esprit.pidev.bns.controller.siwardhrif.ClaimRestController;

import java.io.File;

@SpringBootApplication
@EnableScheduling
@EnableAspectJAutoProxy
public class BnsApplication {

	public static void main(String[] args) {

		SpringApplication.run(BnsApplication.class, args);
	}

}
