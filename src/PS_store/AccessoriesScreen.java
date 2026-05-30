package PS_store;

import java.awt.*;
import javax.swing.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AccessoriesScreen extends javax.swing.JFrame {

    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public AccessoriesScreen() {
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
// استخدمت invokeLater حتى اضمن تحميل الجدول بشكل صحيح على مسار الواجهة Swing (Event Dispatch Thread)
// حتى يتم تحديث الواجهة بشكل صحيح بعد تهيئة الشاشةومايصير لخبطة

        SwingUtilities.invokeLater(() -> {
            loadAccessoriesTable();
        });

        //تغيير لون خلفيه الجدول
        jScrollPane1.getViewport().setBackground(Color.white);
        //تغيير  لون خلفيه العناوين
        accessoryTable.getTableHeader().setBackground(new Color(204, 204, 255, 255));
        accessoryTable.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 13));

        //شعار البرنامج
        ImageIcon icon1 = new ImageIcon("pslogo2.PNG");
        Image img1 = icon1.getImage();
        Image newiImage1 = img1.getScaledInstance(jLabel2.getWidth(), jLabel2.getHeight(), Image.SCALE_SMOOTH);
        jLabel2.setIcon(new ImageIcon(newiImage1));

        //صورة سلة النفايات
        ImageIcon icon2 = new ImageIcon("deleteicon.JPG");
        Image img2 = icon2.getImage();
        Image newiImage2 = img2.getScaledInstance(jLabel6.getWidth(), jLabel6.getHeight(), Image.SCALE_SMOOTH);
        jLabel6.setIcon(new ImageIcon(newiImage2));

        //صورة قلم ليدل ع التعديل
        ImageIcon icon3 = new ImageIcon("editicon.JPG");
        Image img3 = icon3.getImage();
        Image newiImage3 = img3.getScaledInstance(jLabel1.getWidth(), jLabel1.getHeight(), Image.SCALE_SMOOTH);
        jLabel1.setIcon(new ImageIcon(newiImage3));

        //صورة سلة ليدل ع وضع المنتج بسلة التسوق
        ImageIcon icon4 = new ImageIcon("shop.JPG");
        Image img4 = icon4.getImage();
        Image newiImage4 = img4.getScaledInstance(jLabel7.getWidth(), jLabel7.getHeight(), Image.SCALE_SMOOTH);
        jLabel7.setIcon(new ImageIcon(newiImage4));

        accessoryTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "Image", "Name", "Model", "Price", "Stock", "ID"
                }) {
            @Override
            public Class getColumnClass(int columnIndex) {
                if (columnIndex == 0) {
                    return javax.swing.Icon.class; // السطر  اللي بظهر الصورة
                }
                return Object.class;
            }
        });

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        edit = new javax.swing.JButton();
        addnewitem = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        accessoryTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ConsoleManagment");
        setBackground(new java.awt.Color(0, 153, 153));

        jPanel2.setBackground(new java.awt.Color(226, 226, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(1600, 45));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setBackground(new java.awt.Color(226, 226, 255));
        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setText("Back");
        jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(179, 179, 249), 2));
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1410, 10, 90, 30));

        getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_START);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(102, 102, 102));
        jPanel1.setPreferredSize(new java.awt.Dimension(1600, 860));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(226, 226, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.setPreferredSize(new java.awt.Dimension(1600, 100));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 140, 100));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Accessories Management");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 30, 290, -1));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Manage all playstation Accessories in inventory");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 60, 300, -1));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 2200, 130));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel4.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, 50, 30));

        edit.setBackground(new java.awt.Color(255, 255, 255));
        edit.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        edit.setForeground(new java.awt.Color(153, 153, 153));
        edit.setText("Edit");
        edit.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        edit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });
        jPanel4.add(edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 10, 100, 30));

        addnewitem.setBackground(new java.awt.Color(8, 48, 156));
        addnewitem.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        addnewitem.setForeground(new java.awt.Color(255, 255, 255));
        addnewitem.setText("+ Add New Item");
        addnewitem.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        addnewitem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addnewitem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addnewitemActionPerformed(evt);
            }
        });
        jPanel4.add(addnewitem, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 160, 30));

        delete.setBackground(new java.awt.Color(255, 255, 255));
        delete.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        delete.setForeground(new java.awt.Color(204, 0, 0));
        delete.setText("Delete");
        delete.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        delete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });
        jPanel4.add(delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 10, 90, 30));
        jPanel4.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 10, 50, 30));
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 10, 50, 30));

        jButton5.setBackground(new java.awt.Color(255, 255, 255));
        jButton5.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jButton5.setForeground(new java.awt.Color(153, 153, 153));
        jButton5.setText("Add to cart");
        jButton5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 10, 110, 30));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 2200, 50));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        accessoryTable.setBackground(new java.awt.Color(255, 255, 255));
        accessoryTable.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        accessoryTable.setForeground(new java.awt.Color(0, 0, 0));
        accessoryTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Image", "Name", "Model", "Price(JOD)", "Stock", "ID"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        accessoryTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        accessoryTable.setRowHeight(200);
        jScrollPane1.setViewportView(accessoryTable);
        if (accessoryTable.getColumnModel().getColumnCount() > 0) {
            accessoryTable.getColumnModel().getColumn(0).setPreferredWidth(100);
            accessoryTable.getColumnModel().getColumn(4).setPreferredWidth(10);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 1520, 560));

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void addnewitemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addnewitemActionPerformed
        AddScreen add = new AddScreen(this, true, "ACCESSORY");
        add.setVisible(true);
//هون عملت زي مراقب للشاشه الادد بحيث اول ما تسكر ينضاف ومو بس ع داتا بيس كمان ع الجي تيبل  
        add.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosed(WindowEvent e) {

                loadAccessoriesTable();
            }

        });

    }//GEN-LAST:event_addnewitemActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        JOptionPane.showMessageDialog(null, "this feature is under development");
    }//GEN-LAST:event_jButton5ActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        int selectedRow = accessoryTable.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, " select a row first");
            return;
        }

        try {

            int id = Integer.parseInt(accessoryTable.getValueAt(selectedRow, 5).toString());
//نتاكد من المستخدم اذا هوه ع الاكيد بدو يحذف
            int confirm = JOptionPane.showConfirmDialog(
                    this,
                    "Are you sure you want to delete this item?",
                    "Confirm Delete",
                    JOptionPane.YES_NO_OPTION
            );

            if (confirm != JOptionPane.YES_OPTION) {
                return;
            }

            con = Connect.connect();

            String sql = "DELETE FROM PRODUCT WHERE ID = ?";

            pst = con.prepareStatement(sql);
            pst.setInt(1, id);

            pst.executeUpdate();

            pst.close();

            loadAccessoriesTable(); // refresh
            JOptionPane.showMessageDialog(this, "Deleted successfully");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
    }    }//GEN-LAST:event_deleteActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new MainDashboard().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed
//نعرف اي صف اختار المستخدم
        int row = accessoryTable.getSelectedRow();
//نلزم المستخدم يختار صف من الجدول
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Select a row first");
            return;
        }
//نجيب بيانات الصف الي اختارو الشخص  وبعدها نفتح شاشه ال ادد
        int id = Integer.parseInt(accessoryTable.getValueAt(row, 5).toString());
        String name = accessoryTable.getValueAt(row, 1).toString();
        String model = accessoryTable.getValueAt(row, 2).toString();
        double price = Double.parseDouble(accessoryTable.getValueAt(row, 3).toString());
        int stock = Integer.parseInt(accessoryTable.getValueAt(row, 4).toString());

        AddScreen add = new AddScreen(this, true, "ACCESSORY");

        add.setEditMode(id, name, model, price, stock);
        add.setVisible(true);

        loadAccessoriesTable();    }//GEN-LAST:event_editActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new AccessoriesScreen().setVisible(true));

    }

    public void loadAccessoriesTable() {

        try {

            con = Connect.connect();

            String sql = "SELECT * FROM PRODUCT WHERE TYPE='ACCESSORY'";

            pst = con.prepareStatement(sql);

            rs = pst.executeQuery();

            DefaultTableModel model
                    = (DefaultTableModel) accessoryTable.getModel();

            model.setRowCount(0);

            while (rs.next()) {

                model.addRow(new Object[]{
                    new ImageIcon(
                    new ImageIcon(rs.getString("IMAGE_PATH"))
                    .getImage()
                    .getScaledInstance(200, 200, Image.SCALE_SMOOTH)
                    ),
                    rs.getString("NAME"),
                    rs.getString("MODEL"),
                    rs.getDouble("PRICE"),
                    rs.getInt("STOCK"),
                    rs.getInt("ID")

                });

            }

            accessoryTable.setRowHeight(200);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTable accessoryTable;
    private javax.swing.JButton addnewitem;
    private javax.swing.JButton delete;
    private javax.swing.JButton edit;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
