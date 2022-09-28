import { useState } from "react"
import axios from "axios";

export const useTransaccionesPresenter = () => {

    const [billetera, setBilletera] = useState(0);

    const traerDineroEnBilletera = async (idUsuario) => {
        try {
            const res = await axios.get(`https://localhost:7252/api/usuario?idUsuario=${idUsuario}`);
            const saldo = await res.data.usuario.saldoBilletera;
            return saldo
        } catch (err) {
            console.error(err)
        }
    }

    const actualizarBilletera = async (saldo, idUsuario) => {
        const body = {
            idUsuario: idUsuario,
            saldo: saldo
        }
        try {
            const res = await axios.put(`https://localhost:7252/api/usuario/saldo`, body);
            const saldo = await res.data.saldoBilletera;
            return saldo
        } catch (err) {
            console.error(err)
        }
    }

    const realizarCompra = async (body) => {
        /* 
         body:{
            idTransaccion = 1;
            idProducto 
            idComprador
            idVendedor 
            nombre
            cantidad
            precio
         }
        */
        try {
            const res = await axios.post(`https://localhost:7252/api/billetera/compra`, body);
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

    const generarFactura = async (body) => {
        /* 
         body:{
            idTransaccion = 1;
            idProducto 
            idComprador
            idVendedor 
            nombre
            cantidad
            precio
         }
        */
        try {
            const res = await axios.post(`http://localhost:5000/api/facturacion/generarFactura`, body);
            console.log(res.data);
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

    const registrarOferta = async (body) => {
        try {
            const res = await axios.post(`http://localhost:5000/api/subasta/`, body);

        } catch (err) {
            console.error(err);
        }
    }

    const traerFacturas = async (body) => {
        return [
            {
                "idFactura": 16,
                "fechaCompra": "2022-08-09",
                "totalFacturado": 14985,
                "nombre": "The Nintendo 64 - Randy S Lacombe",
                "precio": 14985,
                "cantidad": 1
            },
            {
                "idFactura": 17,
                "fechaCompra": "2022-09-28",
                "totalFacturado": 55,
                "nombre": "test",
                "precio": 55,
                "cantidad": 1
            },
            {
                "idFactura": 18,
                "fechaCompra": "2022-09-28",
                "totalFacturado": 15935,
                "nombre": "The Nintendo 64 - Randy S Lacombe",
                "precio": 14985,
                "cantidad": 1
            },
            {
                "idFactura": 18,
                "fechaCompra": "2022-09-28",
                "totalFacturado": 15935,
                "nombre": "Juego de cartas Uno Ruibal",
                "precio": 950,
                "cantidad": 1
            },
            {
                "idFactura": 19,
                "fechaCompra": "2022-09-28",
                "totalFacturado": 9590,
                "nombre": "Simon Hg Hasbro",
                "precio": 9590,
                "cantidad": 1
            }
        ]
    }

    return {
        actualizarBilletera,
        realizarCompra,
        traerDineroEnBilletera,
        registrarOferta,
        generarFactura,
        traerFacturas
    }
}