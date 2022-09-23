/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ArticuloAlta.java
 *
 * Created on 12/10/2009, 14:29:17
 */
package vista.sucursal;

import entidades.Sucursal;
import entidades.localidad.Departamento;
import entidades.localidad.Localidad;
import entidades.localidad.Provincia;
import entidades.persona.CorreoElectronico;
import entidades.persona.Domicilio;
import entidades.persona.Telefono;
import entidades.persona.TipoTelefono;
import facade.DepartamentoFacade;
import facade.LocalidadFacade;
import facade.ProvinciaFacade;
import facade.SucursalFacade;
import facade.TipoTelefonoFacade;
import includes.Comunes;
import includes.SuperInternalFrame;
import java.awt.HeadlessException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.apache.commons.validator.routines.BigIntegerValidator;
import vista.frPrincipal;

/**
 *
 * @author carlos
 */
public class DiagSucursalAlta extends javax.swing.JDialog {

    List<Telefono> telefonos = new ArrayList<>();
    List<CorreoElectronico> correosElectronicos = new ArrayList<>();

    private String tipoOperacion;

    public DiagSucursalAlta(java.awt.Frame parent, boolean modal, String tipoOperacion) {
        super(parent, modal);
        initComponents();
        this.tipoOperacion = tipoOperacion;
        inicializarComponentes();
    }

    /**
     * Creates new form ArticuloAlta
     */
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        tfCalle = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        tfNumero = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        cboLocalidades = new javax.swing.JComboBox();
        jLabel16 = new javax.swing.JLabel();
        cboDepartamentos = new javax.swing.JComboBox();
        jLabel17 = new javax.swing.JLabel();
        tfEntreCalles = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        tfReferencia = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        tfBarrio = new javax.swing.JTextField();
        cboProvincias = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        cboTiposTelefonos = new javax.swing.JComboBox();
        tfNumeroTelefono = new javax.swing.JTextField();
        btnAgregarTelefono = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jListTelefonos = new javax.swing.JList();
        btnEliminarTelefono = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        tfCorreoElectronico = new javax.swing.JTextField();
        btnAgregarCorreoElectronico = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jListCorreosElectronicos = new javax.swing.JList();
        btnEliminarCorreoElectronico = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        tfDescripcion = new javax.swing.JTextField();
        tfCodigo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setTitle("Alta Sucursal");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Domicilio"));

        jLabel5.setText("Calle");

        jLabel6.setText("Número");

        jLabel10.setText("Localidad");

        jLabel16.setText("Departamento");

        cboDepartamentos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboDepartamentosItemStateChanged(evt);
            }
        });

        jLabel17.setText("Entre Calles");

        jLabel18.setText("Referencia");

        jLabel19.setText("Barrio");

        cboProvincias.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboProvinciasItemStateChanged(evt);
            }
        });

        jLabel3.setText("Provincia");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel17)
                    .addComponent(jLabel18)
                    .addComponent(jLabel19)
                    .addComponent(jLabel16)
                    .addComponent(jLabel10)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cboDepartamentos, 0, 324, Short.MAX_VALUE)
                    .addComponent(tfCalle, javax.swing.GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE)
                    .addComponent(tfEntreCalles, javax.swing.GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE)
                    .addComponent(tfReferencia, javax.swing.GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE)
                    .addComponent(tfBarrio, javax.swing.GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE)
                    .addComponent(cboLocalidades, javax.swing.GroupLayout.Alignment.TRAILING, 0, 324, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(tfNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(cboProvincias, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tfCalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(tfNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(tfEntreCalles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(tfReferencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(tfBarrio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboProvincias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(cboDepartamentos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(cboLocalidades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/save.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/back.png"))); // NOI18N
        jButton2.setText("Salir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Teléfonos"));

        btnAgregarTelefono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/add.png"))); // NOI18N
        btnAgregarTelefono.setText("Agregar");
        btnAgregarTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarTelefonoActionPerformed(evt);
            }
        });

        jScrollPane3.setViewportView(jListTelefonos);

        btnEliminarTelefono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/delete.png"))); // NOI18N
        btnEliminarTelefono.setText("Eliminar");
        btnEliminarTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarTelefonoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane3, 0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(cboTiposTelefonos, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfNumeroTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEliminarTelefono, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAgregarTelefono, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboTiposTelefonos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfNumeroTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregarTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminarTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Correos Electrónicos"));

        btnAgregarCorreoElectronico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/add.png"))); // NOI18N
        btnAgregarCorreoElectronico.setText("Agregar");
        btnAgregarCorreoElectronico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarCorreoElectronicoActionPerformed(evt);
            }
        });

        jScrollPane2.setViewportView(jListCorreosElectronicos);

        btnEliminarCorreoElectronico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/delete.png"))); // NOI18N
        btnEliminarCorreoElectronico.setText("Eliminar");
        btnEliminarCorreoElectronico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarCorreoElectronicoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                    .addComponent(tfCorreoElectronico, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnAgregarCorreoElectronico, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                    .addComponent(btnEliminarCorreoElectronico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfCorreoElectronico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregarCorreoElectronico, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminarCorreoElectronico, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Sucursal"));

        jLabel2.setText("Codigo");

        jLabel1.setText("Descripcion");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 488, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(156, 156, 156)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cboDepartamentosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboDepartamentosItemStateChanged
        cargarLocalidades();
    }//GEN-LAST:event_cboDepartamentosItemStateChanged

    private void btnAgregarTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarTelefonoActionPerformed
        agregarTelefono();
    }//GEN-LAST:event_btnAgregarTelefonoActionPerformed

    private void btnEliminarTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarTelefonoActionPerformed
        eliminarTelefono();
    }//GEN-LAST:event_btnEliminarTelefonoActionPerformed

    private void btnAgregarCorreoElectronicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarCorreoElectronicoActionPerformed
        agregarCorreoElectronico();
    }//GEN-LAST:event_btnAgregarCorreoElectronicoActionPerformed

    private void btnEliminarCorreoElectronicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarCorreoElectronicoActionPerformed
        eliminarCorreoElectronico();
    }//GEN-LAST:event_btnEliminarCorreoElectronicoActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void cboProvinciasItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboProvinciasItemStateChanged
        cargarDepartamentos();
    }//GEN-LAST:event_cboProvinciasItemStateChanged

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        altaSucursal();
    }//GEN-LAST:event_btnGuardarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarCorreoElectronico;
    private javax.swing.JButton btnAgregarTelefono;
    private javax.swing.JButton btnEliminarCorreoElectronico;
    private javax.swing.JButton btnEliminarTelefono;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox cboDepartamentos;
    private javax.swing.JComboBox cboLocalidades;
    private javax.swing.JComboBox cboProvincias;
    private javax.swing.JComboBox cboTiposTelefonos;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JList jListCorreosElectronicos;
    private javax.swing.JList jListTelefonos;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField tfBarrio;
    private javax.swing.JTextField tfCalle;
    private javax.swing.JTextField tfCodigo;
    private javax.swing.JTextField tfCorreoElectronico;
    private javax.swing.JTextField tfDescripcion;
    private javax.swing.JTextField tfEntreCalles;
    private javax.swing.JTextField tfNumero;
    private javax.swing.JTextField tfNumeroTelefono;
    private javax.swing.JTextField tfReferencia;
    // End of variables declaration//GEN-END:variables

    private void inicializarComponentes() {
        tfDescripcion.requestFocus();
        Comunes.cargarJCombo(cboTiposTelefonos, TipoTelefonoFacade.getInstance().getTodos());
        cargarProvincias();
    }

    /*   public void altaSucursal() {
     try {
     Sucursal sucursal = new Sucursal();
     sucursal.setCodigo(tfCodigo.getText());
     sucursal.setNombre(tfDescripcion.getText());
     Domicilio domicilio = new Domicilio();
     domicilio.setCalle(tfCalle.getText());
     domicilio.setNumero(tfNumero.getText());
     domicilio.setEntreCalles(tfEntreCalles.getText());
     domicilio.setReferencia(tfReferencia.getText());
     domicilio.setBarrio(tfBarrio.getText());
     if(cboLocalidades.getSelectedIndex()!=-1){
     domicilio.setLocalidad((Localidad)cboLocalidades.getSelectedItem());}
     sucursal.setDomicilio(domicilio);
     limpiarTextFields();
     tfDescripcion.requestFocus();
     } catch (NoSuchAlgorithmException ex) {
     Logger.getLogger(frSucursalAlta.class.getName()).log(Level.SEVERE, null, ex);
     }
     }*/
    public void limpiarTextFields() {
        tfCodigo.setText("");
        tfDescripcion.setText("");
        tfCalle.setText("");
        tfNumero.setText("");
        tfEntreCalles.setText("");
        tfReferencia.setText("");
        tfBarrio.setText("");
    }

    public void cerrarVentana() {
        this.dispose();
    }

    private void agregarTelefono() {
        if (cboTiposTelefonos.getSelectedIndex() > -1) {
            if (BigIntegerValidator.getInstance().isValid(tfNumeroTelefono.getText())) {
                Telefono telefono = new Telefono();
                telefono.setNumero(tfNumeroTelefono.getText());
                telefono.setTipoTelefono((TipoTelefono) cboTiposTelefonos.getSelectedItem());
                telefonos.add(telefono);
                Comunes.cargarJList(jListTelefonos, telefonos);
                cboTiposTelefonos.setSelectedIndex(0);
                tfNumeroTelefono.setText("");
                tfNumeroTelefono.requestFocus();
            } else {
                JOptionPane.showMessageDialog(null, "Número de teléfono incorrecto", "Error", JOptionPane.ERROR_MESSAGE);
                tfNumeroTelefono.requestFocus();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe escoger un tipo de teléfono", "Error", JOptionPane.ERROR_MESSAGE);
            cboTiposTelefonos.requestFocus();
        }
    }

    private void eliminarTelefono() {
        if (jListTelefonos.getSelectedIndex() != -1) {
            telefonos.remove((Telefono) jListTelefonos.getSelectedValue());
            Comunes.cargarJList(jListTelefonos, telefonos);
        }
    }

    private void agregarCorreoElectronico() {
        if (Comunes.validarEmail(tfCorreoElectronico)) {
            CorreoElectronico correoElectronico = new CorreoElectronico();
            correoElectronico.setDireccion(tfCorreoElectronico.getText());
            correosElectronicos.add(correoElectronico);
            Comunes.cargarJList(jListCorreosElectronicos, correosElectronicos);
            tfCorreoElectronico.setText("");
            tfCorreoElectronico.requestFocus();
        } else {
            JOptionPane.showMessageDialog(null, "Formato Correo electrónico incorrecto", "Error", JOptionPane.ERROR_MESSAGE);
            tfCorreoElectronico.requestFocus();
        }
    }

    private void eliminarCorreoElectronico() {
        if (jListCorreosElectronicos.getSelectedIndex() != -1) {
            correosElectronicos.remove((CorreoElectronico) jListCorreosElectronicos.getSelectedValue());
            Comunes.cargarJList(jListCorreosElectronicos, correosElectronicos);
        }

    }

    private void cargarProvincias() {
        try {
            Comunes.cargarJComboConBlanco(cboProvincias, ProvinciaFacade.getInstance().listarTodosProvinciaOrdenados());
            cargarDepartamentos();
        } catch (java.lang.ClassCastException ex) {
        }
    }

    private void cargarDepartamentos() {
        System.out.println("entro cargar departamentos" + cboProvincias.getSelectedItem());
        try {
            Comunes.cargarJComboConBlanco(cboDepartamentos, DepartamentoFacade.getInstance().listarTodosDepartamentoOrdenados((Provincia) cboProvincias.getSelectedItem()));
            cargarLocalidades();
        } catch (java.lang.ClassCastException ex) {
        }
    }

    private void cargarLocalidades() {
        try {
            Comunes.cargarJComboConBlanco(cboLocalidades, LocalidadFacade.getInstance().listarTodosLocalidadOrdenados((Departamento) cboDepartamentos.getSelectedItem()));
        } catch (java.lang.ClassCastException ex) {
        }

    }

    private void altaSucursal() {
        if (validarSucursal()) {
            try {
                Sucursal sucursal = new Sucursal();
                sucursal.setCodigo(tfCodigo.getText().trim().toUpperCase());
                sucursal.setNombre(tfDescripcion.getText().toUpperCase());
                Domicilio domicilio = new Domicilio();
                domicilio.setCalle(tfCalle.getText());
                domicilio.setNumero(tfNumero.getText());
                domicilio.setEntreCalles(tfEntreCalles.getText());
                domicilio.setReferencia(tfReferencia.getText());
                domicilio.setBarrio(tfBarrio.getText());
                if (cboLocalidades.getSelectedIndex() != -1) {
                    domicilio.setLocalidad((Localidad) cboLocalidades.getSelectedItem());
                }
                sucursal.setDomicilio(domicilio);
                if (!telefonos.isEmpty()) {
                    sucursal.setTelefonos(telefonos);
                }
                if (!correosElectronicos.isEmpty()) {
                    sucursal.setCorreosElectronicos(correosElectronicos);
                }
                SucursalFacade.getInstance().alta(sucursal);
                JOptionPane.showMessageDialog(null, "La Sucursal se ha dado de alta");

                limpiarTextFields();
                reiniciarListas();
                tfDescripcion.requestFocus();
            } catch (HeadlessException e) {
                JOptionPane.showMessageDialog(null, "Error al crear la sucursal");
            }
        }

    }

    private void reiniciarListas() {
        telefonos = new ArrayList<>();
        Comunes.cargarJList(jListTelefonos, telefonos);
        correosElectronicos = new ArrayList<>();
        Comunes.cargarJList(jListCorreosElectronicos, correosElectronicos);
    }

    private boolean validarSucursal() {
        if(tfCodigo.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Debe escribir un codigo de sucursal","Mensaje",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if(tfDescripcion.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Debe escribir un nombre a la sucursal","Mensaje",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

}