import React, { useEffect, useState } from 'react'
import Dialog from '@mui/material/Dialog'
import DialogActions from '@mui/material/DialogActions'
import Typography from '@mui/material/Typography'
import { TextField, Grid, Box, Button } from '@mui/material'
import { useTransaccionesPresenter } from '../presenter/transaccionesPresenter'


const ModalBilletera = (props) => {

  const {
    open,
    setOpen,
    setDineroActual,
    dineroActual,
    actualizarBilletera
  } = props;

  const { traerDineroEnBilletera } = useTransaccionesPresenter()

  const [dinero, setDinero] = useState(0);
  const [dineroModificado, setDineroModificado] = useState(false);

  useEffect(() => {
    traerDineroEnBilletera(localStorage.getItem("idUsuario")).then(data => setDineroActual(data)).catch(err => console.log(err))
  }, [])

  const handleInputChange = (event) => {
    console.log(event.target.name)
    setDinero(event.target.valueAsNumber)
  }

  const actualizarDinero = (event) => {
    event.preventDefault();
    actualizarBilletera(dinero, localStorage.getItem("idUsuario")).then(res =>{
      setDineroModificado(true)
      setDineroActual(res)
    })
    
  }

  const cerrar = () => {
    setOpen(false);
    setDineroModificado(false)
  }

  return (
    <Dialog open={open} onClose={cerrar} fullWidth >
      <Grid container justify="center">
        <Box p={3} >
          <Box mb={3}>
            <Typography variant="h6" gutterBottom>
              {"RETROSTORE - Billetera"}
            </Typography>
          </Box>
          {!dineroModificado
              ?
              <><Box mb={3}>
                <Typography variant="h6" gutterBottom>
                  {`Su billetera contiene $${dineroActual}`}
                </Typography>
              </Box>
                <form>
                    <TextField
                      type="number"
                      name="Dinero"
                      onChange={handleInputChange}
                      label="Agregar Dinero a la Billetera"
                      defaultValue={0}
                      variant="outlined"
                      fullWidth
                      size="small"
                    />
                </form>
              </>
              :
              <Box mb={3}>
                <Typography variant="h6" gutterBottom>
                  {`Saldo Actualizado! Su billetera ahora contiene $${dineroActual.toFixed(2)}`}
                </Typography>
              </Box>
          }
        </Box>
      </Grid>

      <DialogActions style={{ display: "flex", justifyContent: "center" }}  >
        <Grid container sx={{ mt: 0, mb: 2 }}  spacing={3} justifyContent="center">
          <Grid item>
            <Button onClick={actualizarDinero} variant="contained" color="secondary">
              Actualizar
            </Button>
          </Grid>
          <Grid item>
            <Button onClick={cerrar} variant="outlined" color="secondary">
              {!dineroModificado ?
                'Cancelar' :
                'Cerrar'}
            </Button>
          </Grid>
        </Grid>
      </DialogActions>
    </Dialog>
  )
}


export default ModalBilletera;