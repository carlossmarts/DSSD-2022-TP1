import React, { useEffect, useState } from "react";
import Grid from "@mui/material/Grid";
import GridProductos from "../components/GridProductos";
import { useProductosPresenter } from "../presenter/productosPresenter";

const MisCompras = () => {
  const { traerProductosComprados } = useProductosPresenter();

  const [productos, setProductos] = useState([]);

  useEffect(() => {
    traerProductosComprados(localStorage.getItem("idUsuario"))
      .then((data) => setProductos(data))
      .catch((err) => console.log(err));
  }, []);

  return (
    <>
      <Grid>
        {productos ? (
          <GridProductos productos={productos}></GridProductos>
        ) : null}
      </Grid>
    </>
  );
};

export default MisCompras;
