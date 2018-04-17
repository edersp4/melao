package br.com.melao.corretora.model.seguranca;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@Entity
public class Authorities {

    private String authority;

    @ManyToOne
    @JoinColumn(name = "USERNAME")
    private Users user;

}
