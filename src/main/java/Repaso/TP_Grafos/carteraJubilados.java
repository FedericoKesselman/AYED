package TP_Grafos;
import java.util.*;


public class carteraJubilados {

	public List<String> crearCartera (Graph<Persona> personas, String empleado, int separacion) {
		List<String> lista = new LinkedList<>();
 
        if (!personas.isEmpty()) {
        	Vertex<Persona> v = buscarEmpleado (personas, empleado);
        	
        	if (v != null) {	
        		boolean[] visitados = new boolean[personas.getSize()];
		        visitados[v.getPosition()] = true;
		
		        Queue<Vertex<Persona>> cola = new Queue<Vertex<Persona>>();
		        cola.enqueue(v);
		        cola.enqueue(null);
		        int nivel = 0;
		
		        while (!cola.isEmpty() && nivel <= separacion && lista.size() < 40) {
		            Vertex<Persona> w = cola.dequeue();
		            
		            if (w != null) {
			            for (Edge<Persona> edge: personas.getEdges(w)) {
			                int pos = edge.getTarget().getPosition();
			
			                if (!visitados[pos]) {
			                    visitados[pos] = true;
			                    cola.enqueue(edge.getTarget());
			                }
			            }
			            
			            if (w.getData().cumple() && lista.size() < 40) 
			            	lista.add(w.getData().getNombre());
			            
			            
		            }
		            else if (!cola.isEmpty()) {
		            	cola.enqueue(null);
		            	nivel++;
		            }
		        }
        	}	
        	
        }
        return lista;
	}
	
	private Vertex<Persona> buscarEmpleado (Graph<Persona> personas, String empleado) {
		for (Vertex<Persona> per: personas.getVertices()) {
			if (per.getData().getNombre().equals(empleado))
				return per;
		}
		return null;
	}
	
	
	public static void main(String[] args) {
        Graph<Persona> grafo = new AdjListGraph<>();
        Vertex v1 = grafo.createVertex(new Persona(false, "Matias", "AAA", true));
        Vertex v2 = grafo.createVertex(new Persona(true, "Julian", "BBB", false));
        Vertex v3 = grafo.createVertex(new Persona(true, "Francisco", "CCC", false));
        Vertex v4 = grafo.createVertex(new Persona(false, "Valentin", "DDD", true));
        Vertex v5 = grafo.createVertex(new Persona(true, "Omar", "EEE", true));
        Vertex v6 = grafo.createVertex(new Persona(false, "Rosana", "FFF", true));
        Vertex v7 = grafo.createVertex(new Persona(true, "Maria", "GGG", false));
        Vertex v8 = grafo.createVertex(new Persona(true, "Sandra", "HHH", true));
        Vertex v9 = grafo.createVertex(new Persona(true, "Matheo", "III", false));
        
        grafo.connect(v1, v2);
        grafo.connect(v2, v1);
        grafo.connect(v2, v3);
        grafo.connect(v3, v2);
        
        grafo.connect(v1, v9);
        grafo.connect(v9, v1);
        grafo.connect(v9, v8);
        grafo.connect(v8, v9);
        
        grafo.connect(v1, v4);
        grafo.connect(v4, v1);
        grafo.connect(v1, v6);
        grafo.connect(v6, v1);
        grafo.connect(v4, v5);
        grafo.connect(v5, v4);
        grafo.connect(v5, v7);
        grafo.connect(v7, v5);
        
        carteraJubilados banco = new carteraJubilados();
        
        System.out.println(banco.crearCartera(grafo, "Matias", 2));
    }
        
}
