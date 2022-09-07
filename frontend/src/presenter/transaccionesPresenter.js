import { useState } from "react"
import axios from "axios";

export const useTransaccionesPresenter = ()=>{

    const [billetera, setBilletera] = useState(0);

    const traerDineroEnBilletera = async (idUsuario)=>{
        try {
            const res = await axios.get(`https://localhost:7252/api/usuario`, {body: body});
            const saldo = await res.data.saldoBilletera;
            return saldo
        } catch (err) {
            console.error(err)
        }
    }

    const actualizarBilletera = async (body)=>{
        try {
            const res = await axios.put(`https://localhost:7252/api/usuario/saldo`, {body: body});
            const saldo = await res.data.saldoBilletera;
            return saldo
        } catch (err) {
            console.error(err)
        }
    }
    
    const realizarCompra = async (body)=>{
        /* 
         body:{
            idTransaccion = 1;
            idProducto 
            idProducto 
            idProducto 
            idComprador
            idVendedor 
            nombre
            cantidad
            precio
         }
        */
        try {
            const res = await axios.put(`https://localhost:7252/api/usuario/comprar`, {body: body});
            const data = await res.data;
            /*
            data= {
                idProducto,
                idComprador,
                cantidadRestante,
                saldoRestante
            }
            */
            return data
        } catch (err) {
            console.error(err)
        }
    }

    return {
        actualizarBilletera,
        realizarCompra, 
        traerDineroEnBilletera
    }
}