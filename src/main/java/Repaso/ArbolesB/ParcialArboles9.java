package ArbolesB;

public class ParcialArboles9 {
	
	/*
	public BinaryTree<SumDif> sumAndDif(BinaryTree<Integer> arbol) {
		if (!arbol.isEmpty())
			return sumAndDifHelper(arbol, arbol.getData());
		else
			return new BinaryTree<SumDif>(new SumDif (0,0));
	}

	private BinaryTree<SumDif> sumAndDifHelper(BinaryTree<Integer> nodo, int suma){
		if (nodo.isLeaf()) 
			return new BinaryTree<SumDif>(new SumDif(suma, nodo.getData()-suma));
		else {
			BinaryTree<SumDif> izq = null; 
			BinaryTree<SumDif> der = null;
			
			if (nodo.hasLeftChild()) 
				izq = sumAndDifHelper(nodo.getLeftChild(), nodo.getData()+suma);
			
			if (nodo.hasRightChild()) 
				der = sumAndDifHelper(nodo.getRightChild(), nodo.getData()+suma);
				
			BinaryTree<SumDif> aux = new BinaryTree<SumDif>(new SumDif(suma, nodo.getData()-suma));
			aux.addLeftChild(izq);
			aux.addRightChild(der);
			return aux;	
	
		}
	}
	No hace bien el calculo para el nodo raiz. */
	
	
	public BinaryTree<SumDif> sumAndDif(BinaryTree<Integer> arbol) {
        BinaryTree<SumDif> a = new BinaryTree<>();
        sumAndDifHelper(arbol, a, 0, 0);
        return a;
    }
	
	private void sumAndDifHelper (BinaryTree<Integer> arbol, BinaryTree<SumDif> sad, int sum, int parent) {
		SumDif aux = new SumDif (sum+arbol.getData(), arbol.getData()-parent);
		sad.setData(aux);
		
		if (arbol.hasLeftChild()) {
			sad.addLeftChild(new BinaryTree<SumDif>());
			sumAndDifHelper (arbol.getLeftChild(), sad.getLeftChild(), (sum+arbol.getData()), arbol.getData());
		}
		
		if (arbol.hasRightChild()) {
			sad.addRightChild(new BinaryTree<SumDif>());
			sumAndDifHelper (arbol.getRightChild(), sad.getRightChild(), (sum+arbol.getData()), arbol.getData());
		}
	}
	
	
	public static void main(String[] args) {
        System.out.println("Test Ejercicio9");
        ParcialArboles9 parcialArb = new ParcialArboles9();
        
        BinaryTree<Integer> ab = new BinaryTree<Integer>(20);
        ab.addLeftChild(new BinaryTree<Integer>(5));
        ab.getLeftChild().addLeftChild(new BinaryTree<Integer>(-5));
        ab.getLeftChild().addRightChild(new BinaryTree<Integer>(10));
        ab.getLeftChild().getRightChild().addLeftChild(new BinaryTree<Integer>(1));
        ab.addRightChild(new BinaryTree<Integer>(30));
        ab.getRightChild().addLeftChild(new BinaryTree<Integer>(50));
        ab.getRightChild().addRightChild(new BinaryTree<Integer>(-9));
        ab.getRightChild().getLeftChild().addRightChild(new BinaryTree<Integer>(4));
        ab.getRightChild().getLeftChild().getRightChild().addRightChild(new BinaryTree<Integer>(6));
        
        ab.entreNiveles(0, 4);
        System.out.println();
        System.out.println("Nuevo arbol:");
        parcialArb.sumAndDif(ab).entreNiveles(0, 4);
    }

	
}
