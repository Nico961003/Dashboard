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
                resultadoConsulta = conector.consulta("SELECT matricula, nombre, aPaterno, aMaterno FROM txt where estatus='A'");//establecimiento de sentencia aejecutar
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

    public void tablaResponsable() {
        try {
            int filas = jTable2.getRowCount(); //Obtiene la catidad de filas
            for (int i = 1; i <= filas; i++) { //For que se ecuta de acuerdo a la cantidad de filas que haya
                modeloTabla2.removeRow(0); //metodo que elimina cada fila
            }
            try {
                resultadoConsulta = conector.consulta("SELECT Clave, Nombre, apellidoPaterno, apellidoMaterno FROM Responsable");//establecimiento de sentencia aejecutar

            } catch (ClassNotFoundException ex) {
                Logger.getLogger(pnlResponsables.class.getName()).log(Level.SEVERE, null, ex);
            }
            Object[] valores = new Object[4];//Crea un arreglo de objetos un objeto puede 
            while (resultadoConsulta.next()) {
                for (int i = 0; i < 4; i++) {//El numero del for ebe ser igual al de la
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
        jLabel7 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new rojerusan.RSTableMetro();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(243, 242, 242));

        jPanel2.setBackground(new java.awt.Color(243, 242, 242));

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
        btnGenerar.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnGenerarMouseMoved(evt);
            }
        });
        btnGenerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 705, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnGenerar, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGenerar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel7.setFont(new java.awt.Font("Roboto", 1, 40)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(128, 128, 131));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img1/txt.png"))); // NOI18N
        jLabel7.setText("Archivos TXT");
        jLabel7.setIconTextGap(10);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Clave", "Nombre", "A Paterno", "A Materno", "Firma"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane3.setViewportView(jTable2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 991, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 765, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnGenerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarActionPerformed

        for (int i = 0; i < jTable1.getRowCount(); i++) {
            try {
                TableModel model = jTable1.getModel();
                String[] seleccionado = new String[100];
                //System.out.println("prueba " + ((Boolean) model.getValueAt(i, 4) == true));
                //Si la columna 4 está true añadimos el ID
                if ((Boolean) model.getValueAt(i, 4) == true) {
                    seleccionado[i] = ((String) model.getValueAt(i, 0));

                    System.out.println(seleccionado[i]);

                    //  if (seleccionado[i] != null || seleccionado[i] != "") {
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
                            fechaCarreraInicio = resultadoConsulta.getString("fechaInicioCarrera");
                            fechaCarreraTermino = resultadoConsulta.getString("fechaFinCarrera");
                            noRvoe = resultadoConsulta.getString("numeroRvoe");
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(pnlTxt.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    try {
                        //String ruta = "/home/genaro/Documentos/TituloElectronico_" + matricula + ".txt";
                        String ruta = "C:\\Users\\JLIMON\\Documents\\TituloElectronico_" + matricula + ".txt";
                        String contenido = "||1.0|" + folioControl + "|OORM631231HDFSMG03|1|DIRECTOR|LIC.|BEVJ691029HGTRDR09|3|RECTOR|ING."
                                + "|090653|UNIVERSIDAD VICTORIA|" + clave + "|" + nombreCarrera + "|" + fechaCarreraInicio + "|"
                                + fechaCarreraTermino + "|" + clave_autorizacion + "|" + autorizacion_reconocimiento + "|" + noRvoe + "|" + CURP + "|"
                                + nombre + "|" + aPaterno + "|" + aMaterno + "|" + correo + "|" + fechaExpedicion + "|" + idModalidadTitulacion + "|"
                                + modalidadTitulacion + "|" + fechaExamen + "|" + sSocial + "|" + idFundamentoLegalServicioSocial + "|"
                                + fundamentoSS + "|" + idEntidadFederativa + "|" + eFederativa + "|"
                                + institucionProcedencia + "|" + idTipoEstudioAntecedente + "|" + tipodeEstudio + "|"
                                + idEntidadFederativa2 + "|" + eFederativa2 + "|" + fechaAntInicio + "|" + fechaAntTermino + "|" + noCedula + "||";

                        System.out.println(contenido);

                        try {
                            String salida = conector.registrar("UPDATE txt set archivo='" + contenido + "' where folioControl='" + folioControl + "'");
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

                        try {
                            String cadena = "Update txt set estatus = 'B' where matricula='" + seleccionado[i] + "'";
                            //System.out.println(cadena);
                            String salida = conector.registrar(cadena);
                            System.out.println(salida);

                        } catch (ClassNotFoundException ex) {
                            Logger.getLogger(pnlTitulos.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }

                JOptionPane.showMessageDialog(null, "Archivo txt generado exitosamente");
                //abrirarchivo("/home/genaro/Documentos/");
                abrirarchivo("C:\\Users\\JLIMON\\Documents\\");
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        tablaTxtA();
    }//GEN-LAST:event_btnGenerarActionPerformed

    private void btnGenerarMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGenerarMouseMoved
        TableModel model = jTable1.getModel();
        String[] seleccionado = new String[100];

        if (jTable1.getRowCount() == 0) {
            btnGenerar.setEnabled(false);
            JOptionPane.showMessageDialog(null, "Sin registros por generar");
        }
    }//GEN-LAST:event_btnGenerarMouseMoved

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscarActionPerformed

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
                        + Buscar + "%' or aMaterno like '%" + Buscar + "%' or matricula like '%" + Buscar + "%' where estatus='A'");
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rscomponentshade.RSButtonShade btnBuscar;
    private rscomponentshade.RSButtonShade btnGenerar;
    private javax.swing.JLabel jLabel7;
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
}
