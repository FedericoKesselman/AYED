package Repaso.ArbolesG;
import java.util.*;

public class ParcialesArboles10 {
	
	public static List<Integer> resolver(GeneralTree<Integer> arbol) {
		List<Integer> lista = new LinkedList<>();
		
		if (!arbol.isEmpty())
			resolverHelper(arbol, lista, new LinkedList<Integer>(), 0, 0, 0);
		
		return lista;
	}
	
	
	private static int resolverHelper (GeneralTree<Integer> nodo, List<Integer> caminoMax, List<Integer> caminoAct, int cant, int nivel, int max) {
        if (nodo.getData() != 0) {
            caminoAct.add(nodo.getData());
            cant += nivel;
        }

        if (!nodo.isLeaf()) {
        	for (GeneralTree<Integer> child: nodo.getChildren()) 
                max = resolverHelper (child, caminoMax, caminoAct, cant, nivel+1, max);
        }
        else {
            if (cant > max) {
                max = cant;
                caminoMax.removeAll(caminoMax);
                caminoMax.addAll(caminoAct);
            }
        }

        if (nodo.getData() == 1) {
            caminoAct.remove(caminoAct.size()-1);
            cant -= nivel;
        }
           
        return max;
    }
	
	
	public static void main(String[] args){
        List<GeneralTree<Integer>> subChildren1 = new LinkedList<GeneralTree<Integer>>();
        subChildren1.add(new GeneralTree<Integer>(1));
        subChildren1.add(new GeneralTree<Integer>(1));
        subChildren1.add(new GeneralTree<Integer>(1));
        GeneralTree<Integer> subA = new GeneralTree<Integer>(1, subChildren1);
        List<GeneralTree<Integer>> subChildren2 = new LinkedList<GeneralTree<Integer>>();
        subChildren2.add(subA);
        subChildren2.add(new GeneralTree<Integer>(1));
        GeneralTree<Integer> a1 = new GeneralTree<Integer>(0, subChildren2);
        
        List<GeneralTree<Integer>> subChildren3 = new LinkedList<GeneralTree<Integer>>();
        subChildren3.add(new GeneralTree<Integer>(1));
        GeneralTree<Integer> subB = new GeneralTree<Integer>(0, subChildren3);
        List<GeneralTree<Integer>> subChildren4 = new LinkedList<GeneralTree<Integer>>();
        subChildren4.add(subB);
        GeneralTree<Integer> subC = new GeneralTree<Integer>(0, subChildren4);
        List<GeneralTree<Integer>> subChildren5 = new LinkedList<GeneralTree<Integer>>();
        subChildren5.add(new GeneralTree<Integer>(1));
        subChildren5.add(subC);
        GeneralTree<Integer> a2 = new GeneralTree<Integer>(1, subChildren5);
        
        List<GeneralTree<Integer>> subChildren6 = new LinkedList<GeneralTree<Integer>>();
        subChildren6.add(new GeneralTree<Integer>(0));
        subChildren6.add(new GeneralTree<Integer>(0));
        GeneralTree<Integer> subD = new GeneralTree<Integer>(0, subChildren6);
        List<GeneralTree<Integer>> subChildren7 = new LinkedList<GeneralTree<Integer>>();
        subChildren7.add(subD);
        GeneralTree<Integer> subE = new GeneralTree<Integer>(0, subChildren7);
        List<GeneralTree<Integer>> subChildren8 = new LinkedList<GeneralTree<Integer>>();
        subChildren8.add(subE);
        GeneralTree<Integer> a3 = new GeneralTree<Integer>(1, subChildren8);
        
        List<GeneralTree<Integer>> arbol = new LinkedList<GeneralTree<Integer>>();
        arbol.add(a1);
        arbol.add(a2);
        arbol.add(a3);
        GeneralTree<Integer> a = new GeneralTree<Integer>(1, arbol);
        
        System.out.println(resolver(a));
        
    }
	
}
