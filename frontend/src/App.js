import './App.css';
import ResponsiveNav from './components/ResponsiveNav'
import React, { useState } from 'react'
import { BrowserRouter, Route, Routes } from 'react-router-dom'
import Login from './screens/Login'
import Registro from './screens/Registro'
import Productos from './screens/Productos'
import MisProductos from './screens/MisProductos'
import MisCompras from './screens/MisCompras'
import Monitor from './screens/Monitor';
import { createTheme, ThemeProvider } from '@mui/material/styles';

import { Box } from '@mui/material';
import TestPDF from './components/TestPDF';


const App = () => {
  const theme = createTheme();
  const [openModalCarrito, setOpenModalCarrito] = useState(false);

  return (
    <ThemeProvider theme={theme}>
      <BrowserRouter basename="/">
        <ResponsiveNav setOpenModalCarrito={setOpenModalCarrito} />
        <Routes>
          <Route exact path={'/'} element={<Productos openModalCarrito={openModalCarrito} setOpenModalCarrito={setOpenModalCarrito} />} />
          <Route exact path={'/monitor'} element={<Monitor />} />
          <Route exact path={'/mis-productos'} element={<MisProductos />} />
          <Route exact path={'/mis-compras'} element={<MisCompras />} />
          <Route exact path={'/login'} element={<Login />} />
          <Route exact path={'/registro'} element={<Registro />} />
        </Routes>
      </BrowserRouter>
    </ThemeProvider>
    
    // <Box>
    //   <TestPDF/>
    // </Box>
  );
}

export default App;