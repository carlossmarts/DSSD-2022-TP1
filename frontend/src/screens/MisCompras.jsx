import React, { useEffect, useState } from "react";
import Grid from "@mui/material/Grid";
import GridProductos from "../components/GridProductos";
import Button from '@mui/material/Button';
import Card from '@mui/material/Card';
import CardActions from '@mui/material/CardActions';
import CardContent from '@mui/material/CardContent';
import Container from '@mui/material/Container';
import Typography from '@mui/material/Typography';
import { useProductosPresenter } from "../presenter/productosPresenter";

const lista = [
  {
    "idFactura": 16,
    "fechaCompra": "2022-08-09",
    "totalFacturado": 14985,
    "nombre": "The Nintendo 64 - Randy S Lacombe",
    "precio": 14985,
    "cantidad": 1
  },
  {
    "idFactura": 17,
    "fechaCompra": "2022-09-28",
    "totalFacturado": 55,
    "nombre": "test",
    "precio": 55,
    "cantidad": 1
  },
  {
    "idFactura": 18,
    "fechaCompra": "2022-09-28",
    "totalFacturado": 15935,
    "nombre": "The Nintendo 64 - Randy S Lacombe",
    "precio": 14985,
    "cantidad": 1
  },
  {
    "idFactura": 18,
    "fechaCompra": "2022-09-28",
    "totalFacturado": 15935,
    "nombre": "Juego de cartas Uno Ruibal",
    "precio": 950,
    "cantidad": 1
  },
  {
    "idFactura": 19,
    "fechaCompra": "2022-09-28",
    "totalFacturado": 9590,
    "nombre": "Simon Hg Hasbro",
    "precio": 9590,
    "cantidad": 1
  }
]

const MisCompras = () => {
  const { traerProductosComprados } = useProductosPresenter();

  const [productos, setProductos] = useState([]);

  useEffect(() => {
    traerProductosComprados(localStorage.getItem("idUsuario"))
      .then((data) => setProductos(data))
      .catch((err) => console.log(err));
  }, []);

  const descargarFactura = (idProducto) => {
    return 200
  }

  return (
    <>
      <Grid>
        {productos ? (
          <GridProductos productos={productos}></GridProductos>
        ) : null}
      </Grid>
      <Grid>
        <Container sx={{ py: 3 }} maxWidth="md">
          <Grid container spacing={4} >
            {lista
              ? lista.map((producto) => (
                <Grid item key={producto} xs={12} sm={6} md={4} >
                  <Card sx={{ mt: 0, mb: 0 }}>
                    <CardContent>
                      <Typography variant="h6" >
                        {`Compra de ${producto.nombre}`}
                      </Typography>
                      <CardActions>
                        <Button onClick={() => descargarFactura(factura)}>Ver Factura</Button>
                      </CardActions>
                    </CardContent>
                  </Card >
                </Grid>
              ))
              : null
            }
          </Grid>
        </Container>
      </Grid>
    </>
  );
};

export default MisCompras;
