import React, { useState, useEffect } from 'react'
import Grid from '@mui/material/Grid';
import Box from '@mui/material/Box';
import Button from '@mui/material/Button';
import GridProductos from '../components/GridProductos'
import ModalProducto from '../components/ModalProducto'
import {useProductosPresenter} from '../presenter/productosPresenter'


const MisProductos = (props) => {

  const {
    crearProducto,
    editarProductos
  } = props

  const { traerMisProductos } = useProductosPresenter()
  useEffect(() => {
    traerMisProductos().then(data => setProductos(data)).catch(err => console.log(err))
  }, [])

  const [open, setOpen] = useState(false);
  const [openEdicion, setOpenEdicion] = useState(false);
  const [productos, setProductos] = useState([]);
  const [producto, setProducto] = useState({});
  const [productoAEditar, setProductoAEditar] = useState({});
  const [esEdicion, setEsEdicion] = useState(false);

  useEffect(() => {
    console.log(JSON.stringify(producto) +
      "UPDATEADO")
  }, [producto])

  const abrirModalCreacion = () => {
    setEsEdicion(false)
    setOpen(true);
  };

  const abrirModalEdicion = (producto) => {
    setEsEdicion(true)
    setOpenEdicion(true);
    setProductoAEditar(producto)
  };

  return (
    <>
      <Grid>
      <Box p={4} >
          <Button onClick={abrirModalCreacion} variant="contained" color="primary">
            Nuevo producto
          </Button>
        </Box>
      <GridProductos productos={productos} esEditable={true} editar={abrirModalEdicion}></GridProductos>
      <ModalProducto esEdicion={false} open={open} setOpen={setOpen} crearProductos={crearProducto} producto={{}} />
      <ModalProducto esEdicion={true} open={openEdicion} setOpen={setOpenEdicion} editarProductos={editarProductos} producto={productoAEditar} />
      </Grid>
    </>
  );
}

export default MisProductos