package paneles;

import java.sql.SQLException;
import CodeHelpers.ConexionesDB;
import java.awt.Color;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableModel;

public class pnlTxt extends javax.swing.JPanel {

    ConexionesDB conector = new ConexionesDB();
    ResultSet resultadoConsulta;
    DefaultTableModel modeloTabla;
    DefaultTableModel modeloTabla2;

    String curpResponsable = "";
    String idCargo = "";
    String cargo = "";
    String abrTitulo = "";
    String puesto = "";
    String idResponsable = "";
    String[] firmantes = new String[5];

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

    /**
     * *********************************************
     */
    String claveEscuela = "";
    String nombreEscuela = "";
    String carpeta = "";

    public pnlTxt() {
        initComponents();
        modeloTabla = (DefaultTableModel) jTable1.getModel();
        modeloTabla2 = (DefaultTableModel) jTable2.getModel();
        tablaTxtA();
        tablaResponsable();
    }

    public void tablaTxtA() {
        try {
            int filas = jTable1.getRowCount();
            for (int i = 1; i <= filas; i++) {
                modeloTabla.removeRow(0);
            }
            try {
                resultadoConsulta = conector.consulta("SELECT matricula, nombre, aPaterno, aMaterno FROM txt where estatus='A'");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(pnlTxt.class.getName()).log(Level.SEVERE, null, ex);
            }
            Object[] valores = new Object[4];
            while (resultadoConsulta.next()) {
                for (int i = 0; i < 4; i++) {
                    valores[i] = resultadoConsulta.getObject(i + 1);
                }
                modeloTabla.addRow(valores);
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex);
        }

    }

    public void tablaResponsable() {
        try {
            int filas = jTable2.getRowCount();
            for (int i = 1; i <= filas; i++) { 
                modeloTabla2.removeRow(0); 
            }
            try {
                resultadoConsulta = conector.consulta("SELECT Clave, Nombre, apellidoPaterno, apellidoMaterno FROM Responsable");//establecimiento de sentencia aejecutar

            } catch (ClassNotFoundException ex) {
                Logger.getLogger(pnlResponsables.class.getName()).log(Level.SEVERE, null, ex);
            }
            Object[] valores = new Object[4];//Crea un arreglo de objetos un objeto puede 
            while (resultadoConsulta.next()) {
                for (int i = 0; i < 4; i++) {
                    valores[i] = resultadoConsulta.getObject(i + 1);
                }
                modeloTabla2.addRow(valores);
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        txtBuscar = new rscomponentshade.RSTextFieldShade();
        btnBuscar = new rscomponentshade.RSButtonShade();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new rojerusan.RSTableMetro();
        btnGenerar = new rscomponentshade.RSButtonShade();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new rojerusan.RSTableMetro();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(243, 242, 242));

        jPanel2.setBackground(new java.awt.Color(243, 242, 242));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Lista de Documentos TXT.", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("sansserif", 1, 14))); // NOI18N

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

        btnBuscar.setBackground(new java.awt.Color(124, 20, 52));
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/lupa.png"))); // NOI18N
        btnBuscar.setBgHover(new java.awt.Color(124, 20, 52));
        btnBuscar.setBgShadeHover(new java.awt.Color(255, 204, 204));
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Matricula", "Nombre", "Apellido Paterno", "Apellido Materno", "Activar"
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
        jScrollPane1.setViewportView(jTable1);

        btnGenerar.setBackground(new java.awt.Color(124, 20, 52));
        btnGenerar.setText("Generar");
        btnGenerar.setBgHover(new java.awt.Color(255, 204, 204));
        btnGenerar.setBgShadeHover(new java.awt.Color(124, 20, 52));
        btnGenerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarActionPerformed(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null,  new Boolean(true)},
                {null, null, null, null,  new Boolean(true)},
                {null, null, null, null,  new Boolean(true)},
                {null, null, null, null,  new Boolean(true)},
                {null, null, null, null,  new Boolean(true)}
            },
            new String [] {
                "Jerarquia", "Nombre", "A Paterno", "A Materno", "Firma"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable2.setColorBackgoundHead(new java.awt.Color(124, 20, 52));
        jTable2.setColorFilasBackgound2(new java.awt.Color(255, 204, 204));
        jTable2.setColorFilasForeground1(new java.awt.Color(124, 20, 52));
        jTable2.setColorSelBackgound(new java.awt.Color(124, 20, 52));
        jScrollPane3.setViewportView(jTable2);

        jLabel2.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabel2.setText("Seleccione desde la(s) casilla(s) el (los) responsable(s) de la institución para firmar el (los) Documento(s) TXT.");

        jLabel3.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel3.setText("Lista de Firmantes Responsables de la Institución.");

        jLabel4.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabel4.setText("Como mínimo debe seleccionar una opción.");

        jLabel5.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabel5.setText("Seleccione desde la(s) casilla(s) el (los) Documento(s) TXT para firmar.");

        jLabel6.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabel6.setText("Como mínimo debe seleccionar un documento.");

        jLabel8.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel8.setText("Lista de Documentos TXT generados desde el sistema.");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnGenerar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel8))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(4, 4, 4)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jLabel8)
                .addGap(3, 3, 3)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGenerar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel7.setFont(new java.awt.Font("Roboto", 1, 48)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(128, 128, 131));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img1/txt.png"))); // NOI18N
        jLabel7.setText("DOCUMENTOS TXT");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnGenerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarActionPerformed

        for (int i = 0; i < jTable1.getRowCount(); i++) {
            try {
                TableModel model = jTable1.getModel();
                String[] seleccionado = new String[100];

                if ((Boolean) model.getValueAt(i, 4) == true) {
                    seleccionado[i] = ((String) model.getValueAt(i, 0));

                    //System.out.println(seleccionado[i]);
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
                            fechaCarreraInicio = resultadoConsulta.getString("fechaInicioCarrera");
                            fechaCarreraTermino = resultadoConsulta.getString("fechaFinCarrera");
                            noRvoe = resultadoConsulta.getString("numeroRvoe");
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(pnlTxt.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    try {
                        try {
                            resultadoConsulta = conector.consulta("SELECT * FROM configuracion");//establecimiento de sentencia aejecutar

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

                    try {

                        obtenFirmantes();

                        for (int j = 0; j < 5; j++) {
                            if (firmantes[j] != null) {
                                System.out.println("modalidad: " + modalidadTitulacion);
                                if (modalidadTitulacion.equals("POR TESIS")) {
                                    String ruta = carpeta + "\\" + j + "_TituloElectronico_" + matricula + ".txt";
                                    String contenido = "||1.0|" + folioControl + "|" + firmantes[j]
                                            + claveEscuela + "|" + nombreEscuela + "|" + clave + "|" + nombreCarrera + "|" + fechaCarreraInicio + "|"
                                            + fechaCarreraTermino + "|" + clave_autorizacion + "|" + autorizacion_reconocimiento + "|" + noRvoe + "|" + CURP + "|"
                                            + nombre + "|" + aPaterno + "|" + aMaterno + "|" + correo + "|" + fechaExpedicion + "|" + idModalidadTitulacion + "|"
                                            + modalidadTitulacion + "|" + fechaExamen + "||" + sSocial + "|" + idFundamentoLegalServicioSocial + "|"
                                            + fundamentoSS + "|" + idEntidadFederativa + "|" + eFederativa + "|"
                                            + institucionProcedencia + "|" + idTipoEstudioAntecedente + "|" + tipodeEstudio + "|"
                                            + idEntidadFederativa2 + "|" + eFederativa2 + "|" + fechaAntInicio + "|" + fechaAntTermino + "|" + noCedula + "||";
                                    //System.out.println(contenido);
                                    try {

                                        String salida = conector.registrar("UPDATE txt set archivo" + j + "='" + contenido + "', firma" + j + "='" + firmantes[j] + "' where folioControl='" + folioControl + "'");
                                        System.out.println("UPDATE txt set archivo" + j + "='" + contenido + "', firma" + j + "='" + firmantes[j] + "' where folioControl='" + folioControl + "'");
                                    } catch (ClassNotFoundException ex) {
                                        Logger.getLogger(pnlTxt.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                    File file = new File(ruta);
                                    // Si el archivo no existe es creado
                                    if (!file.exists()) {
                                        file.createNewFile();
                                        FileWriter fw = new FileWriter(file);
                                        BufferedWriter bw = new BufferedWriter(fw);
                                        bw.write(contenido);
                                        bw.close();

                                    } else if (file.exists()) {
                                        int reply = JOptionPane.showConfirmDialog(null, "El archivo ya existe\n desea sobrescribir?", "TituloElectronico_" + seleccionado[i] + ".txt", JOptionPane.YES_NO_OPTION);
                                        if (reply == JOptionPane.YES_OPTION) {
                                            FileWriter fw = new FileWriter(file);
                                            BufferedWriter bw = new BufferedWriter(fw);
                                            bw.write(contenido);
                                            bw.close();

                                        } else if (reply == JOptionPane.NO_OPTION) {

                                        }

                                    }
                                } else {
                                    String ruta = carpeta + "\\" + j + "_TituloElectronico_" + matricula + ".txt";
                                    String contenido = "||1.0|" + folioControl + "|" + firmantes[j]
                                            + claveEscuela + "|" + nombreEscuela + "|" + clave + "|" + nombreCarrera + "|" + fechaCarreraInicio + "|"
                                            + fechaCarreraTermino + "|" + clave_autorizacion + "|" + autorizacion_reconocimiento + "|" + noRvoe + "|" + CURP + "|"
                                            + nombre + "|" + aPaterno + "|" + aMaterno + "|" + correo + "|" + fechaExpedicion + "|" + idModalidadTitulacion + "|"
                                            + modalidadTitulacion + "||" + fechaExamen + "|" + sSocial + "|" + idFundamentoLegalServicioSocial + "|"
                                            + fundamentoSS + "|" + idEntidadFederativa + "|" + eFederativa + "|"
                                            + institucionProcedencia + "|" + idTipoEstudioAntecedente + "|" + tipodeEstudio + "|"
                                            + idEntidadFederativa2 + "|" + eFederativa2 + "|" + fechaAntInicio + "|" + fechaAntTermino + "|" + noCedula + "||";
                                    //System.out.println(contenido);
                                    try {

                                        String salida = conector.registrar("UPDATE txt set archivo" + j + "='" + contenido + "', firma" + j + "='" + firmantes[j] + "' where folioControl='" + folioControl + "'");
                                        //System.out.println("UPDATE txt set archivo" + j + "='" + contenido + "', firma" + j + "='" + firmantes[j] + "' where folioControl='" + folioControl + "'");
                                    } catch (ClassNotFoundException ex) {
                                        Logger.getLogger(pnlTxt.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                    File file = new File(ruta);
                                    // Si el archivo no existe es creado
                                    if (!file.exists()) {
                                        file.createNewFile();
                                        FileWriter fw = new FileWriter(file);
                                        BufferedWriter bw = new BufferedWriter(fw);
                                        bw.write(contenido);
                                        bw.close();

                                    } else if (file.exists()) {
                                        int reply = JOptionPane.showConfirmDialog(null, "El archivo ya existe\n desea sobrescribir?", "TituloElectronico_" + seleccionado[i] + ".txt", JOptionPane.YES_NO_OPTION);
                                        if (reply == JOptionPane.YES_OPTION) {
                                            FileWriter fw = new FileWriter(file);
                                            BufferedWriter bw = new BufferedWriter(fw);
                                            bw.write(contenido);
                                            bw.close();

                                        } else if (reply == JOptionPane.NO_OPTION) {

                                        }

                                    }
                                }

                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    try {
                        String cadena = "Update txt set estatus = 'B' where matricula='" + seleccionado[i] + "'";
                        //System.out.println(cadena);
                        String salida = conector.registrar(cadena);
                        System.out.println(salida);

                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(pnlTitulos.class.getName()).log(Level.SEVERE, null, ex);
                    }

                } else { }

            } catch (Exception e) {
                System.out.println(e);
            }
        }
        tablaTxtA();
        tablaResponsable();
        JOptionPane.showMessageDialog(null, "Archivo txt generado exitosamente");
        abrirarchivo(carpeta);

        for (int i = 0; i < 5; i++) {
            firmantes[i] = null;
        }


    }//GEN-LAST:event_btnGenerarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscarActionPerformed

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
                resultadoConsulta = conector.consulta("select * from txt where nombre like '%" + Buscar + "%' or aPaterno like '%"
                        + Buscar + "%' or aMaterno like '%" + Buscar + "%' or matricula like '%" + Buscar + "%' where estatus='A'");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(pnlCarreras.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
            Object[] valores = new Object[4];
            while (resultadoConsulta.next()) {
                for (int i = 0; i < 4; i++) {
                    valores[i] = resultadoConsulta.getObject(i + 1);
                }
                modeloTabla.addRow(valores);
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex);
        }
    }//GEN-LAST:event_txtBuscarCaretUpdate


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rscomponentshade.RSButtonShade btnBuscar;
    private rscomponentshade.RSButtonShade btnGenerar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private rojerusan.RSTableMetro jTable1;
    private rojerusan.RSTableMetro jTable2;
    private rscomponentshade.RSTextFieldShade txtBuscar;
    // End of variables declaration//GEN-END:variables

    public void abrirarchivo(String archivo) {
        try {
            File objetofile = new File(archivo);
            Desktop.getDesktop().open(objetofile);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    public void obtenFirmantes() {
        int i = 0;
        int j = 0;
        int valorTabla = jTable2.getRowCount();
        Integer[] seleccionado = new Integer[5];

        for (i = 0; i < jTable2.getRowCount(); i++) {
            try {
                TableModel model2 = jTable2.getModel();
                if ((model2.getValueAt(i, 4)) != null) {
                    seleccionado[i] = ((Integer) model2.getValueAt(i, 0));
                    System.out.println(seleccionado[i]);
                }
            } catch (Exception ex) {
                Logger.getLogger(pnlTxt.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        for (i = 0; i < 5; i++) {
            if (seleccionado[i] != null) {
                try {
                    try {
                        resultadoConsulta = conector.consulta("SELECT idResponsable, CURP, Puesto, abrev FROM Responsable where Clave=" + seleccionado[i]);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(pnlTxt.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    while (resultadoConsulta.next()) {
                        idResponsable = resultadoConsulta.getString("idResponsable");
                        curpResponsable = resultadoConsulta.getString("CURP");
                        puesto = resultadoConsulta.getString("Puesto");
                        abrTitulo = resultadoConsulta.getString("abrev");
                    }

                } catch (SQLException ex) {
                    Logger.getLogger(pnlTitulos.class.getName()).log(Level.SEVERE, null, ex);
                }
                firmantes[i] = "" + curpResponsable + "|" + idResponsable + "|" + puesto + "|" + abrTitulo + "|";
                System.out.println(firmantes[i]);

            } else {
            }
        }
    }

}
