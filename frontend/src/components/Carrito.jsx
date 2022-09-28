import { Grid, Paper, Button, Box, IconButton, ButtonGroup } from '@mui/material';
import React, { useState, useEffect } from 'react'
import RemoveCircleOutlineIcon from '@mui/icons-material/RemoveCircleOutline';
import HighlightOffIcon from '@mui/icons-material/HighlightOff';

export const Carrito = (props) => {
    const { productos } = props;
    const totalPrice = Array.isArray(productos)? productos.reduce((a, c) => a + c.precio, 0): 0
    const [compraRealizada, setCompraRealizada] = useState(false);

    useEffect(() => {
        console.log("cart items " + productos.length)
        console.log("cart items " + Array.isArray(productos))
        console.log("cart items " +  toString(productos))
      }, [productos])

    const realizarCompra = (event) => {
        event.preventDefault();
        const pedido = {
            "estado": "pendiente"
        }
        // crearCompra(pedido).then((res) => {
        //     if (res.status === 201) {
        //         setCompraRealizada(true)
        //         setIdCompra(res.data)
        //     }
        // })
    }

    return (
        <Box height="75%" width='35%' px={2}>
            <Paper>
                <Box p={3} pb={4} style={{ minHeight: 150 }}>
                    {!compraRealizada ?
                        <> <h2 style={{ 'text-align': 'center' }}>Tu carrito</h2>
                            <div>
                                {productos.length === 0 && <div>Tu carrito está vacío</div>}
                                {
                                    Array.isArray(productos)? 
                                    productos.map((item) => (
                                        <div key={item.idProducto} className="row" style={{ "padding-bottom": "10px" }}>
                                            <div className="col-2 text-right" style={{ "display": "flex" }}>
                                                <div style={{ "align-items": "center", "display": "flex", "padding-right": "10px" }}>{item.nombre} ${item.precio.toFixed(2)}</div>
                                            </div>
                                        </div>
                                    )) :
                                    <></>
                                }

                                {productos.length !== 0 && (
                                    <div style={{ 'text-align': 'right' }}>
                                        <hr></hr>
                                        <div className="row">
                                            <div className="col-2">
                                                <strong>Total: </strong>
                                            </div>
                                            <div className="col-1 text-right">
                                                <strong>${totalPrice.toFixed(2)}</strong>
                                            </div>
                                        </div>
                                        <hr />
                                        <Grid container direction="column" item xs>
                                            <Box >
                                                <Button variant="contained" size="small" onClick={(e) => {
                                                    realizarCompra(e)
                                                }}>
                                                    Realizar Compra
                                                </Button>
                                            </Box>

                                        </Grid>
                                    </div>
                                )}
                            </div>
                        </> :
                        <>
                            <h2 style={{ 'text-align': 'center' }}>¡Realizaste tu compra!</h2>
                        </>}
                </Box>
            </Paper >
        </Box >);
}

export default Carrito