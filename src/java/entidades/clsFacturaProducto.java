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
public class clsFacturaProducto {
    private int _idfacturaproducto;
    private clsFactura factura;
    private clsProducto producto;
    private int _cantidad;
    private double subtotal;

    public clsFacturaProducto() {
    }

    public clsFacturaProducto(int _idfacturaproducto, clsFactura factura, clsProducto producto, int _cantidad, double subtotal) {
        this._idfacturaproducto = _idfacturaproducto;
        this.factura = factura;
        this.producto = producto;
        this._cantidad = _cantidad;
        this.subtotal = subtotal;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public int getIdfacturaproducto() {
        return _idfacturaproducto;
    }

    public void setIdfacturaproducto(int _idfacturaproducto) {
        this._idfacturaproducto = _idfacturaproducto;
    }

    public clsFactura getFactura() {
        return factura;
    }

    public void setFactura(clsFactura factura) {
        this.factura = factura;
    }

    public clsProducto getProducto() {
        return producto;
    }

    public void setProducto(clsProducto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return _cantidad;
    }

    public void setCantidad(int _cantidad) {
        this._cantidad = _cantidad;
    }

    @Override
    public String toString() {
        return "clsFacturaProducto{" + "_idfacturaproducto=" + _idfacturaproducto + ", factura=" + factura + ", producto=" + producto + ", _cantidad=" + _cantidad + ", subtotal=" + subtotal + '}';
    }
    
}
