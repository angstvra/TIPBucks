package views;

import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import model.Bill;
import model.Category;
import model.Product;
import utils.BillDao;
import utils.CategoryDao;
import utils.ProductDao;
import common.OpenPdf;

public class PlaceOrder extends javax.swing.JFrame {

    private int billId = 1;
    private int grandTotal = 0;
    private int productPrice = 0;
    private int productTotal = 0;
    public String emailPattern = "^[a-zA-Z0-9]+[@]+[a-zA-Z0-9]+[.]+[a-zA-Z0-9]+$";
    public String mobileNumberPattern = "^[0-9]*$";
    private String userEmail;
    
    public PlaceOrder() {
        initComponents();
        //setExtendedState(JFrame.MAXIMIZED_BOTH);
        
    }
    
    public PlaceOrder(String email) {
        initComponents();
        txtProName.setEditable(false);
        txtProPrice.setEditable(false);
        txtProTotal.setEditable(false);
        btnAddToCart.setEnabled(false);
        btnGenBillPrint.setEnabled(false);
        JFormattedTextField tf = ((JSpinner.DefaultEditor) jSpinner1.getEditor()).getTextField();
        tf.setEnabled(false);
        userEmail = email;
        //setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
    
    public void productNameByCategory(String category) {
        DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
        dtm.setRowCount(0);
        ArrayList<Product> list = ProductDao.getAllRecordsByCategory(category);
        Iterator<Product> itr = list.iterator();
        while(itr.hasNext()) {
            Product productObj = itr.next();
            dtm.addRow(new Object[]{productObj.getName()});
        }    
    }
   
    public void filterProductByName(String name, String category) {
        DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
        dtm.setRowCount(0);
        ArrayList<Product> list = ProductDao.filterProductByname(name, category);
        Iterator<Product> itr = list.iterator();
        while(itr.hasNext()) {
            Product productObj = itr.next();
            dtm.addRow(new Object[]{productObj.getName()});
        }    
    }
    
    public void clearProductFields() {
        txtProName.setText("");
        txtProPrice.setText("");
        jSpinner1.setValue(1);
        txtProTotal.setText("");
        btnAddToCart.setEnabled(false);    
    }
    
    public void validateFields() {
        String customerName = txtCusName.getText();
        String customerMobileNum = txtCusMobileNum.getText();
        String customerEmail = txtCusEmail.getText();
        if(!customerEmail.equals("") && customerMobileNum.matches(mobileNumberPattern) && customerMobileNum.length() == 10 && customerEmail.matches(emailPattern) && grandTotal > 0) {
            btnGenBillPrint.setEnabled(true);
        }
        else
            btnGenBillPrint.setEnabled(false);
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtCusName = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtCusMobileNum = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtCusEmail = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        txtProName = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtProPrice = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jSpinner1 = new javax.swing.JSpinner();
        jLabel13 = new javax.swing.JLabel();
        txtProTotal = new javax.swing.JTextField();
        btnClear = new javax.swing.JButton();
        btnAddToCart = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();
        lblGrandTotal = new javax.swing.JLabel();
        btnGenBillPrint = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(0, 0));
        setUndecorated(true);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Place Order");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 11, 87, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Bill ID:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 50, 40, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("--");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 48, 23));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Customer Details:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 76, -1, 23));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Name:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 73, -1));

        txtCusName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCusNameKeyReleased(evt);
            }
        });
        getContentPane().add(txtCusName, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 257, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Mobile Number: ");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, -1));

        txtCusMobileNum.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCusMobileNumKeyReleased(evt);
            }
        });
        getContentPane().add(txtCusMobileNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 257, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Email:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, -1, -1));

        txtCusEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCusEmailKeyReleased(evt);
            }
        });
        getContentPane().add(txtCusEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 257, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Category");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(299, 50, -1, -1));

        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(299, 76, 250, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Search");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 110, -1, -1));

        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });
        getContentPane().add(txtSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 140, 250, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 210, 250, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Name");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(581, 50, -1, -1));
        getContentPane().add(txtProName, new org.netbeans.lib.awtextra.AbsoluteConstraints(581, 76, 250, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("Price");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(857, 50, -1, -1));
        getContentPane().add(txtProPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(857, 76, 250, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setText("Quantity");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 110, -1, -1));

        jSpinner1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinner1StateChanged(evt);
            }
        });
        getContentPane().add(jSpinner1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 140, 250, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setText("Total");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 110, -1, -1));
        getContentPane().add(txtProTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 140, 250, -1));

        btnClear.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });
        getContentPane().add(btnClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 180, -1, -1));

        btnAddToCart.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnAddToCart.setText("Add to Cart");
        btnAddToCart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddToCartActionPerformed(evt);
            }
        });
        getContentPane().add(btnAddToCart, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 180, -1, -1));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Price", "Quantity", "Total"
            }
        ));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 230, 530, 360));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setText("Grand Total:");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 610, -1, -1));

        lblGrandTotal.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblGrandTotal.setText("PHP 00");
        getContentPane().add(lblGrandTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 610, -1, -1));

        btnGenBillPrint.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnGenBillPrint.setText("Generate Bill & Print");
        btnGenBillPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenBillPrintActionPerformed(evt);
            }
        });
        getContentPane().add(btnGenBillPrint, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 610, -1, -1));

        btnBack.setText("X");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        getContentPane().add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(1230, 20, 50, 46));

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bg.jpg"))); // NOI18N
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1310, 730));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddToCartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddToCartActionPerformed
        // TODO add your handling code here:
        String name = txtProName.getText();
        String price = txtProPrice.getText();
        String quantity = String.valueOf(jSpinner1.getValue());
        DefaultTableModel dtm = (DefaultTableModel) jTable2.getModel();
        dtm.addRow(new Object[] {name, price, quantity, productTotal});
        grandTotal += productTotal;
        lblGrandTotal.setText(String.valueOf(grandTotal));
        
        clearProductFields();
        validateFields();
    }//GEN-LAST:event_btnAddToCartActionPerformed

    private void btnGenBillPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenBillPrintActionPerformed
        // TODO add your handling code here:
        String customerName = txtCusName.getText();
        String customerMobileNum = txtCusMobileNum.getText();
        String customerEmail = txtCusEmail.getText();
        SimpleDateFormat dFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date date = new Date();
        String todayDate = dFormat.format(date);
        String total = String.valueOf(grandTotal);
        String createdBy = userEmail;
        Bill bill = new Bill();
        bill.setId(billId);
        bill.setName(customerName);
        bill.setMobileNumber(customerMobileNum);
        bill.setEmail(customerEmail);
        bill.setDate(todayDate);
        bill.setTotal(total);
        bill.setCreatedBy(createdBy);
        BillDao.save(bill);
        
        String path = "D:\\";
        com.itextpdf.text.Document doc = new com.itextpdf.text.Document();
        try {
            PdfWriter.getInstance(doc, new FileOutputStream(path + "" + billId + ".pdf"));
            doc.open();
            Paragraph cafeName = new Paragraph("                                                                         Cafe Management System\n");
            doc.add(cafeName);
            Paragraph starLine = new Paragraph("*************************************************************************************************");
            doc.add(starLine);
            Paragraph paragraph3 = new Paragraph("\tBill ID:" +billId+ "\nCustomer Name: " +customerName+ "Total Paid: " +grandTotal);
            doc.add(paragraph3);
            doc.add(starLine);
            
            PdfPTable tb1 = new PdfPTable(4);
            tb1.addCell("Name");
            tb1.addCell("Price");
            tb1.addCell("Quantity");
            tb1.addCell("Total");
            
            for (int i = 0; i < jTable2.getRowCount(); i++) {
                String n = jTable2.getValueAt(i, 0).toString();
                String d = jTable2.getValueAt(i, 1).toString();
                String r = jTable2.getValueAt(i, 2).toString();
                String q = jTable2.getValueAt(i, 3).toString();
                tb1.addCell(n);
                tb1.addCell(d);
                tb1.addCell(r);
                tb1.addCell(q);
            }
            doc.add(tb1);
            doc.add(starLine);
            Paragraph thanksMsg = new Paragraph("Thank You, Please Visit Again.");
            doc.add(thanksMsg);
            OpenPdf.openById(String.valueOf(billId));
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        doc.close();
        setVisible(false);
        new PlaceOrder(createdBy).setVisible(true);
    }//GEN-LAST:event_btnGenBillPrintActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        new Home(userEmail).setVisible(true);
    }//GEN-LAST:event_btnBackActionPerformed

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        // TODO add your handling code here:
        String name = txtSearch.getText();
        String category = (String) jComboBox1.getSelectedItem();
        filterProductByName(name, category);
    }//GEN-LAST:event_txtSearchKeyReleased

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        int index = jTable1.getSelectedRow();
        TableModel model = jTable1.getModel();
        String productName = model.getValueAt(index, 0).toString();
        Product product = ProductDao.getProductByname(productName);
        txtProName.setText(product.getName());
        txtProPrice.setText(product.getPrice());
        jSpinner1.setValue(1);
        txtProTotal.setText(product.getPrice());
        productPrice = Integer.parseInt(product.getPrice());
        productTotal = Integer.parseInt(product.getPrice());
        btnAddToCart.setEnabled(true);
    }//GEN-LAST:event_jTable1MouseClicked

    private void jSpinner1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinner1StateChanged
        // TODO add your handling code here:
        int quantity = (Integer) jSpinner1.getValue();
        if (quantity <= 1) {
            jSpinner1.setValue(1);
            quantity = 1;
        }
        productTotal = productPrice * quantity;
        txtProTotal.setText(String.valueOf(productTotal));
    }//GEN-LAST:event_jSpinner1StateChanged

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        // TODO add your handling code here:
        clearProductFields();
    }//GEN-LAST:event_btnClearActionPerformed

    private void txtCusNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCusNameKeyReleased
        // TODO add your handling code here:
        validateFields();
    }//GEN-LAST:event_txtCusNameKeyReleased

    private void txtCusMobileNumKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCusMobileNumKeyReleased
        // TODO add your handling code here:
        validateFields();
    }//GEN-LAST:event_txtCusMobileNumKeyReleased

    private void txtCusEmailKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCusEmailKeyReleased
        // TODO add your handling code here:
        validateFields();
    }//GEN-LAST:event_txtCusEmailKeyReleased

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:
        int index = jTable2.getSelectedRow();
        int a = JOptionPane.showConfirmDialog(null, "Do you want to remove this product", "Select", JOptionPane.YES_NO_OPTION);
        if (a == 0) {
            TableModel model = jTable2.getModel();
            String total = model.getValueAt(index, 3).toString();
            grandTotal -= Integer.parseInt(total);
            lblGrandTotal.setText(String.valueOf(grandTotal));
            ((DefaultTableModel) jTable2.getModel()).removeRow(index);
        }
    }//GEN-LAST:event_jTable2MouseClicked

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        // TODO add your handling code here:
        billId = Integer.parseInt(BillDao.getId());
        jLabel4.setText(BillDao.getId());
        ArrayList<Category> list = CategoryDao.getAllRecords();
        Iterator<Category> itr = list.iterator();
        while (itr.hasNext()) {
            Category categoryObj = itr.next();
            jComboBox1.addItem(categoryObj.getName());
        }
        String category = (String) jComboBox1.getSelectedItem();
        productNameByCategory(category);
        
    }//GEN-LAST:event_formComponentShown

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        
       String category = (String) jComboBox1.getSelectedItem();
       productNameByCategory(category);
    }//GEN-LAST:event_jComboBox1ActionPerformed

  
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PlaceOrder().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddToCart;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnGenBillPrint;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JLabel lblGrandTotal;
    private javax.swing.JTextField txtCusEmail;
    private javax.swing.JTextField txtCusMobileNum;
    private javax.swing.JTextField txtCusName;
    private javax.swing.JTextField txtProName;
    private javax.swing.JTextField txtProPrice;
    private javax.swing.JTextField txtProTotal;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
