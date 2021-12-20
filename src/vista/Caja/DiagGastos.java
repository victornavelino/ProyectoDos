/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.Caja;

import entidades.Sucursal;
import entidades.caja.Caja;
import entidades.caja.Gasto;
import entidades.caja.TipoDeFactura;
import entidades.caja.TipoDeGasto;
import entidades.usuario.Usuario;
import facade.CajaFacade;
import facade.MovimientoCajaFacade;
import facade.GenericoFacade;
import includes.Comunes;
import includes.ModeloTablaNoEditable;
import java.awt.Color;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JViewport;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author bangho
 */
public class DiagGastos extends javax.swing.JDialog {

    private ModeloTablaNoEditable modeloTablaGastos;
    private Gasto gasto;
    private Usuario usuario;
    private Sucursal sucursal;
    private Caja caja;

    /**
     * Creates new form DiagGastos
     *
     * @param parent
     * @param modal
     * @param usuario
     * @param sucursal
     */
    public DiagGastos(java.awt.Frame parent, boolean modal, Usuario usuario, Sucursal sucursal, Caja caja) {
        super(parent, modal);
        initComponents();
        this.usuario = usuario;
        this.sucursal = sucursal;
        this.caja = caja;
        this.setTitle("Egresos");
        inicializarComponentes();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblGastos = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        cboFiltroTipoGasto = new javax.swing.JComboBox();
        cbTipoGasto = new javax.swing.JComboBox();
        tfImporte = new javax.swing.JTextField();
        tfDescripcion = new javax.swing.JTextField();
        dpFecha = new org.jdesktop.swingx.JXDatePicker();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cboTipoDeFactura = new javax.swing.JComboBox();
        tfCuit = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        tfNroFactura = new javax.swing.JTextField();
        ftfHora = new javax.swing.JFormattedTextField();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(org.openide.util.NbBundle.getMessage(DiagGastos.class, "DiagGastos.jPanel1.border.title"))); // NOI18N

        tblGastos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblGastos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblGastosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblGastos);

        jLabel4.setText(org.openide.util.NbBundle.getMessage(DiagGastos.class, "DiagGastos.jLabel4.text")); // NOI18N

        cboFiltroTipoGasto.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboFiltroTipoGasto.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboFiltroTipoGastoItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 501, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboFiltroTipoGasto, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cboFiltroTipoGasto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tfImporte.setText(org.openide.util.NbBundle.getMessage(DiagGastos.class, "DiagGastos.tfImporte.text")); // NOI18N
        tfImporte.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfImporteKeyTyped(evt);
            }
        });

        tfDescripcion.setText(org.openide.util.NbBundle.getMessage(DiagGastos.class, "DiagGastos.tfDescripcion.text")); // NOI18N

        dpFecha.setFormats("dd/MM/yyyy");

        jLabel1.setText(org.openide.util.NbBundle.getMessage(DiagGastos.class, "DiagGastos.jLabel1.text")); // NOI18N

        jLabel2.setText(org.openide.util.NbBundle.getMessage(DiagGastos.class, "DiagGastos.jLabel2.text")); // NOI18N

        jLabel3.setText(org.openide.util.NbBundle.getMessage(DiagGastos.class, "DiagGastos.jLabel3.text")); // NOI18N

        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/add.png"))); // NOI18N
        btnAgregar.setText(org.openide.util.NbBundle.getMessage(DiagGastos.class, "DiagGastos.btnAgregar.text")); // NOI18N
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/edit.png"))); // NOI18N
        btnModificar.setText(org.openide.util.NbBundle.getMessage(DiagGastos.class, "DiagGastos.btnModificar.text")); // NOI18N
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/delete.png"))); // NOI18N
        btnEliminar.setText(org.openide.util.NbBundle.getMessage(DiagGastos.class, "DiagGastos.btnEliminar.text")); // NOI18N
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        jLabel5.setText(org.openide.util.NbBundle.getMessage(DiagGastos.class, "DiagGastos.jLabel5.text")); // NOI18N

        jLabel6.setText("Tipo de Factura");

        cboTipoDeFactura.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel7.setText(org.openide.util.NbBundle.getMessage(DiagGastos.class, "DiagGastos.jLabel7.text")); // NOI18N

        jLabel8.setText("Numero de Factura");

        try {
            ftfHora.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel9.setText(org.openide.util.NbBundle.getMessage(DiagGastos.class, "DiagGastos.jLabel9.text")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tfDescripcion, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(dpFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel6)
                                    .addComponent(cboTipoDeFactura, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfCuit)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel9)
                                            .addComponent(ftfHora, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5)
                                            .addComponent(tfImporte, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbTipoGasto, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfNroFactura, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbTipoGasto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfCuit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboTipoDeFactura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfNroFactura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5)
                            .addComponent(jLabel9))
                        .addGap(2, 2, 2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(dpFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfImporte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ftfHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAgregar)
                            .addComponent(btnModificar)
                            .addComponent(btnEliminar))))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        altaGasto();
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void tblGastosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblGastosMouseClicked
        cargarParaModificarGasto();
    }//GEN-LAST:event_tblGastosMouseClicked

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        modificarGasto();
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        eliminarGasto();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void cboFiltroTipoGastoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboFiltroTipoGastoItemStateChanged
        filtrarGastos();
    }//GEN-LAST:event_cboFiltroTipoGastoItemStateChanged

    private void tfImporteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfImporteKeyTyped
        // TODO add your handling code here:
        Comunes.soloNumeros(tfImporte, evt);
    }//GEN-LAST:event_tfImporteKeyTyped

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DiagGastos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DiagGastos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DiagGastos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DiagGastos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DiagGastos dialog = new DiagGastos(new javax.swing.JFrame(), true, new Usuario(), new Sucursal(), new Caja());
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    private void cargarTipoDeGastos() {
        Comunes.cargarJComboConBlanco(cboFiltroTipoGasto, GenericoFacade.getInstance().find("TipoDeGasto"));
        Comunes.cargarJCombo(cbTipoGasto, GenericoFacade.getInstance().find("TipoDeGasto"));
    }

    private boolean validarGasto() {
        if (tfImporte.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe tipear un importe");
            tfImporte.grabFocus();
            return false;
        }
        if (tfDescripcion.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe tipear la descripcion");
            tfDescripcion.grabFocus();
            return false;
        }
        if (ftfHora.getText().equals("  :  ")) {
            JOptionPane.showMessageDialog(null, "Debe cargar la hora en formato HH:MM   ejemplo 16:30");
            ftfHora.grabFocus();
            return false;
        }
        if (Comunes.concatenarFechaConHora(dpFecha.getDate(), ftfHora.getText()) == null) {
            JOptionPane.showMessageDialog(null, "Debe cargar correctamente el formato ejemplo 16:30");
            ftfHora.grabFocus();
            return false;
        }

        return true;

    }

    private void cargarTablaGastos(List<Gasto> gastos) {
        modeloTablaGastos = new ModeloTablaNoEditable();
        cargarEncabezadosTablaGastos(modeloTablaGastos);
        configurarTabla(tblGastos);
        try {
            cargarGastos(gastos);
        } catch (Exception ex) {
            Logger.getLogger(DiagSueldosAdelantos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void cargarEncabezadosTablaGastos(ModeloTablaNoEditable modeloTablaGastos) {
        modeloTablaGastos.addColumn("Id");
        modeloTablaGastos.addColumn("Fecha");
        modeloTablaGastos.addColumn("Tipo de Gasto");
        modeloTablaGastos.addColumn("Importe");
        modeloTablaGastos.addColumn("Observaciones");
        tblGastos.setModel(modeloTablaGastos);
    }

    private void configurarTabla(JTable tbl) {
        JViewport scroll = (JViewport) tbl.getParent();
        int ancho = scroll.getWidth();
        int anchoColumna = 0;
        TableColumnModel modeloColumna = tbl.getColumnModel();
        TableColumn columnaTabla;
        for (int i = 0; i < tbl.getColumnCount(); i++) {
            columnaTabla = modeloColumna.getColumn(i);
            switch (i) {
                case 0:
                    anchoColumna = (1 * ancho) / 100;
                    break;
                case 1:
                    anchoColumna = (20 * ancho) / 100;
                    break;
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                case 10:
                case 11:
                case 12:
                    anchoColumna = (5 * ancho) / 100;
                    break;
            }
            columnaTabla.setPreferredWidth(anchoColumna);
            tbl.setColumnModel(modeloColumna);
        }
        tbl.getTableHeader().setFont(new java.awt.Font("Dialog",
                java.awt.Font.PLAIN, 10));
        tbl.getTableHeader().setBackground(java.awt.Color.WHITE);
        tbl.getTableHeader().setForeground(Color.BLACK);
        //Si le queremos cambiar el tamaño a la tablita
        tbl.setFont(new java.awt.Font("Dialog",
                java.awt.Font.PLAIN, 10));
    }

    private void cargarGastos(List<Gasto> gastos) {
        try {
            modeloTablaGastos = new ModeloTablaNoEditable();
            cargarEncabezadosTablaGastos(modeloTablaGastos);
            for (Gasto g : gastos) {
                cargarGasto(g);
            }

            tblGastos.setModel(modeloTablaGastos);
            Comunes.setOcultarColumnasJTable(tblGastos, 0);
        } catch (Exception ex) {
            Logger.getLogger(DiagSueldosAdelantos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void cargarGasto(Gasto gasto) {
        Object[] fila = new Object[5];
        fila[0] = gasto.getId();
        SimpleDateFormat formats = new SimpleDateFormat("dd/MM/yyyy");
        try {
            fila[1] = formats.format(gasto.getFecha());
        } catch (Exception e) {

        }
        fila[2] = gasto.getTipoDeGasto();
        fila[3] = gasto.getImporte();
        fila[4] = gasto.getDescripcion();
        modeloTablaGastos.addRow(fila);
    }

    private void cargarGasto() {
        gasto = (Gasto) MovimientoCajaFacade.getInstance().buscar((Long) tblGastos.getValueAt(tblGastos.getSelectedRow(), 0));
        tfImporte.setText(String.valueOf(gasto.getImporte()));
        tfDescripcion.setText(gasto.getDescripcion());
        dpFecha.setDate(gasto.getFecha());
        try {
            ftfHora.setText(Comunes.extraerHoraDeFecha(gasto.getFecha()));
        } catch (Exception e) {
        }

        tfNroFactura.setText(gasto.getNumeroFactura());
        tfCuit.setText(gasto.getCuit());
        try {
            cbTipoGasto.setSelectedItem(gasto.getTipoDeGasto());
        } catch (Exception e) {
        }

        try {
            cboTipoDeFactura.setSelectedItem(gasto.getTipoDeFactura());
        } catch (Exception e) {
        }

    }

    private void eliminarGasto() {
        try {
            MovimientoCajaFacade.getInstance().eliminar(gasto.getId());
            JOptionPane.showMessageDialog(null, "Registro Eliminado");
            cargarTablaGastos(MovimientoCajaFacade.getInstance().getGastos(caja.getFechaInicio()));
            limpiar();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }
    }

    private void limpiar() {
        gasto = new Gasto();
        Comunes.cargarJCombo(cbTipoGasto, GenericoFacade.getInstance().find("TipoDeGasto"));
        tfDescripcion.setText("");
        tfImporte.setText("");
        ftfHora.setText("");
        btnAgregar.setEnabled(true);
        btnModificar.setEnabled(false);
        btnEliminar.setEnabled(false);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JComboBox cbTipoGasto;
    private javax.swing.JComboBox cboFiltroTipoGasto;
    private javax.swing.JComboBox cboTipoDeFactura;
    private org.jdesktop.swingx.JXDatePicker dpFecha;
    private javax.swing.JFormattedTextField ftfHora;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblGastos;
    private javax.swing.JTextField tfCuit;
    private javax.swing.JTextField tfDescripcion;
    private javax.swing.JTextField tfImporte;
    private javax.swing.JTextField tfNroFactura;
    // End of variables declaration//GEN-END:variables

    private void inicializarComponentes() {
        //CARGAR TABLA CON ADELANTOS DE SUELDO
        caja = CajaFacade.getInstance().getCajaAbierta(sucursal, usuario);
        if (caja == null) {
            Comunes.mensajeError("Es posible que no se haya abierto caja", "No existe caja abierta");
            this.dispose();
        }    //CARGAR TABLA CON ADELANTOS DE SUELDO
        cargarTablaGastos(MovimientoCajaFacade.getInstance().getGastos(caja.getFechaInicio()));
        Comunes.setOcultarColumnasJTable(tblGastos, 0);
        //CARGAR COMBO LISTA EMPLEADOS
        cargarTipoDeGastos();
        //Carga tipo de factura
        Comunes.cargarJComboConBlanco(cboTipoDeFactura, GenericoFacade.getInstance().find("TipoDeFactura"));
        btnAgregar.setEnabled(true);
        btnModificar.setEnabled(false);
        btnEliminar.setEnabled(false);
    }

    private void altaGasto() {

        if (validarGasto() && cbTipoGasto.getSelectedIndex() != -1) {

            try {
                caja = CajaFacade.getInstance().getCajaAbierta(sucursal, usuario);

                BigDecimal saldoFinalCaja = CajaFacade.getInstance().getSaldoFinalCaja(caja);

                //obtenemos el importe del gasto
                BigDecimal importeGasto = new BigDecimal(tfImporte.getText());
                if (saldoFinalCaja.compareTo(importeGasto) >= 0) {
                    gasto = new Gasto();
                    gasto.setTipoDeGasto((TipoDeGasto) cbTipoGasto.getSelectedItem());
//                gasto.setFecha(dpFecha.getDate());
                    gasto.setFecha(Comunes.concatenarFechaConHora(dpFecha.getDate(), ftfHora.getText()));
                    gasto.setImporte(importeGasto);
                    gasto.setDescripcion(tfDescripcion.getText());
                    gasto.setUsuario(usuario);
                    gasto.setSucursal(sucursal);
                    gasto.setCuit(tfCuit.getText());
                    if (cboTipoDeFactura.getSelectedIndex() > 0) {
                        gasto.setTipoDeFactura((TipoDeFactura) cboTipoDeFactura.getSelectedItem());
                    }
                    gasto.setNumeroFactura(tfNroFactura.getText());
                    MovimientoCajaFacade.getInstance().alta(gasto);
                    JOptionPane.showMessageDialog(null, "Datos Registrados");
                    cargarTablaGastos(MovimientoCajaFacade.getInstance().getGastos(caja.getFechaInicio()));
                    limpiar();
                } else {
                    JOptionPane.showMessageDialog(null, "No tiene saldo suficiente para realizar este gasto\n"
                            + "La Caja dispone de $ " + saldoFinalCaja);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error: " + e);
            }
        }
    }

    private void cargarParaModificarGasto() {
        cargarGasto();
        btnAgregar.setEnabled(false);
        btnModificar.setEnabled(true);
        btnEliminar.setEnabled(true);
    }

    private void modificarGasto() {
        if (validarGasto() && cbTipoGasto.getSelectedIndex() != -1) {
            try {
                gasto.setTipoDeGasto((TipoDeGasto) cbTipoGasto.getSelectedItem());
                gasto.setFecha(Comunes.concatenarFechaConHora(dpFecha.getDate(), ftfHora.getText()));
                gasto.setImporte(new BigDecimal(tfImporte.getText()));
                gasto.setDescripcion(tfDescripcion.getText());
                gasto.setUsuario(usuario);
                MovimientoCajaFacade.getInstance().modificar(gasto);
                JOptionPane.showMessageDialog(null, "Datos modificados!!!");
                cargarTablaGastos(MovimientoCajaFacade.getInstance().getGastos(caja.getFechaInicio()));
                limpiar();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error: " + e);
            }
        }

    }

    private void filtrarGastos() {
        if (cboFiltroTipoGasto.getSelectedIndex() > 0) {
            cargarGastos(MovimientoCajaFacade.getInstance().getGastosPorTipo((TipoDeGasto) cboFiltroTipoGasto.getSelectedItem(), caja.getFechaInicio()));
        } else {
            cargarGastos(MovimientoCajaFacade.getInstance().getGastos(caja.getFechaInicio()));
        }

    }

}
