package Tp2.Ej1y2;

import java.util.*;

public class BinaryTree<T> {
	private T data;
	private BinaryTree<T> leftChild;
	private BinaryTree<T> rightChild;
	
	// constructors
	public BinaryTree(T data) {
		this.data = data;
		this.leftChild = null;
		this.rightChild = null;
	}
	
	public BinaryTree() {
		super();
	}
	
	// methods
	public T getData() {
		return data;
	}
	
	public void setData(T data) {
		this.data = data;
	}
	
	public BinaryTree<T> getLeftChild() {
		return this.leftChild;
	}
	
	public BinaryTree<T> getRightChild() {
		return this.rightChild;
	}
	
	public void addLeftChild (BinaryTree<T> child) {
		this.leftChild = child;
	}
	
	public void addRightChild (BinaryTree<T> child) {
		this.rightChild = child;
	}
	
	public void removeLeftChild () {
		this.leftChild = null;
	}
	
	public void removeRightChild () {
		this.rightChild = null;
	}
	
	public boolean isEmpty() {
		return 	this.getData() == null &
				this.isLeaf();
	}
	
	public boolean isLeaf() {
		return this.leftChild == null &
				this.rightChild == null;
	}
	
	public boolean hasLeftChild() {
		return this.leftChild != null;
	}
	
	public boolean hasRightChild() {
		return this.rightChild != null;
	}
	
	
	// exercise 2a
	public int contarHojas() {
		int leftC = 0;
		int rightC = 0;
		
		if (this.isEmpty())
			return 0;
		else 
			if (this.isLeaf()) 
				return 1;
			else {
				if(this.hasLeftChild())
					leftC = this.leftChild.contarHojas();
				if (this.hasRightChild())
					rightC = this.rightChild.contarHojas();
			}

		return leftC + rightC;
	}
	
	// exercise 2b
	public BinaryTree<T> espejo() {
		BinaryTree<T> mirror = new BinaryTree<T>(this.getData());
		
		if (this.hasLeftChild()) 
			mirror.addRightChild(this.getLeftChild().espejo());
		
		if (this.hasRightChild()) 
			mirror.addLeftChild(this.getRightChild().espejo());
		
		return mirror;
	}
	
	// exercise 2c
	public void entreNiveles(int n, int m) {
		
		if (this.isEmpty() || n < 0 || m < n) // empty tree
			return;
		
		Queue<BinaryTree<T>> cola = new LinkedList();
		cola.add(this);
		int nivel = 0;
		
		while (!cola.isEmpty()) {
			int cantNodos = cola.size();
				
			for (int i=0; i<cantNodos; i++) {
				BinaryTree<T> nodoActual = cola.remove();

				if (nivel >= n && nivel <= m) 
					System.out.print (nodoActual.getData() + " | ");

				
				if (nodoActual.hasLeftChild())
					cola.add(nodoActual.getLeftChild());

				if (nodoActual.hasRightChild()) 
					cola.add(nodoActual.getRightChild());	
			}	
			nivel++;	

			if (nivel > m) 
				break;
		}
	}

	 public void imprimirArbol() {
        if(this.hasLeftChild()) this.getLeftChild().imprimirArbol();
        System.out.print(this.getData() + " ");
        if(this.hasRightChild()) this.getRightChild().imprimirArbol();
    }


}


















