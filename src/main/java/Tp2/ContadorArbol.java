package Tp2;

import Tp2.BinaryTree;
import java.util.LinkedList;

public class ContadorArbol {
    private BinaryTree<Integer> arbol;

    public ContadorArbol(BinaryTree<Integer> arbol) {
        this.setArbol(arbol);
    }

    public BinaryTree<Integer> getArbol() {
		return arbol;
	}

	public void setArbol(BinaryTree<Integer> arbol) {
		this.arbol = arbol;
	}

    // preorden:
    public LinkedList<Integer> numerosParesPRE() {
        LinkedList<Integer> lista = new LinkedList<Integer>();

        if (!getArbol().isEmpty())
            numParesPRE(lista, getArbol());

        return lista;
    }

    public void numParesPRE (LinkedList<Integer> lista, BinaryTree<Integer> nodo ) {
        if (nodo.getData()%2 == 0) 
            lista.add(nodo.getData());

        if (nodo.hasLeftChild())
            numParesPRE(lista, nodo.getLeftChild());

        if (nodo.hasRightChild())
            numParesPRE(lista, nodo.getRightChild());
    }

    
    
	// inorder
    public LinkedList<Integer> numerosParesIN() {
        LinkedList<Integer> lista = new LinkedList<Integer>();

        if (!getArbol().isEmpty())
            this.numParesIN(lista, arbol);

        return lista;
    }

    public void numParesIN (LinkedList<Integer> lista, BinaryTree<Integer> nodo ) {
        if (nodo.hasLeftChild())
            numParesIN(lista, nodo.getLeftChild());

        if (nodo.getData()%2 == 0) 
            lista.add(nodo.getData());

        if (nodo.hasRightChild())
            numParesIN(lista, nodo.getRightChild());
    }

    // postorden
    public LinkedList<Integer> numerosParesPOST() {
        LinkedList<Integer> lista = new LinkedList<Integer>();

        if (!getArbol().isEmpty())
            this.numParesPOST(lista, arbol);

        return lista;
    }

    public void numParesPOST (LinkedList<Integer> lista, BinaryTree<Integer> nodo ) {
        if (nodo.hasLeftChild())
            numParesPOST(lista, nodo.getLeftChild());

        if (nodo.hasRightChild())
            numParesPOST(lista, nodo.getRightChild());

        if (nodo.getData()%2 == 0) 
            lista.add(nodo.getData());
    }

    // main
    public static void main (String[] args) {
        System.out.println("Test numeros Pares");
        BinaryTree<Integer> a = new BinaryTree<Integer>(4);
        a.addLeftChild(new BinaryTree<Integer>(2));
        a.addRightChild(new BinaryTree<Integer>(6));
        a.getLeftChild().addLeftChild(new BinaryTree<Integer>(1));
        a.getLeftChild().addRightChild(new BinaryTree<Integer>(3));
        a.getRightChild().addLeftChild(new BinaryTree<Integer>(5));
        a.getRightChild().addRightChild(new BinaryTree<Integer>(8));
        
        ContadorArbol c = new ContadorArbol(a);
        
        LinkedList<Integer> listaIN = c.numerosParesIN();
        System.out.println("Los nodos pares del arbol en INORDER son: ");
        System.out.println(listaIN);
        
        LinkedList<Integer> listaPRE = c.numerosParesPRE();
        System.out.println("Los nodos pares del arbol en PREORDER son: ");
        System.out.println(listaPRE);
        
        LinkedList<Integer> listaPOST = c.numerosParesPOST();
        System.out.println("Los nodos pares del arbol en POSTORDER son: ");
        System.out.println(listaPOST);
    }

}