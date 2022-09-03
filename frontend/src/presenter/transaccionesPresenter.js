import { useState } from "react"
import { TransaccionesAPI } from "../services/transaccionesAPI"

export const useTransaccionesPresenter = ()=>{

    const [billetera, setBilletera] = useState([])

    const traerDineroEnBilletera = async (body)=>{
        // const res = await TransaccionesAPI.traerDineroEnBilletera(body);
        // return res;
        return 2002
    }

    const actualizarBilletera = async (body)=>{
        // const res = await TransaccionesAPI.actualizarBilletera(body);
        // return res;
        return 201
    }
    
    const realizarCompra = async (body)=>{
        const res = await TransaccionesAPI.realizarCompra(body);
        return res;
    }

    return {
        billetera,
        setBilletera,
        traerDineroEnBilletera,
        actualizarBilletera,
        realizarCompra
    }
}