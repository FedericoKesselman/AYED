package Tp3.Ej1;

import java.util.*;

public class GeneralTree<T> {
    private T data;
    private List<GeneralTree<T>> children = new LinkedList<GeneralTree<T>>();

    public GeneralTree (T data) {
        this.data = data;
    } 

    public GeneralTree (T data, List<GeneralTree <T>> children) {
        //this.data = data;
        this(data);
        this.children = children;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public List<GeneralTree<T>> getChildren() {
        return this.children;
    }

    public void addChild (GeneralTree<T> child) {
        getChildren().add(child);
    }

    public boolean hasChildren() {
        return getChildren() != null && !children.isEmpty();
    }

    public void removeChild (GeneralTree<T> child) {
        if (this.hasChildren()) 
            getChildren().remove(child);
    }

    public boolean isEmpty() {
        return data==null && !this.hasChildren();
    }
}