
package group.fantasy;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JDialog;
import java.awt.Color;
import java.awt.Font;

public class NewJFrameFantasy extends javax.swing.JFrame {
   int presupuesto = 100;
   JTextField campoNombre;
   JLabel titulo;
   JButton botonCrearEquipo;
    public NewJFrameFantasy() {
    
    initComponents();

    setTitle("Fantasy");
    setSize(800, 600);
    setResizable(false);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);

    setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
    
    titulo = new JLabel("Bienvenido a FantasyFoot");
    botonCrearEquipo = new JButton("Crear Equipo");
    campoNombre = new JTextField(20);

    getContentPane().setBackground(new Color(20, 30, 45));

    titulo.setForeground(Color.WHITE);
    titulo.setFont(new Font("SansSerif", Font.BOLD, 20));

    JLabel etiquetaNombre = new JLabel("Nombre del equipo");
    etiquetaNombre.setForeground(Color.WHITE);
    etiquetaNombre.setFont(new Font("SansSerif", Font.PLAIN, 16));

    campoNombre.setBackground(new Color(35, 48, 65));
    campoNombre.setForeground(Color.WHITE);
    campoNombre.setCaretColor(Color.WHITE);
    campoNombre.setFont(new Font("SansSerif", Font.PLAIN, 16));

    botonCrearEquipo.setBackground(new Color(40, 180, 100));
    botonCrearEquipo.setForeground(Color.WHITE);
    botonCrearEquipo.setFont(new Font("SansSerif", Font.BOLD, 14));

    add(titulo);
    add(etiquetaNombre);
    add(campoNombre);
    add(botonCrearEquipo);
    
    
   botonCrearEquipo.addActionListener(e -> {
    String nombreEquipo = campoNombre.getText().trim();

    if (nombreEquipo.isEmpty()) {
        JDialog aviso = new JDialog(this, "Aviso", true);
        aviso.setLayout(new FlowLayout());

        aviso.add(new JLabel("Introduce un nombre para el equipo."));

        JButton aceptar = new JButton("Aceptar");
        aceptar.addActionListener(evento -> aviso.dispose());
        aviso.add(aceptar);

        aviso.setSize(350, 150);
        aviso.setResizable(false);
        aviso.setLocationRelativeTo(this);
        aviso.setVisible(true);

        return;
    }

    NewJFrameCrearEquipo ventana =
            new NewJFrameCrearEquipo(nombreEquipo, presupuesto);

    ventana.setVisible(true);
    dispose();
});
}
    

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(NewJFrameFantasy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrameFantasy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrameFantasy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrameFantasy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrameFantasy().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
