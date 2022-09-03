import { useState } from "react"
import { UsuariosApi } from "../services/usuariosAPI"

export const useUsuarioPresenter = ()=>{

    const [user, setUser] = useState([])

    const traerIdUsuario = async(username, password) =>{
        //const res = await UsuarioApi.traerIdUsuario(username, password)
        //return res;
        return 8
    }

    const altaUsuario = async (body)=>{
        //const res = await UsuarioApi.altaUsuario(body);
        //return res;
        return 201
    }
    
    return {
        user,
        setUser,
        traerIdUsuario,
        altaUsuario
    }
}