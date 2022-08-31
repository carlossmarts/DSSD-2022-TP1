package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="usuarios")

public class Usuario {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="idUsuario", unique = false)
	private int idUsuario;
	
	@Column(name="nombre", nullable = true)
	private String nombre;
	
	@Column(name="apellido", nullable = true)
	private String apellido;
	
	@Column(name="dni", nullable = true)
	private String dni;
	
	@Column(name="email", nullable = true)
	private String email;
	
	@Column(name="usuario", nullable = true)
	private String usuario;
	
	@Column(name="clave", nullable = true)
	private String clave;
	
	@Column(name="saldoBilletera", nullable = true)
	private Double saldoBilletera;
	
	public Usuario(int idUsuario, String nombre, String apellido, String dni, String email, String usuario,
			String clave, Double saldoBilletera) {
		super();
		this.idUsuario = idUsuario;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.email = email;
		this.usuario = usuario;
		this.clave = clave;
		this.saldoBilletera = saldoBilletera;
	}
	
	public Usuario() {
		super();
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public Double getSaldoBilletera() {
		return saldoBilletera;
	}

	public void setSaldoBilletera(Double saldoBilletera) {
		this.saldoBilletera = saldoBilletera;
	}

	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni
				+ ", email=" + email + ", usuario=" + usuario + ", clave=" + clave + ", saldoBilletera="
				+ saldoBilletera + "]";
	}
	
}