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
public class clsSensor {
    private int _id;
    private String _tipo;
    private String _observaciones;
    private clsSector _sector_id;
    private String _estado;

    public clsSensor() {
    }

    public clsSensor(int _id, String _tipo, String _observaciones, clsSector _sector_id, String _estado) {
        this._id = _id;
        this._tipo = _tipo;
        this._observaciones = _observaciones;
        this._sector_id = _sector_id;
        this._estado = _estado;
    }

    public int getId() {
        return _id;
    }

    public void setId(int _id) {
        this._id = _id;
    }

    public String getTipo() {
        return _tipo;
    }

    public void setTipo(String _tipo) {
        this._tipo = _tipo;
    }

    public String getObservaciones() {
        return _observaciones;
    }

    public void setObservaciones(String _observaciones) {
        this._observaciones = _observaciones;
    }

    public clsSector getSector_id() {
        return _sector_id;
    }

    public void setSector_id(clsSector _sector_id) {
        this._sector_id = _sector_id;
    }

    public String getEstado() {
        return _estado;
    }

    public void setEstado(String _estado) {
        this._estado = _estado;
    }
   
}
