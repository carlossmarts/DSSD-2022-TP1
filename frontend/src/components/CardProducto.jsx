import * as React from 'react';
import Button from '@mui/material/Button';
import Card from '@mui/material/Card';
import CardActions from '@mui/material/CardActions';
import CardContent from '@mui/material/CardContent';
import Typography from '@mui/material/Typography';
import Imagenes from './Imagenes'

const CardProducto = (props) => {
    const { producto, esEditable, editar, esComprable, setCartItems, ofertar } = props;

    return (
        <Card sx={{ mt: 0, mb: 0 }}>
            <Imagenes imagenes={producto.fotos} />
            <CardContent>
                <Typography variant="h5" >
                    {producto.nombre}
                </Typography>
                <Typography variant="h6">
                    {!producto.esSubasta ?
                        <>${producto.precio.toFixed(2)}</>
                        :
                        <>Precio Base: ${producto.precioBase.toFixed(2)}</>
                    }
                </Typography>
                <Typography variant="body2">
                    {producto.descripcion}
                </Typography>
                <Typography variant="body2">
                    Fecha de Fabricación: {producto.fechaFabricacion}
                </Typography>
                <Typography variant="body2">
                    Cantidad Disponible: {producto.cantidadDisponible}
                </Typography>
            </CardContent>
            <CardActions>
                {esEditable ?
                    <Button onClick={() => editar(producto)}>Editar</Button>
                    : esComprable ?
                        !producto.esSubasta ?
                            <Button onClick={() => setCartItems(producto)}>Comprar</Button>
                            :
                            <Button onClick={() => ofertar(producto)}>Ofertar</Button>
                        :
                        <></>
                }
            </CardActions>
        </Card >
    )
}

export default CardProducto;
