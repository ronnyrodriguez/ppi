package com.yasves.charts;

import com.yasves.entidades.clsPro_det;
import com.yasves.ln.ln_prodet;
import javax.annotation.PostConstruct;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.CategoryAxis;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.LineChartSeries;
 
@ManagedBean
public class chart_mes_11 implements Serializable {
 
    private LineChartModel lineModel1;
    private LineChartModel lineModel2;
     
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
        lineModel2.setTitle(" Noviembre ");
        lineModel2.setZoom(true);
        lineModel2.setLegendPosition("e");
        lineModel2.setAnimate(true);
        
        lineModel2.getAxes().put(AxisType.X, new CategoryAxis(" Semanas del Mes "));
        
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
        int mes=10;
        int codigo_sector=0;
        ChartSeries boys = new ChartSeries();
        boys.setLabel("Rio Puyo ");
        ChartSeries rio2 = new ChartSeries();
        rio2.setLabel("Rio Pindo ");
        
        
        for (int i = 1; i < 3 ; i++) {
            
            codigo_sector=codigo_sector+1;
            
            java.sql.Date eni = new java.sql.Date(2017-1900, mes, 1);
            java.sql.Date enf = new java.sql.Date(2017-1900, mes, 7);
            clsPro_det en=null;
            en=ln_prodet.mayorcf(eni, enf, codigo_sector);
            if (codigo_sector == 1) {
                boys.set("Semana 1 ",en.getPromedio());
            }
            if (codigo_sector == 2) {
                rio2.set("Semana 1 ",en.getPromedio());
            }
        
            java.sql.Date fbi = new java.sql.Date(2017-1900, mes, 8);
            java.sql.Date fbf = new java.sql.Date(2017-1900, mes, 14);
            clsPro_det fb=null;
            fb=ln_prodet.mayorcf(fbi, fbf, codigo_sector);
             
            if (codigo_sector == 1) {
                boys.set("Semana 2 ",fb.getPromedio());
            }
            if (codigo_sector == 2) {
                rio2.set("Semana 2 ",fb.getPromedio());
            }
        
            java.sql.Date mri = new java.sql.Date(2017-1900,mes,15);
            java.sql.Date mrf = new java.sql.Date(2017-1900,mes,21);
            clsPro_det mr=null;
            mr=ln_prodet.mayorcf(mri, mrf, codigo_sector);
             
            if (codigo_sector == 1) {
                boys.set("Semana 3 ",mr.getPromedio());
            }
            if (codigo_sector == 2) {
                rio2.set("Semana 3 ",mr.getPromedio());
            }
            
            
        
            java.sql.Date abrili = new java.sql.Date(2017-1900, mes, 22);
            java.sql.Date abrilf = new java.sql.Date(2017-1900, mes, 28);
            clsPro_det abril=null;
            abril=ln_prodet.mayorcf(abrili, abrilf, codigo_sector);
                
            if (codigo_sector == 1) {
                boys.set("Semana 4",abril.getPromedio());
            }
            if (codigo_sector == 2) {
                rio2.set("Semana 4",abril.getPromedio());
            }
     
        }
          
        model.addSeries(boys);
        model.addSeries(rio2);
         
        return model;
    }

  
 
}

