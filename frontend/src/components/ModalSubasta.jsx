import React, { useEffect, useState } from "react";
import Dialog from "@mui/material/Dialog";
import DialogActions from "@mui/material/DialogActions";
import Typography from "@mui/material/Typography";
import { TextField, Grid, Box, Button } from "@mui/material";
import { useTransaccionesPresenter } from "../presenter/transaccionesPresenter";
import { getCurrentDate } from "./UtilsMethods";

const ModalSubasta = (props) => {
  const { open, setOpen, producto, dineroActual } = props;

  const [oferta, setOferta] = useState(0);
  const [ofertaRealizada, setOfertaRealizada] = useState(false);
  const [esMayor, setEsMayor] = useState(false);

  const { registrarOferta, traerDineroEnBilletera } =
    useTransaccionesPresenter();

  useEffect(() => {
    setEsMayor(dineroActual >= producto.precio);
  }, [dineroActual, producto]);

  const handleInputChange = (event) => {
    setOferta(event.target.valueAsNumber);
  };

  const completarOferta = (event) => {
    event.preventDefault();
    const usuario = localStorage.getItem("idUsuario");
    const body = {
      fechaPuja: getCurrentDate("-"),
      idComprador: Number(usuario),
      precioOfrecido: oferta,
      idProducto: producto.idProducto,
    };
    registrarOferta(body).then((res) => {
      console.log("BODY ", JSON.stringify(body));
      console.log("RES ", JSON.stringify(res));
      setOfertaRealizada(true);
    });
  };

  const cerrar = () => {
    setOpen(false);
    setOfertaRealizada(false);
  };

  return (
    <Dialog open={open} onClose={cerrar} fullWidth>
      <Grid container justify="center">
        <Box p={3}>
          <Box>
            <Box>
              <Typography variant="h6" gutterBottom>
                {"RETROSTORE - Subastas"}
              </Typography>
            </Box>
            {!ofertaRealizada ? (
              <>
                <Box>
                  <Typography variant="h6">
                    {`${producto.nombre}, precio base $${producto.precioBase}`}
                  </Typography>
                  <Typography variant="h6">
                    {`El saldo en su billetera es de $${dineroActual}. `}
                    <Box sx={{ p: 2 }}>
                      <form>
                        <TextField
                          type="number"
                          name="Dinero"
                          onChange={handleInputChange}
                          label="Ofertar"
                          defaultValue={0}
                          variant="outlined"
                          fullWidth
                          size="small"
                        />
                      </form>
                    </Box>
                  </Typography>
                </Box>
              </>
            ) : (
              <Box>
                <Typography variant="h6" gutterBottom>
                  {`¡Oferta de $${oferta} realizada!`}
                </Typography>
              </Box>
            )}
          </Box>
        </Box>
      </Grid>
      <DialogActions style={{ display: "flex", justifyContent: "center" }}>
        {!ofertaRealizada && esMayor ? (
          <>
            <Button
              onClick={completarOferta}
              variant="contained"
              color="secondary"
            >
              Ofertar
            </Button>
            <Button onClick={cerrar} variant="outlined" color="secondary">
              Cancelar
            </Button>
          </>
        ) : (
          <Button onClick={cerrar} variant="outlined" color="secondary">
            Cerrar
          </Button>
        )}
      </DialogActions>
      <Box sx={{ p: 1 }}></Box>
    </Dialog>
  );
};

export default ModalSubasta;
