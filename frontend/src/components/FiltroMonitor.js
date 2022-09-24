import React, {useState, useEffect} from 'react'
import { Typography, Grid, Box, TextField, Button, Select, MenuItem } from '@mui/material'
import makeStyles from '@mui/styles/makeStyles';
import { useHistorialPresenter } from '../presenter/historialPresenter';
import { useProductosPresenter } from '../presenter/productosPresenter';


const FiltroMonitor = (props)=>{
    const {
        setHistorial,
        setOrigen
    } = props
    const classes = useStyles()
    const [idProducto, setIdProducto] = useState("")
    const [productos, setProductos] = useState([])
    
    const { historial, getHistorialProductos, getHistorialSubasta } = useHistorialPresenter()
    const { traerProductos } = useProductosPresenter()

    useEffect(() => {
        traerProductos().then(data => setProductos(data)).catch(err => console.log(err))
    }, [])

    const handleChange = (e)=>{
        setOrigen("")
        setIdProducto(e.target.value.toString())
    }
    const handleClick = (origen) =>{
        setOrigen(origen)
        origen === "producto" ?
            getHistorialProductos().then(data=>setHistorial(data)).catch(err => console.log(err))
        :
            getHistorialSubasta().then(data=>setHistorial(data)).catch(err => console.log(err))
    }

    return(
        <Grid container >
            <Grid xs={2}/>
            <Grid item xs={8} container justyfyContent='center' alignItems='center' spacing={1}>
                <Grid item xs={2}>
                    <Typography color="primary" className={classes.label}>
                        Producto:
                    </Typography>
                </Grid>
                <Grid item xs={6}>
                            <Select 
                                id="producto-select"
                                value={idProducto}
                                onChange={handleChange}
                                fullWidth
                            >
                                {
                                    productos ? productos.map((producto) =>{
                                    return (
                                        <MenuItem  
                                            key={producto.idProducto}
                                            value={producto.idProducto}
                                        > 
                                            {producto.nombre} 
                                        </MenuItem>
                                    )
                                    })
                                    : null
                                }
                            </Select>
                </Grid>
                <Grid item xs={4} container direction='column' spacing={1} alignItems='flex-end'>
                    <Grid item>
                        <Button variant="contained" size='small' color="primary" onClick={()=>handleClick("producto")}>
                            Historial Cambios
                        </Button>
                    </Grid>
                    <Grid item>
                        <Button variant="contained" size='small' color="primary" onClick={()=>handleClick("subasta")}>
                            Historial Subasta
                        </Button>
                    </Grid>
                
                </Grid>

            </Grid>
            <Grid xs={2}/>
        </Grid>
    )

}

export default FiltroMonitor

const useStyles = makeStyles((theme)=>({
    label:{
        fontSize: 16,
        fontWeight: 'bold'
    }
}))