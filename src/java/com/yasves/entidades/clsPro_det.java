
package com.yasves.entidades;

import java.sql.Date;


public class clsPro_det {
    private Integer _id;
    private double _marca_agua;
    private Date _fecha;
    private clsSector sector_id;
    private double promedio;

    public clsPro_det() {
    }

    public clsPro_det(Integer _id, double _marca_agua, Date _fecha, clsSector sector_id) {
        this._id = _id;
        this._marca_agua = _marca_agua;
        this._fecha = _fecha;
        this.sector_id = sector_id;
    }

    public Integer getId() {
        return _id;
    }

    public void setId(Integer _id) {
        this._id = _id;
    }

    public double getMarca_agua() {
        return _marca_agua;
    }

    public void setMarca_agua(double _marca_agua) {
        this._marca_agua = _marca_agua;
    }

    public Date getFecha() {
        return _fecha;
    }

    public void setFecha(Date _fecha) {
        this._fecha = _fecha;
    }

    public clsSector getSector_id() {
        return sector_id;
    }

    public void setSector_id(clsSector sector_id) {
        this.sector_id = sector_id;
    }

    public double getPromedio() {
        return promedio;
    }

    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }
    
}

