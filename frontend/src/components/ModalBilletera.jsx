import React, { useEffect, useState } from 'react'
import Dialog from '@mui/material/Dialog'
import DialogActions from '@mui/material/DialogActions'
import Typography from '@mui/material/Typography'
import { TextField, Grid, Box, Button } from '@mui/material'


const ModalBilletera = (props) => {

  const {
    open,
    setOpen,
    setDineroActual,
    dineroActual,
    actualizarBilletera
  } = props;

  const [dinero, setDinero] = useState(0);
  const [dineroModificado, setDineroModificado] = useState(false);


  const handleInputChange = (event) => {
    console.log(event.target.name)
    setDinero(event.target.valueAsNumber)
  }

  const actualizarDinero = (event) => {
    event.preventDefault();
    actualizarBilletera((dinero + dineroActual), localStorage.getItem("idUsuario")).then((res) => {
      if (res === 201)
        setDineroModificado(true)
      setDineroActual(dinero + dineroActual)
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
          {
            !dineroModificado
              ?
              <><Box mb={3}>
                <Typography variant="h6" gutterBottom>
                  {`Su billetera contiene $${dineroActual.toFixed(2)}`}
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
        <Grid sx={{ mt: 0, mb: 2 }}  spacing={3} >
          <Button onClick={actualizarDinero} variant="contained" color="secondary">
            Actualizar
          </Button>
          <Button onClick={cerrar} variant="outlined" color="secondary">
            {!dineroModificado ?
              'Cancelar' :
              'Cerrar'}
          </Button>
        </Grid>
      </DialogActions>
    </Dialog>
  )
}


export default ModalBilletera;