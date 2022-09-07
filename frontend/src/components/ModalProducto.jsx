import React, { useEffect, useState } from 'react'
import Dialog from '@mui/material/Dialog'
import DialogActions from '@mui/material/DialogActions'
import Typography from '@mui/material/Typography'
import { TextField, Grid, Box, Button } from '@mui/material'
import Archivos from './Archivos'
import SelectorCategorias from './SelectorCategorias'
import { useCategoriasPresenter } from '../presenter/categoriasPresenter'
import { useProductosPresenter } from '../presenter/productosPresenter'


const ModalProducto = (props) => {

  const {
    open,
    setOpen,
    esEdicion,
    producto,
    editarProductos
  } = props;

  const {crearProducto, editarProducto} = useProductosPresenter()
  const [categoria, setCategoria] = useState(producto)
  const [prod, setProd] = useState(producto)

  useEffect(() => {
    setProd(producto)
  }, [producto])

  const { traerCategorias, categorias } = useCategoriasPresenter()
  useEffect(() => {
    traerCategorias()
  }, [])

  useEffect(() => {
    setProd({...prod, idCategoria: categoria.idCategoria})
  }, [categoria])

  useEffect(() => {
    console.log("prod:", prod)
  }, [prod])

  const handleInputChange = (event) => {
    console.log(event.target.name)
    const name = event.target.name
    const value = event.target.type === "number" ? event.target.valueAsNumber : event.target.value
    let temp = {...prod}
    temp[name] = value
    setProd(temp)
  }

  const callCrearProducto = (event) => {
    event.preventDefault();
    const idUsuario = localStorage.getItem("idUsuario")
    crearProducto({...prod, idUsuario: idUsuario}).then((res) => {
      alert("Producto Creado")
    }).then(() => {
      window.location.reload()
    })
  }
  
  const callEditarProducto = (event) => {
    event.preventDefault();
    const idUsuario = localStorage.getItem("idUsuario")
    editarProducto({...prod, idUsuario: idUsuario}).then((res) => {
      if (res === 204)
        alert("Producto Actualizado")
    }).then(() => {
      window.location.reload()
    })
  }

  const cerrar = () => {
    setOpen(false);
  }

  return (
    <Dialog open={open} onClose={cerrar}>
      <Grid container justify="center">
        <Box p={3} style={{ width: '90%' }}>
          <Box p={1}>
            <Box mb={3}>
              <Typography variant="h6" gutterBottom>
                {"RETROSTORE - Productos"}
              </Typography>
            </Box>
            <form>
              <Grid container spacing={3} style={{ width: '100%' }} alignItems="center">
                <Grid item xs={12} sm={6}>
                  <TextField
                    label="Nombre"
                    defaultValue={producto.nombre}
                    variant="outlined"
                    fullWidth
                    size="small"
                    name="nombre"
                    onChange={handleInputChange}
                  />
                </Grid>
                <Grid item xs={12} sm={6} style={{ width: '100%' }}>
                <SelectorCategorias opciones={categorias} nombre={'categorias'} setValor={setCategoria} categoria={categoria}></SelectorCategorias>
                </Grid>
                <Grid item xs={12} sm={12}>
                  <TextField
                    label="Descripción"
                    defaultValue={producto.descripcion}
                    variant="outlined"
                    fullWidth
                    multiline
                    rows={4}
                    size="small"
                    name="descripcion"
                    onChange={handleInputChange}
                  />
                </Grid>
                <Grid item xs={12} sm={6}>
                  <TextField
                    type="number"
                    name="precio"
                    onChange={handleInputChange}
                    label="Precio"
                    defaultValue={producto.precio}
                    variant="outlined"
                    fullWidth
                    size="small"
                  />
                </Grid>
                <Grid item xs={12} sm={6}>
                  <TextField
                    type="number"
                    name="cantidadDisponible"
                    onChange={handleInputChange}
                    label="Cantidad Disponible"
                    defaultValue={producto.cantidadDisponible}
                    variant="outlined"
                    fullWidth
                    size="small"
                  />
                </Grid>
                <Grid item xs={12} sm={6}>
                  <TextField
                    type="date"
                    name="fechaFabricacion"
                    onChange={handleInputChange}
                    label="Fecha de Fabricacion"
                    defaultValue={producto.fechaFabricacion}
                    variant="outlined"
                    fullWidth
                    size="small"
                    InputLabelProps={{
                      shrink: true,
                    }}
                  />
                </Grid>
                <Grid item xs={12}>
                  {
                    prod ?
                      <Archivos
                        form={prod}
                        setForm={setProd}
                      />
                      :
                      null
                  }
                </Grid>
              </Grid>
            </form>
          </Box>
        </Box>
      </Grid>
      <DialogActions style={{ display: "flex", justifyContent: "center" }} >
        {
          !esEdicion
            ?
            <Button onClick={callCrearProducto} variant="contained" color="secondary">
              Crear
            </Button>
            :
            <Button onClick={callEditarProducto} variant="contained" color="secondary">
              Actualizar
            </Button>}
        <Button onClick={cerrar} variant="outlined" color="secondary">
          Cancelar
        </Button>
      </DialogActions>
    </Dialog>
  )
}


export default ModalProducto;