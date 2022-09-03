import axios from 'axios'

export const UsuarioApi = {

    traerIdUsuario : async (username, password)=>{
        try{
            console.log("llamando al servicio usuarioLogin con username", username, "y contraseña", password);
            const res = await axios.post('URLCAMBIAR/api/Usuario/login',
                                            {
                                                "username": username,
                                                "password": password
                                            }
                                        );
            const locs = await res.data;
            return locs 
        } catch (err){
            console.error(err)
        }
    },

    altaUsuario: async (body) => {
        try {
            const res = await axios.post('URLCAMBIAR/api/Comercio/ComercioAndUsuario', body)
            const ret = await res.data;
            return ret
        } catch (err) {
            console.error(err)
        }
    }

}