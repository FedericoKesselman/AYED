package ArbolesB;

public class Transformacion {
	private BinaryTree<Integer> arbol;
	
	public Transformacion(BinaryTree<Integer> arbol) {
		this.arbol = arbol;
	}
	
	public BinaryTree<Integer> suma() {
		if (!arbol.isEmpty()) 
			return sumaHelper(arbol);
		else
			return new BinaryTree<Integer>();
	}
	
	private BinaryTree<Integer> sumaHelper(BinaryTree<Integer> nodo) {
		if (nodo.isLeaf()) 
			return new BinaryTree<>(0);
		else {
			BinaryTree<Integer> izq = null; // hay que inicializarlo en null si o si. Si es que lo tiene despues lo pisa
			BinaryTree<Integer> der = null;
			int suma = 0;
			
			if (nodo.hasLeftChild()) {
				izq = sumaHelper(nodo.getLeftChild());
				suma += izq.getData() + nodo.getLeftChild().getData(); // Suma del hijo izq + dato del nodo que no esta sumado
			}
			
			if (nodo.hasRightChild()) {
				der = sumaHelper(nodo.getRightChild());
				suma += der.getData() + nodo.getRightChild().getData(); // Suma del hijo der + dato del nodo que no esta sumado
			}
			
			BinaryTree<Integer> aux = new BinaryTree<Integer>(suma);
			aux.addLeftChild(izq);
			aux.addRightChild(der);
			return aux;
		}
	}
	
	
	public void imprimirArbol() {
        if(arbol.hasLeftChild()) arbol.getLeftChild().imprimirArbol();
        System.out.print(arbol.getData() + " ");
        if(arbol.hasRightChild()) arbol.getRightChild().imprimirArbol();
    }
	
	
	public static void main (String[] args){
        BinaryTree<Integer> ab = new BinaryTree<Integer>(4);
        ab.addLeftChild(new BinaryTree<Integer>(2));
        ab.addRightChild(new BinaryTree<Integer>(6));
        ab.getLeftChild().addLeftChild(new BinaryTree<Integer>(1));
        ab.getLeftChild().addRightChild(new BinaryTree<Integer>(3));
        ab.getRightChild().addLeftChild(new BinaryTree<Integer>(5));
        ab.getRightChild().addRightChild(new BinaryTree<Integer>(8));
        
        Transformacion tran = new Transformacion(ab);
        tran.suma().imprimirArbol();
	}
	
}
