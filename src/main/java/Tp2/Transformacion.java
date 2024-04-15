package Tp2;

public class Transformacion {
    private BinaryTree<Integer> arbol;

    public Transformacion(BinaryTree<Integer> arbol) {
        this.arbol = arbol;
    }
    
    public BinaryTree<Integer> getArbol() {
		return arbol;
	}

	public void setArbol(BinaryTree<Integer> arbol) {
		this.arbol = arbol;
	}

    public BinaryTree<Integer> suma() {
        if (!arbol.isEmpty()) {
            suma(this.arbol);
            return arbol;
        }
        else
            System.out.println ("Arbol vacio.");
            return null;
    }

    public int suma (BinaryTree<Integer> arbol) {
        int cant = 0;

        if (arbol.isLeaf()) {
            int aux = arbol.getData();
            arbol.setData(0);
            return aux;
        } 
        else {
            if (arbol.hasLeftChild()) 
                cant += suma(arbol.getLeftChild());
            
            if (arbol.hasRightChild())
                cant += suma(arbol.getRightChild());

            int aux = arbol.getData();
            arbol.setData(cant);
            return  aux + cant;
        }
    }

    public static void main (String[] args) {
        System.out.println("Test Transformacion");
        BinaryTree<Integer> ab = new BinaryTree<Integer>(4);
        ab.addLeftChild(new BinaryTree<Integer>(2));
        ab.addRightChild(new BinaryTree<Integer>(6));
        ab.getLeftChild().addLeftChild(new BinaryTree<Integer>(1));
        ab.getLeftChild().addRightChild(new BinaryTree<Integer>(3));
        ab.getRightChild().addLeftChild(new BinaryTree<Integer>(5));
        ab.getRightChild().addRightChild(new BinaryTree<Integer>(8));
        
        ab.imprimirArbol();
        Transformacion tras = new Transformacion(ab);
        tras.suma();
        System.out.println();
        System.out.println("Arbol transformado");
        tras.getArbol().imprimirArbol();
    }
}
