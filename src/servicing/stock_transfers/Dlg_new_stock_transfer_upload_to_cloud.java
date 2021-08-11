/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicing.stock_transfers;

import servicing.receipts.Stock_transfers_items;
import servicing.synch.Synch_stock_transfers;
import servicing.utils.Alert;
import servicing.utils.MyConnection;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import mijzcx.synapse.desk.utils.CloseDialog;
import mijzcx.synapse.desk.utils.KeyMapping;
import mijzcx.synapse.desk.utils.KeyMapping.KeyAction;
import synsoftech.fields.Button;

/**
 *
 * @author Guinness
 */
public class Dlg_new_stock_transfer_upload_to_cloud extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_confirm_action
     */
    //<editor-fold defaultstate="collapsed" desc=" callback ">
    private Callback callback;

    public void setCallback(Callback callback) {
        this.callback = callback;

    }

    public static interface Callback {

        void ok(CloseDialog closeDialog, OutputData data);
    }

    public static class InputData {
    }

    public static class OutputData {
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Constructors ">
    private Dlg_new_stock_transfer_upload_to_cloud(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    private Dlg_new_stock_transfer_upload_to_cloud(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    public Dlg_new_stock_transfer_upload_to_cloud() {
        super();
        setUndecorated(true);
        initComponents();
        myInit();

    }
    private Dlg_new_stock_transfer_upload_to_cloud myRef;

    private void setThisRef(Dlg_new_stock_transfer_upload_to_cloud myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_new_stock_transfer_upload_to_cloud> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_new_stock_transfer_upload_to_cloud create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_new_stock_transfer_upload_to_cloud create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_new_stock_transfer_upload_to_cloud dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_new_stock_transfer_upload_to_cloud((java.awt.Frame) parent, false);
                dialog.setModalityType(modalType);
                dialogContainer.put(parent, dialog);
                java.util.logging.Logger.getAnonymousLogger().log(Level.INFO, "instances: {0}", dialogContainer.size());
                dialog.setThisRef(dialog);
                return dialog;
            } else {
                dialog.setModalityType(modalType);
                return dialog;
            }

        }

        if (parent instanceof java.awt.Dialog) {
            Dlg_new_stock_transfer_upload_to_cloud dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_new_stock_transfer_upload_to_cloud((java.awt.Dialog) parent, false);
                dialog.setModalityType(modalType);
                dialogContainer.put(parent, dialog);
                java.util.logging.Logger.getAnonymousLogger().log(Level.INFO, "instances: {0}", dialogContainer.size());
                dialog.setThisRef(dialog);
                return dialog;
            } else {
                dialog.setModalityType(modalType);
                return dialog;
            }

        }

        return null;

    }
    //</editor-fold>    

    //<editor-fold defaultstate="collapsed" desc=" main ">
    public static void main(String args[]) {

        try {
            javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        Dlg_new_stock_transfer_upload_to_cloud dialog = Dlg_new_stock_transfer_upload_to_cloud.create(new javax.swing.JFrame(), true);
        dialog.setVisible(true);

    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" added ">
    @Override
    public void setVisible(boolean visible) {
        super.setVisible(visible);
        if (visible == true) {
            getContentPane().removeAll();
            initComponents();
            myInit();
            repaint();
        }

    }

    public javax.swing.JPanel getSurface() {
        return (javax.swing.JPanel) getContentPane();
    }

    public void nullify() {
        myRef.setVisible(false);
        myRef = null;
    }
    //</editor-fold>

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new Button.Primary();
        jButton2 = new Button.Default();
        jPanel2 = new javax.swing.JPanel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jButton3 = new javax.swing.JButton();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jProgressBar1 = new javax.swing.JProgressBar();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setText("Yes");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton2.setText("Cancel");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jCheckBox1.setText("1.) Check Connection");
        jCheckBox1.setFocusable(false);

        jButton3.setText("Retry");
        jButton3.setEnabled(false);
        jButton3.setFocusable(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jCheckBox2.setText("2.) Upload Transaction");
        jCheckBox2.setFocusable(false);

        jCheckBox3.setText("3.) Finished");
        jCheckBox3.setFocusable(false);

        jProgressBar1.setRequestFocusEnabled(false);
        jProgressBar1.setString("");
        jProgressBar1.setStringPainted(true);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jCheckBox1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3))
                    .addComponent(jCheckBox3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jCheckBox2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox1)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Upload Transaction to Cloud?");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(99, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35))
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

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        disposed();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        check_connection();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        check_connection();
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JProgressBar jProgressBar1;
    // End of variables declaration//GEN-END:variables

    private void myInit() {
        init_key();
    }
    String stock_transfer_no = "";
    String at_location_id = "";
    int status = 0;

    public void do_pass(String transaction_no) {
        stock_transfer_no = transaction_no;
//        jXLabel1.setText(stmt);
    }
    Stock_transfers.to_stock_transfers stock_transfer = null;

    public void do_update(Stock_transfers.to_stock_transfers rpt) {
        stock_transfer = rpt;

        jLabel1.setText("Push Updates to Cloud?");
        jCheckBox2.setText("2.) Update Transaction");
    }

    public void do_update_new_item(String transaction_no, String at_loc_id) {
        stock_transfer_no = transaction_no;
        at_location_id = at_loc_id;

        jLabel1.setText("Push Item Updates to Cloud?");
        jCheckBox2.setText("2.) Update Item/s Transaction");
    }

    // <editor-fold defaultstate="collapsed" desc="Key">
    private void disposed() {
        this.dispose();
    }

    private void init_key() {
        KeyMapping.mapKeyWIFW(getSurface(),
                KeyEvent.VK_ESCAPE, new KeyAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
//                btn_0.doClick();
                disposed();
            }
        });
    }
    // </editor-fold>

    private void ok() {
        if (callback != null) {
            callback.ok(new CloseDialog(this), new OutputData());
        }
    }

    private void check_connection() {
        jProgressBar1.setString("1.) Checking Connection...");
        jProgressBar1.setIndeterminate(true);
        jButton3.setEnabled(false);
        jButton1.setEnabled(false);
        jCheckBox1.setForeground(new Color(0, 0, 0));
        Thread t = new Thread(new Runnable() {

            @Override
            public void run() {
                int connected = MyConnection.check_cloud_connection();
                if (connected == 0) {
                    jButton3.setEnabled(true);
                    jCheckBox1.setForeground(Color.red);
                    jProgressBar1.setString("Failed to Connect!");

                } else {
                    jCheckBox1.setForeground(Color.BLUE);
                    jCheckBox1.setSelected(true);
                    jProgressBar1.setString("Connection Established!");
                    try {
                        Thread.sleep(500);
                        if (jCheckBox2.getText().equalsIgnoreCase("2.) Upload Transaction")) {
                            upload_transaction();
                        }
                        if (jCheckBox2.getText().equalsIgnoreCase("2.) Update Transaction")) {
                            updated_transaction();
                        }
                        if (jCheckBox2.getText().equalsIgnoreCase("2.) Update Item/s Transaction")) {
                            updated_item_transaction();
                        }
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Dlg_new_stock_transfer_upload_to_cloud.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }

                jProgressBar1.setIndeterminate(false);
            }
        });
        t.start();
    }

    private void upload_transaction() {

        jProgressBar1.setString("2.) Uploading Transaction...");
        jProgressBar1.setIndeterminate(true);
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                List<Stock_transfers.to_stock_transfers> stock_transfers = Stock_transfers.ret_data(" where transaction_no='" + stock_transfer_no + "' ");
                List<Stock_transfers_items.to_stock_transfers_items> items = Stock_transfers_items.ret_data("where stock_transfer_id ='" + stock_transfer_no + "' ");
                Synch_stock_transfers.post_stock_transfer(stock_transfers, items);
                Synch_stock_transfers.update_status_stock_transfer(stock_transfer_no, 1);
                jCheckBox1.setForeground(Color.BLUE);
                jCheckBox2.setSelected(true);

                jProgressBar1.setString("Upload Successful!");

                try {
                    Thread.sleep(500);
                    jCheckBox3.setSelected(true);
                    jProgressBar1.setString("Finished...");
                    Alert.set(1, "");
                    ok1();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Dlg_new_stock_transfer_upload_to_cloud.class.getName()).log(Level.SEVERE, null, ex);
                }

                jProgressBar1.setIndeterminate(false);
                ok();
            }
        });
        t.start();

    }

    private void updated_transaction() {

        jProgressBar1.setString("2.) Updating Transaction...");
        jProgressBar1.setIndeterminate(true);
        Thread t = new Thread(new Runnable() {

            @Override
            public void run() {

                Synch_stock_transfers.update_stock_transfers(stock_transfer);
                Synch_stock_transfers.update_status_stock_transfer(stock_transfer.transaction_no, 1);
                jCheckBox1.setForeground(Color.BLUE);
                jCheckBox2.setSelected(true);

                jProgressBar1.setString("Update Successful!");
                jCheckBox2.setForeground(Color.BLUE);
                try {
                    Thread.sleep(500);
                    jCheckBox3.setSelected(true);
                    jCheckBox3.setForeground(Color.BLUE);
                    jProgressBar1.setString("Finished...");
                    Alert.set(1, "");
                    ok1();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Dlg_new_stock_transfer_upload_to_cloud.class.getName()).log(Level.SEVERE, null, ex);
                }

                jProgressBar1.setIndeterminate(false);
                ok();
            }
        });
        t.start();

    }

    private void updated_item_transaction() {

        jProgressBar1.setString("2.) Updating Transaction...");
        jProgressBar1.setIndeterminate(true);
        Thread t = new Thread(new Runnable() {

            @Override
            public void run() {

                List<Stock_transfers.to_stock_transfers> stock_transfers = Stock_transfers.ret_data(" where transaction_no='" + stock_transfer_no + "' ");
                List<Stock_transfers_items.to_stock_transfers_items> items = Stock_transfers_items.ret_data(" where stock_transfer_id ='" + stock_transfer_no + "' ");
                List<Stock_transfers_items.to_stock_transfers_items> cloud_items = Stock_transfers_items.ret_data_cloud(" where stock_transfer_id ='" + stock_transfer_no + "' and at_location_id ='" + at_location_id + "' ");

                List<Stock_transfers_items.to_stock_transfers_items> items_added = new ArrayList();
                List<Stock_transfers_items.to_stock_transfers_items> items_edited = new ArrayList();
                List<Stock_transfers_items.to_stock_transfers_items> items_deleted = new ArrayList();

                for (Stock_transfers_items.to_stock_transfers_items item : items) {
                    int item_exists = 0;
                    for (Stock_transfers_items.to_stock_transfers_items c_item : cloud_items) {
                        if (item.barcode.equalsIgnoreCase(c_item.barcode) && item.date_added.equalsIgnoreCase(c_item.date_added)) {
                            item_exists = 1;
                            if (item.product_qty != c_item.product_qty || !item.serial_no.equalsIgnoreCase(c_item.serial_no)) {
                                c_item.setProduct_qty(item.product_qty);
                                c_item.setSerial_no(item.serial_no);
                                items_edited.add(c_item);
                            }
                            break;
                        }
                    }

                    if (item_exists == 0) {
                        items_added.add(item);
                    }
                }

                for (Stock_transfers_items.to_stock_transfers_items c_item : cloud_items) {
                    int item_deleted = 1;
                    for (Stock_transfers_items.to_stock_transfers_items item : items) {
                        if (item.barcode.equalsIgnoreCase(c_item.barcode) && item.date_added.equalsIgnoreCase(c_item.date_added)) {
                            item_deleted = 0;
                        }
                    }
                    if (item_deleted == 1) {
                        items_deleted.add(c_item);
                    }
                }

                Synch_stock_transfers.update_items_stock_transfer(stock_transfer, items_added, items_edited, items_deleted);
                Synch_stock_transfers.update_status_stock_transfer(stock_transfer_no, 1);
                jCheckBox1.setForeground(Color.BLUE);
                jCheckBox2.setSelected(true);

                jProgressBar1.setString("Update Successful!");
                jCheckBox2.setForeground(Color.BLUE);
                try {
                    Thread.sleep(500);
                    jCheckBox3.setSelected(true);
                    jCheckBox3.setForeground(Color.BLUE);
                    jProgressBar1.setString("Finished...");
                    Alert.set(1, "");
                    ok1();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Dlg_new_stock_transfer_upload_to_cloud.class.getName()).log(Level.SEVERE, null, ex);
                }

                jProgressBar1.setIndeterminate(false);
                ok();
            }
        });
        t.start();

    }

    private void ok1() {
        if (callback != null) {
            callback.ok(new CloseDialog(this), new OutputData());
        }
    }
}
