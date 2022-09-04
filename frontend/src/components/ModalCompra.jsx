import React, { useEffect, useState } from 'react'
import Dialog from '@mui/material/Dialog'
import DialogActions from '@mui/material/DialogActions'
import Typography from '@mui/material/Typography'
import { TextField, Grid, Box, Button } from '@mui/material'


const ModalCompra = (props) => {

  const {
    open,
    setOpen,
    producto,
    setDineroActual,
    dineroActual,
    actualizarBilletera
  } = props;

  const [dinero, setDinero] = useState(0);
  const [compraRealizada, setCompraRealizada] = useState(false);
  const [esMayor, setEsMayor] = useState(false);

  useEffect(() => {
    setEsMayor(dineroActual >= producto.precio)
  }, [dineroActual, producto])

  const actualizarDinero = (event) => {
    event.preventDefault();
    actualizarBilletera((dinero + dineroActual), localStorage.getItem("idUsuario")).then((res) => {
      if (res === 201)
        setCompraRealizada(true)
      setDineroActual(dinero + dineroActual)
    })
  }


  const cerrar = () => {
    setOpen(false);
    setCompraRealizada(false)
  }

  return (
    <Dialog open={open} onClose={cerrar} fullWidth >
      <Grid container justify="center">
        <Box p={3} >
          <Box p={1}>
            <Box mb={3}>
              <Typography variant="h6" gutterBottom>
                {"RETROSTORE - Compra"}
              </Typography>
            </Box>
            {
              !compraRealizada
                ?
                <>
                  <Box mb={3}>
                    <Typography variant="h6" gutterBottom>
                      {`${producto.nombre}, precio $${producto.precio}`}
                    </Typography>
                    <Typography variant="h6" gutterBottom>
                      {`Tiene cargado en su billetera un total de $${dineroActual}. `}
                      {esMayor ?
                        `Después de la compra, su saldo será de $${dineroActual - producto.precio}`
                        :
                        `Carga dinero a tu billetera para poder comprar el producto ${producto.nombre}`}
                    </Typography>
                  </Box>
                </>
                :
                <Box mb={3}>
                  <Typography variant="h6" gutterBottom>
                    {`Compra realizada! Su billetera ahora contiene $${dineroActual}`}
                  </Typography>
                </Box>
            }
          </Box>
        </Box>
      </Grid>
      <DialogActions style={{ display: "flex", justifyContent: "center" }} >
        {
          !compraRealizada && esMayor ?
            <>
              <Button onClick={actualizarDinero} variant="contained" color="secondary">
                Comprar
              </Button>
              <Button onClick={cerrar} variant="outlined" color="secondary">
                'Cancelar'
              </Button>
            </>
            :
            <Button onClick={cerrar} variant="outlined" color="secondary">'Cerrar'</Button>}
      </DialogActions>
    </Dialog>
  )
}


export default ModalCompra;