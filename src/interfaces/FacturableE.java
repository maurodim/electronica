/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mauro di
 */
public interface FacturableE {
    public Object recuperar(Object Fe);
    public Integer guardar(Object Fe);
    public Object modificar(Object Fe);
    public ArrayList listarPorEstado(Integer estado);
    public Object cargar(Integer id);
    public DefaultTableModel mostrarListado(ArrayList listado);
    public Object reEnviar(Object fe);
    public void eliminar(Object fe);
    public String reimprimir(Object fe);
    public String imprimir(Object fe);
    public Integer generar(Connection conexion,int Condicion,String archivoKey,String archivoCrt,Integer idCliente,String cuitCliente,int tipoDocumentoCliente,int tipoComprobante,Double montoTotal,Double montoBruto,Double montoIva,int ptoDeVenta,String cuitVendedor,int tipoVenta,ArrayList ivas,ArrayList tributos);
}
