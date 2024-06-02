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
                boolean OK = devolverCaminoHelper (grafo, vertex, visitados, lista);
        }

        return lista;
    }

    public boolean devolverCaminoHelper (Graph<String> mapaCiudades, Vertex<T> vertex, boolean[] visitados, List<T> lista) { 
        visitados[vertex.getPosition()] = true;
        boolean OK = false;
        lista.add(vertex.getData()); // Podria ir adentro del if pero asi queda la ciudad2 en la lista 

        if (vertex.getData() != ciudad2) {
            for (Edge<T> edge: vertex.getEdges()) { 
                if (!visitados[edge.getTarget().getPosition()]) && (!OK)
                    OK = devolverCaminoHelper (mapaCiudades, vertex, visitados, lista);
            }

            if (!OK) 
                lista.remove(lista.size()-1);
        }
        else
            OK = true;

        return OK;
    }


    // INCISO2
    public List<String> devolverCaminoExeptuando(String ciudad1, String ciudad2, List<String> ciudades) {
        List<String> lista = new ArrayList<>();
        boolean[] visitados = new boolean(mapaCiudades.getSize());  

        for (Vertex<T> vertex: mapaCiudades.getVertices()) {
            if (vertex.getData() == ciudad1)
                boolean OK = devolverCaminoExeptuandoHelper (grafo, vertex, visitados, lista, ciudades);
        }

        return lista;
    }

    public boolean devolverCaminoExpetuandoHelper (Graph<String> mapaCiudades, Vertex<T> vertex, boolean[] visitados, List<T> lista, List<String> ciudades) { 
        visitados[vertex.getPosition()] = true;
        boolean OK = false;
        lista.add(vertex.getData()); // Podria ir adentro del if pero asi queda la ciudad2 en la lista 

        int pos;
        String destino;

        if (vertex.getData() != ciudad2) {

            for (Edge<T> edge: vertex.getEdges()) { 
                pos = edge.getTarget().getPosition();
                destino = edge.getTarget().getData();

                for (String city: ciudades) 
                    if (city == destino) 
                        visitados[pos] = true;
                // Se pone en true la ciudad para que no pueda entrar 
                // Tambien se podria hacer en el otro metodo pero no es lo que mas conviene(explicado en clase)

                if (!visitados[pos]) && (!OK) 
                    OK = devolverCaminoExeptuandoHelper (mapaCiudades, vertex, visitados, lista);
            }

            if (!OK) 
                lista.remove(lista.size()-1);
        }
        else
            OK = true;

        return OK;
    }



}