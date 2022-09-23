/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.articulos;

import entidades.Sucursal;
import entidades.articulo.Articulo;
import entidades.articulo.ListaPrecio;
import entidades.articulo.PrecioArticulo;
import facade.ArticuloFacade;
import facade.GenericoFacade;
import facade.ListaPrecioFacade;
import facade.PrecioArticuloFacade;
import includes.Comunes;
import static includes.Comunes.redondear;
import includes.ExportarExcel;
import includes.ModeloTablaNoEditable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

/**
 *
 * @author franco
 */
public class DiagAsignarPrecios extends javax.swing.JDialog {

    private ModeloTablaNoEditable modeloTablaArticulos;
    private List<ListaPrecio> listasPrecio;
    private Sucursal sucursal;
    private Vector headers = new Vector();
    private Vector data = new Vector();
    private Sucursal sucursalOrigen;

    /**
     * Creates new form DiagAsignarPrecios
     *
     * @param parent ventana padre
     * @param modal si es modal o no
     * @param sucursal sucursal de la carniceria
     */
    /**
     *
     * @param parent
     * @param modal
     * @param sucursal
     */
    public DiagAsignarPrecios(java.awt.Frame parent, boolean modal, Sucursal sucursal, Sucursal sucursalOrigen) {
        super(parent, modal);
        initComponents();
        this.sucursal = sucursal;
        this.sucursalOrigen = sucursalOrigen;
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
        btnExportar = new javax.swing.JButton();
        btnImportar = new javax.swing.JButton();
        btnEliminarLista = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblArticulos = new javax.swing.JTable();
        btnGuardar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(org.openide.util.NbBundle.getMessage(DiagAsignarPrecios.class, "DiagAsignarPrecios.title")); // NOI18N

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnExportar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/new_page.png"))); // NOI18N
        btnExportar.setText(org.openide.util.NbBundle.getMessage(DiagAsignarPrecios.class, "DiagAsignarPrecios.btnExportar.text")); // NOI18N
        btnExportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportarActionPerformed(evt);
            }
        });

        btnImportar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/new_page.png"))); // NOI18N
        btnImportar.setText(org.openide.util.NbBundle.getMessage(DiagAsignarPrecios.class, "DiagAsignarPrecios.btnImportar.text")); // NOI18N
        btnImportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImportarActionPerformed(evt);
            }
        });

        btnEliminarLista.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/remove.png"))); // NOI18N
        btnEliminarLista.setText(org.openide.util.NbBundle.getMessage(DiagAsignarPrecios.class, "DiagAsignarPrecios.btnEliminarLista.text")); // NOI18N
        btnEliminarLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarListaActionPerformed(evt);
            }
        });

        tblArticulos.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblArticulos);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 596, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnExportar)
                    .addComponent(btnImportar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEliminarLista, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnExportar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnImportar)
                        .addGap(133, 133, 133)
                        .addComponent(btnEliminarLista)))
                .addGap(21, 21, 21))
        );

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/save.png"))); // NOI18N
        btnGuardar.setText(org.openide.util.NbBundle.getMessage(DiagAsignarPrecios.class, "DiagAsignarPrecios.btnGuardar.text")); // NOI18N
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(341, 341, 341)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGuardar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        guardar();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnExportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportarActionPerformed
        exportar();
    }//GEN-LAST:event_btnExportarActionPerformed

    private void btnImportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImportarActionPerformed
        importar();
    }//GEN-LAST:event_btnImportarActionPerformed

    private void btnEliminarListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarListaActionPerformed
        eliminarListaPrecio();
    }//GEN-LAST:event_btnEliminarListaActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminarLista;
    private javax.swing.JButton btnExportar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnImportar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblArticulos;
    // End of variables declaration//GEN-END:variables

    private void guardar() {

        int reply = JOptionPane.showConfirmDialog(null,
                "¿Desea guardar los cambios?", "Atualizar Precios",
                JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
            try {
                guardarArticulos();
                JOptionPane.showMessageDialog(null, "Precios actualizados correctamente");
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

    private void inicializarComponentes() {
        if (!sucursalOrigen.getNombre().contains("CENTRAL")) {
            tblArticulos.setEnabled(false);
            btnEliminarLista.setEnabled(false);
            btnGuardar.setEnabled(false);
            btnImportar.setEnabled(false);
        }

        //PARA QUE NO SE PUEDAN MOVER LAS COLUMNAS, HACE DESASTRE FATAL
        tblArticulos.getTableHeader().setReorderingAllowed(false);
        //COLUMNA SELECCIONABLE PARA ELIMINAR LISTA
        tblArticulos.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        tblArticulos.setCellSelectionEnabled(true);
        tblArticulos.setRowSelectionAllowed(false);
        // SCROLL HORIZONTAL JTABLE
        jScrollPane1.createHorizontalScrollBar();
        tblArticulos.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        listasPrecio = ListaPrecioFacade.getInstance().getTodos();
        cargarTabla();

    }

    private void cargarEncabezadosTabla(ModeloTablaNoEditable modeloTablaArticulos) {
        modeloTablaArticulos.addColumn("ID");
        modeloTablaArticulos.addColumn("Código");
        modeloTablaArticulos.addColumn("Articulo");

        for (ListaPrecio lista : listasPrecio) {
            modeloTablaArticulos.addColumn(lista.getDescripcion());
        }
        tblArticulos.setModel(modeloTablaArticulos);
        Comunes.setOcultarColumnasJTable(tblArticulos, 0);
    }

    private void cargarTabla() {
        List<Integer> columnasNoEditables = new ArrayList<>();
        columnasNoEditables.add(0);
        columnasNoEditables.add(1);
        columnasNoEditables.add(2);
        modeloTablaArticulos = new ModeloTablaNoEditable(columnasNoEditables);
        cargarEncabezadosTabla(modeloTablaArticulos);
        cargarArticulos();

    }

    private void cargarArticulos() {
        for (Articulo articulo : ArticuloFacade.getInstance().getTodos()) {
            cargarArticulo(articulo);
        }
    }

    private void guardarArticulos() {
        ArticuloFacade articuloFacade = ArticuloFacade.getInstance();
        PrecioArticuloFacade precioFacade = PrecioArticuloFacade.getInstance();
        for (int i = 0; i < tblArticulos.getRowCount(); i++) {
            Articulo articulo = articuloFacade.buscar(Long.valueOf(tblArticulos.getValueAt(i, 0).toString()));
            int numeroColumna = 3;
            for (ListaPrecio lista : listasPrecio) {
                PrecioArticulo pa = precioFacade.get(articulo, lista, sucursal);
                String precio = tblArticulos.getValueAt(i, numeroColumna++).toString().replace(",", ".");
    //            System.out.println("precio de la tabla: "+precio);
                pa.setPrecio(redondear(new BigDecimal(precio)));
                precioFacade.modificar(pa);
            }
        }
    }

    private void cargarArticulo(Articulo articulo) {
        int filas = modeloTablaArticulos.getColumnCount();
        int numeroFila = 0;
        Object[] fila = new Object[filas];
        fila[numeroFila++] = articulo.getId();
        fila[numeroFila++] = articulo.getCodigoBarra();
        fila[numeroFila++] = articulo.getDescripcion();
        PrecioArticuloFacade precioFacade = PrecioArticuloFacade.getInstance();
        for (ListaPrecio lista : listasPrecio) {

            PrecioArticulo pa = precioFacade.get(articulo, lista, sucursal);
            //solo la central puede asignar precios, las sucursales solo
            //leen precios sincronizados
           if (sucursal.getNombre().contains("CENTRAL")) {
                if (pa == null) {
                    pa = new PrecioArticulo();
                    pa.setArticulo(articulo);
                    pa.setListaPrecio(lista);
                    pa.setSucursal(sucursal);
                    pa.setPrecio(BigDecimal.ZERO);
                    precioFacade.alta(pa);
                }
                fila[numeroFila++] = pa.getPrecio();
           }else{
               //si no es central tiene que solamente leer datos
               // o cargar ceros sin posibilidad de guardar los cambio
               if(pa==null){
                 fila[numeroFila++] = BigDecimal.ZERO;  
               }else{
                 fila[numeroFila++] = pa.getPrecio();  
               }
           }

        }
        modeloTablaArticulos.addRow(fila);
    }

    private void exportar() {
        new ExportarExcel().crearExcelJtable(tblArticulos, "Listado de Precios");
    }

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
            ModeloTablaNoEditable model = new ModeloTablaNoEditable(data, headers, columnasNoEditables);
            tblArticulos.setModel(model);

        }
    }

    /**
     * * Fill JTable with Excel file data. * * @param file * file :contains xls
     * file to display in jTable
     */
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

    private void eliminarListaPrecio() {
        if (tblArticulos.getSelectedColumn() != -1) {
            int i = JOptionPane.showConfirmDialog(null, "¿Desea eliminar la Lista de Precio Seleccionada?", "Confirmar eliminacion", JOptionPane.YES_NO_OPTION);
            if (i == 0) {
                try {
                    ListaPrecio listaPrecio = (ListaPrecio) GenericoFacade.getInstance().buscar(tblArticulos.getColumnName(tblArticulos.getSelectedColumn()), "ListaPrecio");
                    //recorremos para eliminar los registros
                    for (PrecioArticulo precioArticulo : PrecioArticuloFacade.getInstance().get(listaPrecio, sucursal)) {
                        PrecioArticuloFacade.getInstance().eliminar(precioArticulo.getId());
                    }
                    ListaPrecioFacade.getInstance().eliminar(listaPrecio.getId());
                    JOptionPane.showMessageDialog(null, "Lista de Precios Eliminada!!");
                    this.dispose();
                } catch (Exception e) {

                }

            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe Seleccionar una lista para eliminarla completamente");
        }
    }

}