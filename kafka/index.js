const express = require('express')
path = require('path')
mysql = require('mysql')
const consumer = require("./src/kafka/consumer");
var cors = require('cors')

myConnection = require('express-myconnection');
const productosRoutes = require ('./src/routes/productosRoutes');
const subastasRoutes = require ('./src/routes/subastasRoutes')
const facturasRoutes = require('./src/routes/facturasRoutes')
const ejemploRoutes = require('./src/routes/ejemploRoutes')
const { persist } = require('./src/callbacks/facturasCallback');

const app = express()
app.set('port', 5000)

//middlewares
app.use(express.json())
app.use(cors())

app.use(myConnection(mysql, {
	host: 'localhost',
	user: 'root',
	password: 'password',
	port: 3306,
	database: 'retroshop'
}, 'single'));

app.use(express.urlencoded({extended: false}));
const logger = (req, res, next)=>{
	console.log(`Peticion ${req.method.toUpperCase()} recibida -  ${req.protocol}://${req.get('host')}${req.originalUrl}`)
	console.log("body: ", req.body)
	next();
}


//Rutas
app.use(logger)
app.use(ejemploRoutes)
app.use(subastasRoutes)
app.use(productosRoutes)
app.use(facturasRoutes)

consumer.persistFacturas();

app.listen(app.get('port'), ()=>{
	console.log("server iniciado y escuchando en puerto ", app.get('port'))
})


