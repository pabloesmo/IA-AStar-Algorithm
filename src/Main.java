import java.util.ArrayList;
import es.upm.aedlib.graph.UndirectedAdjacencyListGraph;
import es.upm.aedlib.graph.Vertex;

public class Main {

    public static void main(String [] args) {

        //----------------------------------------------------------------
        //-----------------------PRUEBAS IG-------------------------------
        //----------------------------------------------------------------
        PantallaBienvenida pb = new PantallaBienvenida();
        //----------------------------------------------------------------
        //----------------------------------------------------------------
        
        RedMetro metro = new RedMetro();
        metro.getGrafo();

        //Cuire a Cusset con TRANSBORDO
        //LINEA VERDE DESDE inicio al final e ir subiendo estaciones
        //Caso limite mismo origen y destino

        //Con esto obtengo el grafo y sus aristas conectadas
        //System.out.println(metro.aString());

        //--------------------------PRUEBAS FINALES--------------------------
        //ArrayList<Estacion> lista = new ArrayList<Estacion>();
        //Vertex<Estacion> vertice = metro.getVertice("Vaulx-en-Velin La Sole");
        //Vertex<Estacion> vertice2 = metro.getVertice("Perrache");
        //lista = metro.busqueda((UndirectedAdjacencyListGraph<Estacion,Transicion>)(metro.getGrafo()), vertice, vertice2);
        //double distancia = metro.calculardistanciaDesdeNodoPadre(metro.obtenerEstacionPorNombre("Vaulx-en-Velin La Sole"),metro.obtenerEstacionPorNombre("Perrache"));
        //System.out.println("TIEMPO NUEVO => [" + RedMetro.calcularTiempo() + "]");
        
        
        //System.out.println("DISTANCIA LINEA RECTA => " + distancia);
        //System.out.println("TIEMPO LINEA RECTA =>" + "[" + RedMetro.calcularTiempo2((int)distancia,false) + "]");
        //System.out.println("\nRESULTADO : " + "\n" + "\n" + lista.toString() + "\n");
        //--------------------------------------------------------------------



        //----------------------------------------------------------------
        //-----------------------PRUEBAS DE LINEAS DE METRO---------------
        //----------------------------------------------------------------
        
        //LINEA ROJA
        
        //Iterator<Estacion> nodosA = lineaRoja.iterator();
        //while (nodosA.hasNext()) {
        //System.out.println(nodosA.next().getNombre());
        //}
        //System.out.println();

        //LINEA AZUL
        
        //Iterator<Estacion> nodosB = lineaAzul.iterator();
        //while (nodosB.hasNext()) {
        //System.out.println(nodosB.next().getNombre());
        //}
        //System.out.println();
        
        
        //LINEA AMARILLA

        // Iterator<Estacion> nodosC = lineaAmarilla.iterator();
        // while (nodosC.hasNext()) {
        //     System.out.println(nodosC.next().getNombre());
        // }
        // System.out.println();

        
        //LINEA VERDE
        
        // Iterator<Estacion> nodosD = lineaVerde.iterator();
        // while (nodosD.hasNext()) {
        //     System.out.println(nodosD.next().getNombre());
        // }
        // System.out.println();

        
        //----------------------------------------------------------------
        //-----------------------PRUEBAS DE LINEAS DE METRO---------------
        //----------------------------------------------------------------

        //Transicion transicion = new Transicion(lineaRoja.first().element(), lineaRoja.next(lineaRoja.first()).element());
        //System.out.println("La distancia entre: " + lineaRoja.first().element().getNombre() + " y " + lineaRoja.next(lineaRoja.first()).element().getNombre() + " es: " + transicion.getDistancia() + " metros\n");

        //nodoA_1.setHeuristica(metro.calcularHeuristica(nodoA_1, nodoA_2));
        //System.out.println("La heuristica para llegar de: " + lineaRoja.first().element().getNombre() + " hasta " + lineaRoja.next(lineaRoja.first()).element().getNombre() + " es: " + nodoA_1.getHeuristica() + " metros\n");

        //nodoA_2.setdistanciaDesdeNodoPadre(metro.calculardistanciaDesdeNodoPadre(nodoA_1, nodoA_2));
        //System.out.println("La distancia desde el Nodo Padre: " + lineaRoja.first().element().getNombre() + " en el nodo hijo " + lineaRoja.next(lineaRoja.first()).element().getNombre() + " es: " + nodoA_2.getdistanciaDesdeNodoPadre() + " metros\n");

        //metro.caminoOptimo(nodoA_1, nodoA_14);

        // System.out.println(metro.getGrafo().vertices()+ "\n");
        // System.out.println(metro.getGrafo().edges() + "\n");


        // metro.prueba(metro.getGrafo()., null)

        // System.out.println(metro.getGrafo());

        /*
         * Quiero hacer:
         * Tener las lineas compuestas por los nodos
         * linea_A.add(nodoA_1);
         * linea_A.add(nodoA_2);
         * 
         */
        //PRUEBAS PARA getVertice.
        /*
        Vertex<Estacion>vertice=metro.getVertice("Vaulx-en-Velin La Sole" );
        System.out.print("El nombre de la estacion del vertice es: "+ vertice.element().getNombre());
        Vertex<Estacion>vertice2=metro.getVertice("Gare de Vaise" );
        System.out.print("El nombre de la estacion del vertice es: "+ vertice2.element().getNombre());
        */
            
        /*ArrayList<Estacion> lista = new ArrayList<Estacion>();
        Vertex<Estacion> vertice = metro.getVertice("Hénon");
        Vertex<Estacion> vertice2 = metro.getVertice("Oullins Gare");

        lista = metro.busqueda((UndirectedAdjacencyListGraph<Estacion,Transicion>)(metro.getGrafo()), vertice, vertice2);
        System.out.println("Resultado del algoritmo: " + "\n" + lista.toString());*/
        
        // ArrayList<Estacion> caminoOptimo = metro.busqueda((UndirectedAdjacencyListGraph<Estacion,Transicion>)(metro.getGrafo()), vertice, vertice2);
        // double tiempoTotal = metro.tiempoTotalEntreEstaciones(caminoOptimo);
        // System.out.println("Tiempo total entre estaciones: " + tiempoTotal + " minutos");

    }
}
