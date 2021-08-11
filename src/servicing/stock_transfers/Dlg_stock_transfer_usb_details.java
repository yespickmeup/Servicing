/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicing.stock_transfers;

import servicing.inventory.Inventory;
import servicing.receipts.Stock_transfers_items;
import static servicing.stock_transfers.Dlg_new_stock_transfer_cloud_transactions.show_cost;
import servicing.utils.DateType;
import com.jgoodies.binding.adapter.AbstractTableAdapter;
import com.jgoodies.binding.list.ArrayListModel;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import javax.swing.JTable;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import mijzcx.synapse.desk.utils.CloseDialog;
import mijzcx.synapse.desk.utils.FitIn;
import mijzcx.synapse.desk.utils.KeyMapping;
import mijzcx.synapse.desk.utils.KeyMapping.KeyAction;
import mijzcx.synapse.desk.utils.TableWidthUtilities;
import synsoftech.fields.Button;
import synsoftech.util.ImageRenderer;

/**
 *
 * @author Ronescape
 */
public class Dlg_stock_transfer_usb_details extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_stock_transfer_usb_details
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
    private Dlg_stock_transfer_usb_details(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    private Dlg_stock_transfer_usb_details(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    public Dlg_stock_transfer_usb_details() {
        super();
        setUndecorated(true);
        initComponents();
        myInit();

    }
    private Dlg_stock_transfer_usb_details myRef;

    private void setThisRef(Dlg_stock_transfer_usb_details myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_stock_transfer_usb_details> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_stock_transfer_usb_details create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_stock_transfer_usb_details create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_stock_transfer_usb_details dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_stock_transfer_usb_details((java.awt.Frame) parent, false);
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
            Dlg_stock_transfer_usb_details dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_stock_transfer_usb_details((java.awt.Dialog) parent, false);
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

        Dlg_stock_transfer_usb_details dialog = Dlg_stock_transfer_usb_details.create(new javax.swing.JFrame(), true);
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
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_inventory_barcodes = new javax.swing.JTable();
        jButton1 = new Button.Success();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_stock_transfers = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_stock_transfers_items = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setText("0");

        jLabel3.setText("Total Items:");

        tbl_inventory_barcodes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_inventory_barcodes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_inventory_barcodesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_inventory_barcodes);

        jButton1.setText("Download Items");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 979, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 479, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Items", jPanel3);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Transactions", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

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
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tbl_stock_transfersMouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbl_stock_transfersMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tbl_stock_transfersMouseReleased(evt);
            }
        });
        jScrollPane3.setViewportView(tbl_stock_transfers);

        jLabel12.setText("No. of Transactions:");

        jLabel13.setText("0");

        jLabel14.setText("Transactions Selected:");

        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel15.setText("0");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(1, 1, 1)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel14)
                        .addGap(1, 1, 1)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 947, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel14)
                        .addComponent(jLabel15)))
                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Items", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

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
        jScrollPane2.setViewportView(tbl_stock_transfers_items);

        jLabel1.setText("No. of items:");

        jLabel2.setText("0");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Stock Transfers", jPanel2);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
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
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbl_stock_transfersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_stock_transfersMouseClicked
        select_stock_transfer();
    }//GEN-LAST:event_tbl_stock_transfersMouseClicked

    private void tbl_stock_transfersMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_stock_transfersMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_stock_transfersMouseEntered

    private void tbl_stock_transfersMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_stock_transfersMousePressed
//        show_popup(evt);
    }//GEN-LAST:event_tbl_stock_transfersMousePressed

    private void tbl_stock_transfersMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_stock_transfersMouseReleased
//        show_popup(evt);
    }//GEN-LAST:event_tbl_stock_transfersMouseReleased

    private void tbl_inventory_barcodesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_inventory_barcodesMouseClicked
//        select_item();
    }//GEN-LAST:event_tbl_inventory_barcodesMouseClicked

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tbl_inventory_barcodes;
    private javax.swing.JTable tbl_stock_transfers;
    private javax.swing.JTable tbl_stock_transfers_items;
    // End of variables declaration//GEN-END:variables

    private void myInit() {

//        System.getProperty("pool_db", "db_algorithm");
        init_key();
        init_tbl_stock_transfers();
        init_tbl_inventory_barcodes(tbl_inventory_barcodes);
        init_tbl_stock_transfers_items();
    }
    List<Stock_transfers_items.to_stock_transfers_items> transfer_items = new ArrayList();
    int download = 0;

    public void do_pass(List<Stock_transfers.to_stock_transfers> stock_transfers, List<Inventory.to_inventory> items, int tab, List<Stock_transfers_items.to_stock_transfers_items> transfer_items1) {
        download = 0;
        init_tbl_stock_transfers();
        loadData_inventory_barcodes(items);
        jLabel4.setText("" + items.size());
        transfer_items = transfer_items1;
        for (Stock_transfers.to_stock_transfers transfer : stock_transfers) {
            System.out.println("transfer: " + transfer.status);
            List<Stock_transfers.to_stock_transfers> local_transfer = Stock_transfers.ret_data(" where transaction_no='" + transfer.transaction_no + "' ");
            if (!local_transfer.isEmpty()) {
                transfer.setStatus(1);
            } else {
                transfer.setStatus(0);
            }
        }
        loadData_stock_transfers(stock_transfers);
        jLabel13.setText("" + stock_transfers.size());
//        loadData_stock_transfers_items(transfer_items1);
        jLabel2.setText("" + transfer_items1.size());
        jTabbedPane1.setSelectedIndex(tab);
    }

    public void do_pass2(List<Stock_transfers.to_stock_transfers> stock_transfers, List<Inventory.to_inventory> items, int tab, List<Stock_transfers_items.to_stock_transfers_items> transfer_items1) {
        download = 1;
        init_tbl_stock_transfers();
        loadData_inventory_barcodes(items);
        jLabel4.setText("" + items.size());
        transfer_items = transfer_items1;
        for (Stock_transfers.to_stock_transfers transfer : stock_transfers) {
            System.out.println("transfer: " + transfer.status);
            List<Stock_transfers.to_stock_transfers> local_transfer = Stock_transfers.ret_data(" where transaction_no='" + transfer.transaction_no + "' ");
            if (!local_transfer.isEmpty()) {
                transfer.setStatus(1);
            } else {
                transfer.setStatus(0);
            }
        }
        loadData_stock_transfers(stock_transfers);
        jLabel13.setText("" + stock_transfers.size());
//        loadData_stock_transfers_items(transfer_items1);
        jLabel2.setText("" + transfer_items1.size());
        jTabbedPane1.setSelectedIndex(tab);
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

        int w_status = 0;
        int w_selected = 0;
        if (download == 1) {
            w_selected = 30;
        } else {
            w_status = 100;
        }
//        System.out.println("download: " + download);
        int[] tbl_widths_stock_transfers = {70, 100, 150, 150, 0, w_status, w_selected, 0, 0, 0, 0, 0, 0};

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
        tbl_stock_transfers.getColumnModel().getColumn(9).setCellRenderer(new ImageRenderer());
    }

    private void loadData_stock_transfers(List<Stock_transfers.to_stock_transfers> acc) {
        tbl_stock_transfers_ALM.clear();
        tbl_stock_transfers_ALM.addAll(acc);
    }

    public static class Tblstock_transfersModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "Trans #", "Date", "From", "To", "Finalized by.", "Status", "", "", "", "", "", "", "from_location_id"
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
            if (col == 6) {
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
                    if (tt.finalized_by == null) {
                        return " ";
                    } else {
                        return " " + tt.finalized_by;
                    }
                case 5:
                    if (tt.status == 0) {
                        return "";
                    } else {
                        return " Already Added!";
                    }
                case 6:
                    return tt.selected;
                case 7:
                    return " Delete";
                case 8:
                    return " Print";
                case 9:
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
                case 10:
                    return " Print";
                case 11:
                    return tt.from_location;
                default:
                    return tt.from_location_id;
            }
        }
    }

    //<editor-fold defaultstate="collapsed" desc=" inventory_barcodes "> 
    public static ArrayListModel tbl_inventory_barcodes_ALM;
    public static Tblinventory_barcodesModel tbl_inventory_barcodes_M;

    public static void init_tbl_inventory_barcodes(JTable tbl_inventory_barcodes) {
        tbl_inventory_barcodes_ALM = new ArrayListModel();
        tbl_inventory_barcodes_M = new Tblinventory_barcodesModel(tbl_inventory_barcodes_ALM);
        tbl_inventory_barcodes.setModel(tbl_inventory_barcodes_M);
        tbl_inventory_barcodes.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_inventory_barcodes.setRowHeight(25);
        int[] tbl_widths_inventory_barcodes = {40, 70, 150, 100, 0, 0, 80, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0, n = tbl_widths_inventory_barcodes.length; i < n; i++) {
            if (i == 3) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_inventory_barcodes, i, tbl_widths_inventory_barcodes[i]);
        }
        Dimension d = tbl_inventory_barcodes.getTableHeader().getPreferredSize();
        d.height = 25;
        tbl_inventory_barcodes.getTableHeader().setPreferredSize(d);
        tbl_inventory_barcodes.getTableHeader().setFont(new java.awt.Font("Arial", 0, 12));
        tbl_inventory_barcodes.setRowHeight(25);
        tbl_inventory_barcodes.setFont(new java.awt.Font("Arial", 0, 12));
        TableWidthUtilities.setColumnRightRenderer(tbl_inventory_barcodes, 6);
    }

    public static void loadData_inventory_barcodes(List<Inventory.to_inventory> acc) {
        tbl_inventory_barcodes_ALM.clear();
        tbl_inventory_barcodes_ALM.addAll(acc);
    }

    public static class Tblinventory_barcodesModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "Qty", "Item Code", "Barcode", "Description", "Branch", "Location", "Price", "classification_id", "sub_classification", "sub_classification_id", "product_qty", "unit", "conversion", "selling_price", "date_added", "user_name", "item_type", "status", "supplier", "fixed_price", "cost", "supplier_id", "multi_level_pricing", "vatable", "reorder_level", "markup", "main_barcode", "brand", "brand_id", "model", "model_id", "selling_type", "branch", "branch_code", "location", "location_id", "serial_no"
        };

        public Tblinventory_barcodesModel(ListModel listmodel) {
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
            Inventory.to_inventory tt = (Inventory.to_inventory) getRow(row);
            switch (col) {
                case 0:
                    return " " + FitIn.fmt_woc(tt.product_qty);
                case 1:
                    return " " + tt.barcode;
                case 2:
                    return " " + tt.barcodes;
                case 3:
                    return " " + tt.description;
                case 4:
                    return " " + tt.branch;
                case 5:
                    return " " + tt.location;
                case 6:
                    return FitIn.fmt_wc_0(tt.selling_price) + " ";
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
                    return tt.barcode;
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
                default:
                    return "";
            }
        }
    }
//</editor-fold> 

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

    private void select_stock_transfer() {
        int row = tbl_stock_transfers.getSelectedRow();
        if (row < 0) {
            return;
        }
        int col = tbl_stock_transfers.getSelectedColumn();
        Stock_transfers.to_stock_transfers st = (Stock_transfers.to_stock_transfers) tbl_stock_transfers_ALM.get(row);
        if (col == 6) {
            if (st.selected == true) {
                st.setSelected(false);
            } else {
                st.setSelected(true);
            }
            tbl_stock_transfers_M.fireTableDataChanged();
            int selected = 0;
            List<Stock_transfers.to_stock_transfers> stocks = tbl_stock_transfers_ALM;
            for (Stock_transfers.to_stock_transfers s : stocks) {
                if (s.selected == true) {
                    selected++;
                }
            }

            jLabel15.setText("" + selected);
        } else {

            List<Stock_transfers_items.to_stock_transfers_items> items = transfer_items;
            List<Stock_transfers_items.to_stock_transfers_items> items_to_add = new ArrayList();
            for (Stock_transfers_items.to_stock_transfers_items item : items) {
                if (item.stock_transfer_id.equalsIgnoreCase(st.transaction_no)) {
                    items_to_add.add(item);
                }
            }
            loadData_stock_transfers_items(items_to_add);
            jLabel2.setText("" + items_to_add.size());
        }

    }
}
