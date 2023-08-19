
package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Modelo.*;
import Vista.*;
import Datos.*;


public class ControladorPrincipalUser {
    private frmPrincipalUser vista;
    private Usuario modelo;
    
    
    public ControladorPrincipalUser(Usuario modelo, frmPrincipalUser vista) {
        this.modelo = modelo;
        this.vista = vista;
        
        this.vista.btnDonantes.addActionListener(new ActionListener(){
            public void actionPerformed (ActionEvent e){
                ControladorRegistrarDonantes controlador = new ControladorRegistrarDonantes (new frmDonantes(), Repositorio.donantes);
                controlador.iniciar();
                vista.dispose();
                }
            }
        );
        
        this.vista.btnSolicitud.addActionListener(new ActionListener(){
            public void actionPerformed (ActionEvent e){
                ControladorSolicitud controlador = new ControladorSolicitud (new frmSolicitud(), Repositorio.solicitudes);
                controlador.iniciar();
                vista.dispose();
                }
            }
        );
        
        this.vista.btnExtraccion.addActionListener(new ActionListener(){
            public void actionPerformed (ActionEvent e){
                ControladorExtraccion controlador = new ControladorExtraccion (new frmExtraccion(), Repositorio.extracciones);
                controlador.iniciar();
                vista.dispose();
                }
            }
        );       
        this.vista.btnSalir.addActionListener( new ActionListener() {
                public void actionPerformed(ActionEvent e){
                    ControladorSistema controlador = new ControladorSistema( Repositorio.usuarios,Repositorio.administradores, new frmSistema() );
                    controlador.iniciar();
                    vista.dispose();
                }
            }
        );

    } 
    
    public void iniciar(){
        this.vista.setLocationRelativeTo(null);
        this.vista.setVisible(true);
        this.vista.lblUsuario.setText(modelo.getUsuario());
    }

    
}
