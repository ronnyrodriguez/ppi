package com.yasves.controlador;


import com.yasves.entidades.clsPro_det;
import com.yasves.funciones.crudPro_det;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;

@ManagedBean
@ViewScoped
public class cPro_det {
    private List<clsPro_det> lista;
    private clsPro_det newAt;
    private clsPro_det selectedAt;
   
    public cPro_det() {
        newAt = new clsPro_det();
        cargarDatos();        
    }

    private void insertar(){
        if (crudPro_det.save(newAt)) { //linea guarda el cliente 
           newAt = new clsPro_det();//prepara el constructor posible nuevo cliente 
           cargarDatos(); //refresca el datagrid con los nuevos cambios
           //TODO:mostrar mensaje de guardar 
        }else{
        //TODO:mostrar mensaje de no guardardo 
        }
    }
    private void eliminar(){
        if (crudPro_det.delete(selectedAt)) {
            newAt = new clsPro_det();//prepara el constructor posible nuevo cliente 
           cargarDatos(); //refresca el datagrid con los nuevos cambios
           //TODO:mostrar mensaje deeliminar 
        }else{
        //TODO:mostrar mensaje de no eliminado
        }
    }
    public void actualizar(){
        if (crudPro_det.update(selectedAt)) {
            newAt = new clsPro_det();//prepara el constructor posible nuevo cliente 
           cargarDatos(); //refresca el datagrid con los nuevos cambios
           //TODO:mostrar mensaje de actualizar
        }else{
        //TODO:mostrar mensaje de no actualizar
        }
    }
    
    private void cargarDatos() {
        lista= crudPro_det.findbyAll();
    }

    public List<clsPro_det> getLista() {
        return lista;
    }

    public void setLista(List<clsPro_det> lista) {
        this.lista = lista;
    }

    public clsPro_det getNewAt() {
        return newAt;
    }

    public void setNewAt(clsPro_det newAt) {
        this.newAt = newAt;
    }

    public clsPro_det getSelectedAt() {
        return selectedAt;
    }

    public void setSelectedAt(clsPro_det selectedAt) {
        this.selectedAt = selectedAt;
    }

    
    
}
