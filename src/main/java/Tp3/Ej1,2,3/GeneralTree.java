package Tp3.Ej1;

import java.util.*;
import Tp1.ejercicio8.Queue;

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


    // Ejercicio 2
        // PreOrden
    public List<Integer> numerosImparesMayoresQuePreOrden (Integer n) {
        if (!a.isEmpty) {
            List<Integer> l = new LinkedList<Integer>();
            this.numImpPreOrden (n, l);
            return l;
        }
    }

    public void numImpPreOrden (Integer n, List<Integer> l) {
        int data = this.getData()
        if (data%2 != 0 && data > n)  
            l.add(data);

        List<GeneralTree<T>> children = this.getChildren(); 
        for (GeneralTree<T> child: children) 
            child.numImpPreOrden(n, l);
    }

        // InOrden
    public List<Integer> numerosImparesMayoresQueInOrden (Integer n) {
        if (!a.isEmpty) {
            List<Integer> l = new LinkedList<Integer>();
            this.numImpInOrden (n, l);
            return l;
        }
    }

    public void numImpInOrden (Integer n, List<Integer> l) {
        List<GeneralTree<T>> children = this.getChildren(); 

        if (this.hasChildren()) 
            children.get(0).numImpInOrden(n, l) // va hasta el hijo de mas a la izq

        int data = this.getData()
        if (data%2 != 0 && data > n)  
            l.add(data);
        
        for (GeneralTree<T> child: children) 
            child.numImpInOrden(n, l);
    }

        //PostOrden
    public List<Integer> numerosImparesMayoresQuePostOrden (Integer n) {
        if (!a.isEmpty) {
            List<Integer> l = new LinkedList<Integer>();
            this.numImpPostOrden (n, l);
            return l;
        }
    }

    public void numImpPostOrden (Integer n, List<Integer> l) {
        List<GeneralTree<T>> children = this.getChildren(); 
        
        for (GeneralTree<T> child: children) 
            child.numImpPostOrden(n, l);

        int data = this.getData()
        if (data%2 != 0 && data > n)  
            l.add(data);
    }

        //Niveles
    public List<Integer> numerosImparesMayoresQuePorNiveles (Integer n) {
        int data;
        List<T> result = new LinkedList<T>();
        GeneralTree<T> tree_aux;

        Queue<GeneralTree<T>> queue = new Queue<GeneralTree<T>>();
        queue.enqueue(this);

        while (!queue.isEmpty()) {
            tree_aux = queue.dequeue();

            if (!tree_aux.isEmpty()) { // chequea que tenga dato 
                data = tree_aux.getData();
                if (data%2 != 0 && data > n) result.add(data);
            }

            List<GeneralTree<T>> children = tree_aux.getChildren();
            for (GeneralTree<T> child: children) 
                queue.enqueue(chil);
        }
        
        return result;
    }





}