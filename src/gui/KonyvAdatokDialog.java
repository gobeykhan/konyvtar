package gui;

import model.Konyv;

public class KonyvAdatokDialog extends javax.swing.JDialog {

    private Konyv konyv;
    private boolean mentes;
    
    
    public KonyvAdatokDialog(java.awt.Frame parent, Konyv konyv) {
        super(parent, true);
        initComponents();
        mentes = false;

        this.konyv = konyv;
        if (konyv != null) {
            setTitle("Könyv módósítása");
            tfCim.setText(konyv.getCim());
            tfSzerzo.setText(konyv.getSzerzo());
            tfOldalszam.setText(konyv.getOldalszam() +" ");
        } else {
            setTitle("Új könyv felvétele");

        }

        setLocationRelativeTo(parent);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblCim = new javax.swing.JLabel();
        lblSzerzo = new javax.swing.JLabel();
        lblOldalszam = new javax.swing.JLabel();
        tfCim = new javax.swing.JTextField();
        tfSzerzo = new javax.swing.JTextField();
        tfOldalszam = new javax.swing.JTextField();
        btnMegse = new javax.swing.JButton();
        btnMentes = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblCim.setText("Cím:");

        lblSzerzo.setText("Szerző:");

        lblOldalszam.setText("Oldalszám:");

        btnMegse.setText("Mégsem");
        btnMegse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMegseActionPerformed(evt);
            }
        });

        btnMentes.setText("Mentés");
        btnMentes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMentesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCim)
                            .addComponent(lblSzerzo)
                            .addComponent(lblOldalszam))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfOldalszam, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfSzerzo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfCim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnMentes)
                        .addGap(18, 18, 18)
                        .addComponent(btnMegse)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {tfCim, tfOldalszam, tfSzerzo});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCim)
                    .addComponent(tfCim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSzerzo)
                    .addComponent(tfSzerzo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblOldalszam)
                    .addComponent(tfOldalszam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMentes)
                    .addComponent(btnMegse))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMegseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMegseActionPerformed
        setVisible(false);
        mentes = false;
    }//GEN-LAST:event_btnMegseActionPerformed

    private void btnMentesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMentesActionPerformed
        mentes = true;
        
        if(konyv == null) {
            konyv = new Konyv();
            
            konyv.setCim(tfCim.getText());
            konyv.setSzerzo(tfSzerzo.getText());
            
            
            
        }
        setVisible(false);
        
    }//GEN-LAST:event_btnMentesActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMegse;
    private javax.swing.JButton btnMentes;
    private javax.swing.JLabel lblCim;
    private javax.swing.JLabel lblOldalszam;
    private javax.swing.JLabel lblSzerzo;
    private javax.swing.JTextField tfCim;
    private javax.swing.JTextField tfOldalszam;
    private javax.swing.JTextField tfSzerzo;
    // End of variables declaration//GEN-END:variables

    public Konyv getKonyv() {
        return konyv;
    }

    public boolean isMentes() {
        return mentes;
    }
}
