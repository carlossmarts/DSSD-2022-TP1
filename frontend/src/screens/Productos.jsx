import React, { useEffect, useState } from 'react'
import Grid from '@mui/material/Grid';
import GridProductos from '../components/GridProductos'
import { useProductosPresenter } from '../presenter/productosPresenter'
import ModalSubasta from '../components/ModalSubasta'
import ModalCarrito from '../components/ModalCarrito'
import { useTransaccionesPresenter } from '../presenter/transaccionesPresenter'
import { useCategoriasPresenter } from '../presenter/categoriasPresenter'
import Filtros from '../components/Filtros';



const Productos = (props) => {

  const {
    openModalCarrito,
    setOpenModalCarrito
  } = props;
  
  const { traerProductos } = useProductosPresenter()
  const { traerCategorias, categorias } = useCategoriasPresenter()
  const { actualizarBilletera, traerDineroEnBilletera } = useTransaccionesPresenter()
  const [productos, setProductos] = useState([]);
  const [productoSubasta, setProductoSubasta] = useState({});
  const [cartItems, setCartItems] = useState([]);
  const [openModalSubasta, setOpenModalSubasta] = useState(false);
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

  const abrirModalSubasta = (producto) => {
    setProductoSubasta(producto)
    setOpenModalSubasta(true);
  };
  return (
    <>
      <Grid>
        <Filtros categorias={categorias} setProductos={setProductos}></Filtros>
        <GridProductos productos={productos} esComprable={true} setCartItems={agregarCarrito} ofertar={abrirModalSubasta}></GridProductos>
      </Grid>
      <ModalCarrito productos={cartItems} open={openModalCarrito} setOpen={setOpenModalCarrito} dineroActual={dineroActual}></ModalCarrito>
      <ModalSubasta producto={productoSubasta} open={openModalSubasta} setOpen={setOpenModalSubasta} dineroActual={dineroActual}></ModalSubasta>
    </>
  );
}

export default Productos