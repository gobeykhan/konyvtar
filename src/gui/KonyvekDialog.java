package gui;

import java.awt.Frame;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.LookAndFeel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import model.IModel;
import model.Konyv;

public class KonyvekDialog extends javax.swing.JDialog {

    private IModel model;
    private Frame parent;

    public KonyvekDialog(java.awt.Frame parent, IModel model) {

        super(parent, true);
        this.parent = parent;

        this.model = model;

        initComponents();
        setTitle("Könyvek karbantartása");
        setLocationRelativeTo(parent);

        listaFrissit();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        listKonyvek = new javax.swing.JList();
        bntUj = new javax.swing.JButton();
        btnModosit = new javax.swing.JButton();
        btnTorol = new javax.swing.JButton();
        btnOK = new javax.swing.JButton();
        tfKereses = new javax.swing.JTextField();
        lblKereses = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        listKonyvek.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(listKonyvek);

        bntUj.setText("Új");
        bntUj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntUjActionPerformed(evt);
            }
        });

        btnModosit.setText("Módósít");
        btnModosit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModositActionPerformed(evt);
            }
        });

        btnTorol.setText("Töröl");

        btnOK.setText("OK");
        btnOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOKActionPerformed(evt);
            }
        });

        tfKereses.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfKeresesKeyReleased(evt);
            }
        });

        lblKereses.setText("Név:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblKereses)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfKereses)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnModosit)
                    .addComponent(bntUj)
                    .addComponent(btnTorol)
                    .addComponent(btnOK))
                .addContainerGap(47, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {bntUj, btnModosit, btnOK, btnTorol});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bntUj)
                    .addComponent(tfKereses, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblKereses))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnModosit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnTorol)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnOK))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfKeresesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfKeresesKeyReleased

        listaFrissit();

    }//GEN-LAST:event_tfKeresesKeyReleased

    private void btnOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOKActionPerformed

        setVisible(false);
    }//GEN-LAST:event_btnOKActionPerformed

    private void bntUjActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntUjActionPerformed
        KonyvAdatokDialog kad = new KonyvAdatokDialog(parent, null);
        kad.setVisible(true);
        
        if(kad.isMentes()) {
            try {
                Konyv k = kad.getKonyv();
                model.addKonyv(k);
                listaFrissit();
                
            } catch (SQLException ex) {
                FoAblak.hibaAblak(ex);
            }
        }


    }//GEN-LAST:event_bntUjActionPerformed

    private void btnModositActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModositActionPerformed
        
           Konyv kivalasztott = (Konyv) listKonyvek.getSelectedValue();
        if (kivalasztott != null) {
            KonyvAdatokDialog kad = new KonyvAdatokDialog(parent, kivalasztott);
            kad.setVisible(true);

            if (kad.isMentes()) {
                try {
                    Konyv k = kivalasztott;//ugyanaz mint a kivalasztott
                    model.updateKonyv(k);
                    listaFrissit();
                } catch (SQLException ex) {
                    FoAblak.hibaAblak(ex);
                }
            }

        } else {
            JOptionPane.showMessageDialog(parent, "Nincs kiválasztva könyv!!",
                    "Hiányos adat", JOptionPane.WARNING_MESSAGE);
        }
        

    }//GEN-LAST:event_btnModositActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntUj;
    private javax.swing.JButton btnModosit;
    private javax.swing.JButton btnOK;
    private javax.swing.JButton btnTorol;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblKereses;
    private javax.swing.JList listKonyvek;
    private javax.swing.JTextField tfKereses;
    // End of variables declaration//GEN-END:variables

    private void listaFrissit() {

        List<Konyv> konyvek;
        System.out.println("teszt");

        try {
            konyvek = model.getKonyvekByNev(tfKereses.getText());
            listKonyvek.setListData(konyvek.toArray());
        } catch (SQLException ex) {
            Logger.getLogger(KonyvekDialog.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
