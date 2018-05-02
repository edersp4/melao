package br.com.melao.corretora;

import java.util.Locale;

import org.jasypt.util.password.StrongPasswordEncryptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.FixedLocaleResolver;

//@ComponentScan(basePackageClasses= {MelaoCorretorasApplication.class , HomeController.class,SeguradoService.class})
//@EnableJpaRepositories(basePackageClasses={SeguradoRepository.class})
//@EntityScan(basePackageClasses= {Segurado.class})
@SpringBootApplication
//@Transactional
@ComponentScan(basePackages= {"br.com.melao.corretora.controller.*","br.com.melao.corretora","br.com.melao.corretora.service.*"})
@EnableJpaRepositories(basePackages={"br.com.melao.corretora.repository.*"})
@EntityScan(basePackages= {"br.com.melao.corretora.model.*"})

public class MelaoCorretorasApplication {

	public static void main(String[] args) {
		SpringApplication.run(MelaoCorretorasApplication.class, args);
	}
	
	
	@Bean
	public LocaleResolver localeResolver() {
		return new FixedLocaleResolver(new Locale("pt", "BR"));
	}

	@Bean
	public StrongPasswordEncryptor strongPasswordEncryptor() {
		StrongPasswordEncryptor strongPasswordEncryptor = new StrongPasswordEncryptor();
		return strongPasswordEncryptor;
	}
}
