/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author Lis
 */
public class clsCliente {
    private int id_cliente;
    private String _ruc;
    private String _nombre;
    private String _direccion;

    public clsCliente(int id_cliente, String _ruc, String _nombre, String _direccion) {
        this.id_cliente = id_cliente;
        this._ruc = _ruc;
        this._nombre = _nombre;
        this._direccion = _direccion;
    }

    public clsCliente() {
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getRuc() {
        return _ruc;
    }

    public void setRuc(String _ruc) {
        this._ruc = _ruc;
    }

    public String getNombre() {
        return _nombre;
    }

    public void setNombre(String _nombre) {
        this._nombre = _nombre;
    }

    public String getDireccion() {
        return _direccion;
    }

    public void setDireccion(String _direccion) {
        this._direccion = _direccion;
    }

    @Override
    public String toString() {
        return "clsCliente{" + "id_cliente=" + id_cliente + ", _ruc=" + _ruc + ", _nombre=" + _nombre + ", _direccion=" + _direccion + '}';
    }

}
