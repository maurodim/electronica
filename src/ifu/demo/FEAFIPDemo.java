/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifu.demo;

import interfaces.FacturableE;
import java.sql.Connection;
import java.util.ArrayList;
import objetos.DetalleFacturas;
import objetos.FacturaElectronica;
import objetos.GenerarQr;

/**
 *
 * @author amiranda
 */
public class FEAFIPDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        FacturableE factu=new FacturaElectronica();
        Connection conexion=null;
        int condicion=1;
        String archivoKey="clave.key";
        String archivoCrt="certificado.crt";
        int idCliente=1;
        String cuitCliente="30538872128";
        int tipoD=80;//80- cuit 96- dni
        int tipoC=12;
        Double montoT=1.0;
        Double montoB=1.0;
        Double montoI=0.0;
        int ptoVta=3;
        String cuitVendedor="20229053834";
        int tVta=2;//SI ES SERVICIO O PRODUCTO
        ArrayList listadoI=new ArrayList();
        ArrayList listadoT=new ArrayList();
        listadoI=null;
        listadoT=null;
        String razon="CONFEDERACION ARGENTINA DE LA MED EMPRESA (CAME)";
        String direc="L. N. ALEM 452 - 1003 CABA";
        String condicionIvaC="3";
        ArrayList <DetalleFacturas> lstDetalle=new ArrayList();
        DetalleFacturas detalle=new DetalleFacturas();
        detalle.setIdArticulo(1);
        detalle.setDescripcionArticulo("en una prueba");
        detalle.setCantidad(1.0);
        detalle.setPrecioUnitario(1.0);
        lstDetalle.add(detalle);
        double cuit=2022905383.0;
        //String cuitClien=Float.toString((float) 20229053834.0);
        //GenerarQr qr=new GenerarQr(condicion+idCliente+cuitCliente+tipoD+tipoC+montoT+montoB+montoI+ptoVta+cuitVendedor+tVta+razon+direc+condicionIvaC);
        //System.out.println(Float.toString(cuit)+" convertido: "+cuitClien);
        factu.generar(conexion, condicion, archivoKey, archivoCrt, idCliente, cuitCliente, tipoD, tipoC, montoT,montoB,montoI,ptoVta, cuitVendedor,tVta,listadoI,listadoT,razon,direc,condicionIvaC,lstDetalle);
        /*
        MainFrame mainFrame = new MainFrame();
        mainFrame.setVisible(true);
        mainFrame.setSize(600, 400);
*/
    }
    
}
