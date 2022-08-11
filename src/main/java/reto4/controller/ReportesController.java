package reto4.controller;

import java.sql.SQLException;

import reto4.model.dao.ListaLideresDao;
import reto4.model.dao.ComprasDao;
import reto4.model.dao.ProyectosDao;
import reto4.model.vo.*;
import java.util.List;


public class ReportesController {
    private ProyectosDao proyectosDao;
    private ComprasDao ComprasDao;
    private ListaLideresDao listaLideresDao;

    public ReportesController(){
        proyectosDao = new ProyectosDao();
        ComprasDao = new ComprasDao();
        listaLideresDao = new ListaLideresDao();
    }
    public List<ProyectosVo> listarProyectos() throws SQLException{
        return proyectosDao.listar();
    }
    public List<ComprasVo> listarCompras() throws SQLException{
        return ComprasDao.listar();
    }

    public List<ListaLideresVo> listarLideres() throws SQLException{
        return listaLideresDao.listar();
    }
}

