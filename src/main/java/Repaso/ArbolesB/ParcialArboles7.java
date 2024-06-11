package Repaso.ArbolesB;

public class ParcialArboles7 {
	private BinaryTree<Integer> arbol;
	
	public ParcialArboles7 (BinaryTree<Integer> arbol) {
		this.arbol = arbol;
	}
	
	public BinaryTree<Integer> buscarNodo (BinaryTree<Integer> nodo, int num) {
		if (nodo.getData() == num) 
			return nodo;
		else {
			BinaryTree<Integer> aux = null;
			
			if (nodo.hasLeftChild()) 
				aux = buscarNodo(nodo.getLeftChild(), num);
			
			if ((nodo.hasRightChild()) && (aux == null))
				aux = buscarNodo(nodo.getRightChild(), num);
		
			if (aux != null)
				return aux;
			else 
				return null;
		}
	}
	
	public boolean isLeftTree (int num) {
		if ((arbol.isEmpty()) || (buscarNodo(arbol,num) == null))  // Si arbol vacio o no existe raiz num
			return false;
		else {
			int aux = isLeftTreeHelper((buscarNodo(arbol,num)), num);
			
			if (aux == 1)
				return true;
			else
				return false;
		}
	}
	
	private int isLeftTreeHelper(BinaryTree<Integer> nodo, int num) {
		if (nodo.isLeaf()) 
			return 0;
		else {
			int izq = 0;
			int der = 0;
			
			if (nodo.hasLeftChild())
	            izq += isLeftTreeHelper (nodo.getLeftChild(), num);

	        if (nodo.hasRightChild())
	            der += isLeftTreeHelper (nodo.getRightChild(), num);

	        if (nodo.hasLeftChild() && !nodo.hasRightChild())
	            izq++;
	        else if (!nodo.hasLeftChild() && nodo.hasRightChild())
	            der++;
	        
	        if (nodo.getData() != num)  // Si no es el nodo raiz hay que devolver todos los nodos que no tienen hijos
	        	return izq + der;
	        else // En caso de que si lo sea, asi se chequea para ver que devolver
	        	if (izq > der)
	        		return 1;
	        	else
	        		return 0;
		}
	}
	
	public static void main (String[] args){
		System.out.println("Test Ejercicio 7");
	        
		BinaryTree<Integer> ab = new BinaryTree<Integer>(2);
		ab.addLeftChild(new BinaryTree<Integer>(7));
		ab.addRightChild(new BinaryTree<Integer>(-5));
		ab.getLeftChild().addLeftChild(new BinaryTree<Integer>(23));
		ab.getLeftChild().addRightChild(new BinaryTree<Integer>(6));
		ab.getLeftChild().getLeftChild().addLeftChild(new BinaryTree<Integer>(-3));
		ab.getLeftChild().getRightChild().addLeftChild(new BinaryTree<Integer>(55));
		ab.getLeftChild().getRightChild().addRightChild(new BinaryTree<Integer>(11));
		ab.getRightChild().addLeftChild(new BinaryTree<Integer>(19));
		ab.getRightChild().getLeftChild().addRightChild(new BinaryTree<Integer>(4));
		ab.getRightChild().getLeftChild().getRightChild().addLeftChild(new BinaryTree<Integer>(18));
		ab.entreNiveles(0, 4);
	        
		System.out.println ();
		ParcialArboles7 parcialArb = new ParcialArboles7(ab);
		System.out.println("Resultado= " + parcialArb.isLeftTree(7));
		System.out.println("Resultado= " + parcialArb.isLeftTree(2));
		System.out.println("Resultado= " + parcialArb.isLeftTree(-5));
		System.out.println("Resultado= " + parcialArb.isLeftTree(19));
		System.out.println("Resultado= " + parcialArb.isLeftTree(-3));
	}
}
