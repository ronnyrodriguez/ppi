/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yasves.funciones;

import com.yasves.accesodatos.AccesoDatos;
import com.yasves.accesodatos.ConjuntoResultado;
import com.yasves.accesodatos.Parametro;
import com.yasves.entidades.clsLugar;
import java.util.ArrayList;

/**
 *
 * @author Rocby
 */
public class crudLugar {
    
    public static boolean save(clsLugar cliente){
        boolean resultado = false;
        String sql = "INSERT INTO public.lugar(nombre,observacion) VALUES(?,?)";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, cliente.getNombre()));
        lstPar.add(new Parametro(2, cliente.getObservacion()));       
        try {
            resultado = AccesoDatos.ejecutaComando(sql, lstPar);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return resultado;
    }
    
    public static boolean delete(clsLugar cliente) {
        boolean res=false;
        String sql = "DELETE FROM public.lugar WHERE id=?";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1,cliente.getId()));
        try {
            res= AccesoDatos.ejecutaComando(sql, lstPar);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        return res;
    }

    public static boolean update(clsLugar cliente) {
        boolean res = false;
        String sql = "UPDATE public.lugar " +
                "SET nombre=?,observacion=? " + 
                "WHERE id=?";
        ArrayList<Parametro> lstPar = new ArrayList<>();        
        lstPar.add(new Parametro(1, cliente.getNombre()));
        lstPar.add(new Parametro(2, cliente.getObservacion())); 
        lstPar.add(new Parametro(3, cliente.getId()));
        try{
            res= AccesoDatos.ejecutaComando(sql, lstPar);
        }catch (Exception e) {
            System.out.println(e.getMessage());
            }
        return res;
    }

    public static ArrayList<clsLugar> findbyAll() {
        ArrayList<clsLugar> listado = new ArrayList<>();
        String sql = "SELECT id, nombre, observacion FROM public.lugar";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql, lstPar);
            clsLugar lugar = null;
            while (cres.next())
            {
                lugar = new clsLugar();
                lugar.setId(cres.getInt("id"));
                lugar.setNombre(cres.getString("nombre"));
                lugar.setObservacion(cres.getString("observacion"));
                listado.add(lugar);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listado;
    }

    public clsLugar findbyId(clsLugar ins) {
        clsLugar cliente = null;
        String sql = "SELECT id,nombre,observacion FROM public.lugar WHERE id=?";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, ins.getId()));
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql, lstPar);
            while (cres.next()) {
                cliente = new clsLugar();
                cliente.setId(cres.getInt("id"));
                cliente.setNombre(cres.getString("nombre"));
                cliente.setObservacion(cres.getString("observacion"));        
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return cliente;
    }
    public static clsLugar findbyId(int ide) {
        clsLugar cliente = null;
        String sql = "SELECT id,nombre,observacion FROM public.lugar WHERE id=?";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1,ide));
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql, lstPar);
            while (cres.next()) {
                cliente = new clsLugar();
                cliente.setId(cres.getInt("id"));
                cliente.setNombre(cres.getString("nombre"));
                cliente.setObservacion(cres.getString("observacion"));        
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return cliente;
    }
    
    
    
}
