import React, { useReducer, useEffect, useState } from 'react'
import Dialog from '@mui/material/Dialog'
import DialogActions from '@mui/material/DialogActions'
import Typography from '@mui/material/Typography'
import { TextField, Grid, Box, Button, Checkbox, FormControlLabel } from '@mui/material'
import Archivos from './Archivos'

const ModalProducto = (props) => {

  const {
    open,
    setOpen,
    esEdicion,
    producto,
    crearProductos,
    editarProductos
  } = props;



  useEffect(() => {
    setProd(producto)
  }, [producto])


  const [prod, setProd] = useState(producto)

  const handleInputChange = (event) => {
    console.log(event.target.name)
    if (event.target.name == "visible") {
      setProd({
        ...prod,
        [event.target.name]: event.target.checked
      })
    } else if (event.target.name == "precio") {
      setProd({
        ...prod,
        [event.target.name]: event.target.valueAsNumber
      })
    } else {
      setProd({
        ...prod,
        [event.target.name]: event.target.value
      })
    }
  }

  const crearProducto = (event) => {
    event.preventDefault();
    crearProductos(prod, localStorage.getItem("idUsuario")).then((res) => {
      if (res === 201)
        alert("Producto Creado")
    }).then(() => {
      window.location.reload()
    })
  }

  const editarProducto = (event) => {
    event.preventDefault();
    editarProductos(prod).then((res) => {
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
                  <FormControlLabel
                    control={<Checkbox
                      name="visible"
                      onChange={handleInputChange}
                      checked={producto.visible}
                    />} label="Publicado"
                  />
                </Grid>
                <Grid item xs={12}>
                  {
                    producto ?
                      <Archivos
                        form={producto}
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
            <Button onClick={crearProducto} variant="contained" color="secondary">
              Crear
            </Button>
            :
            <Button onClick={editarProducto} variant="contained" color="secondary">
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