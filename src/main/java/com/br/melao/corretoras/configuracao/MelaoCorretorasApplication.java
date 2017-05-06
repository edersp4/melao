package com.br.melao.corretoras.configuracao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.Transactional;

//@ComponentScan(basePackageClasses= {MelaoCorretorasApplication.class , HomeController.class,SeguradoService.class})
//@EnableJpaRepositories(basePackageClasses={SeguradoRepository.class})
//@EntityScan(basePackageClasses= {Segurado.class})
@SpringBootApplication
@Transactional
@ComponentScan(basePackages= {"br.com.melao.corretora.controller.*","br.com.melao.corretora.configuracao","br.com.melao.corretora.service.*"})
@EnableJpaRepositories(basePackages={"br.com.melao.corretora.repository.*"})
@EntityScan(basePackages= {"br.com.melao.corretora.model.*"})

public class MelaoCorretorasApplication {

	public static void main(String[] args) {
		SpringApplication.run(MelaoCorretorasApplication.class, args);
	}
}
