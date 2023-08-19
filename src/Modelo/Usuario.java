package Modelo;
import java.io.Serializable;

public class Usuario implements Serializable{   
    private String Usuario;
    private String Contrasena;
    
    public Usuario(String Usuario, String Contrasena) {
        this.Usuario = Usuario;
        this.Contrasena = Contrasena;
    }
    
    public String getUsuario() {
        return Usuario;
    }

    public String getContrasena() {
        return Contrasena;
    }
    
    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }
    
    public void setContrasena(String Contrasena) {
        this.Contrasena = Contrasena;
    }
    
    public boolean ingresar(String user, String password){
        boolean result = false;
        if(this.Usuario.equalsIgnoreCase(user) && 
           this.Contrasena.equals(password))
        {
            result = true;
        }            
        return result; 
    }
}