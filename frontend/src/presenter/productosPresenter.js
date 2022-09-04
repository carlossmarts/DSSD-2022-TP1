import { useState } from "react"
import { ProductosApi } from "../services/productosAPI"
import img from '../IMG.jpg';

const prodList = [{
    nombre: 'Cassette',
    precio: 20.44,
    descripcion: 'Esta es una descripcion para cassettes!',
    img: [img]
}, {
    nombre: 'Video Grabadora',
    precio: 20.44,
    descripcion: 'Esta es una descripcion para Videograbadoras!',
    img: [img, img, img]
}, {
    nombre: 'Walkman',
    precio: 20.44,
    descripcion: 'Esta es una descripcion para walkmans!',
    img: [img]
}, {
    nombre: 'Nokia 1100',
    precio: 20.44,
    descripcion: 'Esta es una descripcion para el celular Nokia 1100!',
    img: [img, img]
}
]

const misProds = [{
    nombre: 'Mis productos',
    precio: 20.44,
    descripcion: 'Aca aparecen los productos que subi, se pueden editar',
    img: [img, img]
}
]

const misProdsComprados = [{
    nombre: 'Mis Compras',
    precio: 20.44,
    descripcion: 'Aca aparecen los productos que compre',
    img: [img, img]
}
]

export const useProductosPresenter = () => {

    const [productos, setProductos] = useState()

    const traerProductos = async () => {
        // const res = await ProductosApi.traerProductos()
        // return res;
        return prodList
    }

    const traerProductosComprados = async (idUsuario) => {
        // const res = await ProductosApi.traerProductosComprados(idUsuario);
        // return res;
        return misProdsComprados.concat(prodList)
    }

    const traerMisProductos = async (idUsuario) => {
        // const res = await ProductosApi.traerProductosComprados(idUsuario);
        // return res;
        return misProds.concat(prodList)
    }

    const crearProductos = async (body) => {
        // const res = await ProductosApi.crearProductos(body);
        // return res;       
        return 201
    }

    const editarProducto = async (body) => {
        // const res = await ProductosApi.editarProducto(body);
        // return res;
        return 200
    }

    return {
        productos,
        setProductos,
        traerProductos,
        traerProductosComprados,
        traerMisProductos,
        crearProductos,
        editarProducto
    }
}