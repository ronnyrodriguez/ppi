/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funciones;

import accesodatos.AccesoDatos;
import accesodatos.ConjuntoResultado;
import accesodatos.Parametro;
import entidades.clsProducto;
import java.util.ArrayList;

/**
 *
 * @author Lis
 */
public class crudProducto {
//    public static boolean  save(clsClientes cliente){
//        boolean resultado = false;
//        String sql="INSERT INTO public.cliente(nombres,direccion, telefono, email, ruc) VALUES(?,?,?,?,?)";
//        
    public static boolean save(clsProducto producto){
        boolean resultado =false;
        String sql="INSERT INTO public.producto(di_producto,nombre, stock, precioventa) VALUES(?,?,?,?)";
        ArrayList<Parametro> lstPar= new ArrayList();
        lstPar.add(new Parametro(1,producto.getId_producto()));
        lstPar.add(new Parametro(2, producto.getNombre()));
        lstPar.add(new Parametro(3, producto.getStock()));
        lstPar.add(new Parametro(4, producto.getPrecioventa()));
       
        try{
            resultado= AccesoDatos.ejecutaComando(sql, lstPar);
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
        return resultado;
        
    }
    
    public static boolean delete(clsProducto producto) {
        boolean res=false;
        String sql = "DELETE FROM public.producto WHERE di_producto=?";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1,producto.getId_producto()));
        try {
            res= AccesoDatos.ejecutaComando(sql, lstPar);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        return res;
    }
    
    public static boolean update(clsProducto miproducto) {
        boolean res = false;
        String sql = "UPDATE public.producto " +
                "SET nombre=?, stock=?,precioventa=? " + 
                "WHERE di_producto=?";
        ArrayList<Parametro> lstPar = new ArrayList<>();        
        lstPar.add(new Parametro(1, miproducto.getNombre()));
        lstPar.add(new Parametro(2, miproducto.getStock()));
        lstPar.add(new Parametro(3, miproducto.getPrecioventa()));
        lstPar.add(new Parametro(4, miproducto.getId_producto()));
        
        try{
            res= AccesoDatos.ejecutaComando(sql, lstPar);
        }catch (Exception e) {
            System.out.println(e.getMessage());
            }
        return res;
    }
    
    public static ArrayList<clsProducto> findbyAll() {
        ArrayList<clsProducto> listado = new ArrayList<>();
        String sql = "SELECT di_producto, nombre, stock,precioventa "+
                "FROM public.producto";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql, lstPar);
            clsProducto miproducto = null;
            while (cres.next())
            {
            miproducto= new clsProducto();
            miproducto.setId_producto(cres.getInt("di_producto"));
            miproducto.setNombre(cres.getString("nombre"));
            miproducto.setStock(cres.getInt("stock"));
            miproducto.setPrecioventa(cres.getDouble("precioventa"));
            listado.add((miproducto));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listado;
    }
     public clsProducto findbyId(clsProducto pro) {
        clsProducto miproducto = null;
        String sql = "SELECT di_producto, nombre, stock, precioventa "+
                "FROM public.producto WHERE di_producto=?";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, pro.getId_producto()));
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql, lstPar);
            while (cres.next()) {
             miproducto= new clsProducto();
            miproducto.setId_producto(cres.getInt("id"));
            miproducto.setNombre(cres.getString("nombres"));
            miproducto.setStock(cres.getInt("stock"));
            miproducto.setPrecioventa(cres.getDouble("precioventa"));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return miproducto;
    }
     
     public static clsProducto findbyId(int pro) {
        clsProducto miproducto = null;
        String sql = "SELECT di_producto, nombre, stock,precioventa "+
                "FROM public.producto WHERE di_producto=?";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, pro));
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql, lstPar);
            while (cres.next()) {
             miproducto= new clsProducto();
            miproducto.setId_producto(cres.getInt("id"));
            miproducto.setNombre(cres.getString("nombres"));
            miproducto.setStock(cres.getInt("stock"));
            miproducto.setPrecioventa(cres.getDouble("precioventa"));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return miproducto;
    }
     
     public static ArrayList<clsProducto> findbyStck(int stock) {
        ArrayList<clsProducto> listado = new ArrayList<>();
        String sql = "SELECT di_producto, nombre, stock,precioventa "+
                "FROM public.producto WHERE stock<?";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        lstPar.add(1,new Parametro(1, stock));
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql, lstPar);
            clsProducto miproducto = null;
            while (cres.next())
            {
            miproducto= new clsProducto();
            miproducto.setId_producto(cres.getInt("id"));
            miproducto.setNombre(cres.getString("nombres"));
            miproducto.setStock(cres.getInt("stock"));
            miproducto.setPrecioventa(cres.getDouble("precioventa"));
            listado.add((miproducto));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listado;
    }
}
