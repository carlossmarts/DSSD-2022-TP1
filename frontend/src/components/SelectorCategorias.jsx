import { TextField, Grid, Box } from '@mui/material';
import Autocomplete from '@mui/material/Autocomplete';

const SelectorCategorias = (props) => {
    const {
        opciones,
        setValor,
        categoria,
        nombre
    } = props

    return (
        
        <Autocomplete
            value={categoria ?
                opciones[categoria - 1]
                : null}
            id={nombre}
            options={opciones}
            getOptionLabel={op => op.categoria}
            renderInput={(params) => <TextField 
                {...params} 
                label={`ingresar ${nombre}`} 
                variant="outlined" 
                size="small"
                InputProps={{ ...params.InputProps, style: { padding: 8, height: "38px" } }}
            />}
            onChange={(event, value) => setValor(value)}
        >
        </Autocomplete>
        
      
    )
}
export default SelectorCategorias;