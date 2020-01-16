/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paneles;

import CodeHelpers.ConexionesDB;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author RojeruSan
 */
public class pnlTitulos extends javax.swing.JPanel {

    ConexionesDB conector = new ConexionesDB();
    ResultSet resultadoConsulta;

    String contenido = "";
    String curpResponsable = "";
    int idCargo = 0;
    String cargo = "";
    String abrTitulo = "";

    String clave = "";
    String nombreCarrera = "";
    String numeroRvoe = "";
    int clave_autorizacion = 0;
    String autorizacion_reconocimiento = "";

    /**
     * *****************************************
     */
    String nombre = "", aPaterno = "", aMaterno = "";
    String matricula = "", correo = "", CURP = "";
    String fechaCarreraInicio = "", fechaCarreraTermino = "";

    String fechaInicioAntecedente = "", institucionProcedencia = "";
    String fechaTerminoAntecedente = "", tipodeEstudio = "", eFederativa = "";
    int idModalidadTitulacion = 0, idFundamentoLegalServicioSocial = 0;
    String idEntidadFederativa = "", noCedula = "", noRvoe = "";

    /**
     * *****************************************
     */
    String fechaExpedicion = "", modalidadTitulacion = "", fundamentoSS = "";
    String fechaExamen = "", folioControl = "";
    int sSocial = 0;

    int idTipoEstudioAntecedente = 0;

    public pnlTitulos() {
        initComponents();

        txtCURP.setEnabled(false);
        txtCorreo.setEnabled(false);

        try {
            try {
                resultadoConsulta = conector.consulta("SELECT Matricula, Nombre, apellidoPaterno, apellidoMaterno FROM Profesionista");//establecimiento de sentencia aejecutar
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(pnlTitulos.class.getName()).log(Level.SEVERE, null, ex);
            }

            while (resultadoConsulta.next()) {
                ComboProfesionista.addItem(resultadoConsulta.getString("Matricula") + " - " + resultadoConsulta.getString("Nombre") + " " + resultadoConsulta.getString("apellidoPaterno") + " " + resultadoConsulta.getString("apellidoMaterno"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(pnlTitulos.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            try {
                resultadoConsulta = conector.consulta("SELECT * FROM autorizacionRec");//establecimiento de sentencia aejecutar
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(pnlTitulos.class.getName()).log(Level.SEVERE, null, ex);
            }

            while (resultadoConsulta.next()) {
                ComboautReconocimiento.addItem(resultadoConsulta.getString("AUTORIZACIÓN_RECONOCIMIENTO"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(pnlTitulos.class.getName()).log(Level.SEVERE, null, ex);
        }

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

        try {
            try {
                resultadoConsulta = conector.consulta("SELECT * FROM modalidadTitulacion");//establecimiento de sentencia aejecutar
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(pnlTitulos.class.getName()).log(Level.SEVERE, null, ex);
            }

            while (resultadoConsulta.next()) {
                CombomodalidadTit.addItem(resultadoConsulta.getString("MODALIDAD_TITULACIÓN"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(pnlTitulos.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            try {
                resultadoConsulta = conector.consulta("SELECT * FROM fundamentoSSocial");//establecimiento de sentencia aejecutar
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(pnlTitulos.class.getName()).log(Level.SEVERE, null, ex);
            }

            while (resultadoConsulta.next()) {
                ComboFLegal.addItem(resultadoConsulta.getString("FUNDAMENTO_LEGAL_SERVICIO_SOCIAL"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(pnlTitulos.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            try {
                resultadoConsulta = conector.consulta("SELECT * FROM Carreras");//establecimiento de sentencia aejecutar
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(pnlTitulos.class.getName()).log(Level.SEVERE, null, ex);
            }

            while (resultadoConsulta.next()) {
                ComboCarrera.addItem(resultadoConsulta.getString("Carrera"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(pnlTitulos.class.getName()).log(Level.SEVERE, null, ex);
        }
           

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel7 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        ComboCarrera = new javax.swing.JComboBox<>();
        jLabel24 = new javax.swing.JLabel();
        ComboautReconocimiento = new javax.swing.JComboBox<>();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        DateFechaInicio = new com.toedter.calendar.JDateChooser();
        DateFechaTermino = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        DateExpedicion = new com.toedter.calendar.JDateChooser();
        jLabel16 = new javax.swing.JLabel();
        DateExamenP = new com.toedter.calendar.JDateChooser();
        jLabel14 = new javax.swing.JLabel();
        DateExamenP1 = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        CombomodalidadTit = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        txtCorreo1 = new rscomponentshade.RSTextFieldShade();
        jPanel1 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        ComboProfesionista = new javax.swing.JComboBox<>();
        txtCURP = new rscomponentshade.RSTextFieldShade();
        jLabel17 = new javax.swing.JLabel();
        ComboSSocial = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        ComboFLegal = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        txtCorreo = new rscomponentshade.RSTextFieldShade();
        jLabel15 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        rSButtonShade1 = new rscomponentshade.RSButtonShade();
        rSButtonShade2 = new rscomponentshade.RSButtonShade();
        rSButtonShade3 = new rscomponentshade.RSButtonShade();
        rSButtonShade4 = new rscomponentshade.RSButtonShade();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel7.setFont(new java.awt.Font("Roboto", 1, 48)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(128, 128, 131));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img1/feeedback.png"))); // NOI18N
        jLabel7.setText("TÍTULOS");

        jPanel3.setBackground(new java.awt.Color(243, 242, 242));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del Título"));
        jPanel3.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jPanel3MouseMoved(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(243, 242, 242));
        jPanel2.setBorder(null);

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel21.setText("Nombre de la Carrera");

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel24.setText("Autorización o Reconocimiento");

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel22.setText("Feha de Inicio");

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel23.setText("Fecha Termino");

        jLabel5.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(153, 153, 153));
        jLabel5.setText("Datos de  la Carrera");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel23)
                            .addComponent(jLabel22)
                            .addComponent(jLabel21))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(ComboCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel24)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ComboautReconocimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(DateFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(DateFechaTermino, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(ComboCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ComboautReconocimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel22)
                    .addComponent(DateFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23)
                    .addComponent(DateFechaTermino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel5.setBackground(new java.awt.Color(243, 242, 242));
        jPanel5.setBorder(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Fecha de Expedición");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel16.setText("Fecha de Examen Profesional");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setText("Fecha de Excención Profesional");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Folio");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Modalidad de Titulación");

        txtCorreo1.setBgShadeHover(new java.awt.Color(0, 0, 0));
        txtCorreo1.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtCorreo1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtCorreo1.setPlaceholder("Folio de Título");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel14))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(CombomodalidadTit, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtCorreo1, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DateExamenP1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DateExamenP, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DateExpedicion, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(DateExpedicion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DateExamenP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtCorreo1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(CombomodalidadTit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DateExamenP1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );

        jPanel1.setBackground(new java.awt.Color(243, 242, 242));
        jPanel1.setBorder(null);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setText("Nombre");

        txtCURP.setBgShadeHover(new java.awt.Color(0, 0, 0));
        txtCURP.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtCURP.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtCURP.setPlaceholder("CURP");
        txtCURP.setSelectionColor(new java.awt.Color(0, 0, 0));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel17.setText("Servicio Social");

        ComboSSocial.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Si", "No" }));

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel18.setText("Fundamento Legal del Servicio Social");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setText("CURP");

        txtCorreo.setBgShadeHover(new java.awt.Color(0, 0, 0));
        txtCorreo.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtCorreo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtCorreo.setPlaceholder("Correo");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel15.setText("Correo");

        jLabel3.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 153, 153));
        jLabel3.setText("Datos del Alumno");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel13)
                    .addComponent(jLabel15)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtCURP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ComboProfesionista, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ComboFLegal, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ComboSSocial, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(ComboProfesionista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(txtCURP, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(ComboSSocial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ComboFLegal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18))))
                .addContainerGap())
        );

        rSButtonShade1.setBackground(new java.awt.Color(204, 255, 204));
        rSButtonShade1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/salvar.png"))); // NOI18N
        rSButtonShade1.setBgHover(new java.awt.Color(255, 255, 255));
        rSButtonShade1.setBgShadeHover(new java.awt.Color(153, 255, 153));
        rSButtonShade1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonShade1ActionPerformed(evt);
            }
        });

        rSButtonShade2.setBackground(new java.awt.Color(255, 255, 153));
        rSButtonShade2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/goma-de-borrar.png"))); // NOI18N
        rSButtonShade2.setBgHover(new java.awt.Color(255, 255, 255));
        rSButtonShade2.setBgShadeHover(new java.awt.Color(255, 255, 102));
        rSButtonShade2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonShade2ActionPerformed(evt);
            }
        });

        rSButtonShade3.setBackground(new java.awt.Color(255, 102, 102));
        rSButtonShade3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/compartimiento.png"))); // NOI18N
        rSButtonShade3.setBgHover(new java.awt.Color(255, 255, 255));
        rSButtonShade3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonShade3ActionPerformed(evt);
            }
        });

        rSButtonShade4.setBackground(javax.swing.UIManager.getDefaults().getColor("ArrowButton.disabled"));
        rSButtonShade4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/ojo.png"))); // NOI18N
        rSButtonShade4.setBgHover(new java.awt.Color(255, 255, 255));
        rSButtonShade4.setBgShadeHover(new java.awt.Color(153, 153, 153));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 709, Short.MAX_VALUE)
                        .addComponent(rSButtonShade4, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rSButtonShade3, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rSButtonShade2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rSButtonShade1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rSButtonShade1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rSButtonShade2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rSButtonShade3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rSButtonShade4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel3MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseMoved
      try {
            try {
            String string = (String) ComboProfesionista.getSelectedItem();
            String[] parts = string.split(" ");
            String Matricula = parts[0];

            string = "SELECT * FROM Profesionista where Matricula='" + Matricula + "'";
            //System.out.println(string);
            
            resultadoConsulta = conector.consulta(string);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(pnlTitulos.class.getName()).log(Level.SEVERE, null, ex);
            }
            while (resultadoConsulta.next()) {
                matricula = resultadoConsulta.getString("Matricula");
                txtCURP.setText(resultadoConsulta.getString("CURP"));
                txtCorreo.setText(resultadoConsulta.getString("Correo"));
                nombre = resultadoConsulta.getString("Nombre");
                aPaterno = resultadoConsulta.getString("apellidoPaterno");
                aMaterno = resultadoConsulta.getString("apellidoMaterno");
                CURP = resultadoConsulta.getString("CURP");
                correo = resultadoConsulta.getString("Correo");
            }
        } catch (SQLException ex) {
            Logger.getLogger(pnlTitulos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jPanel3MouseMoved

    private void rSButtonShade1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonShade1ActionPerformed
    capturarDatos();
    regitroBaseDatos();
    }//GEN-LAST:event_rSButtonShade1ActionPerformed

    private void rSButtonShade2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonShade2ActionPerformed
    limpiar();
    }//GEN-LAST:event_rSButtonShade2ActionPerformed

    private void rSButtonShade3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonShade3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rSButtonShade3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboCarrera;
    private javax.swing.JComboBox<String> ComboFLegal;
    private javax.swing.JComboBox<String> ComboProfesionista;
    private javax.swing.JComboBox<String> ComboSSocial;
    private javax.swing.JComboBox<String> ComboautReconocimiento;
    private javax.swing.JComboBox<String> CombomodalidadTit;
    private com.toedter.calendar.JDateChooser DateExamenP;
    private com.toedter.calendar.JDateChooser DateExamenP1;
    private com.toedter.calendar.JDateChooser DateExpedicion;
    private com.toedter.calendar.JDateChooser DateFechaInicio;
    private com.toedter.calendar.JDateChooser DateFechaTermino;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private rscomponentshade.RSButtonShade rSButtonShade1;
    private rscomponentshade.RSButtonShade rSButtonShade2;
    private rscomponentshade.RSButtonShade rSButtonShade3;
    private rscomponentshade.RSButtonShade rSButtonShade4;
    private rscomponentshade.RSTextFieldShade txtCURP;
    private rscomponentshade.RSTextFieldShade txtCorreo;
    private rscomponentshade.RSTextFieldShade txtCorreo1;
    // End of variables declaration//GEN-END:variables

    public void datosCarrera() {
        nombreCarrera = (String) ComboCarrera.getSelectedItem();
        autorizacion_reconocimiento = (String) ComboautReconocimiento.getSelectedItem();
        Date fecha1 = DateFechaInicio.getDate();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        fechaCarreraInicio = sdf.format(fecha1);
        Date fecha2 = DateFechaTermino.getDate();
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
        fechaCarreraInicio = sdf2.format(fecha2);
    }

    public void datosExpedicion() {
        folioControl = txtFolio.getText();
        modalidadTitulacion = (String) CombomodalidadTit.getSelectedItem();
        Date fecha4 = DateExamenP.getDate();
        SimpleDateFormat sdf4 = new SimpleDateFormat("yyyy-MM-dd");
        fechaExamen = sdf4.format(fecha4);

        if ((String) ComboSSocial.getSelectedItem() == "No") {
            sSocial = 0;
        } else {
            sSocial = 1;
        }

        fundamentoSS = (String) ComboFLegal.getSelectedItem();
        Date fecha3 = DateExpedicion.getDate();
        SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd");
        fechaExpedicion = sdf3.format(fecha3);

    }

    public void datosAntecedentes() {
        institucionProcedencia = txtProcedencia.getText();
        institucionProcedencia = institucionProcedencia.toUpperCase();
        tipodeEstudio = (String) ComboTipoEstudio.getSelectedItem();
        eFederativa = (String) ComboEFederativa.getSelectedItem();
        Date fecha5 = DateAntecInicio.getDate();
        SimpleDateFormat sdf5 = new SimpleDateFormat("yyyy-MM-dd");
        fechaInicioAntecedente = sdf5.format(fecha5);
        Date fecha6 = DateAntecTermino.getDate();
        SimpleDateFormat sdf6 = new SimpleDateFormat("yyyy-MM-dd");
        fechaTerminoAntecedente = sdf6.format(fecha6);
        noCedula = txtNoCedula.getText();
    }

    public void capturarDatos() {

        datosCarrera();
        datosExpedicion();
        datosAntecedentes();

        try {
            try {
                resultadoConsulta = conector.consulta("SELECT CLAVE FROM modalidadTitulacion where MODALIDAD_TITULACIÓN='" + modalidadTitulacion + "'");//establecimiento de sentencia aejecutar
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(pnlTitulos.class.getName()).log(Level.SEVERE, null, ex);
            }
            while (resultadoConsulta.next()) {
                idModalidadTitulacion = resultadoConsulta.getInt("CLAVE");
                if (idModalidadTitulacion == 6) {
                    modalidadTitulacion = "OTRO";
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(pnlTitulos.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            try {
                resultadoConsulta = conector.consulta("SELECT ID_AUTORIZACION_RECONOCIMIENTO FROM autorizacionRec where AUTORIZACIÓN_RECONOCIMIENTO='" + autorizacion_reconocimiento + "'");//establecimiento de sentencia aejecutar
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(pnlTitulos.class.getName()).log(Level.SEVERE, null, ex);
            }
            while (resultadoConsulta.next()) {
                clave_autorizacion = resultadoConsulta.getInt("ID_AUTORIZACION_RECONOCIMIENTO");
            }
        } catch (SQLException ex) {
            Logger.getLogger(pnlTitulos.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            try {
                resultadoConsulta = conector.consulta("SELECT ID_FUNDAMENTO_LEGAL_SERVICIO_SOCIAL FROM fundamentoSSocial where FUNDAMENTO_LEGAL_SERVICIO_SOCIAL='" + fundamentoSS + "'");//establecimiento de sentencia aejecutar
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(pnlTitulos.class.getName()).log(Level.SEVERE, null, ex);
            }
            while (resultadoConsulta.next()) {
                idFundamentoLegalServicioSocial = resultadoConsulta.getInt("ID_FUNDAMENTO_LEGAL_SERVICIO_SOCIAL");
            }
        } catch (SQLException ex) {
            Logger.getLogger(pnlTitulos.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            try {
                resultadoConsulta = conector.consulta("SELECT * FROM Carreras where Carrera='" + nombreCarrera + "'");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(pnlTitulos.class.getName()).log(Level.SEVERE, null, ex);
            }
            while (resultadoConsulta.next()) {
                clave = resultadoConsulta.getString("idCarrera");
                noRvoe = resultadoConsulta.getString("noRvoe");
            }
        } catch (SQLException ex) {
            Logger.getLogger(pnlTitulos.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            try {
                resultadoConsulta = conector.consulta("SELECT id_EntidadF FROM entidadFederativa where nombreEntidad='" + eFederativa + "'");//establecimiento de sentencia aejecutar
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(pnlTitulos.class.getName()).log(Level.SEVERE, null, ex);
            }
            while (resultadoConsulta.next()) {
                if (resultadoConsulta.getInt("id_EntidadF") < 10) {
                    idEntidadFederativa = "0" + resultadoConsulta.getInt("id_EntidadF");
                } else {
                    idEntidadFederativa = resultadoConsulta.getString("id_EntidadF");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(pnlTitulos.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            try {
                resultadoConsulta = conector.consulta("SELECT idTipoAntecedente FROM estudioAntecedente where tipoEstudioAntecedente='" + tipodeEstudio + "'");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(pnlTitulos.class.getName()).log(Level.SEVERE, null, ex);
            }
            while (resultadoConsulta.next()) {
                idTipoEstudioAntecedente = resultadoConsulta.getInt("idTipoAntecedente");
            }
        } catch (SQLException ex) {
            Logger.getLogger(pnlTitulos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void regitroBaseDatos() {
        try {
            String cadena = "INSERT INTO txt(folioControl,fechaExpedicion,idModalidadTitulacion, \n"
                    + "modalidadTitulacion,fechaExamen,matricula,nombre,aPaterno,aMaterno,correo,CURP,sSocial, \n"
                    + "idFundamentoLegalServicioSocial,fundamentoSS,clave,nombreCarrera,numeroRvoe,clave_autorizacion,autorizacion_reconocimiento, \n"
                    + "institucionProcedencia,idEntidadFederativa,eFederativa,fechaAntInicio,fechaAntTermino,\n"
                    + "idTipoEstudioAntecedente,tipodeEstudio,noCedula,estatus) VALUES ('" + folioControl + "','" + fechaExpedicion + "','" 
                    + idModalidadTitulacion + "','" + modalidadTitulacion + "','" + fechaExamen + "','" 
                    + matricula + "','" + nombre + "','" + aPaterno + "','" + aMaterno + "','" + correo + "','"
                    + CURP + "','" + sSocial + "','" + idFundamentoLegalServicioSocial + "','" + fundamentoSS + "','" 
                    + clave + "','" + nombreCarrera + "','" + noRvoe + "','" + clave_autorizacion + "','"
                    + autorizacion_reconocimiento + "','" + institucionProcedencia + "','" + idEntidadFederativa + "','"
                    + eFederativa + "','" + fechaInicioAntecedente + "','" + fechaTerminoAntecedente + "','"
                    + idTipoEstudioAntecedente + "','" + tipodeEstudio + "','" + noCedula + "','A')";
            
            System.out.println(cadena);
            
            String salida = conector.registrar(cadena);

            System.out.println(salida);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(pnlTitulos.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(null, "Los datos se han registrado bien  ");
        limpiar();
    }
    
    public void limpiar(){
        
        DateAntecInicio.setDate(null);
        DateAntecTermino.setDate(null);
        
        DateFechaInicio.setDate(null);
        DateFechaTermino.setDate(null);
        txtFolio.setText("");
        DateExamenP.setDate(null);
        Date fecha3 = DateExpedicion.getDate();
        txtProcedencia.setText("");
        txtProcedencia.setText("");
        DateExpedicion.setDate(null);
        txtNoCedula.setText("");
    }
 
}
