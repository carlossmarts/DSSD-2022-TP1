import React, { useReducer, useEffect, useState } from 'react'
import AppBar from '@mui/material/AppBar';
import Box from '@mui/material/Box';
import Toolbar from '@mui/material/Toolbar';
import Typography from '@mui/material/Typography';
import Container from '@mui/material/Container';
import Button from '@mui/material/Button';
import AdbIcon from '@mui/icons-material/Adb';
import { useNavigate } from 'react-router'
import ModalBilletera from './ModalBilletera'
import { useTransaccionesPresenter } from '../presenter/transaccionesPresenter'



const ResponsiveAppBar = () => {
  const [open, setOpen] = useState(false);
  const [dineroActual, setDineroActual] = useState(0);

  const { actualizarBilletera, traerDineroEnBilletera } = useTransaccionesPresenter()

  const history = useNavigate();

  const irARegistro = () => { history("/registro") }
  const irALogin = () => { history("/login") }
  const irAMisProductos = () => { history("/mis-productos") }
  const irAMisCompras = () => { history("/mis-compras") }
  const irAHome = () => { history("/") }

  const cerrarSesion = () => { 
    localStorage.removeItem("idUsuario")
    irAHome()
  }

  const abrirBilletera = () => {
    setOpen(true);
  };

  return (
    <AppBar position="static">
      <Container maxWidth="xl">
        <Toolbar disableGutters>
          <AdbIcon sx={{ display: { xs: 'none', md: 'flex' }, mr: 1 }} />
          <Typography
            variant="h6"
            noWrap
            component="a"
            href="/"
            sx={{
              mr: 2,
              display: { xs: 'none', md: 'flex' },
              fontFamily: 'monospace',
              fontWeight: 700,
              letterSpacing: '.3rem',
              color: 'inherit',
              textDecoration: 'none',
            }}
          >
            RETROSTORE
          </Typography>

          <AdbIcon sx={{ display: { xs: 'flex', md: 'none' }, mr: 1 }} />
          <Box sx={{ flexGrow: 1, display: { xs: 'none', md: 'flex' } }}>
            {
              !localStorage.getItem("idUsuario")
                ?
                <>
                  <Button onClick={irALogin} sx={{ my: 2, color: 'white', display: 'block' }}>Ingresar</Button>
                  <Button onClick={irARegistro} sx={{ my: 2, color: 'white', display: 'block' }}>Registrarse</Button>
                </>

                :
                <>
                  <Button onClick={irAMisProductos} sx={{ my: 2, color: 'white', display: 'block' }}>Mis Productos</Button>
                  <Button onClick={abrirBilletera} sx={{ my: 2, color: 'white', display: 'block' }}>Mi Billetera</Button>
                  <Button onClick={irAMisCompras} sx={{ my: 2, color: 'white', display: 'block' }}>Mis Compras</Button>
                  <Button onClick={cerrarSesion} sx={{ my: 2, color: 'white', display: 'block' }}>Cerrar Sesión</Button>
                </>
            }
          </Box>

        </Toolbar>
      </Container>
      <ModalBilletera open={open} setOpen={setOpen} dineroActual={dineroActual} setDineroActual={setDineroActual} actualizarBilletera={actualizarBilletera}></ModalBilletera>
    </AppBar>
  );
};

export default ResponsiveAppBar;
