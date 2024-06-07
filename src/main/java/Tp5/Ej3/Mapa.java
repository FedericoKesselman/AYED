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

        if (!this.mapaCiudades.isEmpty()) {
            boolean[] visitados = new boolean(mapaCiudades.getSize());    

            Vertex origen = this.mapaCiudades.search(ciudad1);
            Vertex destino = this.mapaCiudades.search(ciudad2);

            if (origen != null && destino != null) {
                devolverCaminoHelper (origen, visitados, lista, ciudad2);
                return lista;
            }
        }
        return lista
    }

    public boolean devolverCaminoHelper (Vertex<T> vertex, boolean[] visitados, List<T> lista, String ciudad2) { 
        visitados[vertex.getPosition()] = true;
        boolean OK = false;
        lista.add(vertex.getData()); // Podria ir adentro del if pero asi queda la ciudad2 en la lista 

        if (vertex.getData() != ciudad2) {
            for (Edge<T> edge: vertex.getEdges()) { 
                if (!visitados[edge.getTarget().getPosition()]) && (!OK)
                    OK = devolverCaminoHelper (edge.getTarget(), visitados, lista, ciudad2);
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

        if (!this.mapaCiudades.isEmpty()) {
            boolean[] visitados = new boolean(mapaCiudades.getSize());  

            Vertex origen = this.mapaCiudades.search(ciudad1);
            Vertex destino = this.mapaCiudades.search(ciudad2);

            if (origen != null && destino != null) {
                devolverCaminoExeptuandoHelper (origen, visitados, lista, ciudades, ciudad2);
                return lista;
            }
        }
        return lista
    }

    public boolean devolverCaminoExpetuandoHelper (Vertex<T> vertex, boolean[] visitados, List<T> lista, List<String> ciudades, String ciudad2) { 
        visitados[vertex.getPosition()] = true;
        boolean OK = false;
        lista.add(vertex.getData()); // Podria ir adentro del if pero asi queda la ciudad2 en la lista 

        int pos;
        String destino;

        if (vertex.getData() != ciudad2) {

            for (Edge<T> edge: vertex.getEdges()) { 
                pos = edge.getTarget().getPosition();
                ciudad = edge.getTarget().getData();

                if (ciudades.contains(ciudad))
                    visitados[pos] = true;
                // Se pone en true la ciudad para que no pueda entrar 
                // Tambien se podria hacer en el otro metodo pero no es lo que mas conviene(explicado en clase)

                if (!visitados[pos]) && (!OK) 
                    OK = devolverCaminoExeptuandoHelper (edge.getTarget(), visitados, lista, ciudades, ciudad2);
            }

            if (!OK) {
                lista.remove(lista.size()-1);
                visitados[vertex.getPosition()] = false;
            }
        }
        else
            OK = true;

        return OK;
    }


    // INCISO3
    public List<String> caminoMasCorto(String ciudad1, String ciudad2) {
        List<String> camino = new ArrayList<>();

        if (!this.mapaCiudades.isEmpty()) {
            boolean[] visitados = new boolean(mapaCiudades.getSize());  

            Vertex origen = this.mapaCiudades.search(ciudad1);
            Vertex destino = this.mapaCiudades.search(ciudad2);

            if (origen != null && destino != null) {
                caminoMasCortoHelper (origen, visitados, ciudad2, new ArrayList<String>(), camino, 0, Integer.MAX_VALUE);
                return camino;
            }
        return camino;
    }

    public int caminoMasCortoHelper(Vertex<T> vertex, boolean[] visitados, String ciudad2, List<T> caminoAct, List<T> caminoMin, int total, int min) {
        visitados[vertex.getPosition()] = true;
        caminoAct.add(vertex.getData());

        if (vertex.getData() = ciudad2 && total < min) { // se encontro un camino posible o un camino mas chico que el anterior
            caminoMin.removeAll(caminoMin);
            caminoMin.addAll(caminoAct);            
            min = total
        }
        else {
            for (Edge<T> edge: vertex.getEdges()) { 
                int pos = edge.getTarget().getPosition();
                int aux = total + edge.getWeight();

                if (!visitados[pos] && aux < min) 
                    min = caminoMasCortoHelper(edge.getTarget(), visitados, ciudad2, caminoAct, caminoMin, aux, min);

            }
        }
        caminoAct.remove(caminoAct.size()-1);
        visitados[vertex.getPosition()] = false;
        return min;
    }



}