/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paneles;

import java.sql.SQLException;
import CodeHelpers.ConexionesDB;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
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
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

public class pnlProfesionista extends javax.swing.JPanel {

    ConexionesDB conector = new ConexionesDB();
    ResultSet resultadoConsulta;
    DefaultTableModel modeloTabla;
    String Nombre = "", apellidoPaterno = "", apellidoMaterno = "";
    String CURP = "", correo = "", Matricula = "";
    String fechaInicioAntecedente = "", institucionProcedencia = "";
    String fechaTerminoAntecedente = "", tipodeEstudio = "", eFederativa = "";
    int idModalidadTitulacion = 0, idFundamentoLegalServicioSocial = 0;
    String idEntidadFederativa = "", noCedula = "", noRvoe = "";
    public static final String SEPARATOR = ",";

    public pnlProfesionista() {

        initComponents();

        modeloTabla = (DefaultTableModel) jTable1.getModel();
        btnBuscar.setEnabled(false);
        btnModificar.setEnabled(false);
        btnBorrar.setEnabled(false);

        tablaProfesionista();

        try {
            try {
                resultadoConsulta = conector.consulta("SELECT * FROM entidadFederativa");//establecimiento de sentencia aejecutar
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(pnlTitulos.class.getName()).log(Level.SEVERE, null, ex);
            }

            while (resultadoConsulta.next()) {
                ComboEFederativa.addItem(resultadoConsulta.getString("nombreEntidad"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(pnlTitulos.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            try {
                resultadoConsulta = conector.consulta("SELECT * FROM estudioAntecedente");//establecimiento de sentencia aejecutar
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(pnlTitulos.class.getName()).log(Level.SEVERE, null, ex);
            }

            while (resultadoConsulta.next()) {
                ComboTipoEstudio.addItem(resultadoConsulta.getString("tipoEstudioAntecedente"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(pnlTitulos.class.getName()).log(Level.SEVERE, null, ex);
        }

        txtMatricula.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char caracter = e.getKeyChar();

                // Verificar si la tecla pulsada no es un digito
                if (((caracter < '0') || (caracter > '9')) && (caracter != '\b' /*corresponde a BACK_SPACE*/)) {
                    e.consume();  // ignorar el evento de teclado
                    JOptionPane.showMessageDialog(null, "Unicamente numeros");
                }
            }
        });

    }

    public void tablaProfesionista() {
        try {
            int filas = jTable1.getRowCount(); //Obtiene la catidad de filas
            for (int i = 1; i <= filas; i++) { //For que se ecuta de acuerdo a la cantidad de filas que haya
                modeloTabla.removeRow(0); //metodo que elimina cada fila
            }
            try {
                resultadoConsulta = conector.consulta("SELECT Matricula, Nombre, apellidoPaterno, apellidoMaterno, CURP, Correo FROM Profesionista");

            } catch (ClassNotFoundException ex) {
                Logger.getLogger(pnlProfesionista.class.getName()).log(Level.SEVERE, null, ex);
            }
            Object[] valores = new Object[6];//Crea un arreglo de objetos un objeto puede 
            while (resultadoConsulta.next()) {
                for (int i = 0; i < 6; i++) {//El numero del for ebe ser igual al de la
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

        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        txtCURP = new rscomponentshade.RSTextFieldShade();
        txtCorreo = new rscomponentshade.RSTextFieldShade();
        txtMatricula = new rscomponentshade.RSTextFieldShade();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtapellidoMaterno = new rscomponentshade.RSTextFieldShade();
        txtNombre = new rscomponentshade.RSTextFieldShade();
        txtapellidoPaterno = new rscomponentshade.RSTextFieldShade();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        DateAntecInicio = new com.toedter.calendar.JDateChooser();
        jLabel30 = new javax.swing.JLabel();
        ComboEFederativa = new javax.swing.JComboBox<>();
        jLabel33 = new javax.swing.JLabel();
        txtProcedencia = new rscomponentshade.RSTextFieldShade();
        jLabel31 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        ComboTipoEstudio = new javax.swing.JComboBox<>();
        jLabel32 = new javax.swing.JLabel();
        txtNoCedula = new rscomponentshade.RSTextFieldShade();
        jLabel17 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        DateAntecTermino = new com.toedter.calendar.JDateChooser();
        rSButtonShade1 = new rscomponentshade.RSButtonShade();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new rojerusan.RSTableMetro();
        btnBuscar = new rscomponentshade.RSButtonShade();
        btnGuardar = new rscomponentshade.RSButtonShade();
        btnLimpia = new rscomponentshade.RSButtonShade();
        btnBorrar = new rscomponentshade.RSButtonShade();
        btnModificar = new rscomponentshade.RSButtonShade();
        txtBuscar = new rscomponentshade.RSTextFieldShade();

        setBackground(new java.awt.Color(243, 242, 242));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(671, 517));

        jLabel7.setFont(new java.awt.Font("Roboto", 1, 40)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(128, 128, 131));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img1/Estudiantes_1.png"))); // NOI18N
        jLabel7.setText("ALUMNOS");
        jLabel7.setIconTextGap(10);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 84, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(243, 242, 242));
        jPanel5.setBorder(null);

        jPanel3.setBackground(new java.awt.Color(243, 242, 242));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del Alumno"));

        txtCURP.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtCURP.setPlaceholder("CURP");

        txtCorreo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtCorreo.setPlaceholder("e-mail");

        txtMatricula.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtMatricula.setPlaceholder("Matricula");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Curp:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Correo Electrónico:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("Matricula:");

        txtapellidoMaterno.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtapellidoMaterno.setPlaceholder("Apellido Materno");

        txtNombre.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtNombre.setPlaceholder("Nombre");

        txtapellidoPaterno.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtapellidoPaterno.setPlaceholder("Apellido paterno");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Apellido Materno:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Nombre:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Apellido Paterno:");

        jPanel4.setBackground(new java.awt.Color(243, 242, 242));

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel27.setText("Institución de Procedencia:");

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel30.setText("Entidad Federativa:");

        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel33.setText("Fecha de Termino:");

        txtProcedencia.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtProcedencia.setPlaceholder("Institución de procedencia");

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel31.setText("Fecha de Inicio:");

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel29.setText("Tipo de Estudio de Antecedente:");

        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel32.setText("Número de Cédula:");

        txtNoCedula.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtNoCedula.setPlaceholder("Número de cédula");

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel17.setText("Status:");

        jRadioButton1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jRadioButton1.setText("Estudiante Activo");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel17)
                    .addComponent(jLabel31)
                    .addComponent(jLabel29)
                    .addComponent(jLabel27))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtProcedencia, javax.swing.GroupLayout.DEFAULT_SIZE, 392, Short.MAX_VALUE)
                            .addComponent(DateAntecInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ComboTipoEstudio, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(62, 62, 62)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel32)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtNoCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel33)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(DateAntecTermino, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel30)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ComboEFederativa, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jRadioButton1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jLabel33))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel30)
                                    .addComponent(ComboEFederativa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(DateAntecTermino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel32)
                            .addComponent(txtNoCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel27)
                            .addComponent(txtProcedencia, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(DateAntecInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel31))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ComboTipoEstudio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel29))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jRadioButton1)))
        );

        rSButtonShade1.setBackground(new java.awt.Color(204, 204, 204));
        rSButtonShade1.setText("Importar .csv");
        rSButtonShade1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonShade1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(52, 52, 52)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)))
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtapellidoPaterno, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtapellidoMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(244, 244, 244)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCURP, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 14, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(rSButtonShade1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)))
                .addGap(20, 20, 20))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtCURP, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6)))
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel9)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(txtMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtapellidoPaterno, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtapellidoMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rSButtonShade1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(243, 242, 242));
        jPanel2.setPreferredSize(new java.awt.Dimension(997, 2319));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Matricula", "Nombre", "Apellido Paterno", "Apellido Materno", "CURP", "e-mail", "Detalles"
            }
        ));
        jTable1.setColorBackgoundHead(new java.awt.Color(124, 20, 52));
        jTable1.setColorFilasBackgound2(new java.awt.Color(255, 204, 204));
        jTable1.setColorFilasForeground1(new java.awt.Color(124, 20, 52));
        jTable1.setColorFilasForeground2(new java.awt.Color(124, 20, 52));
        jTable1.setColorSelBackgound(new java.awt.Color(124, 20, 52));
        jTable1.setDoubleBuffered(true);
        jTable1.setDragEnabled(true);
        jTable1.setFuenteFilas(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTable1.setFuenteFilasSelect(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTable1.setGridColor(new java.awt.Color(255, 255, 255));
        jTable1.setMinimumSize(new java.awt.Dimension(45, 224));
        jTable1.setSelectionBackground(new java.awt.Color(124, 20, 52));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        btnBuscar.setBackground(new java.awt.Color(124, 20, 52));
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/lupa.png"))); // NOI18N
        btnBuscar.setBgHover(new java.awt.Color(124, 20, 52));
        btnBuscar.setBgShadeHover(new java.awt.Color(255, 204, 204));
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnGuardar.setBackground(new java.awt.Color(204, 255, 204));
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/salvar.png"))); // NOI18N
        btnGuardar.setBgHover(new java.awt.Color(255, 255, 255));
        btnGuardar.setBgShadeHover(new java.awt.Color(153, 255, 153));
        btnGuardar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnGuardar.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnGuardarMouseMoved(evt);
            }
        });
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnLimpia.setBackground(new java.awt.Color(255, 255, 153));
        btnLimpia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/goma-de-borrar.png"))); // NOI18N
        btnLimpia.setBgHover(new java.awt.Color(255, 255, 255));
        btnLimpia.setBgShadeHover(new java.awt.Color(255, 255, 102));
        btnLimpia.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnLimpia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiaActionPerformed(evt);
            }
        });

        btnBorrar.setBackground(new java.awt.Color(255, 102, 102));
        btnBorrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/compartimiento.png"))); // NOI18N
        btnBorrar.setBgHover(new java.awt.Color(255, 255, 255));
        btnBorrar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });

        btnModificar.setBackground(new java.awt.Color(204, 204, 255));
        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/documento.png"))); // NOI18N
        btnModificar.setBgHover(new java.awt.Color(255, 255, 255));
        btnModificar.setBgShadeHover(new java.awt.Color(51, 51, 255));
        btnModificar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLimpia, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnModificar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnLimpia, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1038, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1044, Short.MAX_VALUE)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        txtMatricula.setEditable(false);
        int seleccionada = jTable1.rowAtPoint((evt.getPoint()));
        txtMatricula.setText(String.valueOf(jTable1.getValueAt(seleccionada, 0)));
        txtNombre.setText(String.valueOf(jTable1.getValueAt(seleccionada, 1)));
        txtapellidoPaterno.setText(String.valueOf(jTable1.getValueAt(seleccionada, 2)));
        txtapellidoMaterno.setText(String.valueOf(jTable1.getValueAt(seleccionada, 3)));
        txtCURP.setText(String.valueOf(jTable1.getValueAt(seleccionada, 4)));
        txtCorreo.setText(String.valueOf(jTable1.getValueAt(seleccionada, 5)));

        btnModificar.setEnabled(true);
        btnBorrar.setEnabled(true);
        btnGuardar.setEnabled(false);

    }//GEN-LAST:event_jTable1MouseClicked

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        capturarDatos();
        regitroBaseDatos();
        limpiar();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnLimpiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiaActionPerformed
        limpiar();
    }//GEN-LAST:event_btnLimpiaActionPerformed

    private void btnGuardarMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseMoved
        // Patrón para validar el email
        Pattern pattern = Pattern
                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

        // El email a validar
        String email = txtCorreo.getText();

        Matcher mather = pattern.matcher(email);

        if (mather.find() == true) {
            btnGuardar.setEnabled(true);
        } else {
            JOptionPane.showMessageDialog(null, "El email ingresado es inválido\nCorrija y vuelva a intentar");
            txtCorreo.setText("");
            btnGuardar.setEnabled(false);
        }
    }//GEN-LAST:event_btnGuardarMouseMoved

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed

        int reply = JOptionPane.showConfirmDialog(null, "¿Eliminar registro?", "¡¡Advertencia!!", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
            try {
                System.out.println("eliminar");
                String salida = conector.eliminar("Delete from Profesionista where Matricula ='" + txtMatricula.getText() + "'");
                System.out.println(salida);
            } catch (Exception e) {
                System.out.println(e);
            }
            JOptionPane.showMessageDialog(null, "Registro eliminado :( ");
            tablaProfesionista();
            btnBorrar.setEnabled(false);
            btnModificar.setEnabled(false);
            btnGuardar.setEnabled(true);
            limpiar();
        } else {

        }

    }//GEN-LAST:event_btnBorrarActionPerformed

    private void rSButtonShade1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonShade1ActionPerformed
        String ruta = "";
        Scanner entrada = null;
        //Se crea el JFileChooser. Se le indica que la ventana se abra en el directorio actual
        JFileChooser fileChooser = new JFileChooser(".");
        //Se crea el filtro. El primer parámetro es el mensaje que se muestra,
        //el segundo es la extensión de los ficheros que se van a mostrar      
        FileFilter filtro = new FileNameExtensionFilter("Archivos csv (.csv)", "csv");
        //Se le asigna al JFileChooser el filtro
        fileChooser.setFileFilter(filtro);
        //se muestra la ventana
        int valor = fileChooser.showOpenDialog(fileChooser);
        if (valor == JFileChooser.APPROVE_OPTION) {
            ruta = fileChooser.getSelectedFile().getAbsolutePath();
            try {
                File f = new File(ruta);
                entrada = new Scanner(f);
                while (entrada.hasNext()) {
                    entrada.nextLine();//sout
                }
            } catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
            } finally {
                if (entrada != null) {
                    entrada.close();
                }
            }
            System.out.println(ruta);
        } else {
            System.out.println("No se ha seleccionado ningún fichero");
        }

        BufferedReader br = null;

        try {

            br = new BufferedReader(new FileReader(ruta));
            String line = br.readLine();
            while (null != line) {

                String[] fields = line.split(SEPARATOR);
                String listString = String.join("' , '", fields);
                line = br.readLine();
                System.out.println(listString);

                try {
                    String salida = conector.registrar("INSERT INTO Profesionista(Matricula, Nombre, apellidoPaterno, apellidoMaterno, CURP, correo) VALUES ('" + listString + "')");
                    System.out.println(salida);

                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(pnlProfesionista.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        } catch (Exception e) {

        } finally {
            if (null != br) {
                try {
                    br.close();
                } catch (IOException ex) {
                    Logger.getLogger(pnlProfesionista.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        JOptionPane.showMessageDialog(null, "Los datos se han registrado bien  ");
        tablaProfesionista();
    }//GEN-LAST:event_rSButtonShade1ActionPerformed

    private void txtBuscarCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtBuscarCaretUpdate
        String Buscar = txtBuscar.getText();
        try {
            int filas = jTable1.getRowCount(); //Obtiene la catidad de filas
            for (int i = 1; i <= filas; i++) { //For que se ecuta de acuerdo a la cantidad de filas que haya
                modeloTabla.removeRow(0); //metodo que elimina cada fila
            }
            try {
                resultadoConsulta = conector.consulta("select * from Carreras where IdCarrera like '%" + Buscar + "%' or noRvoe like '%" + Buscar + "%' or Carrera like '%" + Buscar + "%' ");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(pnlCarreras.class.getName()).log(Level.SEVERE, null, ex);
            }
            Object[] valores = new Object[3];//Crea un arreglo de objetos un objeto puede
            while (resultadoConsulta.next()) {
                for (int i = 0; i < 3; i++) {//El numero del for ebe ser igual al de la
                    valores[i] = resultadoConsulta.getObject(i + 1); //
                }
                modeloTabla.addRow(valores);//añade una nueva fila con los datos que
                //esten en cada psocion del arreglo de objetos
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex);
        }
    }//GEN-LAST:event_txtBuscarCaretUpdate

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboEFederativa;
    private javax.swing.JComboBox<String> ComboTipoEstudio;
    private com.toedter.calendar.JDateChooser DateAntecInicio;
    private com.toedter.calendar.JDateChooser DateAntecTermino;
    private rscomponentshade.RSButtonShade btnBorrar;
    private rscomponentshade.RSButtonShade btnBuscar;
    private rscomponentshade.RSButtonShade btnGuardar;
    private rscomponentshade.RSButtonShade btnLimpia;
    private rscomponentshade.RSButtonShade btnModificar;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private rojerusan.RSTableMetro jTable1;
    private rscomponentshade.RSButtonShade rSButtonShade1;
    private rscomponentshade.RSTextFieldShade txtBuscar;
    private rscomponentshade.RSTextFieldShade txtCURP;
    private rscomponentshade.RSTextFieldShade txtCorreo;
    private rscomponentshade.RSTextFieldShade txtMatricula;
    private rscomponentshade.RSTextFieldShade txtNoCedula;
    private rscomponentshade.RSTextFieldShade txtNombre;
    private rscomponentshade.RSTextFieldShade txtProcedencia;
    private rscomponentshade.RSTextFieldShade txtapellidoMaterno;
    private rscomponentshade.RSTextFieldShade txtapellidoPaterno;
    // End of variables declaration//GEN-END:variables

    public void capturarDatos() {
        Matricula = txtMatricula.getText();
        Nombre = txtNombre.getText().toUpperCase();
        apellidoPaterno = txtapellidoPaterno.getText().toUpperCase();
        apellidoMaterno = txtapellidoMaterno.getText().toUpperCase();
        CURP = txtCURP.getText().toUpperCase();
        correo = txtCorreo.getText();
    }

    public void regitroBaseDatos() {
        try {
            String salida = conector.registrar("INSERT INTO Profesionista(Matricula, Nombre, apellidoPaterno, apellidoMaterno, CURP, correo) VALUES ('" + Matricula + "','" + Nombre + "','" + apellidoPaterno
                    + "','" + apellidoMaterno + "','" + CURP + "','" + correo + "')");
            System.out.println(salida);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(pnlProfesionista.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(null, "Los datos se han registrado bien  ");
        tablaProfesionista();
    }

    public void limpiar() {
        txtMatricula.setText("");
        txtNombre.setText("");
        txtapellidoPaterno.setText("");
        txtapellidoMaterno.setText("");
        txtCURP.setText("");
        txtCorreo.setText("");

        DateAntecInicio.setDate(null);
        DateAntecTermino.setDate(null);
        txtProcedencia.setText("");
        txtNoCedula.setText("");

        txtMatricula.setEnabled(true);
        btnModificar.setEnabled(false);
        btnBorrar.setEnabled(false);
        btnGuardar.setEnabled(true);
    }

}
