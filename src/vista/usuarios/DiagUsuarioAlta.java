/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ArticuloAlta.java
 *
 * Created on 12/10/2009, 14:29:17
 */
package vista.usuarios;

import entidades.usuario.Grupo;
import entidades.usuario.Usuario;
import facade.GrupoFacade;
import facade.UsuarioFacade;
import includes.Comunes;
import includes.SHA1;
import includes.SuperInternalFrame;
import java.awt.event.KeyEvent;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.*;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author carlos
 */
public class DiagUsuarioAlta extends javax.swing.JDialog{


    SHA1 sha1 = new SHA1();
    private String tipoOperacion;

    /** Creates new form ArticuloAlta */
 
    
    public DiagUsuarioAlta(java.awt.Frame parent, boolean modal, String tipoOperacion) {
        super(parent, modal);
        initComponents();
        this.tipoOperacion = tipoOperacion;
        inicializarComponentes();
    }


    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbAgregarArticuloNuevo = new javax.swing.JLabel();
        jXPanel6 = new org.jdesktop.swingx.JXPanel();
        lbNombreCompleto = new javax.swing.JLabel();
        btGuardar = new javax.swing.JButton();
        btSalir = new javax.swing.JButton();
        tfNombreCompleto = new javax.swing.JTextField();
        lbNombreUsuario = new javax.swing.JLabel();
        tfNombreUsuario = new javax.swing.JTextField();
        lbContrasena = new javax.swing.JLabel();
        passContrasena = new javax.swing.JPasswordField();
        cboGrupo = new javax.swing.JComboBox();
        lbGrupo = new javax.swing.JLabel();

        setTitle("Alta Usuario");

        lbAgregarArticuloNuevo.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        lbAgregarArticuloNuevo.setText("Agregar usuario nuevo");

        jXPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbNombreCompleto.setText("Nombre Completo");

        btGuardar.setText("Guardar");
        btGuardar.setEnabled(false);
        btGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGuardarActionPerformed(evt);
            }
        });
        btGuardar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btGuardarKeyPressed(evt);
            }
        });

        btSalir.setText("Salir");
        btSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalirActionPerformed(evt);
            }
        });
        btSalir.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btSalirKeyPressed(evt);
            }
        });

        tfNombreCompleto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfNombreCompletoKeyReleased(evt);
            }
        });

        lbNombreUsuario.setText("Nombre de Usuario");

        lbContrasena.setText("Contraseña");

        lbGrupo.setText("Grupo");

        javax.swing.GroupLayout jXPanel6Layout = new javax.swing.GroupLayout(jXPanel6);
        jXPanel6.setLayout(jXPanel6Layout);
        jXPanel6Layout.setHorizontalGroup(
            jXPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jXPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jXPanel6Layout.createSequentialGroup()
                        .addGroup(jXPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jXPanel6Layout.createSequentialGroup()
                                .addGroup(jXPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lbContrasena)
                                    .addComponent(lbNombreCompleto)
                                    .addComponent(lbNombreUsuario))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jXPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfNombreCompleto, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
                                    .addComponent(tfNombreUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
                                    .addComponent(passContrasena, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)))
                            .addGroup(jXPanel6Layout.createSequentialGroup()
                                .addComponent(btGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btSalir, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jXPanel6Layout.createSequentialGroup()
                        .addComponent(lbGrupo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45))))
        );
        jXPanel6Layout.setVerticalGroup(
            jXPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jXPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfNombreCompleto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbNombreCompleto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jXPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbNombreUsuario)
                    .addComponent(tfNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jXPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbContrasena)
                    .addComponent(passContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jXPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbGrupo)
                    .addComponent(cboGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addGroup(jXPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btGuardar)
                    .addComponent(btSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jXPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbAgregarArticuloNuevo))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbAgregarArticuloNuevo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jXPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btSalirKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btSalirKeyPressed
        if ((evt.getKeyCode() == KeyEvent.VK_UP)) {
            if (btGuardar.isEnabled()) {
                btGuardar.requestFocus();
            } else {
                tfNombreCompleto.requestFocus();
            }
        } else if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            this.dispose();
        }
}//GEN-LAST:event_btSalirKeyPressed

    private void btSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalirActionPerformed
        this.dispose();
}//GEN-LAST:event_btSalirActionPerformed

    private void btGuardarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btGuardarKeyPressed
        if ((evt.getKeyCode() == KeyEvent.VK_DOWN)) {
            btSalir.requestFocus();
        } else if ((evt.getKeyCode() == KeyEvent.VK_UP)) {
            tfNombreCompleto.requestFocus();
        } else if ((evt.getKeyCode() == KeyEvent.VK_ENTER)) {
            altaUsuario();
        }
}//GEN-LAST:event_btGuardarKeyPressed

    private void btGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGuardarActionPerformed
        altaUsuario();
        
}//GEN-LAST:event_btGuardarActionPerformed

    private void tfNombreCompletoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfNombreCompletoKeyReleased
        btGuardar.setEnabled(true);
    }//GEN-LAST:event_tfNombreCompletoKeyReleased
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btGuardar;
    private javax.swing.JButton btSalir;
    private javax.swing.JComboBox cboGrupo;
    private org.jdesktop.swingx.JXPanel jXPanel6;
    private javax.swing.JLabel lbAgregarArticuloNuevo;
    private javax.swing.JLabel lbContrasena;
    private javax.swing.JLabel lbGrupo;
    private javax.swing.JLabel lbNombreCompleto;
    private javax.swing.JLabel lbNombreUsuario;
    private javax.swing.JPasswordField passContrasena;
    private javax.swing.JTextField tfNombreCompleto;
    private javax.swing.JTextField tfNombreUsuario;
    // End of variables declaration//GEN-END:variables

    private void inicializarComponentes() {
        tfNombreCompleto.requestFocus();
        cargarComboBoxGrupo();
    }
//Alta usuarios users 
    public void altaUsuario() {
        if(validarUsuario()){
        try {
            Usuario usuario = new Usuario();
            //UsuarioFacade usuarioFacade = new UsuarioFacade();
            usuario.setNombreCompleto(tfNombreCompleto.getText());
            usuario.setNombreUsuario(tfNombreUsuario.getText());
            usuario.setContrasena(new String(passContrasena.getPassword()));
            usuario.setContrasena(sha1.getHash(usuario.getContrasena()));
            usuario.setGrupo((Grupo) cboGrupo.getSelectedItem());
            UsuarioFacade.getInstance().alta(usuario);
            limpiarTextFields();
            tfNombreCompleto.requestFocus();
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(DiagUsuarioAlta.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }

    public void limpiarTextFields() {
        tfNombreCompleto.setText("");
        tfNombreUsuario.setText("");
        passContrasena.setText("");
    }

    public void cerrarVentana() {
        this.dispose();
    }

    public void cargarComboBoxGrupo() {
           Comunes.cargarJCombo(cboGrupo, GrupoFacade.getInstance().listarGrupos());
    }

    private boolean validarUsuario() {
       
        boolean flag = false;
        if (tfNombreCompleto.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe ingresar el nombre Completo");
            flag = false;
        } else if (tfNombreUsuario.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe ingresar el nombre de usuario");
            flag = false;
        } else if (passContrasena.getPassword().length == 0) {
            JOptionPane.showMessageDialog(null, "Debe ingresar el Password");
            flag = false;
        } 
        else if (UsuarioFacade.getInstance().buscarExisteUsuario(tfNombreUsuario.getText())) {
            JOptionPane.showMessageDialog(null, "Usuario Existente");
            flag = false;
        } else {
            flag = true;
        }
        return flag;
    }
    

}