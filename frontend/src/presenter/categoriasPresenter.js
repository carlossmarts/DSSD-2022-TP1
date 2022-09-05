import axios from 'axios'
import React from 'react'

const categoriasPresenter = () => {
    const [categorias, setCategorias] = useState([])
  
    const getAll = async()=>{
        try{
            const res = await axios.get("https://localhost:7252/api/producto/categorias");
            const data = await res.data
            setCategorias(data)
        } catch (e){
            console.error("ocurrio un error al consultar las categorias", e)
        }
    }
  
    return {
        getAll,
        categorias
    }
}

export default categoriasPresenter