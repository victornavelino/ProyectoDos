/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.categorias;

import entidades.articulo.Categoria;
import entidades.articulo.SubCategoria;
import facade.CategoriaFacade;
import facade.SubCategoriaFacade;
import includes.Comunes;
import java.awt.HeadlessException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author vouilloz
 */
public class DiagSubCategoria extends javax.swing.JDialog {

    private String tipoOperacion;
    private SubCategoria subCategoria;

    /**
     * Creates new form DiagSubCategoria
     */
    public DiagSubCategoria(java.awt.Frame parent, boolean modal, String tipoOperacion) {
        super(parent, modal);
        initComponents();
        this.tipoOperacion = tipoOperacion;
        inicializarComponentes();
    }

    private DiagSubCategoria(JFrame jFrame, boolean b) {
        //super(parent, modal);
        initComponents();
        inicializarComponentes();
    }

    public SubCategoria getSubCategoria() {
        return subCategoria;
    }

    public void setSubCategoria(SubCategoria subCategoria) {
        this.subCategoria = subCategoria;
    }

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnLista = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jlSubCategorias = new javax.swing.JList();
        btnSeleccionar = new javax.swing.JButton();
        pnSubCategoria = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tfSubCategoria = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cbCategoria = new javax.swing.JComboBox();
        btnAgregarCategoria = new javax.swing.JButton();
        btnAgregarSubCategoria = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnModificar1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        pnLista.setBorder(javax.swing.BorderFactory.createTitledBorder(org.openide.util.NbBundle.getMessage(DiagSubCategoria.class, "DiagSubCategoria.pnLista.border.title"))); // NOI18N

        jlSubCategorias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlSubCategoriasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jlSubCategorias);

        javax.swing.GroupLayout pnListaLayout = new javax.swing.GroupLayout(pnLista);
        pnLista.setLayout(pnListaLayout);
        pnListaLayout.setHorizontalGroup(
            pnListaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnListaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnListaLayout.setVerticalGroup(
            pnListaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnListaLayout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        btnSeleccionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/edit.png"))); // NOI18N
        btnSeleccionar.setText(org.openide.util.NbBundle.getMessage(DiagSubCategoria.class, "DiagSubCategoria.btnSeleccionar.text")); // NOI18N
        btnSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarActionPerformed(evt);
            }
        });

        pnSubCategoria.setBorder(javax.swing.BorderFactory.createTitledBorder(org.openide.util.NbBundle.getMessage(DiagSubCategoria.class, "DiagSubCategoria.pnSubCategoria.border.title"))); // NOI18N

        jLabel1.setText(org.openide.util.NbBundle.getMessage(DiagSubCategoria.class, "DiagSubCategoria.jLabel1.text")); // NOI18N

        tfSubCategoria.setText(org.openide.util.NbBundle.getMessage(DiagSubCategoria.class, "DiagSubCategoria.tfSubCategoria.text")); // NOI18N

        jLabel2.setText(org.openide.util.NbBundle.getMessage(DiagSubCategoria.class, "DiagSubCategoria.jLabel2.text")); // NOI18N

        cbCategoria.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " " }));

        btnAgregarCategoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/add.png"))); // NOI18N
        btnAgregarCategoria.setText(org.openide.util.NbBundle.getMessage(DiagSubCategoria.class, "DiagSubCategoria.btnAgregarCategoria.text")); // NOI18N
        btnAgregarCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarCategoriaActionPerformed(evt);
            }
        });

        btnAgregarSubCategoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/save.png"))); // NOI18N
        btnAgregarSubCategoria.setText(org.openide.util.NbBundle.getMessage(DiagSubCategoria.class, "DiagSubCategoria.btnAgregarSubCategoria.text")); // NOI18N
        btnAgregarSubCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarSubCategoriaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnSubCategoriaLayout = new javax.swing.GroupLayout(pnSubCategoria);
        pnSubCategoria.setLayout(pnSubCategoriaLayout);
        pnSubCategoriaLayout.setHorizontalGroup(
            pnSubCategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnSubCategoriaLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(pnSubCategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(pnSubCategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tfSubCategoria)
                    .addComponent(cbCategoria, 0, 374, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAgregarCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(pnSubCategoriaLayout.createSequentialGroup()
                .addGap(204, 204, 204)
                .addComponent(btnAgregarSubCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(214, Short.MAX_VALUE))
        );
        pnSubCategoriaLayout.setVerticalGroup(
            pnSubCategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnSubCategoriaLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(pnSubCategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfSubCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnSubCategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnSubCategoriaLayout.createSequentialGroup()
                        .addGroup(pnSubCategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(cbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10))
                    .addComponent(btnAgregarCategoria, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(btnAgregarSubCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/back.png"))); // NOI18N
        btnCancelar.setText(org.openide.util.NbBundle.getMessage(DiagSubCategoria.class, "DiagSubCategoria.btnCancelar.text")); // NOI18N
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnModificar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/delete.png"))); // NOI18N
        btnModificar1.setText(org.openide.util.NbBundle.getMessage(DiagSubCategoria.class, "DiagSubCategoria.btnModificar1.text")); // NOI18N
        btnModificar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnSubCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnLista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnSeleccionar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                            .addComponent(btnModificar1, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE))))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnSubCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnLista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnSeleccionar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnModificar1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAgregarCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarCategoriaActionPerformed
        agregarCategoria();// TODO add your handling code here:
    }//GEN-LAST:event_btnAgregarCategoriaActionPerformed

    private void btnAgregarSubCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarSubCategoriaActionPerformed
        altaSubCategoria();
        agregarSubCategoriaLista();
    }//GEN-LAST:event_btnAgregarSubCategoriaActionPerformed

    private void jlSubCategoriasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlSubCategoriasMouseClicked
        btnAgregarSubCategoria.setEnabled(false);
        recogerSubCategoriaSelec();
    }//GEN-LAST:event_jlSubCategoriasMouseClicked

    private void btnSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarActionPerformed
        modificarSubCategoria();
    }//GEN-LAST:event_btnSeleccionarActionPerformed

    private void btnModificar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificar1ActionPerformed
        eliminarSubCategoria();
    }//GEN-LAST:event_btnModificar1ActionPerformed

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
            java.util.logging.Logger.getLogger(DiagSubCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DiagSubCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DiagSubCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DiagSubCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DiagSubCategoria dialog = new DiagSubCategoria(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnAgregarCategoria;
    private javax.swing.JButton btnAgregarSubCategoria;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnModificar1;
    private javax.swing.JButton btnSeleccionar;
    private javax.swing.JComboBox cbCategoria;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList jlSubCategorias;
    private javax.swing.JPanel pnLista;
    private javax.swing.JPanel pnSubCategoria;
    private javax.swing.JTextField tfSubCategoria;
    // End of variables declaration//GEN-END:variables

    private void inicializarComponentes() {
        this.setTitle("Subcategorias");
        cargarComboCategorias();
        agregarSubCategoriaLista();
    }

    private void agregarCategoria() {
        DiagCategorias categorias = new DiagCategorias(null, true);
        categorias.setLocation(Comunes.centrarDialog(categorias));
        categorias.setVisible(true);
        cargarComboCategorias();
    }

    private void cargarComboCategorias() {
        Comunes.cargarJComboConBlanco(cbCategoria, CategoriaFacade.getInstance().getTodos());
    }

    private void altaSubCategoria() {
       if(validarSubCategoria()){
           try {
               SubCategoria subCat = new SubCategoria();
               subCat.setDescripcion(tfSubCategoria.getText());
               subCat.setCategoria((Categoria) cbCategoria.getSelectedItem());
               SubCategoriaFacade.getInstance().alta(subCat);
           } catch (Exception e) {
               JOptionPane.showMessageDialog(null, e);
           }
       }
    }

    private boolean validarSubCategoria() {
          if (tfSubCategoria.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe ingresar la Descripcion de la SubCategoria");
            tfSubCategoria.requestFocus();
            return false;
        } else if (cbCategoria.getSelectedIndex() < 1) {
            JOptionPane.showMessageDialog(null, "Debe Seleccionar una Categoria");
            cbCategoria.requestFocus();
            return false;
        } else {
            return true;
        }
    }

    private void agregarSubCategoriaLista() {
        Comunes.cargarJList(jlSubCategorias, SubCategoriaFacade.getInstance().getTodos());
    }

    private void recogerSubCategoriaSelec() {
        subCategoria =(SubCategoria)jlSubCategorias.getSelectedValue();
        tfSubCategoria.setText(subCategoria.getDescripcion());
        cbCategoria.setSelectedItem(subCategoria.getCategoria());
    }

    private void modificarSubCategoria() {
       if(jlSubCategorias.getSelectedIndex()!=-1){
           subCategoria.setDescripcion(tfSubCategoria.getText());
           subCategoria.setCategoria((Categoria)cbCategoria.getSelectedItem());
           SubCategoriaFacade.getInstance().modificar(subCategoria);
           JOptionPane.showMessageDialog(null, "Sub Categoria Modificada");
           tfSubCategoria.setText("");
           btnAgregarSubCategoria.setEnabled(true);
           agregarSubCategoriaLista();
     }
     else{
     JOptionPane.showMessageDialog(null, "Para poder modificar una SubCategoria debe Seleccionar una de La Lista");
     }
    }

    private void eliminarSubCategoria() {
             if(jlSubCategorias.getSelectedIndex()!=-1){
            int i = JOptionPane.showConfirmDialog(this, "¿Desea eliminar la Subcategoria seleccionada?", "Confirmar eliminacion", JOptionPane.YES_NO_OPTION);
            if (i == 0) {
               
                try {
                    SubCategoriaFacade.getInstance().eliminar(((SubCategoria) jlSubCategorias.getSelectedValue()).getId());
                    JOptionPane.showMessageDialog(null, "Registro eliminado");
                    agregarSubCategoriaLista();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "No se puede eliminar, Subcategoria esta siendo utilizada por uno o mas articulos");
                }
            }
            
        }else{
            JOptionPane.showMessageDialog(null, "Debe seleccionar una SubCategoria para eliminar");
        }   
    }
}