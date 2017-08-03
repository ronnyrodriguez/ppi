/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.util.Date;

/**
 *
 * @author Lis
 */
public class clsFactura {
    private int _numero_factura;
    private clsCliente cliente;
    private Date _fecha;
    private Double subtotal;
    private Double total;
    private Double iva;

    public clsFactura() {
    }

    public clsFactura(int _numero_factura, clsCliente cliente, Date _fecha, Double subtotal, Double total, Double iva) {
        this._numero_factura = _numero_factura;
        this.cliente = cliente;
        this._fecha = _fecha;
        this.subtotal = subtotal;
        this.total = total;
        this.iva = iva;
    }

    public int getNumero_factura() {
        return _numero_factura;
    }

    public void setNumero_factura(int _numero_factura) {
        this._numero_factura = _numero_factura;
    }

    public clsCliente getCliente() {
        return cliente;
    }

    public void setCliente(clsCliente cliente) {
        this.cliente = cliente;
    }

    public Date getFecha() {
        return _fecha;
    }

    public void setFecha(Date _fecha) {
        this._fecha = _fecha;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Double getIva() {
        return iva;
    }

    public void setIva(Double iva) {
        this.iva = iva;
    }

    @Override
    public String toString() {
        return "clsFactura{" + "_numero_factura=" + _numero_factura + ", cliente=" + cliente + ", _fecha=" + _fecha + ", subtotal=" + subtotal + ", total=" + total + ", iva=" + iva + '}';
    }

   
    
}
