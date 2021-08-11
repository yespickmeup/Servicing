/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicing.inventory;

import servicing.inventory_assembly.Inventory_assembly;
import servicing.utils.Alert;
import servicing.utils.Dlg_confirm_action;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import javax.swing.JDialog;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import mijzcx.synapse.desk.utils.CloseDialog;
import mijzcx.synapse.desk.utils.FitIn;
import mijzcx.synapse.desk.utils.KeyMapping;
import mijzcx.synapse.desk.utils.KeyMapping.KeyAction;
import synsoftech.fields.Button;
import synsoftech.panels.Loading;

/**
 *
 * @author Guinness
 */
public class Dlg_inventory_cloud_transactions_local extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_inventory_cloud_transactions
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
    private Dlg_inventory_cloud_transactions_local(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    private Dlg_inventory_cloud_transactions_local(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    public Dlg_inventory_cloud_transactions_local() {
        super();
        setUndecorated(true);
        initComponents();
        myInit();

    }
    private Dlg_inventory_cloud_transactions_local myRef;

    private void setThisRef(Dlg_inventory_cloud_transactions_local myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_inventory_cloud_transactions_local> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_inventory_cloud_transactions_local create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_inventory_cloud_transactions_local create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_inventory_cloud_transactions_local dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_inventory_cloud_transactions_local((java.awt.Frame) parent, false);
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
            Dlg_inventory_cloud_transactions_local dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_inventory_cloud_transactions_local((java.awt.Dialog) parent, false);
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

        Dlg_inventory_cloud_transactions_local dialog = Dlg_inventory_cloud_transactions_local.create(new javax.swing.JFrame(), true);
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
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();
        jButton2 = new Button.Success();
        jPanel3 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Newly Added Items", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 24))); // NOI18N

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("0");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Updated Items", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 24))); // NOI18N

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("0");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanel6.setOpaque(false);

        jLabel1.setText("Upload Status:");

        jProgressBar1.setString("");
        jProgressBar1.setStringPainted(true);

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton2.setText("Check and Download");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jProgressBar1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(0, 13, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(206, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(232, 232, 232))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(90, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Summary", jPanel2);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 722, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 470, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Details", jPanel3);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 727, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 501, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
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
        // TODO add your handling code hercheck_items()
        check_items();
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
    private void myInit() {
//
//        System.setProperty("pool_db", "db_smis_dumaguete_refreshments_store");
//        System.setProperty("pool_host", "localhost");
//        System.setProperty("main_branch", "false");
//        System.setProperty("active_branches", "10");
//        System.setProperty("cloud_host", "128.199.80.53");
//        System.setProperty("cloud_user", "smis2");
//        System.setProperty("cloud_password", "nopassword101");
//        System.setProperty("cloud_db", "db_smis_dumaguete_refreshments_development");
//        System.setProperty("main_branch", "false");
//        System.setProperty("receipt_printing_enabled2", "true");

        init_key();

        check_for_upload();
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

    List<Inventory.to_inventory> to_add = new ArrayList();
    List<Inventory.to_inventory> to_update = new ArrayList();
    List<Inventory.to_inventory> to_delete = new ArrayList();
    List<Inventory_assembly.to_inventory_assembly> assembly_cloud_to_add = new ArrayList();
    List<Inventory_assembly.to_inventory_assembly> assembly_cloud_to_delete = new ArrayList();

    private void check_for_upload() {
        to_add.clear();
        to_update.clear();
        to_delete.clear();
        assembly_cloud_to_add.clear();
        assembly_cloud_to_delete.clear();
        String cloud_host = System.getProperty("cloud_host", "");
        if (!cloud_host.isEmpty()) {
            System.out.println("Retrieving records...");
            String where = " where is_uploaded=0 or is_uploaded=2 ";
            List<Inventory.to_inventory> inventory_cloud = Inventory.ret_data22_cloud("");
            List<Inventory.to_inventory> inventory_local = Inventory.ret_data22("");
            System.out.println("Cloud Items: " + inventory_cloud.size());
            System.out.println("Local Items: " + inventory_local.size());

            System.out.println("Checking records....");

            List<Inventory_assembly.to_inventory_assembly> assembly_local = Inventory_assembly.ret_data("");
            List<Inventory_assembly.to_inventory_assembly> assembly_cloud = Inventory_assembly.ret_data_cloud("");

            for (Inventory_assembly.to_inventory_assembly assembly_c : assembly_cloud) {
                int exists = 0;
                for (Inventory_assembly.to_inventory_assembly assembly_l : assembly_local) {
                    if ((assembly_c.main_item_code.equalsIgnoreCase(assembly_l.main_item_code)) && assembly_c.item_code.equalsIgnoreCase(assembly_l.item_code)) {
                        exists = 1;
                        break;
                    }
                }
                if (exists == 0) {
                    assembly_cloud_to_add.add(assembly_c);
                    System.out.println("Main Item: " + assembly_c.main_item_code + "    New Item: " + assembly_c.item_code + " " + assembly_c.description);
                }
            }

            for (Inventory_assembly.to_inventory_assembly assembly_l : assembly_local) {
                int exists = 0;
                for (Inventory_assembly.to_inventory_assembly assembly_c : assembly_cloud) {
                    if ((assembly_l.main_item_code.equalsIgnoreCase(assembly_c.main_item_code)) && assembly_l.item_code.equalsIgnoreCase(assembly_c.item_code)) {
                        exists = 1;
                        break;
                    }
                }

                if (exists == 0) {
                    assembly_cloud_to_delete.add(assembly_l);
                    System.out.println("Main Item: " + assembly_l.main_item_code);
                    System.out.println("    New Item: " + assembly_l.item_code + " " + assembly_l.description);
                }
            }

            for (Inventory.to_inventory cloud : inventory_cloud) {
                int exists = 0;
                Inventory.to_inventory to = null;
                for (Inventory.to_inventory local : inventory_local) {
                    if (cloud.barcode.equals(local.barcode)) {
                        exists = 1;
                        to = local;
                        break;
                    }
                }

                if (exists == 0) {
                    to_add.add(cloud);
                } else {
                    int update = 0;
                    if (!cnull(cloud.description).equalsIgnoreCase(cnull(to.description))
                            || !cnull(cloud.category).equalsIgnoreCase(cnull(to.category))
                            || !cnull(cloud.classification).equalsIgnoreCase(cnull(to.classification))
                            || !cnull(cloud.sub_classification).equalsIgnoreCase(cnull(to.sub_classification))
                            || !cnull(cloud.item_type).equalsIgnoreCase(cnull(to.item_type))
                            || !cnull(cloud.brand).equalsIgnoreCase(cnull(to.brand))
                            || !cnull(cloud.model).equalsIgnoreCase(cnull(to.model))
                            || !cnull(cloud.barcodes).equalsIgnoreCase(cnull(to.barcodes))
                            || !cnull(cloud.unit).equalsIgnoreCase(cnull(to.unit))
                            || (cloud.selling_price != to.selling_price)
                            || (cloud.conversion != to.conversion)
//                            || (cloud.allow_negative_inventory != to.allow_negative_inventory)
//                            || (cloud.auto_order != to.auto_order)
                            || !cnull(cloud.generic_name).equalsIgnoreCase(cnull(to.generic_name))) {
                        update = 1;
                    }
                    if (update == 1) {
                        to_update.add(cloud);
                    }
                }
            }

            for (Inventory.to_inventory lo : inventory_local) {
                int exists = 0;
                for (Inventory.to_inventory cl : inventory_cloud) {
                    if (lo.barcode.equalsIgnoreCase(cl.barcode)) {
                        exists = 1;
                        break;
                    }
                }
                if (exists == 0) {
                    to_delete.add(lo);

                }
            }

            System.out.println("Finished checking records...");
            System.out.println("----------------------------------------------");
            System.out.println("Items to Add: " + to_add.size());
            System.out.println("Items to Update: " + to_update.size());
            System.out.println("Items to Delete: " + to_delete.size());

            System.out.println("Saving items...");
            jLabel11.setText("" + to_add.size());
            jLabel12.setText("" + to_update.size());

            System.out.println("----------------------------------------------");
            System.out.println("Assembly Local: " + assembly_local.size());
            System.out.println("Assembly Cloud: " + assembly_cloud.size());
            System.out.println("New Item Assembly: " + assembly_cloud_to_add.size());
            System.out.println("To Delete: " + assembly_cloud_to_delete.size());

            jLabel11.setText(FitIn.fmt_woc(to_add.size()));
            jLabel12.setText(FitIn.fmt_woc(to_update.size()));

        }
    }

    private void upload_items() {

        String cloud_host = System.getProperty("cloud_host", "");
        if (!cloud_host.isEmpty()) {
            Window p = (Window) this;
            Dlg_confirm_action nd = Dlg_confirm_action.create(p, true);
            nd.setTitle("");
            nd.setCallback(new Dlg_confirm_action.Callback() {

                @Override
                public void ok(CloseDialog closeDialog, Dlg_confirm_action.OutputData data) {
                    closeDialog.ok();
                    jProgressBar1.setString("Loading...Please wait...");
                    jProgressBar1.setIndeterminate(true);
//                    jButton1.setEnabled(false);
                    Thread t = new Thread(new Runnable() {

                        @Override
                        public void run() {
                            System.out.println("Adding new items...");
                            for (Inventory.to_inventory to : to_add) {
                                System.out.println("    Barcode: " + to.barcode + " - Description: " + to.description);
//                                Inventory.add_inventory_cloud(to);
                            }
                            System.out.println("Finished adding new items...");

                            System.out.println("Updating items...");
                            for (Inventory.to_inventory to : to_update) {
                                System.out.println("    Barcode: " + to.barcode + " - Description: " + to.description);
//                                Inventory.edit_inventory_cloud(to);
                            }
                            Alert.set(0, "Upload successfull!");
                            check_for_upload();
                            System.out.println("Finished updating items...");
//                            jButton1.setEnabled(true);
                            jProgressBar1.setString("Finished...");
                            jProgressBar1.setIndeterminate(false);

                        }
                    });
                    t.start();

                }
            });
            nd.setLocationRelativeTo(this);
            nd.setVisible(true);

        }
    }

    private void check_items() {
        String cloud_host = System.getProperty("cloud_host", "");
        if (!cloud_host.isEmpty()) {
            Window p = (Window) this;
            Dlg_confirm_action nd = Dlg_confirm_action.create(p, true);
            nd.setTitle("");

            nd.setCallback(new Dlg_confirm_action.Callback() {

                @Override
                public void ok(CloseDialog closeDialog, Dlg_confirm_action.OutputData data) {
                    closeDialog.ok();
                    download_local();
//                    jProgressBar1.setString("Loading...Please wait...");
//                    jProgressBar1.setIndeterminate(true);
////                    jButton1.setEnabled(false);
//                    jButton2.setEnabled(false);
//                    Thread t = new Thread(new Runnable() {
//
//                        @Override
//                        public void run() {
//                           
//
////                            jButton1.setEnabled(true);
//                            jButton2.setEnabled(true);
//                            jProgressBar1.setString("Finished...");
//                            jProgressBar1.setIndeterminate(false);
//                        }
//                    });
//                    t.start();
                }
            });
            nd.setLocationRelativeTo(this);
            nd.setVisible(true);
        }
    }

    private String cnull(String var) {
        if (var == null) {
            var = "";
        }
        return var;
    }

    private void download_local() {
        Loader_download_local loader = new Loader_download_local(this);
        loader.execute();
    }

    private void proceed_download_local() {

        for (Inventory.to_inventory to : to_add) {
            System.out.println("  To Add =  Barcode: " + to.barcode + " - Description: " + to.description);
            List<Inventory.to_inventory> check_inv = Inventory.ret_data22(" where barcode='" + to.barcode + "' ");
            if (check_inv.isEmpty()) {
                Inventory.add_inventory(to);
            }

        }

        for (Inventory.to_inventory to : to_delete) {
            System.out.println("   To Delete = Barcode: " + to.barcode + " - Description: " + to.description);
            Inventory.delete_inventory(to);
        }

        System.out.println("Updating items...");
        String main_branch = System.getProperty("main_branch", "false");
        String receipt_printing_enabled2 = System.getProperty("receipt_printing_enabled2", "false");
        if (main_branch.equalsIgnoreCase("false") && receipt_printing_enabled2.equalsIgnoreCase("false")) {
            for (Inventory.to_inventory to : to_update) {
                System.out.println("    Barcode: " + to.barcode + " - Description: " + to.description);
//                Inventory.edit_inventory_no_price(to, to, " where main_barcode='" + to.barcode + "' ");
            }
        }
        if (main_branch.equalsIgnoreCase("false") && receipt_printing_enabled2.equalsIgnoreCase("true")) {
            for (Inventory.to_inventory to : to_update) {
                System.out.println("    Barcode: " + to.barcode + " - Description: " + to.description);
//                Inventory.edit_inventory_with_price(to, to, " where main_barcode='" + to.barcode + "' ");
            }
        }
        if (main_branch.equalsIgnoreCase("false")) {

        }
        if (main_branch.equalsIgnoreCase("false") && receipt_printing_enabled2.equalsIgnoreCase("true")) {
            Inventory_assembly.upload_assembly_to_local_from_cloud(assembly_cloud_to_add, assembly_cloud_to_delete);
        }

        check_for_upload();
        System.out.println("Finished updating items...");
    }

    //<editor-fold defaultstate="collapsed" desc=" Loader Post And Finalize ">
    public class Loader_download_local extends SwingWorker {

        private Loading dialog;

        public Loader_download_local(JDialog dlg) {

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
            proceed_download_local();
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
