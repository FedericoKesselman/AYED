package TP_Grafos;
import java.util.*;

public class Parcial {

	public String resolver (Graph<lugar> sitios, int tiempo) {
		boolean ok = false;
		
		if (!sitios.isEmpty()) {
			Vertex<lugar> origen = null;
			
			for (Vertex<lugar> v: sitios.getVertices()) {
				if (v.getData().getNombre().equals("Entrada")) {
					origen = v;
					break;
				}
			}
			
			if (origen != null) 
				ok = resolverHelper (sitios, origen, new boolean[sitios.getSize()], new LinkedList<lugar>(), tiempo-origen.getData().getMinutos());				
		}
		
		if (ok)
			return "Alcanzable";
		else 
			return "No Alcanzable";
	}
	
	private boolean resolverHelper (Graph<lugar> sitios, Vertex<lugar> vertex, boolean[] visitados, List<lugar> caminoAct, int tiempo) {
		visitados[vertex.getPosition()] = true;
		caminoAct.add(vertex.getData());
		boolean ok = false;
		
		if (tiempo - vertex.getData().getMinutos() >= 0) {
			
			if (caminoAct.size() == sitios.getSize())
				return true;
			else {
				for (Edge<lugar> edge: sitios.getEdges(vertex)) {
					int tiempoNecesario = edge.getWeight();
					if (!visitados[edge.getTarget().getPosition()] && tiempo-vertex.getData().getMinutos()-tiempoNecesario >= 0)
						ok = resolverHelper (sitios, edge.getTarget(), visitados, caminoAct, tiempo-vertex.getData().getMinutos()-tiempoNecesario);
				}
			}
		}
		visitados[vertex.getPosition()] = false;
		caminoAct.remove(vertex.getData());
		return ok;
	}
	
	
}
