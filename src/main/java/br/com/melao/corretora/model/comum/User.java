package br.com.melao.corretora.model.comum;

import lombok.*;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String username;

	@Transient
	private String password;
	private String encryptedPassword;
	private Boolean enabled = true;


	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable
	private List<Role> roles = new ArrayList<>();


	public void addRole(Role role) {
		if (!this.getRoles().contains(role)) {
			this.roles.add(role);
		}

		if (!role.getUsers().contains(this)) {
			role.getUsers().add(this);
		}

	}

	public void removeRole(Role role) {
		this.roles.remove(role);
		role.getUsers().remove(this);
	}


}
