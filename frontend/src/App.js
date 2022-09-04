import './App.css';
import ResponsiveNav from './components/ResponsiveNav'
import React, { useState } from 'react'
import { BrowserRouter, Route, Routes } from 'react-router-dom'
import Login from './screens/Login'
import Registro from './screens/Registro'
import Productos from './screens/Productos'
import MisProductos from './screens/MisProductos'
import MisCompras from './screens/MisCompras'
import { createTheme, ThemeProvider } from '@mui/material/styles';


const App = () => {
  const theme = createTheme();

  return (
    <ThemeProvider theme={theme}>
      <BrowserRouter basename="/">
        <ResponsiveNav />
        <Routes>
          <Route exact path={'/'} element={<Productos/>} />
          <Route exact path={'/mis-productos'} element={<MisProductos/>} />
          <Route exact path={'/mis-compras'} element={<MisCompras/>} />
          <Route exact path={'/login'} element={<Login />} />
          <Route exact path={'/registro'} element={<Registro />} />
        </Routes>
      </BrowserRouter>
    </ThemeProvider>
  );
}

export default App;