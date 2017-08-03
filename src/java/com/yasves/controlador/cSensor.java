package com.yasves.controlador;


import com.yasves.entidades.clsSector;
import com.yasves.entidades.clsSensor;
import com.yasves.funciones.crudSensor;
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
public class cSensor {
    private List<clsSensor> lista;
    private clsSensor newSector;
    private int newlugar;
    private int selectedlugar;
    private clsSensor selectedSector;
   
    public cSensor() {
        newSector = new clsSensor();
        cargarDatos();        
    }

    public void insertar(){
        
        clsSector l=new clsSector(newlugar, null, 0, null, null);
        clsSensor s=new clsSensor(newSector.getId(),newSector.getTipo(),newSector.getObservaciones(),l,newSector.getEstado());
       
        if (crudSensor.save(s)) { //linea guarda el cliente 
           newSector= new clsSensor();//prepara el constructor posible nuevo cliente 
           cargarDatos(); //refresca el datagrid con los nuevos cambios
           //TODO:mostrar mensaje de guardar 
        }else{
        //TODO:mostrar mensaje de no guardardo 
        }
    }
    public void eliminar(){
        
        clsSector l=new clsSector(newlugar, null, 0, null, null);
        clsSensor s=new clsSensor(newSector.getId(),newSector.getTipo(),newSector.getObservaciones(),l,newSector.getEstado());
      
        
        if (crudSensor.delete(s)) {
            newSector = new clsSensor();//prepara el constructor posible nuevo cliente 
           cargarDatos(); //refresca el datagrid con los nuevos cambios
           //TODO:mostrar mensaje deeliminar 
        }else{
        //TODO:mostrar mensaje de no eliminado
        }
    }
    public void actualizar(){
         clsSector l=new clsSector(newlugar, null, 0, null, null);
        clsSensor s=new clsSensor(newSector.getId(),newSector.getTipo(),newSector.getObservaciones(),l,newSector.getEstado());
      
        if (crudSensor.update(s)) {
            newSector = new clsSensor();//prepara el constructor posible nuevo cliente 
           cargarDatos(); //refresca el datagrid con los nuevos cambios
           //TODO:mostrar mensaje de actualizar
        }else{
        //TODO:mostrar mensaje de no actualizar
        }
    }
    
    private void cargarDatos() {
        lista= crudSensor.findbyAll();
    }

    public List<clsSensor> getLista() {
        return lista;
    }

    public void setLista(List<clsSensor> lista) {
        this.lista = lista;
    }

    public clsSensor getNewSector() {
        return newSector;
    }

    public void setNewSector(clsSensor newSector) {
        this.newSector = newSector;
    }

    public int getNewlugar() {
        return newlugar;
    }

    public void setNewlugar(int newlugar) {
        this.newlugar = newlugar;
    }

    public int getSelectedlugar() {
        return selectedlugar;
    }

    public void setSelectedlugar(int selectedlugar) {
        this.selectedlugar = selectedlugar;
    }

    public clsSensor getSelectedSector() {
        return selectedSector;
    }

    public void setSelectedSector(clsSensor selectedSector) {
        this.selectedSector = selectedSector;
    }

    
    
}
