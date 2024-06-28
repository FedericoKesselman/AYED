package TP_Grafos.Parcial1;
import TP_Grafos.*;
import java.util.*;

public class Parcial2 { // TEMA1
	
	public int Parcial (Graph<lugar> sitios, int tiempo) {
		List<lugar> camino = new LinkedList<>();
		
		if (!sitios.isEmpty()) {
			Vertex<lugar> origen = null;
			
			for (Vertex<lugar> v: sitios.getVertices()) {
				if (v.getData().getNombre().equals("Entrada")) {
					origen = v;
					break;
				}
			}
			
			if (origen != null)
				helper(sitios, origen, new boolean[sitios.getSize()], camino, new LinkedList<lugar>(), tiempo);
		}
		
		return camino.size();
	}
	
	private boolean helper (Graph<lugar> sitios, Vertex<lugar> vertex, boolean[] visitados, List<lugar> caminoMax, List<lugar> caminoAct, int tiempo) {
		visitados[vertex.getPosition()] = true;
		caminoAct.add(vertex.getData());
		boolean paro = false;
		
		if (tiempo-vertex.getData().getMinutos() >= 0) {
			tiempo -= vertex.getData().getMinutos();
			
			if (caminoAct.size() > caminoMax.size()) {
				caminoMax.removeAll(caminoMax);
				caminoMax.addAll(caminoAct);
			}
			
			if (caminoMax.size() == sitios.getSize())
				return true;
			else {
				for (Edge<lugar> edge: sitios.getEdges(vertex)) {
					int tiempoArista = edge.getWeight();
					if (!visitados[edge.getTarget().getPosition()] && !paro && tiempo-tiempoArista >= 0)
						paro = helper(sitios, edge.getTarget(), visitados, caminoMax, caminoAct, tiempo-tiempoArista);
				}
			}
		}
		
		caminoAct.remove(caminoAct.size()-1);
		visitados[vertex.getPosition()] = false;
		return paro;
	}
}
