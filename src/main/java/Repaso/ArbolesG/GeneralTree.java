package Repaso.ArbolesG;

import java.util.*;
import java.util.Queue;

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
    
    public boolean isLeaf() {
    	return (!this.hasChildren());
    }
    
    
    /*------------------------------------------EJ2------------------------------------------*/
    /* -- PreOrden -- */
    public List<Integer> numerosImparesMayoresQuePreOrden (GeneralTree <Integer> a, Integer n) {
    	List<Integer> lista = new LinkedList<Integer>();
    	
    	if (!a.isEmpty())
    		preOrdenHelper(a, n, lista);
    	
    	return lista; 	
    }
    
    private void preOrdenHelper (GeneralTree<Integer> nodo, Integer n, List<Integer> lista) {
    	if ((nodo.getData() % 2 == 0) && (nodo.getData() > n))
    			lista.add(nodo.getData());
    	
    	for (GeneralTree<Integer> child: nodo.getChildren()) 
    		preOrdenHelper (child, n, lista);
    }
    
    
    /* -- InOrden -- */
    public List<Integer> numerosImparesMayoresQueInOrden (GeneralTree <Integer> a, Integer n) {
    	List<Integer> lista = new LinkedList<Integer>();
    	
    	if (!a.isEmpty())
    		inOrdenHelper(a, n, lista);
    	
    	return lista;
    }
    
    private void inOrdenHelper (GeneralTree<Integer> a, Integer n, List<Integer> lista) {
    	List<GeneralTree<Integer>> childrens = a.getChildren(); 
    	
    	if (a.hasChildren())
    		inOrdenHelper(childrens.get(0), n, lista);
    	
    	if ( (a.getData() % 2 == 0) && (a.getData() > n) )
    		lista.add(a.getData());
    	
    	for (int i = 1; i < childrens.size(); i++)
    		inOrdenHelper(childrens.get(i), n, lista);
    }
    
    
    /* -- PostOrden -- */
    public List<Integer> numerosImparesMayoresQuePostOrden (GeneralTree <Integer> a, Integer n) {
    	List<Integer> lista = new LinkedList<>();
    	
    	if (!a.isEmpty())
    		postOrdenHelper(a, n, lista);
    	
    	return lista;
    }
    
    private void postOrdenHelper (GeneralTree<Integer> a, Integer n, List<Integer> lista) {
    	for (GeneralTree<Integer> child: a.getChildren())
    		postOrdenHelper (child, n, lista);
    	
    	if ( (a.getData() % 2 == 0) && (a.getData() > n) )
    		lista.add(a.getData());
    }
    
    
    /* -- PorNiveles -- */
    public List<Integer> numerosImparesMayoresQuePorNiveles(GeneralTree <Integer> a, Integer n) {
    	Queue<GeneralTree<Integer>> cola = new LinkedList<>();
    	List<Integer> lista = new LinkedList<>();
    	
    	cola.add(a);
    	
    	while (!cola.isEmpty()) {
    		GeneralTree<Integer> tree_aux = cola.remove();
    		
    		if (!tree_aux.isEmpty()) {
    			if ( (tree_aux.getData() % 2 == 0) && (tree_aux.getData() > n) )
    	    		lista.add(a.getData());
    		}
    		
    		for (GeneralTree<Integer> child: tree_aux.getChildren())
    			cola.add(child);
    	}
    	return lista;
    }
    
    
    /*------------------------------------------EJ3------------------------------------------*/
    /* -- Altura -- */
    public int altura() {
    	if (!this.isEmpty())
    		return alturaHelper();
    	else
    		return -1;
    }
    			
    private int alturaHelper() {
    	if (!this.hasChildren())
    		return 0;
    	else {
    		int max = -1;
    		int cant;
    		
    		for (GeneralTree<T> child: this.getChildren()) {
    			cant = 0;
    			cant += child.alturaHelper();
    			if (cant > max)
    				max = cant;
    		}
    		
    		return max+1;
    	}
    }
    
    
    /* -- Nivel -- */
    public int nivel(T dato) {
    	if (!this.isEmpty())
    		return nivelHelper(dato, 0);
    	else
    		return -1;
    }
    
    public int nivelHelper(T dato, int nivel) {
    	if (this.getData().equals(dato))
    		return nivel;
    	else {
    		int check = -1;
    		
    		for (GeneralTree<T> child: this.getChildren()) {
    			check = child.nivelHelper(dato, nivel+1);
    			if (check != -1)
    				return check;
    		}
    	}
    	return -1;
    }
    
    
    /* -- Ancho -- */
    public int ancho() {
    	Queue<GeneralTree<T>> cola = new LinkedList<>();
    	int ancho = 0;
    	int max = -1;
    	
    	cola.add(this);
    	cola.add(null);
    	
    	while (!cola.isEmpty()) {
    		GeneralTree<T> aux = cola.remove();
    		
    		if (aux != null) {	    		
	    		for (GeneralTree<T> child: aux.getChildren()) 
	    			cola.add(child);
	    		
	    		ancho++;
    		}
    		else if (!cola.isEmpty()) {
    			cola.add(null);
    			ancho = 0;
    			
    			if (ancho > max)
	    			max = ancho;
    		}
    	}
    	
    	return max;
    }
    
    
    /*------------------------------------------EJ5------------------------------------------*/
    public boolean esAncestro(T a, T b) {
    	if (!this.isEmpty()) {
    		GeneralTree<T> aux = buscar(this, a);
    		
    		if (aux != null)
    			return buscar(aux, b) != null;
    	}
    	
    	return false;
    }
    
    public GeneralTree<T> buscar(GeneralTree<T> nodo, T dato) {
    	if (nodo.getData().equals(dato))
    		return nodo;
    		
		GeneralTree<T> aux = null;
		
    	for (GeneralTree<T> child: nodo.getChildren()) {
    		aux = buscar(child, dato);
    		
    		if (aux != null)
    			return aux;
    	}
    		
    	return null;
    }
    
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


    
 
    

    
    

