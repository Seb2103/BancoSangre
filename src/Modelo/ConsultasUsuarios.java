package Modelo;

import Datos.Repositorio;
import static Modelo.ConexionBaseDatos.conectar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

public class ConsultasUsuarios extends ConexionBaseDatos {

    public static DefaultTableModel listar() {
        DefaultTableModel modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        modelo.addColumn("ID");
        modelo.addColumn("NOMBRE");
        modelo.addColumn("CONTRASEÑA");

        Connection con = conectar();
        PreparedStatement ps = null;
        String sql = "SELECT * FROM usuario";
        ResultSet rs;

        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            ResultSetMetaData rsMd = (ResultSetMetaData) rs.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();

            while (rs.next()) {//llenar cada fila
                Object[] filas = new Object[cantidadColumnas];
                for (int i = 0; i < cantidadColumnas; i++) {
                    filas[i] = rs.getObject(i + 1);
                }
                modelo.addRow(filas);//llenamos filas
            }

        } catch (SQLException e) {
            System.out.println("Error de listado: " + e.getMessage());
        } finally {
            ps = null;
            rs = null;
        }

        return modelo;
    }
    
    public void llenar(){
        Connection con=conectar();
        PreparedStatement ps=null;
        String sql="SELECT * FROM usuario";
        ResultSet rs;
        
        try {
            ps = con.prepareStatement(sql);
            rs=ps.executeQuery();
            
            ResultSetMetaData rsMd = (ResultSetMetaData) rs.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();
            
            while (rs.next()) {
                Usuario u = new Usuario(rs.getString("nombre_user"),rs.getString("contra_user"));
                Repositorio.usuarios.agregar(u);
            }
            
        } catch (SQLException e) {
            System.out.println("Error de carga: "+e.getMessage());
        }finally{
            ps=null;
            rs=null;
        }
    }
    
}
