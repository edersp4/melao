package br.com.melao.corretora.builder;

import br.com.melao.corretora.model.segurado.Segurado;
import buildermaster.BuilderMaster;
import lombok.Builder;

public class BuilderMaster2 {

    public static void main(String[] args) {
        new buildermaster.BuilderMaster().gerarCodigoClasse(Segurado.class);
    }
}
