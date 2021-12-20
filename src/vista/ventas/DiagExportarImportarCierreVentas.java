/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.ventas;

import entidades.Sucursal;
import entidades.articulo.Articulo;
import entidades.cliente.Organismo;
import entidades.cliente.Persona;
import entidades.persona.DocumentoIdentidad;
import entidades.persona.TipoDocumento;
import entidades.usuario.Usuario;
import entidades.venta.CierreVentas;
import entidades.venta.Venta;
import entidades.venta.VentaArticulo;
import facade.ArticuloFacade;
import facade.CierreVentasFacade;
import facade.ClienteFacade;
import facade.SucursalFacade;
import facade.TipoDocumentoFacade;
import facade.UsuarioFacade;
import facade.VentaFacade;
import includes.ExportarExcel;
import includes.ModeloTablaNoEditable;
import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JViewport;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

/**
 *
 * @author hugo
 */
public class DiagExportarImportarCierreVentas extends javax.swing.JDialog {

    /**
     * Creates new form DiagClienteGenerico
     */
    private String tipoOperacion;
    private javax.swing.JTextField jTextField;
    private ModeloTablaNoEditable modeloTablaCierreVentas;
    private Vector headers = new Vector();
    private Vector data = new Vector();
    private Venta venta;
    private VentaArticulo ventaArticulo;
    private List<VentaArticulo> listaVentaArticulos;
    private Articulo articulo;

    private Persona persona;
    private Organismo organismo;

    private DocumentoIdentidad documento;
    private TipoDocumento tipodoc;

    private Sucursal sucursal;
    private Usuario usuario;

    private int AuxTicket, AuxSucursal;
    private CierreVentas cierreVentas;

    public DiagExportarImportarCierreVentas(java.awt.Frame parent, boolean modal, Sucursal sucursal) {
        super(parent, modal);
        initComponents();
        this.sucursal = sucursal;
        inicializarComponentes();
    }

    public DiagExportarImportarCierreVentas(java.awt.Frame parent, boolean modal, String tipoOperacion, Sucursal sucursal) {
        super(parent, modal);
        initComponents();
        this.tipoOperacion = tipoOperacion;
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

        bgCodDesc = new javax.swing.ButtonGroup();
        btnCerrar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCierreVentas = new javax.swing.JTable();
        btnExportarArt = new javax.swing.JButton();
        btnImportarArt = new javax.swing.JButton();
        btnGuardarCambios = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/back.png"))); // NOI18N
        btnCerrar.setText(org.openide.util.NbBundle.getMessage(DiagExportarImportarCierreVentas.class, "DiagExportarImportarCierreVentas.btnCerrar.text")); // NOI18N
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(org.openide.util.NbBundle.getMessage(DiagExportarImportarCierreVentas.class, "DiagExportarImportarCierreVentas.jPanel3.border.title"))); // NOI18N

        tblCierreVentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Anulado", "Descuento", "Fecha", "Monto", "Numero Ticket", "Apellido Cli", "Nombre Cli", "Nro Dni", "Tipo Dni", "Razon Social", "CUIL", "Cod Sucursal", "Usu", "CantidadPeso", "PrecioxCatidad", "Precio Cobrado", "Precio Unitario", "Articulo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblCierreVentas);

        btnExportarArt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/new_page.png"))); // NOI18N
        btnExportarArt.setText(org.openide.util.NbBundle.getMessage(DiagExportarImportarCierreVentas.class, "DiagExportarImportarCierreVentas.btnExportarArt.text")); // NOI18N
        btnExportarArt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportarArtActionPerformed(evt);
            }
        });

        btnImportarArt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/new_page.png"))); // NOI18N
        btnImportarArt.setText(org.openide.util.NbBundle.getMessage(DiagExportarImportarCierreVentas.class, "DiagExportarImportarCierreVentas.btnImportarArt.text")); // NOI18N
        btnImportarArt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImportarArtActionPerformed(evt);
            }
        });

        btnGuardarCambios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/save.png"))); // NOI18N
        btnGuardarCambios.setText(org.openide.util.NbBundle.getMessage(DiagExportarImportarCierreVentas.class, "DiagExportarImportarCierreVentas.btnGuardarCambios.text")); // NOI18N
        btnGuardarCambios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarCambiosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1321, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnGuardarCambios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnImportarArt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnExportarArt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnExportarArt, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnImportarArt, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGuardarCambios)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(584, 584, 584)
                .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCerrar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void btnExportarArtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportarArtActionPerformed
        Exportar();
    }//GEN-LAST:event_btnExportarArtActionPerformed

    private void btnImportarArtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImportarArtActionPerformed
        Importar();
    }//GEN-LAST:event_btnImportarArtActionPerformed

    private void btnGuardarCambiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarCambiosActionPerformed
        guardarCierreVentas();
    }//GEN-LAST:event_btnGuardarCambiosActionPerformed

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
            java.util.logging.Logger.getLogger(DiagExportarImportarCierreVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DiagExportarImportarCierreVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DiagExportarImportarCierreVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DiagExportarImportarCierreVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DiagExportarImportarCierreVentas dialog = new DiagExportarImportarCierreVentas(new javax.swing.JFrame(), true, new Sucursal());
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
    private javax.swing.ButtonGroup bgCodDesc;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnExportarArt;
    private javax.swing.JButton btnGuardarCambios;
    private javax.swing.JButton btnImportarArt;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblCierreVentas;
    // End of variables declaration//GEN-END:variables

    private void inicializarComponentes() {
        this.setTitle("Exportar/Importar Cierre de Ventas");
        modeloTablaCierreVentas = new ModeloTablaNoEditable();
        cargarEncabezadosTablaArticulos(modeloTablaCierreVentas);
        if (sucursal.getCodigo().equals("1")) {
            try {
                cargarTablaCierreVentas(CierreVentasFacade.getInstance().listarCierreVentas());
            } catch (Exception e) {
            }
        } else {
            try {
                cargarTablaCierreVentas(CierreVentasFacade.getInstance().listarCierreVentas(sucursal));
            } catch (Exception e) {
            }
        }

        AuxTicket = 0;
        AuxSucursal = 0;
        if (!sucursal.getNombre().toUpperCase().contains("CENTRAL")) {
            btnGuardarCambios.setEnabled(false);
            btnImportarArt.setEnabled(false);
        }
    }

    private void cargarTablaCierreVentas(List<CierreVentas> cierreVentas) {
        modeloTablaCierreVentas = new ModeloTablaNoEditable();
        cargarEncabezadosTablaArticulos(modeloTablaCierreVentas);
        configurarTabla(tblCierreVentas);
        try {
            cargarCierreVentas(cierreVentas);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, "Error: " + ex);
        }
    }

    private void cargarEncabezadosTablaArticulos(ModeloTablaNoEditable modeloTablaCierreVentas) {
        modeloTablaCierreVentas.addColumn("Id");
        modeloTablaCierreVentas.addColumn("Cantidad");
        modeloTablaCierreVentas.addColumn("Fecha");
        modeloTablaCierreVentas.addColumn("Importe");
        modeloTablaCierreVentas.addColumn("Numero de Cierre");
        modeloTablaCierreVentas.addColumn("Sucursal");
        modeloTablaCierreVentas.addColumn("Ticket Desde");
        modeloTablaCierreVentas.addColumn("Ticket Hasta");
        tblCierreVentas.setModel(modeloTablaCierreVentas);
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

    private void cargarCierreVentas(List<CierreVentas> cierreVentas) {
        try {
            modeloTablaCierreVentas = new ModeloTablaNoEditable();
            cargarEncabezadosTablaArticulos(modeloTablaCierreVentas);
            for (CierreVentas cierreVenta : cierreVentas) {
                cargarCierreVenta(cierreVenta);
            }

            tblCierreVentas.setModel(modeloTablaCierreVentas);
            // Comunes.setOcultarColumnasJTable(tblVentas, 0);
        } catch (Exception ex) {
            Logger.getLogger(DiagExportarImportarCierreVentas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void cargarCierreVenta(CierreVentas cierreVentas) {
        // JOptionPane.showMessageDialog(null, "va "+va.getCantidadPeso());
        SimpleDateFormat formats = new SimpleDateFormat("dd/MM/yyyy");
        DecimalFormatSymbols simboloSeparador = new DecimalFormatSymbols(Locale.ENGLISH);
        simboloSeparador.setDecimalSeparator(',');
        DecimalFormat formatoConComa = new DecimalFormat("#####.###", simboloSeparador);
        Object[] fila = new Object[9];
        fila[0] = cierreVentas.getId();
        fila[1] = cierreVentas.getCantidad();
        try {
            fila[2] = formats.format(cierreVentas.getFecha());
        } catch (Exception e) {
        }
        fila[3] = formatoConComa.format(cierreVentas.getImporte());
        fila[4] = cierreVentas.getNumeroCierre();
        fila[5] = cierreVentas.getSucursal().getCodigo();
        fila[6] = cierreVentas.getTicketDesde();
        fila[7] = cierreVentas.getTicketHasta();
        modeloTablaCierreVentas.addRow(fila);
    }

    private void Exportar() {
        new ExportarExcel().crearExcelJtable(tblCierreVentas, "Listado de CierreVentas");
        modeloTablaCierreVentas = new ModeloTablaNoEditable();
        cargarEncabezadosTablaArticulos(modeloTablaCierreVentas);
    }

    private void Importar() {
        JFileChooser jChooser = new JFileChooser(System.getProperty("user.dir"));
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos Excel", "xls");
        jChooser.setFileFilter(filter);
        jChooser.showOpenDialog(this);
        File file = jChooser.getSelectedFile();
        if (file == null || !file.getName().endsWith("xls")) {
            JOptionPane.showMessageDialog(null, "Solo se permiten Archivos .xls.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            leerDatosExcel(file);
            List<Integer> columnasNoEditables = new ArrayList<>();
            columnasNoEditables.add(0);
            columnasNoEditables.add(1);
            columnasNoEditables.add(2);
            columnasNoEditables.add(3);
            columnasNoEditables.add(4);
            columnasNoEditables.add(5);
            columnasNoEditables.add(6);
            columnasNoEditables.add(7);
            columnasNoEditables.add(8);
            columnasNoEditables.add(9);
            columnasNoEditables.add(10);
            columnasNoEditables.add(11);
            columnasNoEditables.add(12);
            columnasNoEditables.add(13);
            columnasNoEditables.add(14);
            ModeloTablaNoEditable model = new ModeloTablaNoEditable(data, headers, columnasNoEditables);
            tblCierreVentas.setModel(model);
        }
    }

    void leerDatosExcel(File file) {
        Workbook workbook = null;
        try {
            try {
                workbook = Workbook.getWorkbook(file);
            } catch (IOException ex) {
                System.out.println("Error: " + ex);
            }
            Sheet sheet = workbook.getSheet(0);
            headers.clear();
            for (int i = 0; i < sheet.getColumns(); i++) {
                Cell cell1 = sheet.getCell(i, 0);
                headers.add(cell1.getContents());
            }
            data.clear();
            for (int j = 1; j < sheet.getRows(); j++) {
                Vector d = new Vector();
                for (int i = 0; i < sheet.getColumns(); i++) {
                    Cell cell = sheet.getCell(i, j);
                    d.add(cell.getContents());
                }
                d.add("\n");
                data.add(d);
            }
        } catch (BiffException e) {
            e.printStackTrace();
        }
    }

//    private void guardarVentas() {
//
//        try {
//            for (int i = 0; i < tblVentas.getRowCount(); i++) {
//                //JOptionPane.showMessageDialog(null,"numero ticket y sucursal"+(String) tblVentas.getValueAt(i, 5)+(String) tblVentas.getValueAt(i, 12));
//                //verificamos la existencia de la venta en la base de datos, validamos por numero ticket y sucursal
//                if (!VentaFacade.getInstance().getVentaNumeroTicketSucursal((String) tblVentas.getValueAt(i, 5), (String) tblVentas.getValueAt(i, 12))) {
//                  
//                    
//                    
//                    venta = new Venta();
//                    
//                    
//                    
//                    if (tblVentas.getValueAt(i, 1).equals("true")) {
//                        venta.setAnulado(true);
//                    } else {
//                        venta.setAnulado(false);
//                    }
//
//                    if (tblVentas.getValueAt(i, 2).equals("")) {
//                        System.out.println("entra set descuento");
//                        venta.setDescuento(new BigDecimal((String) tblVentas.getValueAt(i, 2)));
//                    }
//
//                    SimpleDateFormat formats = new SimpleDateFormat("dd/MM/yyyy");
//                    venta.setFecha(formats.parse((String) tblVentas.getValueAt(i, 3)));
//                    //System.out.println("paso");
//                    venta.setMonto(new BigDecimal((String) tblVentas.getValueAt(i, 4)));
//
//                    venta.setNumeroTicket((String) tblVentas.getValueAt(i, 5));
//
//                    //Si es Persona
//                    if (!tblVentas.getValueAt(i, 8).equals("null")) {
//                    //System.out.println("paso");
//                    //JOptionPane.showMessageDialog(null, "llego");
//                        try {
//                            JOptionPane.showMessageDialog(null, "entro por persona" + ClienteFacade.getInstance().getPersonaXDni((String) tblVentas.getValueAt(i, 8)).getDocumentoIdentidad().getNumero());
//                        } catch (Exception e) {
//                        }
//
//                        persona = new Persona();
//
////Buscamos si existe el cliente persona
//                        if (ClienteFacade.getInstance().getPersonaDni((String) tblVentas.getValueAt(i, 8))) {
//                            //si existe se la setea a persona
//            //                JOptionPane.showMessageDialog(null, "existe persona");
//                            persona = ClienteFacade.getInstance().getPersonaXDni((String) tblVentas.getValueAt(i, 8));
//                        } else {
//                            //sino se la crea
//                            persona.setApellido((String) tblVentas.getValueAt(i, 6));
//                            persona.setNombre((String) tblVentas.getValueAt(i, 7));
//
//                            documento = new DocumentoIdentidad();
//                            documento.setNumero((String) tblVentas.getValueAt(i, 8));
//
//                            //Buscamos si existe tipo de Documento
//                            tipodoc = new TipoDocumento();
//                            if (TipoDocumentoFacade.getInstance().buscarExisteTipo((String) tblVentas.getValueAt(i, 8))) {
//                                //si existe sel le setea
//                                tipodoc = TipoDocumentoFacade.getInstance().buscarPorTipo((String) tblVentas.getValueAt(i, 8));
//                            } else {
//                                //sino se lo crea
//                                tipodoc.setDescripcion((String) tblVentas.getValueAt(i, 9));
//                                TipoDocumentoFacade.getInstance().alta(tipodoc);
//                            }
//
//                            documento.setTipoDocumento(tipodoc);
//                            persona.setDocumentoIdentidad(documento);
//                            ClienteFacade.getInstance().alta(persona);
//                        }
//
//                        venta.setCliente(persona);
//
//                    }
//
//                    //Si es Organismo
//                    if (!tblVentas.getValueAt(i, 11).equals("null")) {
//                        JOptionPane.showMessageDialog(null, "entro por organismo");
//                        try {
//                            JOptionPane.showMessageDialog(null, "entro por Organismo" + ClienteFacade.getInstance().buscarCuitEmpresaObjeto((String) tblVentas.getValueAt(i, 11)).getCUIT());
//                        } catch (Exception e) {
//                            JOptionPane.showMessageDialog(null, "Error: "+e);
//                        }
//                        organismo = new Organismo();
//                        //Buscamos si existe el cliente organismo 
//                        if (ClienteFacade.getInstance().buscarCuitEmpresa((String) tblVentas.getValueAt(i, 11))) {
//                            //si existe se lo setea 
//                            organismo = ClienteFacade.getInstance().buscarCuitEmpresaObjeto((String) tblVentas.getValueAt(i, 11));
//                        } else {
//                            //sino se lo crea
//                            organismo.setCUIT((String) tblVentas.getValueAt(i, 11));
//                            organismo.setRazonSocial((String) tblVentas.getValueAt(i, 10));
//                            ClienteFacade.getInstance().alta(organismo);
//                        }
//
//                        venta.setCliente(organismo);
//                    }
//
//                    //existe sucursal
//                    if (SucursalFacade.getInstance().buscarExisteCodigo((String) tblVentas.getValueAt(i, 12))) {
//                        //buscar y setear sucursal
//                        sucursal = new Sucursal();
//                        sucursal = SucursalFacade.getInstance().buscarPorCodigo((String) tblVentas.getValueAt(i, 12));
//                    }
//
//                    //existe usuario
//                    UsuarioFacade uF = new UsuarioFacade();
//                    if (uF.buscarExisteUsuario((String) tblVentas.getValueAt(i, 13))) {
//                        //buscar y setear Usuario
//                        usuario = new Usuario();
//                        usuario = uF.buscarPorNombre((String) tblVentas.getValueAt(i, 13));
//                    }
//                    venta.setSucursal(sucursal);
//                    venta.setUsuario(usuario);
//                    VentaFacade.getInstance().alta(venta);
//                }
//                
//            }
//            JOptionPane.showMessageDialog(null, "Importacion de ventas Realizado");
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "ERROR" + e);
//        }
//
//    }
    private void guardarCierreVentas() {
        SimpleDateFormat formats = new SimpleDateFormat("dd/MM/yyyy");
        //JOptionPane.showMessageDialog(null, "entro gusrdarVentas");
        try {
            for (int i = 0; i < tblCierreVentas.getRowCount(); i++) {
                //JOptionPane.showMessageDialog(null,"numero ticket y sucursal"+(String) tblVentas.getValueAt(i, 5)+(String) tblVentas.getValueAt(i, 12));
                //verificamos la existencia de la venta en la base de datos, validamos por numero ticket y sucursal

                //si no existe la venta la creamos
                if (!CierreVentasFacade.getInstance().existeCierreVentaSucursal(Integer.valueOf(tblCierreVentas.getValueAt(i, 4).toString()), (String) tblCierreVentas.getValueAt(i, 5))) {

                    cierreVentas = new CierreVentas();
                    cierreVentas.setCantidad(Integer.parseInt(tblCierreVentas.getValueAt(i, 1).toString()));
                    try {
                        cierreVentas.setFecha(formats.parse(tblCierreVentas.getValueAt(i, 2).toString()));
                    } catch (ParseException ex) {
                        Logger.getLogger(DiagExportarImportarCierreVentas.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    cierreVentas.setImporte(new BigDecimal((String) tblCierreVentas.getValueAt(i, 3)));
                    cierreVentas.setNumeroCierre(Integer.parseInt(tblCierreVentas.getValueAt(i, 4).toString()));
                    cierreVentas.setSucursal(SucursalFacade.getInstance().buscarPorCodigo((String) tblCierreVentas.getValueAt(i, 5)));
                    cierreVentas.setSucursal(sucursal);
                    cierreVentas.setTicketDesde(Integer.parseInt(tblCierreVentas.getValueAt(i, 6).toString()));

                    cierreVentas.setTicketHasta(Integer.parseInt(tblCierreVentas.getValueAt(i, 7).toString()));
                    CierreVentasFacade.getInstance().alta(cierreVentas);

                }

            }
            JOptionPane.showMessageDialog(null, "Importacion de Cierres de Ventas Realizado");
            this.dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR" + e);
        }
    }

}