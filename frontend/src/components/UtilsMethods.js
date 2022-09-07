// import Resizer from "react-image-file-resizer";
import imageCompression from "browser-image-compression";
import React from "react";

export function getCurrentDate(separator = "/") {
  let newDate = new Date();
  let date = newDate.getDate();
  let month = newDate.getMonth() + 1;
  let year = newDate.getFullYear();

  return `${year}${separator}${month < 10 ? `0${month}` : `${month}`}${separator}${date < 10 ? `0${date}` : `${date}`}`;
}


//Funciones para carga de archivos
export const convertBase64 = async (archivo) => {
  if (archivo.type.includes("image")) {
    return new Promise(async (resolve, reject) => {
      const options = {
        maxSizeMB: 1,
        maxWidthOrHeight: 1920,
        useWebWorker: true,
        initialQuality: 0.8,
      };
      try {
        const compressedFile = await imageCompression(archivo, options);
      } catch (error) {
        reject(error);
        console.log(error);
      }
    });
  } else {
    return new Promise((resolve, reject) => {
      convert(archivo, resolve, reject);
    });
  }
};

const convert = (file, resolve, reject) => {
  let arrayAuxiliar = [];
  let reader = new FileReader();
  reader.readAsDataURL(file);
  reader.onload = function () {
    let base_64 = reader.result;
    arrayAuxiliar = base_64.split(",");
    resolve(arrayAuxiliar[1]);
  };
  reader.onerror = (error) => {
    reject(error);
  };
};


//FUNCIONES PARA MANEJO DE TEXTO
export const capitalizeName = (sName, name)=>{
  let apellido = sName.split(" ").map(s=>capitalize(s)).join(" ") 
  let nombre = name !== ""? name.split(" ").map(s=>capitalize(s)).join(" ") : ""
  return `${apellido}, ${nombre}`
}

export const capitalize = (str)=>{
  return `${str[0].toUpperCase()}${str.slice(1).toLowerCase()}`
}


