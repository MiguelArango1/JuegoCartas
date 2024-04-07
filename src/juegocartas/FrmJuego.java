
package juegocartas;

import javax.swing.JOptionPane;

public class FrmJuego extends javax.swing.JFrame {
    Jugador jugador1=new Jugador();
    Jugador jugador2=new Jugador();     

    
    public FrmJuego() {
        initComponents();
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnRepartir = new javax.swing.JButton();
        btnVerificar = new javax.swing.JButton();
        tpJugadores = new javax.swing.JTabbedPane();
        pnlJugador1 = new javax.swing.JPanel();
        pnlJugador2 = new javax.swing.JPanel();
        btnOrdenar = new javax.swing.JButton();
        btnPuntaje = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnRepartir.setText("Repartir");
        btnRepartir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRepartirActionPerformed(evt);
            }
        });

        btnVerificar.setText("Verificar");
        btnVerificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerificarActionPerformed(evt);
            }
        });

        pnlJugador1.setBackground(new java.awt.Color(255, 204, 204));

        javax.swing.GroupLayout pnlJugador1Layout = new javax.swing.GroupLayout(pnlJugador1);
        pnlJugador1.setLayout(pnlJugador1Layout);
        pnlJugador1Layout.setHorizontalGroup(
            pnlJugador1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 394, Short.MAX_VALUE)
        );
        pnlJugador1Layout.setVerticalGroup(
            pnlJugador1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 190, Short.MAX_VALUE)
        );

        tpJugadores.addTab("Jugador1", pnlJugador1);

        pnlJugador2.setBackground(new java.awt.Color(255, 102, 102));

        javax.swing.GroupLayout pnlJugador2Layout = new javax.swing.GroupLayout(pnlJugador2);
        pnlJugador2.setLayout(pnlJugador2Layout);
        pnlJugador2Layout.setHorizontalGroup(
            pnlJugador2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 394, Short.MAX_VALUE)
        );
        pnlJugador2Layout.setVerticalGroup(
            pnlJugador2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 190, Short.MAX_VALUE)
        );

        tpJugadores.addTab("Jugador2", pnlJugador2);

        btnOrdenar.setText("Ordenar");
        btnOrdenar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrdenarActionPerformed(evt);
            }
        });

        btnPuntaje.setText("Puntaje");
        btnPuntaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPuntajeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tpJugadores)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnRepartir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnVerificar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnOrdenar)
                        .addGap(18, 18, 18)
                        .addComponent(btnPuntaje)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRepartir)
                    .addComponent(btnVerificar)
                    .addComponent(btnOrdenar)
                    .addComponent(btnPuntaje))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addComponent(tpJugadores, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRepartirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRepartirActionPerformed
        jugador1.repartir();
        jugador2.repartir();      
        
        
        jugador1.mostrarOrdenadoPorEscalera(pnlJugador1);
        jugador2.mostrarOrdenadoPorEscalera(pnlJugador2);
    }//GEN-LAST:event_btnRepartirActionPerformed

    private void btnVerificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerificarActionPerformed
    int pestaña = tpJugadores.getSelectedIndex();
    String mensaje = "";
    switch (pestaña) {
        case 0:
            if (!jugador1.haRepartido()) {
                JOptionPane.showMessageDialog(null, "No has repartido las cartas");
                return;
            }
            mensaje = jugador1.getGrupos();
            break;
        case 1:
            if (!jugador2.haRepartido()) {
                JOptionPane.showMessageDialog(null, "No has repartido las cartas.");
                return;
            }
            mensaje = jugador2.getGrupos();
            break;
    }
    JOptionPane.showMessageDialog(null, mensaje);

    }//GEN-LAST:event_btnVerificarActionPerformed

    private void btnOrdenarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrdenarActionPerformed
            jugador1.Ordenar();
            jugador2.Ordenar();
            
            jugador1.mostrar(pnlJugador1);
            jugador2.mostrar(pnlJugador2); 
    }//GEN-LAST:event_btnOrdenarActionPerformed

    private void btnPuntajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPuntajeActionPerformed
      int pestaña = tpJugadores.getSelectedIndex();
      if (!jugador1.haRepartido()) {
        JOptionPane.showMessageDialog(null, "No has repartido tus cartas");
        return;
    }
    int puntaje = 0;
    switch (pestaña) {
        case 0:
            puntaje = jugador1.calcularPuntaje();
            break;
        case 1:
            puntaje = jugador2.calcularPuntaje();
            break;
    }
    
    JOptionPane.showMessageDialog(null, "El puntaje del jugador es: " + puntaje);
      
    }//GEN-LAST:event_btnPuntajeActionPerformed

    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
        
            public void run() {
                new FrmJuego().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOrdenar;
    private javax.swing.JButton btnPuntaje;
    private javax.swing.JButton btnRepartir;
    private javax.swing.JButton btnVerificar;
    private javax.swing.JPanel pnlJugador1;
    private javax.swing.JPanel pnlJugador2;
    private javax.swing.JTabbedPane tpJugadores;
    // End of variables declaration//GEN-END:variables
}
