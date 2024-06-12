package ArbolesG.Gematria;

import ArbolesG.GeneralTree;

public class ProcesadorGematria {
	
	
	public int contar (GeneralTree<Integer> arbol, int valor) {
		if (!arbol.isEmpty())
			return contarHelper (arbol, valor, 0);
		else
			return -1;
	}
	
	private int contarHelper (GeneralTree<Integer> nodo, int valor, int cantAct) {
		if (nodo.isLeaf()) {
			if ( (nodo.getData()+cantAct) == valor)
				return 1;
			else
				return 0;
		}
		else if (cantAct+nodo.getData() < valor){
			int cant = 0;
			
			for (GeneralTree<Integer> child: nodo.getChildren()) 
				cant += contarHelper(child, valor, cantAct+nodo.getData());
			
			return cant;
		}
		else
			return 0;
	}
	
	
	
}
