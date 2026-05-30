package PS_store;

import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class AddScreen extends javax.swing.JDialog {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(AddScreen.class.getName());

    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    String imagePath = "";
    int editId = -1;
    boolean isEdit = false;
    String itemType = "CONSOLE"; // القيمة الافتراضية
    // تعديل الـ Constructor ليستقبل النوع ويخزنه

    public AddScreen(java.awt.Frame parent, boolean modal, String type) {
        super(parent, modal);
        initComponents();

        this.itemType = type; // السطر 23: تعديل الاسم هنا ليصبح itemType ليتطابق مع المتغير فوق
        setLocationRelativeTo(parent);

        // تعديل العنوان الرئيسي (jLabel) وعنوان الديالوج حسب الشاشة المفتوحة برمجياً
        if (type.equals("GAME")) {
            setTitle("Add New Game");
            jLabel1.setText("Game Info"); // ملاحظة: تأكدي من اسم الـ jLabel الرئيسي عندك، هل هو jLabel1 أو اسم آخر؟
        } else if (type.equals("ACCESSORY")) {
            setTitle("Add New Accessory");
            jLabel1.setText("Accessory Info");
        } else {
            setTitle("Add New Console");
            jLabel1.setText("Console Info");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        uploadimage = new javax.swing.JButton();
        lblImagePreview = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtStock = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtModel = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtPrice = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Console Info");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, 160, 30));

        uploadimage.setBackground(new java.awt.Color(8, 48, 156));
        uploadimage.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        uploadimage.setForeground(new java.awt.Color(204, 204, 255));
        uploadimage.setText("Upload Image");
        uploadimage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uploadimageActionPerformed(evt);
            }
        });
        jPanel1.add(uploadimage, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, -1, -1));

        lblImagePreview.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 51, 51), 2, true));
        jPanel1.add(lblImagePreview, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 170, 130));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Stock");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 160, 80, 20));

        txtStock.setBackground(new java.awt.Color(204, 204, 255));
        txtStock.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtStock.setForeground(new java.awt.Color(0, 0, 0));
        txtStock.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 255), 1, true));
        txtStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStockActionPerformed(evt);
            }
        });
        jPanel1.add(txtStock, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 160, 160, 30));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Name ");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 40, 80, 20));

        txtName.setBackground(new java.awt.Color(204, 204, 255));
        txtName.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtName.setForeground(new java.awt.Color(0, 0, 0));
        txtName.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 255), 1, true));
        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });
        jPanel1.add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 40, 160, 30));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Model");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 80, 80, 20));

        txtModel.setBackground(new java.awt.Color(204, 204, 255));
        txtModel.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtModel.setForeground(new java.awt.Color(0, 0, 0));
        txtModel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 255), 1, true));
        txtModel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtModelActionPerformed(evt);
            }
        });
        jPanel1.add(txtModel, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 80, 160, 30));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Price(JOD)");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 120, 80, 20));

        txtPrice.setBackground(new java.awt.Color(204, 204, 255));
        txtPrice.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtPrice.setForeground(new java.awt.Color(0, 0, 0));
        txtPrice.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 255), 1, true));
        txtPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPriceActionPerformed(evt);
            }
        });
        jPanel1.add(txtPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 120, 160, 30));

        btnAdd.setBackground(new java.awt.Color(8, 48, 156));
        btnAdd.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(204, 204, 255));
        btnAdd.setText("Add ");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        jPanel1.add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 200, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void uploadimageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uploadimageActionPerformed
        JFileChooser chooser = new JFileChooser();
        int result = chooser.showOpenDialog(this);

        if (result == JFileChooser.APPROVE_OPTION) {
            java.io.File selectedFile = chooser.getSelectedFile();

            //  حفظ المسار  في المتغير  عشان ينخفظ بقاعدة البيانات بعدين
            imagePath = selectedFile.getAbsolutePath();

            try {
                //  ننشئ ايقونة من المسار اللي اخترناه
                ImageIcon icon = new ImageIcon(imagePath);

//نجيب ابعاد الليبل 
                int width = lblImagePreview.getWidth();
                int height = lblImagePreview.getHeight();

                if (width <= 0) {
                    width = 135;
                }
                if (height <= 0) {
                    height = 135;
                }

//نزبط الصورة ع حجم الليبل  ونخليها سموذ
                Image img = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);

//نعرض الصوره جوا الليبل 
                lblImagePreview.setIcon(new ImageIcon(img));

                lblImagePreview.revalidate();
                lblImagePreview.repaint();

            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        }
    }//GEN-LAST:event_uploadimageActionPerformed

    private void txtStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStockActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStockActionPerformed

    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameActionPerformed

    private void txtModelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtModelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtModelActionPerformed

    private void txtPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPriceActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed

        try {
//نتاكد انو معبي كلشي وماترك اشي فاضي
            if (txtName.getText().trim().isEmpty()
                    || txtModel.getText().trim().isEmpty()
                    || txtPrice.getText().trim().isEmpty()
                    || txtStock.getText().trim().isEmpty()
                    || imagePath.isEmpty()) {

                JOptionPane.showMessageDialog(this, "Please fill all fields and upload an image");
                return;
            }
            //بحالة  اضافه منتج
con = Connect.connect();
            if (!isEdit) {

                String query = "INSERT INTO PRODUCT (NAME, MODEL, PRICE, STOCK, IMAGE_PATH, TYPE) VALUES (?, ?, ?, ?, ?, ?)";

                pst = con.prepareStatement(query);

                pst.setString(1, txtName.getText());
                pst.setString(2, txtModel.getText());
                pst.setDouble(3, Double.parseDouble(txtPrice.getText()));
                pst.setInt(4, Integer.parseInt(txtStock.getText()));
                pst.setString(5, imagePath);
                pst.setString(6, this.itemType);
                pst.executeUpdate();

            } //بحالة تعديل على منتج
            else {

                String query = "UPDATE PRODUCT SET NAME=?, MODEL=?, PRICE=?, STOCK=?, IMAGE_PATH=? WHERE ID=?";

                pst = con.prepareStatement(query);

                pst.setString(1, txtName.getText());
                pst.setString(2, txtModel.getText());
                pst.setDouble(3, Double.parseDouble(txtPrice.getText()));
                pst.setInt(4, Integer.parseInt(txtStock.getText()));
                pst.setString(5, imagePath);
                pst.setInt(6, editId);

                pst.executeUpdate();
            }
if (pst != null) pst.close();
        if (con != null) con.close();
            this.dispose();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex);
        }
    }//GEN-LAST:event_btnAddActionPerformed

    public void setEditMode(int id, String name, String model, double price, int stock) {

        this.editId = id;
        this.isEdit = true;

        txtName.setText(name);
        txtModel.setText(model);
        txtPrice.setText(String.valueOf(price));
        txtStock.setText(String.valueOf(stock));
        btnAdd.setText("update");

        try {
            con = Connect.connect();

            String sql = "SELECT IMAGE_PATH FROM PRODUCT WHERE ID=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, id);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                imagePath = rs.getString("IMAGE_PATH");

                ImageIcon icon = new ImageIcon(imagePath);

                Image img = icon.getImage().getScaledInstance(
                        lblImagePreview.getWidth(),
                        lblImagePreview.getHeight(),
                        Image.SCALE_SMOOTH
                );

                lblImagePreview.setIcon(new ImageIcon(img));
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnAdd;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JLabel lblImagePreview;
    public javax.swing.JTextField txtModel;
    public javax.swing.JTextField txtName;
    public javax.swing.JTextField txtPrice;
    public javax.swing.JTextField txtStock;
    public javax.swing.JButton uploadimage;
    // End of variables declaration//GEN-END:variables
}
