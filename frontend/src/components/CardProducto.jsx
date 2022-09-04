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
        <div>
            <Card>
                <Imagenes
                    imagenes={producto.fotos}
                />
                <CardContent>
                    <CardContent>
                        <Typography variant="h5" component="h2">
                            {producto.nombre}
                        </Typography>
                    </CardContent>
                    <Typography >
                        {producto.descripcion}
                    </Typography>
                    <Typography>
                        {producto.precio}
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
        </div >)
}

export default CardProducto;
