/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicing.inventory;

import servicing.users.MyUser;
import servicing.users.User_previleges;
import servicing.utils.Alert;
import servicing.utils.TableRenderer;
import com.jgoodies.binding.adapter.AbstractTableAdapter;
import com.jgoodies.binding.list.ArrayListModel;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import javax.swing.JLabel;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import mijzcx.synapse.desk.utils.CloseDialog;
import mijzcx.synapse.desk.utils.FitIn;
import mijzcx.synapse.desk.utils.KeyMapping;
import mijzcx.synapse.desk.utils.KeyMapping.KeyAction;
import mijzcx.synapse.desk.utils.TableWidthUtilities;
import synsoftech.fields.Button;
import synsoftech.fields.Field;

/**
 *
 * @author Guinness
 */
public class Dlg_inventory_uom extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_inventory_uom
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

        public final String uom;

        public OutputData(String uom) {
            this.uom = uom;
        }

    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Constructors ">
    private Dlg_inventory_uom(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    private Dlg_inventory_uom(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    public Dlg_inventory_uom() {
        super();
        setUndecorated(true);
        initComponents();
        myInit();

    }
    private Dlg_inventory_uom myRef;

    private void setThisRef(Dlg_inventory_uom myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_inventory_uom> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_inventory_uom create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_inventory_uom create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_inventory_uom dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_inventory_uom((java.awt.Frame) parent, false);
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
            Dlg_inventory_uom dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_inventory_uom((java.awt.Dialog) parent, false);
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

        Dlg_inventory_uom dialog = Dlg_inventory_uom.create(new javax.swing.JFrame(), true);
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
        jLabel1 = new javax.swing.JLabel();
        tf_unit = new Field.Combo();
        jLabel2 = new javax.swing.JLabel();
        tf_conversion = new Field.Input();
        jLabel3 = new javax.swing.JLabel();
        tf_selling_price = new Field.Input();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_uom = new javax.swing.JTable();
        jButton1 = new Button.Warning();
        jButton2 = new Button.Info();
        jButton3 = new Button.Primary();
        jButton5 = new Button.Default();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Unit:");

        tf_unit.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_unit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_unitMouseClicked(evt);
            }
        });
        tf_unit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_unitActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Conversion:");

        tf_conversion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_conversion.setText("1");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Selling Price:");

        tf_selling_price.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_selling_price.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_selling_priceActionPerformed(evt);
            }
        });

        tbl_uom.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_uom.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_uomMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_uom);

        jButton1.setText("Delete");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Update");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Add");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton5.setText("Close");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel4.setText("No of Rows:");

        jLabel5.setText("0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(tf_selling_price, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                                            .addComponent(tf_conversion)
                                            .addComponent(tf_unit)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(186, 186, 186)
                                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tf_unit, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tf_conversion, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tf_selling_price, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5))
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

    private void tf_unitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_unitActionPerformed
        init_default_uom();
    }//GEN-LAST:event_tf_unitActionPerformed

    private void tf_unitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_unitMouseClicked
        init_default_uom();
    }//GEN-LAST:event_tf_unitMouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        ok();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        add_uom();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void tf_selling_priceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_selling_priceActionPerformed
        add_uom();
    }//GEN-LAST:event_tf_selling_priceActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        update_uom();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tbl_uomMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_uomMouseClicked
        select();
    }//GEN-LAST:event_tbl_uomMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        delete_uom();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_uom;
    private javax.swing.JTextField tf_conversion;
    private javax.swing.JTextField tf_selling_price;
    private javax.swing.JTextField tf_unit;
    // End of variables declaration//GEN-END:variables

    private void myInit() {
        init_key();
        init_tbl_uom();
    }

    public void do_pass(String uoms, to_uom default_uom) {
        List<to_uom> datas = new ArrayList();
        if (uoms == null) {
            datas.add(default_uom);
        } else {
            String[] list = uoms.split(",");
            int exist = 0;
            for (String s : list) {
                int i = s.indexOf(":");
                int ii = s.indexOf("/");
                int iii = s.indexOf("^");
                String uom = s.substring(1, i);
                double conversion = FitIn.toDouble(s.substring(ii + 1, s.length() - 1));
                double selling_price = FitIn.toDouble(s.substring(i + 1, ii));
                int is_default = FitIn.toInt(s.substring(iii + 1, s.length() - 1));
                if (default_uom.uom.equalsIgnoreCase(uom)) {
                    is_default = 1;
                    conversion = default_uom.conversion;
                    selling_price = default_uom.selling_price;
                    exist = 1;
                }
                to_uom to = new to_uom(0, uom, conversion, selling_price, is_default);
                datas.add(to);
            }
            if (exist == 0) {
                datas.add(default_uom);
            }

        }
        loadData_uom(datas);
        jLabel5.setText("" + tbl_uom_ALM.size());
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

    List<S1_inventory_uom.to_inventory_uom> uom_list = new ArrayList();

    private void init_default_uom() {
        String search = tf_unit.getText();
        uom_list.clear();
        uom_list = S1_inventory_uom.ret_data(search);
        Object[][] obj = new Object[uom_list.size()][1];
        int i = 0;
        for (S1_inventory_uom.to_inventory_uom to : uom_list) {
            obj[i][0] = to.name;
            i++;
        }
        JLabel[] labels = {};
        int[] tbl_widths_customers = {350};
        String[] col_names = {"Name"};
        TableRenderer tr = new TableRenderer();
        TableRenderer.
                setPopup(tf_unit, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {
                S1_inventory_uom.to_inventory_uom to = uom_list.
                        get(data.selected_row);
                tf_unit.setText(to.name);
                tf_conversion.grabFocus();
            }
        });
    }

    private ArrayListModel tbl_uom_ALM;
    private TbluomModel tbl_uom_M;

    private void init_tbl_uom() {
        tbl_uom_ALM = new ArrayListModel();
        tbl_uom_M = new TbluomModel(tbl_uom_ALM);
        tbl_uom.getTableHeader().setPreferredSize(new Dimension(100, 40));
        tbl_uom.setModel(tbl_uom_M);
        tbl_uom.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_uom.setRowHeight(25);
        int[] tbl_widths_uom = {100, 100, 100, 60};
        for (int i = 0, n = tbl_widths_uom.length; i < n; i++) {
            if (i == 0) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_uom, i, tbl_widths_uom[i]);
        }
        Dimension d = tbl_uom.getTableHeader().getPreferredSize();
        d.height = 25;
        tbl_uom.getTableHeader().setPreferredSize(d);
        tbl_uom.getTableHeader().setFont(new java.awt.Font("Arial", 0, 12));
        tbl_uom.setRowHeight(25);
        tbl_uom.setFont(new java.awt.Font("Arial", 0, 12));
        TableWidthUtilities.setColumnRightRenderer(tbl_uom, 2);

    }

    private void loadData_uom(List<to_uom> acc) {
        tbl_uom_ALM.clear();
        tbl_uom_ALM.addAll(acc);
    }

    public static class TbluomModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "UOM", "Conversion", "Selling Price", "Default"
        };

        public TbluomModel(ListModel listmodel) {
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
            to_uom tt = (to_uom) getRow(row);
            switch (col) {
                case 0:
                    String uom = tt.uom;
                    uom = uom.replaceAll("#", "/");
                    return " " + uom;
                case 1:
                    return " " + FitIn.fmt_wc_0(tt.conversion);
                case 2:
                    return FitIn.fmt_wc_0(tt.selling_price) + " ";
                default:
                    if (tt.is_default == 1) {
                        return " Yes";
                    } else {
                        return " ";
                    }

            }
        }

    }

    public static class to_uom {

        public final int id;
        public String uom;
        public double conversion;
        public double selling_price;
        public int is_default;

        public to_uom(int id, String uom, double conversion, double selling_price, int is_default) {
            this.id = id;
            this.uom = uom;
            this.conversion = conversion;
            this.selling_price = selling_price;
            this.is_default = is_default;
        }

        public int getIs_default() {
            return is_default;
        }

        public void setIs_default(int is_default) {
            this.is_default = is_default;
        }

        public String getUom() {
            return uom;
        }

        public void setUom(String uom) {
            this.uom = uom;
        }

        public double getConversion() {
            return conversion;
        }

        public void setConversion(double conversion) {
            this.conversion = conversion;
        }

        public double getSelling_price() {
            return selling_price;
        }

        public void setSelling_price(double selling_price) {
            this.selling_price = selling_price;
        }

    }

    private void add_uom() {
        String wheree = " where user_id='" + MyUser.getUser_id() + "' and previledge like '" + "Unit of Measure - (Add)" + "' limit 1";
        List<User_previleges.to_user_previleges> privileges = User_previleges.ret_data(wheree);
        if (privileges.isEmpty()) {
            Alert.set(0, "Privilege not added!");
            return;
        }
        int id = 0;
        String uom = tf_unit.getText();
        uom = uom.replaceAll("/", "#");
        double conversion = FitIn.toDouble(tf_conversion.getText());
        double selling_price = FitIn.toDouble(tf_selling_price.getText());
        to_uom to = new to_uom(id, uom, conversion, selling_price, 0);
        tbl_uom_ALM.add(to);
        tbl_uom_M.fireTableDataChanged();
        tf_unit.setText("");
        tf_selling_price.setText("");
        jLabel5.setText("" + tbl_uom_ALM.size());
    }

    private void update_uom() {
        String wheree = " where user_id='" + MyUser.getUser_id() + "' and previledge like '" + "Unit of Measure - (Edit)" + "' limit 1";
        List<User_previleges.to_user_previleges> privileges = User_previleges.ret_data(wheree);
        if (privileges.isEmpty()) {
            Alert.set(0, "Privilege not added!");
            return;
        }
        int row = tbl_uom.getSelectedRow();
        if (row < 0) {
            return;
        }

        to_uom to = (to_uom) tbl_uom_ALM.get(row);
        int id = 0;
        String uom = tf_unit.getText();
        uom = uom.replaceAll("/", "#");
        double conversion = FitIn.toDouble(tf_conversion.getText());
        double selling_price = FitIn.toDouble(tf_selling_price.getText());
        to.setUom(uom);
        to.setConversion(conversion);
        to.setSelling_price(selling_price);
        tbl_uom_M.fireTableDataChanged();
        tf_unit.setText("");
        tf_selling_price.setText("");

    }

    private void select() {
        int row = tbl_uom.getSelectedRow();
        if (row < 0) {
            return;
        }
        to_uom to = (to_uom) tbl_uom_ALM.get(row);
        tf_unit.setText(to.uom);
        tf_conversion.setText(FitIn.fmt_wc_0(to.conversion));
        tf_selling_price.setText(FitIn.fmt_wc_0(to.selling_price));
    }

    private void delete_uom() {
        String wheree = " where user_id='" + MyUser.getUser_id() + "' and previledge like '" + "Unit of Measure - (Delete)" + "' limit 1";
        List<User_previleges.to_user_previleges> privileges = User_previleges.ret_data(wheree);
        if (privileges.isEmpty()) {
            Alert.set(0, "Privilege not added!");
            return;
        }
        int row = tbl_uom.getSelectedRow();
        if (row < 0) {
            return;
        }
        tbl_uom_ALM.remove(row);
        tbl_uom_M.fireTableDataChanged();
        jLabel5.setText("" + tbl_uom_ALM.size());
    }

    private void ok() {
        String uom = "";
        List<to_uom> datas = tbl_uom_ALM;
        for (to_uom to : datas) {
            uom = uom + ",[" + to.uom + ":" + to.selling_price + "/" + to.conversion + "]";
        }
        uom = uom.substring(1, uom.length());
        if (callback != null) {
            callback.ok(new CloseDialog(this), new OutputData(uom));
        }
    }

}
