package Tp5.Ej1.Matrix;

public class Edge<T> {
    private Vertex<T> target;
    private int weight;

    Edge (Vertex<T> target, int weight) {
        this.target = target;
        this.weight = weight;
    }

    public Vertex<T> getTarget() {
        return this.target;
    }

    public int getWeight() {
        return this.weight;
    }
} 