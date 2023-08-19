package Controlador;

import Modelo.*;
import Vista.*;
import Datos.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorMostrarUsuarios {
    private frmUsuarios vista;
    private UsuarioArreglo modelo;
    
    
    public ControladorMostrarUsuarios(frmUsuarios vista, UsuarioArreglo modelo){
        this.vista = vista;
        this.modelo = modelo;
        
        setModelo();
        
        this.vista.btnSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ControladorPrincipalAdmin controlador = new ControladorPrincipalAdmin(Repositorio.administrador_validado, new frmPrincipalAdmin());
                controlador.iniciar();
                vista.dispose();
            }
        }
        );
    }
    
    private void setModelo(){
        String[] cabecera = {"Usuario", "Contraseña"};
        this.vista.tblUsuarios.setModel(ConsultasUsuarios.listar());
        this.vista.tblUsuarios.getTableHeader().setReorderingAllowed(false);//no mueva
    }
    
    public void iniciar(){
        this.vista.setLocationRelativeTo(null);
        this.vista.setVisible(true);

    }
}