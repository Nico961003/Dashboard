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
import java.math.BigDecimal;
import java.math.BigInteger;
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

    String Llave = "", Certificado = "", numeroSerie = "",  pass = "";

    String archivo[] = new String[5];
    String firma[] = new String[5];

    ////////////////////////////////////////////////////////////////////
    String idResponsable = "";
    String nombreResponsable = "";
    String aPaternoResponsable = "";
    String aMaternoResponsable = "";
    String curpResp = "";
    String puesto = "";
    String abrev = "";

    /**
     * *********************************
     */
    String claveEscuela = "";
    String nombreEscuela = "";
    String carpeta = "";

    public pnlXml() {
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
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new rojerusan.RSTableMetro();
        btnFirmar = new rscomponentshade.RSButtonShade();
        btnDevolver = new rscomponentshade.RSButtonShade();
        txtBuscar = new rscomponentshade.RSTextFieldShade();
        btnBuscar1 = new rscomponentshade.RSButtonShade();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel7.setFont(new java.awt.Font("Roboto", 1, 48)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(128, 128, 131));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img1/xml.png"))); // NOI18N
        jLabel7.setText("DOCUMENTOS XML");
        jLabel7.setMaximumSize(new java.awt.Dimension(357, 96));
        jLabel7.setMinimumSize(new java.awt.Dimension(357, 96));
        jLabel7.setPreferredSize(new java.awt.Dimension(357, 96));

        jPanel3.setBackground(new java.awt.Color(243, 242, 242));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Lista de Documentos XML.", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("sansserif", 1, 14))); // NOI18N

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

        btnFirmar.setBackground(new java.awt.Color(124, 20, 52));
        btnFirmar.setText("Firmar");
        btnFirmar.setBgHover(new java.awt.Color(255, 204, 204));
        btnFirmar.setBgShadeHover(new java.awt.Color(124, 20, 52));
        btnFirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFirmarActionPerformed(evt);
            }
        });

        btnDevolver.setBackground(new java.awt.Color(124, 20, 52));
        btnDevolver.setText("Devolver");
        btnDevolver.setBgHover(new java.awt.Color(255, 204, 204));
        btnDevolver.setBgShadeHover(new java.awt.Color(124, 20, 52));
        btnDevolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDevolverActionPerformed(evt);
            }
        });

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

        jLabel2.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabel2.setText("Seleccione desde la(s) casilla(s) el (los) Documentos para la generación de (los) Documentos(s) XML.");

        jLabel3.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabel3.setText("Como mínimo debe seleccionar un documento.");

        jLabel4.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabel4.setText("O bien seleccione desde la(s) casilla(s) el (los) Documentos para volver a generar un Archivo a Documento TXT. ");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(btnDevolver, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnFirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBuscar1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(2, 2, 2)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(21, 21, 21)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDevolver, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnDevolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDevolverActionPerformed

        for (int i = 0; i < jTable1.getRowCount(); i++) {
            try {
                TableModel model = jTable1.getModel();
                String[] seleccionado = new String[100];
                if ((Boolean) model.getValueAt(i, 4) == true) {
                    seleccionado[i] = ((String) model.getValueAt(i, 0));

                    System.out.println(seleccionado[i]);

                    if (seleccionado[i] != null || seleccionado[i] != "") {
                        try {
                            String cadena = "Update txt set estatus = 'A', firma0 = null, firma1 = null,"
                                    + " firma2 = null, firma3 = null, firma4 = null,"
                                    + " archivo0 = null, archivo1 = null,"
                                    + " archivo2 = null, archivo3 = null, archivo4 = null where matricula='" + seleccionado[i] + "'";
                            //System.out.println(cadena);
                            String salida = conector.registrar(cadena);
                            System.out.println(salida);

                        } catch (ClassNotFoundException ex) {
                            Logger.getLogger(pnlTitulos.class
                                    .getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }

            } catch (Exception e) {
                System.out.println(e);
            }
        }
        JOptionPane.showMessageDialog(null, "Logrado");
        tablaTxtB();
    }//GEN-LAST:event_btnDevolverActionPerformed

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
            int filas = jTable1.getRowCount();
            for (int i = 1; i <= filas; i++) {
                modeloTabla.removeRow(0);
            }
            try {
                resultadoConsulta = conector.consulta("call buscaTxt('" + Buscar + "')");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(pnlCarreras.class.getName()).log(Level.SEVERE, null, ex);
            }
            Object[] valores = new Object[4];
            while (resultadoConsulta.next()) {
                for (int i = 0; i < 4; i++) {
                    valores[i] = resultadoConsulta.getObject(i + 1); //
                }
                if (resultadoConsulta.getString("estatus").equals("B")) {
                    modeloTabla.addRow(valores);
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex);
        }
    }//GEN-LAST:event_txtBuscarCaretUpdate

    private void btnFirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirmarActionPerformed
        try {
            try {
                resultadoConsulta = conector.consulta("SELECT * FROM configuracion");

            } catch (ClassNotFoundException ex) {
                Logger.getLogger(pnlTxt.class.getName()).log(Level.SEVERE, null, ex);
            }

            while (resultadoConsulta.next()) {
                claveEscuela = resultadoConsulta.getString("claveEscuela");
                nombreEscuela = resultadoConsulta.getString("nombreEscuela");
                carpeta = resultadoConsulta.getString("carpeta");
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex);
        }
        /**
         * ** comienza conteo tabla ***********
         */
        for (int i = 0; i < jTable1.getRowCount(); i++) {

            try {
                TableModel model = jTable1.getModel();
                String[] seleccionado = new String[100];
                if ((Boolean) model.getValueAt(i, 4) == true) {
                    seleccionado[i] = ((String) model.getValueAt(i, 0));
                }

                try {
                    try {
                        resultadoConsulta = conector.consulta("SELECT * FROM txt where matricula='" + seleccionado[i] + "'");//establecimiento de sentencia aejecutar
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(pnlTxt.class
                                .getName()).log(Level.SEVERE, null, ex);
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
                        fechaCarreraTermino = resultadoConsulta.getString("fechaFinCarrera");
                        noRvoe = resultadoConsulta.getString("numeroRvoe");
                        fechaCarreraInicio = resultadoConsulta.getString("fechaInicioCarrera");
                        archivo[0] = resultadoConsulta.getString("archivo0");
                        archivo[1] = resultadoConsulta.getString("archivo1");
                        archivo[2] = resultadoConsulta.getString("archivo2");
                        archivo[3] = resultadoConsulta.getString("archivo3");
                        archivo[4] = resultadoConsulta.getString("archivo4");
                        firma[0] = resultadoConsulta.getString("firma0");
                        firma[1] = resultadoConsulta.getString("firma1");
                        firma[2] = resultadoConsulta.getString("firma2");
                        firma[3] = resultadoConsulta.getString("firma3");
                        firma[4] = resultadoConsulta.getString("firma4");

                    }
                } catch (SQLException ex) {
                    Logger.getLogger(pnlXml.class
                            .getName()).log(Level.SEVERE, null, ex);
                }

                for (i = 0; i < 5; i++) {
                    if (firma[i] != null) {
                        try {
                            resultadoConsulta = conector.consulta("select cast(aes_decrypt(pass, 'xyz123') as char), idResponsable,"
                                    + "Nombre, apellidoPaterno, apellidoMaterno,"
                                    + "CURP, Puesto, abrev, Llave, Certificado from Responsable where Clave='" + (i + 1) + "'");
                        } catch (ClassNotFoundException ex) {
                            Logger.getLogger(pnlXml.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        while (resultadoConsulta.next()) {
                            idResponsable = resultadoConsulta.getString("idResponsable");
                            nombreResponsable = resultadoConsulta.getString("Nombre");
                            aPaternoResponsable = resultadoConsulta.getString("apellidoPaterno");
                            aMaternoResponsable = resultadoConsulta.getString("apellidoMaterno");
                            curpResponsable = resultadoConsulta.getString("CURP");
                            puesto = resultadoConsulta.getString("Puesto");
                            abrev = resultadoConsulta.getString("abrev");
                            Llave = resultadoConsulta.getString("Llave");
                            Certificado = resultadoConsulta.getString("Certificado");
                            numeroSerie = resultadoConsulta.getString("numeroSerie"); 
                            pass = resultadoConsulta.getString("cast(aes_decrypt(pass, 'xyz123') as char)");

                            Llave = sign(Llave, pass, archivo[i]);
                            Certificado = Base64.encodeBase64String(toByteArray(Certificado));
                            firma[i] = "<FirmaResponsable nombre=\"" + nombreResponsable + "\" primerApellido=\"" + aPaternoResponsable + "\" segundoApellido=\"" + aMaternoResponsable + "\" curp=\"" + curpResponsable + "\" idCargo=\"" + idResponsable + "\" cargo=\"" + puesto + "\" abrTitulo=\"" + abrev + "\" sello=\"" + Llave + "\" certificadoResponsable=\"" + Certificado + "\" noCertificadoResponsable=\" " + numeroSerie + " \"/>\n";
                        }

                    } else {
                        firma[i] = "";
                    }
                }

                try {

                    if (modalidadTitulacion.equals("POR TESIS")) {
                        String ruta = carpeta + "//TituloElectronico_" + matricula + ".xml";
                        String contenido = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"
                                + "<TituloElectronico xmlns=\"https://www.siged.sep.gob.mx/titulos/\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" version=\"1.0\" folioControl=\"" + folioControl + "\" xmlns:dec=\"https://www.siged.sep.gob.mx/titulos/\">\n"
                                + "  <FirmaResponsables>\n"
                                + firma[0]
                                + firma[1]
                                + firma[2]
                                + firma[3]
                                + firma[4]
                                + "  </FirmaResponsables>\n"
                                + "  <Institucion cveInstitucion=\"" + claveEscuela + "\" nombreInstitucion=\"" + nombreEscuela + "\"/>\n"
                                + "  <Carrera cveCarrera=\"" + clave + "\" nombreCarrera=\"" + nombreCarrera + "\" fechaInicio=\"" + fechaCarreraInicio + "\" fechaTerminacion=\"" + fechaCarreraTermino + "\" idAutorizacionReconocimiento=\"" + clave_autorizacion + "\" autorizacionReconocimiento=\"" + autorizacion_reconocimiento + "\" numeroRvoe=\"" + numeroRvoe + "\"/>\n"
                                + "  <Profesionista curp=\"" + CURP + "\" segundoApellido=\"" + aMaterno + "\" primerApellido=\"" + aPaterno + "\" nombre=\"" + nombre + "\" correoElectronico=\"" + correo + "\"/>"
                                + "  <Expedicion fechaExpedicion=\"" + fechaExpedicion + "\" idModalidadTitulacion=\"" + idModalidadTitulacion + "\" modalidadTitulacion=\"" + modalidadTitulacion + "\" fechaExamenProfesional=\"" + fechaExamen + "\" cumplioServicioSocial=\"" + sSocial + "\" idFundamentoLegalServicioSocial=\"" + idFundamentoLegalServicioSocial + "\" fundamentoLegalServicioSocial=\"" + fundamentoSS + "\" idEntidadFederativa=\"" + idEntidadFederativa + "\" entidadFederativa=\"" + eFederativa + "\"/>\n"
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
                    } else {
                        String ruta = carpeta + "//TituloElectronico_" + matricula + ".xml";
                        String contenido = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"
                                + "<TituloElectronico xmlns=\"https://www.siged.sep.gob.mx/titulos/\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" version=\"1.0\" folioControl=\"" + folioControl + "\" xmlns:dec=\"https://www.siged.sep.gob.mx/titulos/\">\n"
                                + "  <FirmaResponsables>\n"
                                + firma[0]
                                + firma[1]
                                + firma[2]
                                + firma[3]
                                + firma[4]
                                + "  </FirmaResponsables>\n"
                                + "  <Institucion cveInstitucion=\"" + claveEscuela + "\" nombreInstitucion=\"" + nombreEscuela + "\"/>\n"
                                + "  <Carrera cveCarrera=\"" + clave + "\" nombreCarrera=\"" + nombreCarrera + "\" fechaInicio=\"" + fechaCarreraInicio + "\" fechaTerminacion=\"" + fechaCarreraTermino + "\" idAutorizacionReconocimiento=\"" + clave_autorizacion + "\" autorizacionReconocimiento=\"" + autorizacion_reconocimiento + "\" numeroRvoe=\"" + numeroRvoe + "\"/>\n"
                                + "  <Profesionista curp=\"" + CURP + "\" segundoApellido=\"" + aMaterno + "\" primerApellido=\"" + aPaterno + "\" nombre=\"" + nombre + "\" correoElectronico=\"" + correo + "\"/>"
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
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } catch (Exception e) {
                System.out.println(e);
            }

        }
        tablaTxtB();
        abrirarchivo(carpeta);
    }//GEN-LAST:event_btnFirmarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rscomponentshade.RSButtonShade btnBuscar1;
    private rscomponentshade.RSButtonShade btnDevolver;
    private rscomponentshade.RSButtonShade btnFirmar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private rojerusan.RSTableMetro jTable1;
    private rscomponentshade.RSTextFieldShade txtBuscar;
    // End of variables declaration//GEN-END:variables

    public static String sign(String keyPath, String password, String toSign) throws Exception {
        //System.out.println("filepath : " + keyPath);
        final PKCS8Key pkcs8Key = new PKCS8Key(toByteArray(keyPath), password.toCharArray());
        final PrivateKey privateKey = pkcs8Key.getPrivateKey();
        //System.out.println("private " + privateKey);
        final Signature signature = Signature.getInstance("SHA256withRSA");
        signature.initSign(privateKey);
        signature.update(toSign.getBytes("UTF-8"));

        return Base64.encodeBase64String(signature.sign());
    }

    private static byte[] toByteArray(String filePath) throws Exception {

        File f = new File(filePath);

        FileInputStream fis = new FileInputStream(f);

        byte[] fbytes = new byte[(int) f.length()];

        fis.read(fbytes);
        fis.close();

        return fbytes;
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
