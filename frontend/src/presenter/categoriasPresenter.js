import axios from 'axios'
import React, { useReducer, useEffect, useState } from 'react'


export const useCategoriasPresenter = () => {
    const [categorias, setCategorias] = useState([])

    const traerCategorias = async () => {
        // try{
        //     const res = await axios.get("https://localhost:7252/api/producto/categorias");
        //     const data = await res.data
        //     setCategorias(data)
        // } catch (e){
        //     console.error("ocurrio un error al consultar las categorias", e)
        // }
        setCategorias([
            {
                "idCategoria": 1,
                "categoria": "Videojuegos"
            },
            {
                "idCategoria": 2,
                "categoria": "Música"
            },
            {
                "idCategoria": 3,
                "categoria": "Comics"
            },
            {
                "idCategoria": 4,
                "categoria": "Revistas"
            },
            {
                "idCategoria": 5,
                "categoria": "Adornos"
            },
            {
                "idCategoria": 6,
                "categoria": "Juegos de mesa"
            },
            {
                "idCategoria": 7,
                "categoria": "Carteles"
            },
            {
                "idCategoria": 8,
                "categoria": "Latas y botellas"
            }
        ])
    }

    return {
        traerCategorias,
        categorias, 
        setCategorias
    }
}

