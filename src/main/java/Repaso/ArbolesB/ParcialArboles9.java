package Repaso.ArbolesB;

public class ParcialArboles9 {
	
	public BinaryTree<SumDif> sumAndDif (BinaryTree<Integer> arbol) {
		BinaryTree<SumDif> ab = new BinaryTree<SumDif>();
		
		if (!arbol.isEmpty())
			sumAndDifHelper (arbol, ab, 0);
		
		return ab;
	}
	
	private void sumAndDifHelper (BinaryTree<Integer> nodo, BinaryTree<SumDif> ab, int sumPadre) {
		SumDif elem = new SumDif (nodo.getData()+sumPadre, nodo.getData()-sumPadre);
		ab.setData(elem);
		
		if (nodo.hasLeftChild()) {
			BinaryTree<SumDif> aux = new BinaryTree<SumDif>();
			ab.addLeftChild(aux);
			sumAndDifHelper(nodo.getLeftChild(), aux, nodo.getData()+sumPadre);
		}
		
		if (nodo.hasRightChild()) {
			BinaryTree<SumDif> aux = new BinaryTree<SumDif>();
			ab.addRightChild(aux);
			sumAndDifHelper(nodo.getRightChild(), aux, nodo.getData()+sumPadre);
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
