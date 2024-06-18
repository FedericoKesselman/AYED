package TP_Grafos;
import java.util.*;

public class Recorridos<T> {
    
    public List<T> dfs(Graph<T> grafo) {
        List<T> lista = new LinkedList<>();
        boolean[] visitados = new boolean [grafo.getSize()];    

        for (Vertex<T> vertex: grafo.getVertices()) {
            if (!visitados[vertex.getPosition()])
                dfs (grafo, vertex, visitados, lista);
        }

        return lista;
    }

    private void dfs (Graph<T> grafo, Vertex<T> vertex, boolean[] visitados, List<T> lista) { 
        visitados[vertex.getPosition()] = true;
        lista.add(vertex.getData());

        for (Edge<T> edge: grafo.getEdges(vertex)) { 
            if (!visitados[edge.getTarget().getPosition()])
                dfs (grafo, edge.getTarget(), visitados, lista);
        }
    }


    /* ------------------------------------ BFS ------------------------------------ */
    public List<T> bfs(Graph<T> grafo) {
    	List<T> lista = new LinkedList<>();
        boolean[] visitados = new boolean[grafo.getSize()];
 
        for (Vertex<T> vertex: grafo.getVertices()) {
            if (!visitados[vertex.getPosition()])
                bfs (grafo, vertex, visitados, lista);
        }

        return lista;
    }

    private void bfs(Graph<T> grafo, Vertex<T> vertex, boolean[] visitados, List<T> lista) {
        visitados[vertex.getPosition()] = true;

        Queue<Vertex<T>> cola = new Queue<Vertex<T>>();
        cola.enqueue(vertex);

        while (!cola.isEmpty()) {
            Vertex<T> w = cola.dequeue();
            lista.add(w.getData());

            // para todos los vecinos de w:
            for (Edge<T> edge: grafo.getEdges(w)) {
                int pos = edge.getTarget().getPosition();

                if (!visitados[pos]) {
                    visitados[pos] = true;
                    cola.enqueue(edge.getTarget());
                }
            }
        }
    }
    
    public static void main(String[] args) {
        Graph<String> ciudades = new AdjListGraph<String>();
        Recorridos<String> rec = new Recorridos<String>();
        Vertex<String> v1 = ciudades.createVertex("Buenos Aires");
        Vertex<String> v2 = ciudades.createVertex("Santiago");
        Vertex<String> v3 = ciudades.createVertex("Asunción");
        Vertex<String> v4 = ciudades.createVertex("Tokio");
        Vertex<String> v5 = ciudades.createVertex("Roma");
        Vertex<String> v6 = ciudades.createVertex("Paris");
        Vertex<String> v7 = ciudades.createVertex("Madrid");
        Vertex<String> v8 = ciudades.createVertex("Caracas");
        ciudades.connect(v1, v2);
        ciudades.connect(v1, v3);
        ciudades.connect(v2, v5);
        ciudades.connect(v3, v7);
        ciudades.connect(v3, v8);
        ciudades.connect(v8, v7);
        ciudades.connect(v8, v4);
        ciudades.connect(v5, v4);
        ciudades.connect(v7, v4);
        ciudades.connect(v6, v5);
        ciudades.connect(v6, v7);
        ciudades.connect(v6, v4);
        ciudades.connect(v4, v1);
        
        List<String> lisDFS = rec.dfs(ciudades);
        List<String> lisBFS = rec.bfs(ciudades);
        
        System.out.print("Lista DFS: ");
        for (String e: lisDFS){
            System.out.print(e + " ~ ");
        }
        
        System.out.println("");
        
        System.out.print("Lista BFS: ");
        for (String e: lisBFS){
            System.out.print(e + " ~ ");
        }
    }
    
    
} 