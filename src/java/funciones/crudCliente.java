/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funciones;

import entidades.clsCliente;
import accesodatos.AccesoDatos;
import accesodatos.ConjuntoResultado;
import accesodatos.Parametro;
import java.util.ArrayList;


public class crudCliente {
    public static boolean  save(clsCliente cliente){
        boolean resultado = false;
        String sql="INSERT INTO public.cliente(id_cliente,ruc,nombre,direccion) VALUES(?,?,?,?)";
        ArrayList<Parametro> lstPar= new ArrayList();
        lstPar.add(new Parametro(1, cliente.getId_cliente()));
        lstPar.add(new Parametro(2, cliente.getRuc()));
        lstPar.add(new Parametro(3, cliente.getNombre()));
        lstPar.add(new Parametro(4, cliente.getDireccion()));
        try{
            resultado= AccesoDatos.ejecutaComando(sql, lstPar);
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
        return resultado;
    }
    
    public static boolean delete(clsCliente cliente) {
        boolean res=false;
        String sql = "DELETE FROM public.cliente WHERE id_cliente=?";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1,cliente.getId_cliente()));
        try {
            res= AccesoDatos.ejecutaComando(sql, lstPar);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        return res;
    }
    
    public boolean delete(int id) {
        boolean res=false;
        String sql = "DELETE FROM public.cliente WHERE id_cliente=?";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1,id));
        try {
            res= AccesoDatos.ejecutaComando(sql, lstPar);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        return res;
    }
    public static boolean update(clsCliente micliente) {
        boolean res = false;
        String sql = "UPDATE public.cliente " +
                "SET ruc=?, nombre=?, direccion=? WHERE id_cliente=?";
        ArrayList<Parametro> lstPar = new ArrayList<>();   
        lstPar.add(new Parametro(1,micliente.getRuc()));
        lstPar.add(new Parametro(2,micliente.getNombre()));
        lstPar.add(new Parametro(3,micliente.getDireccion()));
        lstPar.add(new Parametro(4,micliente.getId_cliente()));
        try{
            res= AccesoDatos.ejecutaComando(sql, lstPar);
        }catch (Exception e) {
            System.out.println(e.getMessage());
            }
        return res;
    }
    public static ArrayList<clsCliente> findbyAll() {
        ArrayList<clsCliente> listado = new ArrayList<>();
        String sql = "SELECT id_cliente,ruc, nombre, direccion "+
                "FROM public.cliente";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql, lstPar);
            clsCliente cliente = null;
            while (cres.next())
            {
                cliente = new clsCliente();
                cliente.setId_cliente(cres.getInt("id_cliente"));
                cliente.setRuc(cres.getString("ruc"));
                cliente.setNombre(cres.getString("nombre"));
                cliente.setDireccion(cres.getString("direccion"));
                listado.add((cliente));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listado;
    }
    public clsCliente findbyId(clsCliente cli) {
        clsCliente cliente = null;
        String sql = "SELECT id_cliente, ruc , nombre, direccion "+
                "FROM public.cliente WHERE id_cliente=?";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, cli.getId_cliente()));
        
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql, lstPar);
            while (cres.next()) {
                cliente = new clsCliente();
                cliente.setId_cliente(cres.getInt("id_cliente"));
                cliente.setRuc(cres.getString("ruc"));
                cliente.setNombre(cres.getString("nombres"));
                cliente.setDireccion(cres.getString("direccion"));
                
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return cliente;
    }
    public static clsCliente findbyId(int id) {
        clsCliente cliente = null;
        String sql = "SELECT id_cliente,ruc, nombre, direccion "+
                "FROM public.cliente WHERE id_cliente=?";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1,id));
        
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql, lstPar);
            while (cres.next()) {
                cliente = new clsCliente();
                cliente.setId_cliente(cres.getInt("id_cliente"));
                cliente.setRuc(cres.getString("ruc"));
                cliente.setNombre(cres.getString("nombres"));
                cliente.setDireccion(cres.getString("direccion"));
                
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return cliente;
    }
}
