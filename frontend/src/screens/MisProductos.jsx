import React, { useState, useEffect } from 'react'
import Grid from '@mui/material/Grid';
import Box from '@mui/material/Box';
import Button from '@mui/material/Button';
import GridProductos from '../components/GridProductos'
import ModalProducto from '../components/ModalProducto'
import {useProductosPresenter} from '../presenter/productosPresenter'


const MisProductos = (props) => {

  const {
    editarProductos
  } = props

  const { traerMisProductos, crearProducto } = useProductosPresenter()

  useEffect(() => {
    traerMisProductos().then(data => setProductos(data)).catch(err => console.log(err))
  }, [])

  const [open, setOpen] = useState(false);
  const [openEdicion, setOpenEdicion] = useState(false);
  const [productos, setProductos] = useState([]);
  const [producto, setProducto] = useState({
    idProducto : 0,
    nombre : "",
    descripcion : "",
    precio : "",
    cantidadDisponible : "",
    fechaFabricacion : "",
	  fotos : [],
	  idCategoria : 0,
	  idUsuario : 0
  });
  const [productoAEditar, setProductoAEditar] = useState({});
  const [esEdicion, setEsEdicion] = useState(false);

  const abrirModalCreacion = () => {
    setEsEdicion(false)
    setOpen(true);
  };

  const abrirModalEdicion = (producto) => {
    console.log('este es el producto' +producto.nombre)
    setProductoAEditar(producto)
    setEsEdicion(true)
    setOpenEdicion(true);
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
      <ModalProducto esEdicion={false} open={open} setOpen={setOpen} crearProductos={crearProducto} producto={producto} />
      <ModalProducto esEdicion={true} open={openEdicion} setOpen={setOpenEdicion} editarProductos={editarProductos} producto={productoAEditar} />
      </Grid>
    </>
  );
}

export default MisProductos