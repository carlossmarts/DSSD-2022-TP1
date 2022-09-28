import { useState } from "react"
import axios from "axios"
import { getCurrentDate } from "../components/UtilsMethods";


export const useProductosPresenter = () => {

  const [productos, setProductos] = useState()

  const traerProductos = async () => {
    try {
      const res = await axios.get(`https://localhost:7252/api/producto`);
      const productos = await res.data;
      return productos
    } catch (err) {
      console.error(err)
    }
  }

  const traerProductosComprados = async (idUsuario) => {
    try {
      const body = {
        idUsuario: Number(idUsuario),
        tipoUsuario: 'comprador'
      }
      const res = await axios.post(`https://localhost:7252/api/producto/transaccion`, body);
      const productos = await res.data;
      return productos
    } catch (err) {
      console.error(err)
    }
  }

  const traerProductosPorFiltro = async (filtros) => {
    /*  
      params = {
        categoria: 0,
        nombreLike: "",
        precioDesde: 0,
        precioHasta: 0,
        fechaDesde: "",
        fechaHasta: ""
      }
     */
    try {
      const res = await axios.post(`https://localhost:7252/api/producto/byFilter`, filtros);
      const productos = await res.data;
      return productos
    } catch (err) {
      console.error(err)
    }
  }

  const traerMisProductos = async (idUsuario) => {
    try {
      const res = await axios.get(`https://localhost:7252/api/producto/byUser?idUsuario=${idUsuario}`);
      const productos = await res.data;
      return productos
    } catch (err) {
      console.error(err)
    }
  }

  const crearProducto = async (body) => {
    try {
      const res = await axios.post(`https://localhost:7252/api/producto`, body);
      const producto = await res.data;
      const bodyKafka = {
        idProducto: body.idProducto,
        fechaEdicion: getCurrentDate("-"),
        nombre: body.nombre,
        precio: body.precio
      };
      console.log(bodyKafka);
      await axios.post(`http://localhost:5000/api/producto/`, bodyKafka);
      return producto
    } catch (err) {
      console.error(err)
    }
  }

  const editarProducto = async (body) => {
    try {
      const res = await axios.put(`https://localhost:7252/api/producto`, body);
      const producto = await res.data;
      const bodyKafka = {
        idProducto: body.idProducto,
        fechaEdicion: getCurrentDate("-"),
        nombre: body.nombre,
        precio: body.precio
      };
      await axios.post(`http://localhost:5000/api/producto/`, bodyKafka);
      return producto
    } catch (err) {
      console.error(err)
    }
  }

  return {
    productos,
    setProductos,
    traerProductos,
    traerProductosComprados,
    traerProductosPorFiltro,
    traerMisProductos,
    crearProducto,
    editarProducto
  }
}