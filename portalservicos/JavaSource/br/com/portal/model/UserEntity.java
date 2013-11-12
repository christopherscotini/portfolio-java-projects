package br.com.portal.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "TB_USUARIO")
public class UserEntity extends GenericEntity implements Serializable {

	private static final long serialVersionUID = 6651000214536467904L;

	@Column(name = "DS_USERNAME", length = 25, unique = true, nullable = false)
	private String username;

	@Column(name = "DS_PASSWORD", nullable = false)
	private String password;

	@Transient
	private String passwordConfirm;

	@ManyToOne
	@JoinColumn(name = "PERFIL_FK", nullable = false)
	private PerfilEntity perfil;

	public UserEntity() {

	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}

	public PerfilEntity getPerfil() {
		return perfil;
	}

	public void setPerfil(PerfilEntity perfil) {
		this.perfil = perfil;
	}

}
