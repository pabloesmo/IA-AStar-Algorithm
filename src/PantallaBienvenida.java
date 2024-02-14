import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PantallaBienvenida extends JFrame {
	
	JPanel panelBoton = new JPanel();
	JPanel panelEtiqueta = new JPanel();
	JPanel panelPrincipal = new JPanel();
	
    public PantallaBienvenida() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Proyecto IA Grupo 9");
        setSize(500, 400);
        setLocationRelativeTo(null);
        
        panelPrincipal.setLayout(new GridBagLayout()); // Establecer un GridBagLayout para centrar los componentes
        
        
        JLabel etiqueta = new JLabel("¡Bienvenido a nuestra app del metro de Lyon!");
        Font fuente = etiqueta.getFont();
        etiqueta.setFont(new Font(fuente.getFontName(), Font.PLAIN, 22)); // Tamaño de fuente 20
              
        
        JButton botonAbrir = new JButton("Acceder");
        botonAbrir.addActionListener(e -> {
            IGrafica ig = new IGrafica();
            ig.setVisible(true);
            ig.crearInterfaz();
            dispose(); // Cierra la ventana de bienvenida al abrir Display
        });
        
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Espaciado entre componentes
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        panelPrincipal.add(etiqueta, gbc);

        gbc.gridy = 1;
        panelPrincipal.add(botonAbrir, gbc);
       
          
        add(panelPrincipal);
        setVisible(true);
    }
}
