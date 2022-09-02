package model;

import javax.persistence.*;

@Entity
@Table(name = "fotos")
public class FotoProducto {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "idFoto")
    private int idFoto;

    @Column(name="nombre")
    private String nombre;

    @Column (name = "archivo")
    @Basic(fetch = FetchType.LAZY)
    @Lob
    private byte[] archivo;

    @ManyToOne (cascade={CascadeType.ALL, CascadeType.REFRESH})
    @JoinColumn (name = "idProducto")
    private Producto producto;

    public int getIdFoto() {
        return idFoto;
    }

    public void setIdFoto(int idFoto) {
        this.idFoto = idFoto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public byte[] getArchivo() {
        return archivo;
    }

    public void setArchivo(byte[] archivo) {
        this.archivo = archivo;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
}
