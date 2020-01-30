/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paneles;

import CodeHelpers.ConexionesDB;
import java.awt.Desktop;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.ssl.PKCS8Key;

import mx.com.mostrotouille.axolotl.CaptureException;
import mx.com.mostrotouille.axolotl.swing.AxolotlSwingToolkit;
import mx.com.mostrotouille.axolotl.swing.JAboutDialog;
import mx.com.mostrotouille.axolotl.swing.util.AxolotlFileFilter;

public class pnlXml extends javax.swing.JPanel {

    ConexionesDB conector = new ConexionesDB();
    ResultSet resultadoConsulta;
    DefaultTableModel modeloTabla;

    private File currentDirectory;

    String curpResponsable = "";
    String idCargo = "";
    String cargo = "";
    String abrTitulo = "";

    String clave = "";
    String nombreCarrera = "";
    String numeroRvoe = "";
    String clave_autorizacion = "";
    String autorizacion_reconocimiento = "";

    /**
     * *****************************************
     */
    String nombre = "", aPaterno = "", aMaterno = "";
    String matricula = "", correo = "", CURP = "";
    String fechaCarreraInicio = "", fechaCarreraTermino = "";

    String fechaAntInicio = "", institucionProcedencia = "";
    String fechaAntTermino = "", tipodeEstudio = "", eFederativa = "", eFederativa2 = "";
    String idModalidadTitulacion = "", idFundamentoLegalServicioSocial = "";
    String idEntidadFederativa = "", idEntidadFederativa2 = "", noCedula = "", noRvoe = "";

    /**
     * *****************************************
     */
    String fechaExpedicion = "", modalidadTitulacion = "", fundamentoSS = "";
    String fechaExamen = "", folioControl = "";
    String sSocial = "";

    String idTipoEstudioAntecedente = "";

    String Llave = "", Certificado = "", pass = "";
    String Llave2 = "", Certificado2 = "", pass2 = "";

    String archivo = "";
    String archivo2 = "";

    public pnlXml() {

        initComponents();
        initComponents();
        modeloTabla = (DefaultTableModel) jTable1.getModel();
        tablaTxtB();

    }

    public void tablaTxtB() {
        try {
            int filas = jTable1.getRowCount();
            for (int i = 1; i <= filas; i++) {
                modeloTabla.removeRow(0);
            }
            try {
                resultadoConsulta = conector.consulta("SELECT matricula, nombre, aPaterno, aMaterno FROM txt where estatus='B'");//establecimiento de sentencia aejecutar

            } catch (ClassNotFoundException ex) {
                Logger.getLogger(pnlTxt.class.getName()).log(Level.SEVERE, null, ex);
            }
            Object[] valores = new Object[4];//Crea un arreglo de objetos un objeto puede 
            while (resultadoConsulta.next()) {
                for (int i = 0; i < 4; i++) {//El numero del for ebe ser igual al de la
                    valores[i] = resultadoConsulta.getObject(i + 1);
                }
                modeloTabla.addRow(valores);
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel7 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        txtBuscar = new rscomponentshade.RSTextFieldShade();
        btnBuscar1 = new rscomponentshade.RSButtonShade();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new rojerusan.RSTableMetro();
        rSButtonShade5 = new rscomponentshade.RSButtonShade();
        rSButtonShade4 = new rscomponentshade.RSButtonShade();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel7.setFont(new java.awt.Font("Roboto", 1, 40)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(128, 128, 131));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img1/xml.png"))); // NOI18N
        jLabel7.setText("Archivos XML");
        jLabel7.setIconTextGap(10);

        jPanel3.setBackground(new java.awt.Color(243, 242, 242));

        jPanel4.setBackground(new java.awt.Color(243, 242, 242));

        txtBuscar.setPlaceholder("Buscar . . .");
        txtBuscar.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtBuscarCaretUpdate(evt);
            }
        });
        txtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarActionPerformed(evt);
            }
        });

        btnBuscar1.setBackground(new java.awt.Color(124, 20, 52));
        btnBuscar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/lupa.png"))); // NOI18N
        btnBuscar1.setBgHover(new java.awt.Color(124, 20, 52));
        btnBuscar1.setBgShadeHover(new java.awt.Color(255, 204, 204));
        btnBuscar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscar1ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Matricula", "Nombre", "Apellido Paterno", "Apellido Materno", "Generados en txt"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.setColorBackgoundHead(new java.awt.Color(124, 20, 52));
        jTable1.setColorFilasBackgound2(new java.awt.Color(255, 204, 204));
        jTable1.setColorFilasForeground1(new java.awt.Color(124, 20, 52));
        jTable1.setColorFilasForeground2(new java.awt.Color(124, 20, 52));
        jTable1.setColorSelBackgound(new java.awt.Color(124, 20, 52));
        jTable1.setFuenteFilas(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTable1.setFuenteFilasSelect(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTable1.setGridColor(new java.awt.Color(255, 255, 255));
        jTable1.setSelectionBackground(new java.awt.Color(124, 20, 52));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);

        rSButtonShade5.setBackground(new java.awt.Color(124, 20, 52));
        rSButtonShade5.setText("Devolver");
        rSButtonShade5.setBgHover(new java.awt.Color(255, 204, 204));
        rSButtonShade5.setBgShadeHover(new java.awt.Color(124, 20, 52));
        rSButtonShade5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonShade5ActionPerformed(evt);
            }
        });

        rSButtonShade4.setBackground(new java.awt.Color(124, 20, 52));
        rSButtonShade4.setText("Firmar");
        rSButtonShade4.setBgHover(new java.awt.Color(255, 204, 204));
        rSButtonShade4.setBgShadeHover(new java.awt.Color(124, 20, 52));
        rSButtonShade4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonShade4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscar1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(rSButtonShade5, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rSButtonShade4, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rSButtonShade5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rSButtonShade4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(162, 162, 162))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 283, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 976, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void rSButtonShade5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonShade5ActionPerformed
        TableModel model2 = jTable1.getModel();
        String[] seleccionado = new String[100];

        for (int i = 0; i < jTable1.getRowCount(); i++) {
            //System.out.println("prueba " + ((Boolean) model.getValueAt(i, 4) == true));
            //Si la columna 4 está true añadimos el ID
            if ((Boolean) model2.getValueAt(i, 4) == true) {
                seleccionado[i] = ((String) model2.getValueAt(i, 0));
            }

            System.out.println(seleccionado[i]);

            if (seleccionado[i] != null || seleccionado[i] != "") {
                try {
                    String cadena = "Update txt set estatus = 'A' where matricula='" + seleccionado[i] + "'";
                    //System.out.println(cadena);
                    String salida = conector.registrar(cadena);
                    System.out.println(salida);

                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(pnlTitulos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        JOptionPane.showMessageDialog(null, "Logrado");
        tablaTxtB();
    }//GEN-LAST:event_rSButtonShade5ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1MouseClicked

    private void btnBuscar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscar1ActionPerformed

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarActionPerformed

    private void txtBuscarCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtBuscarCaretUpdate
       String Buscar = txtBuscar.getText();
        try {
            int filas = jTable1.getRowCount(); //Obtiene la catidad de filas
            for (int i = 1; i <= filas; i++) { //For que se ecuta de acuerdo a la cantidad de filas que haya
                modeloTabla.removeRow(0); //metodo que elimina cada fila
            }
            try {
                resultadoConsulta = conector.consulta("select * from txt where nombre like '%" + Buscar + "%' or aPaterno like '%"
                        + Buscar + "%' or aMaterno like '%" + Buscar + "%' or matricula like '%" + Buscar + "%' where estatus='B'");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(pnlCarreras.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
            Object[] valores = new Object[4];//Crea un arreglo de objetos un objeto puede
            while (resultadoConsulta.next()) {
                for (int i = 0; i < 4; i++) {//El numero del for ebe ser igual al de la
                    valores[i] = resultadoConsulta.getObject(i + 1); //
                }
                modeloTabla.addRow(valores);//añade una nueva fila con los datos que
                //esten en cada psocion del arreglo de objetos
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex);
        }
    }//GEN-LAST:event_txtBuscarCaretUpdate

    private void rSButtonShade4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonShade4ActionPerformed

        for (int i = 0; i < jTable1.getRowCount(); i++) {
            try {
                TableModel model = jTable1.getModel();
                String[] seleccionado = new String[100];
                if ((Boolean) model.getValueAt(i, 4) == true) {
                    seleccionado[i] = ((String) model.getValueAt(i, 0));
                }

                //System.out.println(seleccionado[i]);
                // if (seleccionado[i] != null || seleccionado[i] != "") {
                try {
                    try {
                        resultadoConsulta = conector.consulta("SELECT * FROM txt where matricula='" + seleccionado[i] + "'");//establecimiento de sentencia aejecutar
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(pnlTxt.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    while (resultadoConsulta.next()) {

                        folioControl = resultadoConsulta.getString("folioControl");
                        fechaExpedicion = resultadoConsulta.getString("fechaExpedicion");
                        idModalidadTitulacion = resultadoConsulta.getString("idModalidadTitulacion");
                        modalidadTitulacion = resultadoConsulta.getString("modalidadTitulacion");
                        fechaExamen = resultadoConsulta.getString("fechaExamen");
                        matricula = resultadoConsulta.getString("matricula");
                        nombre = resultadoConsulta.getString("nombre");
                        aPaterno = resultadoConsulta.getString("aPaterno");
                        aMaterno = resultadoConsulta.getString("aMaterno");
                        correo = resultadoConsulta.getString("correo");
                        CURP = resultadoConsulta.getString("CURP");
                        sSocial = resultadoConsulta.getString("sSocial");
                        idFundamentoLegalServicioSocial = resultadoConsulta.getString("idFundamentoLegalServicioSocial");
                        fundamentoSS = resultadoConsulta.getString("fundamentoSS");
                        clave = resultadoConsulta.getString("clave");
                        nombreCarrera = resultadoConsulta.getString("nombreCarrera");
                        numeroRvoe = resultadoConsulta.getString("numeroRvoe");
                        clave_autorizacion = resultadoConsulta.getString("clave_autorizacion");
                        autorizacion_reconocimiento = resultadoConsulta.getString("autorizacion_reconocimiento");
                        institucionProcedencia = resultadoConsulta.getString("institucionProcedencia");
                        if (resultadoConsulta.getInt("idEntidadFederativa") < 10) {
                            idEntidadFederativa = "0" + resultadoConsulta.getString("idEntidadFederativa");
                        } else {
                            idEntidadFederativa = resultadoConsulta.getString("idEntidadFederativa");
                        }
                        if (resultadoConsulta.getInt("idEntidadFederativa2") < 10) {
                            idEntidadFederativa2 = "0" + resultadoConsulta.getString("idEntidadFederativa2");
                        } else {
                            idEntidadFederativa2 = resultadoConsulta.getString("idEntidadFederativa2");
                        }
                        eFederativa = resultadoConsulta.getString("eFederativa");
                        eFederativa2 = resultadoConsulta.getString("eFederativa2");

                        fechaAntInicio = resultadoConsulta.getString("fechaAntInicio");
                        fechaAntTermino = resultadoConsulta.getString("fechaAntTermino");
                        idTipoEstudioAntecedente = resultadoConsulta.getString("idTipoEstudioAntecedente");
                        tipodeEstudio = resultadoConsulta.getString("tipodeEstudio");
                        noCedula = resultadoConsulta.getString("noCedula");
                        idModalidadTitulacion = resultadoConsulta.getString("idModalidadTitulacion");
                        archivo = resultadoConsulta.getString("archivo");
                        archivo2 = resultadoConsulta.getString("archivo");
                        fechaCarreraInicio = resultadoConsulta.getString("fechaInicioCarrera");
                        fechaCarreraTermino = resultadoConsulta.getString("fechaFinCarrera");
                        noRvoe = resultadoConsulta.getString("numeroRvoe");

                    }
                } catch (SQLException ex) {
                    Logger.getLogger(pnlXml.class.getName()).log(Level.SEVERE, null, ex);
                }

                try {
                    resultadoConsulta = conector.consulta("SELECT Llave, Certificado, pass FROM Responsable where Clave=1");//establecimiento de sentencia aejecutar
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(pnlXml.class.getName()).log(Level.SEVERE, null, ex);
                }
                while (resultadoConsulta.next()) {
                    Llave = resultadoConsulta.getString("Llave");
                    System.out.println("llave " + Llave);
                    Certificado = resultadoConsulta.getString("Certificado");
                    pass = resultadoConsulta.getString("pass");
                    System.out.println("pass " + pass);

                }

                try {
                    resultadoConsulta = conector.consulta("SELECT Llave, Certificado, pass FROM Responsable where Clave=2");//establecimiento de sentencia aejecutar
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(pnlXml.class.getName()).log(Level.SEVERE, null, ex);
                }
                while (resultadoConsulta.next()) {
                    Llave2 = resultadoConsulta.getString("Llave");
                    Certificado2 = resultadoConsulta.getString("Certificado");
                    pass2 = resultadoConsulta.getString("pass");

                }

                try {
                    Llave = sign(Llave, pass, archivo);
                    Certificado = Base64.encodeBase64String(toByteArray(Certificado));
                    System.out.println("llave " + Llave);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                try {
                    Llave2 = sign2(Llave2, pass2, archivo2);
                    System.out.println("llave2 " + Llave2);
                    Certificado2 = Base64.encodeBase64String(toByteArray2(Certificado2));
                } catch (Exception e) {
                    e.printStackTrace();
                }

                try {
                    String ruta = "/home/genaro/Documentos/TituloElectronico_" + matricula + ".xml";
                    //String ruta = "C:\\Users\\JLIMON\\Documents\\TituloElectronico_" + matricula + ".xml";
                    String contenido = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"
                            + "<TituloElectronico xmlns=\"https://www.siged.sep.gob.mx/titulos/\" version=\"1.0\" folioControl=\"" + folioControl + "\" xmlns:dec=\"https://www.siged.sep.gob.mx/titulos/\">\n"
                            + "  <FirmaResponsables>\n"
                            + "    <FirmaResponsable nombre=\"MIGUEL\" primerApellido=\"OSORIO\" segundoApellido=\"RAMOS\" curp=\"OORM631231HDFSMG03\" idCargo=\"1\" cargo=\"DIRECTOR\" abrTitulo=\"LIC.\" sello=\"" + Llave + "\" certificadoResponsable=\"" + Certificado + "\" noCertificadoResponsable=\"00001000000412846216\"/>\n"
                            + "    <FirmaResponsable nombre=\"JORGE\" primerApellido=\"BERRUETA\" segundoApellido=\"VIDEGARAY\" curp=\"BEVJ691029HGTRDR09\" idCargo=\"3\" cargo=\"RECTOR\" abrTitulo=\"ING.\" sello=\"" + Llave2 + "\" certificadoResponsable=\"" + Certificado2 + "\" noCertificadoResponsable=\"00001000000100164040\"/>\n"
                            + "  </FirmaResponsables>\n"
                            + "  <Institucion cveInstitucion=\"" + "090653" + "\" nombreInstitucion=\"" + "UNIVERSIDAD VICTORIA" + "\"/>\n"
                            + "  <Carrera cveCarrera=\"" + clave + "\" nombreCarrera=\"" + nombreCarrera + "\" fechaInicio=\"" + fechaCarreraInicio + "\" fechaTerminacion=\"" + fechaCarreraTermino + "\" idAutorizacionReconocimiento=\"" + clave_autorizacion + "\" autorizacionReconocimiento=\"" + autorizacion_reconocimiento + "\" numeroRvoe=\"" + numeroRvoe + "\"/>\n"
                            + "  <Profesionista curp=\"" + CURP + "\" nombre=\"" + nombre + "\" primerApellido=\"" + aPaterno + "\" segundoApellido=\"" + aMaterno + "\" correoElectronico=\"" + correo + "\"/>"
                            + "  <Expedicion fechaExpedicion=\"" + fechaExpedicion + "\" idModalidadTitulacion=\"" + idModalidadTitulacion + "\" modalidadTitulacion=\"" + modalidadTitulacion + "\" fechaExencionExamenProfesional=\"" + fechaExamen + "\" cumplioServicioSocial=\"" + sSocial + "\" idFundamentoLegalServicioSocial=\"" + idFundamentoLegalServicioSocial + "\" fundamentoLegalServicioSocial=\"" + fundamentoSS + "\" idEntidadFederativa=\"" + idEntidadFederativa + "\" entidadFederativa=\"" + eFederativa + "\"/>\n"
                            + "  <Antecedente institucionProcedencia=\"" + institucionProcedencia + "\" idTipoEstudioAntecedente=\"" + idTipoEstudioAntecedente + "\" tipoEstudioAntecedente=\"" + tipodeEstudio + "\" idEntidadFederativa=\"" + idEntidadFederativa2 + "\" entidadFederativa=\"" + eFederativa2 + "\" fechaInicio=\"" + fechaAntInicio + "\" fechaTerminacion=\"" + fechaAntTermino + "\" noCedula=\"" + noCedula + "\"/>\n"
                            + "</TituloElectronico>";

                    //System.out.println(contenido);
                    File file = new File(ruta);
                    // Si el archivo no existe es creado
                    if (!file.exists()) {
                        file.createNewFile();
                    }
                    FileWriter fw = new FileWriter(file);
                    BufferedWriter bw = new BufferedWriter(fw);
                    bw.write(contenido);
                    bw.close();
                    JOptionPane.showMessageDialog(null, "XML Generado en la ruta : " + ruta);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        JOptionPane.showMessageDialog(null, "Archivo xml generado exitosamente");
        abrirarchivo("/home/genaro/Documentos/");
        //abrirarchivo("C:\\Users\\JLIMON\\Documents");
        tablaTxtB();
    }//GEN-LAST:event_rSButtonShade4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rscomponentshade.RSButtonShade btnBuscar1;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private rojerusan.RSTableMetro jTable1;
    private rscomponentshade.RSButtonShade rSButtonShade4;
    private rscomponentshade.RSButtonShade rSButtonShade5;
    private rscomponentshade.RSTextFieldShade txtBuscar;
    // End of variables declaration//GEN-END:variables
   private static String parseExtensionArrayToDescriptionMessage(String[] extensionArray) {
        final StringBuffer result = new StringBuffer();
        result.append("Archivos (");

        for (int i = 0; i < extensionArray.length; i++) {
            result.append("*.");
            result.append(extensionArray[i]);
            result.append(i < (extensionArray.length - 1) ? ", " : "");
        }

        result.append(")");

        return result.toString();
    }

    public static String sign(String keyPath, String password, String toSign) throws Exception {
        System.out.println("filepath : " + keyPath);
        final PKCS8Key pkcs8Key = new PKCS8Key(toByteArray(keyPath), password.toCharArray());
        final PrivateKey privateKey = pkcs8Key.getPrivateKey();
        System.out.println("private " + privateKey);
        final Signature signature = Signature.getInstance("SHA256withRSA");
        signature.initSign(privateKey);
        signature.update(toSign.getBytes("UTF-8"));

        return Base64.encodeBase64String(signature.sign());
    }

    public static String sign2(String keyPath2, String password2, String toSign2) throws Exception {
        //System.out.println("filepath : " + keyPath2);
        final PKCS8Key pkcs8Key2 = new PKCS8Key(toByteArray2(keyPath2), password2.toCharArray());
        final PrivateKey privateKey2 = pkcs8Key2.getPrivateKey();
        //System.out.println("private " + privateKey2);
        final Signature signature2 = Signature.getInstance("SHA256withRSA");
        signature2.initSign(privateKey2);
        signature2.update(toSign2.getBytes("UTF-8"));

        return Base64.encodeBase64String(signature2.sign());
    }

    private static byte[] toByteArray(String filePath) throws Exception {

        File f = new File(filePath);

        FileInputStream fis = new FileInputStream(f);

        byte[] fbytes = new byte[(int) f.length()];

        fis.read(fbytes);
        fis.close();

        return fbytes;
    }

    private static byte[] toByteArray2(String filePath2) throws Exception {

        File f2 = new File(filePath2);

        FileInputStream fis2 = new FileInputStream(f2);

        byte[] fbytes2 = new byte[(int) f2.length()];

        fis2.read(fbytes2);
        fis2.close();

        return fbytes2;
    }

    private void selectFile(JTextField txtfld, String[] extensionArray) {
        final JFileChooser flchsr = new JFileChooser(currentDirectory);
        flchsr.setFileFilter(
                new AxolotlFileFilter(extensionArray, parseExtensionArrayToDescriptionMessage(extensionArray)));

        final int option = flchsr.showOpenDialog(this);

        if (option == JFileChooser.APPROVE_OPTION) {
            txtfld.setText(flchsr.getSelectedFile().getAbsolutePath());

            currentDirectory = flchsr.getCurrentDirectory();
        }
    }

    private void selectFile2(JTextField txtfld, String[] extensionArray) {
        final JFileChooser flchsr = new JFileChooser(currentDirectory);
        flchsr.setFileFilter(
                new AxolotlFileFilter(extensionArray, parseExtensionArrayToDescriptionMessage(extensionArray)));

        final int option = flchsr.showOpenDialog(this);

        if (option == JFileChooser.APPROVE_OPTION) {
            txtfld.setText(flchsr.getSelectedFile().getAbsolutePath());

            currentDirectory = flchsr.getCurrentDirectory();
        }
    }

    public void abrirarchivo(String archivo) {
        try {
            File objetofile = new File(archivo);
            Desktop.getDesktop().open(objetofile);
        } catch (IOException ex) {
            // System.out.println(ex);
        }
    }

}
