package com.yasves.controlador;


import com.yasves.entidades.clsLugar;
import com.yasves.funciones.crudLugar;
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
public class cLugar {
    private List<clsLugar> lista;
    private clsLugar newLugar;
    private clsLugar selectedLugar;
   
    public cLugar() {
        newLugar = new clsLugar();
        cargarDatos();        
    }    

    public void insertar(){
        if (crudLugar.save(newLugar)) { //linea guarda el cliente 
           newLugar = new clsLugar();//prepara el constructor posible nuevo cliente 
           cargarDatos(); //refresca el datagrid con los nuevos cambios
           //TODO:mostrar mensaje de guardar 
        }else{
        //TODO:mostrar mensaje de no guardardo 
        }
    }
    public void eliminar(){
        if (crudLugar.delete(selectedLugar)) {
            newLugar = new clsLugar();//prepara el constructor posible nuevo cliente 
           cargarDatos(); //refresca el datagrid con los nuevos cambios
           //TODO:mostrar mensaje deeliminar 
        }else{
        //TODO:mostrar mensaje de no eliminado
        }
    }
    public void actualizar(){
        if (crudLugar.update(selectedLugar)) {
            newLugar = new clsLugar();//prepara el constructor posible nuevo cliente 
           cargarDatos(); //refresca el datagrid con los nuevos cambios
           //TODO:mostrar mensaje de actualizar
        }else{
        //TODO:mostrar mensaje de no actualizar
        }
    }
    
    private void cargarDatos() {
        lista= crudLugar.findbyAll();
    }

    public List<clsLugar> getLista() {
        return lista;
    }

    public void setLista(List<clsLugar> lista) {
        this.lista = lista;
    }

    public clsLugar getNewLugar() {
        return newLugar;
    }

    public void setNewLugar(clsLugar newLugar) {
        this.newLugar = newLugar;
    }

    public clsLugar getSelectedLugar() {
        return selectedLugar;
    }

    public void setSelectedLugar(clsLugar selectedLugar) {
        this.selectedLugar = selectedLugar;
    }

    
    
}
