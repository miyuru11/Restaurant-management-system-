public class Dashboard extends javax.swing.JFrame {

    public Dashboard() {
        initComponents();
        setBounds(200,100,675,600);
        setResizable(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnFoods = new javax.swing.JButton();
        btnCustomers = new javax.swing.JButton();
        btnBilling = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Algerian", 1, 40)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("DASHBOARD");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(210, 130, 250, 54);

        btnFoods.setFont(new java.awt.Font("Book Antiqua", 1, 14)); // NOI18N
        btnFoods.setText("FOODS");
        btnFoods.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFoodsActionPerformed(evt);
            }
        });
        getContentPane().add(btnFoods);
        btnFoods.setBounds(270, 220, 125, 30);

        btnCustomers.setFont(new java.awt.Font("Book Antiqua", 1, 14)); // NOI18N
        btnCustomers.setText("CUSTOMERS");
        btnCustomers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCustomersActionPerformed(evt);
            }
        });
        getContentPane().add(btnCustomers);
        btnCustomers.setBounds(270, 270, 125, 30);

        btnBilling.setFont(new java.awt.Font("Book Antiqua", 1, 14)); // NOI18N
        btnBilling.setText("BILLING");
        btnBilling.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBillingActionPerformed(evt);
            }
        });
        getContentPane().add(btnBilling);
        btnBilling.setBounds(270, 320, 125, 30);

        btnBack.setFont(new java.awt.Font("Book Antiqua", 0, 12)); // NOI18N
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        getContentPane().add(btnBack);
        btnBack.setBounds(290, 450, 90, 23);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/juice.jpg"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(-20, 0, 750, 670);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFoodsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFoodsActionPerformed
        new foodForm().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnFoodsActionPerformed

    private void btnCustomersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCustomersActionPerformed
        new CustomersForm().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnCustomersActionPerformed

    private void btnBillingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBillingActionPerformed
        new BillingForm().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnBillingActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        new LoginForm().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnBackActionPerformed

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
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnBilling;
    private javax.swing.JButton btnCustomers;
    private javax.swing.JButton btnFoods;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}