import * as React from 'react';
import Grid from '@mui/material/Grid';
import Container from '@mui/material/Container';
import CardProducto from './CardProducto'


const GridProductos = (props) => {
    const { productos, esEditable, editar, esComprable, setCartItems, ofertar } = props;
    return (
        <Container sx={{ py: 3 }} maxWidth="md">
            <Grid container spacing={4} >
                {productos ? productos.map((producto) => (
                    <Grid item key={producto} xs={12} sm={6} md={4} >
                        <CardProducto producto={producto} esEditable={esEditable} editar={editar} esComprable={esComprable} setCartItems={setCartItems} ofertar={ofertar}></CardProducto>
                    </Grid>
                    
                ))
                : null
                }
            </Grid>
        </Container>)
}

export default GridProductos;
