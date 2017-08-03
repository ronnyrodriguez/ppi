/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yasves.funciones;

import com.yasves.accesodatos.AccesoDatos;
import com.yasves.accesodatos.ConjuntoResultado;
import com.yasves.accesodatos.Parametro;
import com.yasves.entidades.clsSensor;
import java.util.ArrayList;

/**
 *
 * @author Rocby
 */
public class crudSensor {

    public static boolean save(clsSensor factura) {
        boolean resultado = false;
        String sql = "INSERT INTO public.equipo(tipo,observaciones,sector_id,estado)"
                + " VALUES(?,?,?,?)";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, factura.getTipo()));
        lstPar.add(new Parametro(2, factura.getObservaciones()));
        lstPar.add(new Parametro(3, factura.getEstado()));
        lstPar.add(new Parametro(4, factura.getSector_id().getId()));
        try {
            resultado = AccesoDatos.ejecutaComando(sql, lstPar);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return resultado;
    }

    public static boolean delete(clsSensor factura) {
        boolean res = false;
        String sql = "DELETE FROM public.equipo WHERE n=?";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, factura.getId()));
        try {
            res = AccesoDatos.ejecutaComando(sql, lstPar);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return res;
    }

    public static boolean update(clsSensor factura) {
        boolean res = false;
        String sql = "UPDATE public.equipo "
                + "SET tipo=?,observaciones=?,estado=?,sector_id=? "
                + "WHERE id=?";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, factura.getTipo()));
        lstPar.add(new Parametro(2, factura.getObservaciones()));
        lstPar.add(new Parametro(3, factura.getEstado()));
        lstPar.add(new Parametro(4, factura.getSector_id().getId()));
        try {
            res = AccesoDatos.ejecutaComando(sql, lstPar);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return res;
    }

    public static ArrayList<clsSensor> findbyAll() {
        ArrayList<clsSensor> listado = new ArrayList<>();
        String sql = "SELECT id,tipo,observaciones,estado,sector_id "
                + "FROM public.equipo";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql, lstPar);
            clsSensor factura = null;
            while (cres.next()) {
                factura = new clsSensor();
                factura.setId(cres.getInt("id"));
                factura.setTipo(cres.getString("tipo"));
                factura.setObservaciones(cres.getString("observaciones"));
                factura.setEstado(cres.getString("estado"));
                factura.setSector_id(crudSector.findbyId(cres.getInt("sector_id")));

                listado.add((factura));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listado;
    }

    public clsSensor findbyId(clsSensor ins) {
        clsSensor factura = null;
        String sql = "SELECT id,tipo,observaciones,estado,sector_id "
                + "FROM public.equipo WHERE id=?";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, ins.getId()));
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql, lstPar);
            while (cres.next()) {
                factura = new clsSensor();
                factura.setId(cres.getInt("id"));
                factura.setTipo(cres.getString("tipo"));
                factura.setObservaciones(cres.getString("observaciones"));
                factura.setEstado(cres.getString("estado"));
                factura.setSector_id(crudSector.findbyId(cres.getInt("sector_id")));

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return factura;
    }

    public static clsSensor findbyId(int ide) {
        clsSensor factura = null;
        String sql = "SELECT id,tipo,observaciones,estado,sector_id "
                + "FROM public.equipo WHERE id=?";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, ide));
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql, lstPar);
            while (cres.next()) {
                factura = new clsSensor();
                factura.setId(cres.getInt("id"));
                factura.setTipo(cres.getString("tipo"));
                factura.setObservaciones(cres.getString("observaciones"));
                factura.setEstado(cres.getString("estado"));
                factura.setSector_id(crudSector.findbyId(cres.getInt("sector_id")));
                

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return factura;
    }
}
