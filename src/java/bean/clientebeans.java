/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entidades.clsCliente;
import funciones.crudCliente;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Lis
 */
@ManagedBean
@ViewScoped
public class clientebeans {

    private clsCliente newCliente;
    private clsCliente selectedCliente;
    private List<clsCliente> lista;
    
    public clientebeans() {
        newCliente = new clsCliente();
        cargarDatos();
    }
    
    private void cargarDatos() {
        lista=crudCliente.findbyAll();
    }
    public void insertar(){
        if (crudCliente.save(newCliente)) { //linea guarda el cliente 
           newCliente = new clsCliente();//prepara el constructor posible nuevo cliente 
           cargarDatos(); //refresca el datagrid con los nuevos cambios
           //TODO:mostrar mensaje de guardar 
        }else{
        //TODO:mostrar mensaje de no guardardo 
        }
    }
    public void eliminar(){
        if (crudCliente.delete(selectedCliente)) {
            newCliente = new clsCliente();//prepara el constructor posible nuevo cliente 
           cargarDatos(); //refresca el datagrid con los nuevos cambios
           //TODO:mostrar mensaje deeliminar 
        }else{
        //TODO:mostrar mensaje de no eliminado
        }
    }
    public void actualizar(){
        if (crudCliente.update(selectedCliente)) {
            newCliente = new clsCliente();//prepara el constructor posible nuevo cliente 
           cargarDatos(); //refresca el datagrid con los nuevos cambios
           //TODO:mostrar mensaje de actualizar
        }else{
        //TODO:mostrar mensaje de no actualizar
        }
    }
    public clsCliente getNewCliente() {
        return newCliente;
    }

    public void setNewCliente(clsCliente newCliente) {
        this.newCliente = newCliente;
    }

    public clsCliente getSelectedCliente() {
        return selectedCliente;
    }

    public void setSelectedCliente(clsCliente selectedCliente) {
        this.selectedCliente = selectedCliente;
    }

    public List<clsCliente> getLista() {
        return lista;
    }

    public void setLista(List<clsCliente> lista) {
        this.lista = lista;
    }
    
}
