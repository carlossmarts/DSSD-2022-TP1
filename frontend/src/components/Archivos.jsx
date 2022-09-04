import React, { Fragment, useState } from "react";
import Grid from "@material-ui/core/Grid";
import { grey, blue } from "@material-ui/core/colors";
import AddCircleOutlineIcon from '@mui/icons-material';
import DeleteIcon from '@mui/icons-material';
import SubjectIcon from '@mui/icons-material';
import { Button } from "@material-ui/core";
import { convertBase64 } from "./UtilsMethods";
import AlertDialog  from '../../basics/AlertDialog'

import {
    Dialog,
    DialogTitle,
    DialogActions,
    DialogContent,
    DialogContentText,
    Typography,
    IconButton
} from '@material-ui/core'




/************************************************
 * Componente principal
 ***********************************************/
const Archivos = (props) => {

    const { 
        form, 
        setForm
    } = props

    const [input, setInput] = useState();
    const [openModalAdjunto, setOpenModalAdjunto] = useState(false);
    const [confirModal, setConfirModal] = useState({
        open: false
    });
    const [alertModal, setAlertModal] = useState(false)


    const changeFileHandler = async (event) => {
        setInput(event.target);
        for (let i = 0; i < event.target.files.length; i++) {
            if (event.target.files[i].size > 5242880) {
                window.alert(
                    "Advertencia: No se pudo cargar el archivo. El mismo no debe superar los 5 MB "
                );
                return;
            }
        }
        const formTemp = { ...form };
        const filesTemp = [...formTemp.archivos];
        for (let i = 0; i < event.target.files.length; i++) {
            const file_bytes = await convertBase64(event.target.files[i]);
            filesTemp.push({
                nombre: event.target.files[i].name,
                file: file_bytes,
            });
        }
        if(filesTemp.length >3){
            setAlertModal(true)
        } else{
            formTemp.archivos = filesTemp;
            setForm(formTemp);
        }
    };
    const fileName = () => {
        let retorno = ""
        if (form.archivos.length === 1) {
            const name = form.archivos[0].nombre;
            let result = "";
            if (name.length > 12) {
                result = name.slice(0, 12) + "...";
            } else {
                result = name;
            }
            retorno = result;
        } else if (form.archivos.length > 1){
            retorno = form.archivos.length + " Archivos";
        } 

        return retorno
    };

    const DeleteFile = () => {
        const formTemp = { ...form };
        const filesTemp = [];
        formTemp.archivos = filesTemp;
        onCloseConfirmModal();
        setForm(formTemp);
        input.value = "";
    };

    const onCloseConfirmModal = () => {
        const tempModal = { ...confirModal };
        tempModal.open = false;
        setConfirModal(tempModal);
    };

    const OpenDeleteFile = () => {
        const tempModal = { ...confirModal };
        tempModal.open = true;
        tempModal.onAcceptClick = DeleteFile;
        tempModal.onCancelClick = onCloseConfirmModal;
        tempModal.onClose = onCloseConfirmModal;
        setConfirModal(tempModal);
    };

    const OpenFiles = () => {
        openModalListaAdjunto();
    };

    const DeleteOrFile = () => {
        let retorno = null;
        if (form.archivos.length === 0){
            retorno = (<Typography variant="body2" style={{color: "#0097D0", fontWeight:"bold"}}>
                        ADJUNTAR ARCHIVOS
                    </Typography>)
        }
        if (form.archivos.length === 1)
            retorno = (
                <IconButton onClick={OpenDeleteFile}>
                    <DeleteIcon
                        style={{
                            fontSize: 20,
                            color: grey[700],
                        }}
                    />
                </IconButton>
            );
        if (form.archivos.length > 1)
            retorno = (
                <IconButton onClick={OpenFiles}>
                    <SubjectIcon
                        style={{
                            fontSize: 24,
                            color: blue[700],
                        }}
                    />
                </IconButton>
            );
        return retorno;
    };

    const openModalListaAdjunto = () => {
        setOpenModalAdjunto(true);
    };
    const closeModalListaAdjunto = () => {
        setOpenModalAdjunto(false);
    };

    return (
        <Fragment>

            <Dialog open={confirModal.open} onClose={confirModal.onClose} >
              <DialogContent>
                <DialogContentText>
                  ¿Desea eliminar el archivo?
                </DialogContentText>
              </DialogContent>
              <DialogActions style = {{display:"flex", justifyContent:"center"}}>
                <Button size="small" variant="outlined" onClick={confirModal.onAcceptClick} contenido="Aceptar" />
                <Button size="small" variant="outlined" onClick={confirModal.onCancelClick} contenido="Cancelar" />
              </DialogActions>
            </Dialog>

            <AlertDialog
                open={alertModal}
                handleClose={()=>{setAlertModal(false)}}
                alertSeverity={"warning"}
                alertMsg={"La cantidad máxima permitida de archivos es 3"}
            />

            <ModalListadoAdjuntos
                open={openModalAdjunto}
                close={closeModalListaAdjunto}
                archivos={form.archivos}
                formulario={form}
                setFormulario={setForm}
            />

            <Grid container alignItems="center">
                <Grid item >
                    <div >
                        {form.archivos.length < 4 ? (
                            <label className="custom-file-upload">
                                <AddCircleOutlineIcon
                                    style={{
                                        marginRight: "10px",
                                        fontSize: 20,
                                        color: blue[700],
                                    }}
                                />
                                <input
                                    id={"archivos"}
                                    onChange={changeFileHandler}
                                    type="file"
                                    multiple
                                    disabled={form.estado !== "Completo"}
                                />
                            </label>
                        ) : null}
                    </div>
                </Grid>
                <Grid item >
                    <b>{fileName()}</b>
                </Grid>
                <Grid item>
                    {DeleteOrFile()}
                </Grid>
            </Grid>
        </Fragment>
    );
};

export default Archivos;



/******************************************
 * Modal
 ******************************************/

const ModalListadoAdjuntos = (props) => {

    const {
        open,
        close,
        archivos,
        formulario,
        setFormulario
    } = props

    return (
        <>
            <Dialog open={open} onClose={close} fullWidth maxWidth="xs">
              <DialogTitle >
                Listado de archivos adjuntos
              </DialogTitle>
              <DialogContent>
                <DialogContentText>
                    {
                        archivos?
                        archivos.map((archivo)=>{
                            return <ItemListaArchivos
                                    key={archivo.nombre}
                                    item={archivo}
                                    formulario={formulario}
                                    setFormulario={setFormulario}
                                />
                        })
                        :
                        <></>
                    }
                </DialogContentText>
              </DialogContent>
              <DialogActions style={{display:"flex", justifyContent:"center"}}>
                <Button
                    variant="contained"
                    onClick={close}
                    contenido="Cerrar ventana"
                />
              </DialogActions>
            </Dialog>
        </>
    )
}


/******************************************
 * Item lista
 ******************************************/

const ItemListaArchivos = (props)=>{
    const {
        item,
        formulario,
        setFormulario
    } = props

    const [open, setOpen] = useState(false)

    const cerrar = ()=>{
        setOpen(false)
    }

    const eliminar = ()=>{
        const formTemp = { ...formulario };
        const filesTemp = [...formTemp.archivos].filter(f => f.nombre !== item.nombre);
        formTemp.archivos = filesTemp;
        setFormulario(formTemp);
        setOpen(false);
    }

    const abreviarNombre = (nombreArchivo) => {
        let nombre;
        if (nombreArchivo.length > 40) {
          nombre = nombreArchivo.slice(0, 40).concat("...");
        } else nombre = nombreArchivo;
        return nombre
      };

    

    return (
        <>
            <Grid container alignItems="center" >
               <Grid item xs={10} justifyContent="flex-start">
                    <Typography variant="body1" >{abreviarNombre(item.nombre)}</Typography>       
               </Grid>
               <Grid item xs={2} justifyContent="flex-end">
                    <IconButton onClick={()=>{setOpen(true)}}>
                        <DeleteIcon
                            style={{
                                position: "absolute",
                                marginTop: "-4px",
                                marginLeft: "5px",
                                fontSize: 20,
                                color: grey[700],
                            }}
                        />
                    </IconButton>
                 
               </Grid>

               <Dialog open={open} onClose={()=>{setOpen(false)}}>
                 <DialogContent>
                     {
                        formulario.estado === "Completo" ?
                            "Eliminar archivo?"
                        : 
                            "No se puede eliminar archivo"

                     }
                 </DialogContent>
                 <DialogActions style={{display:"flex", justifyContent:"center"}}>
                     {
                        formulario.estado === "Completo" ?
                            <Button
                                size="small"
                                variant="contained"
                                contenido="Aceptar"
                                onClick={eliminar}
                            />
                        :
                            null
                     }
                    <Button
                        size="small"
                        variant="contained"
                        contenido={formulario.estado === "Completo"? "Cancelar" : "Cerrar"}
                        onClick={cerrar}
                    />
                 </DialogActions>
               </Dialog>
            </Grid>
        </>
    )
}