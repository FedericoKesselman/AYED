package Repaso.ArbolesB;


public class RedBinariaLlena {
	private BinaryTree<Integer> arbol;
	
	public RedBinariaLlena (BinaryTree<Integer> arbol) {
		this.arbol = arbol;
	}
	
	public int retardoReenvio() {
		if (!arbol.isEmpty())
			return retardoReenvioHelper(arbol);
		else
			return -1;
	}
	
	public int retardoReenvioHelper(BinaryTree<Integer> nodo) {
		if (nodo.isLeaf())
			return nodo.getData();
		else {
			int reetardoIzq = 0;
			int reetardoDer = 0;
			
			if (nodo.hasLeftChild())
				reetardoIzq += retardoReenvioHelper(nodo.getLeftChild());
			
			if (nodo.hasRightChild())
				reetardoDer += retardoReenvioHelper(nodo.getRightChild());
			
			if (reetardoDer > reetardoIzq)
				return reetardoDer + nodo.getData();
			else
				return reetardoIzq + nodo.getData();
		}
	}
	
	
	public static void main (String[] args){
        BinaryTree<Integer> ab = new BinaryTree<Integer>(4);
        ab.addLeftChild(new BinaryTree<Integer>(2));
        ab.addRightChild(new BinaryTree<Integer>(6));
        ab.getLeftChild().addLeftChild(new BinaryTree<Integer>(1));
        ab.getLeftChild().addRightChild(new BinaryTree<Integer>(3));
        ab.getRightChild().addLeftChild(new BinaryTree<Integer>(5));
        ab.getRightChild().addRightChild(new BinaryTree<Integer>(8));
        
        RedBinariaLlena red = new RedBinariaLlena(ab);
        System.out.println (red.retardoReenvio());
	}
	
	
}
