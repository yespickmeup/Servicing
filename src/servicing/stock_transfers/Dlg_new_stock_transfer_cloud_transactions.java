/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicing.stock_transfers;

import servicing.branch_locations.S1_branch_locations;
import servicing.branch_locations.S4_branch_locations;
import servicing.receipts.Stock_transfers_items;
import servicing.synch.Synch_stock_transfers;
import servicing.users.MyUser;
import servicing.users.User_previlege_others;
import servicing.utils.Alert;
import servicing.utils.DateType;
import servicing.utils.Dlg_confirm_action;
import servicing.utils.MyConnection;
import com.jgoodies.binding.adapter.AbstractTableAdapter;
import com.jgoodies.binding.list.ArrayListModel;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import mijzcx.synapse.desk.utils.CloseDialog;
import mijzcx.synapse.desk.utils.FitIn;
import mijzcx.synapse.desk.utils.KeyMapping;
import mijzcx.synapse.desk.utils.KeyMapping.KeyAction;
import mijzcx.synapse.desk.utils.TableWidthUtilities;
import servicing.branch_locations.Branch_locations;
import synsoftech.fields.Button;
import synsoftech.fields.Field;
import synsoftech.panels.Loading;
import synsoftech.util.ImageRenderer;

/**
 *
 * @author Guinness
 */
public class Dlg_new_stock_transfer_cloud_transactions extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_new_stock_transfer_cloud_transactions
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

        public final Stock_transfers.to_stock_transfers stock_transfer;
        public final List<Stock_transfers_items.to_stock_transfers_items> stock_transfer_items;

        public OutputData(Stock_transfers.to_stock_transfers stock_transfer, List<Stock_transfers_items.to_stock_transfers_items> stock_transfer_items) {
            this.stock_transfer = stock_transfer;
            this.stock_transfer_items = stock_transfer_items;
        }

    }

//</editor-fold>
    //<editor-fold defaultstate="collapsed" desc=" Constructors ">
    private Dlg_new_stock_transfer_cloud_transactions(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    private Dlg_new_stock_transfer_cloud_transactions(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    public Dlg_new_stock_transfer_cloud_transactions() {
        super();
        setUndecorated(true);
        initComponents();
        myInit();

    }
    private Dlg_new_stock_transfer_cloud_transactions myRef;

    private void setThisRef(Dlg_new_stock_transfer_cloud_transactions myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_new_stock_transfer_cloud_transactions> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_new_stock_transfer_cloud_transactions create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_new_stock_transfer_cloud_transactions create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_new_stock_transfer_cloud_transactions dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_new_stock_transfer_cloud_transactions((java.awt.Frame) parent, false);
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
            Dlg_new_stock_transfer_cloud_transactions dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_new_stock_transfer_cloud_transactions((java.awt.Dialog) parent, false);
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

        Dlg_new_stock_transfer_cloud_transactions dialog = Dlg_new_stock_transfer_cloud_transactions.create(new javax.swing.JFrame(), true);
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
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_stock_transfers = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_stock_transfers_items = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tf_from_branch = new Field.Input();
        tf_from_location = new Field.Input();
        jPanel5 = new javax.swing.JPanel();
        jButton1 = new Button.Default();
        jLabel3 = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();
        jPanel6 = new javax.swing.JPanel();
        jButton2 = new Button.Success();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Transactions", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        tbl_stock_transfers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_stock_transfers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_stock_transfersMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_stock_transfers);

        jLabel1.setText("Total no. of rows:");

        jLabel2.setText("0");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Items", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        tbl_stock_transfers_items.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_stock_transfers_items.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_stock_transfers_itemsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_stock_transfers_items);

        jLabel7.setText("Total no. of rows:");

        jLabel8.setText("0");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addContainerGap())
        );

        jPanel4.setOpaque(false);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Location:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Branch:");

        tf_from_branch.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_from_branch.setFocusable(false);
        tf_from_branch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_from_branchMouseClicked(evt);
            }
        });
        tf_from_branch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_from_branchActionPerformed(evt);
            }
        });

        tf_from_location.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_from_location.setFocusable(false);
        tf_from_location.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_from_locationActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tf_from_branch)
                    .addComponent(tf_from_location, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tf_from_branch, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_from_location, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1))
        );

        jPanel5.setOpaque(false);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/icons_menu_maintenance/cloud-storage3.png"))); // NOI18N
        jButton1.setText("Download");
        jButton1.setFocusable(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setText("Status:");

        jProgressBar1.setRequestFocusEnabled(false);
        jProgressBar1.setString("");
        jProgressBar1.setStringPainted(true);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jButton1)
                .addGap(1, 1, 1)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel6.setOpaque(false);

        jButton2.setText("Post and Finalize");
        jButton2.setFocusable(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
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

    private void tf_from_branchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_from_branchMouseClicked

    }//GEN-LAST:event_tf_from_branchMouseClicked

    private void tf_from_branchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_from_branchActionPerformed

    }//GEN-LAST:event_tf_from_branchActionPerformed

    private void tf_from_locationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_from_locationActionPerformed

    }//GEN-LAST:event_tf_from_locationActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
//        
        download_transfers();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tbl_stock_transfersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_stock_transfersMouseClicked
        check_items();
    }//GEN-LAST:event_tbl_stock_transfersMouseClicked

    private void tbl_stock_transfers_itemsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_stock_transfers_itemsMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_stock_transfers_itemsMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        post_and_finalize();
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbl_stock_transfers;
    private javax.swing.JTable tbl_stock_transfers_items;
    private javax.swing.JTextField tf_from_branch;
    private javax.swing.JTextField tf_from_location;
    // End of variables declaration//GEN-END:variables
    private void myInit() {
        init_key();
//        System.setProperty("pool_host", "192.168.1.51");
//        System.setProperty("pool_db", "db_algorithm");
//
//        System.setProperty("cloud_host", "128.199.80.53");
//        System.setProperty("cloud_user", "smis2");
//        System.setProperty("cloud_password", "nopassword101");
//        System.setProperty("cloud_db", "db_algorithm");
        set_default_branch();
        init_tbl_stock_transfers();
        init_tbl_stock_transfers_items();
    }

    static int show_cost = 1;
    private void set_default_branch() {
        Branch_locations.to_branch_locations to = S4_branch_locations.ret_data();
        Field.Input f_br = (Field.Input) tf_from_branch;
        Field.Input f_lo = (Field.Input) tf_from_location;
        f_br.setText(to.branch);
        f_br.setId(to.branch_id);
        f_lo.setText(to.location);
        f_lo.setId("" + to.id);
        String wheree = " where user_id='" + MyUser.getUser_id() + "' and name like '" + "Stock Transfer - Show Cost - (Add)" + "' limit 1";
        List<User_previlege_others.to_user_previlege_others> datas = User_previlege_others.ret_data(wheree);
        if (datas.isEmpty()) {
            show_cost = 0;
        } else {
            show_cost = 1;
        }
    }

    public void do_pass() {

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

    private ArrayListModel tbl_stock_transfers_ALM;
    private Tblstock_transfersModel tbl_stock_transfers_M;

    private void init_tbl_stock_transfers() {
        tbl_stock_transfers_ALM = new ArrayListModel();
        tbl_stock_transfers_M = new Tblstock_transfersModel(tbl_stock_transfers_ALM);
        tbl_stock_transfers.getTableHeader().setPreferredSize(new Dimension(100, 40));
        tbl_stock_transfers.setModel(tbl_stock_transfers_M);
        tbl_stock_transfers.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_stock_transfers.setRowHeight(25);
        int[] tbl_widths_stock_transfers = {70, 100, 150, 150, 60, 40, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0, n = tbl_widths_stock_transfers.length; i < n; i++) {
            if (i == 2 || i == 3) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_stock_transfers, i, tbl_widths_stock_transfers[i]);
        }
        Dimension d = tbl_stock_transfers.getTableHeader().getPreferredSize();
        d.height = 25;
        tbl_stock_transfers.getTableHeader().setPreferredSize(d);
        tbl_stock_transfers.getTableHeader().setFont(new java.awt.Font("Arial", 0, 12));
        tbl_stock_transfers.setRowHeight(25);
        tbl_stock_transfers.setFont(new java.awt.Font("Arial", 0, 12));
        tbl_stock_transfers.getColumnModel().getColumn(5).setCellRenderer(new ImageRenderer());
        tbl_stock_transfers.getColumnModel().getColumn(6).setCellRenderer(new ImageRenderer());
    }

    private void loadData_stock_transfers(List<Stock_transfers.to_stock_transfers> acc) {
        tbl_stock_transfers_ALM.clear();
        tbl_stock_transfers_ALM.addAll(acc);
    }

    public static class Tblstock_transfersModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "Trans #", "Date", "From", "To", "Status", "", "", "", "", "", "", "from_location", "from_location_id"
        };
        
        public Tblstock_transfersModel(ListModel listmodel) {
            super(listmodel, COLUMNS);
        }
        
        @Override
        public boolean isCellEditable(int row, int column) {

            return false;
        }

        @Override
        public Class getColumnClass(int col) {
            if (col == 10) {
                return Boolean.class;
            }
            return Object.class;
        }

        @Override
        public Object getValueAt(int row, int col) {
            Stock_transfers.to_stock_transfers tt = (Stock_transfers.to_stock_transfers) getRow(row);
            switch (col) {
                case 0:
                    return " " + tt.transaction_no;
                case 1:
                    return " " + DateType.convert_slash_datetime(tt.date_added);
                case 2:
                    return " " + tt.from_branch + " : " + tt.from_location;
                case 3:
                    return " " + tt.to_branch + " : " + tt.to_location;
                case 4:
                    if (tt.status == 0) {
                        return " Posted";
                    } else if (tt.status == 2) {
                        return " Deleted";
                    } else {
                        return " Finalized";
                    }
                case 5:
                    return "/POS/icon_payment/eye.png";
                case 6:
                    return "/POS/icon_payment/select.png";
                case 7:
                    return " Print";
                case 8:
                    if (tt.is_uploaded == 0) {
                        return "/POS/icons4/cloud-storage-uploading-option (3).png";
                    } else if (tt.is_uploaded == 2) {
                        return "/POS/icons4/cloud-storage-uploading-option (4).png";
                    } else if (tt.is_uploaded == 3) {
                        return "/POS/icons4/cloud-storage-uploading-option (6)";
                    } else if (tt.is_uploaded == 4) {
                        return "/POS/icons4/cloud-storage-uploading-option (5).png";
                    } else {
                        return "/POS/icons4/cloud-storage-uploading-option (2).png";
                    }
                case 9:
                    return " Print";
                case 10:
                    return " Print";
                case 11:
                    return tt.from_location;
                default:
                    return tt.from_location_id;
            }
        }
    }

    private void ret_cloud_stock_transfer_records() {
        tbl_stock_transfers_items_ALM.clear();
//        jProgressBar1.setString("Establishing connection...");
//        jProgressBar1.setIndeterminate(true);
//        Thread t = new Thread(new Runnable() {
//
//            @Override
//            public void run() {
//                
//                jProgressBar1.setString("Finished...");
//                jProgressBar1.setIndeterminate(false);
//            }
//        });
//        t.start();
        int connected = MyConnection.check_cloud_connection();
        if (connected == 0) {
            jLabel6.setText("Failed to connect!");
        } else {
            try {
                jLabel6.setText("Connected");
                Thread.sleep(1000);
                Field.Input br = (Field.Input) tf_from_branch;
                jProgressBar1.setString("Retrieving records...");
                String where = " where is_uploaded=0 and at_branch_id<>'" + br.getId() + "' and to_branch_id='" + br.getId() + "'";
//                System.out.println(where);
                List<Stock_transfers.to_stock_transfers> datas = Stock_transfers.ret_data_cloud(where);
                for (Stock_transfers.to_stock_transfers trans : datas) {
                    List<Stock_transfers.to_stock_transfers> local_to = Stock_transfers.ret_data(" where transaction_no like '" + trans.transaction_no + "' limit 1 ");
                    if (!local_to.isEmpty()) {
                        Synch_stock_transfers.update_status_stock_transfer_cloud(trans.transaction_no, 1, trans.at_location_id);
                    }
                }
                
                List<Stock_transfers.to_stock_transfers> datas2 = Stock_transfers.ret_data_cloud(where);
                loadData_stock_transfers(datas2);
                jLabel2.setText("" + datas2.size());
            } catch (InterruptedException ex) {
                Logger.getLogger(Dlg_new_stock_transfer_cloud_transactions.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void select_transaction() {
        int row = tbl_stock_transfers.getSelectedRow();
        if (row < 0) {
            return;
        }
        final Stock_transfers.to_stock_transfers to = (Stock_transfers.to_stock_transfers) tbl_stock_transfers_ALM.get(row);

        int col = tbl_stock_transfers.getSelectedColumn();
        if (col == 5) {
            String where = " where stock_transfer_id='" + to.transaction_no + "' ";
            List<Stock_transfers_items.to_stock_transfers_items> items = Stock_transfers_items.ret_data_cloud(where);
            loadData_stock_transfers_items(items);
            jLabel8.setText("" + items.size());
//            jProgressBar1.setString("Finished...");
//            jProgressBar1.setIndeterminate(false);
//            jProgressBar1.setString("Loading...Please wait...");
//            jProgressBar1.setIndeterminate(true);
//            Thread t = new Thread(new Runnable() {
//
//                @Override
//                public void run() {
//
//                }
//            });
//            t.start();
        }
        if (col == 6) {
            final Stock_transfers.to_stock_transfers stock_transfer = to;
            final List<Stock_transfers_items.to_stock_transfers_items> stock_transfer_items = tbl_stock_transfers_items_ALM;
            if (stock_transfer_items.isEmpty()) {
                Alert.set(0, "Transaction does not have items added!");
                return;
            }
            Window p = (Window) this;
            Dlg_confirm_action nd = Dlg_confirm_action.create(p, true);
            nd.setTitle("");
            nd.do_pass("Proceed selecting transaction");
            nd.setCallback(new Dlg_confirm_action.Callback() {
                @Override
                public void ok(CloseDialog closeDialog, Dlg_confirm_action.OutputData data) {
                    closeDialog.ok();
                    ok2(stock_transfer, stock_transfer_items);
                }
            });
            nd.setLocationRelativeTo(this);
            nd.setVisible(true);
        }
    }

    private void ok2(Stock_transfers.to_stock_transfers stock_transfer, List<Stock_transfers_items.to_stock_transfers_items> stock_transfer_items) {
        if (callback != null) {
            callback.ok(new CloseDialog(this), new OutputData(stock_transfer, stock_transfer_items));
        }
    }
    //<editor-fold defaultstate="collapsed" desc=" Items ">
    private ArrayListModel tbl_stock_transfers_items_ALM;
    private Tblstock_transfers_itemsModel tbl_stock_transfers_items_M;

    private void init_tbl_stock_transfers_items() {
        tbl_stock_transfers_items_ALM = new ArrayListModel();
        tbl_stock_transfers_items_M = new Tblstock_transfers_itemsModel(tbl_stock_transfers_items_ALM);
        tbl_stock_transfers_items.getTableHeader().setPreferredSize(new Dimension(100, 40));
        tbl_stock_transfers_items.setModel(tbl_stock_transfers_items_M);
        tbl_stock_transfers_items.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_stock_transfers_items.setRowHeight(25);
        int[] tbl_widths_stock_transfers_items = {100, 100, 50, 50, 80, 80, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0, n = tbl_widths_stock_transfers_items.length; i < n; i++) {
            if (i == 1) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_stock_transfers_items, i, tbl_widths_stock_transfers_items[i]);
        }
        Dimension d = tbl_stock_transfers_items.getTableHeader().getPreferredSize();
        d.height = 25;
        tbl_stock_transfers_items.getTableHeader().setPreferredSize(d);
        tbl_stock_transfers_items.getTableHeader().setFont(new java.awt.Font("Arial", 0, 11));
        tbl_stock_transfers_items.setRowHeight(25);
        tbl_stock_transfers_items.setFont(new java.awt.Font("Arial", 0, 11));
    }

    private void loadData_stock_transfers_items(List<Stock_transfers_items.to_stock_transfers_items> acc) {
        tbl_stock_transfers_items_ALM.clear();
        tbl_stock_transfers_items_ALM.addAll(acc);
    }

    public static class Tblstock_transfers_itemsModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "Code", "Description", "Qty", "Unit", "Cost", "Price", "", "", "Status", "sub_classification_id", "product_qty", "unit", "conversion", "selling_price", "date_added", "user_name", "item_type", "status", "supplier", "fixed_price", "cost", "supplier_id", "multi_level_pricing", "vatable", "reorder_level", "markup", "barcodes", "brand", "brand_id", "model", "model_id", "selling_type", "branch", "branch_code", "location", "location_id"
        };

        public Tblstock_transfers_itemsModel(ListModel listmodel) {
            super(listmodel, COLUMNS);
        }

        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }

        @Override
        public Class getColumnClass(int col) {
            if (col == 1000) {
                return Boolean.class;
            }
            return Object.class;
        }

        @Override
        public Object getValueAt(int row, int col) {
            Stock_transfers_items.to_stock_transfers_items tt = (Stock_transfers_items.to_stock_transfers_items) getRow(row);
            switch (col) {
                case 0:
                    return " " + tt.barcode;
                case 1:
                    return " " + tt.description;
                case 2:
                    return " " + FitIn.fmt_woc(tt.product_qty);
                case 3:
                    String uom = tt.unit;
                    String[] list = uom.split(",");
                    String unit = "";
                    int o = 0;
                    for (String s : list) {
                        int i = s.indexOf(":");
                        unit = s.substring(1, i);
                        o++;
                    }
                    return " " + unit;
                case 4:
                    if (show_cost == 1) {
                        return " " + FitIn.fmt_wc_0(tt.cost);
                    } else {
                        return " ";
                    }

                case 5:
                    return " " + FitIn.fmt_wc_0(tt.selling_price);
                case 6:
                    return " Update";
                case 7:
                    return " Delete";
                case 8:
                    if (tt.status == 0 && tt.id == 0) {
                        return " ";
                    } else if (tt.status == 1) {
                        return " Finalized";
                    } else if (tt.status == 0 && tt.id != 0) {
                        return " Posted";
                    } else {
                        return " Deleted";
                    }
                case 9:
                    return tt.sub_classification_id;
                case 10:
                    return tt.product_qty;
                case 11:
                    return tt.unit;
                case 12:
                    return tt.conversion;
                case 13:
                    return tt.selling_price;
                case 14:
                    return tt.date_added;
                case 15:
                    return tt.user_name;
                case 16:
                    return tt.item_type;
                case 17:
                    return tt.status;
                case 18:
                    return tt.supplier;
                case 19:
                    return tt.fixed_price;
                case 20:
                    return tt.cost;
                case 21:
                    return tt.supplier_id;
                case 22:
                    return tt.multi_level_pricing;
                case 23:
                    return tt.vatable;
                case 24:
                    return tt.reorder_level;
                case 25:
                    return tt.markup;
                case 26:
                    return tt.barcodes;
                case 27:
                    return tt.brand;
                case 28:
                    return tt.brand_id;
                case 29:
                    return tt.model;
                case 30:
                    return tt.model_id;
                case 31:
                    return tt.selling_type;
                case 32:
                    return tt.branch;
                case 33:
                    return tt.branch_code;
                case 34:
                    return tt.location;
                default:
                    return tt.location_id;
            }
        }
    }
    //</editor-fold>

    private void post_and_finalize() {
        int row = tbl_stock_transfers.getSelectedRow();
        if (row < 0) {
            return;
        }
        final Stock_transfers.to_stock_transfers to = (Stock_transfers.to_stock_transfers) tbl_stock_transfers_ALM.get(row);
        List<Stock_transfers.to_stock_transfers> local_to = Stock_transfers.ret_data(" where transaction_no like '" + to.transaction_no + "' ");
        if (!local_to.isEmpty()) {
            Alert.set(0, "Transaction already finalized!");
            return;
        }
        Window p = (Window) this;
        Dlg_confirm_action nd = Dlg_confirm_action.create(p, true);
        nd.setTitle("");
        nd.do_pass("Proceed posting and finalizing?");
        nd.setCallback(new Dlg_confirm_action.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_confirm_action.OutputData data) {
                closeDialog.ok();
                st_post_and_finalize();
//                proceed_post_and_finalize(to);
//                jProgressBar1.setString("Loading...Please wait...");
//                jProgressBar1.setIndeterminate(true);
//                jButton1.setEnabled(false);
//                jButton2.setEnabled(false);
//                Thread t = new Thread(new Runnable() {
//
//                    @Override
//                    public void run() {
//                        jButton1.setEnabled(true);
//                        jButton2.setEnabled(true);
//                        jProgressBar1.setString("Finished...");
//                        jProgressBar1.setIndeterminate(false);
//                    }
//                });
//                t.start();

            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);
    }

    private void proceed_post_and_finalize() {
        int row = tbl_stock_transfers.getSelectedRow();
        if (row < 0) {
            return;
        }
        final Stock_transfers.to_stock_transfers to = (Stock_transfers.to_stock_transfers) tbl_stock_transfers_ALM.get(row);
        int id = 0;
        final String transaction_no = to.transaction_no;
        String user_name = to.user_name;
        String date_added = to.date_added;
        String remarks = to.remarks;
        String to_branch = to.to_branch;
        String to_branch_id = to.to_branch_id;
        String to_location = to.to_location;
        String to_location_id = to.to_location_id;

        String from_branch = to.from_branch;
        String from_branch_id = to.from_branch_id;
        String from_location = to.from_location;
        String from_location_id = to.from_location_id;

        String at_branch = to.at_branch;
        String at_branch_id = to.at_branch_id;
        String at_location = to.at_location;
        String at_location_id = to.at_location_id;
        int is_uploaded = 1;
        String finalized_by_id = MyUser.getUser_id();
        String finalized_by = MyUser.getUser_screen_name();
        final Stock_transfers.to_stock_transfers rpt = new Stock_transfers.to_stock_transfers(id, transaction_no, user_name, date_added, remarks,
                                                                                              to_branch, to_branch_id, to_location, to_location_id, from_branch, from_branch_id, from_location, from_location_id, 0, false,
                                                                                              at_branch, at_branch_id, at_location, at_location_id, is_uploaded, finalized_by_id, finalized_by);
        List<Stock_transfers_items.to_stock_transfers_items> datas = tbl_stock_transfers_items_ALM;
        if (datas.isEmpty()) {
            Alert.set(0, "No Item Added!");
            return;
        }

        Stock_transfers.add_stock_transfers(rpt, datas);

        Stock_transfers.finalize(rpt, datas, finalized_by_id, finalized_by);
        Synch_stock_transfers.update_status_stock_transfer(rpt.transaction_no, 1);
        Synch_stock_transfers.update_status_stock_transfer_cloud(rpt.transaction_no, 1, rpt.at_location_id);

        Alert.set(0, "Stock Transfer Posted and Finalized");
        ret_cloud_stock_transfer_records();
    }

    private void download_transfers() {
        Loader loader = new Loader(this);
        loader.execute();
    }

    //<editor-fold defaultstate="collapsed" desc=" Loader Download ">
    public class Loader extends SwingWorker {

        private Loading dialog;

        public Loader(JDialog dlg) {

            dialog = new Loading();
            Toolkit tk = Toolkit.getDefaultToolkit();
            int xSize = ((int) tk.getScreenSize().
                    getWidth());
            int ySize = ((int) tk.getScreenSize().
                    getHeight());
            dialog.setSize(xSize, ySize);
            dialog.setPreferredSize(new Dimension(xSize, ySize));
            dialog.setAlwaysOnTop(true);
            addPropertyChangeListener(new PropertyChangeListener() {
                @Override
                public void propertyChange(PropertyChangeEvent evt) {
                    if ("state".equals(evt.getPropertyName())) {
                        if (getState() == SwingWorker.StateValue.STARTED) {
                            SwingUtilities.invokeLater(new Runnable() {
                                @Override
                                public void run() {
                                    if (getState() == SwingWorker.StateValue.STARTED) {
                                        dialog.setVisible(true);
                                    }
                                }
                            });
                        }
                    }
                }
            });
        }

        @Override
        protected Object doInBackground() throws Exception {
            ret_cloud_stock_transfer_records();
            return null;
        }

        @Override
        protected void done() {
            dialog.dispose();
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                }
            });
        }
    }

    //</editor-fold>
    private void check_items() {
        Loader_items loader = new Loader_items(this);
        loader.execute();
    }

    //<editor-fold defaultstate="collapsed" desc=" Loader Check Items ">
    public class Loader_items extends SwingWorker {

        private Loading dialog;

        public Loader_items(JDialog dlg) {

            dialog = new Loading();
            Toolkit tk = Toolkit.getDefaultToolkit();
            int xSize = ((int) tk.getScreenSize().
                    getWidth());
            int ySize = ((int) tk.getScreenSize().
                    getHeight());
            dialog.setSize(xSize, ySize);
            dialog.setPreferredSize(new Dimension(xSize, ySize));
            dialog.setAlwaysOnTop(true);
            addPropertyChangeListener(new PropertyChangeListener() {
                @Override
                public void propertyChange(PropertyChangeEvent evt) {
                    if ("state".equals(evt.getPropertyName())) {
                        if (getState() == SwingWorker.StateValue.STARTED) {
                            SwingUtilities.invokeLater(new Runnable() {
                                @Override
                                public void run() {
                                    if (getState() == SwingWorker.StateValue.STARTED) {
                                        dialog.setVisible(true);
                                    }
                                }
                            });
                        }
                    }
                }
            });
        }

        @Override
        protected Object doInBackground() throws Exception {
            select_transaction();
            return null;
        }

        @Override
        protected void done() {
            dialog.dispose();
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                }
            });
        }
    }

    //</editor-fold>
    private void st_post_and_finalize() {
        Loader_finalize loader = new Loader_finalize(this);
        loader.execute();
    }

    //<editor-fold defaultstate="collapsed" desc=" Loader Post And Finalize ">
    public class Loader_finalize extends SwingWorker {

        private Loading dialog;

        public Loader_finalize(JDialog dlg) {

            dialog = new Loading();
            Toolkit tk = Toolkit.getDefaultToolkit();
            int xSize = ((int) tk.getScreenSize().
                    getWidth());
            int ySize = ((int) tk.getScreenSize().
                    getHeight());
            dialog.setSize(xSize, ySize);
            dialog.setPreferredSize(new Dimension(xSize, ySize));
            dialog.setAlwaysOnTop(true);
            addPropertyChangeListener(new PropertyChangeListener() {
                @Override
                public void propertyChange(PropertyChangeEvent evt) {
                    if ("state".equals(evt.getPropertyName())) {
                        if (getState() == SwingWorker.StateValue.STARTED) {
                            SwingUtilities.invokeLater(new Runnable() {
                                @Override
                                public void run() {
                                    if (getState() == SwingWorker.StateValue.STARTED) {
                                        dialog.setVisible(true);
                                    }
                                }
                            });
                        }
                    }
                }
            });
        }

        @Override
        protected Object doInBackground() throws Exception {
            proceed_post_and_finalize();
            return null;
        }

        @Override
        protected void done() {
            dialog.dispose();
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                }
            });
        }
    }

    //</editor-fold>
}
