package reto4.model.dao;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import reto4.model.vo.ComprasVo;
import reto4.utils.JDBCUtilities;

public class ComprasDao {
    public List<ComprasVo> listar() throws SQLException{
        List<ComprasVo> respuesta = new ArrayList<ComprasVo>();
        Connection conn = JDBCUtilities.getConnection();
        Statement stm = null;
        ResultSet rs = null;
        String consulta = "select c.ID_Compra as Compra, Constructora, Banco_Vinculado as banco from Proyecto p join Compra c on(p.ID_Proyecto = c.ID_Proyecto) where c.Proveedor = 'Homecenter' and Ciudad = 'Salento'";
        try{
            stm = conn.createStatement();
            rs = stm.executeQuery(consulta);
            while(rs.next()){
                ComprasVo vo = new ComprasVo();
                vo.setId(rs.getInt("Compra"));
                vo.setConstructora(rs.getString("Constructora"));
                vo.setBanco(rs.getString("banco"));
                respuesta.add(vo);
            }
        }
        finally{
            if (rs != null){
                rs.close();
            }
            if(stm != null){
                stm.close();
            }
            if(conn !=null){
                conn.close();
            }
        }
        return respuesta;
    }
}
