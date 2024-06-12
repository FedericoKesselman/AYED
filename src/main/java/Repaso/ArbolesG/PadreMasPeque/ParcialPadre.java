package ArbolesG.PadreMasPeque;

import ArbolesG.GeneralTree;
import java.util.*;

public class ParcialPadre {

	public static List<GeneralTree<Integer>> buscarPadres (GeneralTree<Integer> arbol) {
		LinkedList<GeneralTree<Integer>> lista = new LinkedList<>();
		
		if (!arbol.isEmpty())
			buscarPadresHelper (arbol, lista);
		
		return lista;
	}
	
	private static int buscarPadresHelper(GeneralTree<Integer> nodo, LinkedList<GeneralTree<Integer>> lista) {
		if (nodo.isLeaf()) 
			return nodo.getData();
		else {
			int suma = 0;
			
			for (GeneralTree<Integer> child: nodo.getChildren()) 
				suma += buscarPadresHelper(child, lista);
			
			if (nodo.getData() < suma)
				lista.add(nodo);
			
			return (suma + nodo.getData());
		}
	}
}
