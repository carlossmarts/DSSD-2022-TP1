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
import Stack from '@mui/material/Stack';
import Box from '@mui/material/Box';
import Toolbar from '@mui/material/Toolbar';
import Typography from '@mui/material/Typography';
import Container from '@mui/material/Container';
import Link from '@mui/material/Link';
import { createTheme, ThemeProvider } from '@mui/material/styles';
import { ProductionQuantityLimits } from '@mui/icons-material';
import { useCategoriasPresenter } from '../presenter/categoriasPresenter'
import SelectorCategorias from '../components/SelectorCategorias'

const Filtros = (props) => {
    const { categorias } = props;
    const [categoria, setCategoria] = useState({});

    return (
        <React.Fragment>
            <SelectorCategorias opciones={categorias} nombre={'categorias'} setValor={setCategoria}></SelectorCategorias>
        </React.Fragment>
        )
}

export default Filtros;
