package paneles;

import CodeHelpers.ConexionesDB;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import mx.com.mostrotouille.axolotl.swing.util.AxolotlFileFilter;

public class pnlConfiguracion extends javax.swing.JPanel {

    private File currentDirectory;
    ConexionesDB conector = new ConexionesDB();
    ResultSet resultadoConsulta;
    DefaultTableModel modeloTabla;

    String claveEscuela = "";
    String nombreEscuela = "";
    String carpeta = "";
    int cuenta = 0;

    public pnlConfiguracion() {
        initComponents();
        verificaConfiguracion();
    }

    public void verificaConfiguracion() {
        try {
            try {
                resultadoConsulta = conector.consulta("SELECT count(*) FROM configuracion");

            } catch (ClassNotFoundException ex) {
                Logger.getLogger(pnlTxt.class.getName()).log(Level.SEVERE, null, ex);
            }

            while (resultadoConsulta.next()) {
                cuenta = resultadoConsulta.getInt("count(*)");
            }

        } catch (SQLException ex) {
            System.out.println("Error: " + ex);
        }

        if (cuenta == 1) {
            try {
                try {
                    resultadoConsulta = conector.consulta("SELECT claveEscuela, nombreEscuela, carpeta FROM configuracion");

                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(pnlTxt.class.getName()).log(Level.SEVERE, null, ex);
                }

                while (resultadoConsulta.next()) {
                    txtclaveInstitucion.setText(resultadoConsulta.getString("claveEscuela"));
                    txtnombreInstitucion.setText(resultadoConsulta.getString("nombreEscuela"));
                    txtCarpeta.setText(resultadoConsulta.getString("carpeta"));
                    btnGuardar.setEnabled(false);
                    btnModificar.setEnabled(true);
                }

            } catch (SQLException ex) {
                System.out.println("Error: " + ex);
            }
        } else {
            btnGuardar.setEnabled(true);
            btnModificar.setEnabled(false);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        txtnombreInstitucion = new rscomponentshade.RSTextFieldShade();
        txtclaveInstitucion = new rscomponentshade.RSTextFieldShade();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        txtCarpeta = new rscomponentshade.RSTextFieldShade();
        jButton4 = new rscomponentshade.RSButtonShade();
        btnGuardar = new rscomponentshade.RSButtonShade();
        btnModificar = new rscomponentshade.RSButtonShade();
        jLabel7 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(243, 242, 242));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Configuración de Archivos"));

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel27.setText("Nombre institución");

        txtnombreInstitucion.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtnombreInstitucion.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtnombreInstitucion.setPlaceholder("Nombre de la institución");

        txtclaveInstitucion.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtclaveInstitucion.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtclaveInstitucion.setPlaceholder("Clave de la institución");

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel28.setText("Clave institucion");

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel29.setText("Carpeta");

        txtCarpeta.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtCarpeta.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtCarpeta.setPlaceholder("Examinar...");

        jButton4.setBackground(new java.awt.Color(255, 153, 102));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/subir.png"))); // NOI18N
        jButton4.setBgHover(new java.awt.Color(255, 255, 255));
        jButton4.setBgShadeHover(new java.awt.Color(243, 242, 242));
        jButton4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        btnGuardar.setBackground(new java.awt.Color(204, 255, 204));
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/salvar.png"))); // NOI18N
        btnGuardar.setBgHover(new java.awt.Color(255, 255, 255));
        btnGuardar.setBgShadeHover(new java.awt.Color(243, 242, 242));
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

        btnModificar.setBackground(new java.awt.Color(204, 204, 255));
        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/documento.png"))); // NOI18N
        btnModificar.setBgHover(new java.awt.Color(255, 255, 255));
        btnModificar.setBgShadeHover(new java.awt.Color(243, 242, 242));
        btnModificar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnModificar.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnModificarMouseMoved(evt);
            }
        });
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel27)
                            .addComponent(jLabel28)
                            .addComponent(jLabel29))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtCarpeta, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtclaveInstitucion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtnombreInstitucion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(287, 287, 287)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtnombreInstitucion, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtclaveInstitucion, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtCarpeta, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel29))
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(70, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jLabel7.setFont(new java.awt.Font("Roboto", 1, 48)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(128, 128, 131));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img1/configuracion.png"))); // NOI18N
        jLabel7.setText("CONFIGURACIÓN");
        jLabel7.setMaximumSize(new java.awt.Dimension(357, 96));
        jLabel7.setMinimumSize(new java.awt.Dimension(357, 96));
        jLabel7.setPreferredSize(new java.awt.Dimension(357, 96));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 799, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        JFileChooser fc = new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int respuesta = fc.showSaveDialog(this);

        if (respuesta == JFileChooser.APPROVE_OPTION) {

            String archivoElegido = fc.getSelectedFile().getAbsolutePath();
            txtCarpeta.setText(archivoElegido);

        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        capturarDatos();
        registrarDatos();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        capturarDatos();
        int reply = JOptionPane.showConfirmDialog(null, "¿Modificar registro?", "¡¡Advertencia!!", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
            capturarDatos();
            try {

                System.out.println("modificar");

                String sql = "update configuracion set carpeta='" + carpeta + "', nombreEscuela='" + nombreEscuela + "',"
                        + " claveEscuela='" + claveEscuela + "'";

                System.out.println(sql);
                String salida = conector.registrar(sql);

            } catch (Exception e) {
                System.out.println(e);
            }
            JOptionPane.showMessageDialog(null, "Registro modificado ");
            btnModificar.setEnabled(false);
            verificaConfiguracion();
        } else {
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnGuardarMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseMoved
        verificaCampos();
    }//GEN-LAST:event_btnGuardarMouseMoved

    private void btnModificarMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModificarMouseMoved
        verificaCampos();
    }//GEN-LAST:event_btnModificarMouseMoved

    public void capturarDatos() {
        claveEscuela = txtclaveInstitucion.getText();
        nombreEscuela = txtnombreInstitucion.getText();
        carpeta = txtCarpeta.getText().replace("\\", "\\\\");;
    }

    public void registrarDatos() {
        try {
            String sql = "INSERT INTO configuracion(claveEscuela, nombreEscuela, carpeta) VALUES ('" + claveEscuela + "','" + nombreEscuela + "','" + carpeta + "')";
            System.out.println(sql);
            String salida = conector.registrar(sql);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(pnlConfiguracion.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(null, "Los datos se han registrado bien ");
    }

    public void verificaCampos() {
        if (txtCarpeta.getText().equals("") || txtclaveInstitucion.getText().equals("") || txtnombreInstitucion.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "No puede haber campos vacios ");
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rscomponentshade.RSButtonShade btnGuardar;
    private rscomponentshade.RSButtonShade btnModificar;
    private rscomponentshade.RSButtonShade jButton4;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private rscomponentshade.RSTextFieldShade txtCarpeta;
    private rscomponentshade.RSTextFieldShade txtclaveInstitucion;
    private rscomponentshade.RSTextFieldShade txtnombreInstitucion;
    // End of variables declaration//GEN-END:variables
}
