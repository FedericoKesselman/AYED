package TP_Grafos;
import java.util.*;

public class Parcial { // TEMA 2

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
			
			if (origen != null) {
				ok = resolverHelper (sitios, origen, new boolean[sitios.getSize()], new LinkedList<>(), tiempo-origen.getData().getMinutos());
			}
		}
		
		if (ok)
			return "Alcanzable";
		else
			return "No Alcanzable";
	}
	
	private boolean resolverHelper (Graph<lugar> sitios, Vertex<lugar> vertex, boolean[] visitados, List<lugar> camino, int tiempo) {
		visitados[vertex.getPosition()] = true;
		camino.add(vertex.getData());
		boolean paro = false;
		
		if (tiempo - vertex.getData().getMinutos() >= 0) {
			tiempo -= vertex.getData().getMinutos();
		
			if (camino.size() == sitios.getSize())
				return true;
			else {
				for (Edge<lugar> edge: sitios.getEdges(vertex)) {
					int tiempoArista = edge.getWeight();
					if (!visitados[edge.getTarget().getPosition()] && !paro && tiempo-tiempoArista >= 0)
						paro = resolverHelper (sitios, edge.getTarget(), visitados, camino, tiempo-tiempoArista);
				}
			}
		}
		
		if (!paro) {
			visitados[vertex.getPosition()] = false;
			camino.remove(camino.size()-1);
		}
		return paro;
	}
	
	
}










