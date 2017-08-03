/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yasves.ln;

import com.yasves.accesodatos.AccesoDatos;
import com.yasves.accesodatos.ConjuntoResultado;
import com.yasves.accesodatos.Parametro;
import com.yasves.entidades.clsPro_det;
import com.yasves.entidades.clsSector;
import com.yasves.funciones.crudPro_det;
import com.yasves.funciones.crudSector;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class ln_prodet {

    public static clsPro_det mayorcf(Date fecha1,Date fecha2, Integer codigo)  {
        clsPro_det factura=null;

        String sql = "SELECT public.sector.codigo_sector AS sector,Avg(public.pro_det.marca_agua) AS promedio,"
                + " Count(public.pro_det.sector_id) AS codigo "
                + " FROM public.pro_det "
                + " INNER JOIN public.sector ON public.pro_det.sector_id = public.sector.id "
                + " WHERE "
                + " public.pro_det.fecha >= ? AND "
                + " public.pro_det.fecha <= ? AND "
                + " public.pro_det.sector_id = ? GROUP BY public.sector.codigo_sector";
        System.out.println(sql);
        ArrayList<Parametro> lstPar = new ArrayList<>();
        
        lstPar.add(new Parametro(1,fecha1));
        lstPar.add(new Parametro(2,fecha2));
        lstPar.add(new Parametro(3,codigo));
        
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql, lstPar);
            
            while (cres.next()) {
                factura = new clsPro_det();                
                factura.setPromedio(cres.getDouble("promedio"));
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return factura;
    }
}
