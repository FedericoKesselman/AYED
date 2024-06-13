package ArbolesB;

public class Repaso {
	BinaryTree<Integer> arbol;
	
	public Repaso (BinaryTree<Integer> arbol) {
		this.arbol = arbol;
	}
	
	public boolean resolver (int k) {
		if (!arbol.isEmpty())
			return resolverHelper (arbol, k, 0);
		
		return false;
	}
	
	private boolean resolverHelper (BinaryTree<Integer> nodo, int k, int sumaAct) {
		if (nodo.isLeaf()) {
			if (sumaAct+nodo.getData() == k)
				return true;
			else
				return false;
		}
		else {
			boolean cumple = true;
			
			if (nodo.hasLeftChild())
				cumple = resolverHelper (nodo.getLeftChild(), k, sumaAct+nodo.getData());
			
			if ( (nodo.hasRightChild()) && cumple) 
				cumple = resolverHelper (nodo.getRightChild(), k, sumaAct+nodo.getData());
			
			
			return cumple;
		}
	}
	
	public static void main(String[] args) {
        System.out.println("Test Ejercicio 7");

        BinaryTree<Integer> ab = new BinaryTree<>(2);
        ab.addLeftChild(new BinaryTree<>(1));
        ab.addRightChild(new BinaryTree<>(2));

        ab.getLeftChild().addLeftChild(new BinaryTree<>(5));
        ab.getLeftChild().addRightChild(new BinaryTree<>(4));
        ab.getLeftChild().getRightChild().addLeftChild(new BinaryTree<>(1));
        ab.getLeftChild().getRightChild().addRightChild(new BinaryTree<>(1));

        ab.getRightChild().addLeftChild(new BinaryTree<>(1));
        ab.getRightChild().addRightChild(new BinaryTree<>(2));
        ab.getRightChild().getRightChild().addRightChild(new BinaryTree<>(2));
        ab.getRightChild().getLeftChild().addLeftChild(new BinaryTree<>(3));
        
        Repaso aux = new Repaso(ab);
        System.out.print(aux.resolver(8));
	}
	
}
