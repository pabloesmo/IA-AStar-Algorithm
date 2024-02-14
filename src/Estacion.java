import es.upm.aedlib.positionlist.PositionList;

public class Estacion {

    private String nombre;
    private double distanciaTrasbordo;
    private double latitud;
    private double longitud;
    private Estacion padre;

   

	private PositionList<Object> listaEstaciones; //Lista de estaciones(nodos) adyacentes
    private PositionList<Object> listaLineas; //Lista de lineas con las que está en contacto (a las que pertecene la estación) 
    private double heuristica; //H(n): (metros hasta la meta) del nodo actual (n)
    private double distanciaDesdeNodoPadre; //G(n): (metros) del nodo padre hasta el nodo actual (n)
    private double costeReal; //F(n) = H(n) + G(n)
    

    public Estacion(String nombre, double distanciaTrasbordo, double latitud, double longitud) {
        this.nombre = nombre;
        this.distanciaTrasbordo = distanciaTrasbordo;
        this.latitud = latitud;
        this.longitud = longitud;
        costeReal = calculo_F(heuristica, distanciaDesdeNodoPadre);
    }


    //Funciones para los nodosAdyancentes
    public double calculo_F (double heuristica, double distanciaDesdeNodoPadre) {
        return (heuristica + distanciaDesdeNodoPadre);

    }

    //Getters y setters

    // Getter y Setter para 'nombre'
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    // Getter y Setter para 'distanciaTrasbordo'
    public double getDistanciaTrasbordo() {
        return distanciaTrasbordo;
    }

    public void setDistanciaTrasbordo(double distanciaTrasbordo) {
        this.distanciaTrasbordo = distanciaTrasbordo;
    }

    // Getter y Setter para 'listaEstaciones'
    public PositionList<Object> getListaEstaciones() {
        return listaEstaciones;
    }

    public void setListaEstaciones(PositionList<Object> listaEstaciones) {
        this.listaEstaciones = listaEstaciones;
    }

    // Getter y Setter para 'listaLineas'
    public PositionList<Object> getListaLineas() {
        return listaLineas;
    }

    public void setListaLineas(PositionList<Object> listaLineas) {
        this.listaLineas = listaLineas;
    }

    // Getter y Setter para 'heuristica'
    public double getHeuristica() {
        return heuristica;
    }

    public void setHeuristica(double heuristica) {
        this.heuristica = heuristica;
    }

    // Getter y Setter para 'distanciaDesdeNodoPadre'
    public double getdistanciaDesdeNodoPadre() {
        return distanciaDesdeNodoPadre;
    }

    public void setdistanciaDesdeNodoPadre(double distanciaDesdeNodoPadre) {
        this.distanciaDesdeNodoPadre = distanciaDesdeNodoPadre;
    }

    // Getter y Setter para 'costeReal'
    public double getCosteReal() {
        return costeReal;
    }

    public void setCosteReal(double costeReal) {
        this.costeReal = costeReal;
    }

    // Getter y Setter para 'latitud'
    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    // Getter y Setter para 'longitud'
    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public String toString() {
        return (getNombre());
    }
    public Estacion getPadre() {
		return padre;
	}


	public void setPadre(Estacion padre) {
		this.padre = padre;
	}


	public double getDistanciaDesdeNodoPadre() {
		return distanciaDesdeNodoPadre;
	}


	public void setDistanciaDesdeNodoPadre(double distanciaDesdeNodoPadre) {
		this.distanciaDesdeNodoPadre = distanciaDesdeNodoPadre;
	}
}
