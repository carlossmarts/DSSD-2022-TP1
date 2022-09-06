import React, { useEffect, useState } from 'react'
import AppBar from '@mui/material/AppBar';
import Button from '@mui/material/Button';
import CameraIcon from '@mui/icons-material/PhotoCamera';
import Card from '@mui/material/Card';
import CardActions from '@mui/material/CardActions';
import CardContent from '@mui/material/CardContent';
import CardMedia from '@mui/material/CardMedia';
import CssBaseline from '@mui/material/CssBaseline';
import Grid from '@mui/material/Grid';
import { TextField } from '@mui/material';
import Stack from '@mui/material/Stack';
import Box from '@mui/material/Box';
import Toolbar from '@mui/material/Toolbar';
import Typography from '@mui/material/Typography';
import Container from '@mui/material/Container';
import IconButton from '@mui/material/IconButton'
import { blue } from '@mui/material/colors'
import SearchIcon from '@mui/icons-material/Search';
import Link from '@mui/material/Link';
import { createTheme, ThemeProvider } from '@mui/material/styles';
import { ProductionQuantityLimits } from '@mui/icons-material';
import { useCategoriasPresenter } from '../presenter/categoriasPresenter'
import { useProductosPresenter } from '../presenter/productosPresenter'
import SelectorCategorias from '../components/SelectorCategorias'

const Filtros = (props) => {
    const { categorias } = props;
    const [categoria, setCategoria] = useState({});
    const [filtros, setFiltros] = useState({
        categoria: 0,
        nombreLike: "",
        precioDesde: 0,
        precioHasta: 0,
        fechaDesde: "",
        fechaHasta: ""
    })

    const {
        traerProductosPorFiltro,
        productos
    } = useProductosPresenter()

    useEffect(() => {
        let tempFiltros = { ...filtros }
        tempFiltros.categoria = categoria
        setFiltros(tempFiltros)
    }, [categoria])

    const handleChange = (e) => {
        let tempFiltros = { ...filtros }
        tempFiltros[e.target.name] = e.target.value
        setFiltros(tempFiltros)
    }
    const buscarProductos = () => {
        //traerProductosPorFiltro(filtros)
    }


    return (
        <React.Fragment>
            <Box p={4}>
                <Grid container spacing={2}>
                    <Grid item container xs={11} >

                        <Grid item xs={2}>
                            <SelectorCategorias opciones={categorias} nombre={'categorias'} setValor={setCategoria}></SelectorCategorias>
                        </Grid>
                        <Grid item xs={2}>
                            <TextField
                                required
                                name="nombreLike"
                                label="Nombre(like)"
                                id="nombreLike"
                                variant="outlined"
                                value={filtros.nombreLike}
                                InputProps={{ style: { padding: 0, height: "38px" } }}
                                onChange={handleChange}
                            />
                        </Grid>
                        <Grid item xs={2}>
                            <TextField
                                type="date"
                                label="Fecha Desde"
                                variant="outlined"
                                name="fechaDesde"
                                onChange={handleChange}
                                value={filtros.fechaDesde}
                                size="small"
                                inputProps={{ max: filtros.fechaHasta, shrink: true }}
                                InputLabelProps={{
                                    shrink: true,
                                }}
                            />
                        </Grid>
                        <Grid item xs={2}>
                            <TextField
                                type="date"
                                label="Fecha Hasta"
                                variant="outlined"
                                name="fechaHasta"
                                onChange={handleChange}
                                value={filtros.fechaHasta}
                                size="small"
                                inputProps={{ min: filtros.fechaDesde }}
                                InputLabelProps={{
                                    shrink: true,
                                }}
                            />
                        </Grid>
                        <Grid item xs={2}>
                            <TextField
                                type="number"
                                label="Precio Desde"
                                variant="outlined"
                                name="precioDesde"
                                onChange={handleChange}
                                value={filtros.precioDesde}
                                size="small"
                            />
                        </Grid>
                        <Grid item xs={2}>
                            <TextField
                                type="number"
                                label="Precio Hasta"
                                variant="outlined"
                                name="precioHasta"
                                onChange={handleChange}
                                value={filtros.precioHasta}
                                size="small"
                            />
                        </Grid>
                    </Grid>
                    <Grid item xs={1}>
                        <IconButton onClick={buscarProductos}>
                            <SearchIcon style={{ color: blue[700], fontSize: "24px" }} />
                        </IconButton>
                    </Grid>
                </Grid>
            </Box>

        </React.Fragment>
    )
}

export default Filtros;
