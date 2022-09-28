const { serverOK, serverError } = require("../callbacks/utils");

const controller = {}

controller.save = (req) => {
    const facturaReq = {
        fechaCompra: req.body.fechaCompra,
        idComprador: req.body.idComprador,
        totalFacturado: req.body.totalFacturado
    };
    req.getConnection((err, conn) => {
        conn.query(
            "INSERT INTO facturas set ?",
            facturaReq,
            (err, facturaReq) => {
                if (err) {
                    console.error("Error insertando factura:" + err.message);
                    return conn.rollback(() => {
                        serverError(err);
                        throw err;
                    });
                }
                req.body.productos.forEach(detalle => {
                    let detalle_factura = {
                        idFactura: facturaReq.insertId,
                        idVendedor: req.body.idVendedor,
                        nombre: detalle.nombre,
                        precio: detalle.precio,
                        cantidad: detalle.cantidad
                    };
                    conn.query(
                        "INSERT INTO detalle_factura set ?",
                        detalle_factura,
                        (err, facturaReq) => {
                            if (err) {
                                console.error("Error insertando detalle_factura" + err.message);
                                return conn.rollback(() => {
                                    serverError(err);
                                    throw err;
                                });
                            }
                            return serverOK(req);
                        })
                });
            }
        )
    })
}

controller.getByComprador = (req, res) => {
    req.getConnection((err, conn) => {
        conn.query(`SELECT * from facturas f WHERE f.idComprador = ? `, [req.body.idComprador],
            (err, facturas) => {
                if (err) {
                    console.error("Error consultando factura" + err.message);
                    return;
                }
                var respFacturas = [];
                for (let factura of facturas) {
                    conn.query(`SELECT * from detalle_factura d where d.idFactura = ?`, [factura.idFactura], (err, detalle) => {
                        if (err) {
                            console.error("Error consultando factura" + err.message);
                            return;
                        }
                        respFacturas.push({ ...factura, productos: detalle })
                    });
                }
                res.json(respFacturas)
            })
    });
}

module.exports = controller