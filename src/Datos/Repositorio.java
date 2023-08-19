
package Datos;

import Modelo.Administrador;
import Modelo.AdministradorArreglo;
import Modelo.DonanteArreglo;
import Modelo.ExtraccionArreglo;
import Modelo.Usuario;
import Modelo.UsuarioArreglo;
import Modelo.SolicitudArreglo;
import java.io.Serializable;

public class Repositorio implements Serializable {
    
    public static UsuarioArreglo usuarios = new UsuarioArreglo(3);
    public static Usuario usuario_validado;
    public static AdministradorArreglo administradores = new AdministradorArreglo(3);
    public static Administrador administrador_validado;
    public static DonanteArreglo donantes = new DonanteArreglo(10);
    public static ExtraccionArreglo extracciones = new ExtraccionArreglo(15);
    public static SolicitudArreglo solicitudes = new SolicitudArreglo(10);
}
