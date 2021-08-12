/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicing.my_services;

import servicing.my_services.My_services_crews.to_my_services_crews;

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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import mijzcx.synapse.desk.utils.CloseDialog;
import mijzcx.synapse.desk.utils.KeyMapping;
import mijzcx.synapse.desk.utils.KeyMapping.KeyAction;
import mijzcx.synapse.desk.utils.TableWidthUtilities;
import servicing.branch_locations.Branch_locations;
import servicing.users.User_previleges;
import servicing.utils.Dlg_confirm_action;
import servicing.utils.TableRenderer;
import synsoftech.fields.Button;
import synsoftech.fields.Field;
import synsoftech.util.Focus_Fire;
import synsoftech.util.ImageRenderer1;

/**
 *
 * @author Ronald
 */
public class Dlg_my_services_crews extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_my_services_crews
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
    private Dlg_my_services_crews(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    private Dlg_my_services_crews(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    public Dlg_my_services_crews() {
        super();
        setUndecorated(true);
        initComponents();
        myInit();

    }
    private Dlg_my_services_crews myRef;

    private void setThisRef(Dlg_my_services_crews myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_my_services_crews> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_my_services_crews create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_my_services_crews create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_my_services_crews dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_my_services_crews((java.awt.Frame) parent, false);
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
            Dlg_my_services_crews dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_my_services_crews((java.awt.Dialog) parent, false);
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

        Dlg_my_services_crews dialog = Dlg_my_services_crews.create(new javax.swing.JFrame(), true);
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
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_my_services_crews = new javax.swing.JTable();
        jTextField9 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        tf_department1 = new Field.Combo();
        jCheckBox3 = new javax.swing.JCheckBox();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tf_address = new javax.swing.JTextArea();
        tf_lname = new Field.Input();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tf_mi = new Field.Input();
        tf_fname = new Field.Input();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tf_contact_no = new Field.Input();
        jLabel6 = new javax.swing.JLabel();
        tf_department = new Field.Combo();
        tf_manager = new Field.Combo();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel10 = new javax.swing.JLabel();
        jCheckBox2 = new javax.swing.JCheckBox();
        jButton2 = new Button.Success();
        jButton4 = new Button.Default();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        tbl_my_services_crews.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_my_services_crews.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_my_services_crewsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_my_services_crews);

        jTextField9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField9ActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel11.setText("Department:");

        tf_department1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_department1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_department1ActionPerformed(evt);
            }
        });

        jCheckBox3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox3.setSelected(true);
        jCheckBox3.setText("All");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Address:");

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        tf_address.setColumns(20);
        tf_address.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_address.setRows(5);
        jScrollPane1.setViewportView(tf_address);

        tf_lname.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("Last Name:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Middle Name:");

        tf_mi.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        tf_fname.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_fname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_fnameActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("First Name:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Contact #:");

        tf_contact_no.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("Department:");

        tf_department.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_department.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_departmentMouseClicked(evt);
            }
        });
        tf_department.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_departmentActionPerformed(evt);
            }
        });

        tf_manager.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_manager.setFocusable(false);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("Manager:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel9.setText("Status:");

        jCheckBox1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox1.setSelected(true);
        jCheckBox1.setText("Active/Inactive");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel10.setText("Manager:");

        jCheckBox2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox2.setText("Yes/No");
        jCheckBox2.setEnabled(false);
        jCheckBox2.setFocusable(false);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/servicing/icons/icon.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/servicing/icons/new-file.png"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel12.setText("No. of rows:");

        jLabel13.setText("0");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 841, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBox3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_department1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tf_lname)
                            .addComponent(jScrollPane1)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(tf_fname)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tf_mi))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tf_contact_no)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jCheckBox1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(tf_department)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tf_manager))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jTextField9))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_fname, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_mi, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_lname, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_contact_no, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_department, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_manager, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_department1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(5, 5, 5))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void tf_fnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_fnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_fnameActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        save_my_services_crews();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        clear_my_services_crews();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void tbl_my_services_crewsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_my_services_crewsMouseClicked
        select_my_services_crews();
    }//GEN-LAST:event_tbl_my_services_crewsMouseClicked

    private void tf_departmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_departmentActionPerformed
        init_departments();
    }//GEN-LAST:event_tf_departmentActionPerformed

    private void tf_department1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_department1ActionPerformed
        init_departments2();
    }//GEN-LAST:event_tf_department1ActionPerformed

    private void jTextField9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField9ActionPerformed
        data_cols();
    }//GEN-LAST:event_jTextField9ActionPerformed

    private void tf_departmentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_departmentMouseClicked
        init_departments();
    }//GEN-LAST:event_tf_departmentMouseClicked

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JTable tbl_my_services_crews;
    private javax.swing.JTextArea tf_address;
    private javax.swing.JTextField tf_contact_no;
    private javax.swing.JTextField tf_department;
    private javax.swing.JTextField tf_department1;
    private javax.swing.JTextField tf_fname;
    private javax.swing.JTextField tf_lname;
    private javax.swing.JTextField tf_manager;
    private javax.swing.JTextField tf_mi;
    // End of variables declaration//GEN-END:variables
    private void myInit() {
        init_key();
        set_default_branch();
        init_tbl_my_services_crews();
        data_cols();
        focus();
    }
    String my_branch = "";
    String my_branch_id = "";
    String my_location = "";
    String my_location_id = "";

    private void set_default_branch() {
        servicing.branch_locations.S1_branch_locations.to_branch_locations to = S4_branch_locations.ret_data();
        my_branch = to.branch;
        my_branch_id = to.branch_id;
        my_location = to.location;
        my_location_id = "" + to.id;
    }

    private void focus() {
        JTextField[] tf = {tf_fname, tf_mi, tf_lname, tf_contact_no, tf_department, jTextField9};
        Focus_Fire.onFocus_lostFocus(tf);
        Focus_Fire.select_all(tf);

        JTextArea[] tf2 = {tf_address};
        Focus_Fire.onFocus_lostFocus(tf2);
        Focus_Fire.select_all(tf2);
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
    private ArrayListModel tbl_my_services_crews_ALM;
    private Tblmy_services_crewsModel tbl_my_services_crews_M;

    private void init_tbl_my_services_crews() {
        tbl_my_services_crews_ALM = new ArrayListModel();
        tbl_my_services_crews_M = new Tblmy_services_crewsModel(tbl_my_services_crews_ALM);
        tbl_my_services_crews.getTableHeader().setPreferredSize(new Dimension(100, 40));
        tbl_my_services_crews.setModel(tbl_my_services_crews_M);
        tbl_my_services_crews.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_my_services_crews.setRowHeight(25);
        int[] tbl_widths_my_services_crews = {100, 100, 100, 50, 60, 30, 30, 0, 0, 0, 0, 0};
        for (int i = 0, n = tbl_widths_my_services_crews.length; i < n; i++) {
            if (i == 0) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_my_services_crews, i, tbl_widths_my_services_crews[i]);
        }
        Dimension d = tbl_my_services_crews.getTableHeader().getPreferredSize();
        d.height = 30;
        tbl_my_services_crews.getTableHeader().setPreferredSize(d);
        tbl_my_services_crews.getTableHeader().setFont(new java.awt.Font("Arial", 0, 11));
        tbl_my_services_crews.setRowHeight(25);
        tbl_my_services_crews.setFont(new java.awt.Font("Arial", 0, 11));
        tbl_my_services_crews.getColumnModel().getColumn(5).setCellRenderer(new ImageRenderer1());
        tbl_my_services_crews.getColumnModel().getColumn(6).setCellRenderer(new ImageRenderer1());
    }

    private void loadData_my_services_crews(List<to_my_services_crews> acc) {
        tbl_my_services_crews_ALM.clear();
        tbl_my_services_crews_ALM.addAll(acc);
    }

    public static class Tblmy_services_crewsModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "Name", "Department", "Manager", "Status", "Account", "", "", "manager_id", "department", "department_id", "is_manager", "is_status"
        };

        public Tblmy_services_crewsModel(ListModel listmodel) {
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
            to_my_services_crews tt = (to_my_services_crews) getRow(row);
            switch (col) {
                case 0:
                    return " " + tt.fname + " " + tt.mi + " " + tt.lname;
                case 1:
                    return " " + tt.department;
                case 2:
                    return " " + tt.manager;
                case 3:
                    if (tt.is_status == 0) {
                        return "   Inactive";
                    } else {
                        return "   Active";
                    }
                case 4:
                    if (tt.account_created == 0) {
                        return "   Create";
                    } else {
                        return "   --------";
                    }
                case 5:
                    return "/servicing/icons/edit.png";
                case 6:
                    return "/servicing/icons/remove11.png";
                case 7:
                    return tt.manager_id;
                case 8:
                    return tt.department;
                case 9:
                    return tt.department_id;
                case 10:
                    return tt.is_manager;
                default:
                    return tt.is_status;
            }
        }
    }

    private void data_cols() {
        Field.Combo dep = (Field.Combo) tf_department1;

        String where = "";
        if (jCheckBox3.isSelected()) {
            where = " where fname like '%" + jTextField9.getText() + "%' and location_id='" + my_location_id + "' "
                    + " or fname like '%" + jTextField9.getText() + "%' and location_id='" + my_location_id + "' order by fname asc";
        } else {
            where = " where fname like '%" + jTextField9.getText() + "%' and department_id ='" + dep.getId() + "' and location_id='" + my_location_id + "' "
                    + " or fname like '%" + jTextField9.getText() + "%' and department_id ='" + dep.getId() + "' and location_id='" + my_location_id + "'"
                    + " order by fname asc";
        }
        loadData_my_services_crews(My_services_crews.ret_data(where));
    }

    private void save_my_services_crews() {
        int row = tbl_my_services_crews.getSelectedRow();
        if (row < 0) {
            Field.Combo dep = (Field.Combo) tf_department;
            Field.Combo man = (Field.Combo) tf_manager;
            int id = -1;
            String fname = tf_fname.getText();
            String mi = tf_mi.getText();
            String lname = tf_lname.getText();
            String address = tf_address.getText();
            String contact_no = tf_contact_no.getText();
            String manager = tf_manager.getText();
            String manager_id = man.getId();
            String department = tf_department.getText();
            String department_id = dep.getId();
            int is_manager = 0;
            if (jCheckBox2.isSelected()) {
                is_manager = 1;
            }
            int is_status = 0;
            if (jCheckBox1.isSelected()) {
                is_status = 1;
            }
            int account_created = 0;

            to_my_services_crews to = new to_my_services_crews(id, fname, mi, lname, address, contact_no, manager, manager_id, department, department_id, is_manager, is_status, account_created, my_branch, my_branch_id, my_location, my_location_id);
            My_services_crews.add_my_services_crews(to);
            data_cols();

        } else {
            Field.Combo dep = (Field.Combo) tf_department;
            Field.Combo man = (Field.Combo) tf_manager;
            to_my_services_crews to = (to_my_services_crews) tbl_my_services_crews_ALM.get(tbl_my_services_crews.convertRowIndexToModel(row));
            int id = to.id;
            String fname = tf_fname.getText();
            String mi = tf_mi.getText();
            String lname = tf_lname.getText();
            String address = tf_address.getText();
            String contact_no = tf_contact_no.getText();
            String manager = tf_manager.getText();
            String manager_id = man.getId();
            String department = tf_department.getText();
            String department_id = dep.getId();
            int is_manager = 0;
            if (jCheckBox2.isSelected()) {
                is_manager = 1;
            }
            int is_status = 0;
            if (jCheckBox1.isSelected()) {
                is_status = 1;
            }

            to_my_services_crews to1 = new to_my_services_crews(id, fname, mi, lname, address, contact_no, manager, manager_id, department, department_id, is_manager, is_status, 0, to.branch, to.branch_id, to.location, to.location_id);
            My_services_crews.edit_my_services_crews(to1);
            data_cols();

        }
        clear_my_services_crews();
    }

    private void select_my_services_crews() {
        int row = tbl_my_services_crews.getSelectedRow();
        if (row < 0) {
            return;
        }
        to_my_services_crews to = (to_my_services_crews) tbl_my_services_crews_ALM.get(tbl_my_services_crews.convertRowIndexToModel(row));
        int col = tbl_my_services_crews.getSelectedColumn();
        if (col == 5) {
            Field.Combo dep = (Field.Combo) tf_department;
            Field.Combo man = (Field.Combo) tf_manager;
            tf_fname.setText(to.fname);
            tf_mi.setText(to.mi);
            tf_lname.setText(to.lname);
            tf_address.setText(to.address);
            tf_contact_no.setText(to.contact_no);
            tf_manager.setText(to.manager);
            man.setId(to.manager_id);
            tf_department.setText(to.department);
            dep.setId(to.department_id);

            if (to.is_status == 0) {
                jCheckBox1.setSelected(false);
            } else {
                jCheckBox1.setSelected(true);
            }

            if (to.is_manager == 0) {
                jCheckBox2.setSelected(false);
            } else {
                jCheckBox2.setSelected(true);
            }
        }
        if (col == 6) {
            Window p = (Window) this;
            Dlg_confirm_action nd = Dlg_confirm_action.create(p, true);
            nd.setTitle("");

            nd.setCallback(new Dlg_confirm_action.Callback() {

                @Override
                public void ok(CloseDialog closeDialog, Dlg_confirm_action.OutputData data) {
                    closeDialog.ok();
                    delete_my_services_crews();
                }
            });
            nd.setLocationRelativeTo(this);
            nd.setVisible(true);
        }
        if (col == 4) {
            int created = 0;
            if (to.account_created == 0) {
                created = 1;
            } else {
                created = 0;
            }

            if (created == 0) {
                cancel_account(created, to.id);
            } else {
                crew_account("" + to.id, created, to.fname + " " + to.lname);
            }
        }

    }

    private void cancel_account(final int created, final int id) {
        Window p = (Window) this;
        Dlg_my_service_confirm nd = Dlg_my_service_confirm.create(p, true);
        nd.setTitle("");

        nd.setCallback(new Dlg_my_service_confirm.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_my_service_confirm.OutputData data) {
                closeDialog.ok();
                My_services_crews.edit_my_services_created("" + id, created);
                data_cols();
            }
        });
        nd.setLocationRelativeTo(jScrollPane2);
        nd.setVisible(true);
    }

    private void crew_account(final String id, final int created, final String screen_name) {
        Window p = (Window) this;
        Dlg_crew_account nd = Dlg_crew_account.create(p, true);
        nd.setTitle("");
        nd.setCallback(new Dlg_crew_account.Callback() {
            @Override
            public void ok(CloseDialog closeDialog, Dlg_crew_account.OutputData data) {
                closeDialog.ok();
                My_services_crews.edit_my_services_created("" + id, created);
                int ids = -1;
                String account = "Services";
                String previledge = "Services-View/Encode";
                int status = 1;
                String user_id = "0";
                String user_name = data.user_name;

                My_services_crews.add_users2(screen_name, data.user_name, data.password, my_branch, my_branch_id, my_location, my_location_id);
                user_id = My_services_crews.lastId();
                User_previleges.to_user_previleges to3 = new User_previleges.to_user_previleges(0, account, previledge, status, user_id, user_name);
                User_previleges.add_user_previleges(to3);
                data_cols();
            }
        });
        nd.setLocationRelativeTo(jScrollPane2);
        nd.setVisible(true);
    }

    private void edit_my_services_crews() {
        int row = tbl_my_services_crews.getSelectedRow();
        if (row < 0) {
            return;
        }

    }

    private void clear_my_services_crews() {
        tf_fname.setText("");
        tf_mi.setText("");
        tf_lname.setText("");
        tf_address.setText("");
        tf_contact_no.setText("");

        tbl_my_services_crews.clearSelection();
        tf_fname.grabFocus();

    }

    private void delete_my_services_crews() {
        int row = tbl_my_services_crews.getSelectedRow();
        if (row < 0) {
            return;
        }
        to_my_services_crews to = (to_my_services_crews) tbl_my_services_crews_ALM.get(tbl_my_services_crews.convertRowIndexToModel(row));
        My_services_crews.delete_my_services_crews(to);
        data_cols();
        clear_my_services_crews();
    }

    List<My_services_departments.to_my_services_departments> department_list = new ArrayList();

    private void init_departments() {

        department_list = My_services_departments.ret_data(" order by department asc ");
        Object[][] obj = new Object[department_list.size()][1];
        int i = 0;
        for (My_services_departments.to_my_services_departments to : department_list) {
            obj[i][0] = to.department;
            i++;
        }
        JLabel[] labels = {};
        int[] tbl_widths_customers = {300};
        int width = 0;
        String[] col_names = {""};
        TableRenderer tr = new TableRenderer();
        TableRenderer.setPopup(tf_department, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {
                Field.Combo dep = (Field.Combo) tf_department;
                Field.Combo man = (Field.Combo) tf_manager;
                My_services_departments.to_my_services_departments to = department_list.get(data.selected_row);
                dep.setId("" + to.id);
                tf_department.setText("" + to.department);

                man.setText("" + to.manager);
                man.setId("" + to.manager_id);
            }
        });
    }

    private void init_departments2() {

        department_list = My_services_departments.ret_data(" order by department asc ");
        Object[][] obj = new Object[department_list.size()][1];
        int i = 0;
        for (My_services_departments.to_my_services_departments to : department_list) {
            obj[i][0] = to.department;
            i++;
        }
        JLabel[] labels = {};
        int[] tbl_widths_customers = {300};
        int width = 0;
        String[] col_names = {""};
        TableRenderer tr = new TableRenderer();
        TableRenderer.setPopup(tf_department1, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {
                Field.Combo dep = (Field.Combo) tf_department1;
                My_services_departments.to_my_services_departments to = department_list.get(data.selected_row);
                dep.setId("" + to.id);
                tf_department1.setText("" + to.department);
                data_cols();
            }
        });
    }
}
