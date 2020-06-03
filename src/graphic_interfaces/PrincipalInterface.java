/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphic_interfaces;

import javax.swing.ImageIcon;

/**
 *
 * @author danie
 */
public class PrincipalInterface extends javax.swing.JFrame {

    /**
     * Creates new form PrincipalInterface
     */
    public PrincipalInterface() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setIconImage(new ImageIcon(getClass().getResource("/images/Icon_App.png")).getImage());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Panel_MenuBar = new javax.swing.JPanel();
        Label_ExitButton = new javax.swing.JLabel();
        Panel_Home = new javax.swing.JPanel();
        Label_ReportsTittle = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Panel_MenuBar.setBackground(new java.awt.Color(255, 97, 50));

        Label_ExitButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Icon_ExitDoorWhite_32px.png"))); // NOI18N
        Label_ExitButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Label_ExitButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Label_ExitButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout Panel_MenuBarLayout = new javax.swing.GroupLayout(Panel_MenuBar);
        Panel_MenuBar.setLayout(Panel_MenuBarLayout);
        Panel_MenuBarLayout.setHorizontalGroup(
            Panel_MenuBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_MenuBarLayout.createSequentialGroup()
                .addContainerGap(606, Short.MAX_VALUE)
                .addComponent(Label_ExitButton)
                .addContainerGap())
        );
        Panel_MenuBarLayout.setVerticalGroup(
            Panel_MenuBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Label_ExitButton, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        getContentPane().add(Panel_MenuBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 40));

        Panel_Home.setBackground(new java.awt.Color(255, 255, 255));
        Panel_Home.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153), 2));

        Label_ReportsTittle.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        Label_ReportsTittle.setForeground(new java.awt.Color(255, 97, 50));
        Label_ReportsTittle.setText("Generar Reportes");

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Icon_OrangePDF.png"))); // NOI18N
        jButton1.setBorderPainted(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setFocusPainted(false);

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Icon_Maintenance_96px.png"))); // NOI18N
        jButton2.setBorderPainted(false);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.setFocusPainted(false);

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Icon_OrangePDF.png"))); // NOI18N
        jButton3.setBorderPainted(false);
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.setFocusPainted(false);

        javax.swing.GroupLayout Panel_HomeLayout = new javax.swing.GroupLayout(Panel_Home);
        Panel_Home.setLayout(Panel_HomeLayout);
        Panel_HomeLayout.setHorizontalGroup(
            Panel_HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_HomeLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(Panel_HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jButton1)
                    .addComponent(Label_ReportsTittle))
                .addGap(64, 64, 64)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addGap(53, 53, 53))
        );
        Panel_HomeLayout.setVerticalGroup(
            Panel_HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_HomeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Label_ReportsTittle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Panel_HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(234, Short.MAX_VALUE))
        );

        getContentPane().add(Panel_Home, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 650, 390));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Label_ExitButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label_ExitButtonMouseClicked
        System.exit(0);
    }//GEN-LAST:event_Label_ExitButtonMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PrincipalInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PrincipalInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PrincipalInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrincipalInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PrincipalInterface().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Label_ExitButton;
    private javax.swing.JLabel Label_ReportsTittle;
    private javax.swing.JPanel Panel_Home;
    private javax.swing.JPanel Panel_MenuBar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    // End of variables declaration//GEN-END:variables
}
