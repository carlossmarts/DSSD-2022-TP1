import React, { useEffect, useState } from 'react'
import Grid from '@mui/material/Grid';
import GridProductos from '../components/GridProductos'
import { useProductosPresenter } from '../presenter/productosPresenter'
import ModalCompra from '../components/ModalCompra'
import { useTransaccionesPresenter } from '../presenter/transaccionesPresenter'
import { useCategoriasPresenter } from '../presenter/categoriasPresenter'
import Filtros from '../components/Filtros';



const Productos = () => {

  const { traerProductos } = useProductosPresenter()
  const { traerCategorias, categorias } = useCategoriasPresenter()
  const { actualizarBilletera, traerDineroEnBilletera } = useTransaccionesPresenter()
  const [productos, setProductos] = useState([]);
  const [productoCompra, setProductoCompra] = useState({});

  const [open, setOpen] = useState(false);
  const [dineroActual, setDineroActual] = useState(0);

  useEffect(() => {
    traerCategorias()
  }, [])

  useEffect(() => {
    console.log(categorias)
  }, [categorias])

  useEffect(() => {
    traerProductos().then(data => setProductos(data)).catch(err => console.log(err))
  }, [])

  useEffect(() => {
    traerDineroEnBilletera(localStorage.getItem("idUsuario")).then(data => setDineroActual(data)).catch(err => console.log(err))
  }, [])

  const abrirModalCompra = (producto) => {
    setProductoCompra(producto)
    setOpen(true);
  };

  return (
    <>
      <Grid>
        <Filtros categorias={categorias}></Filtros>
        <GridProductos productos={productos} esComprable={true} comprar={abrirModalCompra}></GridProductos>
      </Grid>
      <ModalCompra producto={productoCompra} open={open} setOpen={setOpen} setDineroActual={setDineroActual} dineroActual={dineroActual} actualizarBilletera={actualizarBilletera}></ModalCompra>
    </>
  );
}

export default Productos