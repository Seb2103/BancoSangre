
package Main;

import Controlador.ControladorSistema;
import Datos.Repositorio;
import Modelo.ConsultasAdministrador;
import Modelo.ConsultasUsuarios;
import Vista.frmSistema;

public class SABS {
    public static void main(String[] args) {
        ConsultasUsuarios cU = new ConsultasUsuarios();
        cU.llenar();
        ConsultasAdministrador cA = new ConsultasAdministrador();
        cA.llenar();
        ControladorSistema controlador = new ControladorSistema(Repositorio.usuarios,Repositorio.administradores, new frmSistema());
        controlador.iniciar();
    }
}
