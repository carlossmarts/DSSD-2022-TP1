import React, { useEffect, useState } from 'react'
import Grid from '@mui/material/Grid';
import GridProductos from '../components/GridProductos'
import { useProductosPresenter } from '../presenter/productosPresenter'
import ModalSubasta from '../components/ModalSubasta'
import Carrito from '../components/Carrito'
import { useTransaccionesPresenter } from '../presenter/transaccionesPresenter'
import { useCategoriasPresenter } from '../presenter/categoriasPresenter'
import Filtros from '../components/Filtros';



const Productos = () => {

  const { traerProductos } = useProductosPresenter()
  const { traerCategorias, categorias } = useCategoriasPresenter()
  const { actualizarBilletera, traerDineroEnBilletera } = useTransaccionesPresenter()
  const [productos, setProductos] = useState([]);
  const [productoCompra, setProductoCompra] = useState({});
  const [cartItems, setCartItems] = useState([]);
  const [open, setOpen] = useState(false);
  const [dineroActual, setDineroActual] = useState(0);

  useEffect(() => {
    traerCategorias()
  }, [])

  useEffect(() => {
    traerProductos().then(data => setProductos(data)).catch(err => console.log(err))
  }, [])

  useEffect(() => {
    traerDineroEnBilletera(localStorage.getItem("idUsuario")).then(data => setDineroActual(data)).catch(err => console.log(err))
  }, [])

  const agregarCarrito = (product) => {
    cartItems.length!==0 ? setCartItems([...cartItems, product]) : setCartItems([product]);
};

  const abrirModalCompra = (producto) => {
    setProductoCompra(producto)
    setOpen(true);
  };

  return (
    <>
      <Grid>
        <Filtros categorias={categorias} setProductos={setProductos}></Filtros>
        <GridProductos productos={productos} esComprable={true} setCartItems={agregarCarrito} ofertar={abrirModalCompra}></GridProductos>
      </Grid>
      <Carrito productos={cartItems}></Carrito>
      <ModalSubasta producto={productoCompra} open={open} setOpen={setOpen} dineroActual={dineroActual}></ModalSubasta>
    </>
  );
}

export default Productos