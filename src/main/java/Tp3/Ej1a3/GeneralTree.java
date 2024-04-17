package Tp3.Ej1a3;

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
    	List<Integer> l = new LinkedList<Integer>();
        if (!this.isEmpty()) 
            this.numImpPreOrden (n, l);
        return l;
    }

    public void numImpPreOrden (Integer n, List<Integer> l) {
        int data = (Integer) this.getData();
        if (data%2 != 0 && data > n)  
            l.add(data);

        List<GeneralTree<T>> children = this.getChildren(); 
        for (GeneralTree<T> child: children) 
            child.numImpPreOrden(n, l);
    }

        // InOrden
    public List<Integer> numerosImparesMayoresQueInOrden (Integer n) {
    	List<Integer> l = new LinkedList<Integer>();
        if (!this.isEmpty()) 
            this.numImpInOrden (n, l);
        return l;
    }

    public void numImpInOrden (Integer n, List<Integer> l) {
        List<GeneralTree<T>> children = this.getChildren(); 

        if (this.hasChildren()) 
            children.get(0).numImpInOrden(n, l); // va hasta el hijo de mas a la izq

        int data = (Integer) this.getData();
        if (data%2 != 0 && data > n)  
            l.add(data);
        
        for (GeneralTree<T> child: children) 
            child.numImpInOrden(n, l);
    }

        //PostOrden
    public List<Integer> numerosImparesMayoresQuePostOrden (Integer n) {
    	List<Integer> l = new LinkedList<Integer>();
        if (!this.isEmpty()) 
            this.numImpPostOrden (n, l);
        return l;
    }

    public void numImpPostOrden (Integer n, List<Integer> l) {
        List<GeneralTree<T>> children = this.getChildren(); 
        
        for (GeneralTree<T> child: children) 
            child.numImpPostOrden(n, l);

        int data = (Integer) this.getData();
        if (data%2 != 0 && data > n)  
            l.add(data);
    }

        //Niveles
    public List<Integer> numerosImparesMayoresQuePorNiveles (Integer n) {
        int data;
        List<Integer> result = new LinkedList<Integer>();
        GeneralTree<T> tree_aux;

        Queue<GeneralTree<T>> queue = new Queue<GeneralTree<T>>();
        queue.enqueue(this);

        while (!queue.isEmpty()) {
            tree_aux = queue.dequeue();

            if (!tree_aux.isEmpty()) { // chequea que tenga dato 
                data = (Integer) tree_aux.getData();
                if (data%2 != 0 && data > n) result.add(data);
            }

            List<GeneralTree<T>> children = tree_aux.getChildren();
            for (GeneralTree<T> child: children) 
                queue.enqueue(child);
        }
        
        return result;
    }

    //Ejercicio3
    public int altura() {
        if (this.isEmpty()) 
            return -1;
        else
            return alt();
    }

    public int alt () {
        if (!this.hasChildren()) 
            return 0;
        else {
            int maximo = -1;
            int cant;

            List<GeneralTree<T>> children = this.getChildren(); 
            for (GeneralTree<T> child: children) {
                cant = 0;
                cant += child.alt();
                if (cant > maximo)
                    maximo = cant;
            }

            return maximo + 1;
        }
    }

    public int nivel (T dato) {
        if (!this.isEmpty()) 
            return niv(dato);
        else
            return -1;
    }

    public int niv(T dato) {
        if (this.getData() == dato)
            return (this.alt()); // si el dato es la raiz
        else {
            List<GeneralTree<T>> children = this.getChildren(); 

            for (GeneralTree<T> child: children) {
                if (child.getData() == dato) 
                    return (child.alt());

                child.niv(dato);
            }
            return -1;
        }
    }


    public int ancho(){ 
        if(this.isEmpty()) 
            return 0;
        else 
            return anchoHelper();
    }
    
    private int anchoHelper() {
        int cant = 0;
        int max = -1;

        GeneralTree<T> tree_aux;
        Queue<GeneralTree<T>> queue = new Queue<GeneralTree<T>>();

        queue.enqueue(this);
        queue.enqueue(null);

        while (!queue.isEmpty()) {
            tree_aux = queue.dequeue();

            if (tree_aux!= null) { // 
                List<GeneralTree<T>> children = tree_aux.getChildren();

                for (GeneralTree<T> child: children) {
                    queue.enqueue(child);
                    cant++;
                }
                queue.enqueue(null);
            }
            else {
                if (cant > max) 
                    max = cant;
                cant = 0;
            }
        }
        
        return max;
    }


}