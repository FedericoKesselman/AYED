package Tp5.Ej1.Matrix;
import java.util.ArrayList;

public class MatrixGraph<T> {
    private static final int EMPTY_VALUE = 0;
    private int maxVertices;
    private List<Vertex<T>> vertices;
    private int[][] adjMatrix; 


    public MatrixGraph (int maxVert) {
        this.maxVertices = maxVert;

        vertices = new ArrayList<>();
        adjMatrix = new int [maxVertices][maxVertices];

        for (int i = 0; i < maxVertices; i++) {
            for (int j = 0; j < maxVertices; j++) {
            	adjMatrix[i][j] = EMPTY_VALUE;
            }
        }
    }


    public Vertex<T> createVertex (T data) {
        if (vertices.size() == maxVertices) 
            return null;
        
        Vertex<T> vertice = new Vertex<>(data, vertices.size());
        vertices.add(vertice);
        
        return vertice;
    }


    public void removeVertex(Vertex<T> vertex) {
        if (!vertices.remove(vertex)) 
    		return;
        
        int index = vertex.getPosition();
        int total = vertices.size();

        // Elimino la fila
        for (int fila = index; fila < total; fila++) {
        	adjMatrix[fila] = adjMatrix[fila + 1];
        }

        // Elimino la columna
        for (int fila = 0; fila < total; fila++) {
            for (int col = index; col < total; col++) {
            	adjMatrix[fila][col] = adjMatrix[fila][col + 1];
            }
        }

        for (int fila = index; fila < total; fila++) {
        	vertices.get(fila).decrementPosition();
        }

        // Limpio la ultima fila
        for (int col = 0; col < total; col++) {
        	adjMatrix[total][col] = EMPTY_VALUE;
        }
        // Limpio la ultima columna
        for (int fila = 0; fila < total; fila++) {
        	adjMatrix[fila][total] = EMPTY_VALUE;
        }
    }

    public Vertex<T> search(T data) {
		for (Vertex<T> vertice : this.vertices) {
			if (vertice.getData().equals(data)) {
				return vertice;
			}
		}
		return null;
	}


    private boolean belongs(Vertex<T> vertex) {
        int pos = vertex.getPosition();
        return (pos >= 0) && (pos < this.vertices.size()) && (this.vertices.get(pos) == vertex);
    }


    public void connect (Vertex<T> origin, Vertex<T> destination) {
        connext(origin, destination, 1);
    }

    public void connect (Vertex<T> origin, Vertex<T> destination, int weight) {
        if (this.belongs(origin)) && (this.belongs(destination)) {
            adjMatrix[((Vertex<T>) origin).getPosition()] [((Vertex<T>) destination).getPosition()] = weight;
        }
    }


    public void disconnext (Vertex<T> origin, Vertex<T> destination) {
        if (this.belongs(origin)) {
            connext (origin, destination, EMPTY_VALUE);
        }
    }


    public boolean existsEdge (Vertex<T> origin, Vertex<T> destination) {
        return this.weight(origin, destination) != EMPTY_VALUE;
    }


    public boolean isEmpty() {
        return vertices.isEmpty();
    }


    public List<Vertex<T>> getVertices() {
    	return new ArrayList<>(this.vertices);
    }


    public int weight(Vertex<T> origin, Vertex<T> destination) {
    	int weight = 0;
    	if (this.belongs(origin) && this.belongs(destination)) {
    		weight = adjMatrix[((AdjMatrixVertex<T>) origin).getPosition()]
    				[((AdjMatrixVertex<T>) destination).getPosition()];
    	}
   		return weight;
    }


    
}