package Tp5.Ej1.Matrix;

public class Vertex<T> {
    private T data;
    private int position;

    Vertex (int data, int position) {
        this.data = data;
        this.position = position;
    }

    public void setData (T data) {
        this.data = data;
    }

    public T getData () {
        return this.data;
    }

    void setPosition (int position) {
        this.position = position;
    }

    public int getPosition () {
        return this.position;
    }

    void decrementPosition () {
        this.position--;
    }
}