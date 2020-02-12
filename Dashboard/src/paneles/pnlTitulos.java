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
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Genaro
 */
public class pnlTitulos extends javax.swing.JPanel {

    ConexionesDB conector = new ConexionesDB();
    ResultSet resultadoConsulta;
    DefaultTableModel modeloTabla;

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
    String fechaInicioCarrera = "", fechaFinCarrera = "";
    int idModalidadTitulacion = 0;
    int idFundamentoLegalServicioSocial = 0;
    String idEntidadFederativa = "", idEntidadFederativa2 = "", eFederativa2 = "", noCedula = "", noRvoe = "";

    /**
     * *****************************************
     */
    String fechaExpedicion = "", modalidadTitulacion = "", fundamentoSS = "";
    String fechaExamen = "", folioControl = "";
    int sSocial = 0;

    String idTipoEstudioAntecedente = "";



    public pnlTitulos() {
        initComponents();
        Llamado();
        modeloTabla = (DefaultTableModel) jTable1.getModel();
        tablaTitulos();
        txtCURP.setEnabled(false);
        txtCorreo.setEnabled(false);
        btnDetalles.setEnabled(false);
        btnEliminar.setEnabled(false);

    }

    public void tablaTitulos() {
        try {
            int filas = jTable1.getRowCount(); //Obtiene la catidad de filas
            for (int i = 1; i <= filas; i++) { //For que se ecuta de acuerdo a la cantidad de filas que haya
                modeloTabla.removeRow(0); //metodo que elimina cada fila
            }
            try {
                resultadoConsulta = conector.consulta("SELECT folioControl, matricula, nombre, aPaterno, aMaterno FROM txt where estatus='A'");//establecimiento de sentencia aejecutar
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(pnlTitulos.class.getName()).log(Level.SEVERE, null, ex);
            }
            Object[] valores = new Object[5];//Crea un arreglo de objetos un objeto puede 
            while (resultadoConsulta.next()) {
                for (int i = 0; i < 5; i++) {//El numero del for ebe ser igual al de la
                    valores[i] = resultadoConsulta.getObject(i + 1);
                }
                modeloTabla.addRow(valores);
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex);
        }
    }

    public void Llamado() {
        try {
            try {
                resultadoConsulta = conector.consulta("SELECT Matricula, Nombre, apellidoPaterno, apellidoMaterno FROM Profesionista where estatus='A'");//establecimiento de sentencia aejecutar
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
                //  ComboEFederativa.addItem(resultadoConsulta.getString("nombreEntidad"));
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
                //   ComboTipoEstudio.addItem(resultadoConsulta.getString("tipoEstudioAntecedente"));
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel7 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        DateExpedicion = new com.toedter.calendar.JDateChooser();
        jLabel16 = new javax.swing.JLabel();
        DateExamenP = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        CombomodalidadTit = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        txtFolio = new rscomponentshade.RSTextFieldShade();
        jLabel12 = new javax.swing.JLabel();
        ComboProfesionista = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        txtCURP = new rscomponentshade.RSTextFieldShade();
        jLabel15 = new javax.swing.JLabel();
        txtCorreo = new rscomponentshade.RSTextFieldShade();
        jLabel18 = new javax.swing.JLabel();
        ComboSSocial = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        ComboFLegal = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        ComboCarrera = new javax.swing.JComboBox<>();
        DateFechaInicio = new com.toedter.calendar.JDateChooser();
        jLabel23 = new javax.swing.JLabel();
        DateFechaTermino = new com.toedter.calendar.JDateChooser();
        jLabel24 = new javax.swing.JLabel();
        ComboautReconocimiento = new javax.swing.JComboBox<>();
        jLabel19 = new javax.swing.JLabel();
        ComboEFederativa = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnDetalles = new rscomponentshade.RSButtonShade();
        btnEliminar = new rscomponentshade.RSButtonShade();
        btnLimpiar = new rscomponentshade.RSButtonShade();
        btnAgregar = new rscomponentshade.RSButtonShade();
        txtBuscar = new rscomponentshade.RSTextFieldShade();
        btnBuscar = new rscomponentshade.RSButtonShade();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new rojerusan.RSTableMetro();
        jLabel6 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel7.setFont(new java.awt.Font("Roboto", 1, 48)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(128, 128, 131));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img1/titulo_1.png"))); // NOI18N
        jLabel7.setText("TÍTULOS");

        jPanel3.setBackground(new java.awt.Color(243, 242, 242));
        jPanel3.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jPanel3MouseMoved(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(243, 242, 242));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Editar Datos para Generar Título Electrónico.", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("sansserif", 1, 14))); // NOI18N
        jPanel5.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jPanel5MouseMoved(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Fecha de Expedición:");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel16.setText("Examen Profesional:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Folio del Título:");

        CombomodalidadTit.setMaximumSize(new java.awt.Dimension(32, 23));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Modalidad de Titulación:");

        txtFolio.setBgShadeHover(new java.awt.Color(0, 0, 0));
        txtFolio.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtFolio.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtFolio.setPlaceholder("Folio de Título");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setText("Nombre:");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setText("CURP:");

        txtCURP.setBgShadeHover(new java.awt.Color(0, 0, 0));
        txtCURP.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtCURP.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtCURP.setPlaceholder("CURP");
        txtCURP.setSelectionColor(new java.awt.Color(0, 0, 0));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel15.setText("E-mail:");

        txtCorreo.setBgShadeHover(new java.awt.Color(0, 0, 0));
        txtCorreo.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtCorreo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtCorreo.setPlaceholder("Correo Electrónico");

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel18.setText("Fundamento Servicio Social:");

        ComboSSocial.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Si", "No" }));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel17.setText("Servicio Social:");

        jLabel5.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(153, 153, 153));
        jLabel5.setText("Datos de  la Carrera:");

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel21.setText("Nombre de la Carrera:");

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel22.setText("Feha de Inicio:");

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel23.setText("Fecha Termino:");

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel24.setText("Reconocimiento:");

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel19.setText("Entidad Federativa:");

        jLabel8.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(153, 153, 153));
        jLabel8.setText("Datos del Título:");

        jLabel3.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 153, 153));
        jLabel3.setText("Datos del Alumno:");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel18)
                            .addComponent(jLabel8)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel4)
                                .addComponent(jLabel1)
                                .addComponent(jLabel16)
                                .addComponent(jLabel19)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(DateExamenP, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(DateExpedicion, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(ComboEFederativa, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtFolio, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(CombomodalidadTit, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGap(109, 109, 109)
                                        .addComponent(jLabel3))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel13)
                                                .addComponent(jLabel12)
                                                .addComponent(jLabel15))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtCURP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(ComboProfesionista, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(jPanel5Layout.createSequentialGroup()
                                            .addComponent(jLabel17)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(ComboSSocial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addComponent(ComboFLegal, javax.swing.GroupLayout.PREFERRED_SIZE, 468, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel22)
                                    .addComponent(jLabel23))
                                .addGap(51, 51, 51)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(DateFechaTermino, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(DateFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel21)
                                    .addComponent(jLabel24))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ComboCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, 435, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ComboautReconocimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap())
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel5)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel3))
                .addGap(5, 5, 5)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtFolio, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(ComboProfesionista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel12))
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CombomodalidadTit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel13)
                            .addComponent(txtCURP, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel15))
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel1)
                                .addComponent(DateExpedicion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel16)
                                    .addComponent(DateExamenP, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(ComboEFederativa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel19)))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(ComboSSocial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(jLabel17)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ComboFLegal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(ComboCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(ComboautReconocimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DateFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23)
                    .addComponent(DateFechaTermino, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(243, 242, 242));

        btnDetalles.setBackground(javax.swing.UIManager.getDefaults().getColor("ArrowButton.disabled"));
        btnDetalles.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/ojo.png"))); // NOI18N
        btnDetalles.setBgHover(new java.awt.Color(255, 255, 255));
        btnDetalles.setBgShadeHover(new java.awt.Color(153, 153, 153));
        btnDetalles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetallesActionPerformed(evt);
            }
        });

        btnEliminar.setBackground(new java.awt.Color(255, 102, 102));
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/compartimiento.png"))); // NOI18N
        btnEliminar.setBgHover(new java.awt.Color(255, 255, 255));
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnLimpiar.setBackground(new java.awt.Color(255, 255, 153));
        btnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/goma-de-borrar.png"))); // NOI18N
        btnLimpiar.setBgHover(new java.awt.Color(255, 255, 255));
        btnLimpiar.setBgShadeHover(new java.awt.Color(255, 255, 102));
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        btnAgregar.setBackground(new java.awt.Color(204, 255, 204));
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/salvar.png"))); // NOI18N
        btnAgregar.setBgHover(new java.awt.Color(255, 255, 255));
        btnAgregar.setBgShadeHover(new java.awt.Color(153, 255, 153));
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
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
                "Folio", "Matricula", "Nombre", "Apellido Paterno", "Apellido Materno"
            }
        ));
        jTable1.setColorBackgoundHead(new java.awt.Color(124, 20, 52));
        jTable1.setColorFilasBackgound2(new java.awt.Color(255, 204, 204));
        jTable1.setColorFilasForeground1(new java.awt.Color(124, 20, 52));
        jTable1.setColorFilasForeground2(new java.awt.Color(124, 20, 52));
        jTable1.setColorSelBackgound(new java.awt.Color(124, 20, 52));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel6.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel6.setText("Lista de Títulos Generados.");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 206, Short.MAX_VALUE)
                        .addComponent(btnDetalles, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(12, 12, 12))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAgregar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnLimpiar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEliminar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDetalles, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, Short.MAX_VALUE))
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
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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
                fechaInicioAntecedente = resultadoConsulta.getString("fechaAntInicio");
                fechaTerminoAntecedente = resultadoConsulta.getString("fechaAntTermino");
            }
        } catch (SQLException ex) {
            Logger.getLogger(pnlTitulos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jPanel3MouseMoved

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        capturarDatos();
        regitroBaseDatos();
        limpiar();
        tablaTitulos();
        Llamado();
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        limpiar();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int reply = JOptionPane.showConfirmDialog(null, "¿Eliminar registro?", "¡¡Advertencia!!", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {

            try {
                String salida = conector.registrar("UPDATE Profesionista set estatus='A' where CURP='" + txtCURP.getText() + "'");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(pnlTitulos.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                System.out.println("eliminar");
                String salida = conector.eliminar("Delete from txt where folioControl ='" + txtFolio.getText() + "'");
                System.out.println(salida);
            } catch (Exception e) {
                System.out.println(e);
            }
            JOptionPane.showMessageDialog(null, "Registro eliminado :( ");
            btnEliminar.setEnabled(false);
            //btnModificar.setEnabled(false);
            btnAgregar.setEnabled(true);
            limpiar();
        } else {

        }

        tablaTitulos();
        limpiar();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void jPanel5MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MouseMoved
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
    }//GEN-LAST:event_jPanel5MouseMoved

    private void btnDetallesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetallesActionPerformed

        try {
            try {
                resultadoConsulta = conector.consulta("SELECT modalidadTitulacion,"
                        + " correo, nombreCarrera, fechaExpedicion, fechaExamen,"
                        + " fechaExamen, sSocial, fundamentoSS, autorizacion_reconocimiento,"
                        + " institucionProcedencia, fechaAntInicio, fechaAntTermino FROM txt where folioControl='" + txtFolio.getText() + "'");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(pnlResponsables.class.getName()).log(Level.SEVERE, null, ex);
            }
            while (resultadoConsulta.next()) {
                String combo = "";
                if (resultadoConsulta.getInt("sSocial") == 1) {
                    combo = "Si";
                } else {
                    combo = "No";
                }
                JOptionPane.showMessageDialog(null, "Modalidad Titulacion : " + resultadoConsulta.getString("modalidadTitulacion")
                        + "\nCorreo : " + resultadoConsulta.getString("correo")
                        + "\nCarrera : " + resultadoConsulta.getString("nombreCarrera")
                        + "\nFecha de expedicion : " + resultadoConsulta.getDate("fechaExpedicion")
                        + "\nFecha examen o excencion : " + resultadoConsulta.getDate("fechaExamen")
                        + "\nServicio social : " + combo
                        + "\nFundamento S Social : " + resultadoConsulta.getString("fundamentoSS")
                        + "\nAutorizacion Reconocimiento : " + resultadoConsulta.getString("autorizacion_reconocimiento")
                        + "\nInstitucion procedencia : " + resultadoConsulta.getString("institucionProcedencia")
                        + "\nFecha Inicio Carrera anterior : " + resultadoConsulta.getDate("fechaAntInicio")
                        + "\nFecha Fin Carrera anterior : " + resultadoConsulta.getDate("fechaAntTermino"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(pnlTitulos.class.getName()).log(Level.SEVERE, null, ex);
        }

        // btnModificar.setEnabled(true);
        btnEliminar.setEnabled(true);
        btnAgregar.setEnabled(false);

    }//GEN-LAST:event_btnDetallesActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        txtFolio.setEnabled(false);
        btnDetalles.setEnabled(true);
        btnEliminar.setEnabled(true);
        ComboProfesionista.setEnabled(false);
        int seleccionada = jTable1.rowAtPoint((evt.getPoint()));
        String combo = "";

        txtFolio.setText(String.valueOf(jTable1.getValueAt(seleccionada, 0)));

        try {
            try {
                resultadoConsulta = conector.consulta("SELECT *  FROM txt where folioControl='" + String.valueOf(jTable1.getValueAt(seleccionada, 0)) + "'");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(pnlResponsables.class.getName()).log(Level.SEVERE, null, ex);
            }
            while (resultadoConsulta.next()) {

                CombomodalidadTit.setSelectedItem(resultadoConsulta.getString("modalidadTitulacion"));
                ComboProfesionista.addItem(resultadoConsulta.getString("matricula") + " - " + resultadoConsulta.getString("nombre") + " " + resultadoConsulta.getString("aPaterno") + " " + resultadoConsulta.getString("aMaterno"));
                ComboProfesionista.setSelectedItem(resultadoConsulta.getString("matricula") + " - " + resultadoConsulta.getString("nombre") + " " + resultadoConsulta.getString("aPaterno") + " " + resultadoConsulta.getString("aMaterno"));
                txtCURP.setText(resultadoConsulta.getString("CURP"));
                txtCorreo.setText(resultadoConsulta.getString("correo"));
                ComboCarrera.setSelectedItem(resultadoConsulta.getString("nombreCarrera"));
                DateFechaInicio.setDate(resultadoConsulta.getDate("fechaInicioCarrera"));
                DateFechaTermino.setDate(resultadoConsulta.getDate("fechaFinCarrera"));
                DateExpedicion.setDate(resultadoConsulta.getDate("fechaExpedicion"));
                DateExamenP.setDate(resultadoConsulta.getDate("fechaExamen"));
                if (resultadoConsulta.getInt("sSocial") == 1) {
                    ComboSSocial.setSelectedItem("Si");
                } else {
                    ComboSSocial.setSelectedItem("No");
                }

                ComboFLegal.setSelectedItem(resultadoConsulta.getString("fundamentoSS"));
                ComboautReconocimiento.setSelectedItem(resultadoConsulta.getString("autorizacion_reconocimiento"));

            }
        } catch (SQLException ex) {
            Logger.getLogger(pnlTitulos.class.getName()).log(Level.SEVERE, null, ex);
        }

        // btnModificar.setEnabled(true);
        btnEliminar.setEnabled(true);
        btnAgregar.setEnabled(false);
    }//GEN-LAST:event_jTable1MouseClicked

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

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboCarrera;
    private javax.swing.JComboBox<String> ComboEFederativa;
    private javax.swing.JComboBox<String> ComboFLegal;
    private javax.swing.JComboBox<String> ComboProfesionista;
    private javax.swing.JComboBox<String> ComboSSocial;
    private javax.swing.JComboBox<String> ComboautReconocimiento;
    private javax.swing.JComboBox<String> CombomodalidadTit;
    private com.toedter.calendar.JDateChooser DateExamenP;
    private com.toedter.calendar.JDateChooser DateExpedicion;
    private com.toedter.calendar.JDateChooser DateFechaInicio;
    private com.toedter.calendar.JDateChooser DateFechaTermino;
    private rscomponentshade.RSButtonShade btnAgregar;
    private rscomponentshade.RSButtonShade btnBuscar;
    private rscomponentshade.RSButtonShade btnDetalles;
    private rscomponentshade.RSButtonShade btnEliminar;
    private rscomponentshade.RSButtonShade btnLimpiar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private rojerusan.RSTableMetro jTable1;
    private rscomponentshade.RSTextFieldShade txtBuscar;
    private rscomponentshade.RSTextFieldShade txtCURP;
    private rscomponentshade.RSTextFieldShade txtCorreo;
    private rscomponentshade.RSTextFieldShade txtFolio;
    // End of variables declaration//GEN-END:variables

    public void datosCarrera() {
        nombreCarrera = (String) ComboCarrera.getSelectedItem();
        autorizacion_reconocimiento = (String) ComboautReconocimiento.getSelectedItem();
        Date fecha1 = DateFechaInicio.getDate();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        fechaInicioCarrera = sdf.format(fecha1);
        Date fecha2 = DateFechaTermino.getDate();
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
        fechaFinCarrera = sdf2.format(fecha2);

    }

    public void datosExpedicion() {
        folioControl = txtFolio.getText();
        modalidadTitulacion = (String) CombomodalidadTit.getSelectedItem();
        Date fecha4 = DateExamenP.getDate();
        SimpleDateFormat sdf4 = new SimpleDateFormat("yyyy-MM-dd");
        fechaExamen = sdf4.format(fecha4);

        if ((String) ComboSSocial.getSelectedItem() == "Si") {
            sSocial = 1;
        } else {
            sSocial = 0;
        }
        eFederativa = (String) ComboEFederativa.getSelectedItem();
        fundamentoSS = (String) ComboFLegal.getSelectedItem();
        Date fecha3 = DateExpedicion.getDate();
        SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd");
        fechaExpedicion = sdf3.format(fecha3);

    }

    public void datosAntecedentes() {
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
                institucionProcedencia = resultadoConsulta.getString("institucionProcedencia");
                idEntidadFederativa2 = resultadoConsulta.getString("idEntidadFederativa");
                eFederativa2 = resultadoConsulta.getString("eFederativa");
                fechaInicioAntecedente = resultadoConsulta.getString("fechaAntInicio");
                fechaTerminoAntecedente = resultadoConsulta.getString("fechaAntTermino");
                idTipoEstudioAntecedente = resultadoConsulta.getString("idTipoEstudioAntecedente");
                tipodeEstudio = resultadoConsulta.getString("tipodeEstudio");
                noCedula = resultadoConsulta.getString("noCedula");
            }
        } catch (SQLException ex) {
            Logger.getLogger(pnlTitulos.class.getName()).log(Level.SEVERE, null, ex);
        }

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
                resultadoConsulta = conector.consulta("SELECT idEntidadFederativa, eFederativa FROM Profesionista where eFederativa='" + eFederativa2 + "'");//establecimiento de sentencia aejecutar
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(pnlTitulos.class.getName()).log(Level.SEVERE, null, ex);
            }
            while (resultadoConsulta.next()) {
                    idEntidadFederativa2 = resultadoConsulta.getString("idEntidadFederativa");
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
                idTipoEstudioAntecedente = resultadoConsulta.getString("idTipoAntecedente");
            }
        } catch (SQLException ex) {
            Logger.getLogger(pnlTitulos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void regitroBaseDatos() {
        try {
            String cadena = "INSERT INTO txt(folioControl,fechaExpedicion,idModalidadTitulacion, \n"
                    + "modalidadTitulacion,fechaExamen,matricula,nombre,aPaterno,aMaterno,correo,CURP,sSocial, \n"
                    + "idFundamentoLegalServicioSocial,idEntidadFederativa,eFederativa,fundamentoSS,clave,nombreCarrera,\n"
                    + "numeroRvoe,fechaInicioCarrera,fechaFinCarrera,clave_autorizacion,autorizacion_reconocimiento, \n"
                    + "institucionProcedencia,idEntidadFederativa2,eFederativa2,fechaAntInicio,fechaAntTermino,\n"
                    + "idTipoEstudioAntecedente,tipodeEstudio,noCedula,estatus,archivo0,archivo1,archivo2,archivo3,archivo4) VALUES ('" 
                    + folioControl + "','" + fechaExpedicion + "','"
                    + idModalidadTitulacion + "','" + modalidadTitulacion + "','" + fechaExamen + "','"
                    + matricula + "','" + nombre + "','" + aPaterno + "','" + aMaterno + "','" + correo + "','"
                    + CURP + "','" + sSocial + "','" + idFundamentoLegalServicioSocial + "','" + idEntidadFederativa + "','" + eFederativa + "','" 
                    + fundamentoSS + "','" + clave + "','" + nombreCarrera + "','" + noRvoe + "','" + fechaInicioCarrera + "','" + fechaFinCarrera + "','"
                    + clave_autorizacion + "','" + autorizacion_reconocimiento + "','" + institucionProcedencia + "','"
                    + idEntidadFederativa2 + "','" + eFederativa2 + "','" + fechaInicioAntecedente + "','" + fechaTerminoAntecedente + "','"
                    + idTipoEstudioAntecedente + "','" + tipodeEstudio + "','" + noCedula + "','A','Pendiente','Pendiente','Pendiente','Pendiente','Pendiente')";

            System.out.println(cadena);
            String salida = conector.registrar(cadena);
            System.out.println(salida);

            salida = conector.registrar("UPDATE Profesionista set estatus='B' where Matricula='" + matricula + "'");

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(pnlTitulos.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(null, "Los datos se han registrado bien  ");
        limpiar();
    }

    public void limpiar() {
        txtFolio.setEnabled(true);
        DateFechaInicio.setDate(null);
        DateFechaTermino.setDate(null);
        txtFolio.setText("");
        DateExamenP.setDate(null);
        Date fecha3 = DateExpedicion.getDate();
        txtFolio.setText("");
        DateExpedicion.setDate(null);
        btnDetalles.setEnabled(false);
        btnEliminar.setEnabled(false);
        btnAgregar.setEnabled(true);
        ComboProfesionista.removeAllItems();
        ComboProfesionista.setEnabled(true);
        Llamado();
    }

}
