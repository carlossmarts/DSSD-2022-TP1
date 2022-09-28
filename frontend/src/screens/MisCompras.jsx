import React, { useEffect, useState } from "react";
import Grid from "@mui/material/Grid";
import GridProductos from "../components/GridProductos";
import Button from "@mui/material/Button";
import Card from "@mui/material/Card";
import CardActions from "@mui/material/CardActions";
import CardContent from "@mui/material/CardContent";
import Container from "@mui/material/Container";
import Typography from "@mui/material/Typography";
import { useProductosPresenter } from "../presenter/productosPresenter";
import { useTransaccionesPresenter } from "../presenter/transaccionesPresenter";
import { PDFDownloadLink } from "@react-pdf/renderer";
import FacturaPDF from "../components/FacturaPDF";

const MisCompras = () => {
  const { traerProductosComprados } = useProductosPresenter();
  const { traerFacturas } = useTransaccionesPresenter();

  const [productos, setProductos] = useState([]);
  const [facturas, setFacturas] = useState([]);

  useEffect(() => {
    traerProductosComprados(localStorage.getItem("idUsuario"))
      .then((data) => setProductos(data))
      .catch((err) => console.log(err));
  }, []);

  useEffect(() => {
    traerFacturas({ idComprador: localStorage.getItem("idUsuario") })
      .then((data) => setFacturas(data))
      .catch((err) => console.log(err));
  }, []);

  useEffect(() => {
    console.log(facturas);
  }, [facturas]);

  const descargarFactura = (idProducto) => {
    return 200;
  };

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
            {facturas.length!=0
              ? facturas.map((factura) => (
                  <Grid item key={factura} xs={12} sm={6} md={4}>
                    <Card sx={{ mt: 0, mb: 0 }}>
                      <CardContent>
                        <Typography variant="h6">
                          {`Compra de ${factura.nombre}`}
                        </Typography>
                        <CardActions>
                          {/* <PDFDownloadLink
                            document={<FacturaPDF factura={factura} />}
                            fileName={`factura.pdf`}
                          >
                            Descargar factura
                          </PDFDownloadLink> */}
                        </CardActions>
                      </CardContent>
                    </Card>
                  </Grid>
                ))
              : null}
          </Grid>
        </Container>
      </Grid>
    </>
  );
};

export default MisCompras;
