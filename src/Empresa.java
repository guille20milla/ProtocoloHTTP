/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Alumno
 */
public class Empresa implements Comparable<Empresa>{
    private String identificador;
    private String nombre;
    private String cambio;
    private String porcentaje;
    private boolean verde;
    
    public Empresa(String i,String n,String c,String p,boolean v){
        this.identificador=i;
        this.nombre=n;
        this.cambio=c;
        this.porcentaje=p;
        this.verde=v;
    }

    /**
     * @return the identificador
     */
    public String getIdentificador() {
        return identificador;
    }

    /**
     * @param identificador the identificador to set
     */
    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the cambio
     */
    public String getCambio() {
        return cambio;
    }

    /**
     * @param cambio the cambio to set
     */
    public void setCambio(String cambio) {
        this.cambio = cambio;
    }

    /**
     * @return the porcentaje
     */
    public String getPorcentaje() {
        return porcentaje;
    }

    /**
     * @param porcentaje the porcentaje to set
     */
    public void setPorcentaje(String porcentaje) {
        this.porcentaje = porcentaje;
    }

    /**
     * @return the verde
     */
    public boolean isVerde() {
        return verde;
    }

    /**
     * @param verde the verde to set
     */
    public void setVerde(boolean verde) {
        this.verde = verde;
    }

    @Override
    public int compareTo(Empresa t) {
        return this.identificador.compareTo(t.identificador);
    }
}
