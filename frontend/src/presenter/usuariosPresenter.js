import { useState } from "react"
import axios from "axios"


export const useUsuarioPresenter = () => {
    

    const [user, setUser] = useState([])

    
    const traerIdUsuario = async (username, password) => {
        try {
            const body = {
                usuario: username,
                clave: password
            }
            const res = await axios.post('https://localhost:7252/api/usuario/login', body);
            const user = await res.data;
            return user;
        } catch (err) {
            console.error(err)
        }
    }

    const altaUsuario = async (body) => {
        console.log(JSON.stringify(body))
        try {
            const res = await axios.post('https://localhost:7252/api/usuario', body)
            const ret = await res.data;
            return ret
        } catch (err) {
            console.error(err)
        }
    }

    const getById = async (idUsuario) => {
        console.log(JSON.stringify(idUsuario))
        try {
            const res = await axios.get('https://localhost:7252/api/usuario/',{idUsuario:idUsuario})
            const ret = await res.data;
            console.log(ret)
            return ret
        } catch (err) {
            console.error(err)
        }
    }

    return {
        user,
        setUser,
        traerIdUsuario,
        getById,
        altaUsuario
    }
}