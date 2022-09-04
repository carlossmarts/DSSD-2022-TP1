import axios from 'axios'

export const ProductosApi = {

    traerProductos: async () => {
        try {
            const res = await axios.get(`https://localhost:7252/api/producto`);
            const locs = await res.data;
            return locs
        } catch (err) {
            console.error(err)
        }
    },

    traerProductosComprados: async (idUsuario) => {
        try {
            const res = await axios.get(`URLCAMBIAR/api/Productos/Compras/${idUsuario}`);
            const locs = await res.data;
            return locs
        } catch (err) {
            console.error(err)
        }
    },

    traerMisProductos: async (idUsuario) => {
        try {
            const res = await axios.get(`URLCAMBIAR/api/Productos/${idUsuario}`);
            const locs = await res.data;
            return locs
        } catch (err) {
            console.error(err)
        }
    },

    crearProductos: async (body) => {
        try {
            const res = await axios.post(`https://localhost:7252/api/producto`, body);
            const locs = await res.status;
            return locs
        } catch (err) {
            console.error(err)
        }
    },

    editarProducto: async (body) => {
        try {
            const res = await axios.put(`URLCAMBIAR/api/Producto/`, body);
            const locs = await res.status;
            return locs
        } catch (err) {
            console.error(err)
        }
    }
}