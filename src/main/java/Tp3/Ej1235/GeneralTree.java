package Tp3.Ej1235;

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

    private void numImpPreOrden (Integer n, List<Integer> l) {
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

    private void numImpInOrden (Integer n, List<Integer> l) {
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

    private void numImpPostOrden (Integer n, List<Integer> l) {
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

    private int alt () {
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

    private int niv(T dato) {
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

    //Ejercicio5
    public boolean esAncestro(T a, T b) {
        if (!this.isEmpty()) {
            GeneralTree<T> nodo = buscar(a, b, this);

            if (nodo != null) { // si esta antes B, o no encuentra A es null
                GeneralTree<T> aux = buscar(b, b, nodo);
                if ( (aux != null) && (aux.getData().equals(b)) )
                    return true;
            }
        }
        return false;
    }

    private GeneralTree<T> buscar(T a, T b, GeneralTree<T> nodo) {
        GeneralTree<T> tree_aux;
        Queue<GeneralTree<T>> queue = new Queue<GeneralTree<T>>();
        
        queue.enqueue(nodo);

        while (!queue.isEmpty()) {
            tree_aux = queue.dequeue();
            
            if (tree_aux.getData().equals(a))  
                return tree_aux;
            else if (tree_aux.getData().equals(b)) // encuentra antes a B, retorna null
                return null;

            List<GeneralTree<T>> children = tree_aux.getChildren();
            for (GeneralTree<T> child: children) 
                queue.enqueue(child);
        }
        return null;
    }
    // El unico problema es que si A y B tiene el mismo valor va a dar siempre true


    public static void main(String[] args) {
        List<GeneralTree<Integer>> children1 = new LinkedList<GeneralTree<Integer>>();
        children1.add(new GeneralTree<Integer>(4));
        children1.add(new GeneralTree<Integer>(7));
        children1.add(new GeneralTree<Integer>(5));
        GeneralTree<Integer> a1 = new GeneralTree<Integer>((13), children1);
        
        List<GeneralTree<Integer>> children2 = new LinkedList<GeneralTree<Integer>>();
        children2.add(new GeneralTree<Integer>(6));
        children2.add(new GeneralTree<Integer>(10));
        children2.add(new GeneralTree<Integer>(18));
        GeneralTree<Integer> a2 = new GeneralTree<Integer>((25), children2);
        
        List<GeneralTree<Integer>> children3 = new LinkedList<GeneralTree<Integer>>();
        children3.add(new GeneralTree<Integer>(9));
        children3.add(new GeneralTree<Integer>(12));
        children3.add(new GeneralTree<Integer>(19));
        GeneralTree<Integer> a3 = new GeneralTree<Integer>((11), children3);
        
        List<GeneralTree<Integer>> children4 = new LinkedList<GeneralTree<Integer>>();
        children4.add(a1);
        children4.add(a2);
        children4.add(a3);
        GeneralTree<Integer> a = new GeneralTree<Integer>((14), children4);
        
        System.out.println(a.esAncestro(14,11));
        
    }
    
    
    
}