/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.Caja;

import entidades.Sucursal;
import entidades.articulo.Articulo;
import entidades.caja.CobranzaCtaCte;
import entidades.caja.CuentaCorriente;
import entidades.caja.CuponTarjeta;
import entidades.caja.MovimientoCaja;
import entidades.caja.PlanTarjeta;
import entidades.caja.TarjetaDeCredito;
import entidades.cliente.Cliente;
import entidades.usuario.Usuario;
import facade.ClienteFacade;
import facade.CuentaCorrienteFacade;
import facade.CuponTarjetaFacade;
import facade.MovimientoCajaFacade;
import facade.PlanTarjetaFacade;
import facade.SubCategoriaFacade;
import facade.TarjetaDeCreditoFacade;
import facade.UnidadMedidaFacade;
import includes.Comunes;
import java.awt.HeadlessException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author vouilloz
 */
public class DiagAltaCobranza extends javax.swing.JDialog {

    private String tipoOperacion;
    private Cliente client;
    private CobranzaCtaCte cobranza;
    //EN LA SIGUIENTE LISTA SE GUARDAN LAS VENTAS CUENTA CORRIENTE CON SALDO
    private List<CuentaCorriente> listaVentasCuentaCorriente = new ArrayList<CuentaCorriente>();
    //EN LA SIGIENTE LISTA GUARDAMOS LAS COBRANZAS CUENTA CORRIENTE CON SALDO
    private List<CobranzaCtaCte> listaCobranzaCtaCte = new ArrayList<CobranzaCtaCte>();
    //GUARDAMOS LA LISTA CON LAS CONBRANZAS REALIZADAS CON TARJETA DE CREDITO
    private List<CuponTarjeta> listaCobranzaCuponesTarjetas =new ArrayList<>();
    //ACUMULADOR TOTAL MONTO COBRANZA
    private Usuario usuario;
    private Sucursal sucursal;

    /**
     * Creates new form DiagPlanTarjeta
     */
    public DiagAltaCobranza(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        inicializar();
    }

    public DiagAltaCobranza(java.awt.Frame parent, boolean modal, String tipoOperacion, Cliente cliente, Usuario usuario, Sucursal sucursal) {
        super(parent, modal);
        initComponents();
        //    this.planTarjeta = plan;
        this.tipoOperacion = tipoOperacion;
        client = cliente;
        this.usuario = usuario;
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
        btnTarjeta = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        tfMonto = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tfNroRecibo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        taObservaciones = new javax.swing.JTextArea();
        btnEfectivo = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(org.openide.util.NbBundle.getMessage(DiagAltaCobranza.class, "DiagAltaCobranza.jPanel1.border.title"))); // NOI18N

        btnTarjeta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/accept.png"))); // NOI18N
        btnTarjeta.setText(org.openide.util.NbBundle.getMessage(DiagAltaCobranza.class, "DiagAltaCobranza.btnTarjeta.text")); // NOI18N
        btnTarjeta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTarjetaActionPerformed(evt);
            }
        });

        jLabel2.setText(org.openide.util.NbBundle.getMessage(DiagAltaCobranza.class, "DiagAltaCobranza.jLabel2.text")); // NOI18N

        tfMonto.setText(org.openide.util.NbBundle.getMessage(DiagAltaCobranza.class, "DiagAltaCobranza.tfMonto.text")); // NOI18N
        tfMonto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfMontoKeyTyped(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText(org.openide.util.NbBundle.getMessage(DiagAltaCobranza.class, "DiagAltaCobranza.jLabel1.text")); // NOI18N

        jLabel3.setText(org.openide.util.NbBundle.getMessage(DiagAltaCobranza.class, "DiagAltaCobranza.jLabel3.text")); // NOI18N

        tfNroRecibo.setText(org.openide.util.NbBundle.getMessage(DiagAltaCobranza.class, "DiagAltaCobranza.tfNroRecibo.text")); // NOI18N
        tfNroRecibo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfNroReciboKeyTyped(evt);
            }
        });

        jLabel4.setText(org.openide.util.NbBundle.getMessage(DiagAltaCobranza.class, "DiagAltaCobranza.jLabel4.text")); // NOI18N

        taObservaciones.setColumns(20);
        taObservaciones.setRows(5);
        jScrollPane1.setViewportView(taObservaciones);

        btnEfectivo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/accept.png"))); // NOI18N
        btnEfectivo.setText(org.openide.util.NbBundle.getMessage(DiagAltaCobranza.class, "DiagAltaCobranza.btnEfectivo.text")); // NOI18N
        btnEfectivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEfectivoActionPerformed(evt);
            }
        });

        jLabel5.setText(org.openide.util.NbBundle.getMessage(DiagAltaCobranza.class, "DiagAltaCobranza.jLabel5.text")); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(tfNroRecibo, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(tfMonto, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnEfectivo, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnTarjeta, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addGap(9, 9, 9)
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 52, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfMonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tfNroRecibo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTarjeta, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEfectivo, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTarjetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTarjetaActionPerformed
        pagarConTarjeta();
    }//GEN-LAST:event_btnTarjetaActionPerformed

    private void tfMontoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfMontoKeyTyped
        // TODO add your handling code here:
        Comunes.soloNumeros(tfMonto, evt);
    }//GEN-LAST:event_tfMontoKeyTyped

    private void tfNroReciboKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfNroReciboKeyTyped
        // TODO add your handling code here:
        Comunes.soloNumeros(tfNroRecibo, evt);
    }//GEN-LAST:event_tfNroReciboKeyTyped

    private void btnEfectivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEfectivoActionPerformed
        aceptar();
    }//GEN-LAST:event_btnEfectivoActionPerformed

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
            java.util.logging.Logger.getLogger(DiagAltaCobranza.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DiagAltaCobranza.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DiagAltaCobranza.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DiagAltaCobranza.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DiagAltaCobranza dialog = new DiagAltaCobranza(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnEfectivo;
    private javax.swing.JButton btnTarjeta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea taObservaciones;
    private javax.swing.JTextField tfMonto;
    private javax.swing.JTextField tfNroRecibo;
    // End of variables declaration//GEN-END:variables

    private void inicializarComponentes() {
        this.setTitle("Alta Cobranza");
        jLabel1.setText(client.toString());
    }

    private void cargarDatosPlan() {
        try {
            //         tfDescripcion.setText(planTarjeta.getDescripcion());
        } catch (Exception e) {

        }
        try {
            //          tfCoeficiente.setText(String.valueOf(planTarjeta.getCoeficiente()));
        } catch (Exception e) {

        }
        try {
            //          cbTarjeta.setSelectedItem(planTarjeta.getTarjetaDeCredito());
        } catch (Exception e) {

        }
    }

    private void aceptar() {
        if (tipoOperacion.equals("Alta")) {
            if (validarCampos()) {
                try {
                    //CARGA DEL OBJETO COBRANZA
                    cobranza = new CobranzaCtaCte();
                    //cobranza.setImporte(BigDecimal.valueOf(Double.valueOf(tfMonto.getText())));
                    BigDecimal montoCobranzaTotal = new BigDecimal(BigInteger.ZERO);

                    montoCobranzaTotal = montoCobranzaTotal.add(new BigDecimal(tfMonto.getText()));
                    cobranza.setFecha(Comunes.obtenerFechaActualDesdeDB());
                    cobranza.setCliente(client);
                    cobranza.setImporte(BigDecimal.valueOf(Double.valueOf(tfMonto.getText())));
                    cobranza.setNumero(Integer.valueOf(tfNroRecibo.getText().trim()));
                    cobranza.setObservaciones(taObservaciones.getText());
                    cobranza.setUsuario(usuario);
                    cobranza.setSucursal(sucursal);
                    //JOptionPane.showMessageDialog(null, "montoCobranzaTotal :" + montoCobranzaTotal);
                    //OBTENER LISTA DE LAS VENTAS CUENTA CORRIENTE ENTIDAD MOVIMIENTOCAJA_CUENTA CORRIENTE
                    listaVentasCuentaCorriente = CuentaCorrienteFacade.getInstance().getCuentasCCliente(client);
                    //System.out.println("lista venta CC con saldo"+listaVentasCuentaCorriente);
                    //OBTENER LISTA COBRANZAS 
                    listaCobranzaCtaCte = MovimientoCajaFacade.getInstance().getCobranzas(client);
                    //System.out.println("lista cobranza saldo segun cliente" + listaCobranzaCtaCte);

                    for (CobranzaCtaCte ccc : listaCobranzaCtaCte) {
                        montoCobranzaTotal = montoCobranzaTotal.add(ccc.getImporte());
                        ccc.setSaldoCobranza(BigDecimal.valueOf(0.00));
                        MovimientoCajaFacade.getInstance().modificar(ccc);
                    }

                    for (CuentaCorriente cc : listaVentasCuentaCorriente) {

                        //create int object
                        int res;

                        res = montoCobranzaTotal.compareTo(cc.getImporteCtaCte()); // Comaparamos el acumulador totalCobranzaTotal con el saldo de la venta q se esta leyenedo

                        //Cobranza total = importe de la cc
                        if (res == 0) {
                            cc.setSaldo(new BigDecimal("0.00"));
                            montoCobranzaTotal = new BigDecimal("0.00");
                            CuentaCorrienteFacade.getInstance().modificar(cc);
                        } //Cobranza total > importe de la cc 
                        else if (res == 1) {
                            montoCobranzaTotal = montoCobranzaTotal.subtract(cc.getImporteCtaCte());
                            cc.setSaldo(new BigDecimal("0.00"));
                            CuentaCorrienteFacade.getInstance().modificar(cc);

                        } //CObranza Total < importe de la cc
                        else if (res == -1) {
                            cc.setSaldo(cc.getImporteCtaCte().subtract(montoCobranzaTotal));
                            montoCobranzaTotal = cc.getSaldo();
                            CuentaCorrienteFacade.getInstance().modificar(cc);

                        }

                    }
                    cobranza.setSaldoCobranza(montoCobranzaTotal);
                    //ALTA DE LA COBRANZA
                    MovimientoCajaFacade.getInstance().alta(cobranza);

                    JOptionPane.showMessageDialog(this, "Cobranza Realizada!");
                    this.dispose();
                } catch (Exception e) {
                }
            }

//        } else if (tipoOperacion.equals("Modificación")) {
//            if (validarCampos()) {
//                //              planTarjeta.setDescripcion(tfDescripcion.getText().toUpperCase());
//                //              planTarjeta.setCoeficiente(new BigDecimal(tfCoeficiente.getText()));
//                //              planTarjeta.setTarjetaDeCredito((TarjetaDeCredito)cbTarjeta.getSelectedItem());
//                //             PlanTarjetaFacade.getInstance().modificar(planTarjeta);
//                JOptionPane.showMessageDialog(this, "Plan Modificado!");
//                this.dispose();
//
//            }
        }

    }

    private boolean validarCampos() {
        //boolean flag=Boolean.TRUE;
        if (tfMonto.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe Especificar un Monto", "Mensaje", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (tfNroRecibo.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe especificar el Nro de Recibo", "Mensaje", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (!Comunes.validarInteger(tfNroRecibo.getText())) {
            JOptionPane.showMessageDialog(this, "Debe ingresar un número en el Nro de Recibo", "Mensaje", JOptionPane.ERROR_MESSAGE);
            tfNroRecibo.requestFocus();
            return false;
        }

//        if (MovimientoCajaFacade.getInstance().existeNroReciboCobranza(Integer.valueOf(tfNroRecibo.getText().trim()))) {
//            JOptionPane.showMessageDialog(null, "Numero de recibo Existente");
//            tfNroRecibo.grabFocus();
//            return false;
//        }
        return true;
    }

    private void pruebaAlta() {
        CobranzaCtaCte c = new CobranzaCtaCte();
        //c.setCliente(ClienteFacade.getInstance().buscar();
    }

    private void inicializar() {
        //Cargar lista ordenada por fecha (antiguas primero)con ventas cuenta corriente donde saldo sea <> 0

        //iniciar bucle recorrido de lista
        //si monto cobranza > saldo venta cuenta corriente
        //si monto cobranza = saldo venta cuenta corriente
        //si monto cobranza < saldo venta cuenta corriente
        btnTarjeta.setVisible(false);
    }

    private void pagarConTarjeta() {
        if (tipoOperacion.equals("Alta")) {
            if (validarCampos()) {
                try {
                    diagCobroTarjetaCuentaC cobroTarjetaCuentaC = new diagCobroTarjetaCuentaC(null, true, new BigDecimal(tfMonto.getText()));
                    cobroTarjetaCuentaC.setLocation(Comunes.centrarDialog(cobroTarjetaCuentaC));
                    cobroTarjetaCuentaC.setVisible(true);
                    if (cobroTarjetaCuentaC.getCuponTarjeta() != null) {
                        cobroTarjetaCuentaC.getCuponTarjeta().setCliente(client);
                        cobroTarjetaCuentaC.getCuponTarjeta().setFecha(Comunes.obtenerFechaActualDesdeDB());
                        CuponTarjetaFacade.getInstance().alta(cobroTarjetaCuentaC.getCuponTarjeta());

                        //CARGA DEL OBJETO COBRANZA
                        cobranza = new CobranzaCtaCte();
                        //cobranza.setImporte(BigDecimal.valueOf(Double.valueOf(tfMonto.getText())));
                        BigDecimal montoCobranzaTotal = new BigDecimal(BigInteger.ZERO);

                        montoCobranzaTotal = montoCobranzaTotal.add(new BigDecimal(tfMonto.getText()));
                        cobranza.setFecha(Comunes.obtenerFechaActualDesdeDB());
                        cobranza.setCliente(client);
                        cobranza.setImporte(BigDecimal.valueOf(Double.valueOf(tfMonto.getText())));
                        cobranza.setNumero(Integer.valueOf(tfNroRecibo.getText().trim()));
                        cobranza.setObservaciones(taObservaciones.getText());
                        cobranza.setUsuario(usuario);
                        cobranza.setSucursal(sucursal);
                        //JOptionPane.showMessageDialog(null, "montoCobranzaTotal :" + montoCobranzaTotal);
                        //OBTENER LISTA DE LAS VENTAS CUENTA CORRIENTE ENTIDAD MOVIMIENTOCAJA_CUENTA CORRIENTE
                        listaVentasCuentaCorriente = CuentaCorrienteFacade.getInstance().getCuentasCCliente(client);
                        //System.out.println("lista venta CC con saldo"+listaVentasCuenta   Corriente);
                        //OBTENER LISTA COBRANZAS 
                        listaCobranzaCtaCte = MovimientoCajaFacade.getInstance().getCobranzas(client);
                        //System.out.println("lista cobranza saldo segun cliente" + listaCobranzaCtaCte);
                        
                        listaCobranzaCuponesTarjetas = CuponTarjetaFacade.getInstance().listarCuponesTarjetaCliente(client);

                        for (CobranzaCtaCte ccc : listaCobranzaCtaCte) {
                            montoCobranzaTotal = montoCobranzaTotal.add(ccc.getImporte());
                            ccc.setSaldoCobranza(BigDecimal.valueOf(0.00));
                            MovimientoCajaFacade.getInstance().modificar(ccc);
                        }
                        for (CuponTarjeta cuponTarjeta :listaCobranzaCuponesTarjetas){
                            montoCobranzaTotal = montoCobranzaTotal.add(cuponTarjeta.getImporteCuponConRecargo());
                        }

                        for (CuentaCorriente cc : listaVentasCuentaCorriente) {

                            //create int object
                            int res;

                            res = montoCobranzaTotal.compareTo(cc.getImporteCtaCte()); // Comaparamos el acumulador totalCobranzaTotal con el saldo de la venta q se esta leyenedo

                            //Cobranza total = importe de la cc
                            if (res == 0) {
                                cc.setSaldo(new BigDecimal("0.00"));
                                montoCobranzaTotal = new BigDecimal("0.00");
                                CuentaCorrienteFacade.getInstance().modificar(cc);
                            } //Cobranza total > importe de la cc 
                            else if (res == 1) {
                                montoCobranzaTotal = montoCobranzaTotal.subtract(cc.getImporteCtaCte());
                                cc.setSaldo(new BigDecimal("0.00"));
                                CuentaCorrienteFacade.getInstance().modificar(cc);

                            } //CObranza Total < importe de la cc
                            else if (res == -1) {
                                cc.setSaldo(cc.getImporteCtaCte().subtract(montoCobranzaTotal));
                                montoCobranzaTotal = cc.getSaldo();
                                CuentaCorrienteFacade.getInstance().modificar(cc);

                            }

                        }
                        cobranza.setSaldoCobranza(montoCobranzaTotal);
                        //ALTA DE LA COBRANZA
                        MovimientoCajaFacade.getInstance().alta(cobranza);

                        JOptionPane.showMessageDialog(this, "Cobranza Realizada!");
                        this.dispose();
                    }
                } catch (Exception e) {

                }
            }
        }

    }
}