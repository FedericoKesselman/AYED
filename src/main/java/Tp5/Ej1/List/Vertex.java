package Tp5.Ej1.List;

public class Vertex<T> {
    private T data;
    private int position;
    private List<Edge<T>> edges;

    Vertex (int data, int position) {
        this.data = data;
        this.position = position;
        this.edges = new ArrayList<>();
    }

    public void setData (T data) {
        this.data = data;
    }

    public T getData () {
        return this.data;
    }

    public void setPosition (int position) {
        this.position = position;
    }

    public int getPosition () {
        return this.position;
    }

    void decrementPosition () {
        this.position--;
    }

    void connect (Vertex<T> destination) {
        this.connect (destination, 1);
    }

    void connext (Vertex<T> destination, int weight) {
        Edge<T> edge = this.getEdge(destination);

        if (edge == null) 
			this.edges.add(new Edge<>(destination, weight));
    }


    void disconnect(Vertex<T> destination) {
		Edge<T> edge = this.getEdge(destination);

		if (edge != null) 
			this.edges.remove(edge);
	}

	public List<Edge<T>> getEdges() {
		return this.edges;
	}

	/**
	 * Retorna, si es que existe, la arista hacia el vertice recibido.
	 */
	public Edge<T> getEdge(Vertex<T> destination) {
		for (Edge<T> edge : this.edges) {
			if (edge.getTarget() == destination) 
				return edge;
		}
        
		return null;
	}
}