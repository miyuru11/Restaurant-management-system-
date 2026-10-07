import java.sql.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

public class BillingForm extends javax.swing.JFrame {

    public BillingForm() {
        initComponents();
        setBounds(200,100,675,600);
        setResizable(false);
        Connect();
        LoadCustomer();
        LoadFoodItem();
        LoadFoodPrice();
        Fetch();
        
        // Add this ActionListener to update the food price when a food item is selected
        comboFoodName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoadFoodPrice();
            }
        });
    }

    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    
    public void Connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cafe_application?useSSL=false&serverTimezone=UTC","root","");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(foodForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(foodForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void LoadCustomer() {
        try {
            pst = con.prepareStatement("SELECT customerName FROM customers_tbl");
            rs = pst.executeQuery();
            comboCustomer.removeAllItems();
            while(rs.next()){
                comboCustomer.addItem(rs.getString("customerName"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(BillingForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void LoadFoodItem() {
        try {
            pst = con.prepareStatement("SELECT foodName FROM food_tbl");
            rs = pst.executeQuery();
            comboFoodName.removeAllItems();
            while(rs.next()){
                comboFoodName.addItem(rs.getString("foodName"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(BillingForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void LoadFoodPrice() {
        try {
            String selectedFood = comboFoodName.getSelectedItem().toString();
            pst = con.prepareStatement("SELECT foodPrice FROM food_tbl WHERE foodName = ?");
            pst.setString(1, selectedFood);
            rs = pst.executeQuery();
            
            while(rs.next()){
                String price = rs.getString("foodPrice");
                txtFoodPrice.setText(price);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BillingForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void Fetch() {
        try {
            int q;
            pst = con.prepareStatement("SELECT * FROM billing_tbl");
            rs = pst.executeQuery();
            ResultSetMetaData rss = rs.getMetaData();
            q = rss.getColumnCount();
            
            DefaultTableModel df = (DefaultTableModel)jTable1.getModel();
            df.setRowCount(0);
            while(rs.next()) {
                Vector v2 = new Vector();
                for(int a=1; a<=q; a++) {
                    v2.add(rs.getString("customerName"));
                    v2.add(rs.getString("foodName"));
                    v2.add(rs.getString("foodPrice"));
                    v2.add(rs.getString("quantity"));
                    v2.add(rs.getDouble("totalPrice"));
                }
                df.addRow(v2);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BillingForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        comboCustomer = new javax.swing.JComboBox<>();
        comboFoodName = new javax.swing.JComboBox<>();
        txtFoodPrice = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtQuantity = new javax.swing.JTextField();
        btnAddBill = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Algerian", 1, 40)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("BILLING");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(260, 30, 154, 54);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Customer :");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(110, 100, 90, 30);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Food Name :");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(110, 140, 90, 30);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Food Price :");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(110, 180, 117, 30);

        comboCustomer.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(comboCustomer);
        comboCustomer.setBounds(220, 100, 100, 30);

        comboFoodName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(comboFoodName);
        comboFoodName.setBounds(220, 140, 100, 30);
        getContentPane().add(txtFoodPrice);
        txtFoodPrice.setBounds(220, 180, 100, 30);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Quantity :");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(110, 220, 117, 30);
        getContentPane().add(txtQuantity);
        txtQuantity.setBounds(220, 220, 100, 30);

        btnAddBill.setFont(new java.awt.Font("Book Antiqua", 0, 12)); // NOI18N
        btnAddBill.setText("Add to Bill");
        btnAddBill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddBillActionPerformed(evt);
            }
        });
        getContentPane().add(btnAddBill);
        btnAddBill.setBounds(360, 160, 96, 23);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {
                "Customer", "Food Name", "Food Price", "Quantity", "Total Price"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(45, 300, 580, 200);

        jLabel6.setFont(new java.awt.Font("NewsGoth BT", 1, 15)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Customer's Bill");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(290, 270, 120, 20);

        btnBack.setFont(new java.awt.Font("Book Antiqua", 0, 12)); // NOI18N
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        getContentPane().add(btnBack);
        btnBack.setBounds(470, 520, 72, 23);

        jButton1.setFont(new java.awt.Font("Book Antiqua", 0, 12)); // NOI18N
        jButton1.setText("Print Report");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(470, 160, 97, 23);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/food_background.jpg"))); // NOI18N
        jLabel7.setText("jLabel7");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(0, 0, 720, 620);

        jButton2.setText("jButton2");
        getContentPane().add(jButton2);
        jButton2.setBounds(590, 160, 75, 23);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddBillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddBillActionPerformed
        try {
            String customer = comboCustomer.getSelectedItem().toString();
            String foodName = comboFoodName.getSelectedItem().toString();
            String foodPrice = txtFoodPrice.getText();
            String quantity = txtQuantity.getText();
            
            double price = Double.parseDouble(foodPrice);
            int qty = Integer.parseInt(quantity);         
            double totalPrice = price * qty;
            
            pst = con.prepareStatement("INSERT INTO billing_tbl (customerName,foodName,foodPrice,quantity,totalPrice)VALUES(?,?,?,?,?)");
            pst.setString(1,customer);
            pst.setString(2,foodName);
            pst.setString(3,foodPrice);
            pst.setString(4,quantity);
            pst.setDouble(5, totalPrice);
            
            int k = pst.executeUpdate();
            
            if(k==1){
                JOptionPane.showMessageDialog(this,"Bill Added Successfully!");
                
                // Add the new row to the table
                DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                model.addRow(new Object[] { customer, foodName, foodPrice, quantity, totalPrice });
                
                comboCustomer.setSelectedItem("");
                comboFoodName.setSelectedItem("");
                txtFoodPrice.setText("");
                txtQuantity.setText("");
                LoadCustomer();
                Fetch();
                
            } else {
                JOptionPane.showMessageDialog(this,"Record Failed.. Try Again!");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(BillingForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAddBillActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        new Dashboard().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnBackActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        try {
        
               Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cafe_application?useSSL=false&serverTimezone=UTC","root","");
                String reportpath ="C:\\Users\\USER\\JaspersoftWorkspace\\MyReports\\Cherry.jrxml";
                JasperReport jr=JasperCompileManager.compileReport(reportpath);
                JasperPrint jp = JasperFillManager.fillReport(jr,null,con);
                JasperViewer.viewReport(jp);
                
        }
        
        catch(Exception e){
        
            JOptionPane.showMessageDialog(null,"Error:"+ e.getMessage());
             
}
        
        
        
        
        
        
        
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(BillingForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BillingForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BillingForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BillingForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BillingForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddBill;
    private javax.swing.JButton btnBack;
    private javax.swing.JComboBox<String> comboCustomer;
    private javax.swing.JComboBox<String> comboFoodName;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtFoodPrice;
    private javax.swing.JTextField txtQuantity;
    // End of variables declaration//GEN-END:variables
}