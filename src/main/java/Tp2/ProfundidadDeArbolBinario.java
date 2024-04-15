package Tp2;

public class ProfundidadDeArbolBinario {
    private BinaryTree<Integer> arbol;

    public ProfundidadDeArbolBinario(BinaryTree<Integer> arbol) {
        this.arbol = arbol;
    }
    
    public BinaryTree<Integer> getArbol() {
		return arbol;
	}

	public void setArbol(BinaryTree<Integer> arbol) {
		this.arbol = arbol;
	}


    public int sumaElementosProfundidad (int i) {
        if (!arbol.isEmpty())
            return sumaElementosProfundidad(this.arbol, i, 0);
        else
            return 0;
    }

    public int sumaElementosProfundidad (BinaryTree<Integer> arbol, int i, int profundidad) {
        int cant = 0;

        if (profundidad == i) 
            cant++;
        else {
        
            if ((arbol.hasLeftChild()) && (profundidad < i))
                cant += sumaElementosProfundidad(arbol.getLeftChild(), i, profundidad+1);
            
            if ((arbol.hasRightChild()) && (profundidad < i))
                cant += sumaElementosProfundidad(arbol.getRightChild(), i, profundidad+1);

        }
        return cant;
    }

    public static void main (String[] args) {
        System.out.println("Test Profundidad");
        BinaryTree<Integer> ab = new BinaryTree<Integer>(4);
        ab.addLeftChild(new BinaryTree<Integer>(2));
        ab.addRightChild(new BinaryTree<Integer>(6));
        ab.getLeftChild().addLeftChild(new BinaryTree<Integer>(1));
        ab.getLeftChild().addRightChild(new BinaryTree<Integer>(3));
        ab.getRightChild().addLeftChild(new BinaryTree<Integer>(5));
        ab.getRightChild().addRightChild(new BinaryTree<Integer>(8));
        
        ProfundidadDeArbolBinario prof = new ProfundidadDeArbolBinario(ab);
        System.out.println(prof.sumaElementosProfundidad(2));
    }
}