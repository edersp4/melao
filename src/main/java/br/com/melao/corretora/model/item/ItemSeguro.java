package br.com.melao.corretora.model.item;

import java.math.BigDecimal;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import br.com.melao.corretora.model.segurado.Segurado;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="tipo_seguro")
public abstract class ItemSeguro {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String ciaSeguradora;
	private String susep;
	
	@NumberFormat(pattern="#,##0.00")
	private BigDecimal porcentagemComissao;
	@NumberFormat(pattern="#,##0.00")
	private BigDecimal valorComissao;
	@NumberFormat(pattern="#,##0.00")
	private BigDecimal premioLiquido;
	@NumberFormat(pattern="#,##0")
	private BigDecimal quantidadeParcela;
	private String observacao;
	
	
	
	@Column(name = "tipo_seguro", insertable = false, updatable = false)
	private String tipoSeguro;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Calendar dataInicioVigencia;
	
	@Temporal(TemporalType.DATE)
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

	public BigDecimal getPorcentagemComissao() {
		return porcentagemComissao;
	}

	public void setPorcentagemComissao(BigDecimal porcentagemComissao) {
		this.porcentagemComissao = porcentagemComissao;
	}

	public BigDecimal getValorComissao() {
		return valorComissao;
	}

	public void setValorComissao(BigDecimal valorComissao) {
		this.valorComissao = valorComissao;
	}

	public BigDecimal getPremioLiquido() {
		return premioLiquido;
	}

	public void setPremioLiquido(BigDecimal premioLiquido) {
		this.premioLiquido = premioLiquido;
	}

	public BigDecimal getQuantidadeParcela() {
		return quantidadeParcela;
	}

	public void setQuantidadeParcela(BigDecimal quantidadeParcela) {
		this.quantidadeParcela = quantidadeParcela;
	}
	
	
	
	
}
