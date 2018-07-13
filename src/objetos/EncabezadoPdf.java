/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetos;

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
    private final Integer numero;
    private final String cuit;
    private final String ingresosBrutos;
    private final String inicioActividades;
    private final String condicionIva;

    public EncabezadoPdf(int punto, Integer numero) {
        this.punto = punto;
        this.numero = numero;
        this.nombreComercio="BAMBUSOFT";
        this.razonSocial="Mauro Di";
        this.direccion="Alberti 1479, Santa Fe";
        this.telefono="0342-4600332";
        this.cuit="20-22905383-4";
        this.ingresosBrutos="011-13150619513";
        this.inicioActividades="01/10/2013";
        this.condicionIva="Responsable Monotributo";
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

    public Integer getNumero() {
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
