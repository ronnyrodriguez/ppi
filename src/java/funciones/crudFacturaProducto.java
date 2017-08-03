/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funciones;

import accesodatos.AccesoDatos;
import accesodatos.ConjuntoResultado;
import accesodatos.Parametro;
import entidades.clsFacturaProducto;
import java.util.ArrayList;

/**
 *
 * @author Lis
 */
public class crudFacturaProducto {
    public static boolean  save(clsFacturaProducto defa){
        boolean resultado = false;
        String sql="INSERT INTO public.dfacturaproducto(id_facturaproducto,numero_factura,di_producto, cantidad, subtotal) VALUES(?,?,?,?,?)";
        ArrayList<Parametro> lstPar= new ArrayList();
        lstPar.add(new Parametro(1,defa.getIdfacturaproducto()));
        lstPar.add(new Parametro(2, defa.getFactura().getNumero_factura()));
        lstPar.add(new Parametro(3, defa.getProducto().getId_producto()));
        lstPar.add(new Parametro(4, defa.getCantidad()));
        lstPar.add(new Parametro(5, defa.getSubtotal()));
      
        try{
            resultado= AccesoDatos.ejecutaComando(sql, lstPar);
        } catch(Exception e){
            System.out.println("Error: "+ e.getMessage());
        }
        return resultado;
        
    }
    public boolean delete(clsFacturaProducto defa) {
        boolean res=false;
        String sql = "DELETE FROM public.dfacturaproducto WHERE id_facturaproducto=?";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1,defa.getIdfacturaproducto()));
        try {
            res= AccesoDatos.ejecutaComando(sql, lstPar);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        return res;
    }
    public boolean update(clsFacturaProducto midefa) {
        boolean res = false;
        String sql = "UPDATE public.dfacturaproducto " +
                "SET numero_factura=? ,di_producto=?, cantidad=?, subtotal=?" + 
                "WHERE id_facturaproducto=?";
        ArrayList<Parametro> lstPar = new ArrayList<>();        
        lstPar.add(new Parametro(1,midefa.getFactura().getNumero_factura()));
        lstPar.add(new Parametro(2,midefa.getProducto().getId_producto()));
        lstPar.add(new Parametro(3,midefa.getCantidad()));
        lstPar.add(new Parametro(4,midefa.getSubtotal()));
        lstPar.add(new Parametro(5,midefa.getIdfacturaproducto()));
        try{
            res= AccesoDatos.ejecutaComando(sql, lstPar);
        }catch (Exception e) {
            System.out.println(e.getMessage());
            }
        return res;
    }
     public ArrayList<clsFacturaProducto> findbyAll() {
        ArrayList<clsFacturaProducto> listado = new ArrayList<>();
        String sql = "SELECT numero_factura,di_producto, cantidad, subtotal "+
                "FROM public.dfacturaproducto";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql, lstPar);
            clsFacturaProducto defa = null;
            while (cres.next())
            {
                defa = new clsFacturaProducto();
                defa.setIdfacturaproducto(cres.getInt("id"));
//                defa.getFactura().setNumero_factura(cres.getInt("idfactura"));
//                defa.getProducto().setId_producto(cres.getInt("idproducto"));
                defa.setCantidad(cres.getInt("cantidad"));
                defa.setSubtotal(cres.getInt("subtotal"));
                listado.add((defa));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listado;
    }
      public clsFacturaProducto findbyId(clsFacturaProducto defa) {
        clsFacturaProducto decfat = null;
        String sql = "SELECT numero_factura,di_producto, cantidad, subtotal "+
                "FROM public.dfacturaproducto WHERE id_facturaproducto=?";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, defa.getIdfacturaproducto()));
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql, lstPar);
            while (cres.next()) {
                defa = new clsFacturaProducto();
                defa.setIdfacturaproducto(cres.getInt("id"));
                defa.getFactura().setNumero_factura(cres.getInt("idfactura"));
                defa.getProducto().setId_producto(cres.getInt("idproducto"));
                defa.setCantidad(cres.getInt("cantidad"));
                defa.setSubtotal(cres.getInt("subtotal"));
              
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return defa;
    }
}
