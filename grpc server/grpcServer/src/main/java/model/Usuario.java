package model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="usuarios")
public class Usuario {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUsuario")
    private int idUsuario;

    @Column(name="nombre")
    private String nombre;

    @Column(name="apellido")
    private String apellido;

    @Column(name="dni")
    private String dni;

    @Column(name="email")
    private String email;

    @Column(name="usuario")
    private String usuario;

    @Column(name="clave")
    private String clave;

    @Column(name="saldoBilletera")
    private double saldoBilletera;
    
    @Column (name = "idTipoUsuario")
    private int idTipoUsuario;

    @OneToMany(mappedBy="usuario" )
    private List<Producto> productos;

    @OneToMany(mappedBy="comprador" )
    private List<Transaccion> compras;

    @OneToMany(mappedBy="vendedor" )
    private List<Transaccion> ventas;

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

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public List<Transaccion> getCompras() {
        return compras;
    }

    public void setCompras(List<Transaccion> compras) {
        this.compras = compras;
    }

    public List<Transaccion> getVentas() {
        return ventas;
    }

    public void setVentas(List<Transaccion> ventas) {
        this.ventas = ventas;
    }

	public int getIdTipoUsuario() {
		return idTipoUsuario;
	}

	public void setIdTipoUsuario(int idTipoUsuario) {
		this.idTipoUsuario = idTipoUsuario;
	}

	public void setSaldoBilletera(double saldoBilletera) {
		this.saldoBilletera = saldoBilletera;
	}

	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni
				+ ", email=" + email + ", usuario=" + usuario + ", clave=" + clave + ", saldoBilletera="
				+ saldoBilletera + ", idTipoUsuario=" + idTipoUsuario + ", productos=" + productos + ", compras="
				+ compras + ", ventas=" + ventas + "]";
	}
	
}
