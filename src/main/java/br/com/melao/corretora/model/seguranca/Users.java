package br.com.melao.corretora.model.seguranca;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class Users {

    @Id
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private boolean enabled;

    @OneToMany(cascade = CascadeType.ALL , mappedBy = "user")
    private Set<Authorities> authorities = new HashSet<>();


}
