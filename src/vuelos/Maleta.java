package vuelos;

import java.util.Comparator;

public class Maleta {

    private int vuelo;
    private String propietario;
    private int prioridad;

    public Maleta(String propietario, int vuelo) {

        this.vuelo = vuelo;
        this.propietario = propietario;
        prioridad = 1;

    }

    public int getVuelo() {
        return vuelo;
    }

    @Override
    public String toString() {
        return propietario + ", con vuelo: " + vuelo + "\n";
    }

}

class ComparatorMaletas implements Comparator<Maleta> {

    @Override
    public int compare(Maleta o1, Maleta o2) {
        return 0;
    }

}
