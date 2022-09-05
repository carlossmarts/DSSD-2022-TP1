import * as React from 'react';
import Button from '@mui/material/Button';
import Card from '@mui/material/Card';
import CardActions from '@mui/material/CardActions';
import CardContent from '@mui/material/CardContent';
import Typography from '@mui/material/Typography';
import Imagenes from './Imagenes'

const CardProducto = (props) => {
    const { producto, esEditable, editar, esComprable, comprar } = props;
    return (
            <Card sx={{ mt: 0, mb: 0 }}>
                <Imagenes imagenes={producto.fotos} />
                <CardContent>
                    <Typography variant="h5" >
                        {producto.nombre}
                    </Typography>
                    <Typography variant="h6">
                        ${producto.precio.toFixed(2)}
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
                            <Button onClick={() => comprar(producto)}>Comprar</Button>
                            :
                            <></>
                    }
                </CardActions>
            </Card >
       )
}

export default CardProducto;
