
package Modelo;

import java.text.SimpleDateFormat;
import java.util.Date;


public class ExtraccionSangre {
    private static int contador=0;
    private int codigo;
    private Date Fecha;
    private float Volumen;
    private String GrupoSanguineo;
    private String Rh;
    private SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/YYYY HH:mm");
    private String donante;
    
    public ExtraccionSangre(float Volumen, String GrupoSanguineo, String Rh, String donante) {
        this.codigo=contador;
        contador++;
        this.Fecha=new Date();
        this.Volumen = Volumen;
        this.GrupoSanguineo = GrupoSanguineo;
        this.Rh = Rh;
        this.donante = donante;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    public String getFecha() {
        return sdf.format(Fecha);
    }

    public void setFecha(Date Fecha) {
        this.Fecha = Fecha;
    }

    public float getVolumen() {
        return Volumen;
    }

    public void setVolumen(float Volumen) {
        this.Volumen = Volumen;
    }

    public String getGrupoSanguineo() {
        return GrupoSanguineo;
    }

    public void setGrupoSanguineo(String GrupoSanguineo) {
        this.GrupoSanguineo = GrupoSanguineo;
    }

    public String getRh() {
        return Rh;
    }

    public void setRh(String Rh) {
        this.Rh = Rh;
    }

    public String getDonante() {
        return donante;
    }

    public void setDonante(String donante) {
        this.donante = donante;
    }

}
