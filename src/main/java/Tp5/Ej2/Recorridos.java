package Tp5.Ej2;
import Tp5.Ej1.List.Graph;
import java.util.*;

public class Recorridos<T> {
    
    public List<T> dfs(Graph<T> grafo) {
        List<T> lista = new ArrayList<>();
        boolean[] visitados = new boolean(grafo.getSize());    

        for (Vertex<T> vertex: grafo.getVertices()) {
            if (!visitados[vertex.getPosition()])
                dfs (grafo, vertex, visitados, lista);
        }

        return lista;
    }

    public void dfs (Graph<T> grafo, Vertex<T> vertex, boolean[] visitados, List<T> lista) { 
        visitados[vertex.getPosition()] = true;
        lista.add(vertex.getData());

        for (Edge<T> edge: vertex.getEdges()) { 

            if (!visitados[edge.getTarget().getPosition()])
                dfs (grafo, vertex, visitados, lista);
        }
    }


    // TODAVIA FALTA VERLO EN LA CLASE PRACTICA
    public List<T> bfs(Grafo<T> grafo) {
        boolean[] visitados = new boolean(grafo.getSize());
 
        // en un for por si el grafo no es conexo. se dispara el recorrido desde los vertices no alcanzados
        for (Vertex<T> vertex: grafo.getVertices()) {
            if (!visitados[vertex.getPosition()])
                bfs (grafo, vertex, visitados, lista);
        }

        return lista;
    }

    private void bfs(Graph<T> grafo, Vertex<T> vertex, boolean[] visitados, List<T> data) {
        visitados[vertex.getPosition()] = true;
        lista.add(vertex.getData());

        Queue<Vertex<T>> q = new Queue<Vertex<T>>();
        q.enqueue(vertex);

        while (!q.isEmpty()) {
            Vertex<T> w = q.dequeue();
            lista.add(vertex.getData());

            // para todos los vecinos de w:
            for (Edge<T> edge: grafo.getEdges(w)) {
                int pos = edge.getTarget().getPosition();

                if (!visitados[pos]) {
                    visitados[pos] = true;
                    //Vertex<T> v = e.getTarget();
                    q.enqueue(e.getTarget());
                }
            }
        }
    }
} 