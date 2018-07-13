package objetos;



import conversiones.Numeros;
import feafip.bi.ClassFactory;
import feafip.bi.IContribuyente;
import feafip.bi.Iwsfev1;
import feafip.bi.TipoComprobante;
import interfaces.FacturableE;
import interfaces.Instalable;
import java.math.BigDecimal;
import java.sql.Connection;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;






public class FacturaElectronica implements FacturableE,Instalable{
    private String valor;
    private String resultado;
    private String respuesta;
    private String cae;
    private String caeVto;
    private String fechaCae;
    private String afipQty;
    private String afipPlastId;
    private String afipPlastCbte;
    private Integer id;
    private Integer idFactura;
    private Integer idCliente;
    private String fecha;
    private String customerId;
    private String customerTypeDoc;
    private String tipoComprobante;
    private Double importeTotal;
    private Double importeNeto;
    private Double impuestoLiquido;
    private String condVta;
    private Integer estado;
    private Connection conexion;
    private String archivoKey;
    private String archivoCrt;
    private String condicionIvaVendedor;
    private int numeroPuntoDeVenta;
    private int tipoCompro;
    private TipoComprobante tipoComp;
    private String cuitVendedor;
    private int tipoVta;
    private ArrayList listadoIva;
    private ArrayList listadoTributos;
    private String razonSocial;
    private String direccionCliente;
    private String condicionIvaCliente;
    private ArrayList listadoDetalle;

    public ArrayList getListadoDetalle() {
        return listadoDetalle;
    }
    
    
    public String getCondicionIvaCliente() {
        return condicionIvaCliente;
    }
    

    public int getNumeroPuntoDeVenta() {
        return numeroPuntoDeVenta;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public String getDireccionCliente() {
        return direccionCliente;
    }
    
    
    
    
    

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    
    public String getCondVta() {
        return condVta;
    }

    public void setCondVta(String condVta) {
        this.condVta = condVta;
    }

    
    public Integer getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(Integer idFactura) {
        this.idFactura = idFactura;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerTypeDoc() {
        return customerTypeDoc;
    }

    public void setCustomerTypeDoc(String customerTypeDoc) {
        this.customerTypeDoc = customerTypeDoc;
    }

    public String getTipoComprobante() {
        return tipoComprobante;
    }

    public void setTipoComprobante(String tipoComprobante) {
        this.tipoComprobante = tipoComprobante;
    }

    public Double getImporteTotal() {
        return importeTotal;
    }

    public void setImporteTotal(Double importeTotal) {
        this.importeTotal = importeTotal;
    }

    public Double getImporteNeto() {
        return importeNeto;
    }

    public void setImporteNeto(Double importeNeto) {
        this.importeNeto = importeNeto;
    }

    public Double getImpuestoLiquido() {
        return impuestoLiquido;
    }

    public void setImpuestoLiquido(Double impuestoLiquido) {
        this.impuestoLiquido = impuestoLiquido;
    }
    
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    
    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public String getCae() {
        return cae;
    }

    public void setCae(String cae) {
        this.cae = cae;
    }

    public String getCaeVto() {
        return caeVto;
    }

    public void setCaeVto(String caeVto) {
        this.caeVto = caeVto;
    }

    public String getFechaCae() {
        return fechaCae;
    }

    public void setFechaCae(String fechaCae) {
        this.fechaCae = fechaCae;
    }

    public String getAfipQty() {
        return afipQty;
    }

    public void setAfipQty(String afipQty) {
        this.afipQty = afipQty;
    }

    public String getAfipPlastId() {
        return afipPlastId;
    }

    public void setAfipPlastId(String afipPlastId) {
        this.afipPlastId = afipPlastId;
    }

    public String getAfipPlastCbte() {
        return afipPlastCbte;
    }

    public void setAfipPlastCbte(String afipPlastCbte) {
        this.afipPlastCbte = afipPlastCbte;
    }
    
    
    private Integer guardarEnFiscal(){
        String fecha=Numeros.ConvertirFechaFiscal();
               /*
               String tipo=String.valueOf(comp.getTipoComprobanteFiscal());
               String numero=String.valueOf(numeroComprobante);
               comp.setMontoBruto(comp.getMontoTotal() / 1.21);
               comp.setMontoIva(comp.getMontoTotal() - comp.getMontoBruto());
               int tipoClienteId=0;
               if(comp.getTipoComprobante()==11){
                   tipoClienteId=99;
               }else{
                   tipoClienteId=80;
               }
               String razonS=comp.getCliente().getRazonSocial();
               String cuit=comp.getCliente().getNumeroDeCuit();
               if(cuit.equals("1"))cuit="0";
               sql="insert into fiscal (fecha,tipo,numero,gravado,impuesto,total,idcliente,tipoClienteId,razon,cuit) values (lpad("+fecha+",8,'0'),'"+tipo+"','"+numero+"',"+comp.getMontoBruto()+","+comp.getMontoIva()+","+comp.getMontoTotal()+","+comp.getCliente().getCodigoId()+","+tipoClienteId+",'"+razonS+"','"+cuit+"')";
               System.out.println("fiscal: "+sql);
               tra.guardarRegistro(sql);
        */
               return 0;
    }
    private Object leer(){
        // Los nombres de los parametros de las funciones se obtienen en FEAFIP.pdf
        
        //URLs de autenticacion y negocio. Cambiarlas por las de producción al implementarlas en el cliente(abajo)
        String URLWSAA = "https://wsaa.afip.gov.ar/ws/services/LoginCms";//"https://wsaahomo.afip.gov.ar/ws/services/LoginCms";
          // Producción: https://wsaa.afip.gov.ar/ws/services/LoginCms
        String URLWSW = "https://servicios1.afip.gov.ar/wsfev1/service.asmx";//"https://wswhomo.afip.gov.ar/wsfev1/service.asmx";
          // Producción: https://servicios1.afip.gov.ar/wsfev1/service.asmx
        double nro;

        int ptoVta = this.numeroPuntoDeVenta; // ATENCION! SI RECIBE UN ERROR DE FECHA O NUMERO DE COMPROBANTE EN ESTA DEMO CAMBIE ESTE VALOR POR OTRO DE 1 A 9999
        
        tipoComp = TipoComprobante.tcFacturaC; // Factura A(Ver excel referencias codigos AFIP)
        
        
        
        Format formatter = new SimpleDateFormat("yyyyMMdd");
        String FechaComp = formatter.format(new Date());
         
        Iwsfev1 wsfev1 = ClassFactory.createwsfev1();
        double cuitV= Double.parseDouble("20229053834");
        double cuitC=Double.parseDouble(this.customerId);
        int customerTD=Integer.parseInt(this.customerTypeDoc);
        String montoT=String.valueOf(this.importeTotal);
        String montoN=String.valueOf(this.importeNeto);
        String montoI=String.valueOf(this.impuestoLiquido);
        //wsfev1.cuit(20229053834.0);  // Cuit del vendedor
        wsfev1.cuit(cuitV);
        //i BigDecimal roundFinalPrice=new BigDecimal(cuitV).setScale(2,BigDecimal.ROUND_HALF_UP);
        //String cuitClien=roundFinalPrice.toPlainString();
        
        //JOptionPane.showMessageDialog(null,"Fecha "+FechaComp);
        wsfev1.url(URLWSW);
        System.out.println(URLWSW+" wsaa "+URLWSAA);
        if (wsfev1.login(this.archivoCrt, this.archivoKey, URLWSAA)){
            if (!wsfev1.sfRecuperaLastCMP(ptoVta, tipoComp.comEnumValue())) {
                JOptionPane.showMessageDialog(null,wsfev1.errorDesc());
            } else {
                nro = wsfev1.sfLastCMP() + 1;
                wsfev1.reset();
                if(this.condicionIvaVendedor.equals("2")){
                    wsfev1.agregaFactura(this.tipoVta,customerTD, cuitC, nro, nro, FechaComp, this.importeTotal, 0,this.importeNeto, 0, "", "", "", "PES", 1);
                    //wsfev1.agregaFactura(2, 99,0.0, nro, nro, FechaComp, 1.5, 0, 1.5, 0, FechaComp, FechaComp, FechaComp, "PES", 1);
                    
                    
                    TiposIva tipoI;
                    Tributos tributos;
                    if(this.listadoIva !=null){
                        Iterator itI=this.listadoIva.listIterator();
                        while(itI.hasNext()){
                            tipoI=(TiposIva) itI.next();
                            wsfev1.agregaIVA(tipoI.getId(),tipoI.getBaseImponible(),tipoI.getImporte()); // Ver Excel de referencias de codigos AFIP
                            //wsfev1.agregaIVA(1, 0,0); // Ver Excel de referencias de codigos AFIP
                        }
                    }
                    if(this.listadoTributos !=null){
                        Iterator itT=this.listadoTributos.listIterator();
                        while(itT.hasNext()){
                            tributos=(Tributos) itT.next();
                            wsfev1.agregaTributo(tributos.getId(),tributos.getDescripcion(),tributos.getBaseImponible(),tributos.getAlicuota(),tributos.getImporte());
                        }
                    }
                }else{
                    wsfev1.agregaFactura(this.tipoVta,customerTD, cuitC, nro, nro, FechaComp, this.importeTotal, 0,this.importeNeto, 0, FechaComp,FechaComp,FechaComp, "PES", 1);
                }
                if (!wsfev1.autorizar(ptoVta, (TipoComprobante)tipoComp)){
                    JOptionPane.showMessageDialog(null,wsfev1.errorDesc());
                } else {
                    if (wsfev1.sfResultado(0).equals("A")) {
                        JOptionPane.showMessageDialog(null,"Felicitaciones! Si ve este mensaje instalo correctamente FEAFIP. CAE y Vencimiento: " + wsfev1.sfcae(0) + " " + wsfev1.sfVencimiento(0)+" numero comprobante "+nro);
                        this.cae=wsfev1.sfcae(0);
                        this.caeVto=wsfev1.sfVencimiento(0);
                        String num=String.valueOf(nro);
                        int nume=num.length();
                        nume=nume-2;
                        num=num.substring(0,nume);
                        this.afipPlastId=num;
                        this.afipPlastCbte=num;
                        this.tipoComprobante=String.valueOf((TipoComprobante)tipoComp);
                        this.fechaCae=FechaComp;
                        
                        //IContribuyente iContribuyente=ClassFactory.createContribuyente();
                        //System.out.println(iContribuyente.condicionIVADesc()+" numero iva "+iContribuyente.condicionIVA().comEnumValue());
                        this.estado=1;
                        //ACA DEBERÍA PASAR LOS VALORES A PDF PARA QUE SE GENERE LA FACTURA
                        
                        pdfsJavaGenerador pdf=new pdfsJavaGenerador();
                        pdf.setDoc(this);
                        pdf.setPunto(this.numeroPuntoDeVenta);
                        pdf.setNumero(nro);
                        pdf.run();
                        return nro;
                        //return this.guardarEnFiscal();
                    } else {
                        JOptionPane.showMessageDialog(null,wsfev1.autorizarRespuestaObs(0));
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(null,wsfev1.errorDesc());
        }
        
        
        
        
        
        
        
        
        
        /*
        Comprobantes compro=new Comprobantes();
        compro=(Comprobantes)comp;
        FacturaElectronica fE=new FacturaElectronica();
        if(Propiedades.getCONDICION().equals("2")){
        URL url = new URL("https://tufacturaelectronica.net/api/v1/FE");
        String charSet="UTF-8";
        String tipo="xml";
        String key=Propiedades.getKEY();
        String cuit=compro.getCliente().getNumeroDeCuit().trim();
        Integer codigoIdCliente=compro.getCliente().getCodigoId();
        Integer tipDocumento=0;
        Integer tipComprobante=0;
        
        String idCliente=compro.getCliente().getNumeroDeCuit();
        fE.setEstado(compro.getPagado());
        if(idCliente.length() == 8 || idCliente.length()==11){
            
        }else{
            
            idCliente=JOptionPane.showInputDialog(null,"Ingrese numero de CUIT/CUIL o DNI Sin puntos ni guiones ",idCliente);
            if(idCliente.equals("0")){
                idCliente="00000000";
            }
        }
        idCliente=idCliente.replace("-","");
        idCliente=idCliente.trim();
        Integer cantCuit=idCliente.length();
        switch(cantCuit){
            case 11:
                if(compro.getTipoComprobante()==2)tipDocumento=80;
                if(compro.getTipoComprobante()==10)tipDocumento=80;
                if(compro.getTipoComprobante()==8)tipDocumento=80;
                if(compro.getTipoComprobante()==3)tipDocumento=80;
                if(compro.getTipoComprobante()==1)tipDocumento=86;
                break;
            case 8:
                tipDocumento=96;
                break;
            case 7:
                tipDocumento=96;
                break;
        }
        String tipoDocumento=String.valueOf(tipDocumento);
        System.out.println();
        if(Propiedades.getCONDICION().equals("2")){
            if(compro.getTipoComprobante()==1)tipComprobante=6;//factura B a consumidor final
            if(compro.getTipoComprobante()==2)tipComprobante=1;//1 FACTURA A 
            if(compro.getTipoComprobante()==9)tipComprobante=2;//2
            if(compro.getTipoComprobante()==10)tipComprobante=3;//3 NOTA DE CREDITO A
            if(compro.getTipoComprobante()==11)tipComprobante=7;
            if(compro.getTipoComprobante()==12)tipComprobante=8;
            if(compro.getTipoComprobante()==8)tipComprobante=8;//NTA DE CREDITO B A CONS FINAL y exento
            if(compro.getTipoComprobante()==3)tipComprobante=6;// factura B A EXENTO
        }else{
            if(compro.getTipoComprobante()==1)tipComprobante=11;
            if(compro.getTipoComprobante()==2)tipComprobante=11;//1
            if(compro.getTipoComprobante()==9)tipComprobante=12;//2
            if(compro.getTipoComprobante()==10)tipComprobante=13;//3
            if(compro.getTipoComprobante()==11)tipComprobante=12;
            if(compro.getTipoComprobante()==12)tipComprobante=13;
        }
        String tipoComprobante=String.valueOf(tipComprobante);
        System.out.println(tipComprobante);
        
        String importeTotal;
        String importeNeto;
        String importeEx="0.0";
        String impuestoLiq;
        if(tipoComprobante.equals("8")|| tipoComprobante.equals("3")){
            importeTotal=String.valueOf((compro.getMontoTotal() * -1));
            importeNeto=String.valueOf((compro.getMontoBruto() * -1));
            impuestoLiq=String.valueOf((compro.getMontoIva() * -1));
        }else{
            importeTotal=String.valueOf(compro.getMontoTotal());
            importeNeto=String.valueOf(compro.getMontoBruto());
            
            impuestoLiq=String.valueOf(compro.getMontoIva());
        }
        
        
        
        HttpURLConnection con = (HttpURLConnection)url.openConnection();
        Authenticator au = new Authenticator() {
         @Override
         protected PasswordAuthentication
            getPasswordAuthentication() {
            return new PasswordAuthentication
               ("mauro@bambusoft.com.ar", "SUtter001".toCharArray());
         }
      };
      Authenticator.setDefault(au);
      con.setDoOutput(true);
      con.setRequestMethod("POST");
      try{
      OutputStreamWriter out=new OutputStreamWriter(
      con.getOutputStream());
      
      out.write("TYPE="+tipo);
      out.write("&PUBLIC_KEY="+key);
      out.write("&CUSTOMERID="+idCliente);
      out.write("&CUSTOMERTYPEDOC="+tipoDocumento);
      out.write("&TIPO_COMPROBANTE="+tipoComprobante);
      out.write("&IMPORTE_TOTAL="+importeTotal);
      out.write("&IMPORTE_NETO="+importeNeto);
      out.write("&IMP_OP_EX="+importeEx);
      out.write("&IMPTO_LIQ="+impuestoLiq);
      out.close();
      
      BufferedReader in=new BufferedReader(new InputStreamReader(con.getInputStream()));
      String response;
      String cadena="";
      while((response=in.readLine())!=null){
          System.out.println("cadena "+response);
          cadena=response;
      }
          
                  
      //String cadena=response;
      //in.close();
      
      DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
        DocumentBuilder db=dbf.newDocumentBuilder();
        //System.err.println(cadena);
        InputSource archivo=new InputSource();
        
        archivo.setCharacterStream(new StringReader(cadena));
        Document documento=db.parse(archivo);
        //Document documento=db.parse(response);
        documento.getDocumentElement().normalize();
        org.w3c.dom.NodeList nodeLista=documento.getElementsByTagName("AFIP");
        int cantidad=nodeLista.getLength();
        System.out.println("Informacion de conecciones");
        
        for (int s = 0; s < cantidad; s++) {
            
	Node primerNodo = nodeLista.item(s);
	String titulo;
	String autor;
	String hits;
        System.err.println("numero nodo "+s);
        
	if (primerNodo.getNodeType() == Node.ELEMENT_NODE) {

	Element primerElemento = (Element) primerNodo;
        //Configuracion conf=new Configuracion();
        
	        org.w3c.dom.NodeList primerNombreElementoLista =primerElemento.getElementsByTagName("RESPONSE");
	Element primerNombreElemento =(Element) primerNombreElementoLista.item(0);
	        org.w3c.dom.NodeList primerNombre = primerNombreElemento.getChildNodes();
	 fE.setRespuesta(((Node) primerNombre.item(0)).getNodeValue().toString());
	System.out.println("respuesta : "  + fE.getRespuesta());
        //conf.setNombreConeccion(nombreConeccion);
	        org.w3c.dom.NodeList segundoNombreElementoLista =primerElemento.getElementsByTagName("CAE");
	Element segundoNombreElemento =(Element) segundoNombreElementoLista.item(0);
	        org.w3c.dom.NodeList segundoNombre = segundoNombreElemento.getChildNodes();

	fE.setCae(((Node) segundoNombre.item(0)).getNodeValue().toString());
	System.out.println("cae : "  + fE.getCae());
        //conf.setStringDeUrl(stringDeUrl);
	        org.w3c.dom.NodeList tercerNombreElementoLista =primerElemento.getElementsByTagName("CAE_VTO");
	Element tercerNombreElemento =(Element) tercerNombreElementoLista.item(0);
	        org.w3c.dom.NodeList tercerNombre = tercerNombreElemento.getChildNodes();
    	fE.setCaeVto(((Node) tercerNombre.item(0)).getNodeValue().toString());
	System.out.println("cae vencimiento : "  + fE.getCaeVto());
        //conf.setUsuario(usuario);
        org.w3c.dom.NodeList cuartoNombreElementoLista =primerElemento.getElementsByTagName("FECHA_CAE");
	Element cuartoNombreElemento =(Element) cuartoNombreElementoLista.item(0);
	        org.w3c.dom.NodeList cuartoNombre = cuartoNombreElemento.getChildNodes();
    	fE.setFechaCae(((Node) cuartoNombre.item(0)).getNodeValue().toString());
	System.out.println("fecha cae : "  + fE.getFechaCae());
        //conf.setUsuario(usuario);
        org.w3c.dom.NodeList quintoNombreElementoLista =primerElemento.getElementsByTagName("AFIPQTY");
	Element quintoNombreElemento =(Element) quintoNombreElementoLista.item(0);
	        org.w3c.dom.NodeList quintoNombre = quintoNombreElemento.getChildNodes();
    	fE.setAfipQty(((Node) quintoNombre.item(0)).getNodeValue().toString());
	System.out.println("afipqty : "  + fE.getAfipQty());
        //conf.setUsuario(usuario);
        org.w3c.dom.NodeList sextoNombreElementoLista =primerElemento.getElementsByTagName("AFIPLASTID");
	Element sextoNombreElemento =(Element) sextoNombreElementoLista.item(0);
	        org.w3c.dom.NodeList sextoNombre = sextoNombreElemento.getChildNodes();
    	fE.setAfipPlastId(((Node) sextoNombre.item(0)).getNodeValue().toString());
        int comprobanteId=Integer.parseInt(fE.getAfipPlastId());
        fE.setAfipPlastId(String.valueOf(comprobanteId));
	System.out.println("afipplastid : "  + fE.getAfipPlastId());
        //conf.setUsuario(usuario);
        org.w3c.dom.NodeList septimoNombreElementoLista =primerElemento.getElementsByTagName("AFIPLASTCBTE");
	Element septimoNombreElemento =(Element) septimoNombreElementoLista.item(0);
	        org.w3c.dom.NodeList septimoNombre = septimoNombreElemento.getChildNodes();
    	fE.setAfipPlastCbte(((Node) septimoNombre.item(0)).getNodeValue().toString());
        int comprobanteN=Integer.parseInt(fE.getAfipPlastCbte()) + 1;
        fE.setAfipPlastCbte(String.valueOf(comprobanteN));
	System.out.println("afipplastcbte : "  + fE.getAfipPlastCbte());
        //conf.setClave(clave);
        //listadoConecciones.add(conf);
        
	}
        }
        in.close();
        }catch(java.net.UnknownHostException ex){
          Logger.getLogger(FacturaElectronica.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("En factura electronica: "+ex);
            fE.setRespuesta("ERROR");
        }catch(java.lang.NullPointerException ey){
          Logger.getLogger(FacturaElectronica.class.getName()).log(Level.SEVERE, null, ey);
            System.err.println("Parametros invalidos: "+ey);
            fE.setRespuesta("PARAMETROS");  
        }
        
        fE.setIdFactura(compro.getIdFactura());
        fE.setIdCliente(codigoIdCliente);
        fE.setCustomerId(idCliente);
        fE.setCustomerTypeDoc(tipoDocumento);
        fE.setTipoComprobante(tipoComprobante);
        fE.setImporteTotal(importeTotal);
        fE.setImporteNeto(importeNeto);
        fE.setImpuestoLiquido(impuestoLiq);
        //fE.setFecha(fE.getFechaCae());
        //fE.setEstado(1);
        fE.setId(guardar(fE));
        
        }
        if(Propiedades.getCONDICION().equals("1")){
            ComprobanteC comC=new ComprobanteC();
            fE=(FacturaElectronica) comC.leer(comp);
            
        }
        */
      return this;
    }

    @Override
    public Object recuperar(Object Fe) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer guardar(Object Fe) {
        Integer id=0;
        /*
        Transaccionable tra=new Conecciones();
        FacturaElectronica ffE=new FacturaElectronica();
        ffE=(FacturaElectronica)Fe;
        Integer estado=0;
        //Integer id=0;
        estado=ffE.getEstado();
        //if(ffE.getRespuesta().equals("OK"))estado=1;
        String sql="insert into facturaelectronica (cae,cae_vto,fecha_cae,afipqty,afipplastid,afipplastcbte,idfactura,idcliente,estado,customerid,customertypedoc,tipo_comprobante,importe_total,importe_neto,impto_liq) values ('"+ffE.getCae()+"','"+ffE.getCaeVto()+"','"+ffE.getFechaCae()+"','"+ffE.getAfipQty()+"','"+ffE.getAfipPlastId()+"','"+ffE.getAfipPlastCbte()+"',"+ffE.getIdFactura()+","+ffE.getIdCliente()+","+estado+",'"+ffE.getCustomerId()+"','"+ffE.getCustomerTypeDoc()+"','"+ffE.getTipoComprobante()+"','"+ffE.getImporteTotal()+"','"+ffE.getImporteNeto()+"','"+ffE.getImpuestoLiquido()+"')";
        System.out.println(sql);
        tra.guardarRegistro(sql);
        sql="select LAST_INSERT_ID()";
        ResultSet rs=tra.leerConjuntoDeRegistros(sql);
        try {
            while(rs.next()){
                id=rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FacturaElectronica.class.getName()).log(Level.SEVERE, null, ex);
        }
        */        
        return id;
    }

    @Override
    public Object modificar(Object Fe) {
        FacturaElectronica fE=new FacturaElectronica();
        /*
        fE=(FacturaElectronica)Fe;
        String sql="update facturaelectronica set cae='"+fE.getCae()+"',cae_vto='"+fE.getCaeVto()+"',fecha_cae='"+fE.getFechaCae()+"',afipqty='"+fE.getAfipQty()+"',afipplastid='"+fE.getAfipPlastId()+"',afipplastcbte='"+fE.getAfipPlastCbte()+"', estado=1 where id="+fE.getId();
        Transaccionable tra=new Conecciones();
        tra.guardarRegistro(sql);
        */
        return fE;
    }

    @Override
    public ArrayList listarPorEstado(Integer estado) {
        ArrayList listado=new ArrayList();
        
        /*
        String sql="select * from facturaelectronica order by id desc";
        Transaccionable tra=new Conecciones();
        ResultSet rs=tra.leerConjuntoDeRegistros(sql);
        FacturaElectronica factE;
        try {
            while(rs.next()){
                factE=new FacturaElectronica();
                factE.setId(rs.getInt("id"));
                factE.setCae(rs.getString("cae"));
                factE.setCaeVto(rs.getString("cae_vto"));
                factE.setFechaCae(rs.getString("fecha_cae"));
                factE.setAfipQty(rs.getString("afipqty"));
                factE.setAfipPlastId(rs.getString("afipplastid"));
                factE.setAfipPlastCbte(rs.getString("afipplastcbte"));
                factE.setIdFactura(rs.getInt("idfactura"));
                factE.setIdCliente(rs.getInt("idcliente"));
                factE.setFecha(rs.getString("fecha"));
                factE.setCustomerId(rs.getString("customerid"));
                factE.setCustomerTypeDoc(rs.getString("customertypedoc"));
                factE.setTipoComprobante(rs.getString("tipo_comprobante"));
                factE.setImporteTotal(rs.getString("importe_total"));
                factE.setImporteNeto(rs.getString("importe_neto"));
                factE.setImpuestoLiquido(rs.getString("impto_liq"));
                factE.setEstado(rs.getInt("estado"));
                if(rs.getInt("estado")==1){
                    factE.setRespuesta("OK");
                }else{
                    factE.setRespuesta("ERROR");
                }
                listado.add(factE);
                
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(FacturaElectronica.class.getName()).log(Level.SEVERE, null, ex);
        }
        */
        return listado;
    }

    @Override
    public Object cargar(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DefaultTableModel mostrarListado(ArrayList listadoC) {
        DefaultTableModel listado=new DefaultTableModel();
        
        /*
        FacturaElectronica cotizacion;
        ClientesTango cliente;
        Facturar bus=new ClientesTango();
        Facturable ff=new Facturas();
        Facturas factura;
        Iterator iL=listadoC.listIterator();
        listado.addColumn("Fecha");
        listado.addColumn("Cliente");
        listado.addColumn("Nº Factura");
        listado.addColumn("Monto");
        listado.addColumn("Id Afip");
        Object[] fila=new Object[5];
        while(iL.hasNext()){
            cotizacion=(FacturaElectronica)iL.next();
            cliente=new ClientesTango();
            factura=new Facturas();
            fila[0]=String.valueOf(cotizacion.getFecha());
            cliente=(ClientesTango)bus.cargarPorCodigoAsignado(cotizacion.getIdCliente());
            fila[1]=cliente.getRazonSocial();
            fila[2]=cotizacion.getAfipPlastCbte();
            //factura=(Facturas)ff.
            fila[3]=String.valueOf(cotizacion.getImporteTotal());
            fila[4]=cotizacion.getAfipPlastId();
            listado.addRow(fila);
        }
        */
        return listado;
    }

    @Override
    public Object reEnviar(Object fe) {
        FacturaElectronica fE=new FacturaElectronica();
        
        /*
        fE=(FacturaElectronica)fe;
        try {
            
            URL url = new URL("https://tufacturaelectronica.net/api/v1/RETRIEVE");
            String charSet="UTF-8";
            String tipo="xml";
            String key=Propiedades.getKEY().trim();
            //String cuit=compro;
            Integer tipDocumento=0;
            Integer tipComprobante=0;
            
            String idCliente=fE.getCustomerId();
            
            String tipoDocumento=fE.getCustomerTypeDoc();
            
            String tipoComprobante=fE.getTipoComprobante();
            String importeTotal=fE.getImporteTotal();
            String importeNeto=fE.getImporteNeto();
            String importeEx="0.0";
            String impuestoLiq=fE.getImpuestoLiquido();
            
            
            HttpURLConnection con;
            
                con = (HttpURLConnection)url.openConnection();
            
            Authenticator au = new Authenticator() {
                @Override
                protected PasswordAuthentication
                    getPasswordAuthentication() {
                        return new PasswordAuthentication
                       ("mauro@bambusoft.com.ar", "SUtter001".toCharArray());
                    }
            };
            Authenticator.setDefault(au);
            con.setDoOutput(true);
            con.setRequestMethod("POST");
            try{
                OutputStreamWriter out=new OutputStreamWriter(
                        con.getOutputStream());
                
                out.write("TYPE="+tipo);
                out.write("&PUBLIC_KEY="+key);
                out.write("&MODE=PROD");
                out.write("&INVOICEID="+fE.getAfipPlastId());
                
                out.close();
                
                BufferedReader in=new BufferedReader(new InputStreamReader(con.getInputStream()));
                String response;
                String cadena="";
                while((response=in.readLine())!=null){
                    System.out.println(response);
                    if(response.equals("")){
                        
                    }else{
                        cadena=response;
                    }
                }
                
                System.out.println("ASI QUEDA LA CADENA: "+cadena);
                //String cadena=response;
                //in.close();
                
                DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
                DocumentBuilder db=dbf.newDocumentBuilder();
                //System.err.println(cadena);
                InputSource archivo=new InputSource();
                
                archivo.setCharacterStream(new StringReader(cadena));
                Document documento=db.parse(archivo);
                //Document documento=db.parse(response);
                documento.getDocumentElement().normalize();
                org.w3c.dom.NodeList nodeLista=documento.getElementsByTagName("AFIP");
                int cantidad=nodeLista.getLength();
                System.out.println("Informacion de conecciones");
                  
                for (int s = 0; s < cantidad; s++) {
                    
                    Node primerNodo = nodeLista.item(s);
                    String titulo;
                    String autor;
                    String hits;
                    System.err.println("numero nodo "+s);
                    
                    if (primerNodo.getNodeType() == Node.ELEMENT_NODE) {
                        
                        Element primerElemento = (Element) primerNodo;
                        //Configuracion conf=new Configuracion();
                        
                        org.w3c.dom.NodeList primerNombreElementoLista =primerElemento.getElementsByTagName("RESPONSE");
                        Element primerNombreElemento =(Element) primerNombreElementoLista.item(0);
                        org.w3c.dom.NodeList primerNombre = primerNombreElemento.getChildNodes();
                        fE.setRespuesta(((Node) primerNombre.item(0)).getNodeValue().toString());
                        System.out.println("respuesta : "  + fE.getRespuesta());
                        //conf.setNombreConeccion(nombreConeccion);
                        org.w3c.dom.NodeList segundoNombreElementoLista =primerElemento.getElementsByTagName("CAE");
                        Element segundoNombreElemento =(Element) segundoNombreElementoLista.item(0);
                        org.w3c.dom.NodeList segundoNombre = segundoNombreElemento.getChildNodes();
                        
                        fE.setCae(((Node) segundoNombre.item(0)).getNodeValue().toString());
                        System.out.println("cae : "  + fE.getCae());
                        //conf.setStringDeUrl(stringDeUrl);
                        org.w3c.dom.NodeList tercerNombreElementoLista =primerElemento.getElementsByTagName("CAE_VTO");
                        Element tercerNombreElemento =(Element) tercerNombreElementoLista.item(0);
                        org.w3c.dom.NodeList tercerNombre = tercerNombreElemento.getChildNodes();
                        fE.setCaeVto(((Node) tercerNombre.item(0)).getNodeValue().toString());
                        System.out.println("cae vencimiento : "  + fE.getCaeVto());
                        //conf.setUsuario(usuario);
                        org.w3c.dom.NodeList cuartoNombreElementoLista =primerElemento.getElementsByTagName("TIPO_DOCUMENTO");
                        Element cuartoNombreElemento =(Element) cuartoNombreElementoLista.item(0);
                        org.w3c.dom.NodeList cuartoNombre = cuartoNombreElemento.getChildNodes();
                        fE.setCustomerTypeDoc(((Node) cuartoNombre.item(0)).getNodeValue().toString());
                        System.out.println("fecha cae : "  + fE.getCustomerTypeDoc());
                        //conf.setUsuario(usuario);
                        org.w3c.dom.NodeList quintoNombreElementoLista =primerElemento.getElementsByTagName("NRO_DOCUMENTO");
                        Element quintoNombreElemento =(Element) quintoNombreElementoLista.item(0);
                        org.w3c.dom.NodeList quintoNombre = quintoNombreElemento.getChildNodes();
                        fE.setCustomerId(((Node) quintoNombre.item(0)).getNodeValue().toString());
                        System.out.println("afipqty : "  + fE.getCustomerId());
                        //conf.setUsuario(usuario);
                        org.w3c.dom.NodeList sextoNombreElementoLista =primerElemento.getElementsByTagName("IMPORTE_TOTAL");
                        Element sextoNombreElemento =(Element) sextoNombreElementoLista.item(0);
                        org.w3c.dom.NodeList sextoNombre = sextoNombreElemento.getChildNodes();
                        fE.setImporteTotal(((Node) sextoNombre.item(0)).getNodeValue().toString());
                        System.out.println("afipplastid : "  + fE.getImporteTotal());
                        //conf.setUsuario(usuario);
                        org.w3c.dom.NodeList septimoNombreElementoLista =primerElemento.getElementsByTagName("IMPORTE_NETO");
                        Element septimoNombreElemento =(Element) septimoNombreElementoLista.item(0);
                        org.w3c.dom.NodeList septimoNombre = septimoNombreElemento.getChildNodes();
                        fE.setImporteNeto(((Node) septimoNombre.item(0)).getNodeValue().toString());
                        System.out.println("afipplastcbte : "  + fE.getImporteNeto());
                        
                        org.w3c.dom.NodeList octavoNombreElementoLista =primerElemento.getElementsByTagName("IMPTO_LIQ");
                        Element octavoNombreElemento =(Element) octavoNombreElementoLista.item(0);
                        org.w3c.dom.NodeList octavoNombre = octavoNombreElemento.getChildNodes();
                        fE.setImpuestoLiquido(((Node) octavoNombre.item(0)).getNodeValue().toString());
                        System.out.println("afipplastcbte : "  + fE.getImpuestoLiquido());
                        
                        org.w3c.dom.NodeList novenoNombreElementoLista =primerElemento.getElementsByTagName("TIPO_COMPROBANTE");
                        Element novenoNombreElemento =(Element) novenoNombreElementoLista.item(0);
                        org.w3c.dom.NodeList novenoNombre = novenoNombreElemento.getChildNodes();
                        fE.setTipoComprobante(((Node) novenoNombre.item(0)).getNodeValue().toString());
                        System.out.println("afipplastcbte : "  + fE.getTipoComprobante());
                        
                        org.w3c.dom.NodeList decimoNombreElementoLista =primerElemento.getElementsByTagName("CBTE_DESDE");
                        Element decimoNombreElemento =(Element) decimoNombreElementoLista.item(0);
                        org.w3c.dom.NodeList decimoNombre = decimoNombreElemento.getChildNodes();
                        fE.setAfipPlastCbte(((Node) decimoNombre.item(0)).getNodeValue().toString());
                        System.out.println("afipplastcbte : "  + fE.getAfipPlastCbte());
                        //conf.setClave(clave);
                        //listadoConecciones.add(conf);
                    }
                }
                in.close();
            }catch(java.net.UnknownHostException ex){
                Logger.getLogger(FacturaElectronica.class.getName()).log(Level.SEVERE, null, ex);
                System.err.println("En factura electronica: "+ex);
                fE.setRespuesta("ERROR");
            }catch(java.lang.NullPointerException ey){
                Logger.getLogger(FacturaElectronica.class.getName()).log(Level.SEVERE, null, ey);
                System.err.println("Parametros invalidos: "+ey);
                fE.setRespuesta("PARAMETROS");
            } catch (ParserConfigurationException ex) {
                Logger.getLogger(FacturaElectronica.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SAXException ex) {
                Logger.getLogger(FacturaElectronica.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        } catch (MalformedURLException ex) {
            Logger.getLogger(FacturaElectronica.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FacturaElectronica.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        */
        return fE;
        
    }

    @Override
    public void eliminar(Object fe) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String reimprimir(Object fe) {
        /*
        FacturaElectronica fE=new FacturaElectronica();
        fE=(FacturaElectronica)fe;
        pdfsJavaGenerador pdf=new pdfsJavaGenerador();
        ClientesTango cliente=new ClientesTango();
        Facturar fac=new ClientesTango();
        cliente=(ClientesTango)fac.cargarPorCodigoAsignado(fE.getIdCliente());
        pdf.setCliente(cliente);
        pdf.setDoc(fE);
        pdf.run();
        */
        return null;
        
    }

    @Override
    public String imprimir(Object fe) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean InstalarTablas() {
        //creacion de tabla facturaelectronica
        
        Boolean ver=true;
        /*
        Transaccionable tra=new Conecciones();
        tra.guardarRegistro("CREATE TABLE facturaelectronica (id int(11) NOT NULL,cae varchar (20),cae_vto varchar(8),fecha_cae varchar(20),afipqty varchar(4),afipplastid varchar(20),afipplastcbte varchar(10),idfactura int(11) not null,idcliente int(11) not null,estado int(11) not null default '0',customerid varchar (11),customertypedoc varchar(2),tipo_comprobante varchar(1),importe_total varchar(30),importe_neto varchar(25),impto_liq varchar(25),fecha timestamp not null default current_timestamp)ENGINE=InnoDB DEFAULT CHARSET=utf8"); //(idcliente,total,tipo,idusuario,idpedido,idremito,numerofactura,estado,saldo,subtotal,descuento,porcentajeD)
        tra.guardarRegistro("ALTER TABLE facturaelectronica ADD PRIMARY KEY (id)");
        tra.guardarRegistro("ALTER TABLE facturaelectronica MODIFY id int(11) NOT NULL AUTO_INCREMENT");
        tra.guardarRegistro("alter table facturaelectronica modify tipo_comprobante varchar(2)");
        
        */
        //String sql="insert into facturaelectronica (cae,cae_vto,fecha_cae,afipqty,afipplastid,afipplastcbte,idfactura,idcliente,estado,customerid,customertypedoc,tipo_comprobante,importe_total,importe_neto,impto_liq) values ('"+ffE.getCae()+"','"+ffE.getCaeVto()+"','"+ffE.getFechaCae()+"','"+ffE.getAfipQty()+"','"+ffE.getAfipPlastId()+"','"+ffE.getAfipPlastCbte()+"',"+ffE.getIdFactura()+","+ffE.getIdCliente()+","+estado+",'"+ffE.getCustomerId()+"','"+ffE.getCustomerTypeDoc()+"','"+ffE.getTipoComprobante()+"','"+ffE.getImporteTotal()+"','"+ffE.getImporteNeto()+"','"+ffE.getImpuestoLiquido()+"')";
        return ver;
    }

    @Override
    public Boolean ActualizarTablas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer generar(Connection conexion, int Condicion, String archivoKey, String archivoCrt, Integer idCliente, String cuitCliente, int tipoDocumentoCliente, int tipoComprobante, Double montoTotal, Double montoBruto, Double montoIva,int ptoDeVenta,String cuitVendedor,int tipoV,ArrayList lstI,ArrayList lstT,String razonSocial,String direccion,String condicionIvaCliente,ArrayList lstDetalle) {
        FacturaElectronica fE=new FacturaElectronica();
        fE.listadoIva=new ArrayList();
        fE.listadoTributos=new ArrayList();
        fE.conexion=conexion;
        fE.condicionIvaVendedor=String.valueOf(Condicion);
        fE.archivoKey=archivoKey;
        fE.archivoCrt=archivoCrt;
        fE.idCliente=idCliente;
        fE.customerId=cuitCliente;
        fE.customerTypeDoc=String.valueOf(tipoDocumentoCliente);
        fE.numeroPuntoDeVenta=ptoDeVenta;
        fE.importeTotal=montoTotal;
        fE.importeNeto=montoBruto;
        fE.impuestoLiquido=montoIva;
        fE.tipoCompro=tipoComprobante;
        fE.cuitVendedor=cuitVendedor;
        fE.tipoVta=tipoV;
        fE.listadoIva=lstI;
        fE.listadoTributos=lstT;
        fE.razonSocial=razonSocial;
        fE.direccionCliente=direccion;
        fE.condicionIvaCliente=condicionIvaCliente;
        fE.listadoDetalle=lstDetalle;
        if(fE.condicionIvaVendedor.equals("2")){
            
            
            if(fE.tipoCompro==1)tipoComp=TipoComprobante.tcFacturaB;//factura B a consumidor final
            if(fE.tipoCompro==2)tipoComp=TipoComprobante.tcFacturaA;//1 FACTURA A 
            if(fE.tipoCompro==9)tipoComp=TipoComprobante.tcNotaDebitoA;//2
            if(fE.tipoCompro==10)tipoComp=TipoComprobante.tcNotaCreditoA;//3 NOTA DE CREDITO A
            if(fE.tipoCompro==11)tipoComp=TipoComprobante.tcNotaDebitoB;
            if(fE.tipoCompro==12)tipoComp=TipoComprobante.tcNotaCreditoB;//tipComprobante=8;
            if(fE.tipoCompro==8)tipoComp=TipoComprobante.tcFacturaB;//NTA DE CREDITO B A CONS FINAL y exento
            if(fE.tipoCompro==3)tipoComp=TipoComprobante.tcFacturaB;// factura B A EXENTO
        }else{
            if(fE.tipoCompro==1)tipoComp=TipoComprobante.tcFacturaC;
            if(fE.tipoCompro==2)tipoComp=TipoComprobante.tcFacturaC;//1
            if(fE.tipoCompro==9)tipoComp=TipoComprobante.tcNotaDebitoC;//2
            if(fE.tipoCompro==10)tipoComp=TipoComprobante.tcNotaCreditoC;//3
            if(fE.tipoCompro==11)tipoComp=TipoComprobante.tcNotaDebitoC;
            if(fE.tipoCompro==12)tipoComp=TipoComprobante.tcNotaCreditoC;
        }
        
        fE.leer();
        return fE.guardarEnFiscal();
    }
}
