import axios from 'axios'
import { v4 as uuidv4 } from 'uuid';


export const useHistorialPresenter = () => {

    const getHistorialProductos = async (idProducto) => {
        const body = {
            groupId: uuidv4(),
            topic: `productos_${idProducto}`
        }
                console.log(body);

        try {
            const res = await axios.post('http://localhost:5000/api/producto/getHistorico', body);
            const historicoProducto = await res.data;
            return historicoProducto
        } catch (err) {
            console.error(err)
        } 
    }

    const getHistorialSubasta = async (idProducto) => {
        const body = {
            groupId: uuidv4(),
            topic: `ofertas_${idProducto}`
        }
        console.log(body);
        try {
            const res = await axios.post('http://localhost:5000/api/subasta/getHistorico', body);
            const historicoSubasta = await res.data;
            return historicoSubasta
        } catch (err) {
            console.error(err)
        } 
    }
    return {
       getHistorialProductos,
       getHistorialSubasta
    }
}