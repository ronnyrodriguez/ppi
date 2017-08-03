/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yasves.funciones;

import com.yasves.accesodatos.AccesoDatos;
import com.yasves.accesodatos.ConjuntoResultado;
import com.yasves.accesodatos.Parametro;
import com.yasves.entidades.clsSector;
import java.util.ArrayList;

/**
 *
 * @author Rocby
 */
public class crudSector {
    public static boolean save(clsSector factura){
        boolean resultado = false;
        String sql = "INSERT INTO public.sector(codigo_sector,distancia,observacion,lugar_id)"
                + " VALUES(?,?,?,?)";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, factura.getCodigo_sector()));
        lstPar.add(new Parametro(2, factura.getDistancia()));
        lstPar.add(new Parametro(3, factura.getObservacion()));   
        lstPar.add(new Parametro(4, factura.getLugar_id().getId()));
        try {
            resultado = AccesoDatos.ejecutaComando(sql, lstPar);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return resultado;
    }
    
    public static boolean delete(clsSector factura) {
        boolean res=false;
        String sql = "DELETE FROM public.sector WHERE n=?";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1,factura.getId()));
        try {
            res= AccesoDatos.ejecutaComando(sql, lstPar);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        return res;
    }

    public static boolean update(clsSector factura) {
        boolean res = false;
        String sql = "UPDATE public.sector " +
                "SET codigo_sector=?,distancia=?,observacion=?,lugar_id=? " + 
                "WHERE id=?";
        ArrayList<Parametro> lstPar = new ArrayList<>();    
        lstPar.add(new Parametro(1, factura.getCodigo_sector()));
        lstPar.add(new Parametro(2, factura.getDistancia()));
        lstPar.add(new Parametro(3, factura.getObservacion()));   
        lstPar.add(new Parametro(4, factura.getLugar_id().getId()));
        try{
            res= AccesoDatos.ejecutaComando(sql, lstPar);
        }catch (Exception e) {
            System.out.println(e.getMessage());
            }
        return res;
    }

    public static ArrayList<clsSector> findbyAll() {
        ArrayList<clsSector> listado = new ArrayList<>();
        String sql = "SELECT id,codigo_sector,distancia,observacion,lugar_id "+
                "FROM public.sector";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql, lstPar);
            clsSector factura = null;
            while (cres.next())
            {
                factura = new clsSector();
                factura.setId(cres.getInt("id"));                
                factura.setCodigo_sector(cres.getString("codigo_sector"));
                factura.setDistancia(cres.getDouble("distancia"));
                factura.setObservacion(cres.getString("observacion"));
                factura.setLugar_id(crudLugar.findbyId(cres.getInt("lugar_id")));
                
                listado.add((factura));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listado;
    }

    public clsSector findbyId(clsSector ins) {
        clsSector factura = null;
        String sql = "SELECT id,codigo_sector,distancia,observacion,lugar_id "+
                "FROM public.sector WHERE id=?";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, ins.getId()));
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql, lstPar);
            while (cres.next()) {
                factura = new clsSector();
                factura.setId(cres.getInt("id"));                
                factura.setCodigo_sector(cres.getString("codigo_sector"));
                factura.setDistancia(cres.getDouble("distancia"));
                factura.setObservacion(cres.getString("observacion"));
                factura.setLugar_id(crudLugar.findbyId(cres.getInt("lugar_id")));                
                
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return factura;
    }
    public static clsSector findbyId(int ide) {
        clsSector factura = null;
        String sql = "SELECT id,codigo_sector,distancia,observacion,lugar_id "+
                "FROM public.sector WHERE id=?";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1,ide));
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql, lstPar);
            while (cres.next()) {
                factura = new clsSector();
                factura.setId(cres.getInt("id"));                
                factura.setCodigo_sector(cres.getString("codigo_sector"));
                factura.setDistancia(cres.getDouble("distancia"));
                factura.setObservacion(cres.getString("observacion"));
                factura.setLugar_id(crudLugar.findbyId(cres.getInt("lugar_id"))); 
               
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return factura;
    }
}
