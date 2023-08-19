package Modelo;
import java.io.Serializable;
public class AdministradorArreglo implements Serializable{
    private Administrador[] vec_administrador;
    private int index, dimension;
    private final String[] encabezado =  {"ADMINISTRADOR","CONTRASEÑA"};

    public AdministradorArreglo(int dimension) {
        this.vec_administrador = new Administrador[dimension];
        this.dimension=dimension;
        this.index = 0;
    }
    
    public String[] getEncabezado() {
        return encabezado;
    }
    
    private boolean full() {
        if(this.index == this.vec_administrador.length) 
            return true;
        else 
            return false;
    }
    
    private boolean vacio() {
        if(this.index == 0) 
            return true;
        else 
            return false;
    }
    
    public Object[][] getInfo(){
        Object resultado[][] = new Object[this.index][3];
        if(!vacio()){
            for(int i = 0; i< this.index;i++){
                resultado[i][0] = this.vec_administrador[i].getAdministrador();
                resultado[i][1] = this.vec_administrador[i].getContrasena();
            }
        }
        return resultado;
    }
    
    public Object[][] getAdmin(){
        int c = 0;
        Object resultado[][] = new Object[this.index][3];
        if(!vacio()){
            for(int i = 0; i< vec_administrador.length; i++){
                if(this.vec_administrador[i] instanceof Administrador){
                    resultado[c][0] = this.vec_administrador[i].getAdministrador();
                    resultado[c][1] = this.vec_administrador[i].getContrasena();
                    c++;
                }
            }
        }
        return resultado;
    }
    
    public Administrador[] getInfoCombo(){
        Administrador resultado[]= null;
        if(!vacio()){
            resultado = new Administrador[this.index];
            for(int i = 0; i<this.index; i++){
                resultado[i]= this.vec_administrador[i];
            }
        }
        return resultado;
    }
    
    public boolean agregar(Administrador administrador){
        boolean resultado = false;
        if(!full()){
            this.vec_administrador[index] = administrador;
            index++;
            resultado = true;
        }else{
            redimensionar();
        }
        return resultado;
    }
    
    public void redimensionar(){
        int new_dimension = this.dimension*3;
        Administrador[] nuevoArreglo = new Administrador[new_dimension];
        for(int i=0; i < this.index; i++){
            nuevoArreglo[i] = this.vec_administrador[i];
        }
        this.vec_administrador = nuevoArreglo;
    }
  
    public Administrador ingresar(String admin, String password){
        Administrador resultado = null;
        for( Administrador tmp_admin : this.vec_administrador ){
            if(tmp_admin != null && tmp_admin.ingresar(admin,password)){
                resultado = tmp_admin;
                break;
            }
        }
        return resultado;
    }
}
