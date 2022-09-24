import axios from 'axios'
import React, { useReducer, useEffect, useState } from 'react'
import { historicoProductoMock, historicoSubastaMock } from '../mock/historial'


export const useHistorialPresenter = () => {

    const getHistorialProductos = async (idProducto) => {
        // const body = {
        //     idProducto: idProducto
        // }
        // try {
        //     const res = await axios.get('localhost:5000/api/producto/getHistorico', body);
        //     const historicoProducto = await res.data;
        //     return historicoProducto
        // } catch (err) {
        //     console.error(err)
        // } 
        return historicoProductoMock
    }

    const getHistorialSubasta = async (idProducto) => {
        // const body = {
        //     idProducto: idProducto
        // }
        // try {
        //     const res = await axios.get('localhost:5000/api/subasta/getHistorico', body);
        //     const historicoSubasta = await res.data;
        //     return historicoSubasta
        // } catch (err) {
        //     console.error(err)
        // } 
        return historicoSubastaMock
    }
    return {
       getHistorialProductos,
       getHistorialSubasta
    }
}