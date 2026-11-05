/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author dayuh
 */
public class MyAppointments extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(MyAppointments.class.getName());
private int customerId;
private String firstName;
private String lastName;

public MyAppointments(String firstName, String lastName, int customerId) {

    initComponents();

    this.firstName = firstName;
    this.lastName = lastName;
    this.customerId = customerId;

    setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);

    loadAppointments();
}

private void loadAppointments() {
   
    String sql = "SELECT a.appointment_id, "
               + "a.appointment_date, "
               + "a.appointment_time, "
               + "s.service_name, "
               + "a.details, "
               + "a.appointment_status "
               + "FROM appointments a "
               + "JOIN Service s ON a.service_id = s.service_id "
               + "WHERE a.customer_id = ? "
               + "ORDER BY a.created_at DESC";

    try (
        java.sql.Connection con = DBConnection.getConnection();
        java.sql.PreparedStatement pst = con.prepareStatement(sql)
    ) {
        pst.setInt(1, customerId);

        try (java.sql.ResultSet rs = pst.executeQuery()) {
            javax.swing.table.DefaultTableModel model =
                (javax.swing.table.DefaultTableModel)
                jTable1.getModel();

            model.setRowCount(0);

            while (rs.next()) {
                java.sql.Date sqlDate =
                    rs.getDate("appointment_date");

                String formattedDate = "";

                if (sqlDate != null) {
                    formattedDate = sqlDate.toLocalDate().format(
                        java.time.format.DateTimeFormatter.ofPattern(
                            "MMMM d, yyyy",
                            java.util.Locale.ENGLISH
                        )
                    );
                }

                model.addRow(new Object[] {
                    rs.getInt("appointment_id"),
                    formattedDate,
                    rs.getString("appointment_time"),
                    rs.getString("service_name"),
                    rs.getString("details"),
                    rs.getString("appointment_status")
                });
            }
        }

    } catch (java.sql.SQLException e) {
        javax.swing.JOptionPane.showMessageDialog(
            this,
            "Failed to load appointments: " + e.getMessage()
        );
    }

}
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setText("ERCANS TAILORING SHOP");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setText("MY APPOINTMENTS");

        jTable1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Appointment ID", "Appointment Date", "Time", "Service", "Details", "Status"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jButton1.setText("BACK TO DASHBOARD");
        jButton1.addActionListener(this::jButton1ActionPerformed);

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jButton2.setText("REQUEST CANCELLATION");
        jButton2.addActionListener(this::jButton2ActionPerformed);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(502, 502, 502)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1195, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(569, 569, 569)
                        .addComponent(jLabel2)))
                .addContainerGap(372, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addGap(104, 104, 104)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(215, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed


    CustomerDashboard dashboard =
    new CustomerDashboard(firstName, lastName, customerId);

dashboard.setVisible(true);
this.dispose();


    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed


    int row = jTable1.getSelectedRow();

    if (row == -1) {
        javax.swing.JOptionPane.showMessageDialog(
            this, "Please select an appointment first."
        );
        return;
    }

    int appointmentId = Integer.parseInt(
        jTable1.getValueAt(row, 0).toString()
    );

    String status = jTable1.getValueAt(row, 5).toString();

    if (!status.equalsIgnoreCase("Approved")
            && !status.equalsIgnoreCase("Accepted")) {
        javax.swing.JOptionPane.showMessageDialog(
            this,
            "Only approved appointments can request cancellation."
        );
        return;
    }

    int confirm = javax.swing.JOptionPane.showConfirmDialog(
        this,
        "Send a cancellation request to the admin?",
        "Request Cancellation",
        javax.swing.JOptionPane.YES_NO_OPTION
    );

    if (confirm != javax.swing.JOptionPane.YES_OPTION) {
        return;
    }

    
String sql = "UPDATE appointments "
           + "SET cancellation_status = 'Pending' "
           + "WHERE appointment_id = ? "
           + "AND customer_id = ? "
           + "AND appointment_status IN ('Approved', 'Accepted') "
           + "AND (cancellation_status IS NULL "
           + "OR cancellation_status = 'Rejected')";

    try (
        java.sql.Connection con = DBConnection.getConnection();
        java.sql.PreparedStatement pst = con.prepareStatement(sql)
    ) {
        pst.setInt(1, appointmentId);
        pst.setInt(2, customerId);

        int updated = pst.executeUpdate();

        if (updated > 0) {
            javax.swing.JOptionPane.showMessageDialog(
                this,
                "Cancellation request sent!\n"
                + "Please wait for admin approval."
            );

            loadAppointments();
        } else {
            javax.swing.JOptionPane.showMessageDialog(
                this,
                "Request failed. Please refresh and try again."
            );
        }

    } catch (java.sql.SQLException e) {
        javax.swing.JOptionPane.showMessageDialog(
            this, "Database error: " + e.getMessage()
        );
    }


    }//GEN-LAST:event_jButton2ActionPerformed

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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() ->
    new MyAppointments("", "", 0).setVisible(true)
);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
