/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetos;

import Configuracion.Propiedades;

/**
 *
 * @author mauro
 */
public class EncabezadoPdf {
    private final String nombreComercio;
    private final String razonSocial;
    private final String direccion;
    private final String telefono;
    private final int punto;
    private final double numero;
    private final String cuit;
    private final String ingresosBrutos;
    private final String inicioActividades;
    private final String condicionIva;

    public EncabezadoPdf(int punto, double numero) {
        this.punto = punto;
        this.numero = numero;
        this.nombreComercio=Propiedades.getNOMBRECOMERCIO();
        this.razonSocial=Propiedades.getNOMBRECOMERCIO();
        this.direccion=Propiedades.getDIRECCION();
        this.telefono=Propiedades.getTELEFONO();
        this.cuit=Propiedades.getCUIT();
        this.ingresosBrutos=Propiedades.getINGBRUTOS();
        this.inicioActividades=Propiedades.getINICIOACT();
        this.condicionIva="Responsable Inscripto";
    }

    public String getCondicionIva() {
        return condicionIva;
    }
    
    
    public String getNombreComercio() {
        return nombreComercio;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public int getPunto() {
        return punto;
    }

    public double getNumero() {
        return numero;
    }

    public String getCuit() {
        return cuit;
    }

    public String getIngresosBrutos() {
        return ingresosBrutos;
    }

    public String getInicioActividades() {
        return inicioActividades;
    }
    
}
