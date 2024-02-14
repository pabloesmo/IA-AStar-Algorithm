import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import es.upm.aedlib.positionlist.NodePositionList;
import es.upm.aedlib.positionlist.PositionList;
import es.upm.aedlib.graph.UndirectedAdjacencyListGraph;
import es.upm.aedlib.graph.UndirectedGraph;
import es.upm.aedlib.graph.Vertex;
import es.upm.aedlib.graph.Edge;

public class RedMetro {

    //Atributos
    private UndirectedGraph<Estacion, Transicion> grafo; //Grafo resultante
    private Map<String, PositionList<Estacion>> lineas;
    private static int distanciaAcum = 0;
    private static int contTransbordos = 0;
    int contadorEstaciones = 0;
    
    //LISTA DE NODOS AUN POR EXPLORAR (ordenada por f(n))
    //el nodo con menor coste de esa lista es el que se usa
    private ArrayList<Vertex<Estacion>> listaAbierta = new ArrayList<>();
    
    //LISTA DE NODOS YA EXPLORADOS
    //son nodos que ya no se necesita explorar
    private static ArrayList<Vertex<Estacion>> listaCerrada = new ArrayList<>();
    private ArrayList<Vertex<Estacion>> listaVertices = new ArrayList<>();
    private ArrayList<Edge<Transicion>> aristasPosibles = new ArrayList<Edge<Transicion>>();

    //Constructor
    public RedMetro() {
        this.lineas = new HashMap<>();
        inicializarLineas();
        grafo = formarGrafo();
    }

    private void inicializarLineas() {
        Estacion nodoA_1 = new Estacion("Vaulx-en-Velin La Sole", 0, 45.761132045863015, 4.92262906647644);
        Estacion nodoA_2 = new Estacion("Laurent Bonnevay Astroballe", 0, 45.76494390717362, 4.90949392600119);
        Estacion nodoA_3 = new Estacion("Cusset", 0, 45.76578297402, 4.900558547427424);
        Estacion nodoA_4 = new Estacion("Flachet", 0, 45.767763664296645, 4.890312906952106);
        Estacion nodoA_5 = new Estacion("Gratte-Ciel", 0, 45.769197665315204, 4.882961166476789);
        Estacion nodoA_6 = new Estacion("République Villeurbanne", 0, 45.77075964504703, 4.87413133764077);
        Estacion nodoA_7 = new Estacion("Charpennes Charles Hernu", 1, 45.77070484519425, 4.863827918067045);
        Estacion nodoA_8 = new Estacion("Masséna", 0, 45.76950964840141, 4.853594981821059);
        Estacion nodoA_9 = new Estacion("Foch", 0, 45.76879618236245, 4.844512276263637);
        Estacion nodoA_10 = new Estacion("Hôtel de Ville Louis Pradel", 1, 45.76755713778554, 4.83718976224724);
        Estacion nodoA_11 = new Estacion("Cordeliers", 0, 45.76339816480058, 4.836121606951918);
        Estacion nodoA_12 = new Estacion("Bellecour", 1, 45.75799385015686, 4.83422103949272);
        Estacion nodoA_13 = new Estacion("Ampère Victor Hugo", 0, 45.752982317892204, 4.829943931558147);
        Estacion nodoA_14 = new Estacion("Perrache", 0, 45.7495581245159, 4.827051373327138);

        Estacion nodoB_1 = new Estacion("Charpennes Charles Hernu", 1, 45.770667426673334, 4.863420222296512);
        Estacion nodoB_2 = new Estacion("Brotteaux", 0, 45.76693026441002, 4.859881912351331);
        Estacion nodoB_3 = new Estacion("Gare Part-Dieu Vivier Merle", 0, 45.76153979020785, 4.8583349818207795);
        Estacion nodoB_4 = new Estacion("Place Guichard Bourse du Travail", 0, 45.75944872312853, 4.848179995312441);
        Estacion nodoB_5 = new Estacion("Saxe Gambetta", 1, 45.753952260309916, 4.847582541344991);
        Estacion nodoB_6 = new Estacion("Jean Macé", 0, 45.74595357640285, 4.8429773683283);
        Estacion nodoB_7 = new Estacion("Place Jean Jaurès", 0, 45.73812710877874, 4.838142878114833);
        Estacion nodoB_8 = new Estacion("Debourg", 0, 45.73146187249944, 4.834166010655561);
        Estacion nodoB_9 = new Estacion("Stade de Gerland", 0, 45.72721420964688, 4.831334281819293);
        Estacion nodoB_10 = new Estacion("Oullins Gare", 0, 45.71690812575391, 4.8153447990156275);

        Estacion nodoC_1 = new Estacion("Cuire", 0, 45.78602088487646, 4.833608976572972);
        Estacion nodoC_2 = new Estacion("Hénon", 0, 45.779264726801244, 4.827680405100138);
        Estacion nodoC_3 = new Estacion("Croix-Rousse", 0, 45.77438456952748, 4.832417681821303);
        Estacion nodoC_4 = new Estacion("Croix-Paquet", 0, 45.77106711898925, 4.836497476568719);
        Estacion nodoC_5 = new Estacion("Hôtel de Ville Louis Pradel", 1, 45.76755713778554, 4.83718976224724);

        Estacion nodoD_1 = new Estacion("Gare de Vaise", 0, 45.78129323870223, 4.8048061098814925);
        Estacion nodoD_2 = new Estacion("Valmy", 0, 45.77466480283413, 4.805638753709511);
        Estacion nodoD_3 = new Estacion("Gorge de Loup", 0, 45.766193257421286, 4.8050779095298966);
        Estacion nodoD_4 = new Estacion("Vieux Lyon Cathédrale St. Jean", 0, 45.760233879090514, 4.826569674501445);
        Estacion nodoD_5 = new Estacion("Bellecour", 1, 45.758187014046, 4.835057531526802);
        Estacion nodoD_6 = new Estacion("Guillotière", 0, 45.75548018583981, 4.8427260071404845);
        Estacion nodoD_7 = new Estacion("Saxe Gambetta", 1, 45.753989690163905, 4.847657641528144);
        Estacion nodoD_8 = new Estacion("Garibaldi", 0, 45.75170533748474, 4.8543685476179546);
        Estacion nodoD_9 = new Estacion("Sans-Souci", 0, 45.74809975895535, 4.86485060713995);
        Estacion nodoD_10 = new Estacion("Monplaisir-Lumière", 0, 45.74568671243723, 4.871443042065572);
        Estacion nodoD_11 = new Estacion("Grange Blanche", 0, 45.743098019380895, 4.879670987557089);
        Estacion nodoD_12 = new Estacion("Laënnec", 0, 45.73840401561335, 4.886762418781206);
        Estacion nodoD_13 = new Estacion("Mermoz Pinel", 0, 45.73093230673911, 4.887907895496851);
        Estacion nodoD_14 = new Estacion("Parilly", 0, 45.719640020014786, 4.8879095187798836);
        Estacion nodoD_15 = new Estacion("Gare de Vénissieux", 0, 45.705304595849405, 4.888592968509919);

        Estacion[] estacionesLineaRoja = { nodoA_1, nodoA_2, nodoA_3, nodoA_4, nodoA_5, nodoA_6, nodoA_7, nodoA_8,
                nodoA_9, nodoA_10, nodoA_11, nodoA_12, nodoA_13, nodoA_14 };
        Estacion[] estacionesLineaAzul = { nodoB_1, nodoB_2, nodoB_3, nodoB_4, nodoB_5, nodoB_6, nodoB_7, nodoB_8,
                nodoB_9, nodoB_10 };
        Estacion[] estacionesLineaAmarilla = { nodoC_1, nodoC_2, nodoC_3, nodoC_4, nodoC_5 };
        Estacion[] estacionesLineaVerde = { nodoD_1, nodoD_2, nodoD_3, nodoD_4, nodoD_5, nodoD_6, nodoD_7, nodoD_8,
                nodoD_9, nodoD_10, nodoD_11, nodoD_12, nodoD_13, nodoD_14, nodoD_15 };

        lineas.put("Roja", crearLinea(estacionesLineaRoja));
        lineas.put("Azul", crearLinea(estacionesLineaAzul));
        lineas.put("Amarilla", crearLinea(estacionesLineaAmarilla));
        lineas.put("Verde", crearLinea(estacionesLineaVerde));
    }

    private PositionList<Estacion> crearLinea(Estacion[] estaciones) {
        PositionList<Estacion> linea = new NodePositionList<>();
        for (Estacion estacion : estaciones) {
            linea.addLast(estacion);
        }
        return linea;
    }

    public Estacion obtenerEstacionPorNombre(String nombreEstacion) {
        for (PositionList<Estacion> linea : lineas.values()) {
            for (Estacion estacion : linea) {
                if (estacion.getNombre().equals(nombreEstacion)) {
                    return estacion;
                }
            }
        }
        return null; // Estación no encontrada
    }

    //Crear el grafo
    private UndirectedGraph<Estacion, Transicion> formarGrafo() {
        UndirectedGraph<Estacion, Transicion> res = new UndirectedAdjacencyListGraph<>();
    
        for (PositionList<Estacion> listaEstaciones : lineas.values()) {
            Vertex<Estacion> verticeAnterior = null;
    
            for (Estacion estacion : listaEstaciones) {
                Vertex<Estacion> vx = getVertex(listaVertices, estacion.getNombre());

                if(vx==null) {
                    vx = res.insertVertex(estacion);
                    listaVertices.add(vx);
                }

                if (verticeAnterior != null) {
                    Transicion transicion = new Transicion(verticeAnterior.element(), vx.element());
                    res.insertUndirectedEdge(verticeAnterior, vx, transicion);
                }
                verticeAnterior = vx;
            }
        }
        return res;
    }

    private Vertex<Estacion> getVertex(ArrayList<Vertex<Estacion>> lista, String nombre){
        Iterator<Vertex<Estacion>> it = lista.iterator();
        while(it.hasNext()){
            Vertex<Estacion> ver = it.next();
            if(ver.element().getNombre().equals(nombre))
                return ver;
        }
        return null;
    }

    /**
     * @param actual Estacion actual n
     * @param destino Estacion a donde queremos llegar
     * @return Heuristica (H(n)) de n a destino
     */
    public static double calcularHeuristica(Estacion actual, Estacion destino) {
        Transicion actualDestino = new Transicion(actual, destino);
        return (actualDestino.getDistancia());
    }
    
    //CAMBIAR ESTA PRQ ES LO MISMO
    /**
     * @param anterior NodoPadre
     * @param actual NodoHijo
     * @return G(n): metros del nodo padre hasta el nodo actual (n)
     */
    public double calculardistanciaDesdeNodoPadre(Estacion anterior, Estacion actual) {
        Transicion padreHijo = new Transicion(anterior, actual);
        return (padreHijo.getDistancia());
    }


    public ArrayList<Estacion> busqueda(UndirectedAdjacencyListGraph<Estacion, Transicion> undirectedAdjacencyListGraph, Vertex<Estacion> origen, Vertex<Estacion> destino) {
        boolean terminar = false;
        Vertex<Estacion> actual = origen;
        Estacion estacion_destino = destino.element();

        listaAbierta.clear();
        listaCerrada.clear();
        listaAbierta.add(actual);
        Vertex<Estacion> siguiente = null;
        Edge<Transicion> siguienteArista = null;
        Estacion estacion_siguiente = null;
        Estacion estacion_actual = null;
        ArrayList<Estacion> estacionesCamino = new ArrayList<>();

        if(origen.element().equals(destino.element())){
            terminar = true;
        }

        while (!terminar && !listaAbierta.isEmpty()) {
            Iterable<Edge<Transicion>> lista_provisional = undirectedAdjacencyListGraph.edges(actual);
            aristasPosibles = transformacion(lista_provisional);
            listaAbierta.remove(actual);
            estacion_actual = actual.element();
            estacionesCamino.add(estacion_actual);
            listaCerrada.add(actual);

            for (int i = 0; i < aristasPosibles.size(); i++) {
                siguienteArista = aristasPosibles.get(i);
                //System.out.println("Sig_arista= " + siguienteArista + "\n");
                siguiente = undirectedAdjacencyListGraph.opposite(actual, siguienteArista);
                //System.out.println("Sig_nodo= " + siguiente + "\n");
                estacion_siguiente = siguiente.element();

                if (!listaCerrada.contains(siguiente)) {
                    if (!listaAbierta.contains(siguiente)) {
                        estacion_siguiente.setHeuristica(calcularHeuristica(estacion_actual, estacion_siguiente));
                        double g = siguienteArista.element().getDistancia();
                        //System.out.println("G= " + g + "\n");
                        distanciaAcum += g;
                        //System.out.println("SIGUIENTE=>" + estacion_siguiente);
                        //System.out.println("FINAL=>" + estacion_destino);
                        Transicion transicion = new Transicion(estacion_siguiente, estacion_destino);
                        double f = g + transicion.getDistancia();
                        //System.out.println("F= " + f + "\n");
                        estacion_siguiente.setCosteReal(f);
                        estacion_siguiente.setPadre(estacion_actual);
                        estacion_siguiente.setHeuristica(transicion.getDistancia());
                        listaAbierta.add(siguiente);
                    } else {
                        comprobarMenorG(estacion_actual, estacion_siguiente, siguienteArista.element().getDistancia());
                    }
                }
                //System.out.println("Lista => " + listaAbierta);
            }
            actual = getSiguienteNodo();
            contadorEstaciones++;
            System.out.println("\nNODO QUE USO=> " + actual);
            System.out.println("------------------------------------");
            if (actual != null) {
                terminar = actual.equals(destino);
            }
        }
        if (terminar) {
            //System.out.println("\nEl algoritmo ha pasado por " + contadorEstaciones + " estaciones\n");
            System.out.println("DISTANCIA TOTAL = [" + distanciaAcum + "]\n");
            estacionesCamino.add(destino.element());
        }
        contTransbordos = numTransbordos(estacionesCamino);
        return estacionesCamino;
    }

    public static ArrayList<Estacion> insertar(){
		ArrayList<Estacion> resultado = new ArrayList<>();
		Estacion aux = listaCerrada.get(listaCerrada.size() - 1).element();
		while(aux.getPadre() != null) {
			resultado.add(aux);
			aux = aux.getPadre();
		}
		resultado.add(aux);
		return resultado;
	}
    
    public Vertex<Estacion> getSiguienteNodo(){
        Vertex<Estacion> siguiente = null;
    	double fMenor = -1;
        //System.out.println(listaAbierta);
    	for(int i=0 ; i < listaAbierta.size(); i++) {
    		//System.out.println("NOMBRE: " + listaAbierta.get(i).element().getNombre() + ", COSTE: " + listaAbierta.get(i).element().getCosteReal());
    		double f = listaAbierta.get(i).element().getCosteReal();
    		if(fMenor == -1 || fMenor > f) {
    			fMenor=f;
    			siguiente=listaAbierta.get(i);
    		}
    	}
    	return siguiente;
    }
    
    public void comprobarMenorG(Estacion actual,Estacion siguiente,double pesoNuevo) {
    	double g_actual = siguiente.getdistanciaDesdeNodoPadre();
    	double g_nuevo = actual.getdistanciaDesdeNodoPadre()+pesoNuevo;
    	if(g_nuevo < g_actual) {
    		siguiente.setPadre(actual);
    		siguiente.setdistanciaDesdeNodoPadre(g_nuevo);
    	}
    }
    
    //Getters
    public UndirectedGraph<Estacion, Transicion> getGrafo() {
        return grafo;
    }
    
    public ArrayList<Estacion>getCamino(Vertex<Estacion> verticeInicio,Vertex<Estacion>verticeFinal){//funcion que devuelve el camino a seguir respecto al vertice final del grafo hasta el inicio.
    	ArrayList<Estacion> res = new ArrayList<Estacion>();
    	Estacion estacionInicio= verticeInicio.element();
    	Estacion estacionFinal= verticeFinal.element();
    	Estacion aux=estacionFinal;
    	while(!aux.equals(estacionInicio)) {
    		Estacion padre=aux.getPadre();
    		res.add(aux);
    		aux=padre;
    	}
    	res.add(estacionInicio);
    	return res;
    }
    
    public Vertex<Estacion> getVertice(String nombreEstacion){// para poder buscar el inicio y fin necesitamos saber los vertices del grafo para dichas estaciones.
    	Iterable<Vertex<Estacion>> listaVertices=grafo.vertices();
    	Iterator<Vertex<Estacion>> it = listaVertices.iterator();
    	Vertex<Estacion> vertice = null; 
    	boolean encontrado=false;
    	Estacion estacion= null;
    	while(it.hasNext()&&!encontrado) {
    		vertice = it.next();
    		estacion = vertice.element();

    		if(estacion.getNombre().equals(nombreEstacion)){
                encontrado=true;
            }    
    		
    	}
    	return vertice;
    }
    
    public ArrayList<Edge<Transicion>> transformacion(Iterable<Edge<Transicion>> lista){
    	ArrayList<Edge<Transicion>> res = new ArrayList<Edge<Transicion>>();
    	Iterator<Edge<Transicion>> it= lista.iterator();
    	Edge<Transicion> arista=null;
    	while(it.hasNext()){
    		arista=it.next();
    		res.add(arista);
    	}
    	return res;
    }

    public static String calcularTiempo() {
		String res = "";
		 final double  vMedia = 8.33333;
		 double time = (float) distanciaAcum / vMedia;
		 int minutos = (int) (time / 60);
		 int segundos = (int) (time % 60);
         if(contTransbordos > 0){
            //añadimos 2 minutos extra por cada transbordo
            minutos += 1.2 * contTransbordos; 
         }
		 res = minutos + " minutos " + segundos + " segundos";
		return res;
	}

    public static String calcularTiempo2(int distanciaTotal, boolean transbordo) {
		String res = "";
		 final double  vMedia = 8.33333;
		 double time = (float) distanciaTotal / vMedia;
		 int minutos = (int) (time / 60);
		 int segundos = (int) (time % 60);
         if(transbordo){
            //añadimos 1 minuto extra por cada transbordo
            minutos++; 
         }
		 res = minutos + " minutos " + segundos + " segundos";
		return res;
	}
    
    public static int distanciaTotal(Estacion origen, Estacion destino) {
        double res = 0;
        res = calcularHeuristica(origen,destino);
        return (int) res;
    }  

    public static int numTransbordos(ArrayList<Estacion> estaciones){
        int numT = 0;
        for(int i=0; i<estaciones.size(); i++){
            switch (estaciones.get(i).getNombre()) {
                case "Hôtel de Ville Louis Pradel":
                    numT++;
                    break;
                case "Bellecour":
                    numT++;
                    break;
                case "Saxe Gambetta":
                    numT++;
                    break;
                case "Charpennes Charles Hernu":
                    numT++;
                    break;
                default:
                    break;
            }
        }
        return numT;
    }

    public void reseteaDistancia(){
        distanciaAcum = 0;
    }

    public String aString() {
        StringBuilder result = new StringBuilder();
        Iterable<Vertex<Estacion>> vertices = grafo.vertices();

        for (Vertex<Estacion> vertex : vertices) {
            result.append(vertex.element().getNombre()).append(" -> ");
            Iterable<Edge<Transicion>> edges = grafo.edges(vertex);

            for (Edge<Transicion> edge : edges) {
                Vertex<Estacion> oppositeVertex = grafo.opposite(vertex, edge);
                result.append(oppositeVertex.element().getNombre()).append(", ");
            }

            result.append("\n");
        }

        return result.toString();
    }
}