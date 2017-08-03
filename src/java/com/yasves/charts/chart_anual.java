package com.yasves.charts;

import com.yasves.entidades.clsPro_det;
import com.yasves.ln.ln_prodet;
import javax.annotation.PostConstruct;
import java.io.Serializable;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.CategoryAxis;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.LineChartSeries;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
 
@ManagedBean
public class chart_anual implements Serializable {
 
    private LineChartModel lineModel1;
    private LineChartModel lineModel2;
    private int año;
     
    @PostConstruct
    public void init() {
        createLineModels();
    }
 
    public LineChartModel getLineModel1() {
        return lineModel1;
    }
 
    public LineChartModel getLineModel2() {
        return lineModel2;
    }
     
    private void createLineModels() {
        lineModel1 = initLinearModel();
        lineModel1.setTitle("Linear Chart");
        lineModel1.setLegendPosition("e");
        Axis yAxis = lineModel1.getAxis(AxisType.Y);
        yAxis.setMin(0);
        yAxis.setMax(10);
         
        lineModel2 = initCategoryModel();
        lineModel2.setTitle(" Informe Anual ");
        lineModel2.setZoom(true);
        lineModel2.setLegendPosition("e");
        lineModel2.setAnimate(true);
        
        //lineModel2.setShowPointLabels(true);
        lineModel2.getAxes().put(AxisType.X, new CategoryAxis(" Meses del Año "));
        
        yAxis = lineModel2.getAxis(AxisType.Y);
        yAxis.setLabel("Flujo del Rio");
        yAxis.setMin(0);
        yAxis.setMax(500);
    }
   
    private LineChartModel initLinearModel() {
        LineChartModel model = new LineChartModel();
 
        LineChartSeries series1 = new LineChartSeries();
        
        series1.setLabel("Series 1");
 
        series1.set(1, 2);
        series1.set(2, 1);
        series1.set(3, 3);
        series1.set(4, 6);
        series1.set(5, 8);
 
        LineChartSeries series2 = new LineChartSeries();
        series2.setLabel("Series 2");
 
        series2.set(1, 6);
        series2.set(2, 3);
        series2.set(3, 2);
        series2.set(4, 7);
        series2.set(5, 9);
 
        model.addSeries(series1);
        model.addSeries(series2);
         
        return model;
    }
    
   
    public LineChartModel initCategoryModel() {
        LineChartModel model = new LineChartModel();
        int mes=0;
        int codigo_sector=0;
        
        ChartSeries boys = new ChartSeries();
        boys.setLabel("Rio Puyo ");
        ChartSeries rio2 = new ChartSeries();
        rio2.setLabel("Rio Pindo ");
        int a;
        if (año == 0) {
            a=2017;
        }else{
            a=año;
        }
        
        for (int i = 0; i < 3 ; i++) {
            
            codigo_sector=codigo_sector+1;
            
            java.sql.Date eni = new java.sql.Date(a-1900, mes, 1);
            java.sql.Date enf = new java.sql.Date(a-1900, mes, 28);
            clsPro_det en=null;
            en=ln_prodet.mayorcf(eni, enf, codigo_sector);
            if (codigo_sector == 1) {
                boys.set("Enero",en.getPromedio());
            }
            if (codigo_sector == 2) {
                rio2.set("Enero",en.getPromedio());
            }
        
            java.sql.Date fbi = new java.sql.Date(a-1900, mes+1, 1);
            java.sql.Date fbf = new java.sql.Date(a-1900, mes+1, 28);
            clsPro_det fb=null;
            fb=ln_prodet.mayorcf(fbi, fbf, codigo_sector);
             
            if (codigo_sector == 1) {
                boys.set("Febrero",fb.getPromedio());
            }
            if (codigo_sector == 2) {
                rio2.set("Febrero",fb.getPromedio());
            }
        
            java.sql.Date mri = new java.sql.Date(a-1900, mes+2, 1);
            java.sql.Date mrf = new java.sql.Date(a-1900, mes+2, 28);
            clsPro_det mr=null;
            mr=ln_prodet.mayorcf(mri, mrf, codigo_sector);
             
            if (codigo_sector == 1) {
                boys.set("Marzo",mr.getPromedio());
            }
            if (codigo_sector == 2) {
                rio2.set("Marzo",mr.getPromedio());
            }
            
        
            java.sql.Date abrili = new java.sql.Date(a-1900, mes+3, 1);
            java.sql.Date abrilf = new java.sql.Date(a-1900, mes+3, 28);
            clsPro_det abril=null;
            abril=ln_prodet.mayorcf(abrili, abrilf, codigo_sector);
                
            if (codigo_sector == 1) {
                boys.set("Abril",abril.getPromedio());
            }
            if (codigo_sector == 2) {
                rio2.set("Abril",abril.getPromedio());
            }
            
     
            java.sql.Date Mayoi = new java.sql.Date(a-1900, mes+4, 1);
            java.sql.Date Mayof = new java.sql.Date(a-1900, mes+4, 28);
            clsPro_det my=null;
            my=ln_prodet.mayorcf(Mayoi, Mayof, codigo_sector);
            
            if (codigo_sector == 1) {
                boys.set("Mayo",my.getPromedio());
            }
            if (codigo_sector == 2) {
                rio2.set("Mayo",my.getPromedio());
            }
            
            
        
            java.sql.Date Junioi = new java.sql.Date(a-1900, mes+5, 1);
            java.sql.Date Juniof = new java.sql.Date(a-1900, mes+5, 28);
            clsPro_det jn=null;
            jn=ln_prodet.mayorcf(Junioi, Juniof, codigo_sector);
            
            if (codigo_sector == 1) {
                boys.set("Junio",jn.getPromedio());
            }
            if (codigo_sector == 2) {
                rio2.set("Junio",jn.getPromedio());
            }
            
            
            
            java.sql.Date Julioi = new java.sql.Date(a-1900, mes+6, 1);
            java.sql.Date Juliof = new java.sql.Date(a-1900, mes+6, 28);
            clsPro_det jl=null;
            jl=ln_prodet.mayorcf(Julioi, Juliof, codigo_sector);
            
            if (codigo_sector == 1) {
               boys.set("Julio",jl.getPromedio());
            }
            if (codigo_sector == 2) {
                rio2.set("Julio",jl.getPromedio());
            }
            
            
            
            
            java.sql.Date agi = new java.sql.Date(a-1900, mes+7, 1);
            java.sql.Date agf = new java.sql.Date(a-1900, mes+7, 28);
            clsPro_det ag=null;
            ag=ln_prodet.mayorcf(agi, agf, codigo_sector);
            
            if (codigo_sector == 1) {
                boys.set("Agosto",ag.getPromedio());
            }
            if (codigo_sector == 2) {
                rio2.set("Agosto",ag.getPromedio());
            }
            
          
            java.sql.Date spi = new java.sql.Date(a-1900, mes+8, 1);
            java.sql.Date spf = new java.sql.Date(a-1900, mes+8, 28);
            clsPro_det sp=null;
            sp=ln_prodet.mayorcf(spi, spf, codigo_sector);
            
            if (codigo_sector == 1) {
                boys.set("Septiembre",sp.getPromedio());
            }
            if (codigo_sector == 2) {
                rio2.set("Septiembre",sp.getPromedio());
            }
            
         
            java.sql.Date oci = new java.sql.Date(a-1900, mes+9, 1);
            java.sql.Date ocf = new java.sql.Date(a-1900, mes+9, 28);
            clsPro_det oc=null;
            oc=ln_prodet.mayorcf(oci, ocf, codigo_sector);
            
            if (codigo_sector == 1) {
                boys.set("Octubre",oc.getPromedio());
            }
            if (codigo_sector == 2) {
                rio2.set("Octubre",oc.getPromedio());
            }           
            
           
            java.sql.Date nvi = new java.sql.Date(a-1900, mes+10, 1);
            java.sql.Date nvf = new java.sql.Date(a-1900, mes+10, 28);
            clsPro_det nv=null;
            nv=ln_prodet.mayorcf(nvi, nvf, codigo_sector);
          
            if (codigo_sector == 1) {
                  boys.set("Noviembre",nv.getPromedio());
            }
            if (codigo_sector == 2) {
                rio2.set("Noviembre",nv.getPromedio());
            }
            
          
            java.sql.Date dci = new java.sql.Date(a-1900, mes+11, 1);
            java.sql.Date dcf = new java.sql.Date(a-1900, mes+11, 28);
            clsPro_det dc=null;
            dc=ln_prodet.mayorcf(dci, dcf, codigo_sector);
                        
            if (codigo_sector == 1) {
                boys.set("Diciembre",dc.getPromedio());
            }
            if (codigo_sector == 2) {
                rio2.set("Diciembre",dc.getPromedio());
            }
            
            
        }
          
        model.addSeries(boys);
        model.addSeries(rio2);
         
        return model;
    }

    public int getAño() {
        return año;
    }
  
    public void setAño(int año) {
        this.año = año;
        
    }
 
}

