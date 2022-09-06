import { useState } from "react"
import axios from "axios"


export const useUsuarioPresenter = () => {

    const [user, setUser] = useState([])

    const traerIdUsuario = async (username, password) => {
        try {
            const body = {
                username: username,
                password: password
            }
            console.log("llamando al servicio usuarioLogin con username", username, "y contraseña", password);
            const res = await axios.post('https://localhost:7252/api/usuario/login', body);
            const user = await res.data;
            return user;
        } catch (err) {
            console.error(err)
        }
        return 8
    }

    const altaUsuario = async (body) => {
        try {
            const res = await axios.post('https://localhost:7252/api/usuario', body)
            const ret = await res.data;
            return ret
        } catch (err) {
            console.error(err)
        }
    }

    return {
        user,
        setUser,
        traerIdUsuario,
        altaUsuario
    }
}