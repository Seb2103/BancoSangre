package Modelo;
import java.io.Serializable;

public class Administrador implements Serializable{   
    private String Administrador;
    private String Contrasena;
    
    public Administrador(String Administrador, String Contrasena) {
        this.Administrador = Administrador;
        this.Contrasena = Contrasena;
    }
    
    public String getAdministrador() {
        return Administrador;
    }

    public String getContrasena() {
        return Contrasena;
    }
    
    public void setAdministrador(String Administrador) {
        this.Administrador = Administrador;
    }
    
    public void setContrasena(String Contrasena) {
        this.Contrasena = Contrasena;
    }
    
    public boolean ingresar(String admin, String password){
        boolean result = false;
        if(this.Administrador.equalsIgnoreCase(admin) && 
           this.Contrasena.equals(password))
        {
            result = true;
        }            
        return result; 
    }
}