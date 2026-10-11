
package group.fantasy;
import java.awt.Color;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;

public class NewJFrameCrearEquipo extends javax.swing.JFrame {
private int presupuesto;
private JLabel etiquetaPresupuesto;
private JLabel tituloJugadores;
private int valor;
    
public NewJFrameCrearEquipo(String nombreEquipo, int presupuesto) {
    initComponents();
    this.presupuesto = presupuesto;
    JPanel panelJugador = new JPanel();
    

    setTitle("Crear equipo");
    setSize(800, 600);
    setResizable(false);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(new FlowLayout(FlowLayout.CENTER, 20, 12));

    getContentPane().setBackground(new Color(20, 30, 45));

    JLabel etiquetaEquipo = new JLabel("Equipo: " + nombreEquipo);
    etiquetaEquipo.setForeground(Color.WHITE);
    etiquetaEquipo.setFont(new Font("SansSerif", Font.BOLD, 20));
    etiquetaEquipo.setPreferredSize(new Dimension(740, 32));
    etiquetaEquipo.setHorizontalAlignment(JLabel.CENTER);
    add(etiquetaEquipo);

    etiquetaPresupuesto =
            new JLabel("Presupuesto: " + this.presupuesto + " millones");

    etiquetaPresupuesto.setForeground(new Color(80, 220, 150));
    etiquetaPresupuesto.setFont(new Font("SansSerif", Font.BOLD, 18));
    etiquetaPresupuesto.setPreferredSize(new Dimension(740, 28));
    etiquetaPresupuesto.setHorizontalAlignment(JLabel.CENTER);
    add(etiquetaPresupuesto);

    JLabel tituloJugadores = new JLabel ("JUGADORES");
    tituloJugadores.setForeground(new Color(80,220,150));
    tituloJugadores.setFont(new Font ("SansSerif", Font.BOLD, 18));
    tituloJugadores.setPreferredSize(new java.awt.Dimension(740, 28));
    tituloJugadores.setHorizontalAlignment(JLabel.CENTER);
    add(tituloJugadores);
    
    // Tres tarjetas por fila; las siguientes filas se recorren verticalmente.
    panelJugador.setLayout(new java.awt.GridLayout(0, 3, 16, 16));
    panelJugador.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
    panelJugador.setBackground(new Color(20, 30, 45));
    
    panelJugador.add(crearTarjeta("Lamine Yamal", "lamine.jpg", 30));
    panelJugador.add(crearTarjeta("Antony", "antony.jpg", 15));
    panelJugador.add(crearTarjeta("Courtois", "courtois.jpg", 20,
            "https://a.espncdn.com/i/headshots/soccer/players/full/134283.png"));
    panelJugador.add(crearTarjeta("Mbappé", "mbappe.jpg", 35,
            "https://a.espncdn.com/i/headshots/soccer/players/full/231388.png"));
    panelJugador.add(crearTarjeta("Pedri", "pedri.jpg", 25));
    panelJugador.add(crearTarjeta("Raphinha", "raphinna.jpg", 25));
    panelJugador.add(crearTarjeta("Valverde", "valverde.jpg", 25));

    javax.swing.JScrollPane scrollJugadores = new javax.swing.JScrollPane(
            panelJugador,
            javax.swing.JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
            javax.swing.JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    scrollJugadores.setPreferredSize(new Dimension(740, 390));
    scrollJugadores.setBorder(null);
    scrollJugadores.getViewport().setBackground(new Color(20, 30, 45));
    scrollJugadores.getVerticalScrollBar().setUnitIncrement(24);
    add(scrollJugadores);
    setLocationRelativeTo(null);
}
    
    // Cada llamada crea una tarjeta con su propia imagen, nombre y precio.
    private JPanel crearTarjeta(String nombre, String archivoImagen, int precio) {
        return crearTarjeta(nombre, archivoImagen, precio, null);
    }

    private JPanel crearTarjeta(String nombre, String archivoImagen, int precio,
            String urlImagen) {
        JPanel tarjeta = new JPanel();
        tarjeta.setLayout(new BoxLayout(tarjeta, BoxLayout.Y_AXIS));
        tarjeta.setBackground(new Color(35, 48, 65));
        tarjeta.setPreferredSize(new Dimension(200, 320));
        tarjeta.setBorder(javax.swing.BorderFactory.createCompoundBorder(
                javax.swing.BorderFactory.createLineBorder(new Color(55, 74, 94)),
                javax.swing.BorderFactory.createEmptyBorder(10, 8, 10, 8)));

        URL ruta = getClass().getResource("/" + archivoImagen);
        if (ruta == null) {
            throw new IllegalArgumentException("No se encuentra la imagen: " + archivoImagen);
        }
        ImageIcon original = new ImageIcon(ruta);
        if (original.getIconWidth() <= 0 || original.getIconHeight() <= 0) {
            throw new IllegalArgumentException("No se puede leer la imagen: " + archivoImagen);
        }
        
        double escala = Math.min(120.0 / original.getIconWidth(),
                160.0 / original.getIconHeight());
        int ancho = Math.max(1, (int) (original.getIconWidth() * escala));
        int alto = Math.max(1, (int) (original.getIconHeight() * escala));
        Image imagenEscalada = original.getImage().getScaledInstance(
                ancho, alto, Image.SCALE_SMOOTH);
        JLabel fotoJugador = new JLabel(new ImageIcon(imagenEscalada));
        fotoJugador.setAlignmentX(java.awt.Component.CENTER_ALIGNMENT);
        fotoJugador.setPreferredSize(new Dimension(180, 170));
        fotoJugador.setMaximumSize(new Dimension(180, 170));

        if (urlImagen != null) {
            // Cargar en segundo plano permite seguir usando los botones.
            new javax.swing.SwingWorker<ImageIcon, Void>() {
                @Override
                protected ImageIcon doInBackground() throws Exception {
                    URL url = java.net.URI.create(urlImagen).toURL();
                    java.net.URLConnection conexion = url.openConnection();
                    conexion.setConnectTimeout(5000);
                    conexion.setReadTimeout(5000);
                    try (java.io.InputStream entrada = conexion.getInputStream()) {
                        ImageIcon iconoInternet = new ImageIcon(entrada.readAllBytes());
                        if (iconoInternet.getIconWidth() <= 0
                                || iconoInternet.getIconHeight() <= 0) {
                            throw new java.io.IOException("La URL no contiene una imagen válida");
                        }
                        double proporcion = Math.min(120.0 / iconoInternet.getIconWidth(),
                                160.0 / iconoInternet.getIconHeight());
                        int nuevoAncho = Math.max(1,
                                (int) (iconoInternet.getIconWidth() * proporcion));
                        int nuevoAlto = Math.max(1,
                                (int) (iconoInternet.getIconHeight() * proporcion));
                        Image escalada = iconoInternet.getImage().getScaledInstance(
                                nuevoAncho, nuevoAlto, Image.SCALE_SMOOTH);
                        return new ImageIcon(escalada);
                    }
                }

                @Override
                protected void done() {
                    try {
                        fotoJugador.setIcon(get());
                    } catch (Exception ex) {
                        // Si no hay conexión, se conserva la foto del proyecto.
                        System.err.println("No se pudo cargar la foto de internet de "
                                + nombre + "; se usa la imagen local.");
                    }
                }
            }.execute();
        }

        JLabel nombreJugador = new JLabel(nombre);
        nombreJugador.setForeground(Color.WHITE);
        nombreJugador.setFont(new Font("SansSerif", Font.BOLD, 16));
        nombreJugador.setAlignmentX(java.awt.Component.CENTER_ALIGNMENT);

        JLabel etiquetaPrecio = new JLabel("Precio: " + precio + " millones.");
        etiquetaPrecio.setForeground(new Color(80, 220, 150));
        etiquetaPrecio.setFont(new Font("SansSerif", Font.BOLD, 14));
        etiquetaPrecio.setAlignmentX(java.awt.Component.CENTER_ALIGNMENT);

        JButton botonComprar = new JButton("Comprar");
        botonComprar.setAlignmentX(java.awt.Component.CENTER_ALIGNMENT);
        JButton venderJugador = new JButton("Vender");
        venderJugador.setAlignmentX(java.awt.Component.CENTER_ALIGNMENT);
        venderJugador.setEnabled(false);
        botonComprar.setBackground(new Color(40, 180, 100));
        botonComprar.setForeground(Color.WHITE);
        venderJugador.setBackground(new Color(55, 74, 94));
        venderJugador.setForeground(Color.WHITE);
        for (JButton boton : new JButton[]{botonComprar, venderJugador}) {
            boton.setFont(new Font("SansSerif", Font.BOLD, 14));
            boton.setFocusPainted(false);
            boton.setMaximumSize(new Dimension(160, 30));
        }
        
        tarjeta.add(fotoJugador);
        tarjeta.add(nombreJugador);
        tarjeta.add(javax.swing.Box.createVerticalStrut(6));
        tarjeta.add(etiquetaPrecio);
        tarjeta.add(javax.swing.Box.createVerticalStrut(10));
        tarjeta.add(botonComprar);
        tarjeta.add(javax.swing.Box.createVerticalStrut(6));
        tarjeta.add(venderJugador);
        botonComprar.addActionListener(e -> {
    if (this.presupuesto >= precio) {
        this.presupuesto -= precio;

        etiquetaPresupuesto.setText(
                "Presupuesto: " + this.presupuesto + " millones"
        );

        etiquetaPrecio.setText("Comprado");
        botonComprar.setEnabled(false);
        venderJugador.setEnabled(true);
    }
});
        venderJugador.addActionListener(e -> {
            this.presupuesto += precio;
            etiquetaPresupuesto.setText(
                    "Presupuesto: " + this.presupuesto + " millones");
            etiquetaPrecio.setText("Precio: " + precio + " millones.");
            botonComprar.setEnabled(true);
            venderJugador.setEnabled(false);
        });
        return tarjeta;
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
            java.util.logging.Logger.getLogger(NewJFrameCrearEquipo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrameCrearEquipo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrameCrearEquipo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrameCrearEquipo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrameCrearEquipo("Equipo de prueba", 100).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
