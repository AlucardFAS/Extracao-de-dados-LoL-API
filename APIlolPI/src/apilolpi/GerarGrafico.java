/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apilolpi;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultKeyedValuesDataset;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author victor.etrindade
 */
public class GerarGrafico {
    
    public void graficoBarraJogador (int top, int jungle, int mid, int bot,int identfy) throws FileNotFoundException, IOException{
        DefaultCategoryDataset graficoBarra1 = new DefaultCategoryDataset();
        
        graficoBarra1.setValue(top, "Lane", "TOP");
        graficoBarra1.setValue(jungle, "Lane", "JUNGLE");
        graficoBarra1.setValue(mid, "Lane", "MID");
        graficoBarra1.setValue(bot, "Lane", "BOT");
        
        JFreeChart grafico = ChartFactory.createBarChart("% de jogos por lane", "lane", "%", graficoBarra1,PlotOrientation.VERTICAL,false,true,false);
        
        if(identfy == 1){
            OutputStream arquivo = new FileOutputStream("grafico_barra_j1.png");
            ChartUtilities.writeChartAsPNG(arquivo, grafico, 550, 400);
        }
        if (identfy == 2) {
            OutputStream arquivo = new FileOutputStream("grafico_barra_j2.png");
            ChartUtilities.writeChartAsPNG(arquivo, grafico, 550, 400);
        }
    }
    
    public void graficoPizzaLigaSolo (int wins, int losses,int identify) throws FileNotFoundException, IOException{
        DefaultPieDataset graficoPizza = new DefaultKeyedValuesDataset();
        
        graficoPizza.setValue("vitorias", wins);
        graficoPizza.setValue("derrotas", losses);
        
        JFreeChart grafico = ChartFactory.createPieChart("Rate SoloQueue", graficoPizza, true, true, false);
        
        if (identify == 1) {
            OutputStream arquivo = new FileOutputStream("grafico_pizza_solo_j1.png");
            ChartUtilities.writeChartAsPNG(arquivo, grafico, 550, 400);
        }
        if (identify == 2) {
            OutputStream arquivo = new FileOutputStream("grafico_pizza_solo_j2.png");
            ChartUtilities.writeChartAsPNG(arquivo, grafico, 550, 400);
        }
        
    }
    
    public void graficoPizzaLigaFlex (int wins, int losses,int identify) throws FileNotFoundException, IOException{
        DefaultPieDataset graficoPizza = new DefaultKeyedValuesDataset();
        
        graficoPizza.setValue("vitorias", wins);
        graficoPizza.setValue("derrotas", losses);
        
        JFreeChart grafico = ChartFactory.createPieChart("Rate FLEX", graficoPizza, true, true, false);
        
        if (identify == 1) {
            OutputStream arquivo = new FileOutputStream("grafico_pizza_flex_j1.png");
            ChartUtilities.writeChartAsPNG(arquivo, grafico, 550, 400);
        }
        if (identify == 2) {
            OutputStream arquivo = new FileOutputStream("grafico_pizza_flex_j2.png");
            ChartUtilities.writeChartAsPNG(arquivo, grafico, 550, 400);
        }
    }
}
