package br.com.melao.corretora.model.item;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Embedded;
import javax.persistence.Entity;

import br.com.melao.corretora.model.comum.Endereco;

@Entity
@DiscriminatorValue( "Seguro Empresarial")
public class ItemSeguroEmpresarial extends ItemSeguro {

	@Embedded
	private Endereco endereco;
	private String coberturaBasica;
	private String tipoEmpresa;

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getCoberturaBasica() {
		return coberturaBasica;
	}

	public void setCoberturaBasica(String coberturaBasica) {
		this.coberturaBasica = coberturaBasica;
	}

	public String getTipoEmpresa() {
		return tipoEmpresa;
	}

	public void setTipoEmpresa(String tipoEmpresa) {
		this.tipoEmpresa = tipoEmpresa;
	}

}
