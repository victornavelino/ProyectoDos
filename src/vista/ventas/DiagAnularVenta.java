/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.ventas;

import entidades.venta.Venta;
import facade.EntregaFacade;
import facade.VentaFacade;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author vouilloz
 */
public class DiagAnularVenta extends javax.swing.JDialog {

    /**
     * Creates new form DiagAnularVenta
     */
    public DiagAnularVenta(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        buscarUltimaVenta();
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
        jLabel1 = new javax.swing.JLabel();
        tfNumeroTicket = new javax.swing.JTextField();
        btnAnular = new javax.swing.JButton();
        btnSalirAnularVenta = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(org.openide.util.NbBundle.getMessage(DiagAnularVenta.class, "DiagAnularVenta.jPanel1.border.title"))); // NOI18N

        jLabel1.setText(org.openide.util.NbBundle.getMessage(DiagAnularVenta.class, "DiagAnularVenta.jLabel1.text")); // NOI18N

        tfNumeroTicket.setText(org.openide.util.NbBundle.getMessage(DiagAnularVenta.class, "DiagAnularVenta.tfNumeroTicket.text")); // NOI18N

        btnAnular.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/delete.png"))); // NOI18N
        btnAnular.setText(org.openide.util.NbBundle.getMessage(DiagAnularVenta.class, "DiagAnularVenta.btnAnular.text")); // NOI18N
        btnAnular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnularActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(tfNumeroTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnAnular, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(173, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfNumeroTicket, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAnular))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        btnSalirAnularVenta.setText(org.openide.util.NbBundle.getMessage(DiagAnularVenta.class, "DiagAnularVenta.btnSalirAnularVenta.text")); // NOI18N
        btnSalirAnularVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirAnularVentaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(188, 188, 188)
                .addComponent(btnSalirAnularVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(btnSalirAnularVenta)
                .addGap(33, 33, 33))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirAnularVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirAnularVentaActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirAnularVentaActionPerformed

    private void btnAnularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnularActionPerformed
        if (!tfNumeroTicket.getText().isEmpty()) {
            anularVenta();
            this.dispose();
        }else{
            JOptionPane.showMessageDialog(null, "Debe escribir un numero de ticket");
            tfNumeroTicket.requestFocus();
        }

    }//GEN-LAST:event_btnAnularActionPerformed

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
            java.util.logging.Logger.getLogger(DiagAnularVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DiagAnularVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DiagAnularVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DiagAnularVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DiagAnularVenta dialog = new DiagAnularVenta(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnAnular;
    private javax.swing.JButton btnSalirAnularVenta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField tfNumeroTicket;
    // End of variables declaration//GEN-END:variables

    private void buscarUltimaVenta() {
        try {

            List<Object> listaVentas = VentaFacade.getInstance().listaVentasDescendente();
            int ticket;
            ticket = (int) listaVentas.get(0);
            tfNumeroTicket.setText(String.valueOf(ticket));
        } catch (Exception e) {
            System.out.println("salio catch");

        }

    }

    private void anularVenta() {
        if (VentaFacade.getInstance().getVentaNumeroTicket(tfNumeroTicket.getText()) != null) {
            Venta ven = VentaFacade.getInstance().getVentaNumeroTicket(tfNumeroTicket.getText());
            try {
                if (ven.getCierreVentas() == null && ven.getCobroVenta()==null) {
                    ven.setAnulado(true);
                    if(VentaFacade.getInstance().esVentaEntrega(ven)){
                        EntregaFacade.getInstance().eliminar(EntregaFacade.getInstance().getEntrega(ven).getId());
                    }
                    VentaFacade.getInstance().modificar(ven);
                    JOptionPane.showMessageDialog(null, "Ticket Anulado");
                    tfNumeroTicket.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "El ticket no puede ser eliminado, ya ha sido cerrado o cobrado ");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error tratando de eliminar ticket");
            }
        }

    }
}
