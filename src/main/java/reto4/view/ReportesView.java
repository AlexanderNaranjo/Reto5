package reto4.view;

import reto4.controller.ReportesController;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.awt.*;
import reto4.model.vo.*;

public class ReportesView extends JFrame implements ActionListener{
        private static ReportesController controller;

        private JTable tabla;
        private DefaultTableModel modelo;
        private JLabel lblTitulo, lblConsulta;
        private JRadioButton btnPrimerInf, btnSegundoInf, btnTercerInf;
        private ButtonGroup btnGroup;
        

        public ReportesView(){
            controller = new ReportesController();
            etiqueta1();
            radioButton();
            etiqueta2();
            tabla();
        }

        public void tabla(){
            tabla = new JTable(modelo);
            tabla.setPreferredScrollableViewportSize(new Dimension(500,200));
            add(tabla);
            JScrollPane pane = new JScrollPane(tabla);
            add(pane);   
        }

        public void etiqueta1(){
            lblTitulo = new JLabel("Informe Ministerio de Vivienda");
            lblTitulo.setPreferredSize(new Dimension(400,30));
            lblTitulo.setFont(new Font("Arial", Font.BOLD, 20));
            add(lblTitulo);
        }
        public void etiqueta2(){
            lblConsulta = new JLabel();
            lblConsulta.setPreferredSize(new Dimension(200, 30)); 
            lblConsulta.setFont(new Font("Arial", Font.BOLD, 14));
            add(lblConsulta);
        }

        public void radioButton(){
            btnPrimerInf = new JRadioButton("Primer Informe");
            btnPrimerInf.setPreferredSize(new Dimension(180,20));
            btnSegundoInf = new JRadioButton("Segundo Informe");
            btnSegundoInf.setPreferredSize(new Dimension(180,20));
            btnTercerInf = new JRadioButton("Tercer Informe");
            btnTercerInf.setPreferredSize(new Dimension(180,20));
            btnGroup = new ButtonGroup();
            add(btnPrimerInf);
            add(btnSegundoInf);
            add(btnTercerInf);
            btnGroup.add(btnPrimerInf);
            btnGroup.add(btnSegundoInf);
            btnGroup.add(btnTercerInf);
            btnPrimerInf.addActionListener(this);
            btnSegundoInf.addActionListener(this);
            btnTercerInf.addActionListener(this);
        }

        public void segundoInforme() {
            try{
                List<ProyectosVo> proyectos = controller.listarProyectos();
                modelo = new DefaultTableModel();
                modelo.addColumn("Id proyecto");
                modelo.addColumn("Constructora");
                modelo.addColumn("Habitaciones");
                modelo.addColumn("Ciudad");
                for(ProyectosVo proyecto: proyectos){
                    Object[] fila = new Object[4];
                    fila[0]= proyecto.getId();
                    fila[1]= proyecto.getConstructora();
                    fila[2]= proyecto.getHabitaciones();
                    fila[3]= proyecto.getCiudad();   
                    modelo.addRow(fila);                 
                    }
                tabla.setModel(modelo);
                modelo.fireTableDataChanged();
                    
                }
            catch (Exception e){
                System.out.println("Error: " + e.getMessage());
            }
                
            
        }
        public void tercerInforme() {
            try{
                List<ComprasVo> compras = controller.listarCompras();
                //Creeación del modelo:
                modelo = new DefaultTableModel();
                modelo.addColumn("Id Compras"); // Nombres de las columnas
                modelo.addColumn("Constructora");
                modelo.addColumn("Banco vinculado");
                for(ComprasVo compra: compras){ // recorrer el objeto vo con ayuda de los getters
                    Object[] fila = new Object[3]; // creacion de la fila
                    fila[0]= compra.getId();
                    fila[1]= compra.getConstructora();
                    fila[2]= compra.getBanco();  
                    modelo.addRow(fila); // adicion de la fila
                }
                tabla.setModel(modelo); // fija el cambio de modelo
                modelo.fireTableDataChanged(); //actualizo el modelo de la tabla
                }
            catch(Exception e){
                System.out.println("Error: " + e.getMessage());
            }
            
        }
        public void primerInforme() {
            try{
                List<ListaLideresVo> lideres = controller.listarLideres();
                
                //Creeación del modelo:
                modelo = new DefaultTableModel();
                modelo.addColumn("Id Lider"); // Nombres de las columnas
                modelo.addColumn("Nombre");
                modelo.addColumn("Apellido");
                modelo.addColumn("Ciudad");
                for(ListaLideresVo lider: lideres){ // recorrer el objeto vo con ayuda de los getters
                    Object[] fila = new Object[4]; // creacion de la fila
                    fila[0]= lider.getId();
                    fila[1]= lider.getNombre();
                    fila[2]= lider.getApellido();
                    fila[3]= lider.getCiudad();   
                    modelo.addRow(fila); // adicion de la fila
                }
                tabla.setModel(modelo); // fija el cambio de modelo
                modelo.fireTableDataChanged(); //actualizo el modelo de la tabla
            }
            catch(Exception e){
                System.out.println("Error: " + e.getMessage());
            }
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == btnPrimerInf){
                primerInforme();
                lblConsulta.setText("Informe de líderes");
            }
            if(e.getSource() == btnSegundoInf){
                segundoInforme();
                lblConsulta.setText("Informe de proyectos");
            }
            if(e.getSource() == btnTercerInf){
                tercerInforme();
                lblConsulta.setText("Informe de compras");
            }
            
        }
}
