/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import com.sun.org.apache.bcel.internal.generic.NEW;
import entidades.clsProducto;
import funciones.crudProducto;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;


/**
 *
 * @author Lis
 */
@ManagedBean
@ViewScoped
public class productobeans {

    private clsProducto newProducto;
    private clsProducto selectedProducto;
    private List<clsProducto> lista;

    public productobeans() {
        newProducto = new clsProducto();
        cargarDatos();
    }

    private void cargarDatos() {
        lista=crudProducto.findbyAll();
    }
    public void insertar(){
        if (crudProducto.save(newProducto)) { //linea guarda el cliente 
           newProducto = new clsProducto();//prepara el constructor posible nuevo cliente 
           cargarDatos(); //refresca el datagrid con los nuevos cambios
           //TODO:mostrar mensaje de guardar 
        }else{
        //TODO:mostrar mensaje de no guardardo 
        }
    }
    public void eliminar(){
        if (crudProducto.delete(selectedProducto)) {
            newProducto = new clsProducto();//prepara el constructor posible nuevo cliente 
           cargarDatos(); //refresca el datagrid con los nuevos cambios
           //TODO:mostrar mensaje deeliminar 
        }else{
        //TODO:mostrar mensaje de no eliminado
        }
    }
    public void actualizar(){
        if (crudProducto.update(selectedProducto)) {
            newProducto = new clsProducto();//prepara el constructor posible nuevo cliente 
           cargarDatos(); //refresca el datagrid con los nuevos cambios
           //TODO:mostrar mensaje de actualizar
        }else{
        //TODO:mostrar mensaje de no actualizar
        }
    }

    public clsProducto getNewProducto() {
        return newProducto;
    }

    public void setNewProducto(clsProducto newProducto) {
        this.newProducto = newProducto;
    }

    public clsProducto getSelectedProducto() {
        return selectedProducto;
    }

    public void setSelectedProducto(clsProducto selectedProducto) {
        this.selectedProducto = selectedProducto;
    }

    public List<clsProducto> getLista() {
        return lista;
    }

    public void setLista(List<clsProducto> lista) {
        this.lista = lista;
    }

}
