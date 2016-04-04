package com.appdeveloper.appgasagua.paulohenrique.appgasagua.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author PauloHenrique
 *
 */
@Entity
@Table(name = "tb_login")
public class LoginSistema {

	private String usuario;
	private String senha;

	@Id
	@Column(name = "usuario", length = 10, unique = true)
	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	@Column(name = "senha")
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
