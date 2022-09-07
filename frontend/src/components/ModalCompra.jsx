import React, { useEffect, useState } from "react";
import Dialog from "@mui/material/Dialog";
import DialogActions from "@mui/material/DialogActions";
import Typography from "@mui/material/Typography";
import { TextField, Grid, Box, Button } from "@mui/material";
import { useTransaccionesPresenter } from "../presenter/transaccionesPresenter";

const ModalCompra = (props) => {
  const {
    open,
    setOpen,
    producto,
    setDineroActual,
    dineroActual,
    actualizarBilletera,
  } = props;

  const [dinero, setDinero] = useState(0);
  const [compraRealizada, setCompraRealizada] = useState(false);
  const [esMayor, setEsMayor] = useState(false);

  const { realizarCompra, traerDineroEnBilletera } =
    useTransaccionesPresenter();

  useEffect(() => {
    setEsMayor(dineroActual >= producto.precio);
  }, [dineroActual, producto]);

  const completarCompra = (event) => {
    event.preventDefault();
    const usuario = localStorage.getItem("idUsuario")
    const body = {
      idTransaccion: 0,
      idProducto: producto.idProducto,
      idComprador: Number(usuario),
      idVendedor: producto.idUsuario,
      nombre: producto.nombre,
      cantidad: 1,
      precio: producto.precio
   }
   realizarCompra(body).then(
      (res) => {
        console.log('BODY ', JSON.stringify(body))
        console.log('RES ', JSON.stringify(res))
        setDineroActual(res.saldoRestante);
        setCompraRealizada(true);
      }
    );

  };

  const cerrar = () => {
    setOpen(false);
    setCompraRealizada(false);
  };

  return (
    <Dialog open={open} onClose={cerrar} fullWidth>
      <Grid container justify="center">
        <Box p={3}>
          <Box>
            <Box>
              <Typography variant="h6" gutterBottom>
                {"RETROSTORE - Compra"}
              </Typography>
            </Box>
            {!compraRealizada && producto.precio && dineroActual ? (
              <>
                <Box>
                  <Typography variant="h6">
                    {`${producto.nombre}, precio $${producto.precio.toFixed(
                      2
                    )}`}
                  </Typography>
                  <Typography variant="h6">
                    {`El saldo en su billetera es de $${dineroActual.toFixed(
                      2
                    )}. `}
                    {esMayor
                      ? `Después de la compra, su saldo será de $${(
                          dineroActual - producto.precio
                        ).toFixed(2)}`
                      : `Cargue dinero a su billetera para poder comprar el producto ${producto.nombre}`}
                  </Typography>
                </Box>
              </>
            ) : (
              <Box>
                <Typography variant="h6" gutterBottom>
                  {`Compra realizada! Su billetera ahora contiene $${dineroActual}`}
                </Typography>
              </Box>
            )}
          </Box>
        </Box>
      </Grid>
      <DialogActions style={{ display: "flex", justifyContent: "center" }}>
        {!compraRealizada && esMayor ? (
          <>
            <Button
              onClick={completarCompra}
              variant="contained"
              color="secondary"
            >
              Comprar
            </Button>
            <Button onClick={cerrar} variant="outlined" color="secondary">
              Cancelar
            </Button>
          </>
        ) : (
          <Button onClick={cerrar} variant="outlined" color="secondary">
            'Cerrar'
          </Button>
        )}
      </DialogActions>
    </Dialog>
  );
};

export default ModalCompra;
