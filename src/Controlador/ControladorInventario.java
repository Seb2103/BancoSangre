
package Controlador;

import Datos.Repositorio;
import Modelo.ConsultasSangre;
import Vista.frmInventario;
import Vista.frmPrincipalAdmin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorInventario {
    private final frmInventario vista;
    
    public ControladorInventario(frmInventario vista){
        this.vista = vista;
        
        this.vista.btnRegresar.addActionListener(new ActionListener(){
            public void actionPerformed (ActionEvent e){
                ControladorPrincipalAdmin controlador = new ControladorPrincipalAdmin(Repositorio.administrador_validado, new frmPrincipalAdmin());
                controlador.iniciar();
                vista.dispose();
            }
        }
        );
    }
    
    public void actualizarTabla() {
          this.vista.tbl_Inventario.setModel(ConsultasSangre.listar());
          this.vista.tbl_Inventario.getTableHeader().setReorderingAllowed(false);
    }
    
    public void iniciar(){
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
        actualizarTabla();
    }
}
