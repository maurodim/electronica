/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifu.demo;

import interfaces.FacturableE;
import java.io.IOException;
import java.sql.Connection;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import objetos.DetalleFacturas;
import objetos.FacturaElectronica;
import objetos.TiposIva;
import objetos.Tributos;

/**
 *
 * @author amiranda
 */
public class FEAFIPDemo {

    /**
     * @param args the command line arguments
     * condicion-Condicion Iva Vendedor 1 - monotributo 2 - responsable inscripto/exento
     * archivokey- lee de propiedades
     * archivocrt- idem key
     * idcliente-id interno del sistema
     * cuitCliente-numero de cuit del cliente en string
     * tipoD-tipo documento del cliente (80-cuit,96-dni,99-0 para consumidor final)
     * tipoC-tipo comprobante de venta (fcc,fca,fcb,etc)
     * montoT-monto total
     * montoB-monto neto
     * montoI- monto de iva
     * ptoVta- punto de venta del vendedor, aprobado por afip
     * cuitVendedor-lee de propiedades es un string
     * tVta- tipo de venta, si es un producto o servicio
     * listadoI-listado de iva
     * listadoT-listado de tributos
     * razon- razon social del comprador
     * direc- direccion del comprador, incluir localidad
     * condicionIvaC- condicion iva comprador
     * lstDetalle- listado e detalle factura
     * 
     */
    public static void main(String[] args) throws ParseException {
       
        FacturableE factu=new FacturaElectronica();
        /*
        Connection conexion=null;
        int condicion=2;
        String archivoKey="clave.key";
        String archivoCrt="certificado.crt";
        int idCliente=1;
        String cuitCliente="30538872128";
        int tipoD=80;//80- cuit 96- dni
        int tipoC=2;
        Double montoT=120.75;
        Double montoB=100.0;
        Double montoI=15.75;
        int ptoVta=3;
        String cuitVendedor="20229053834";
        int tVta=2;//SI ES SERVICIO=2 O PRODUCTO=1
        ArrayList listadoI=new ArrayList();
        ArrayList listadoT=new ArrayList();
        //listadoI=null;
        //listadoT=null;
        String razon="CONFEDERACION ARGENTINA DE LA MED EMPRESA (CAME)";
        String direc="L. N. ALEM 452 - 1003 CABA";
        String condicionIvaC="3";
        ArrayList <DetalleFacturas> lstDetalle=new ArrayList();
        DetalleFacturas detalle=new DetalleFacturas();
        detalle.setCodigo("1");
        detalle.setDescripcion("en una prueba");
        detalle.setCantidadS("1.0");
        detalle.setPrecioUnitarioS("100.0");
        lstDetalle.add(detalle);
        TiposIva iva=new TiposIva(5,50,10.5f,21);
        listadoI.add(iva);
        iva=new TiposIva(4,50,5.25f,10.5f);
        listadoI.add(iva);
        Tributos tributo=new Tributos(2,"IB Santa Fe",100,5,5);
        listadoT.add(tributo);
        double cuit=20229053834.0;
        
        factu.generar(conexion, condicion, archivoKey, archivoCrt, idCliente, cuitCliente, tipoD, tipoC, montoT,montoB,montoI,ptoVta, cuitVendedor,tVta,listadoI,listadoT,razon,direc,condicionIvaC,lstDetalle);
        
        MainFrame mainFrame = new MainFrame();
        mainFrame.setVisible(true);
        mainFrame.setSize(600, 400);
*/
       factu.solicitarCertificado("20229053834.0");
    }
    
}
