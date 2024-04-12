package Tp2;
import java.util.*;
import Tp2.BinaryTree;

public class RedBinariaLlena {
    private BinaryTree<Integer> arbol;

    public RedBinariaLlena (BinaryTree<Integer> arbol) {
        this.setArbol(arbol);
    }

    public BinaryTree<Integer> getArbol() {
		return arbol;
	}

	public void setArbol(BinaryTree<Integer> arbol) {
		this.arbol = arbol;
	}
    //

    /* public int retardoReenvio() {
        LinkedList<Integer> lista = new LinkedList<>();

        if (!getArbol().isEmpty()) {
            lista.add(getArbol().getData()); // guarda raiz
            retardoR(lista, getArbol());
        }

        int retardo = 0;
        for (int elto: lista)
            retardo += elto;
        
        return retardo;
    }


    public void retardoR (LinkedList<Integer> lista, BinaryTree<Integer> nodo) {
        BinaryTree<Integer> izq;
        BinaryTree<Integer> der;

        if (nodo.hasLeftChild()) { 
            izq = nodo.getLeftChild();
            der = nodo.getRightChild();
        }
        else return;

        if (izq.getData() > der.getData()) {
            lista.add(izq.getData());
            retardoR(lista, izq);
        }
        else {
            lista.add(der.getData());
            retardoR(lista, der);
        }
    } 
    funciona correctamente pero siempre y cuando el arbol este ordenado
	*/ 

    public int retardoReenvio() {
        if (!arbol.isEmpty()) 
            return retardoReenvio(arbol);
        else 
            return 0;
    }


    public int retardoReenvio (BinaryTree<Integer> arbol) {
        int retHI = 0;
        int retHD = 0;

        if (arbol.hasLeftChild()) {
            retHI = retardoReenvio(arbol.getLeftChild());
            retHD = retardoReenvio(arbol.getRightChild());
        }

        return (Math.max(retHI, retHD) + arbol.getData());
    }


    public static void main (String[] args) {
        System.out.println("Test mayor retardo");
        BinaryTree<Integer> ab = new BinaryTree<Integer>(4);
        ab.addLeftChild(new BinaryTree<Integer>(2));
        ab.addRightChild(new BinaryTree<Integer>(6));
        ab.getLeftChild().addLeftChild(new BinaryTree<Integer>(1));
        ab.getLeftChild().addRightChild(new BinaryTree<Integer>(3));
        ab.getRightChild().addLeftChild(new BinaryTree<Integer>(5));
        ab.getRightChild().addRightChild(new BinaryTree<Integer>(8));
        
        RedBinariaLlena red = new RedBinariaLlena(ab);
        System.out.println("El mayor retardo posible es de: " + red.retardoReenvio() + " segundos");
    }

}