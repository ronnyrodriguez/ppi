/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yasves.entidades;

/**
 *
 * @author Rocby
 */
public class clsLugar {
    private int _id;
    private String _nombre;
    private String _observacion;

    public clsLugar() {
    }

    public clsLugar(int _id, String _nombre, String _observacion) {
        this._id = _id;
        this._nombre = _nombre;
        this._observacion = _observacion;
    }

    public int getId() {
        return _id;
    }

    public void setId(int _id) {
        this._id = _id;
    }

    public String getNombre() {
        return _nombre;
    }

    public void setNombre(String _nombre) {
        this._nombre = _nombre;
    }

    public String getObservacion() {
        return _observacion;
    }

    public void setObservacion(String _observacion) {
        this._observacion = _observacion;
    }

    
}
