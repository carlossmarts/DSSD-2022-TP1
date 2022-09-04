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
        console.log(
          "compressedFile instanceof Blob",
          compressedFile instanceof Blob
        ); // true
        console.log(
          `compressedFile size ${compressedFile.size / 1024 / 1024} MB`
        ); // smaller than maxSizeMB
        console.log(`uncompressedFile size ${archivo.size / 1024 / 1024} MB`);
        convert(compressedFile, resolve, reject);
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

export const currencyMaskEvent = (e)=>{
  e.target.value = currencyMask(e.target.value)
  return e
}

export const currencyMask = (val) =>{
  val = val.toString()
  val = val.replace(/\D/g, "")
  if(val.length < 2 ){
    val = "0,0" + val;
  } else if(val.length < 3 ){
    val = "0," + val;
  }else{
    if(val[0]=== "0"){
      val = val.replace(/0/, "")
    }
    val = `${val.substring(0, val.length-2)},${val.substring(val.length-2, val.length)}`
  }

  val = val. replace(/(?=(\d{3})+(\D))\B/g, ".")
  val = "$ " + val;
  if (val === "$ 0,0" || val === "$ 0,00"){
    val = ""
  }
  return val
}

export const formatImporte = (num) => {
  num = num.toString()
  num = num.replace(".", ",")
  num = num. replace(/(?=(\d{3})+(\D))\B/g, ".")
  return `${num.length === 0 ? "" : "$ "} ${num}`
}

