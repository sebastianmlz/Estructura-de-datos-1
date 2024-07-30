/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Presentacion;
import Negocio.Carton;
import Negocio.Juego;
import javax.swing.*;
import java.awt.*;


/**
 *
 * @author PC
 */
public class FBingo extends javax.swing.JFrame {

    private Juego juego;
    private int cartonActual;
    
    private boolean filaLlenaNotificada = false;

    /**
     * Creates new form BingoGUI
     */
    public FBingo() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGenerarNumero = new javax.swing.JButton();
        btnGenerar = new javax.swing.JButton();
        txtRangoNumeros = new javax.swing.JTextField();
        lblTotalNumeros = new javax.swing.JLabel();
        txtCantidadCartones = new javax.swing.JTextField();
        panelCarton = new javax.swing.JPanel();
        lblCartonActual = new javax.swing.JLabel();
        btnMostrarC = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtCarton = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtCantNume = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnReiniciar = new javax.swing.JButton();
        lblNumeroGenerado = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("BINGO!");

        btnGenerarNumero.setText("Generar Numeros");
        btnGenerarNumero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarNumeroActionPerformed(evt);
            }
        });

        btnGenerar.setText("Generar Carton");
        btnGenerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarActionPerformed(evt);
            }
        });

        lblTotalNumeros.setText("Rango Numeros 0-n");
        lblTotalNumeros.setToolTipText("");

        txtCantidadCartones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCantidadCartonesActionPerformed(evt);
            }
        });

        panelCarton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout panelCartonLayout = new javax.swing.GroupLayout(panelCarton);
        panelCarton.setLayout(panelCartonLayout);
        panelCartonLayout.setHorizontalGroup(
            panelCartonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 290, Short.MAX_VALUE)
        );
        panelCartonLayout.setVerticalGroup(
            panelCartonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 288, Short.MAX_VALUE)
        );

        lblCartonActual.setText("Cantidad de cartones:");

        btnMostrarC.setText("Mostrar carton");
        btnMostrarC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarCActionPerformed(evt);
            }
        });

        jLabel1.setText("Numero de carton:");

        jLabel2.setText("Cantidad de numeros:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel3.setText("JUEGO BINGO");
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        btnReiniciar.setText("Reiniciar ");
        btnReiniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReiniciarActionPerformed(evt);
            }
        });

        lblNumeroGenerado.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btnGenerar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnGenerarNumero, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(lblTotalNumeros)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtRangoNumeros, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtCantNume, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtCantidadCartones, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblCartonActual, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(btnReiniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNumeroGenerado, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 88, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCarton, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnMostrarC))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(panelCarton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)))
                .addGap(63, 63, 63))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel3)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(lblCartonActual)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCantidadCartones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblTotalNumeros)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtRangoNumeros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCantNume, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnGenerar)
                        .addGap(43, 43, 43)
                        .addComponent(btnGenerarNumero)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblNumeroGenerado, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnMostrarC)
                            .addComponent(jLabel1)
                            .addComponent(txtCarton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(panelCarton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnReiniciar)
                .addGap(70, 70, 70))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnGenerarNumeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarNumeroActionPerformed
          if (juego == null) {
            JOptionPane.showMessageDialog(this, "Primero debe generar los cartones.");
            return;
        }
        juego.jugar();
        lblNumeroGenerado.setText("Número generado: " + juego.nume);

        juego.marcarCartones(juego.nume);
        mostrarCarton(cartonActual);

        // Verificar si algún cartón tiene una fila llena o está lleno
        for(int i=1; i<=juego.getCantidadCartones(); i++){
            if (juego.getCarton(i).PrimeraFilaLlena() && !filaLlenaNotificada) {
                JOptionPane.showMessageDialog(this, "¡Primera Fila llena en el cartón ID: " + i + "!");
                filaLlenaNotificada = true;
                mostrarCarton(i);
                txtCarton.setText(Integer.toString(i));
            }
            if (juego.getCarton(i).cartonLleno()) {
                mostrarCarton(i);
                txtCarton.setText(Integer.toString(i));
                JOptionPane.showMessageDialog(this, "¡Bingo! Cartón lleno ID: " + i);
                break;
            }
        }      
    }//GEN-LAST:event_btnGenerarNumeroActionPerformed

    private void btnGenerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarActionPerformed
     try {
            int cantidadCartones = Integer.parseInt(txtCantidadCartones.getText());
            int rangoNumeros = Integer.parseInt(txtRangoNumeros.getText());
            int cantidadNumeros = Integer.parseInt(txtCantNume.getText());           
            juego = new Juego(cantidadCartones, rangoNumeros, cantidadNumeros); // Inicializa el juego con múltiples cartones
            cartonActual = 1;
            filaLlenaNotificada = false;
            
            mostrarCarton(cartonActual);     
            txtCarton.setText(Integer.toString(cartonActual));
            JOptionPane.showMessageDialog(this, "Los cartones se generaron correctamente\nPara jugar presione el boton de GENERAR NUMERO"
                                            +"\nDisfrute el juego!");
     } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese números válidos para la cantidad de cartones y de números dentro del rango");
        }
    }//GEN-LAST:event_btnGenerarActionPerformed

    private void btnMostrarCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarCActionPerformed
        int carton = Integer.parseInt(txtCarton.getText());
        if((carton >=1 ) && (carton <= juego.getCantidadCartones())){
            mostrarCarton(carton);
        }else{
            JOptionPane.showMessageDialog(this, "Numero de carton inexistente", "Mostrar Carton", JOptionPane.ERROR_MESSAGE);
        }  
    }//GEN-LAST:event_btnMostrarCActionPerformed
  
    private void btnReiniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReiniciarActionPerformed
        panelCarton.removeAll();
        panelCarton.revalidate();
        panelCarton.repaint();
        txtCantidadCartones.setText("");
        txtRangoNumeros.setText("");
        txtCantNume.setText("");
        txtCarton.setText("");
    }//GEN-LAST:event_btnReiniciarActionPerformed

    private void txtCantidadCartonesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantidadCartonesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCantidadCartonesActionPerformed
  
    private void mostrarCarton(int numCarton) {
        panelCarton.removeAll();
        if (juego.getCantidadCartones() == 0) {
            return;
        }
        Carton carton = juego.getCarton(numCarton); // Mostramos el cartón actual

        int cellWidth = 60;
        int cellHeight = 60;

        panelCarton.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(2, 2, 2, 2);
        gbc.fill = GridBagConstraints.BOTH;

        int filas = carton.getFilas();
        int columnas = carton.getColumnas();
        int totalCasillas = filas * columnas;

        // Obtener los números del cartón
        int num = 0;
        int ant= num;
        for (int i = 0; i < totalCasillas; i++) {
            JLabel label = new JLabel();
            label.setHorizontalAlignment(SwingConstants.CENTER);
            label.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
            label.setOpaque(true);
            label.setFont(new Font("Arial", Font.BOLD, 20));
            label.setPreferredSize(new Dimension(cellWidth, cellHeight));

            gbc.gridx = (i % columnas);
            gbc.gridy = (i / columnas);
            num=ant;
            for(int j=num+1; j<=juego.getRangoF(); j++){
                if(carton.getC().Pertenece(j)|| carton.getCopia().Pertenece(j)){
                    if(carton.getC().Pertenece(j)){
                        label.setText(String.valueOf(j));
                        label.setBackground(Color.WHITE);
                        label.setForeground(Color.BLACK);
                    }else{
                        if(carton.getCopia().Pertenece(j)){
                            label.setText(String.valueOf(j));
                            label.setBackground(Color.RED);
                            label.setForeground(Color.WHITE);
                        }
                    }
                    ant = j;
                    j = juego.getRangoF();
                }else {
                    label.setText(" ");
                    label.setBackground(Color.LIGHT_GRAY);
                }
            }
            panelCarton.add(label, gbc);
        }
        panelCarton.revalidate();
        panelCarton.repaint();
    }

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
            java.util.logging.Logger.getLogger(FBingo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FBingo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FBingo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FBingo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FBingo().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGenerar;
    private javax.swing.JButton btnGenerarNumero;
    private javax.swing.JButton btnMostrarC;
    private javax.swing.JButton btnReiniciar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblCartonActual;
    private javax.swing.JLabel lblNumeroGenerado;
    private javax.swing.JLabel lblTotalNumeros;
    private javax.swing.JPanel panelCarton;
    private javax.swing.JTextField txtCantNume;
    private javax.swing.JTextField txtCantidadCartones;
    private javax.swing.JTextField txtCarton;
    private javax.swing.JTextField txtRangoNumeros;
    // End of variables declaration//GEN-END:variables
}
