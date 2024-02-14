import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import es.upm.aedlib.graph.UndirectedAdjacencyListGraph;
import es.upm.aedlib.graph.Vertex;

public class IGrafica extends JFrame {

    ArrayList<Estacion> lista = new ArrayList<Estacion>();
	private JComboBox<String> listaDesplegable1;
    private JComboBox<String> listaDesplegable2;
    private String seleccionOrigen;
    private String seleccionDestino;
    private BufferedImage backgroundImage; 
    private JPanel panelBoton = new JPanel();
    private JPanel panelListas = new JPanel();
    private JPanel panelEtiqueta = new JPanel();
    private JPanel panelResultado = new JPanel();
    private String[] listaOrigen = {"Cuire", "Hénon", "Croix-Rousse", "Croix-Paquet",
            "Hôtel de Ville Louis Pradel", "Cordeliers", "Bellecour", "Foch", "Masséna", 
            "Ampère Victor Hugo", "Perrache", "Charpennes Charles Hernu",
            "République Villeurbanne", "Gratte-Ciel", "Flachet",
            "Cusset", "Laurent Bonnevay Astroballe", "Vaulx-en-Velin La Sole",
            "Gare de Vaise", "Valmy", "Gorge de Loup", "Vieux Lyon Cathédrale St. Jean",
            "Guillotière", "Saxe Gambetta", "Garibaldi", "Sans-Souci", "Monplaisir-Lumière",
            "Grange Blanche", "Laënnec", "Mermoz Pinel", "Parilly", "Gare de Vénissieux",
            "Brotteaux", "Gare Part-Dieu Vivier Merle", "Place Guichard Bourse du Travail", "Jean Macé",
            "Place Jean Jaurès", "Debourg", "Stade de Gerland", "Oullins Gare"};
    private String[] listaDestino = {"Cuire", "Hénon", "Croix-Rousse", "Croix-Paquet",
            "Hôtel de Ville Louis Pradel", "Cordeliers", "Bellecour", "Foch", "Masséna", 
            "Ampère Victor Hugo", "Perrache", "Charpennes Charles Hernu",
            "République Villeurbanne", "Gratte-Ciel", "Flachet",
            "Cusset", "Laurent Bonnevay Astroballe", "Vaulx-en-Velin La Sole",
            "Gare de Vaise", "Valmy", "Gorge de Loup", "Vieux Lyon Cathédrale St. Jean",
            "Guillotière", "Saxe Gambetta", "Garibaldi", "Sans-Souci", "Monplaisir-Lumière",
            "Grange Blanche", "Laënnec", "Mermoz Pinel", "Parilly", "Gare de Vénissieux",
            "Brotteaux", "Gare Part-Dieu Vivier Merle", "Place Guichard Bourse du Travail", "Jean Macé",
            "Place Jean Jaurès", "Debourg", "Stade de Gerland", "Oullins Gare"};
    
    public static RedMetro mapa = new RedMetro(); 

    public void crearInterfaz() {
    	//---------------------VENTANA---------------------
    	//-------------------------------------------------
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Metro de Lyon");
        setSize(400, 400);
        setBounds(700, 50, 800, 800);
        
        setLocationRelativeTo(null);
        //-------------------------------------------------
        //-------------------------------------------------
        
        
        //---------------------IMAGEN----------------------
    	//-------------------------------------------------
        try {
            backgroundImage = ImageIO.read(new File("Resources/metro.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //-------------------------------------------------
        //-------------------------------------------------
        
        
        JPanel panelPrincipal = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (backgroundImage != null) {
                    g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
                }
            }
        };
        panelPrincipal.setPreferredSize(new Dimension(200, 200));
        panelPrincipal.setLayout(null); // Establece un null layou
        
        
        //---------------------LISTAS----------------------
    	//-------------------------------------------------        
        panelListas.setLayout(new BoxLayout(panelListas, BoxLayout.X_AXIS));
        panelListas.setBounds(20, 580, 540, 35); // Cambia las coordenadas y dimensiones según necesites
        panelListas.setOpaque(false); // Establece el panel como no opaco para lograr transparencia


        //LISTA 1 DESPLEGABLE
        listaDesplegable1 = new JComboBox<>(listaOrigen);
        listaDesplegable1.setMaximumSize(new Dimension(160, 30));
        //LISTA 2 DESPLEGABLE
        listaDesplegable2 = new JComboBox<>(listaDestino);
        listaDesplegable2.setMaximumSize(new Dimension(160, 30));
        
        //Meto la 1 en el PANEL
        panelListas.add(listaDesplegable1);
        //*********************************************************
        panelListas.add(Box.createRigidArea(new Dimension(20, 0)));
        //*********************************************************
        //Meto la 2 en el PANEL
        panelListas.add(listaDesplegable2);
        
        //ACCIONES DE LAS LISTAS
        listaDesplegable1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JComboBox<?> combo = (JComboBox<?>) e.getSource();
                seleccionOrigen = (String) combo.getSelectedItem();
                System.out.println("Origen seleccionado: " + seleccionOrigen);
            }
        });
        listaDesplegable2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JComboBox<?> combo = (JComboBox<?>) e.getSource();
                seleccionDestino = (String) combo.getSelectedItem();
                System.out.println("Destino seleccionado: " + seleccionDestino);
            }
        });
        panelPrincipal.add(panelListas);
        //-------------------------------------------------
        //-------------------------------------------------
        
        
        //---------------------TEXTO----------------------
    	//-------------------------------------------------
        JLabel resultado = new JLabel();
        Font fuenteRes = resultado.getFont();
        resultado.setFont(new Font(fuenteRes.getFontName(), Font.PLAIN, 13));
        resultado.setOpaque(false); // Establece el componente como opaco para mostrar el fondo
        resultado.setVisible(false); // Establece la etiqueta como oculta inicialmente
        panelResultado.setBounds(55, 690, 270, 30); // Coordenadas y dimensiones según necesites
        panelResultado.setOpaque(false); // Establece el panel como no opaco para lograr transparencia
        panelResultado.setVisible(false);
        panelPrincipal.add(panelResultado);
        panelResultado.add(resultado);

        //-------------------------------------------------
        //-------------------------------------------------
        
        
        //---------------------BOTON----------------------
    	//-------------------------------------------------
        JButton botonCalcular = new JButton("Calcular");
        //Doy tamaño del boton
        Dimension dimensionesBoton = new Dimension(100, 40);
        botonCalcular.setPreferredSize(dimensionesBoton);
        //Accion del boton
        botonCalcular.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
                /***********************************************************************/
                mapa.reseteaDistancia();
                Estacion origen = mapa.obtenerEstacionPorNombre(seleccionOrigen);
                Estacion destino = mapa.obtenerEstacionPorNombre(seleccionDestino);
                Vertex<Estacion> verticeOrigen = mapa.getVertice(origen.getNombre());
                Vertex<Estacion> verticeDestino = mapa.getVertice(destino.getNombre());
                lista = mapa.busqueda((UndirectedAdjacencyListGraph<Estacion,Transicion>)(mapa.getGrafo()), verticeOrigen, verticeDestino);
                System.out.println("\nEstaciones por las que pasa el algoritmo: " + "\n" + lista.toString());
                /***********************************************************************/
                //double distancia = mapa.calculardistanciaDesdeNodoPadre(mapa.obtenerEstacionPorNombre(seleccionOrigen),mapa.obtenerEstacionPorNombre(seleccionDestino));
                //System.out.println(distancia);
                String tiempo = RedMetro.calcularTiempo();
                
                System.out.println(tiempo);
                resultado.setText("Tiempo estimado: " + tiempo);
                /***********************************************************************/
                panelResultado.setVisible(true);
                resultado.setVisible(true);				
			}
        });
        panelBoton.add(botonCalcular);
        panelBoton.setBounds(135, 630, 100, 50); // Cambia las coordenadas y dimensiones según necesites
        panelEtiqueta.setOpaque(false); // Establece el panel como no opaco para lograr transparencia
        panelPrincipal.add(panelBoton);
        //-------------------------------------------------
        //-------------------------------------------------
        
        
        //---------------------TEXTO----------------------
    	//-------------------------------------------------
        JLabel etiqueta = new JLabel("Seleccione origen y destino...");
        Font fuente = etiqueta.getFont();
        etiqueta.setFont(new Font(fuente.getFontName(), Font.PLAIN, 14)); // Tamaño de fuente 20
        panelEtiqueta.setBounds(90, 540, 225, 30); // Cambia las coordenadas y dimensiones según necesites
        panelEtiqueta.setOpaque(false); // Establece el panel como no opaco para lograr transparencia
        panelEtiqueta.add(etiqueta);
        panelPrincipal.add(panelEtiqueta);
        //-------------------------------------------------
        //-------------------------------------------------        
        

        //Añado el panel general con todos los subpaneles
        add(panelPrincipal);
        setVisible(true);
    }

}