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
import java.sql.Statement;
import java.text.SimpleDateFormat;
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
    String idTipoEstudioAntecedente = "";
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
                resultadoConsulta = conector.consulta("call nombreEntidadFederativa");
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

        txtNoCedula.addKeyListener(new KeyAdapter() {
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
        jLabel27 = new javax.swing.JLabel();
        txtProcedencia = new rscomponentshade.RSTextFieldShade();
        jLabel30 = new javax.swing.JLabel();
        ComboEFederativa = new javax.swing.JComboBox<>();
        jLabel31 = new javax.swing.JLabel();
        DateAntecInicio = new com.toedter.calendar.JDateChooser();
        jLabel33 = new javax.swing.JLabel();
        DateAntecTermino = new com.toedter.calendar.JDateChooser();
        jLabel29 = new javax.swing.JLabel();
        ComboTipoEstudio = new javax.swing.JComboBox<>();
        jLabel32 = new javax.swing.JLabel();
        txtNoCedula = new rscomponentshade.RSTextFieldShade();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnBuscar = new rscomponentshade.RSButtonShade();
        btnGuardar = new rscomponentshade.RSButtonShade();
        btnLimpia = new rscomponentshade.RSButtonShade();
        btnBorrar = new rscomponentshade.RSButtonShade();
        btnModificar = new rscomponentshade.RSButtonShade();
        txtBuscar = new rscomponentshade.RSTextFieldShade();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new rojerusan.RSTableMetro();

        setBackground(new java.awt.Color(243, 242, 242));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(671, 517));

        jLabel7.setFont(new java.awt.Font("Roboto", 1, 48)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(128, 128, 131));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img1/Estudiantes_1.png"))); // NOI18N
        jLabel7.setText("ALUMNOS");
        jLabel7.setMaximumSize(new java.awt.Dimension(357, 96));
        jLabel7.setMinimumSize(new java.awt.Dimension(350, 104));
        jLabel7.setPreferredSize(new java.awt.Dimension(357, 96));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 1024, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 4, Short.MAX_VALUE)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel5.setBackground(new java.awt.Color(243, 242, 242));

        jPanel3.setBackground(new java.awt.Color(243, 242, 242));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Editar Datos del Alumno.", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("sansserif", 1, 14))); // NOI18N

        txtCURP.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtCURP.setPlaceholder("CURP");

        txtCorreo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtCorreo.setPlaceholder("e-mail");

        txtMatricula.setDisabledTextColor(new java.awt.Color(0, 0, 0));
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

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel27.setText("Instituto:");

        txtProcedencia.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtProcedencia.setPlaceholder("Institución de procedencia");

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel30.setText("Entidad Federativa:");

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel31.setText("Fecha de Inicio:");

        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel33.setText("Fecha de Termino:");

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel29.setText("Antecedente Escolar:");

        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel32.setText("Número de Cédula:");

        txtNoCedula.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtNoCedula.setPlaceholder("Número de cédula");

        jLabel5.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(153, 153, 153));
        jLabel5.setText("Datos Académicos Anteriores.");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel32)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNoCedula, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                            .addComponent(txtapellidoPaterno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtMatricula, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtapellidoMaterno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel27)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtProcedencia, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel5)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel29)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ComboTipoEstudio, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel33)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(jLabel31)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(DateAntecInicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(DateAntecTermino, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                                .addGap(4, 4, 4))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel9)
                            .addComponent(jLabel30))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtCURP, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                            .addComponent(ComboEFederativa, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))))
                .addGap(148, 148, 148))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtProcedencia, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel27))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel29)
                                    .addComponent(ComboTipoEstudio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(DateAntecInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(DateAntecTermino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCURP, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel30)
                            .addComponent(ComboEFederativa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel31)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel33)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(txtNoCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(243, 242, 242));
        jPanel2.setPreferredSize(new java.awt.Dimension(997, 2319));

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

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Matricula", "Nombre", "Apellido Paterno", "Apellido Materno", "CURP", "e-mail"
            }
        ));
        jTable1.setAutoscrolls(false);
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
        jTable1.setSelectionBackground(new java.awt.Color(124, 20, 52));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1012, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(566, Short.MAX_VALUE)
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
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnLimpia, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(122, 122, 122))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1018, Short.MAX_VALUE))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1030, Short.MAX_VALUE)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(59, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        txtMatricula.setEnabled(false);
        int seleccionada = jTable1.rowAtPoint((evt.getPoint()));
        txtMatricula.setText(String.valueOf(jTable1.getValueAt(seleccionada, 0)));
        txtNombre.setText(String.valueOf(jTable1.getValueAt(seleccionada, 1)));
        txtapellidoPaterno.setText(String.valueOf(jTable1.getValueAt(seleccionada, 2)));
        txtapellidoMaterno.setText(String.valueOf(jTable1.getValueAt(seleccionada, 3)));
        txtCURP.setText(String.valueOf(jTable1.getValueAt(seleccionada, 4)));
        txtCorreo.setText(String.valueOf(jTable1.getValueAt(seleccionada, 5)));

        Matricula = String.valueOf(jTable1.getValueAt(seleccionada, 0));

        try {
            try {
                resultadoConsulta = conector.consulta("SELECT * FROM Profesionista where Matricula='" + Matricula + "'");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(pnlResponsables.class.getName()).log(Level.SEVERE, null, ex);
            }
            while (resultadoConsulta.next()) {
                txtProcedencia.setText(resultadoConsulta.getString("institucionProcedencia"));
                DateAntecInicio.setDate(resultadoConsulta.getDate("fechaAntInicio"));
                DateAntecTermino.setDate(resultadoConsulta.getDate("fechaAntTermino"));
                ComboTipoEstudio.setSelectedItem(resultadoConsulta.getString("tipodeEstudio"));
                ComboEFederativa.setSelectedItem(resultadoConsulta.getString("eFederativa"));
                txtNoCedula.setText(resultadoConsulta.getString("noCedula"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(pnlTitulos.class.getName()).log(Level.SEVERE, null, ex);
        }

        btnModificar.setEnabled(true);
        btnBorrar.setEnabled(true);
        btnGuardar.setEnabled(false);

    }//GEN-LAST:event_jTable1MouseClicked

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed

        int reply = JOptionPane.showConfirmDialog(null, "¿Modificar registro?", "¡¡Advertencia!!", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
            try {

                capturarDatos();
                System.out.println("modificar");

                String sql = "Update Profesionista set Matricula=" + Matricula + ", Nombre='" + Nombre
                        + "', apellidoPaterno='" + apellidoPaterno + "', apellidoMaterno='" + apellidoMaterno
                        + "', CURP='" + CURP + "', Correo='" + correo + "', institucionProcedencia='" + institucionProcedencia
                        + "', idEntidadFederativa='" + idEntidadFederativa + "', fechaAntInicio='" + fechaInicioAntecedente + "', fechaAntTermino='" + fechaTerminoAntecedente
                        + "', idTipoEstudioAntecedente='" + idTipoEstudioAntecedente + "',tipodeEstudio='" + tipodeEstudio + "', eFederativa='" + eFederativa
                        + "', noCedula='" + noCedula + "' where Matricula='" + txtMatricula.getText() + "'";

                System.out.println(sql);
                String salida = conector.registrar(sql);

            } catch (Exception e) {
                System.out.println(e);
            }
            JOptionPane.showMessageDialog(null, "Registro modificado ");

            btnBorrar.setEnabled(false);
            btnModificar.setEnabled(false);
            btnGuardar.setEnabled(true);
            limpiar();
        } else {

        }
        tablaProfesionista();

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

        if (txtMatricula.getText() == "" || txtNombre.getText() == "" || txtapellidoPaterno.getText() == ""
                || txtCURP.getText() == "" || txtProcedencia.getText() == "" || txtNoCedula.getText() == ""
                || DateAntecInicio.getDate() == null || DateAntecTermino.getDate() == null) {
            btnGuardar.setEnabled(false);
            JOptionPane.showMessageDialog(null, "No deben haber campos vacios, termina");
        } else {
            btnGuardar.setEnabled(true);
        }

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

        try {
            try {
                resultadoConsulta = conector.consulta("SELECT Matricula FROM Profesionista where Matricula = " + txtMatricula.getText());//establecimiento de sentencia aejecutar
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(pnlProfesionista.class.getName()).log(Level.SEVERE, null, ex);
            }
            while (resultadoConsulta.next()) {

                if (resultadoConsulta.getString("Matricula") != null || resultadoConsulta.getString("Matricula") != "") {
                    JOptionPane.showMessageDialog(null, "La matricula ya fue registrada\nCorrija y vuelva a intentar");
                    btnGuardar.setEnabled(false);
                } else {
                    btnGuardar.setEnabled(true);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(pnlProfesionista.class.getName()).log(Level.SEVERE, null, ex);
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

    private void txtBuscarCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtBuscarCaretUpdate
        String Buscar = txtBuscar.getText();
        try {
            int filas = jTable1.getRowCount();
            for (int i = 1; i <= filas; i++) {
                modeloTabla.removeRow(0);
            }
            try {
                resultadoConsulta = conector.consulta("select * from Profesionista where Matricula like '%"
                        + Buscar + "%' or Nombre like '%"
                        + Buscar + "%' or apellidoPaterno like '%"
                        + Buscar + "%' or apellidoMaterno like '%"
                        + Buscar + "%' or CURP like '%"
                        + Buscar + "%' or Correo like '%"
                        + Buscar + "%' ");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(pnlCarreras.class.getName()).log(Level.SEVERE, null, ex);
            }
            Object[] valores = new Object[6];
            while (resultadoConsulta.next()) {
                for (int i = 0; i < 6; i++) {
                    valores[i] = resultadoConsulta.getObject(i + 1); //
                }
                modeloTabla.addRow(valores);
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private rojerusan.RSTableMetro jTable1;
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

        institucionProcedencia = txtProcedencia.getText();
        institucionProcedencia = institucionProcedencia.toUpperCase();
        tipodeEstudio = (String) ComboTipoEstudio.getSelectedItem();

        try {
            try {
                resultadoConsulta = conector.consulta("SELECT idTipoAntecedente FROM estudioAntecedente where tipoEstudioAntecedente='" + tipodeEstudio + "'");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(pnlTitulos.class.getName()).log(Level.SEVERE, null, ex);
            }
            while (resultadoConsulta.next()) {
                idTipoEstudioAntecedente = resultadoConsulta.getString("idTipoAntecedente");
            }
        } catch (SQLException ex) {
            Logger.getLogger(pnlTitulos.class.getName()).log(Level.SEVERE, null, ex);
        }

        eFederativa = (String) ComboEFederativa.getSelectedItem();

        try {
            try {
                resultadoConsulta = conector.consulta("SELECT id_EntidadF FROM entidadFederativa where nombreEntidad='" + eFederativa + "'");//establecimiento de sentencia aejecutar
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(pnlTitulos.class.getName()).log(Level.SEVERE, null, ex);
            }
            while (resultadoConsulta.next()) {
                idEntidadFederativa = resultadoConsulta.getString("id_EntidadF");
            }
        } catch (SQLException ex) {
            Logger.getLogger(pnlTitulos.class.getName()).log(Level.SEVERE, null, ex);
        }

        Date fecha5 = DateAntecInicio.getDate();
        SimpleDateFormat sdf5 = new SimpleDateFormat("yyyy-MM-dd");
        fechaInicioAntecedente = sdf5.format(fecha5);
        Date fecha6 = DateAntecTermino.getDate();
        SimpleDateFormat sdf6 = new SimpleDateFormat("yyyy-MM-dd");
        fechaTerminoAntecedente = sdf6.format(fecha6);
        noCedula = txtNoCedula.getText();

    }

    public void regitroBaseDatos() {
        try {

            String sql = "INSERT INTO Profesionista(Matricula, Nombre, apellidoPaterno, "
                    + "apellidoMaterno, correo, CURP, institucionProcedencia,idEntidadFederativa,eFederativa,"
                    + "fechaAntInicio,fechaAntTermino,idTipoEstudioAntecedente,tipodeEstudio,"
                    + "noCedula,estatus) VALUES ('" + Matricula + "','" + Nombre + "','" + apellidoPaterno + "','"
                    + apellidoMaterno + "','" + correo + "','" + CURP + "','"
                    + institucionProcedencia + "','" + idEntidadFederativa + "','"
                    + eFederativa + "','" + fechaInicioAntecedente + "','" + fechaTerminoAntecedente + "','"
                    + idTipoEstudioAntecedente + "','" + tipodeEstudio + "','" + noCedula + "','A')";

            System.out.println(sql);
            String salida = conector.registrar(sql);

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
