/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.promocion;

import vista.cliente.*;
import entidades.cliente.Cliente;
import entidades.cliente.Organismo;
import entidades.cliente.Persona;
import entidades.persona.DocumentoIdentidad;
import entidades.persona.Telefono;
import entidades.persona.TipoDocumento;
import entidades.persona.TipoTelefono;
import entidades.promocion.Promocion;
import facade.ClienteFacade;
import facade.TelefonoFacade;
import facade.TipoDocumentoFacade;
import facade.TipoTelefonoFacade;
import includes.ExportarExcel;
import includes.ModeloTablaNoEditable;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

/**
 *
 * @author vouilloz
 */
public class DiagImportarExportarPromociones extends javax.swing.JDialog {

    private Vector headers = new Vector();
    private Vector data = new Vector();
    private List<Cliente> listasCliente;
    private ModeloTablaNoEditable modeloTablaPromociones;
    private Persona persona;
    private Organismo organismo;
    private TipoTelefono tipotel;
    private Telefono telefono;
    private DocumentoIdentidad documento;
    private TipoDocumento tipoDoc;

    /**
     * Creates new form DiagImportarExportarClientes
     */
    public DiagImportarExportarPromociones(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tblPromociones = new javax.swing.JTable();
        btnImportarPromociones = new javax.swing.JButton();
        btnExportarPromociones = new javax.swing.JButton();
        btnGuardarPromociones = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tblPromociones.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblPromociones);

        btnImportarPromociones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/new_page.png"))); // NOI18N
        btnImportarPromociones.setText(org.openide.util.NbBundle.getMessage(DiagImportarExportarPromociones.class, "DiagImportarExportarPromociones.btnImportarPromociones.text")); // NOI18N
        btnImportarPromociones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImportarPromocionesActionPerformed(evt);
            }
        });

        btnExportarPromociones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/new_page.png"))); // NOI18N
        btnExportarPromociones.setText(org.openide.util.NbBundle.getMessage(DiagImportarExportarPromociones.class, "DiagImportarExportarPromociones.btnExportarPromociones.text")); // NOI18N
        btnExportarPromociones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportarPromocionesActionPerformed(evt);
            }
        });

        btnGuardarPromociones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/save.png"))); // NOI18N
        btnGuardarPromociones.setText(org.openide.util.NbBundle.getMessage(DiagImportarExportarPromociones.class, "DiagImportarExportarPromociones.btnGuardarPromociones.text")); // NOI18N
        btnGuardarPromociones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarPromocionesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 544, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnImportarPromociones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnExportarPromociones, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(268, 268, 268)
                        .addComponent(btnGuardarPromociones, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(btnImportarPromociones, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnExportarPromociones, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(btnGuardarPromociones)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnImportarPromocionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImportarPromocionesActionPerformed
        importar();
    }//GEN-LAST:event_btnImportarPromocionesActionPerformed

    private void btnExportarPromocionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportarPromocionesActionPerformed
        exportar();
    }//GEN-LAST:event_btnExportarPromocionesActionPerformed

    private void btnGuardarPromocionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarPromocionesActionPerformed
        guardar();
    }//GEN-LAST:event_btnGuardarPromocionesActionPerformed

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
            java.util.logging.Logger.getLogger(DiagImportarExportarPromociones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DiagImportarExportarPromociones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DiagImportarExportarPromociones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DiagImportarExportarPromociones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DiagImportarExportarPromociones dialog = new DiagImportarExportarPromociones(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnExportarPromociones;
    private javax.swing.JButton btnGuardarPromociones;
    private javax.swing.JButton btnImportarPromociones;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblPromociones;
    // End of variables declaration//GEN-END:variables

    private void importar() {
        JFileChooser jChooser = new JFileChooser(System.getProperty("user.dir"));
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos Excel", "xls");
        jChooser.setFileFilter(filter);
        jChooser.showOpenDialog(this);
        File file = jChooser.getSelectedFile();
        if (file == null || !file.getName().endsWith("xls")) {
            JOptionPane.showMessageDialog(null, "Please select only Excel file.", "Error", JOptionPane.ERROR_MESSAGE);
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
            ModeloTablaNoEditable model = new ModeloTablaNoEditable(data, headers, columnasNoEditables);
            tblPromociones.setModel(model);
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

    private void exportar() {
        new ExportarExcel().crearExcelJtable(tblPromociones, "Listado de Personas");
    }

    private void inicializarComponentes() {
        cargarTablaPromociones();

    }

    private void cargarTablaPromociones() {
        List<Integer> columnasNoEditables = new ArrayList<>();
        columnasNoEditables.add(0);
        columnasNoEditables.add(1);
        columnasNoEditables.add(2);
        columnasNoEditables.add(3);
        columnasNoEditables.add(4);
        columnasNoEditables.add(5);
        columnasNoEditables.add(6);
        modeloTablaPromociones = new ModeloTablaNoEditable(columnasNoEditables);
        cargarEncabezadosTabla(modeloTablaPromociones);
    }

    private void cargarEncabezadosTabla(ModeloTablaNoEditable modeloTablaClientes) {
        modeloTablaClientes.addColumn("Nombre");
        modeloTablaClientes.addColumn("Fecha Inicio");
        modeloTablaClientes.addColumn("Fecha Fin");
        modeloTablaClientes.addColumn("Es por Precio");
        modeloTablaClientes.addColumn("Porcentaje a todos");
        modeloTablaClientes.addColumn("Habilitada");
        modeloTablaClientes.addColumn("Prioridad");
        tblPromociones.setModel(modeloTablaPromociones);
    }

    /*   private void cargarPromocion(Promocion promocion) {
     int filas = modeloTablaPromociones.getColumnCount();
     int numeroFila = 0;
     Object[] fila = new Object[filas];
     //fila[numeroFila++] = cliente.getId();
     fila[numeroFila++] = promocion.getNombre();
     fila[numeroFila++] = promocion.getFechaInicio().toString();
     fila[numeroFila++] = promocion.getFechaFin().toString();
     fila[numeroFila++] = promocion.isEsPorPrecio();
     fila[numeroFila++] = promocion.getPorcentajeATodos();
     fila[numeroFila++] = promocion.isHabilitada();
     fila[numeroFila++] = promocion.getPrioridad();
        
     modeloTablaPromociones.addRow(fila);
     }*/
    private void guardar() {
        int reply = JOptionPane.showConfirmDialog(null,
                "¿Desea guardar los cambios?", "Atualizar Clientes",
                JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
            try {
                guardarPromociones();
                JOptionPane.showMessageDialog(null, "Clientes actualizados correctamente");
                this.dispose();
            } catch (java.lang.NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "No se han guardado los cambios \n"
                        + "Es posible que haya ingresado un valor incorrecto",
                        "Error Guardando", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "No se han guardado los cambios");
            this.dispose();
        }

    }

    private void guardarPromociones() {

        try {
            for (int i = 0; i < tblPromociones.getRowCount(); i++) {
                persona = new Persona();
                documento = new DocumentoIdentidad();
                tipoDoc = new TipoDocumento();
                persona.setApellido(tblPromociones.getValueAt(i, 0).toString());
                persona.setNombre(tblPromociones.getValueAt(i, 1).toString());

                if (tblPromociones.getValueAt(i, 2).toString().equals("dni")) {
                    tipoDoc = (TipoDocumento) TipoDocumentoFacade.getInstance().buscarPorTipo(tblPromociones.getValueAt(i, 2).toString());
                }

                documento.setNumero(tblPromociones.getValueAt(i, 3).toString());
                documento.setTipoDocumento(tipoDoc);
                persona.setDocumentoIdentidad(documento);

                ClienteFacade.getInstance().alta(persona);

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "" + e);
        }

    }

}