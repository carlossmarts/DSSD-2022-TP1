import axios from 'axios'

export const TransaccionesAPI = {

    traerDineroEnBilletera: async (idUsuario) => {
        try {
            const res = await axios.get(`URLCAMBIAR/api/billetera/${idUsuario}`);
            const locs = await res.data;
            return locs
        } catch (err) {
            console.error(err)
        }
    },

    actualizarBilletera: async (body) => {
        try {
            const res = await axios.put(`https://localhost:7252/api/usuario/saldo`, body);
            const locs = await res.status;
            return locs
        } catch (err) {
            console.error(err)
        }
    },

    realizarCompra: async (body) => {
        try {
            const res = await axios.put(`https://localhost:7252/api/usuario/comprar`, body);
            const locs = await res.status;
            return locs
        } catch (err) {
            console.error(err)
        }
    }
}