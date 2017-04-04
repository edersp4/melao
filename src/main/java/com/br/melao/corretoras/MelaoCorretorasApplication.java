package com.br.melao.corretoras;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.Transactional;

import br.com.melao.corretora.controller.HomeController;
import br.com.melao.corretora.model.Segurado;
import br.com.melao.corretora.repository.SeguradoRepository;
import br.com.melao.corretora.service.cadastro.SeguradoService;

@SpringBootApplication
@Transactional
@ComponentScan(basePackageClasses= {MelaoCorretorasApplication.class , HomeController.class,SeguradoService.class})
@EnableJpaRepositories(basePackageClasses={SeguradoRepository.class})
@EntityScan(basePackageClasses= {Segurado.class})
public class MelaoCorretorasApplication {

	public static void main(String[] args) {
		SpringApplication.run(MelaoCorretorasApplication.class, args);
	}
}
