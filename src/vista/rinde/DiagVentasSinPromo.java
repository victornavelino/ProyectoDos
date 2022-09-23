/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.rinde;

import entidades.Sucursal;
import entidades.articulo.Articulo;
import entidades.articulo.Categoria;
import entidades.cliente.Organismo;
import entidades.cliente.Persona;
import entidades.venta.Venta;
import entidades.venta.VentaArticulo;
import facade.ArticuloFacade;
import facade.CategoriaFacade;
import facade.SucursalFacade;
import facade.VentaFacade;
import includes.Comunes;
import includes.ExportarExcel;
import includes.ModeloTablaNoEditable;
import java.awt.Color;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JViewport;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import vista.ventas.DiagExportarImportarVentas;

/**
 *
 * @author franco
 */
public class DiagVentasSinPromo extends javax.swing.JDialog {

    private ModeloTablaNoEditable modeloTablaVentas;
    private Vector headers = new Vector();
    private Vector data = new Vector();
    private Sucursal sucursal;
    private List<Categoria> categorias;
    private List<Venta> ventas;
    private List<Object[]> ventasObjeto;
    private List<Venta> listaVentasFiltradas;
    BigDecimal totalVentasSinPromo = new BigDecimal("0.00");

    /**
     * Creates new form DiagListadoVentas
     */
    public DiagVentasSinPromo(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        inicializarComponentes();

    }

    public DiagVentasSinPromo(java.awt.Frame parent, boolean modal, Sucursal sucursal) {
        super(parent, modal);
        initComponents();
        this.sucursal = sucursal;
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

        cboSucursal = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblVentas = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        btnFiltrar = new javax.swing.JButton();
        cbSucursal = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jListSeleccionadas = new javax.swing.JList();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jListNoSeleccionadas = new javax.swing.JList();
        jLabel7 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        dpFechaDesde = new org.jdesktop.swingx.JXDatePicker();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        dpFechaHasta = new org.jdesktop.swingx.JXDatePicker();
        btnExportarArt = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();
        tfTotalVentasSinPromo = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        cboSucursal.setBorder(javax.swing.BorderFactory.createTitledBorder(org.openide.util.NbBundle.getMessage(DiagVentasSinPromo.class, "DiagVentasSinPromo.cboSucursal.border.title"))); // NOI18N

        tblVentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblVentas);

        jLabel3.setText(org.openide.util.NbBundle.getMessage(DiagVentasSinPromo.class, "DiagVentasSinPromo.jLabel3.text")); // NOI18N

        btnFiltrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/buscar2.png"))); // NOI18N
        btnFiltrar.setText(org.openide.util.NbBundle.getMessage(DiagVentasSinPromo.class, "DiagVentasSinPromo.btnFiltrar.text")); // NOI18N
        btnFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiltrarActionPerformed(evt);
            }
        });

        cbSucursal.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(org.openide.util.NbBundle.getMessage(DiagVentasSinPromo.class, "DiagVentasSinPromo.jPanel1.border.title"))); // NOI18N

        jLabel6.setText(org.openide.util.NbBundle.getMessage(DiagVentasSinPromo.class, "DiagVentasSinPromo.jLabel6.text")); // NOI18N

        jScrollPane2.setViewportView(jListSeleccionadas);

        jButton2.setText(org.openide.util.NbBundle.getMessage(DiagVentasSinPromo.class, "DiagVentasSinPromo.jButton2.text")); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText(org.openide.util.NbBundle.getMessage(DiagVentasSinPromo.class, "DiagVentasSinPromo.jButton3.text")); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jScrollPane3.setViewportView(jListNoSeleccionadas);

        jLabel7.setText(org.openide.util.NbBundle.getMessage(DiagVentasSinPromo.class, "DiagVentasSinPromo.jLabel7.text")); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(55, 55, 55))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane3)
                            .addComponent(jScrollPane2))))
                .addGap(21, 21, 21))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(org.openide.util.NbBundle.getMessage(DiagVentasSinPromo.class, "DiagVentasSinPromo.jPanel2.border.title"))); // NOI18N

        jLabel4.setText(org.openide.util.NbBundle.getMessage(DiagVentasSinPromo.class, "DiagVentasSinPromo.jLabel4.text")); // NOI18N

        jLabel2.setText(org.openide.util.NbBundle.getMessage(DiagVentasSinPromo.class, "DiagVentasSinPromo.jLabel2.text")); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dpFechaHasta, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dpFechaDesde, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(70, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dpFechaDesde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dpFechaHasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout cboSucursalLayout = new javax.swing.GroupLayout(cboSucursal);
        cboSucursal.setLayout(cboSucursalLayout);
        cboSucursalLayout.setHorizontalGroup(
            cboSucursalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cboSucursalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(cboSucursalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cboSucursalLayout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(cboSucursalLayout.createSequentialGroup()
                        .addGroup(cboSucursalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(cboSucursalLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26))))
            .addGroup(cboSucursalLayout.createSequentialGroup()
                .addGap(347, 347, 347)
                .addComponent(btnFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        cboSucursalLayout.setVerticalGroup(
            cboSucursalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cboSucursalLayout.createSequentialGroup()
                .addGroup(cboSucursalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cboSucursalLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(cboSucursalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(cbSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cboSucursalLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)))
                .addComponent(btnFiltrar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        btnExportarArt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/new_page.png"))); // NOI18N
        btnExportarArt.setText(org.openide.util.NbBundle.getMessage(DiagVentasSinPromo.class, "DiagVentasSinPromo.btnExportarArt.text")); // NOI18N
        btnExportarArt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportarArtActionPerformed(evt);
            }
        });

        btnCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/back.png"))); // NOI18N
        btnCerrar.setText(org.openide.util.NbBundle.getMessage(DiagVentasSinPromo.class, "DiagVentasSinPromo.btnCerrar.text")); // NOI18N
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        tfTotalVentasSinPromo.setText(org.openide.util.NbBundle.getMessage(DiagVentasSinPromo.class, "DiagVentasSinPromo.tfTotalVentasSinPromo.text")); // NOI18N

        jLabel8.setText(org.openide.util.NbBundle.getMessage(DiagVentasSinPromo.class, "DiagVentasSinPromo.jLabel8.text")); // NOI18N

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/accept.png"))); // NOI18N
        jButton4.setText(org.openide.util.NbBundle.getMessage(DiagVentasSinPromo.class, "DiagVentasSinPromo.jButton4.text")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cboSucursal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(321, 321, 321)
                .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfTotalVentasSinPromo, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton4))
                    .addComponent(btnExportarArt, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(cboSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfTotalVentasSinPromo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jButton4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExportarArt, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCerrar))
                .addGap(17, 17, 17))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExportarArtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportarArtActionPerformed
        Exportar();
    }//GEN-LAST:event_btnExportarArtActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void btnFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiltrarActionPerformed
        filtrarVentas();
    }//GEN-LAST:event_btnFiltrarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        agregarCategoria();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        quitarCategoria();
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(DiagVentasSinPromo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DiagVentasSinPromo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DiagVentasSinPromo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DiagVentasSinPromo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DiagVentasSinPromo dialog = new DiagVentasSinPromo(new javax.swing.JFrame(), true);
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnExportarArt;
    private javax.swing.JButton btnFiltrar;
    private javax.swing.JComboBox<String> cbSucursal;
    private javax.swing.JPanel cboSucursal;
    private org.jdesktop.swingx.JXDatePicker dpFechaDesde;
    private org.jdesktop.swingx.JXDatePicker dpFechaHasta;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JList jListNoSeleccionadas;
    private javax.swing.JList jListSeleccionadas;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tblVentas;
    private javax.swing.JTextField tfTotalVentasSinPromo;
    // End of variables declaration//GEN-END:variables

    private void Exportar() {
        new ExportarExcel().crearExcelJtable(tblVentas, "Listado de Ventas");
    }

    private void cargarTablaVentas(List<Object[]> ventasObjeto) {
        modeloTablaVentas = new ModeloTablaNoEditable();
        cargarEncabezadosTablaArticulos(modeloTablaVentas);
        configurarTabla(tblVentas);
        try {
            cargarVentasObjeto(ventasObjeto);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, "Error: " + ex);
        }
    }

    private void cargarEncabezadosTablaArticulos(ModeloTablaNoEditable modeloTablaArticulos) {
        modeloTablaArticulos.addColumn("Id");
        modeloTablaArticulos.addColumn("Sucursal");
        modeloTablaArticulos.addColumn("Fecha");
        modeloTablaArticulos.addColumn("Numero Ticket");
        modeloTablaArticulos.addColumn("Nombre/Razon Social");
        modeloTablaArticulos.addColumn("Monto sin PROMO");
        modeloTablaArticulos.addColumn("Monto con PROMO");
        modeloTablaArticulos.addColumn("Descuento");
        modeloTablaArticulos.addColumn("Anulada");
        modeloTablaArticulos.addColumn("Usuario");
        modeloTablaArticulos.addColumn("Articulo");
        modeloTablaArticulos.addColumn("Cantidad/Peso");
        modeloTablaArticulos.addColumn("Precio Promocion");
        modeloTablaArticulos.addColumn("Precio Lista");

        tblVentas.setModel(modeloTablaVentas);
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

    private void cargarVentas(List<Venta> ventas) {
        try {
            modeloTablaVentas = new ModeloTablaNoEditable();
            cargarEncabezadosTablaArticulos(modeloTablaVentas);
            for (Venta venta : ventas) {

                for (VentaArticulo ventaArticulo : venta.getVentasArticulos()) {
                    if (categorias.contains(ArticuloFacade.getInstance().buscarPorCodigo(ventaArticulo.getArticuloCodigo()).getSubCategoria().getCategoria())) {
                        cargarVenta(venta, ventaArticulo);
                    }

                }

            }

            tblVentas.setModel(modeloTablaVentas);
            // Comunes.setOcultarColumnasJTable(tblVentas, 0);
        } catch (Exception ex) {
            Logger.getLogger(DiagExportarImportarVentas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void cargarVentasObjeto(List<Object[]> ventasObjeto) {
        try {
            modeloTablaVentas = new ModeloTablaNoEditable();
            cargarEncabezadosTablaArticulos(modeloTablaVentas);
            totalVentasSinPromo=new BigDecimal("0.00");
            for (Object[] articulo : ventasObjeto) {

                // JOptionPane.showMessageDialog(null, "va "+va.getCantidadPeso());
                SimpleDateFormat formats = new SimpleDateFormat("dd/MM/yyyy");
                DecimalFormatSymbols simboloSeparador = new DecimalFormatSymbols(Locale.ENGLISH);
                simboloSeparador.setDecimalSeparator(',');
                DecimalFormat formatoConComa = new DecimalFormat("#####.###", simboloSeparador);
                Object[] fila = new Object[14];
                int n = 0;
                fila[n++] = articulo[0];
                fila[n++] = articulo[1];
                fila[n++] = formats.format(articulo[2]);
                fila[n++] = articulo[3];
                fila[n++] = articulo[4];
                fila[n++] = new DecimalFormat("0.00").format(articulo[5]);
                fila[n++] = new DecimalFormat("0.00").format(articulo[6]);
                fila[n++] = new DecimalFormat("0.00").format(articulo[7]);
                fila[n++] = articulo[8];
                fila[n++] = articulo[9];
                fila[n++] = articulo[10];
                fila[n++] = new DecimalFormat("0.00").format(articulo[11]);
                fila[n++] = new DecimalFormat("0.00").format(articulo[12]);
                fila[n++] = new DecimalFormat("0.00").format(articulo[13]);

                modeloTablaVentas.addRow(fila);
                totalVentasSinPromo=totalVentasSinPromo.add(new BigDecimal(articulo[5].toString()));
            }

            tblVentas.setModel(modeloTablaVentas);
            tfTotalVentasSinPromo.setText(new DecimalFormat("0.00").format(totalVentasSinPromo));
            // Comunes.setOcultarColumnasJTable(tblVentas, 0);
        } catch (Exception ex) {
            Logger.getLogger(DiagExportarImportarVentas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void cargarVenta(Venta venta, VentaArticulo ventaArticulo) {
        // JOptionPane.showMessageDialog(null, "va "+va.getCantidadPeso());
        SimpleDateFormat formats = new SimpleDateFormat("dd/MM/yyyy");
        DecimalFormatSymbols simboloSeparador = new DecimalFormatSymbols(Locale.ENGLISH);
        simboloSeparador.setDecimalSeparator(',');
        DecimalFormat formatoConComa = new DecimalFormat("#####.###", simboloSeparador);
        Object[] fila = new Object[16];
        int n = 0;
        fila[n++] = venta.getId();
        fila[n++] = venta.getSucursal();
        if (venta.getFecha() != null) {
            fila[n++] = formats.format(venta.getFecha());
        }
        fila[n++] = venta.getNumeroTicket();

        fila[n++] = venta.getCliente();
        fila[n++] = venta.getDniCliente();

        fila[n++] = formatoConComa.format(venta.getMonto());
        fila[n++] = formatoConComa.format(VentaFacade.getInstance().getVentaNumeroTicket(String.valueOf(venta.getNumeroTicket())).getMonto());
        fila[n++] = formatoConComa.format(venta.getDescuento());
        if (venta.isAnulado()) {
            fila[n++] = "Si";
        } else {
            fila[n++] = "No";
        }
        fila[n++] = venta.getUsuario().getNombreCompleto();
        fila[n++] = ventaArticulo.getArticuloDescripcion();
        fila[n++] = formatoConComa.format(ventaArticulo.getCantidadPeso());
        fila[n++] = formatoConComa.format(ventaArticulo.getPrecio());
        fila[n++] = formatoConComa.format(ventaArticulo.getPrecioPromocion());
        fila[n++] = formatoConComa.format(ventaArticulo.getPrecioUnitario());

        modeloTablaVentas.addRow(fila);
    }

//    private void cargarVenta(Venta venta, VentaArticulo ventaArticulo) {
//        // JOptionPane.showMessageDialog(null, "va "+va.getCantidadPeso());
//        SimpleDateFormat formats = new SimpleDateFormat("dd/MM/yyyy");
//        DecimalFormatSymbols simboloSeparador = new DecimalFormatSymbols(Locale.ENGLISH);
//        simboloSeparador.setDecimalSeparator(',');
//        DecimalFormat formatoConComa = new DecimalFormat("#####.###", simboloSeparador);
//        Object[] fila = new Object[16];
//        int n = 0;
//        fila[n++] = venta.getId();
//        fila[n++] = venta.getSucursal();
//        if (venta.getFecha() != null) {
//            fila[n++] = formats.format(venta.getFecha());
//        }
//        fila[n++] = venta.getNumeroTicket();
//
//        fila[n++] = venta.getCliente();
//        fila[n++] = venta.getDniCliente();
//
//        fila[n++] = formatoConComa.format(venta.getMonto());
//        fila[n++] = formatoConComa.format(VentaFacade.getInstance().getVentaNumeroTicket(String.valueOf(venta.getNumeroTicket())).getMonto());
//        fila[n++] = formatoConComa.format(venta.getDescuento());
//        if (venta.isAnulado()) {
//            fila[n++] = "Si";
//        } else {
//            fila[n++] = "No";
//        }
//        fila[n++] = venta.getUsuario().getNombreCompleto();
//        fila[n++] = ventaArticulo.getArticuloDescripcion();
//        fila[n++] = formatoConComa.format(ventaArticulo.getCantidadPeso());
//        fila[n++] = formatoConComa.format(ventaArticulo.getPrecio());
//        fila[n++] = formatoConComa.format(ventaArticulo.getPrecioPromocion());
//        fila[n++] = formatoConComa.format(ventaArticulo.getPrecioUnitario());
//
//        modeloTablaVentas.addRow(fila);
//    }
    private void inicializarComponentes() {
        categorias = new ArrayList<>();
        //cargarTablaVentas(VentaFacade.getInstance().listaVentasOrdXNroTicket());
        Comunes.formatearJXdatePicker(dpFechaDesde);
        Comunes.formatearJXdatePicker(dpFechaHasta);
        cargarCbSucursal();
        Comunes.cargarJList(jListNoSeleccionadas, CategoriaFacade.getInstance().getTodos());
    }

    private void filtrarVentas() {
        System.out.println("categorias: " + categorias);
        //ventas = VentaFacade.getInstance().listaVentasXSucursalXCategoriaXFechas((Sucursal) cbSucursal.getSelectedItem(), categorias, dpFechaDesde.getDate(), dpFechaHasta.getDate());
        ventasObjeto = VentaFacade.getInstance().listaVentasXSucursalXCategoriaXFechas2((Sucursal) cbSucursal.getSelectedItem(), categorias, dpFechaDesde.getDate(), dpFechaHasta.getDate());
        //filtarVentasCategorias(ventas, categorias);
        //System.out.println("ventas: " + ventas);
        cargarTablaVentas(ventasObjeto);
    }

    private void cargarCbSucursal() {
        Comunes.cargarJCombo(cbSucursal, SucursalFacade.getInstance().getTodos());
        cbSucursal.setSelectedItem(sucursal);
        if (sucursal.getNombre().contains("CENTRAL")) {
            cbSucursal.setEnabled(true);
        } else {
            cbSucursal.setEnabled(false);
        }
    }

    private void agregarCategoria() {
        if (!jListNoSeleccionadas.getSelectedValuesList().isEmpty()) {
            categorias.addAll(jListNoSeleccionadas.getSelectedValuesList());
        }
        cargarCategorias();
    }

    private void cargarCategorias() {

        List<Categoria> categoriasDisponibles = CategoriaFacade.getInstance().getTodos();
        categoriasDisponibles.removeAll(categorias);
        Comunes.cargarJList(jListNoSeleccionadas, categoriasDisponibles);
        Comunes.cargarJList(jListSeleccionadas, categorias);

    }

    private void quitarCategoria() {

        if (!jListSeleccionadas.getSelectedValuesList().isEmpty()) {
            categorias.removeAll(jListSeleccionadas.getSelectedValuesList());
        }
        cargarCategorias();
    }

    private void filtarVentasCategorias(List<Venta> ventas, List<Categoria> categorias) {
        listaVentasFiltradas = new ArrayList<>();

        //RECORREMOS VENTAS
        ventas.forEach((venta) -> {
            BigDecimal totalComun = new BigDecimal("0.00");
            BigDecimal totalpromo = new BigDecimal("0.00");
            Venta ventaAux = new Venta();
            ventaAux = venta;

            List<VentaArticulo> listaVentaArticuloFiltrados = new ArrayList<>();
            //RECORREMOS ARTICULOS DE LA VENTA
            for (VentaArticulo ventasArticulo : venta.getVentasArticulos()) {
                Articulo articulo = ArticuloFacade.getInstance().buscarPorCodigo(ventasArticulo.getArticuloCodigo());

                if (categorias.contains(articulo.getSubCategoria().getCategoria())) {
                    //AGREGAMOS A ESTA LISTA SOLO LOS ARTICULOS DE LAS CATEGORIAS SELECCIONADAS EN EL JLIST
                    listaVentaArticuloFiltrados.add(ventasArticulo);
                    totalComun = totalComun.add((BigDecimal) ventasArticulo.getPrecioUnitario());
                    totalpromo = totalpromo.add((BigDecimal) ventasArticulo.getPrecioPromocion());
                }
            }
            ventaAux.setMonto(totalComun);
            tfTotalVentasSinPromo.setText(totalComun.toString());
            //ventaAux.set
            ventaAux.setVentasArticulos(listaVentaArticuloFiltrados);
            listaVentasFiltradas.add(ventaAux);

        });
        System.out.println("LISTA DE VENTAS FILTRADA: " + listaVentasFiltradas);
        //VentaFacade.getInstance().getTotalVentasSinPromo(fechaIni, fechaFin, sucursal)

    }

}
