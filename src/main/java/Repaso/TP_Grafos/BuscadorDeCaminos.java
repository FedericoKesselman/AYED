package TP_Grafos;
import java.util.*;

public class BuscadorDeCaminos {
	private Graph<String> bosque;
	
	public BuscadorDeCaminos (Graph<String> bosque) {
		this.bosque = bosque;
	}
	
	public List <List<String>> recorridosMasSeguro() {
		List<List<String>> caminos = new LinkedList<>();
		
		if (!bosque.isEmpty()) {
			Vertex<String> origen = bosque.search("Casa Caperucita");
			Vertex<String> destino = bosque.search("Casa Abuelita");
			
			if (origen != null && destino != null) {
				boolean[] visitados = new boolean[bosque.getSize()];
				recorridosHelper (bosque, origen, caminos, new LinkedList<>(), visitados);
			}
		}
		
		return caminos;
	}
	
	private void recorridosHelper (Graph<String> bosque, Vertex<String> vertex, List<List<String>> caminos, List<String> caminoAct, boolean[] visitados) {
		visitados[vertex.getPosition()] = true;
		caminoAct.add(vertex.getData());
		
		if (vertex.getData().equals("Casa Abuelita")) {
			caminos.add(new LinkedList<>(caminoAct)); // Si no se crea una nueva estaria todo el tiempo guardando la referencia a la misma lista de caminoAct
		}
		else {
			for (Edge<String> edge: bosque.getEdges(vertex)) {
				if (edge.getWeight() < 5 && !visitados[edge.getTarget().getPosition()])
					recorridosHelper (bosque, edge.getTarget(), caminos, caminoAct, visitados);
			}
		}
		
		visitados[vertex.getPosition()] = false;
		caminoAct.remove(caminoAct.size()-1);
	}
	
	public static void main (String[] args) {
        Graph<String> bosque = new AdjListGraph<String>();
        Vertex<String> v1 = bosque.createVertex("Casa Caperucita");
        Vertex<String> v2 = bosque.createVertex("Claro 3");
        Vertex<String> v3 = bosque.createVertex("Claro 1");
        Vertex<String> v4 = bosque.createVertex("Claro 2");
        Vertex<String> v5 = bosque.createVertex("Claro 5");
        Vertex<String> v6 = bosque.createVertex("Claro 4");
        Vertex<String> v7 = bosque.createVertex("Casa Abuelita");
        
        bosque.connect(v1, v2, 4);
        bosque.connect(v2, v1, 4);
        bosque.connect(v1, v3, 3);
        bosque.connect(v3, v1, 3);
        bosque.connect(v1, v4, 4);
        bosque.connect(v4, v1, 4);
        bosque.connect(v2, v5, 15);
        bosque.connect(v5, v2, 15);
        bosque.connect(v3, v5, 3);
        bosque.connect(v5, v3, 3);
        bosque.connect(v4, v3, 4);
        bosque.connect(v3, v4, 4);
        bosque.connect(v4, v5, 11);
        bosque.connect(v5, v4, 11);
        bosque.connect(v4, v6, 10);
        bosque.connect(v6, v4, 10);
        bosque.connect(v4, v3, 4);
        bosque.connect(v3, v4, 4);
        bosque.connect(v5, v7, 4);
        bosque.connect(v7, v5, 4);
        bosque.connect(v6, v7, 9);
        bosque.connect(v7, v6, 9);
        
        BuscadorDeCaminos bos = new BuscadorDeCaminos(bosque);
        
        List<List<String>> lis = bos.recorridosMasSeguro();
        for(List<String> l: lis) {
            System.out.println(l);
        }
    }
}
