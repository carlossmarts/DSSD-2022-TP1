import React, { useEffect, useState } from "react";
import Dialog from "@mui/material/Dialog";
import DialogActions from "@mui/material/DialogActions";
import Typography from "@mui/material/Typography";
import { TextField, Grid, Box, Button } from "@mui/material";
import { useTransaccionesPresenter } from "../presenter/transaccionesPresenter";
import { getCurrentDate } from "./UtilsMethods";

const ModalCarrito = (props) => {
  const { open, setOpen, productos, setDineroActual, dineroActual } = props;

  const [dinero, setDinero] = useState(0);
  const [compraRealizada, setCompraRealizada] = useState(false);
  const precioTotal = Array.isArray(productos)
    ? productos.reduce((a, c) => a + c.precio, 0)
    : 0;
  const [compraEnProceso, setCompraEnProceso] = useState(false);

  const { realizarCompra, generarFactura } = useTransaccionesPresenter();

  const completarCompra = (event) => {
    event.preventDefault();
    var prodCliente = [];
    const usuario = localStorage.getItem("idUsuario");
    setCompraEnProceso(true);
    productos
      .map((producto, i) => {
        console.log(producto.nombre);
        const body = {
          idTransaccion: 0,
          idProducto: producto.idProducto,
          idComprador: Number(usuario),
          idVendedor: producto.idUsuario,
          nombre: producto.nombre,
          cantidad: 1,
          precio: producto.precio,
        };
        const bodyProdCliente = {
          fechaCompra: getCurrentDate("-"),
          idVendedor: producto.idUsuario,
          idComprador: Number(usuario),
          productos: [
            {
              nombre: producto.nombre,
              precio: producto.precio,
              cantidad: 1,
            },
          ],
          totalFacturado: producto.precio,
        };

        const bodyProd = {
          nombre: producto.nombre,
          precio: producto.precio,
          cantidad: 1,
        };

        if (prodCliente.length === 0) {
          prodCliente.push(bodyProdCliente);
        } else {
          var existe = false;
          for (i = 0; i < prodCliente.length; i++) {
            if (prodCliente[i].idVendedor === bodyProdCliente.idVendedor) {
              existe = true;
              prodCliente[i].productos = [
                ...prodCliente[i].productos,
                bodyProd,
              ];
              prodCliente[i].totalFacturado = prodCliente[i].productos.reduce(
                (a, c) => a + c.precio,
                0
              );
            }
          }
          if (!existe) {
            prodCliente.push(bodyProdCliente);
          }
        }
        realizarCompra(body).then((res) => {
          console.log("BODY ", JSON.stringify(body));
          console.log("RES ", JSON.stringify(res));
          if (i === productos.length - 1) {
            setDineroActual(dineroActual - precioTotal);
            setCompraEnProceso(false);
            setCompraRealizada(true);
          }
        });
      })
      .then(
        prodCliente.map((factura) => {
          generarFactura(factura).then((res) => {
            console.log("RES ", JSON.stringify(res));
          });
        })
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
              productos.length === 0 ? (
                <div>Tu carrito está vacío</div>
              ) : !compraEnProceso ? (
                <>
                  <Typography variant="h6" gutterBottom>
                    {"Estas comprando:"}
                  </Typography>
                  <div></div>
                  {productos.map((item) => (
                    <div
                      key={item.idProducto}
                      className="row"
                      style={{ "padding-bottom": "10px" }}
                    >
                      <div
                        className="col-2 text-right"
                        style={{ display: "flex" }}
                      >
                        <div
                          style={{
                            "align-items": "center",
                            display: "flex",
                            "padding-right": "10px",
                          }}
                        >
                          {item.nombre} ${item.precio.toFixed(2)}
                        </div>
                      </div>
                    </div>
                  ))}
                  <div>{`Total a gastar $${precioTotal.toFixed(2)}`}</div>
                </>
              ) : (
                <div>Tu compra esta en proceso! Espera unos instantes</div>
              )
            ) : (
              <Box>
                <Typography variant="h6" gutterBottom>
                  {`Compra realizada! Su billetera ahora contiene $${dineroActual.toFixed(
                    2
                  )}`}
                </Typography>
              </Box>
            )}
          </Box>
        </Box>
      </Grid>
      <DialogActions style={{ display: "flex", justifyContent: "center" }}>
        {!compraRealizada ? (
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
