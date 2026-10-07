import java.sql.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class CustomersForm extends javax.swing.JFrame {

    public CustomersForm() {
        initComponents();
        setBounds(200,100,675,600);
        setResizable(false);
        Connect();
        LoadCustomer();
        Fetch();
    }
    
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    
    public void Connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cafe_application?useSSL=false&serverTimezone=UTC","root","");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CustomersForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CustomersForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void LoadCustomer(){
        try {
            pst = con.prepareStatement("SELECT customerID FROM customers_tbl");
            rs = pst.executeQuery();
            txtCustomerID.removeAllItems();
            while(rs.next()){
                txtCustomerID.addItem(rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomersForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void Fetch() {
        try {
            int q;
            pst = con.prepareStatement("SELECT * FROM customers_tbl");
            rs = pst.executeQuery();
            ResultSetMetaData rss = rs.getMetaData();
            q = rss.getColumnCount();
            
            DefaultTableModel df = (DefaultTableModel)jTable1.getModel();
            df.setRowCount(0);
            while(rs.next()) {
                Vector v2 = new Vector();
                for(int a=1; a<=q; a++) {
                    v2.add(rs.getString("customerID"));
                    v2.add(rs.getString("customerName"));
                    v2.add(rs.getString("address"));
                    v2.add(rs.getString("phoneNumber"));
                }
                df.addRow(v2);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomersForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtCustomerName = new javax.swing.JTextField();
        txtAddress = new javax.swing.JTextField();
        txtPhoneNumber = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnBack = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtCustomerID = new javax.swing.JComboBox<>();
        btnSearch = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Algerian", 1, 40)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("CUSTOMERS");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(220, 50, 240, 54);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Customer Name :");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(70, 140, 110, 30);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Address :");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(70, 180, 57, 30);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Phone Number :");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(70, 218, 105, 30);

        txtCustomerName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCustomerNameActionPerformed(evt);
            }
        });
        getContentPane().add(txtCustomerName);
        txtCustomerName.setBounds(200, 140, 200, 30);
        getContentPane().add(txtAddress);
        txtAddress.setBounds(200, 180, 200, 30);
        getContentPane().add(txtPhoneNumber);
        txtPhoneNumber.setBounds(200, 220, 200, 30);

        btnAdd.setFont(new java.awt.Font("Book Antiqua", 0, 12)); // NOI18N
        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        getContentPane().add(btnAdd);
        btnAdd.setBounds(100, 270, 72, 23);

        btnUpdate.setFont(new java.awt.Font("Book Antiqua", 0, 12)); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        getContentPane().add(btnUpdate);
        btnUpdate.setBounds(200, 270, 72, 23);

        btnDelete.setFont(new java.awt.Font("Book Antiqua", 0, 12)); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        getContentPane().add(btnDelete);
        btnDelete.setBounds(300, 270, 72, 23);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Customer ID", "Customer Name", "Address", "Phone Number"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 568, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(50, 320, 580, 194);

        btnBack.setFont(new java.awt.Font("Book Antiqua", 0, 12)); // NOI18N
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        getContentPane().add(btnBack);
        btnBack.setBounds(470, 530, 72, 23);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Customer ID :");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(430, 140, 93, 30);

        txtCustomerID.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(txtCustomerID);
        txtCustomerID.setBounds(530, 140, 75, 30);

        btnSearch.setFont(new java.awt.Font("Book Antiqua", 0, 12)); // NOI18N
        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });
        getContentPane().add(btnSearch);
        btnSearch.setBounds(530, 180, 75, 23);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/food_background.jpg"))); // NOI18N
        jLabel7.setText("jLabel7");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(0, 0, 860, 600);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCustomerNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCustomerNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCustomerNameActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        new Dashboard().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        try {
            String customerName = txtCustomerName.getText();
            String customerAddress = txtAddress.getText();
            String customerPhone = txtPhoneNumber.getText();
            
            pst = con.prepareStatement("INSERT INTO customers_tbl (customerName,address,phoneNumber)VALUES(?,?,?)");
            pst.setString(1,customerName);
            pst.setString(2,customerAddress);
            pst.setString(3,customerPhone);
            
            int k = pst.executeUpdate();
            
            if(k==1){
                JOptionPane.showMessageDialog(this,"Customer Added Successfully!");
                txtCustomerName.setText("");
                txtAddress.setText("");
                txtPhoneNumber.setText("");
                Fetch();
                LoadCustomer();
                
            } else {
                JOptionPane.showMessageDialog(this,"Record Failed.. Try Again!");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(CustomersForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        try {
            String customerName = txtCustomerName.getText();
            String customerAddress = txtAddress.getText();
            String customerPhone = txtPhoneNumber.getText();
            String customerID = txtCustomerID.getSelectedItem().toString();
            
            pst = con.prepareStatement("UPDATE customers_tbl SET customerName=?,address=?,phoneNumber=? WHERE customerID=?");
            
            pst.setString(1, customerName);
            pst.setString(2, customerAddress);
            pst.setString(3, customerPhone);
            pst.setString(4, customerID);
            
            int k = pst.executeUpdate();
            
            if(k==1) {
                JOptionPane.showMessageDialog(this,"Customer has been successfully updated!");
                txtCustomerName.setText("");
                txtAddress.setText("");
                txtPhoneNumber.setText("");
                txtCustomerName.requestFocus();
                Fetch();
                LoadCustomer();
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(CustomersForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        try {
            String customerID = txtCustomerID.getSelectedItem().toString();
            
            pst = con.prepareStatement("SELECT * FROM customers_tbl WHERE customerID=?");
            pst.setString(1,customerID);
            rs = pst.executeQuery();
            if(rs.next()==true){
                txtCustomerName.setText(rs.getString(2));
                txtAddress.setText(rs.getString(3));
                txtPhoneNumber.setText(rs.getString(4));
            } else {
                JOptionPane.showMessageDialog(this,"No Customer Found!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomersForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        try {
            String customerID = txtCustomerID.getSelectedItem().toString();
            pst = con.prepareStatement("DELETE FROM customers_tbl WHERE customerID=?");
            pst.setString(1,customerID);
            
            int k = pst.executeUpdate();
            
            if(k==1) {
                JOptionPane.showMessageDialog(this,"Customer has been successfully deleted!");
                txtCustomerName.setText("");
                txtAddress.setText("");
                txtPhoneNumber.setText("");
                txtCustomerName.requestFocus();
                Fetch();
                LoadCustomer();
            } else {
                JOptionPane.showMessageDialog(this,"Record failed to delete!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomersForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

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
            java.util.logging.Logger.getLogger(CustomersForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CustomersForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CustomersForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CustomersForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CustomersForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JComboBox<String> txtCustomerID;
    private javax.swing.JTextField txtCustomerName;
    private javax.swing.JTextField txtPhoneNumber;
    // End of variables declaration//GEN-END:variables
}