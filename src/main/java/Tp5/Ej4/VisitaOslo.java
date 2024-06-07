package Tp5.Ej4;
import Tp5.Ej1.List.Graph;
import java.util.*;

public class VisistaOslo {

    public List<String> paseoEnBici(Graph<String> lugares, String destino, int maxTiempo, List<String> lugaresRestringidos) {
        List<String> lista = new ArrayList<>();

        if (!this.paseoEnBici.isEmpty()) {
            boolean[] visitados = new boolean(mapaCiudades.getSize());    

            Vertex origen = this.mapaCiudades.search('Ayuntamiento');
            Vertex Vdestino = this.mapaCiudades.search(destino);

            if (origen != null && Vdestino != null) {

                for (String restringido: lugaresRestringidos) {
                    Vertex<String> v = lugares.search(restringido)

                    if (v != null)
                        visitados[v.getPosition()] = true;
                }

                // No paso el grafo como parametro porque ya con los vertices puedo trabajar
                paseoEnBiciHelper (origen, visitados, lista, destino, tiempoMax);
            }
        }

        return lista;
    }

    private boolean paseoEnBiciHelper (Vertex<String> vertex, boolean[] visitados, List<String> camino, String destino, int tiempo) {
        visitados[vertex.getPosition()] = true;
        camino.add(vertex.getData()); 
        boolean OK = false;

        if (vertex.getData().equals(destino))
            return true;
        else {
            for (Edge<String> edge: vertex.getEdges()) { 
                int pos = edge.getTarget().getPosition();
                int tiempoNecesario = edge.getWeight();

                if (!visitados[pos]) && (!OK) && ((tiempo - tiempoNecesario) >= 0) 
                    OK = paseoEnBiciHelper (edge.getTarget(), visitados, camino, destino, (tiempo - tiempoNecesario));
            }
        }

        if (!OK)
            camino.remove(camino.size()-1);

        visitados[vertex.getPosition()] = false;
        return OK;
    }


    public static void main(String[] args) { 
        // FALTA CHEQUEAR QUE FUNCIONEN LOS METODOS
    }

}