
public class Transicion {

    private Estacion actual;
    private Estacion siguiente;
    private double distancia;

    public Transicion(Estacion actual, Estacion siguiente) {
        this.actual = actual;
        this.siguiente = siguiente;
        distancia = calculoDistancia();
    }

    //Unidad: metros
    private double calculoDistancia() {
        double res;
        double radio_tierra = 6371;
        double lon1 = Math.toRadians(actual.getLongitud());
        double lon2 = Math.toRadians(siguiente.getLongitud());
        double lat1 = Math.toRadians(actual.getLatitud());
        double lat2 = Math.toRadians(siguiente.getLatitud());

        double dlon = (lon2 - lon1);
        double dlat = (lat2 - lat1);

        double sinlat = Math.sin(dlat / 2);
        double sinlon = Math.sin(dlon / 2);

        double a = (sinlat * sinlat) + Math.cos(lat1) * Math.cos(lat2) * (sinlon * sinlon);
        double c = 2 * Math.asin(Math.min(1.0, Math.sqrt(a)));

        res = radio_tierra * c * 1000;
        return res;
    }

    public Estacion getActual() {
        return actual;
    }

    public Estacion getSiguiente() {
        return siguiente;
    }

    public double getDistancia() {
        return distancia;
    }

    public String toString() {
        return ("desde: "+ actual.getNombre() + ", hasta: " + siguiente.getNombre() + "\n");
    }

}