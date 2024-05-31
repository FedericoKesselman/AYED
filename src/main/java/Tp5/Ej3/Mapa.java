package Tp5.Ej3;
import Tp5.Ej1.List.Graph;
import java.util.*;

public class Mapa {
    private Graph<String> mapaCiudades;

    public Mapa (Graph<String> mapaCiudades) {
        this.mapaCiudades = mapaCiudades;
    }

    // INCISO1
    public List<String> devolverCamino(String ciudad1, String ciudad2) {
        List<String> lista = new ArrayList<>();
        boolean[] visitados = new boolean(mapaCiudades.getSize());    

        for (Vertex<T> vertex: mapaCiudades.getVertices()) {
            if (vertex.getData() == ciudad1)
                boolean OK = dfs (grafo, vertex, visitados, lista);
        }

        return lista;
    }

    public boolean dfs (Graph<String> mapaCiudades, Vertex<T> vertex, boolean[] visitados, List<T> lista) { 
        visitados[vertex.getPosition()] = true;
        boolean OK = false;
        lista.add(vertex.getData()); // Podria ir adentro del if pero asi queda la ciudad2 en la lista 

        if (vertex.getData() != ciudad2) {
            for (Edge<T> edge: vertex.getEdges()) { 
                if (!visitados[edge.getTarget().getPosition()]) && (!OK)
                    OK = dfs (mapaCiudades, vertex, visitados, lista);
            }

            if (!OK) 
                lista.remove(lista.size()-1);
        }
        else
            OK = true;

        return OK;
    }

}