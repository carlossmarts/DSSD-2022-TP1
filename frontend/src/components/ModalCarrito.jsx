import React, { useEffect, useState } from "react";
import Dialog from "@mui/material/Dialog";
import DialogActions from "@mui/material/DialogActions";
import Typography from "@mui/material/Typography";
import { TextField, Grid, Box, Button } from "@mui/material";
import { useTransaccionesPresenter } from "../presenter/transaccionesPresenter";

const ModalCarrito = (props) => {
  const {
    open,
    setOpen,
    productos,
    setDineroActual,
    dineroActual,
    actualizarBilletera,
  } = props;

  const [dinero, setDinero] = useState(0);
  const [compraRealizada, setCompraRealizada] = useState(false);
  const [esMayor, setEsMayor] = useState(false);
  const precioTotal = Array.isArray(productos) ? productos.reduce((a, c) => a + c.precio, 0) : 0

  const { realizarCompra, traerDineroEnBilletera } =
    useTransaccionesPresenter();

  useEffect(() => {
    setEsMayor(dineroActual >= precioTotal);
  }, [dineroActual, productos]);

  const completarCompra = (event) => {
    event.preventDefault();
    const usuario = localStorage.getItem("idUsuario")
    const body = {
      idTransaccion: 0,
      idUsuario: usuario
      //COMPLETAR PARA COMPRA
    }
    realizarCompra(body).then(
      (res) => {
        console.log('BODY ', JSON.stringify(body))
        console.log('RES ', JSON.stringify(res))
        //setDineroActual(res.saldoRestante);
        setDineroActual(dineroActual-precioTotal);
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
            {!compraRealizada && precioTotal && dineroActual ? (
              productos.length === 0 ? <div>Tu carrito está vacío</div> 
              :
                productos.map((item) => (
                  <div key={item.idProducto} className="row" style={{ "padding-bottom": "10px" }}>
                    <div className="col-2 text-right" style={{ "display": "flex" }}>
                      <div style={{ "align-items": "center", "display": "flex", "padding-right": "10px" }}>{item.nombre} ${item.precio.toFixed(2)}</div>
                    </div>
                  </div>
                ))
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
            Cerrar
          </Button>
        )}
      </DialogActions>
    </Dialog>
  );
};

export default ModalCarrito;
