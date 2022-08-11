package reto4;

import reto4.view.ReportesView;
import java.awt.*;
import javax.swing.JFrame;

public class App 
{
    public static void main( String[] args )
    {
        var reportesView = new ReportesView();
        reportesView.setLayout(new FlowLayout());
        reportesView.setSize(600, 400);
        reportesView.setVisible(true);
        reportesView.setResizable(false);
        reportesView.setTitle("Reto 5 - Extracción de información y generación de informes");
        reportesView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        reportesView.setLocationRelativeTo(null); //ubica la ventana en el centro de la pantalla 
        
    }
}
