
package Controlador;

import Datos.Repositorio;
import Modelo.Administrador;
import Modelo.AdministradorArreglo;
import Modelo.Usuario;
import Modelo.UsuarioArreglo;
import Vista.frmPrincipalUser;
import Vista.frmPrincipalAdmin;
import Vista.frmSistema;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;


public class ControladorSistema {
    private frmSistema vista;
    private UsuarioArreglo modelousuario;
    private AdministradorArreglo modeloadministrador;
    
    
    public ControladorSistema(UsuarioArreglo modelousuario,AdministradorArreglo modeloadministrador, frmSistema vista) {
        this.vista = vista;
        this.modelousuario=modelousuario;
        this.modeloadministrador=modeloadministrador;
        
        this.vista.btnIngresar.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e){
                    Usuario u = modelousuario.ingresar( vista.txtUsuario.getText(),vista.txtContraseña.getText());
                    Administrador a = modeloadministrador.ingresar( vista.txtUsuario.getText(),vista.txtContraseña.getText());
                    if(a != null){
                        Repositorio.administrador_validado = a;
                        ControladorPrincipalAdmin controladoradmin = new ControladorPrincipalAdmin( a, new frmPrincipalAdmin() );
                        controladoradmin.iniciar();
                        vista.dispose();
                     }else if(u != null){
                        Repositorio.usuario_validado = u;
                        ControladorPrincipalUser controladoruser = new ControladorPrincipalUser( u, new frmPrincipalUser() );
                        controladoruser.iniciar();
                        vista.dispose();
                    }else{
                        vista.txtContraseña.setText("");
                        JOptionPane.showMessageDialog(vista, "Intente nuevamente");
                    }
                }
            }
        );
        
        this.vista.btnSalir.addActionListener( new ActionListener() {
                public void actionPerformed(ActionEvent e){
                    System.exit(0); 
                }
            }
        );
    }
    
    public void iniciar(){
        this.vista.setLocationRelativeTo(null);
        this.vista.txtUsuario.setText("");
        this.vista.txtContraseña.setText("");
        this.vista.setVisible(true);
    }
}
