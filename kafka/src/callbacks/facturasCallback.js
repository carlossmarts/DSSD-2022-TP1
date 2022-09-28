const producer = require("../kafka/producer");
const { serverError } = require("./utils");
const facturasController = require('../controllers/facturasController')
const callback = {};

callback.save = (req, res) => {
  try {
    const response = producer.guardarMensaje(req.body, "facturas");
    const saveFactura = facturasController.save(req);
    res.json(response);
  } catch (error) {
    console.error("FacturasCallbak Save: " + error.message);
    res.json(serverError(error))
  }
};

callback.getAll = ((req, res) => {
  try {
    facturasController.getByComprador(req, res)
  } catch (error) {
    console.error("FacturasCallbak getByComprador: " + error.message);
    res.json(serverError(error))
  }
})

module.exports = callback;
