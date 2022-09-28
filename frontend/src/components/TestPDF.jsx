import React, { useState } from 'react'
import {PDFDownloadLink, PDFViewer} from '@react-pdf/renderer'
import FacturaPDF from './FacturaPDF'
import { Box } from '@mui/material'

const TestPDF = () => {
    
    const [factura, setFactura] = useState({
        "fechaCompra":"2022-09-12 23:56:00",
        "idVendedor": 1,
        "idComprador":1,
        "productos": [
            { 
                "nombre": "Papure",
                "precio": 250,
                "cantidad":2
            },
            { 
                "nombre": "falopa",
                "precio": 500,
                "cantidad":3
            },
            { 
                "nombre": "hamburguejas",
                "precio": 10000,
                "cantidad":10
            }
        ],
        "totalFacturado":500
    })
    
    
    return (
        <Box p={4}>
        <PDFViewer style={{width:"80%", height: "800px"}}>
            <FacturaPDF
                factura={factura}
            />
        </PDFViewer>
        <PDFDownloadLink
            document={
                <FacturaPDF
                    factura={factura}
                />
            }
            fileName={`factura.pdf`}
        >
        descargar factura
        </PDFDownloadLink>
        </Box>
    )
}

export default TestPDF