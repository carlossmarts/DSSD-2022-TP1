import React, {useState, useEffect} from 'react'
import { Document, Page, Text, View, StyleSheet } from '@react-pdf/renderer'
import { useUsuarioPresenter } from '../presenter/usuariosPresenter'


const FacturaPDF = (props) => {
    const {
        factura
    } = props

    const {getById} = useUsuarioPresenter()

    const [vendedor, setVendedor] = useState({})
    const [comprador, setComprador] = useState({})

    useEffect (()=>{
         getById(factura.idVendedor).then(res => setComprador(res)).catch(e=>console.log(e))
         getById(factura.idComprador).then(res => setVendedor(res)).catch(e=>console.log(e))
     }, [])

  return (
    <Document>
        <Page style={styles.body} size='a4'>
          <View style={styles.headerContainer}>
            <View>
              <Text style={styles.fs10}>RetroShop - Factura</Text>
            </View>
            <View>
              <Text style={styles.fs10}>{`Fecha de compra: ${factura.fechaCompra}`}</Text>
            </View>
          </View>

          <View style={{paddingTop:"16px"}}>
            <Text style={styles.fs12}>Comprador:</Text>

            <Text style={styles.fs12}>Vendedor:</Text>
          </View>

          <View style={{paddingVertical:"16px"}}>
            <Text style={styles.fs12}>Detalle de factura:</Text>
          </View>

          <View style={styles.encabezadoContainer}>
            <View style={styles.nombre}>
              <Text style={styles.fs12}>Nombre</Text>
            </View>
            <View style={styles.precio}>
              <Text style={styles.fs12}>Precio</Text>
            </View>
            <View style={styles.precio}>
              <Text style={styles.fs12}>Cantidad</Text>
            </View>
            <View style={styles.precio}>
              <Text style={styles.fs12}>Subtotal</Text>
            </View>
          </View>

          {
            factura.productos.map((prod)=>{
              return(
                <View style={styles.itemFacturaContainer}>
                  <View style={styles.nombre}>
                    <Text style={styles.fs10}>{`- ${prod.nombre}`}</Text>
                  </View>
                  <View style={styles.precio}>
                    <Text style={styles.fs10}>{`$ ${prod.precio}`}</Text>
                  </View>
                  <View style={styles.precio}>
                    <Text style={styles.fs10}>{prod.cantidad}</Text>
                  </View>
                  <View style={styles.precio}>
                    <Text style={styles.fs10}>{prod.cantidad*prod.precio}</Text>
                  </View>
                </View>
              )
            })
          }
          <View style={styles.totalContainer}>
            <Text style={styles.fs12}>{`TOTAL: $ ${factura.totalFacturado}`}</Text>
          </View>

          
        </Page>
    </Document>
  )
}

export default FacturaPDF

const styles = StyleSheet.create({
  body:{
    padding:30
  },
  headerContainer:{
    flexDirection:'row',
    justifyContent:"space-between"
  },
  fs10:{
    fontSize:10
  },
  fs12:{
    fontSize:12
  },
  itemFacturaContainer:{
    flexDirection: "row",
    paddingTop: "8px"
  },
  encabezadoContainer:{
    flexDirection:"row",
    borderBottom: "1px solid #ddd"
  },
  nombre:{
    flexDirection: "row",
    width:"40%",
    justifyContent:"flex-start"
  },
  precio:{
    flexDirection: "row",
    width:"20%",
    justifyContent:"flex-start"
  },
  totalContainer:{
    flexDirection:"row",
    justifyContent: "flex-end",
    padding:"32px",
    
  },
  total:{
    fontSize:"12px",
    borderBottom: "1px solid #ddd"
  }

})