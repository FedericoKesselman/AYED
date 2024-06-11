package Repaso.ArbolesB;

import java.util.*;

public class ContadorArbol{
	private BinaryTree<Integer> arbol;
	
	
	/* --------------------------------InOrden----------------------------*/
	public List<Integer> inOrden() {
		List<Integer> lista = new LinkedList<Integer>();
		
		if (!arbol.isEmpty()) 
			inOrdenHelper(arbol, lista);
		
		return lista;
	}
	
	private void inOrdenHelper (BinaryTree<Integer> nodo, List<Integer> lista) {
		if (nodo.hasLeftChild())
			inOrdenHelper (nodo.getLeftChild(), lista);
		
		if (nodo.getData() % 2 == 0)
			lista.add(nodo.getData());
		
		if (nodo.hasRightChild())
			inOrdenHelper (nodo.getRightChild(), lista);
	}
	
	
	/* --------------------------------PostOrden----------------------------*/
	public List<Integer> postOrden() {
		List<Integer> lista = new LinkedList<Integer>();
		
		if (!arbol.isEmpty()) 
			postOrdenHelper(arbol, lista);
		
		return lista;
	}
	
	private void postOrdenHelper (BinaryTree<Integer> nodo, List<Integer> lista) {
		if (nodo.hasLeftChild())
			inOrdenHelper (nodo.getLeftChild(), lista);
		
		if (nodo.hasRightChild())
			inOrdenHelper (nodo.getRightChild(), lista);
		
		if (nodo.getData() % 2 == 0)
			lista.add(nodo.getData());
	}
	
	
	/* --------------------------------PreOrden----------------------------*/
	public List<Integer> preOrden() {
		List<Integer> lista = new LinkedList<Integer>();
		
		if (!arbol.isEmpty()) 
			preOrdenHelper(arbol, lista);
		
		return lista;
	}
	
	private void preOrdenHelper (BinaryTree<Integer> nodo, List<Integer> lista) {
		if (nodo.getData() % 2 == 0)
			lista.add(nodo.getData());
		
		if (nodo.hasLeftChild())
			preOrdenHelper (nodo.getLeftChild(), lista);
		
		if (nodo.hasRightChild())
			preOrdenHelper (nodo.getRightChild(), lista);
	}
}
