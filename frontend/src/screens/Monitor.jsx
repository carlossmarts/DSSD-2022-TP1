import React, { useState, useEffect }from 'react'
import {Box, Grid} from '@mui/material'
import FiltroMonitor from '../components/FiltroMonitor';
import TablaMonitor from '../components/TablaMonitor';



const Monitor = () => {
    
    const [origen, setOrigen] = useState("")
    const [historial, setHistorial] = useState([])

    useEffect(() => {
      console.log(historial)
    }, [historial])
    
    return (  
        <Box p={4}>
            <Grid container direction='column' spacing={2}>
                <Grid item xs={12}>
                    <FiltroMonitor
                        setHistorial={setHistorial}
                        setOrigen={setOrigen}
                    />
                </Grid>
                <Grid item>
                    <TablaMonitor
                        origen={origen}
                        historial={historial}
                    />
                </Grid>
            </Grid>
        </Box>
    ) 
}
    
export default Monitor
