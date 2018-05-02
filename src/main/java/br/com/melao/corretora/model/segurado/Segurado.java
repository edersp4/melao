package br.com.melao.corretora.model.segurado;

import br.com.melao.corretora.model.comum.Endereco;
import br.com.melao.corretora.model.item.ItemSeguro;
import lombok.Data;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Calendar;
import java.util.List;

@Data
@Entity(name="segurado")
public class Segurado {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	private String nome;
	
	@NotBlank
	@CPF
	private String cpf;

	@NotBlank
	private String telefone;
	
	private String celular;
	
	private String telefoneTrab;
	
	@Email
	private String email;
	
	@Column(insertable = false, updatable = false)
	private String cep;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "segurado" )
	private List<ItemSeguro>seguro;
	
	@NotNull
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Calendar dataDeNascimento;
	
	@Embedded
	private Endereco endereco;


}
