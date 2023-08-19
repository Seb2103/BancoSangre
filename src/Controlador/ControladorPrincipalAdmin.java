package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Modelo.*;
import Vista.*;
import Datos.*;

public class ControladorPrincipalAdmin {
    private frmPrincipalAdmin vista;
    private Administrador modelo;
    
    public ControladorPrincipalAdmin(Administrador modelo, frmPrincipalAdmin vista) {
        this.modelo = modelo;
        this.vista = vista;
        
        this.vista.btnUsuarios.addActionListener(new ActionListener(){
            public void actionPerformed (ActionEvent e){
                ControladorMostrarUsuarios controlador = new ControladorMostrarUsuarios(new frmUsuarios(), Repositorio.usuarios);
                controlador.iniciar();
                vista.dispose();
                }
            }
        );
        
        this.vista.btnInventario.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                ControladorInventario controlador = new ControladorInventario(new frmInventario());
                controlador.iniciar();
                vista.dispose();
            }
        }
        );
        
        this.vista.btnSalir.addActionListener( new ActionListener() {
                public void actionPerformed(ActionEvent e){
                    ControladorSistema controlador = new ControladorSistema(Repositorio.usuarios,Repositorio.administradores, new frmSistema() );
                    controlador.iniciar();
                    vista.dispose();
                }
            }
        );
    } 
    
    public void iniciar(){
        this.vista.setLocationRelativeTo(null);
        this.vista.setVisible(true);
        this.vista.lblUsuario.setText(modelo.getAdministrador());
    }
}
