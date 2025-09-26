package proyectoupn_grupo6.Vista;
import java.awt.Color;
import proyectoupn_grupo6.modelo.Usuario;
import proyectoupn_grupo6.util.Session;

public class PrincipalVista extends javax.swing.JFrame { 
    
    public PrincipalVista() {
        initComponents();
        establecerTitulo();
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setLocationRelativeTo(this);
        
    }

    private void establecerTitulo(){
        Usuario usuario = (Usuario) Session.get("USUARIO");
        this.setForeground(Color.ORANGE);
        String titulo = "LIBRERIA UNIVERSAL        :::       Usuario : " + usuario.getNombre()+" " + usuario.getApellido();
        this.setTitle(titulo);
        
    
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        menuConsultaPublicacion = new javax.swing.JMenuBar();
        itemVentas = new javax.swing.JMenu();
        itemsVenta = new javax.swing.JMenuItem();
        itemConsultaVentas = new javax.swing.JMenuItem();
        itemControl = new javax.swing.JMenuItem();
        mnMantenimiento = new javax.swing.JMenu();
        itmConsultaPublicacion = new javax.swing.JMenuItem();
        itmMantenimientoPublicacion = new javax.swing.JMenuItem();
        mnSalir = new javax.swing.JMenu();
        itemCerrarSesion = new javax.swing.JMenuItem();

        jMenuItem2.setText("jMenuItem2");

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 204));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(638, 638, 638)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(126, 126, 126)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(283, Short.MAX_VALUE))
        );

        itemVentas.setForeground(new java.awt.Color(204, 153, 0));
        itemVentas.setText("Ventas");

        itemsVenta.setBackground(new java.awt.Color(153, 102, 0));
        itemsVenta.setForeground(new java.awt.Color(153, 102, 0));
        itemsVenta.setText("Ventas");
        itemsVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemsVentaActionPerformed(evt);
            }
        });
        itemVentas.add(itemsVenta);

        itemConsultaVentas.setBackground(new java.awt.Color(153, 102, 0));
        itemConsultaVentas.setForeground(new java.awt.Color(153, 102, 0));
        itemConsultaVentas.setText("Consulta Ventas");
        itemConsultaVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemConsultaVentasActionPerformed(evt);
            }
        });
        itemVentas.add(itemConsultaVentas);

        itemControl.setBackground(new java.awt.Color(153, 102, 0));
        itemControl.setForeground(new java.awt.Color(153, 102, 0));
        itemControl.setText("Control");
        itemControl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemControlActionPerformed(evt);
            }
        });
        itemVentas.add(itemControl);

        menuConsultaPublicacion.add(itemVentas);

        mnMantenimiento.setForeground(new java.awt.Color(153, 102, 0));
        mnMantenimiento.setText("Mantenimiento");

        itmConsultaPublicacion.setForeground(new java.awt.Color(153, 102, 0));
        itmConsultaPublicacion.setText("Consulta Publicacion");
        itmConsultaPublicacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmConsultaPublicacionActionPerformed(evt);
            }
        });
        mnMantenimiento.add(itmConsultaPublicacion);

        itmMantenimientoPublicacion.setForeground(new java.awt.Color(153, 102, 0));
        itmMantenimientoPublicacion.setText("Mantenimiento Publicacion");
        itmMantenimientoPublicacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmMantenimientoPublicacionActionPerformed(evt);
            }
        });
        mnMantenimiento.add(itmMantenimientoPublicacion);

        menuConsultaPublicacion.add(mnMantenimiento);

        mnSalir.setForeground(new java.awt.Color(204, 153, 0));
        mnSalir.setText("Salir");

        itemCerrarSesion.setForeground(new java.awt.Color(255, 51, 51));
        itemCerrarSesion.setText("Cerrar sesión");
        itemCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCerrarSesionActionPerformed(evt);
            }
        });
        mnSalir.add(itemCerrarSesion);

        menuConsultaPublicacion.add(mnSalir);

        setJMenuBar(menuConsultaPublicacion);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void itemCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCerrarSesionActionPerformed
        System.exit(0);
    }//GEN-LAST:event_itemCerrarSesionActionPerformed

    private void itemsVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemsVentaActionPerformed

        
             VentaVista.main(null);
    }//GEN-LAST:event_itemsVentaActionPerformed

    private void itemConsultaVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemConsultaVentasActionPerformed

        ConsultaVentaVista.main(null);
    }//GEN-LAST:event_itemConsultaVentasActionPerformed

    private void itemControlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemControlActionPerformed
      ControlVista.main(null);
    }//GEN-LAST:event_itemControlActionPerformed

    private void itmConsultaPublicacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmConsultaPublicacionActionPerformed
        // TODO add your handling code here:
        ConsultaPublicacionPorTipoVista.main();
    }//GEN-LAST:event_itmConsultaPublicacionActionPerformed

    private void itmMantenimientoPublicacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmMantenimientoPublicacionActionPerformed
        // TODO add your handling code here:
          MantenimientoPublicacionVista.main(null);
    }//GEN-LAST:event_itmMantenimientoPublicacionActionPerformed

    public static void main(String args[]) {
//UsuarioDto usuariodto
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
            java.util.logging.Logger.getLogger(PrincipalVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PrincipalVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PrincipalVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrincipalVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PrincipalVista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem itemCerrarSesion;
    private javax.swing.JMenuItem itemConsultaVentas;
    private javax.swing.JMenuItem itemControl;
    private javax.swing.JMenu itemVentas;
    private javax.swing.JMenuItem itemsVenta;
    private javax.swing.JMenuItem itmConsultaPublicacion;
    private javax.swing.JMenuItem itmMantenimientoPublicacion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JMenuBar menuConsultaPublicacion;
    private javax.swing.JMenu mnMantenimiento;
    private javax.swing.JMenu mnSalir;
    // End of variables declaration//GEN-END:variables


}
