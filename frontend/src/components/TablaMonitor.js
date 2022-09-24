import React from 'react'
import { DataGrid } from '@mui/x-data-grid';
import { Box } from '@mui/material';
import { v4 as uuidv4 } from 'uuid';

const TablaMonitor = (props) => {
    const {
        origen,
        historial
    } = props

    const columnas = 
    origen === "producto" ? 
        [
            {field: "fechaEdicion", headerName: <b>Fecha de edicion</b>, width: 150},
            {field: "nombre", headerName: <b>Nombre</b>, width: 300},
            {field: "precio", headerName: <b>Precio</b>, width: 150}
        ]
    :
        [
            {field: "fechaPuja", headerName: <b>Fecha de puja</b>, width: 150},
            {field: "idComprador", headerName: <b>id comprador</b>, width: 100},
            {field: "nombreComprador", headerName: <b>comprador</b>, width: 200},
            {field: "precioOfrecido", headerName: <b>precio ofrecido</b>, width: 150}
        ]

    return (
        <Box style={{width:'100%', display:'flex', justifyContent:'center'}}>
            <Box style={{height:'450px', width: '600px'}}>
                {
                    origen !== "" ?
                        <DataGrid 
                            rows={historial} 
                            columns={columnas} 
                            pageSize={6}
                            getRowId={(row)=>uuidv4()} 
                        />
                    : null
                }
            </Box>
        </Box>
    )
}

export default TablaMonitor