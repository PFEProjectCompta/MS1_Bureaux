package com.ges.officeservice;

import com.ges.officeservice.config.InitialData;
import com.ges.officeservice.entities.AdmineBureau;
import com.ges.officeservice.entities.Bureau;
import com.ges.officeservice.entities.CompteUtilisateur;
import com.ges.officeservice.repository.AdminBureauRepository;
import com.ges.officeservice.repository.BureauRepository;
import com.ges.officeservice.repository.CompteUtilisateurRepository;
import com.ges.officeservice.repository.SocieteRepository;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class OfficeServiceApplication {

	private static AdminBureauRepository adminBureauRepository;
	private static  SocieteRepository societeRepository;
	private static BureauRepository bureauRepository;
	private static CompteUtilisateurRepository compteUtilisateurRepository;

	public OfficeServiceApplication(AdminBureauRepository adminBureauRepository, SocieteRepository societeRepository, BureauRepository bureauRepository, CompteUtilisateurRepository compteUtilisateurRepository) {
		this.adminBureauRepository = adminBureauRepository;
		this.societeRepository = societeRepository;
		this.bureauRepository = bureauRepository;
		this.compteUtilisateurRepository = compteUtilisateurRepository;
	}
	public static void main(String[] args) {
		SpringApplication.run(OfficeServiceApplication.class, args);
	}

	@Bean
	@Transactional
	CommandLineRunner start(){
		return args -> {
			InitialData.creeAdmineBureau();
			InitialData.creeBureau();
			InitialData.creeCompteUtilisateur();
			InitialData.creeSociete();
		};
	};


}
