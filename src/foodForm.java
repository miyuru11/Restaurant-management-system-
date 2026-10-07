import java.sql.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class foodForm extends javax.swing.JFrame {

    public foodForm() {
        initComponents();
        setBounds(200,100,675,600);
        setResizable(false);
        Connect();
        LoadFoodItem();
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
            Logger.getLogger(foodForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(foodForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void LoadFoodItem(){
        try {
            pst = con.prepareStatement("SELECT foodName FROM food_tbl");
            rs = pst.executeQuery();
            txtFoodID.removeAllItems();
            while(rs.next()){
                txtFoodID.addItem(rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(foodForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void Fetch() {
        try {
            int q;
            pst = con.prepareStatement("SELECT * FROM food_tbl");
            rs = pst.executeQuery();
            ResultSetMetaData rss = rs.getMetaData();
            q = rss.getColumnCount();
            
            DefaultTableModel df = (DefaultTableModel)jTable1.getModel();
            df.setRowCount(0);
            while(rs.next()) {
                Vector v2 = new Vector();
                for(int a=1; a<=q; a++) {
                    v2.add(rs.getString("id"));
                    v2.add(rs.getString("foodName"));
                    v2.add(rs.getString("foodPrice"));
                }
                df.addRow(v2);
            }
        } catch (SQLException ex) {
            Logger.getLogger(foodForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtFoodName = new javax.swing.JTextField();
        txtFoodPrice = new javax.swing.JTextField();
        txtFoodID = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnSearch = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnBack = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(600, 600));
        getContentPane().setLayout(null);

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Food Name :");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(80, 130, 81, 32);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Food Price :");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(80, 170, 81, 32);

        txtFoodName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFoodNameActionPerformed(evt);
            }
        });
        getContentPane().add(txtFoodName);
        txtFoodName.setBounds(170, 130, 200, 30);
        getContentPane().add(txtFoodPrice);
        txtFoodPrice.setBounds(170, 170, 200, 30);

        getContentPane().add(txtFoodID);
        txtFoodID.setBounds(500, 130, 75, 30);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Food ID :");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(430, 130, 81, 32);

        btnAdd.setFont(new java.awt.Font("Book Antiqua", 0, 12)); // NOI18N
        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        getContentPane().add(btnAdd);
        btnAdd.setBounds(90, 250, 72, 23);

        btnUpdate.setFont(new java.awt.Font("Book Antiqua", 0, 12)); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        getContentPane().add(btnUpdate);
        btnUpdate.setBounds(180, 250, 72, 23);

        btnDelete.setFont(new java.awt.Font("Book Antiqua", 0, 12)); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        getContentPane().add(btnDelete);
        btnDelete.setBounds(270, 250, 72, 23);

        btnSearch.setFont(new java.awt.Font("Book Antiqua", 0, 12)); // NOI18N
        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });
        getContentPane().add(btnSearch);
        btnSearch.setBounds(500, 180, 72, 23);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Food ID", "Food Name", "Food Price"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(30, 300, 600, 200);

        btnBack.setFont(new java.awt.Font("Book Antiqua", 0, 12)); // NOI18N
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        getContentPane().add(btnBack);
        btnBack.setBounds(480, 520, 75, 23);

        jLabel5.setFont(new java.awt.Font("Algerian", 1, 40)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("FOODS");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(260, 40, 170, 60);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/food_background.jpg"))); // NOI18N
        jLabel7.setText("jLabel7");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(-50, -30, 1050, 980);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        try {
            String foodName = txtFoodName.getText();
            String foodPrice = txtFoodPrice.getText();
            
            pst = con.prepareStatement("INSERT INTO food_tbl (foodName,foodPrice)VALUES(?,?)");
            pst.setString(1,foodName);
            pst.setString(2,foodPrice);
            
            int k = pst.executeUpdate();
            
            if(k==1){
                JOptionPane.showMessageDialog(this,"Record Added Successfully!");
                txtFoodName.setText("");
                txtFoodPrice.setText("");
                Fetch();
                LoadFoodItem();
                
            } else {
                JOptionPane.showMessageDialog(this,"Record Failed.. Try Again!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(foodForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        try {
            String foodName = txtFoodName.getText();
            String foodPrice = txtFoodPrice.getText();
            String foodID = txtFoodID.getSelectedItem().toString();
            
            pst = con.prepareStatement("UPDATE food_tbl SET foodName=?,foodPrice=? WHERE foodName=?");
            
            pst.setString(1, foodName);
            pst.setString(2, foodPrice);
            pst.setString(3, foodID);
            
            int k = pst.executeUpdate();
            
            if(k==1) {
                JOptionPane.showMessageDialog(this,"Record has been successfully updated!");
                txtFoodName.setText("");
                txtFoodPrice.setText("");
                txtFoodName.requestFocus();
                Fetch();
                LoadFoodItem();
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(foodForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        try {
            String foodID = txtFoodID.getSelectedItem().toString();
            pst = con.prepareStatement("DELETE FROM food_tbl WHERE foodName=?");
            pst.setString(1,foodID);
            
            int k = pst.executeUpdate();
            
            if(k==1) {
                JOptionPane.showMessageDialog(this,"Record has been successfully deleted!");
                txtFoodName.setText("");
                txtFoodPrice.setText("");
                txtFoodName.requestFocus();
                Fetch();
                LoadFoodItem();
            } else {
                JOptionPane.showMessageDialog(this,"Record failed to delete!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(foodForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void txtFoodNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFoodNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFoodNameActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        try {
            String foodID = txtFoodID.getSelectedItem().toString();
            
            pst = con.prepareStatement("SELECT * FROM food_tbl WHERE foodName=?");
            pst.setString(1,foodID);
            rs = pst.executeQuery();
            if(rs.next()==true){
                txtFoodName.setText(rs.getString(2));
                txtFoodPrice.setText(rs.getString(3));
            } else {
                JOptionPane.showMessageDialog(this,"No Record Found!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(foodForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        new Dashboard().setVisible(true);
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
            java.util.logging.Logger.getLogger(foodForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(foodForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(foodForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(foodForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new foodForm().setVisible(true);
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JComboBox<String> txtFoodID;
    private javax.swing.JTextField txtFoodName;
    private javax.swing.JTextField txtFoodPrice;
    // End of variables declaration//GEN-END:variables
}