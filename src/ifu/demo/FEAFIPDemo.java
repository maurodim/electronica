/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifu.demo;

import interfaces.FacturableE;
import java.sql.Connection;
import java.util.ArrayList;
import objetos.FacturaElectronica;

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
        int condicion=2;
        String archivoKey="clave.key";
        String archivoCrt="sistema.crt";
        int idCliente=1;
        String cuitCliente="30538872128";
        int tipoD=80;//80- cuit 96- dni
        int tipoC=1;
        Double montoT=10.0;
        Double montoB=10.0;
        Double montoI=0.0;
        int ptoVta=3;
        String cuitVendedor="20229053834";
        int tVta=2;//SI ES SERVICIO O PRODUCTO
        ArrayList listadoI=new ArrayList();
        ArrayList listadoT=new ArrayList();
        listadoI=null;
        listadoT=null;
        factu.generar(conexion, condicion, archivoKey, archivoCrt, idCliente, cuitCliente, tipoD, tipoC, montoT,montoB,montoI,ptoVta, cuitVendedor,tVta,listadoI,listadoT);
        /*
        MainFrame mainFrame = new MainFrame();
        mainFrame.setVisible(true);
        mainFrame.setSize(600, 400);
*/
    }
    
}
