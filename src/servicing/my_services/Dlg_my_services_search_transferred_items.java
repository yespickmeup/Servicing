/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicing.my_services;

import com.jgoodies.binding.adapter.AbstractTableAdapter;
import com.jgoodies.binding.list.ArrayListModel;
import java.awt.Dimension;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import mijzcx.synapse.desk.utils.CloseDialog;
import mijzcx.synapse.desk.utils.FitIn;
import mijzcx.synapse.desk.utils.KeyMapping;
import mijzcx.synapse.desk.utils.KeyMapping.KeyAction;
import mijzcx.synapse.desk.utils.TableWidthUtilities;
import servicing.receipts.Stock_transfers_items;
import servicing.receipts.Stock_transfers_items.to_stock_transfers_items;
import servicing.users.MyUser;
import servicing.utils.Alert;
import servicing.utils.Dlg_confirm_action;
import servicing.utils.TableRenderer;
import synsoftech.fields.Button;
import synsoftech.fields.Field;

/**
 *
 * @author User
 */
public class Dlg_my_services_search_transferred_items extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_my_services_search_transferred_items
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

        public final List<Stock_transfers_items.to_stock_transfers_items> datas;

        public OutputData(List<to_stock_transfers_items> datas) {
            this.datas = datas;
        }

    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Constructors ">
    private Dlg_my_services_search_transferred_items(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    private Dlg_my_services_search_transferred_items(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    public Dlg_my_services_search_transferred_items() {
        super();
        setUndecorated(true);
        initComponents();
        myInit();

    }
    private Dlg_my_services_search_transferred_items myRef;

    private void setThisRef(Dlg_my_services_search_transferred_items myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_my_services_search_transferred_items> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_my_services_search_transferred_items create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_my_services_search_transferred_items create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_my_services_search_transferred_items dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_my_services_search_transferred_items((java.awt.Frame) parent, false);
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
            Dlg_my_services_search_transferred_items dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_my_services_search_transferred_items((java.awt.Dialog) parent, false);
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

        Dlg_my_services_search_transferred_items dialog = Dlg_my_services_search_transferred_items.create(new javax.swing.JFrame(), true);
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
        jLabel8 = new javax.swing.JLabel();
        tf_to_branch = new Field.Combo();
        tf_to_location = new Field.Combo();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_stock_transfers_items = new javax.swing.JTable();
        jButton1 = new Button.Primary();
        jButton2 = new Button.Default();
        jLabel18 = new javax.swing.JLabel();
        tf_to_location1 = new Field.Search();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("Branch:");

        tf_to_branch.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_to_branch.setFocusable(false);
        tf_to_branch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_to_branchMouseClicked(evt);
            }
        });
        tf_to_branch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_to_branchActionPerformed(evt);
            }
        });

        tf_to_location.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_to_location.setFocusable(false);
        tf_to_location.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_to_locationMouseClicked(evt);
            }
        });
        tf_to_location.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_to_locationActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel17.setText("Location:");

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
        jScrollPane1.setViewportView(tbl_stock_transfers_items);

        jButton1.setText("Add to Transaction");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Cancel");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel18.setText("Search:");

        tf_to_location1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_to_location1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_to_location1MouseClicked(evt);
            }
        });
        tf_to_location1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_to_location1ActionPerformed(evt);
            }
        });

        jLabel1.setText("No. of rows:");

        jLabel2.setText("0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 719, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tf_to_branch)
                            .addComponent(tf_to_location)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_to_location1)))
                .addGap(40, 40, 40))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_to_branch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_to_location, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_to_location1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2)))
                .addGap(40, 40, 40))
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

    private void tf_to_branchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_to_branchMouseClicked
//        init_branch_locations();
    }//GEN-LAST:event_tf_to_branchMouseClicked

    private void tf_to_branchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_to_branchActionPerformed
//        init_branch_locations();
    }//GEN-LAST:event_tf_to_branchActionPerformed

    private void tf_to_locationMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_to_locationMouseClicked
//        init_branch_locations2();
    }//GEN-LAST:event_tf_to_locationMouseClicked

    private void tf_to_locationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_to_locationActionPerformed
//        init_branch_locations2();
    }//GEN-LAST:event_tf_to_locationActionPerformed

    private void tf_to_location1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_to_location1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_to_location1MouseClicked

    private void tf_to_location1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_to_location1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_to_location1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        confirm();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        disposed();
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_stock_transfers_items;
    private javax.swing.JTextField tf_to_branch;
    private javax.swing.JTextField tf_to_location;
    private javax.swing.JTextField tf_to_location1;
    // End of variables declaration//GEN-END:variables

    private void myInit() {
        init_key();
        set_default_branch();
        init_tbl_stock_transfers_items(tbl_stock_transfers_items);
    }

    public void do_pass(String branch, String branch_id, String location, String location_id, String slip_no) {
        Field.Combo br = (Field.Combo) tf_to_branch;
        Field.Combo loc = (Field.Combo) tf_to_location;
        br.setText(branch);
        br.setId(branch_id);
        loc.setText(location);
        loc.setId(location_id);
        tf_to_location1.setText(slip_no);
        ret_items();
    }
    String location_ids = "";

    private void set_default_branch() {

        servicing.branch_locations.S1_branch_locations.to_branch_locations to = S4_branch_locations.ret_data();
        location_ids = "" + to.id;
        Field.Combo f_br = (Field.Combo) tf_to_branch;
        f_br.setText(to.branch);
        f_br.setId(to.branch_id);

        String where = " order by branch,location asc ";
        branch_location_list = S1_branch_locations.ret_location_where(where);

        String where3 = " where user_id='" + MyUser.getUser_id() + "' ";

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

    List<S1_branch_locations.to_branch_locations> branch_location_list3 = new ArrayList();

    private void init_branch_locations() {
        if (!tf_to_branch.isEnabled()) {
            return;
        }
        Object[][] obj = new Object[branch_location_list3.size()][2];
        int i = 0;
        for (S1_branch_locations.to_branch_locations to : branch_location_list3) {
            obj[i][0] = " " + to.branch;
            obj[i][1] = " " + to.location;
            i++;
        }
        JLabel[] labels = {};
        int[] tbl_widths_customers = {120, 90};
        int width = 0;
        String[] col_names = {"Branch", "Location"};
        TableRenderer tr = new TableRenderer();
        TableRenderer.setPopup(tf_to_branch, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {
                S1_branch_locations.to_branch_locations to = branch_location_list3.get(data.selected_row);
                Field.Combo br = (Field.Combo) tf_to_branch;

                br.setText("" + to.branch);
                br.setId("" + to.branch_id);

            }
        });
    }

    List<S1_branch_locations.to_branch_locations> branch_location_list = new ArrayList();

    private void init_branch_locations2() {

        Field.Combo br = (Field.Combo) tf_to_branch;
        Field.Combo loc = (Field.Combo) tf_to_location;

        branch_location_list.clear();
        String where = " where branch_id='" + br.getId() + "' order by location asc ";
        branch_location_list = S1_branch_locations.ret_location_where(where);
        Object[][] obj = new Object[branch_location_list.size()][2];
        int i = 0;
        for (S1_branch_locations.to_branch_locations to : branch_location_list) {
            obj[i][0] = " " + to.id;
            obj[i][1] = " " + to.location;
            i++;
        }
        JLabel[] labels = {};
        int[] tbl_widths_customers = {0, tf_to_location.getWidth()};
        int width = 0;
        String[] col_names = {"Code", "Location"};
        TableRenderer tr = new TableRenderer();
        TableRenderer.
                setPopup(tf_to_location, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {
                S1_branch_locations.to_branch_locations to = branch_location_list.
                        get(data.selected_row);
                loc.setText("" + to.location);
                loc.setId("" + to.id);
//                int add_transfer = 0;
//                String from_location_id = "" + to.id;
//                for (Stock_transfer_privileges.to_stock_transfer_privileges stp : stock_transfer_privileges) {
//
//                    if (stp.from_location_id.equalsIgnoreCase(from_location_id) && stp.add_transfer == 1) {
//                        add_transfer = 1;
//                        break;
//                    }
//                }
//
//                if (add_transfer == 1) {
//
//                } else {
//                    Alert.set(0, "Privilege to transfer this location not added!");
//                }

            }
        });
    }

    //<editor-fold defaultstate="collapsed" desc=" stock_transfers_items "> 
    public static ArrayListModel tbl_stock_transfers_items_ALM;
    public static Tblstock_transfers_itemsModel tbl_stock_transfers_items_M;

    public static void init_tbl_stock_transfers_items(JTable tbl_stock_transfers_items) {
        tbl_stock_transfers_items_ALM = new ArrayListModel();
        tbl_stock_transfers_items_M = new Tblstock_transfers_itemsModel(tbl_stock_transfers_items_ALM);
        tbl_stock_transfers_items.setModel(tbl_stock_transfers_items_M);
        tbl_stock_transfers_items.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_stock_transfers_items.setRowHeight(25);
        int[] tbl_widths_stock_transfers_items = {60, 140, 100, 80, 80, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0, n = tbl_widths_stock_transfers_items.length; i < n; i++) {
            if (i == 2) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_stock_transfers_items, i, tbl_widths_stock_transfers_items[i]);
        }
        Dimension d = tbl_stock_transfers_items.getTableHeader().getPreferredSize();
        d.height = 25;
        tbl_stock_transfers_items.getTableHeader().setPreferredSize(d);
        tbl_stock_transfers_items.getTableHeader().setFont(new java.awt.Font("Arial", 0, 12));
        tbl_stock_transfers_items.setRowHeight(25);
        tbl_stock_transfers_items.setFont(new java.awt.Font("Arial", 0, 12));
    }

    public static void loadData_stock_transfers_items(List<to_stock_transfers_items> acc) {
        tbl_stock_transfers_items_ALM.clear();
        tbl_stock_transfers_items_ALM.addAll(acc);
    }

    public static class Tblstock_transfers_itemsModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "Qty", "Item Code", "Description", "Price", "Amount", "category_id", "classification", "classification_id", "sub_classification", "sub_classification_id", "product_qty", "unit", "conversion", "selling_price", "date_added", "user_name", "item_type", "status", "supplier", "fixed_price", "cost", "supplier_id", "multi_level_pricing", "vatable", "reorder_level", "markup", "barcodes", "brand", "brand_id", "model", "model_id", "selling_type", "branch", "branch_code", "location", "location_id", "stock_transfer_id", "serial_no", "to_branch", "to_branch_id", "to_location", "to_location_id", "at_branch", "at_branch_id", "at_location", "at_location_id", "is_uploaded", "finalized_by_id", "finalized_by", "service_id", "service_trans_no", "service_slip_no", "service_by_id", "service_by_name"
        };

        public Tblstock_transfers_itemsModel(ListModel listmodel) {
            super(listmodel, COLUMNS);
        }

        @Override
        public boolean isCellEditable(int row, int column) {
            if (column == 100) {
                return true;
            }
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
            to_stock_transfers_items tt = (to_stock_transfers_items) getRow(row);
            switch (col) {
                case 0:
                    return " " + tt.product_qty;
                case 1:
                    return " " + tt.barcode;
                case 2:
                    return " " + tt.description;
                case 3:
                    return " " + tt.selling_price;
                case 4:
                    return " " + FitIn.fmt_wc_0(tt.selling_price * tt.product_qty);
                case 5:
                    return tt.category_id;
                case 6:
                    return tt.classification;
                case 7:
                    return tt.classification_id;
                case 8:
                    return tt.sub_classification;
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
                case 35:
                    return tt.location_id;
                case 36:
                    return tt.stock_transfer_id;
                case 37:
                    return tt.serial_no;
                case 38:
                    return tt.to_branch;
                case 39:
                    return tt.to_branch_id;
                case 40:
                    return tt.to_location;
                case 41:
                    return tt.to_location_id;
                case 42:
                    return tt.at_branch;
                case 43:
                    return tt.at_branch_id;
                case 44:
                    return tt.at_location;
                case 45:
                    return tt.at_location_id;
                case 46:
                    return tt.at_location_id;
                case 47:
                    return tt.at_location_id;
                case 48:
                    return tt.at_location_id;
                case 49:
                    return tt.at_location_id;
                case 50:
                    return tt.at_location_id;
                case 51:
                    return tt.at_location_id;
                case 52:
                    return tt.at_location_id;
                default:
                    return tt.at_location_id;
            }
        }
    }

    private void ret_items() {
        String where = " where service_trans_no is NULL and service_slip_no like'" + tf_to_location1.getText() + "' ";

        List<Stock_transfers_items.to_stock_transfers_items> items = Stock_transfers_items.ret_data(where);
        loadData_stock_transfers_items(items);
        jLabel2.setText("" + items.size());
    }
//</editor-fold> 

    private void confirm() {
        Window p = (Window) this;
        Dlg_confirm_action nd = Dlg_confirm_action.create(p, true);
        nd.setTitle("");
//        nd.do_pass(services);
        nd.setCallback(new Dlg_confirm_action.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_confirm_action.OutputData data) {
                closeDialog.ok();
                ok1();
            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);
    }

    private void ok1() {
        List<Stock_transfers_items.to_stock_transfers_items> items = tbl_stock_transfers_items_ALM;
        if (items.isEmpty()) {
            Alert.set(0, "No item/s found!");
            return;
        }
        if (callback != null) {
            callback.ok(new CloseDialog(this), new OutputData(items));
        }
    }
}
