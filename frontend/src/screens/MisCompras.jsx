import React, { useEffect, useState } from 'react'
import Grid from '@mui/material/Grid';
import GridProductos from '../components/GridProductos'
import {useProductosPresenter} from '../presenter/productosPresenter'


const MisCompras = () => {

  const { traerProductosComprados } = useProductosPresenter()

  const [productos, setProductos] = useState([]);

  useEffect(() => {
    traerProductosComprados().then(data => setProductos(data)).catch(err => console.log(err))
  }, [])

  return (
    <>
      <Grid>
        <GridProductos productos={productos}></GridProductos>
      </Grid>
    </>
  );
}

export default MisCompras