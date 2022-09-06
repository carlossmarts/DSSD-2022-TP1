import { useState } from "react"
import axios from 'axios'
import { TransaccionesAPI } from "../services/transaccionesAPI"

export const useTransaccionesPresenter = ()=>{

    const [billetera, setBilletera] = useState([])

    const traerDineroEnBilletera = async (idUsuario)=>{
        // const res = await TransaccionesAPI.traerDineroEnBilletera(idUsuario);
        // return res;
        return 2002
    }

    const actualizarBilletera = async (body)=>{
        try {
            const res = await axios.put(`https://localhost:7252/api/usuario/saldo`, body);
            const saldo = await res.data.saldoBilletera;
            return saldo
        } catch (err) {
            console.error(err)
        }
        return 201
    }
    
    const realizarCompra = async (body)=>{
        try {
            const res = await axios.put(`https://localhost:7252/api/usuario/comprar`, body);
            const locs = await res.data;
            return locs
        } catch (err) {
            console.error(err)
        }
    }

    return {
        billetera,
        setBilletera,
        traerDineroEnBilletera,
        actualizarBilletera,
        realizarCompra
    }
}