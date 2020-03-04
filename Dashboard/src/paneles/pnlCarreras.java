package paneles;

import java.sql.SQLException;
import CodeHelpers.ConexionesDB;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class pnlCarreras extends javax.swing.JPanel {

    ConexionesDB conector = new ConexionesDB();
    ResultSet resultadoConsulta;
    DefaultTableModel modeloTabla;

    String cveCarrera = "";
    String nombreCarrera = "";
    String noRvoe = "";

    public pnlCarreras() {
        initComponents();
        modeloTabla = (DefaultTableModel) jTable1.getModel();
        btnBuscar.setEnabled(false);
        btnBorrar.setEnabled(false);
        btnModificar.setEnabled(false);
        tablaCarreras();

        //Esta funcion impide que el usuario pueda ingresar letras
        txtClavearrera.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char caracter = e.getKeyChar();

                // Verificar si la tecla pulsada no es un digito
                if (((caracter < '0') || (caracter > '9')) && (caracter != '\b' /*corresponde a BACK_SPACE*/)) {
                    e.consume();  // ignorar el evento de teclado
                    JOptionPane.showMessageDialog(null, "Unicamente numeros");
                }
            }
        });

        txtNoRvoe.addKeyListener(new KeyAdapter() {
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

    public void tablaCarreras() {
        try {
            int filas = jTable1.getRowCount();
            for (int i = 1; i <= filas; i++) {
                modeloTabla.removeRow(0);
            }
            try {
                resultadoConsulta = conector.consulta("call Carreras");

            } catch (ClassNotFoundException ex) {
                Logger.getLogger(pnlCarreras.class.getName()).log(Level.SEVERE, null, ex);
            }
            Object[] valores = new Object[3];
            while (resultadoConsulta.next()) {
                for (int i = 0; i < 3; i++) {
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
        jPanel8 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtNoRvoe = new rscomponentshade.RSTextFieldShade();
        txtNombreCarrera = new rscomponentshade.RSTextFieldShade();
        txtClavearrera = new rscomponentshade.RSTextFieldShade();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new rojerusan.RSTableMetro();
        txtBuscar = new rscomponentshade.RSTextFieldShade();
        btnBuscar = new rscomponentshade.RSButtonShade();
        btnModificar = new rscomponentshade.RSButtonShade();
        btnBorrar = new rscomponentshade.RSButtonShade();
        btnLimpiar = new rscomponentshade.RSButtonShade();
        btnGuardar = new rscomponentshade.RSButtonShade();

        setBackground(new java.awt.Color(255, 255, 255));
        setDoubleBuffered(false);
        setEnabled(false);
        setPreferredSize(new java.awt.Dimension(976, 668));

        jLabel7.setFont(new java.awt.Font("Roboto", 1, 48)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(128, 128, 131));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img1/carrer.png"))); // NOI18N
        jLabel7.setText("CARRERAS");
        jLabel7.setMaximumSize(new java.awt.Dimension(357, 96));
        jLabel7.setMinimumSize(new java.awt.Dimension(357, 96));
        jLabel7.setPreferredSize(new java.awt.Dimension(357, 96));

        jPanel8.setBackground(new java.awt.Color(243, 242, 242));

        jPanel1.setBackground(new java.awt.Color(243, 242, 242));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Editar Datos de Carrera.", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("sansserif", 1, 14))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Clave de Carrera:");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Nombre de Carrera:");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setText("Numéro de RVOE:");

        txtNoRvoe.setBgShadeHover(new java.awt.Color(0, 0, 0));
        txtNoRvoe.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtNoRvoe.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtNoRvoe.setPlaceholder("Numero de RVOE");
        txtNoRvoe.setSelectionColor(new java.awt.Color(0, 0, 0));

        txtNombreCarrera.setBgShadeHover(new java.awt.Color(0, 0, 0));
        txtNombreCarrera.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtNombreCarrera.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtNombreCarrera.setPlaceholder("Nombre de la Carrera");

        txtClavearrera.setBgShadeHover(new java.awt.Color(0, 0, 0));
        txtClavearrera.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtClavearrera.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtClavearrera.setPlaceholder("Clave de la Carrera");
        txtClavearrera.setSelectionColor(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNoRvoe, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombreCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtClavearrera, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtClavearrera, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                    .addComponent(txtNombreCarrera, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtNoRvoe, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)))
        );

        jPanel9.setBackground(new java.awt.Color(243, 242, 242));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Clave de Carrera", "Nombre carrera", "NoRvoe"
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
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
        }

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
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
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

        btnBorrar.setBackground(new java.awt.Color(255, 204, 204));
        btnBorrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/compartimiento.png"))); // NOI18N
        btnBorrar.setBgHover(new java.awt.Color(255, 255, 255));
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
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

        btnGuardar.setBackground(new java.awt.Color(204, 255, 204));
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/salvar.png"))); // NOI18N
        btnGuardar.setBgHover(new java.awt.Color(255, 255, 255));
        btnGuardar.setBgShadeHover(new java.awt.Color(153, 255, 153));
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

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(btnModificar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(92, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 799, Short.MAX_VALUE)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed

    }//GEN-LAST:event_txtBuscarActionPerformed

    private void txtBuscarCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtBuscarCaretUpdate
        try {
            int filas = jTable1.getRowCount();
            for (int i = 1; i <= filas; i++) {
                modeloTabla.removeRow(0);
            }
            try {
                resultadoConsulta = conector.consulta("call Busqueda ('" + txtBuscar.getText() + "')");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(pnlCarreras.class.getName()).log(Level.SEVERE, null, ex);
            }
            Object[] valores = new Object[3];
            while (resultadoConsulta.next()) {
                for (int i = 0; i < 3; i++) {
                    valores[i] = resultadoConsulta.getObject(i + 1);
                }
                modeloTabla.addRow(valores);
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex);
        }
    }//GEN-LAST:event_txtBuscarCaretUpdate

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        txtClavearrera.setEnabled(false);
        int seleccionada = jTable1.rowAtPoint((evt.getPoint()));
        txtClavearrera.setText(String.valueOf(jTable1.getValueAt(seleccionada, 0)));
        txtNombreCarrera.setText(String.valueOf(jTable1.getValueAt(seleccionada, 1)));
        txtNoRvoe.setText(String.valueOf(jTable1.getValueAt(seleccionada, 2)));
        btnModificar.setEnabled(true);
        btnBorrar.setEnabled(true);
        btnGuardar.setEnabled(false);
    }//GEN-LAST:event_jTable1MouseClicked

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        int reply = JOptionPane.showConfirmDialog(null, "¿Modificar registro?", "¡¡Advertencia!!", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
            capturarDatos();
            try {

                String sql = "call actualizaCarrera('" + nombreCarrera + "', '" + noRvoe + "', '" + cveCarrera + "')";
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
        tablaCarreras();
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        capturarDatos();
        regitroBaseDatos();
        limpiar();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        limpiar();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        int reply = JOptionPane.showConfirmDialog(null, "¿Eliminar registro?", "¡¡Advertencia!!", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
            try {

                String salida = conector.eliminar("call eliminaCarrera('" + txtClavearrera.getText() + "')");

            } catch (Exception e) {
                System.out.println(e);
            }
            JOptionPane.showMessageDialog(null, "Registro eliminado :( ");
            tablaCarreras();
            btnBorrar.setEnabled(false);
            btnModificar.setEnabled(false);
            btnGuardar.setEnabled(true);
            limpiar();
        } else {
            /**
             * *******
             */
        }
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void btnGuardarMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseMoved

        if (txtClavearrera.getText().equals("") || txtNombreCarrera.getText().equals("") || txtNoRvoe.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "No puede haber campos vacios");
            btnGuardar.setEnabled(false);
        } else {
            btnGuardar.setEnabled(true);
            try {
                try {
                    resultadoConsulta = conector.consulta("call verificaCveCarrera ('" + txtClavearrera.getText() + "')");
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(pnlCarreras.class.getName()).log(Level.SEVERE, null, ex);
                }

                while (resultadoConsulta.next()) {
                    if (resultadoConsulta.getString("IdCarrera") != null) {
                        JOptionPane.showMessageDialog(null, "La clave de carrera ya existe");
                        txtClavearrera.requestFocus();
                    }
                }
            } catch (SQLException ex) {
                System.out.println("Error: " + ex);
            }

        }

    }//GEN-LAST:event_btnGuardarMouseMoved


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rscomponentshade.RSButtonShade btnBorrar;
    private rscomponentshade.RSButtonShade btnBuscar;
    private rscomponentshade.RSButtonShade btnGuardar;
    private rscomponentshade.RSButtonShade btnLimpiar;
    private rscomponentshade.RSButtonShade btnModificar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private rojerusan.RSTableMetro jTable1;
    private rscomponentshade.RSTextFieldShade txtBuscar;
    private rscomponentshade.RSTextFieldShade txtClavearrera;
    private rscomponentshade.RSTextFieldShade txtNoRvoe;
    private rscomponentshade.RSTextFieldShade txtNombreCarrera;
    // End of variables declaration//GEN-END:variables
public void limpiar() {
        txtClavearrera.setText("");
        txtNoRvoe.setText("");
        txtNombreCarrera.setText("");
        txtClavearrera.setEnabled(true);
        btnGuardar.setEnabled(true);
        btnBorrar.setEnabled(false);
        btnModificar.setEnabled(false);
    }

    public void capturarDatos() {
        cveCarrera = txtClavearrera.getText();
        nombreCarrera = txtNombreCarrera.getText();
        noRvoe = txtNoRvoe.getText();
    }

    public void regitroBaseDatos() {
        try {
            String sql = "call guardaCarrera('" + cveCarrera + "','" + nombreCarrera + "','" + noRvoe + "')";
            String salida = conector.registrar(sql);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(pnlCarreras.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(null, "Los datos se han registrado bien  ");
        tablaCarreras();
    }
}
