package model;

import javax.persistence.*;

@Entity
@Table(name="categorias")
public class Categoria {

    @Id
    @Column(name = "idCategoria")
    private int idCategoria;

    @Column(name="categoria")
    private String categoria;

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Categoria{" +
                "idCategoria=" + idCategoria +
                ", categoria='" + categoria + '\'' +
                '}';
    }
}
