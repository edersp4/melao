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

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import br.com.melao.corretora.model.segurado.Segurado;

@Data
@EqualsAndHashCode(exclude = {"Segurado.class"})
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


}
