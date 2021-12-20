/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.Caja;

import Recursos.Soap;
import entidades.Sucursal;
import entidades.caja.CobroVenta;
import entidades.caja.CuentaCorriente;
import entidades.caja.CuponTarjeta;
import entidades.cliente.Persona;
import entidades.persona.Telefono;
import entidades.venta.Venta;
import facade.ClienteFacade;
import facade.CuentaCorrienteFacade;
import facade.CuponTarjetaFacade;
import facade.MovimientoCajaFacade;
import facade.VentaFacade;
import includes.Comunes;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author nago
 */
public class DiagModificacionCobroVentas extends javax.swing.JDialog {

    private Sucursal sucursal;
    private Venta venta;
    List<CuponTarjeta> listaCuponesTarjeta = new ArrayList<>();

    /**
     * Creates new form DiagAnularCobroVentas
     */
    public DiagModificacionCobroVentas(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public DiagModificacionCobroVentas(java.awt.Frame parent, boolean modal, Sucursal sucursal) {
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnBuscarTicket = new javax.swing.JButton();
        tfResultadoBusqueda = new javax.swing.JTextField();
        tfNroTicket = new javax.swing.JTextField();
        btnAnularCobro = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(org.openide.util.NbBundle.getMessage(DiagModificacionCobroVentas.class, "DiagModificacionCobroVentas.jPanel1.border.border.title")))); // NOI18N

        jLabel1.setText(org.openide.util.NbBundle.getMessage(DiagModificacionCobroVentas.class, "DiagModificacionCobroVentas.jLabel1.text")); // NOI18N

        btnBuscarTicket.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/buscar2.png"))); // NOI18N
        btnBuscarTicket.setText(org.openide.util.NbBundle.getMessage(DiagModificacionCobroVentas.class, "DiagModificacionCobroVentas.btnBuscarTicket.text")); // NOI18N
        btnBuscarTicket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarTicketActionPerformed(evt);
            }
        });

        tfResultadoBusqueda.setText(org.openide.util.NbBundle.getMessage(DiagModificacionCobroVentas.class, "DiagModificacionCobroVentas.tfResultadoBusqueda.text")); // NOI18N

        tfNroTicket.setText(org.openide.util.NbBundle.getMessage(DiagModificacionCobroVentas.class, "DiagModificacionCobroVentas.tfNroTicket.text")); // NOI18N
        tfNroTicket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNroTicketActionPerformed(evt);
            }
        });
        tfNroTicket.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfNroTicketKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel1)
                .addGap(9, 9, 9)
                .addComponent(tfNroTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBuscarTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tfResultadoBusqueda))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btnBuscarTicket)
                    .addComponent(tfNroTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addComponent(tfResultadoBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(83, Short.MAX_VALUE))
        );

        btnAnularCobro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/aceptar.png"))); // NOI18N
        btnAnularCobro.setText(org.openide.util.NbBundle.getMessage(DiagModificacionCobroVentas.class, "DiagModificacionCobroVentas.btnAnularCobro.text")); // NOI18N
        btnAnularCobro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnularCobroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAnularCobro, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(122, 122, 122))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAnularCobro)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarTicketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarTicketActionPerformed
        buscarTicketCobrado();


    }//GEN-LAST:event_btnBuscarTicketActionPerformed

    private void tfNroTicketKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfNroTicketKeyTyped
        Comunes.soloNumerosSinComa(tfNroTicket, evt);
    }//GEN-LAST:event_tfNroTicketKeyTyped

    private void btnAnularCobroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnularCobroActionPerformed
        aceptar();
    }//GEN-LAST:event_btnAnularCobroActionPerformed

    private void tfNroTicketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNroTicketActionPerformed
        buscarTicketCobrado();
    }//GEN-LAST:event_tfNroTicketActionPerformed

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
            java.util.logging.Logger.getLogger(DiagModificacionCobroVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DiagModificacionCobroVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DiagModificacionCobroVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DiagModificacionCobroVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DiagModificacionCobroVentas dialog = new DiagModificacionCobroVentas(new javax.swing.JFrame(), true, new Sucursal());
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
    private javax.swing.JButton btnAnularCobro;
    private javax.swing.JButton btnBuscarTicket;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField tfNroTicket;
    private javax.swing.JTextField tfResultadoBusqueda;
    // End of variables declaration//GEN-END:variables

    private void buscarTicketCobrado() {
        tfResultadoBusqueda.setText("");
        venta = VentaFacade.getInstance().getTicketCobradoNoCerradoCaja(tfNroTicket.getText(), sucursal);
        if (venta != null) {
            tfResultadoBusqueda.setText(venta.getCliente() + ", monto: " + venta.getMonto());
            btnAnularCobro.requestFocus();
        } else {
            JOptionPane.showMessageDialog(null, "El cobro de este ticket ha sido cerrado con la caja");
        }

    }

    private void inicializarComponentes() {
        tfResultadoBusqueda.setEditable(false);

    }

    private void aceptar() {
        if (venta != null) {
            int reply = JOptionPane.showConfirmDialog(null, "Esta seguro de anular cobro de ticket", "Realizar anulacion", JOptionPane.YES_NO_OPTION);
            if (reply == JOptionPane.YES_OPTION) {
                CobroVenta cobroVenta = venta.getCobroVenta();
                //CONSUMIMOS WEB SERVICE 
                if (ClienteFacade.getInstance().getPersonaXDni(cobroVenta.getVenta().getDniCliente()).isFidelizado()) {
                    enviarVentaSOAP(cobroVenta);
                }
                venta.setCobroVenta(null);
                VentaFacade.getInstance().modificar(venta);
                MovimientoCajaFacade.getInstance().eliminar(cobroVenta.getId());

                CuentaCorriente cc = CuentaCorrienteFacade.getInstance().getCuentaCorrienteTicket(venta);
                if (cc != null) {
                    CuentaCorrienteFacade.getInstance().eliminar(cc.getId());
                }
                listaCuponesTarjeta = CuponTarjetaFacade.getInstance().listarCuponesTarjetaVenta(venta);
                for (CuponTarjeta cuponTarjeta : listaCuponesTarjeta) {
                    CuponTarjetaFacade.getInstance().eliminar(cuponTarjeta.getId());
                }
                JOptionPane.showMessageDialog(null, "cobro eliminado");
                this.dispose();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un ticket para anular su pago");
        }
    }

    private void enviarVentaSOAP(CobroVenta cobroVenta) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("HGM678leR54G99FFjv");
        stringBuilder.append("|");
        //DNI
        try {

            stringBuilder.append(Comunes.quitarPuntosDNI(cobroVenta.getVenta().getDniCliente()));
            stringBuilder.append("|");
        } catch (Exception e) {
            stringBuilder.append("|");
        }
        //NOMBRE CLIENTE
        try {
            stringBuilder.append(cobroVenta.getVenta().getCliente());
            stringBuilder.append("|");
        } catch (Exception e) {
            stringBuilder.append("|");
        }
        //TELEFONOS
        String celular = "0";
        String fijo = "0";

        if (!ClienteFacade.getInstance().getPersonaXDni(cobroVenta.getVenta().getDniCliente()).getTelefonos().isEmpty()) {
            List<Telefono> listaTelefonos = ClienteFacade.getInstance().getPersonaXDni(cobroVenta.getVenta().getDniCliente()).getTelefonos();
            for (Telefono telefono : listaTelefonos) {
                if (telefono.getTipoTelefono().getDescripcion().contains("CELULAR")) {
                    celular = telefono.getNumero().trim();
                }
                if (telefono.getTipoTelefono().getDescripcion().contains("FIJO")) {
                    fijo = telefono.getNumero().trim();
                }
            }
            //celular
            stringBuilder.append(celular);
            stringBuilder.append("|");
            //fijo
            stringBuilder.append(fijo);
            stringBuilder.append("|");

        } else {
            //celular
            stringBuilder.append("0");
            stringBuilder.append("|");
            //fijo
            stringBuilder.append("0");
            stringBuilder.append("|");
        }

        //MAIL
        try {
            if (!ClienteFacade.getInstance().getPersonaXDni(cobroVenta.getVenta().getDniCliente()).getCorreosElectronicos().isEmpty()) {
                stringBuilder.append(ClienteFacade.getInstance().getPersonaXDni(cobroVenta.getVenta().getDniCliente()).getCorreosElectronicos().get(0));
                stringBuilder.append("|");
            } else {
                //stringBuilder.append("nose@nose.com");
                stringBuilder.append("|");
            }

        } catch (Exception e) {
            //stringBuilder.append("nose@nose.com");
            stringBuilder.append("|");
        }
        //MONTO
        try {
            stringBuilder.append("-");
            stringBuilder.append(cobroVenta.getVenta().getMonto());
            stringBuilder.append("|");
        } catch (Exception e) {
            stringBuilder.append("0");
            stringBuilder.append("|");
        }
        //COMPROBANTE
        try {
            stringBuilder.append(cobroVenta.getVenta().getNumeroTicket());
            stringBuilder.append("|");
        } catch (Exception e) {
            stringBuilder.append("0");
            stringBuilder.append("|");
        }
        //sucursal
        try {
            stringBuilder.append(cobroVenta.getVenta().getSucursal().getCodigo());
            stringBuilder.append("|");
        } catch (Exception e) {
            stringBuilder.append("0");
            stringBuilder.append("|");
        }
        //ID VENDEDOR
        try {
            stringBuilder.append(cobroVenta.getVenta().getUsuario().getId());
            stringBuilder.append("|");
        } catch (Exception e) {
            stringBuilder.append("0");
            stringBuilder.append("|");
        }
        //NOMBRE VENDEDOR
        try {
            stringBuilder.append(cobroVenta.getVenta().getUsuario().getNombreCompleto());
            stringBuilder.append("|");
        } catch (Exception e) {
            stringBuilder.append("NN");
            stringBuilder.append("|");
        }
        //FECHA NAC CLIENTE
        try {
            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
            if (ClienteFacade.getInstance().getPersonaXDni(cobroVenta.getVenta().getDniCliente()).getFechaNacimiento() != null) {
                stringBuilder.append(formatoFecha.format(ClienteFacade.getInstance().getPersonaXDni(cobroVenta.getVenta().getDniCliente()).getFechaNacimiento()));
                stringBuilder.append("|");
            } else {
                stringBuilder.append("01/01/2019");
                stringBuilder.append("|");
            }
        } catch (Exception e) {
            stringBuilder.append("01/01/2019");
            stringBuilder.append("|");
        }
        //SEXO CLIENTE
        try {
            if (ClienteFacade.getInstance().getPersonaXDni(cobroVenta.getVenta().getDniCliente()).getSexo() != null) {
                Persona persona = ClienteFacade.getInstance().getPersonaXDni(cobroVenta.getVenta().getDniCliente());
                if (persona.getSexo().getName().contains("MASCULINO")) {
                    stringBuilder.append("M");
                    stringBuilder.append("|");
                }
                if (persona.getSexo().getName().contains("FEMENINO")) {
                    stringBuilder.append("F");
                    stringBuilder.append("|");
                }
            } else {
                stringBuilder.append("N");
                stringBuilder.append("|");
                stringBuilder.append("N");
                stringBuilder.append("|");
            }
        } catch (Exception e) {
            stringBuilder.append("N");
            stringBuilder.append("|");
            stringBuilder.append("N");
            stringBuilder.append("|");
        }
        //FECHA VENTA
        try {
            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
            stringBuilder.append(formatoFecha.format(cobroVenta.getFecha()));
            stringBuilder.append("|");

        } catch (Exception e) {
            stringBuilder.append("01/01/2019");
            stringBuilder.append("|");
        }
        //NUMERO DE SOCIO DNI
        try {
            stringBuilder.append(cobroVenta.getVenta().getDniCliente());
        } catch (Exception e) {

        }
        //String strCadena = "HGM678leR54G99FFjv|30207103|Franco Zurita Perea|3834811718|414141|francozurita@gmail.com|5000|0|1|0|Franco Zurita|'14/4/1983|Masc|5/9/2019|1";
        String cadena = new String();
        //System.out.println("CADENA: " + stringBuilder.toString());
        Runnable r = new Soap(stringBuilder.toString(),cobroVenta);
        Thread t = new Thread(r);
        t.start();
    }
}