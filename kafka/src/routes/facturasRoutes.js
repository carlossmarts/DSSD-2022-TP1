//modulos
const express = require('express');
const path = require('path');
const facturasCallback = require('../callbacks/facturasCallback')

//inicializacion
const router = express();

//rutas
router.post('/api/facturacion/generarFactura',facturasCallback.save)
router.post('/api/facturas/get', facturasCallback.getAll)

module.exports = router