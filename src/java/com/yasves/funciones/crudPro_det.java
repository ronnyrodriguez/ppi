/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yasves.funciones;

import com.yasves.accesodatos.AccesoDatos;
import com.yasves.accesodatos.ConjuntoResultado;
import com.yasves.accesodatos.Parametro;
import com.yasves.entidades.clsPro_det;
import java.util.ArrayList;

/**
 *
 * @author Rocby
 */
public class crudPro_det {
     public static boolean save(clsPro_det cliente){
        boolean resultado = false;
        String sql = "INSERT INTO public.pro_det(marca_agua,fecha,sector_id) VALUES(?,?,?)";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, cliente.getMarca_agua()));
        lstPar.add(new Parametro(2, cliente.getFecha()));  
        lstPar.add(new Parametro(3, cliente.getSector_id().getId()));
        try {
            resultado = AccesoDatos.ejecutaComando(sql, lstPar);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return resultado;
    }
    
    public static boolean delete(clsPro_det cliente) {
        boolean res=false;
        String sql = "DELETE FROM public.pro_det WHERE id=?";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1,cliente.getId()));
        try {
            res= AccesoDatos.ejecutaComando(sql, lstPar);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        return res;
    }

    public static boolean update(clsPro_det cliente) {
        boolean res = false;
        String sql = "UPDATE public.pro_det " +
                "SET marca_agua=?,fecha=?,sector_id=? " + 
                "WHERE id=?";
        ArrayList<Parametro> lstPar = new ArrayList<>();        
        lstPar.add(new Parametro(1, cliente.getMarca_agua()));
        lstPar.add(new Parametro(2, cliente.getFecha())); 
        lstPar.add(new Parametro(4,cliente.getId()));  
        lstPar.add(new Parametro(3, cliente.getSector_id().getId()));
        try{
            res= AccesoDatos.ejecutaComando(sql, lstPar);
        }catch (Exception e) {
            System.out.println(e.getMessage());
            }
        return res;
    }

    public static ArrayList<clsPro_det> findbyAll() {
        ArrayList<clsPro_det> listado = new ArrayList<>();
        String sql = "SELECT id,marca_agua, fecha, sector_id "+
                "FROM public.pro_det";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql, lstPar);
            clsPro_det producto = null;
            while (cres.next())
            {
                producto = new clsPro_det();
                producto.setId(cres.getInt("id"));
                producto.setMarca_agua(cres.getDouble("marca_agua"));
                producto.setFecha(cres.getDate("fecha"));
                producto.setSector_id(crudSector.findbyId(cres.getInt("sector_id")));
                listado.add((producto));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listado;
    }

    public clsPro_det findbyId(clsPro_det ins) {
        clsPro_det cliente = null;
        String sql = "SELECT id,marca_agua,fecha,sector_id FROM public.pro_det WHERE id=?";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, ins.getId()));
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql, lstPar);
            while (cres.next()) {
                cliente = new clsPro_det();
                cliente.setId(cres.getInt("id"));
                cliente.setMarca_agua(cres.getDouble("marca_agua"));
                cliente.setFecha(cres.getDate("fecha"));
                cliente.setSector_id(crudSector.findbyId(cres.getInt("lugar_id")));        
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return cliente;
    }
    public static clsPro_det findbyId(int ide) {
        clsPro_det cliente = null;
        String sql = "SELECT id,marca_agua,fecha,sector_id FROM public.pro_det WHERE id=?";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1,ide));
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql, lstPar);
            while (cres.next()) {
                cliente = new clsPro_det();
                cliente.setId(cres.getInt("id"));
                cliente.setMarca_agua(cres.getDouble("marca_agua"));
                cliente.setFecha(cres.getDate("fecha"));
                cliente.setSector_id(crudSector.findbyId(cres.getInt("sector_id")));       
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return cliente;
    }

   
    
}


