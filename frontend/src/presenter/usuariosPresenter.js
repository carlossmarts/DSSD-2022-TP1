import { useState } from "react"
import axios from "axios"


export const useUsuarioPresenter = ()=>{

    const [user, setUser] = useState([])

    const traerIdUsuario = async(username, password) =>{
        const body = {
            username: username,
            password: password
        }
        try{
            console.log("llamando al servicio usuarioLogin con username", username, "y contraseña", password);
            const res = await axios.post('https://localhost:7252/api/usuario/login', { body: body});
            const data = await res.data;
            setUser(data)
            return data 
        } catch (err){
            console.error(err)
        }
        return 8
    }

    const altaUsuario = async (body)=>{
        try {
            const res = await axios.post('https://localhost:7252/api/usuario', {body: body})
            const data = await res.data;
            setUser(data)
            return data
        } catch (err) {
            console.error(err)
        }
        return 201
    }
    
    return {
        user,
        setUser,
        traerIdUsuario,
        altaUsuario
    }
}