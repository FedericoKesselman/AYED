package Repaso.ArbolesB;

import java.util.*;

public class ProfundidadDeArbolBinario {
	private BinaryTree<Integer> arbol;

	public ProfundidadDeArbolBinario(BinaryTree<Integer> arbol) {
		this.arbol = arbol;
	}
	
	
	public int sumaElementosProfundidad (int p) {
		Queue<BinaryTree<Integer>> cola = new LinkedList<BinaryTree<Integer>>();
		BinaryTree<Integer> nodo;
		
		cola.add(arbol);
		cola.add(null);
		
		int nivel = 0;
		int suma = 0;
		
		while (!cola.isEmpty()) {
			nodo = cola.remove();
			
			if (nodo != null) {
				if (nivel == p)
					suma += nodo.getData();
				
				if (nodo.hasLeftChild())
					cola.add(nodo.getLeftChild());
				
				if (nodo.hasRightChild())
					cola.add(nodo.getRightChild());
			}
			else if (!cola.isEmpty()) {
				cola.add(null);
				nivel++;
			}
			
		}
		return suma;
	}
	
	public static void main (String[] args){
        BinaryTree<Integer> ab = new BinaryTree<Integer>(4);
        ab.addLeftChild(new BinaryTree<Integer>(2));
        ab.addRightChild(new BinaryTree<Integer>(6));
        ab.getLeftChild().addLeftChild(new BinaryTree<Integer>(1));
        ab.getLeftChild().addRightChild(new BinaryTree<Integer>(3));
        ab.getRightChild().addLeftChild(new BinaryTree<Integer>(5));
        ab.getRightChild().addRightChild(new BinaryTree<Integer>(8));
        
        ProfundidadDeArbolBinario suma = new ProfundidadDeArbolBinario(ab);
        System.out.println (suma.sumaElementosProfundidad(2));
	}
	
	
}
