package paneles;

import CodeHelpers.ConexionesDB;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.ssl.PKCS8Key;
import mx.com.mostrotouille.axolotl.CaptureException;
import mx.com.mostrotouille.axolotl.swing.AxolotlSwingToolkit;
import mx.com.mostrotouille.axolotl.swing.JAboutDialog;
import mx.com.mostrotouille.axolotl.swing.util.AxolotlFileFilter;

public class pnlResponsables extends javax.swing.JPanel {

    private File currentDirectory;

    String Clave = "";
    String Nombre = "";
    String apellidoPaterno = "";
    String apellidoMaterno = "";
    String CURP = "";
    String Puesto = "";
    String abr = "";
    String Llave = "";
    String Certificado = "";
    String pass = "";

    ConexionesDB conector = new ConexionesDB();
    ResultSet resultadoConsulta;
    DefaultTableModel modeloTabla;

    public pnlResponsables() {
        initComponents();
        modeloTabla = (DefaultTableModel) jTable1.getModel();
        tablaReponsables();
        comboClave();
        btnEliminar.setEnabled(false);
        btnModificar.setEnabled(false);
    }

    public void tablaReponsables() {
        try {
            int filas = jTable1.getRowCount(); //Obtiene la catidad de filas
            for (int i = 1; i <= filas; i++) { //For que se ecuta de acuerdo a la cantidad de filas que haya
                modeloTabla.removeRow(0); //metodo que elimina cada fila
            }
            try {
                resultadoConsulta = conector.consulta("SELECT Clave, Nombre, apellidoPaterno, apellidoMaterno, CURP, Puesto  FROM Responsable");//establecimiento de sentencia aejecutar

            } catch (ClassNotFoundException ex) {
                Logger.getLogger(pnlResponsables.class.getName()).log(Level.SEVERE, null, ex);
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

        try {
            try {
                resultadoConsulta = conector.consulta("SELECT CARGO_FIRMANTE FROM cargos");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(pnlTitulos.class.getName()).log(Level.SEVERE, null, ex);
            }

            while (resultadoConsulta.next()) {
                ComboCargo.addItem(resultadoConsulta.getString("CARGO_FIRMANTE"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(pnlTitulos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void comboClave() {

        int comparaClave = 0;
        Integer[] valores = new Integer[5];
        for (int i = 0; i < 5; i++) {
            valores[i] = ((Integer) Integer.parseInt(ComboClave.getItemAt(i)));
        }

        for (int i = 0; i < 5; i++) {
            try {
                try {
                    resultadoConsulta = conector.consulta("SELECT Clave FROM Responsable where Clave = " + valores[i]);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(pnlResponsables.class.getName()).log(Level.SEVERE, null, ex);
                }
                while (resultadoConsulta.next()) {
                    valores[i] = resultadoConsulta.getInt("Clave");
                    ComboClave.removeItem(valores[i].toString());
                }
            } catch (SQLException ex) {
                Logger.getLogger(pnlResponsables.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void prueba(){
        int comparaClave = 0;
        String prueba = (String) ComboClave.getSelectedItem();

        for (int i = 0; i < 5; i++) {
            try {
                try {
                    resultadoConsulta = conector.consulta("SELECT Clave FROM Responsable where Clave = " + prueba );
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(pnlResponsables.class.getName()).log(Level.SEVERE, null, ex);
                }
                while (resultadoConsulta.next()) {
                    prueba = resultadoConsulta.getString("Clave");
                    System.out.println("valores " + prueba);
                    ComboClave.removeItem(prueba);
                }
            } catch (SQLException ex) {
                Logger.getLogger(pnlResponsables.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        btnModificar = new rscomponentshade.RSButtonShade();
        btnEliminar = new rscomponentshade.RSButtonShade();
        btnLimpia = new rscomponentshade.RSButtonShade();
        btnAgregar = new rscomponentshade.RSButtonShade();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new rojerusan.RSTableMetro();
        jPanel3 = new javax.swing.JPanel();
        txtCURP = new rscomponentshade.RSTextFieldShade();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtapellidoMaterno = new rscomponentshade.RSTextFieldShade();
        txtNombre = new rscomponentshade.RSTextFieldShade();
        txtapellidoPaterno = new rscomponentshade.RSTextFieldShade();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        ComboAbr = new javax.swing.JComboBox<>();
        txtFldCer = new rscomponentshade.RSTextFieldShade();
        jLabel27 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        ComboClave = new javax.swing.JComboBox<>();
        jButton1 = new rscomponentshade.RSButtonShade();
        ComboCargo = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        txtFldKey = new rscomponentshade.RSTextFieldShade();
        jButton2 = new rscomponentshade.RSButtonShade();
        jLabel33 = new javax.swing.JLabel();
        psswrdFldPass = new javax.swing.JPasswordField();
        jLabel9 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setFocusable(false);

        jPanel2.setBackground(new java.awt.Color(243, 242, 242));

        jPanel4.setBackground(new java.awt.Color(243, 242, 242));

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

        btnEliminar.setBackground(new java.awt.Color(255, 102, 102));
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/compartimiento.png"))); // NOI18N
        btnEliminar.setBgHover(new java.awt.Color(255, 255, 255));
        btnEliminar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
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

        btnAgregar.setBackground(new java.awt.Color(204, 255, 204));
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/salvar.png"))); // NOI18N
        btnAgregar.setBgHover(new java.awt.Color(255, 255, 255));
        btnAgregar.setBgShadeHover(new java.awt.Color(153, 255, 153));
        btnAgregar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnAgregar.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnAgregarMouseMoved(evt);
            }
        });
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Jerarquia", "Nombre", "Apellido Paterno", "Apellido Materno", "CURP", "Puesto"
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
        jTable1.setSelectionBackground(new java.awt.Color(124, 20, 52));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTable1MousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLimpia, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jScrollPane1)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimpia, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(105, 105, 105))
        );

        jPanel3.setBackground(new java.awt.Color(243, 242, 242));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del Responsable Firmante de Título Electrónico"));

        txtCURP.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtCURP.setPlaceholder("CURP");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Curp:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("Abr. de Título:");

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

        ComboAbr.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ING.", "LIC." }));
        ComboAbr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboAbrActionPerformed(evt);
            }
        });

        txtFldCer.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtFldCer.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtFldCer.setPlaceholder("Examinar...");

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel27.setText("Certificado:");

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel30.setText("Cargo:");

        ComboClave.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5" }));
        ComboClave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboClaveActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(255, 153, 102));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/subir.png"))); // NOI18N
        jButton1.setBgHover(new java.awt.Color(255, 255, 255));
        jButton1.setBgShadeHover(new java.awt.Color(243, 242, 242));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        ComboCargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboCargoActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Jerarquia:");

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel31.setText("Llave Privada:");

        txtFldKey.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtFldKey.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtFldKey.setPlaceholder("Examinar...");

        jButton2.setBackground(new java.awt.Color(255, 153, 102));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/subir.png"))); // NOI18N
        jButton2.setBgHover(new java.awt.Color(255, 255, 255));
        jButton2.setBgShadeHover(new java.awt.Color(243, 242, 242));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel33.setText("Contraseña:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtapellidoMaterno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtapellidoPaterno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel30)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ComboClave, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ComboCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel27)
                                    .addComponent(jLabel11))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtFldCer, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(16, 16, 16)
                                        .addComponent(jLabel33))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jLabel31)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtFldKey, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(psswrdFldPass, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(ComboAbr, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                            .addGap(55, 55, 55)
                            .addComponent(jLabel8)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtCURP, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(104, 104, 104))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCURP, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtapellidoPaterno, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtapellidoMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ComboClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel30)
                            .addComponent(ComboCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ComboAbr, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel27)
                                .addComponent(txtFldCer, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(7, 7, 7)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel31)
                                .addComponent(txtFldKey, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(psswrdFldPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel33))))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.getAccessibleContext().setAccessibleName("");

        jLabel9.setFont(new java.awt.Font("Roboto", 1, 48)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(128, 128, 131));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img1/Responsable.png"))); // NOI18N
        jLabel9.setText("RESPONSABLES");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        int reply = JOptionPane.showConfirmDialog(null, "¿Modificar registro?", "¡¡Advertencia!!", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
            capturarDatos();
            try {

                System.out.println("modificar");

                String sql = "Update Responsable set Clave=" + Clave + ", Nombre='" + Nombre
                        + "', apellidoPaterno='" + apellidoPaterno + "', apellidoMaterno='" + apellidoMaterno
                        + "', CURP='" + CURP + "', Puesto='" + Puesto + "', abrev='" + abr
                        + "', Llave='" + Llave + "', Certificado='" + Certificado + "', pass='" + pass + "' where Clave='" + Clave + "'";

                System.out.println(sql);
                String salida = conector.registrar(sql);

            } catch (Exception e) {
                System.out.println(e);
            }
            JOptionPane.showMessageDialog(null, "Registro modificado ");
            tablaReponsables();
            btnEliminar.setEnabled(false);
            btnModificar.setEnabled(false);
            btnAgregar.setEnabled(true);
            limpiar();
        } else {

        }
        tablaReponsables();
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnAgregarMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarMouseMoved
        System.out.println("ok");
        if(txtCURP.getText() == "" || txtFldCer.getText() == "" || txtFldKey.getText() == "" ||
                txtNombre.getText() == "" || txtapellidoMaterno.getText() == "" || txtapellidoPaterno.getText() == ""){
            
            btnAgregar.setEnabled(false);
            JOptionPane.showMessageDialog(null, "No puede haber campos vacios");
            
        } else {
            btnAgregar.setEnabled(true);
        } 
        
    }//GEN-LAST:event_btnAgregarMouseMoved

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        capturarDatos();
        registrarDatos();
        limpiar();
        tablaReponsables();
        comboClave();
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnLimpiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiaActionPerformed
        limpiar();
    }//GEN-LAST:event_btnLimpiaActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed

        int reply = JOptionPane.showConfirmDialog(null, "¿Eliminar registro?", "¡¡Advertencia!!", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
            try {
                System.out.println("eliminar");
                String salida = conector.eliminar("Delete from Responsable where CURP ='" + txtCURP.getText() + "'");
                System.out.println(salida);
            } catch (Exception e) {
                System.out.println(e);
            }
            JOptionPane.showMessageDialog(null, "Registro eliminado :( ");
            tablaReponsables();
            btnEliminar.setEnabled(false);
            btnModificar.setEnabled(false);
            btnAgregar.setEnabled(true);
            limpiar();
        } else {

        }
        comboClave();
        tablaReponsables();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked


        ComboClave.setEnabled(false);
        int seleccionada = jTable1.rowAtPoint((evt.getPoint()));
        String combo = "";
        txtNombre.setText(String.valueOf(jTable1.getValueAt(seleccionada, 1)));
        txtapellidoPaterno.setText(String.valueOf(jTable1.getValueAt(seleccionada, 2)));
        txtapellidoMaterno.setText(String.valueOf(jTable1.getValueAt(seleccionada, 3)));
        txtCURP.setText(String.valueOf(jTable1.getValueAt(seleccionada, 4)));
        ComboCargo.setSelectedItem(String.valueOf(jTable1.getValueAt(seleccionada, 5)));

        try {
            try {
                resultadoConsulta = conector.consulta("SELECT Clave, Llave, Certificado, abrev  FROM Responsable where CURP='" + String.valueOf(jTable1.getValueAt(seleccionada, 4)) + "'");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(pnlResponsables.class.getName()).log(Level.SEVERE, null, ex);
            }
            while (resultadoConsulta.next()) {
                combo = resultadoConsulta.getString("Clave");
                ComboClave.addItem(combo);
                ComboClave.setSelectedItem(combo);
                txtFldCer.setText(resultadoConsulta.getString("Certificado"));
                txtFldKey.setText(resultadoConsulta.getString("Llave"));
                ComboAbr.addItem(resultadoConsulta.getString("abrev"));
                ComboAbr.setSelectedItem(resultadoConsulta.getString("abrev"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(pnlResponsables.class.getName()).log(Level.SEVERE, null, ex);
        }
        txtFldCer.setEnabled(false);
        txtFldKey.setEnabled(false);
        btnModificar.setEnabled(true);
        btnEliminar.setEnabled(true);
        btnAgregar.setEnabled(false);

    }//GEN-LAST:event_jTable1MouseClicked

    private void ComboCargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboCargoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboCargoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        selectFile(txtFldCer, new String[]{"cer"});
        txtFldCer.setEnabled(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void ComboClaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboClaveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboClaveActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        selectFile(txtFldKey, new String[]{"key"});
        txtFldKey.setEnabled(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void ComboAbrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboAbrActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboAbrActionPerformed

    private void jTable1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MousePressed
        prueba();
    }//GEN-LAST:event_jTable1MousePressed

    public void capturarDatos() {

        Clave = (String) ComboClave.getSelectedItem();
        Nombre = txtNombre.getText().toUpperCase();
        apellidoPaterno = txtapellidoPaterno.getText().toUpperCase();
        apellidoMaterno = txtapellidoMaterno.getText().toUpperCase();
        CURP = txtCURP.getText().toUpperCase();
        Puesto = (String) ComboCargo.getSelectedItem();
        abr = (String) ComboAbr.getSelectedItem();

        StringBuffer result = new StringBuffer();
        Certificado = txtFldCer.getText().toString();
        Llave = txtFldKey.getText().toString();
        pass = new String(psswrdFldPass.getPassword());
        Certificado = Certificado.replace("\\", "\\\\");
        Llave = Llave.replace("\\", "\\\\");
        System.out.println("Certificado " + Certificado);
        System.out.println("Llave " + Llave);

    }

    public void registrarDatos() {

        try {

            String sql = "INSERT INTO Responsable(Clave, Nombre, apellidoPaterno, apellidoMaterno, CURP, Puesto, abrev, Llave, Certificado, pass) VALUES ('" + Clave + "','" + Nombre + "','" + apellidoPaterno
                    + "','" + apellidoMaterno + "','" + CURP + "','" + Puesto + "','" + abr + "','" + Llave + "','" + Certificado + "','" + pass + "')";

            System.out.println(sql);
            String salida = conector.registrar(sql);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(pnlResponsables.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "La contraseña del certificado es incorrecta");
        }
        JOptionPane.showMessageDialog(null, "Los datos se han registrado bien  ");

    }

    public void limpiar() {

        prueba();
        txtNombre.setText("");
        txtapellidoPaterno.setText("");
        txtapellidoMaterno.setText("");
        txtCURP.setText("");
        txtFldKey.setText("");
        txtFldCer.setText("");
        psswrdFldPass.setText("");
        btnEliminar.setEnabled(false);
        btnModificar.setEnabled(false);
        btnAgregar.setEnabled(true);
        ComboClave.setEnabled(true);

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboAbr;
    private javax.swing.JComboBox<String> ComboCargo;
    private javax.swing.JComboBox<String> ComboClave;
    private rscomponentshade.RSButtonShade btnAgregar;
    private rscomponentshade.RSButtonShade btnEliminar;
    private rscomponentshade.RSButtonShade btnLimpia;
    private rscomponentshade.RSButtonShade btnModificar;
    private rscomponentshade.RSButtonShade jButton1;
    private rscomponentshade.RSButtonShade jButton2;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private rojerusan.RSTableMetro jTable1;
    private javax.swing.JPasswordField psswrdFldPass;
    private rscomponentshade.RSTextFieldShade txtCURP;
    private rscomponentshade.RSTextFieldShade txtFldCer;
    private rscomponentshade.RSTextFieldShade txtFldKey;
    private rscomponentshade.RSTextFieldShade txtNombre;
    private rscomponentshade.RSTextFieldShade txtapellidoMaterno;
    private rscomponentshade.RSTextFieldShade txtapellidoPaterno;
    // End of variables declaration//GEN-END:variables
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

}
