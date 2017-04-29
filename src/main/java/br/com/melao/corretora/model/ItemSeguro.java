package br.com.melao.corretora.model;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="tipo_seguro")
public abstract class ItemSeguro {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String ciaSeguradora;
	private String susep;
	private String porcentagemComissao;
	private String valorComissao;
	private String premioLiquido;
	private String quantidadeParcela;
	private String observacao;
	
	
	
	@Column(name = "tipo_seguro", insertable = false, updatable = false)
	private String tipoSeguro;
	
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Calendar dataInicioVigencia;
	
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Calendar dataFimVigencia;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="ID_SEGURADO" )
	private Segurado segurado;
	
	
	public Long getId() {
		return id;
	}

	public void setId( Long id ) {
		this.id = id;
	}

	public String getCiaSeguradora() {
		return ciaSeguradora;
	}

	public void setCiaSeguradora( String ciaSeguradora ) {
		this.ciaSeguradora = ciaSeguradora;
	}

	public String getSusep() {
		return susep;
	}

	public void setSusep( String susep ) {
		this.susep = susep;
	}

	public String getPorcentagemComissao() {
		return porcentagemComissao;
	}

	public void setPorcentagemComissao( String porcentagemComissao ) {
		this.porcentagemComissao = porcentagemComissao;
	}

	public String getValorComissao() {
		return valorComissao;
	}

	public void setValorComissao( String valorComissao ) {
		this.valorComissao = valorComissao;
	}

	public String getPremioLiquido() {
		return premioLiquido;
	}

	public void setPremioLiquido( String premioLiquido ) {
		this.premioLiquido = premioLiquido;
	}

	public String getQuantidadeParcela() {
		return quantidadeParcela;
	}

	public void setQuantidadeParcela( String quantidadeParcela ) {
		this.quantidadeParcela = quantidadeParcela;
	}

	public Calendar getDataInicioVigencia() {
		return dataInicioVigencia;
	}

	public void setDataInicioVigencia( Calendar dataInicioVigencia ) {
		this.dataInicioVigencia = dataInicioVigencia;
	}

	public Calendar getDataFimVigencia() {
		return dataFimVigencia;
	}

	public void setDataFimVigencia( Calendar dataFimVigencia ) {
		this.dataFimVigencia = dataFimVigencia;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public String getTipoSeguro() {
		return tipoSeguro;
	}

	public void setTipoSeguro(String tipoSeguro) {
		this.tipoSeguro = tipoSeguro;
	}

	public Segurado getSegurado() {
		return segurado;
	}

	public void setSegurado(Segurado segurado) {
		this.segurado = segurado;
	}
	
	
	
	
}
