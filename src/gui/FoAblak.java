package gui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.DBModel;
import model.IModel;

public class FoAblak extends javax.swing.JFrame {

    private IModel model;

    public FoAblak() {
        initComponents();
        setTitle("Könyvtár v0.1");

        String connUrl = "jdbc:mysql://localhost:3306/konyvtar";
        String user = "root";
        String pass = "1234";

        try {
            Connection conn = DriverManager.getConnection(connUrl, user, pass);
            model = new DBModel(conn);

        } catch (SQLException ex) {

        }
    }

    public static void hibaAblak(Exception ex) {
        JOptionPane.showMessageDialog(null, ex.toString(), "Hiba", JOptionPane.ERROR_MESSAGE);
        System.exit(-1);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuBar1 = new javax.swing.JMenuBar();
        jmFajl = new javax.swing.JMenu();
        miKilepes = new javax.swing.JMenuItem();
        jmAdatok = new javax.swing.JMenu();
        miKonyvek = new javax.swing.JMenuItem();
        imTagok = new javax.swing.JMenuItem();

        jMenuItem3.setText("jMenuItem3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jmFajl.setText("Fájl");

        miKilepes.setText("Kilépés");
        jmFajl.add(miKilepes);

        jMenuBar1.add(jmFajl);

        jmAdatok.setText("Adatok");

        miKonyvek.setText("Könyvek");
        miKonyvek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miKonyvekActionPerformed(evt);
            }
        });
        jmAdatok.add(miKonyvek);

        imTagok.setText("Tagok");
        jmAdatok.add(imTagok);

        jMenuBar1.add(jmAdatok);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 775, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 663, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void miKonyvekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miKonyvekActionPerformed

        KonyvekDialog kd = new KonyvekDialog(this, model);
        kd.setVisible(true);
    }//GEN-LAST:event_miKonyvekActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> {
            new FoAblak().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem imTagok;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenu jmAdatok;
    private javax.swing.JMenu jmFajl;
    private javax.swing.JMenuItem miKilepes;
    private javax.swing.JMenuItem miKonyvek;
    // End of variables declaration//GEN-END:variables
}
