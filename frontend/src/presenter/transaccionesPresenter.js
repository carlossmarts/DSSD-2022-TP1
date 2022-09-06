import { useState } from "react"
import axios from "axios";

export const useTransaccionesPresenter = ()=>{

    const [billetera, setBilletera] = useState(0);

    const actualizarBilletera = async (idUsuario, saldo)=>{
        const body = {
            idUsuario: idUsuario,
            saldo: saldo
        }
        try {
            const res = await axios.put(`https://localhost:7252/api/usuario/saldo`, body);
            const data = await res.data;
            setBilletera(data.saldoBilletera)
        } catch (err) {
            console.error(err)
        }
        return 201
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
            const data = await res.status;
            /*
            data= {
                idProducto,
                idComprador,
                cantidadRestante,
                saldoRestante
            }
            */
            setBilletera(data.saldoRestante)
        } catch (err) {
            console.error(err)
        }
        return 201;
    }

    return {
        actualizarBilletera,
        realizarCompra
    }
}