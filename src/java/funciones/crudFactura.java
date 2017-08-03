/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funciones;

import accesodatos.AccesoDatos;
import accesodatos.ConjuntoResultado;
import accesodatos.Parametro;
import entidades.clsFactura;
import java.util.ArrayList;

/**
 *
 * @author Lis
 */
public class crudFactura {
    public static boolean  save(clsFactura factura){
        boolean resultado = false;
        String sql="INSERT INTO public.factura(numero_factura,cliente_id, fecha,subtotal, total,iva ) VALUES(?,?,?,?,?,?)";
        ArrayList<Parametro> lstPar= new ArrayList();
        lstPar.add(new Parametro(1, factura.getNumero_factura()));
        lstPar.add(new Parametro(2, factura.getCliente().getId_cliente()));
        lstPar.add(new Parametro(3, factura.getFecha()));
        lstPar.add(new Parametro(4, factura.getSubtotal()));
        lstPar.add(new Parametro(5, factura.getTotal()));
        lstPar.add(new Parametro(6, factura.getIva()));
        try{
            resultado= AccesoDatos.ejecutaComando(sql, lstPar);
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
        return resultado;
        
    }
    public static boolean delete(clsFactura factura) {
        boolean res=false;
        String sql = "DELETE FROM public.factura WHERE numero_factura=?";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1,factura.getNumero_factura()));
        try {
            res= AccesoDatos.ejecutaComando(sql, lstPar);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        return res;
    }
     public static boolean update(clsFactura mifactura) {
        boolean res = false;
        String sql = "UPDATE public.factura " +
                "SET cliente_id=?,fecha=?,subtotal=?, total=?,iva=? " + 
                "WHERE numero_factura=?";
        ArrayList<Parametro> lstPar = new ArrayList<>();        
        lstPar.add(new Parametro(1,mifactura.getCliente()));
        lstPar.add(new Parametro(2,mifactura.getFecha()));
        lstPar.add(new Parametro(3,mifactura.getSubtotal()));
        lstPar.add(new Parametro(4,mifactura.getTotal()));
        lstPar.add(new Parametro(5,mifactura.getIva()));
        lstPar.add(new Parametro(6,mifactura.getNumero_factura()));
        try{
            res= AccesoDatos.ejecutaComando(sql, lstPar);
        }catch (Exception e) {
            System.out.println(e.getMessage());
            }
        return res;
    }
     public static ArrayList<clsFactura> findbyAll() {
        ArrayList<clsFactura> listado = new ArrayList<>();
        String sql = "SELECT numero_factura, cliente_id ,fecha,subtotal,total,iva "+
                "FROM public.factura";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql, lstPar);
            clsFactura factura = null;
            while (cres.next())
            {
                factura = new clsFactura();
                factura.setNumero_factura(cres.getInt("numero_factura"));
                factura.setCliente(crudCliente.findbyId(cres.getInt("cliente_id")));
                factura.setFecha(cres.getDate("fecha"));
                factura.setSubtotal(cres.getDouble("subtotal"));
                factura.setTotal(cres.getDouble("total"));
                factura.setIva(cres.getDouble("iva"));
                listado.add((factura));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listado;
    }
     public clsFactura findbyId(clsFactura fac) {
        clsFactura factura = null;
        String sql = "SELECT cliente_id,fecha,subtotal, total, iva "+
                "FROM public.factura WHERE numero_factura=?";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, fac.getNumero_factura()));
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql, lstPar);
            while (cres.next()) {
                   factura = new clsFactura();
                factura.setNumero_factura(cres.getInt("numero_factura"));
                factura.setCliente(crudCliente.findbyId(cres.getInt("cliente_id")));
                factura.setFecha(cres.getDate("fecha"));
                factura.setSubtotal(cres.getDouble("subtotal"));
                factura.setTotal(cres.getDouble("total"));
                factura.setIva(cres.getDouble("iva"));
               
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return factura;
     }
        public static clsFactura findbyId(int fact) {
        clsFactura factura = null;
        String sql = "SELECT cliente_id,fecha,subtotal, total, iva "+
                "FROM public.factura WHERE numero_factura=?";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, fact));
       try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql, lstPar);
            while (cres.next()) {
                factura = new clsFactura();
                factura.setNumero_factura(cres.getInt("id"));
                factura.setCliente(crudCliente.findbyId(cres.getInt("idCliente")));
                factura.setFecha(cres.getDate("fecha"));
                factura.setSubtotal(cres.getDouble("subtotal"));
                factura.setTotal(cres.getDouble("total"));
                factura.setIva(cres.getDouble("iva"));
               
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return factura;
    }
}

