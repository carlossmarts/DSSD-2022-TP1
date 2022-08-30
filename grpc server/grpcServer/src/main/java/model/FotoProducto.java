package model;

import javax.persistence.*;

@Entity
@Table(name = "fotos")
public class FotoProducto {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "idFoto")
    private long idFoto;

    @Column(name="nombre")
    private String nombre;

    @Column (name = "archivo")
    @Basic(fetch = FetchType.LAZY)
    @Lob
    private byte[] archivo;

    public long getIdFoto() {
        return idFoto;
    }

    public void setIdFoto(long idFoto) {
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
}
