package br.com.melao.corretora.model;

import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;

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
	
	private String cep;
	
	@Email
	private String email;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "segurado" )
	private List<SeguroCarro>seguro;
	
	@NotNull
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Calendar dataDeNascimento;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return convertNull(nome);
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return convertNull(cpf);
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return convertNull(telefone);
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCep() {
		return convertNull(cep);
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getEmail() {
		return convertNull(email);
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Calendar getDataDeNascimento() {
		return dataDeNascimento;
	}

	public void setDataDeNascimento(Calendar dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Segurado other = (Segurado) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	private String convertNull(String campo) {
		return "".equals(campo) ? null : campo;
	}

	@Override
	public String toString() {
		return "Segurado [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", telefone=" + telefone + ", cep=" + cep
				+ ", email=" + email + ", dataDeNascimento=" + dataDeNascimento + "]";
	}

	public List<SeguroCarro> getSeguro() {
		return seguro;
	}

	public void setSeguro(List<SeguroCarro> seguro) {
		this.seguro = seguro;
	}
	
}
