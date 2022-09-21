package model;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
@Entity
@Table(name="productos")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "idProducto")
    private int idProducto;

    @Column(name="nombre")
    private String nombre;

    @Column(name="descripcion")
    private String descripcion;

    @Column(name="precio")
    private double precio;

    @Column(name="cantidad")
    private int cantidad;

    @Column(name="fechaFabricacion")
    @Type(type="date")
    private Date fechaFabricacion;
    
    @Column(name="precioBase") //Nuevos atributos TP2
    private double precioBase;
    
    @Column(name="esSubasta")//Nuevos atributos TP2
    private boolean esSubasta;
    
    @Column(name="fechaLimite")//Nuevos atributos TP2
    @Type(type="date")
    private Date fechaLimite;

    @ManyToOne (cascade={CascadeType.DETACH,CascadeType.REFRESH})
    @JoinColumn (name = "idCategoria")
    private Categoria categoria;

    @ManyToOne (cascade={CascadeType.DETACH,CascadeType.REFRESH})
    @JoinColumn (name = "idUsuario")
    private Usuario usuario;

    @OneToMany(cascade= CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true, mappedBy="producto")
    private List<FotoProducto> fotosProducto;

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Date getFechaFabricacion() {
        return fechaFabricacion;
    }

    public void setFechaFabricacion(Date fechaFabricacion) {
        this.fechaFabricacion = fechaFabricacion;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<FotoProducto> getFotosProducto() {
        return fotosProducto;
    }
    
    public void setFotosProducto(List<FotoProducto> fotosProducto) {
		this.fotosProducto = fotosProducto;
	}

	public double getPrecioBase() {
		return precioBase;
	}

	public void setPrecioBase(double precioBase) {
		this.precioBase = precioBase;
	}

	public boolean isEsSubasta() {
		return esSubasta;
	}

	public void setEsSubasta(boolean esSubasta) {
		this.esSubasta = esSubasta;
	}

	public Date getFechaLimite() {
		return fechaLimite;
	}

	public void setFechaLimite(Date fechaLimite) {
		this.fechaLimite = fechaLimite;
	}

	@Override
	public String toString() {
		return "Producto [idProducto=" + idProducto + ", nombre=" + nombre + ", descripcion=" + descripcion
				+ ", precio=" + precio + ", cantidad=" + cantidad + ", fechaFabricacion=" + fechaFabricacion
				+ ", precioBase=" + precioBase + ", esSubasta=" + esSubasta + ", fechaLimite=" + fechaLimite
				+ ", categoria=" + categoria + ", usuario=" + usuario + "]";
	}
	
}
