package Tp5.Ej1.List;
import java.util.*;

public class Graph<T> {
    private List<Vertex<T>> vertices;

    public Graph() {
        this.vertices = new ArrayList<>();
    }

    public Vertex<T> createVertex(T data) {
        int newPos = this.vertices.size();
        Vertex<T> vertice = new Vertex(data, newPos);
        this.vertices.add (vertice);

        return vertice;
    }

    public void removeVertex(Vertex<T> vertex) {
        int position = vertex.getPosition();

        if (this.vertices.get(position) != vertex) 
            return;

        this.vertices.remove(position);

        for (; position < this.vertices.size(); position++) {
            this.vertices.get(position).decrementPosition();
        }

        for (Vertex<T> other: this.vertices) {
            this.disconnect(other, vertex);
        }
    }


    public Vertex<T> search(T data) {
		for (Vertex<T> vertex : this.vertices) {
			if (vertex.getData().equals(data)) {
				return vertex;
			}
		}
		return null;
	}

	/**
	 * Indica si el vértice recibido pertenece al grafo.
	 */
	private boolean belongs(Vertex<T> vertex) {
		int pos = vertex.getPosition();
		return pos >= 0 && pos < this.vertices.size() && this.vertices.get(pos) == vertex;
	}


	public void connect(Vertex<T> origin, Vertex<T> destination) {
		if (this.belongs(origin) && this.belongs(destination)) {
			((Vertex<T>) origin).connect(destination);
		}
	}

	public void connect(Vertex<T> origin, Vertex<T> destination, int weight) {
		if (this.belongs(origin) && this.belongs(destination)) {
			((Vertex<T>) origin).connect(destination, weight);
		}
	}


	public void disconnect(Vertex<T> origin, Vertex<T> destination) {
		if (this.belongs(origin)) {
			((Vertex<T>) origin).disconnect(destination);
		}
	}

	/**
	 * Retorna la arista entre los dos vértices, si es que existe.  Previamente valida
	 * que el vértice pertenezca al grafo.
	 */
	private Edge<T> edge(Vertex<T> origin, Vertex<T> destination) {
		if (this.belongs(origin)) {
			return ((Vertex<T>) origin).getEdge(destination);
		}
		return null;
	}

	
	public boolean existsEdge(Vertex<T> origin, Vertex<T> destination) {
		return this.edge(origin, destination) != null;
	}

	
	public int weight(Vertex<T> origin, Vertex<T> destination) {
		Edge<T> edge = this.edge(origin, destination);
		int weight = 0;

		if (edge != null) 
			weight = edge.getWeight();
		
		return weight;
	}


	public boolean isEmpty() {
		return this.vertices.isEmpty();
	}


	public List<Vertex<T>> getVertices() {
		return new ArrayList<>(this.vertices);
	}


	public List<Edge<T>> getEdges(Vertex<T> vertex) {
		if (this.belongs(vertex)) {
			return ((Vertex<T>) vertex).getEdges();
		}
		return null;
	}


	public Vertex<T> getVertex(int position) {
		if (position < 0 || this.vertices.size()<= position) {
			// la posición recibida es incorrecta
			return null;
		}
		return this.vertices.get(position);
	}
	
	
	public int getSize() {
		return this.vertices.size();
	}
} 