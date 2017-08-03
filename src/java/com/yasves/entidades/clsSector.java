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
public class clsSector {
    private int _id;
    private String _codigo_sector;
    private double _distancia;
    private String _observacion;
    private clsLugar lugar_id;

    public clsSector() {
    }

    public clsSector(int _id, String _codigo_sector, double _distancia, String _observacion, clsLugar lugar_id) {
        this._id = _id;
        this._codigo_sector = _codigo_sector;
        this._distancia = _distancia;
        this._observacion = _observacion;
        this.lugar_id = lugar_id;
    }

    public int getId() {
        return _id;
    }

    public void setId(int _id) {
        this._id = _id;
    }

    public String getCodigo_sector() {
        return _codigo_sector;
    }

    public void setCodigo_sector(String _codigo_sector) {
        this._codigo_sector = _codigo_sector;
    }

    public double getDistancia() {
        return _distancia;
    }

    public void setDistancia(double _distancia) {
        this._distancia = _distancia;
    }

    public String getObservacion() {
        return _observacion;
    }

    public void setObservacion(String _observacion) {
        this._observacion = _observacion;
    }

    public clsLugar getLugar_id() {
        return lugar_id;
    }

    public void setLugar_id(clsLugar lugar_id) {
        this.lugar_id = lugar_id;
    }

   
    
    
}
