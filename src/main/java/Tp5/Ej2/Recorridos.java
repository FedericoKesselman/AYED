package Tp5.Ej2;

public class Recorridos {
    
    public List<T> dfs(Graph<T> grafo) {
        List<T> lista = new ArrayList<>();
        boolean[] visitados = new boolean(grafo.getSize());    

        for (Vertex<T> vertex: grafo.getVertices()) {
            if (!visitados[vertex.getPosition()])
                dfs (grafo, vertex, visitados, lista);
        }
    }

    public void dfs (Graph<T> grafo, Vertex<T> vertex, boolean[] visitados, List<T> lista) { 
        visitados[vertex.getPosition()] = true;
        lista.add(vertex.getData());

        for (Edge<T> edge: vertex.getEdges()) {

            if (!visitados[edge.getTarget().getPosition()])
                dfs (grafo, vertex, visitados, lista);
        }
    }


    


} 