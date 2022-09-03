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
            const res = await axios.put(`URLCAMBIAR/api/billetera`, body);
            const locs = await res.status;
            return locs
        } catch (err) {
            console.error(err)
        }
    },

    realizarCompra: async (body) => {
        try {
            const res = await axios.put(`URLCAMBIAR/api/compras`, body);
            const locs = await res.status;
            return locs
        } catch (err) {
            console.error(err)
        }
    }
}