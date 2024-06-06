package Tp2;

public class Ejercicio7 {
    private BinaryTree<Integer> arbol;
    
    public Ejercicio7 (BinaryTree<Integer> arbol) {
    	this.arbol = arbol;
    }

    public boolean isLeftTree (int num) {

        if (!arbol.isEmpty()) {

            if (isLeftT(buscar(this.arbol, num), num) == 1)
                return true;
            else
                return false;

        } 
        else
            return false;
    }

    private BinaryTree<Integer> buscar (BinaryTree<Integer> nodo, int num) {
        if (nodo.getData()== num)
            return nodo;
        
        BinaryTree<Integer> res = new BinaryTree<Integer>();

        if(nodo.hasLeftChild()) 
            res = buscar(nodo.getLeftChild(), num);

        if((nodo.hasRightChild()) && (res.isEmpty())) 
            res = buscar(nodo.getRightChild(), num);
        
        return res;
    }


    private int isLeftT (BinaryTree<Integer> nodo, int num) {
        int cantL = 0;
        int cantR = 0;
        
        if (nodo.hasLeftChild())
            cantL += isLeftT (nodo.getLeftChild(), num);

        if (nodo.hasRightChild())
            cantR += isLeftT (nodo.getRightChild(), num);

        //
        if (nodo.hasLeftChild() && !nodo.hasRightChild())
            cantL++;
        else {
            if (!nodo.hasLeftChild() && nodo.hasRightChild())
            cantR++;
        }
        //

        if (nodo.getData() != num)
            return cantL + cantR;
        else 
            if (cantL > cantR)
                return 1;
            else
                return 0;
    }

    public static void main (String[] args) { 
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
        Ejercicio7 parcialArb = new Ejercicio7(ab);
        System.out.println("Resultado= " + parcialArb.isLeftTree(7));
        System.out.println("Resultado= " + parcialArb.isLeftTree(2));
        System.out.println("Resultado= " + parcialArb.isLeftTree(-5));
        System.out.println("Resultado= " + parcialArb.isLeftTree(19));
        System.out.println("Resultado= " + parcialArb.isLeftTree(-3));
    }

}