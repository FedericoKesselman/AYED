package ArbolesG.Princesa;

import ArbolesG.GeneralTree;
import java.util.*;

public class ParcialPrincesa {
	
	public static List<Personaje> encontrarPrincesa(GeneralTree<Personaje> arbol) {
		LinkedList<Personaje> lista = new LinkedList<>();
		
		if ( (!arbol.isEmpty()) && (!arbol.getData().esDragon()))
			encontrarPrincesaHelper (arbol, lista, new LinkedList<Personaje>());
		
		return lista;
	}
	
	private static boolean encontrarPrincesaHelper (GeneralTree<Personaje> nodo, List<Personaje> camino, List<Personaje> caminoAct) {
		caminoAct.add(nodo.getData());
		
		if (nodo.getData().esPrincesa()) {
			camino.addAll(caminoAct);
			return true;
		}
		else {
			boolean paro = false; // Si ya encuentra el dato para 
			
			for (GeneralTree<Personaje> child: nodo.getChildren()) {
				if ( (!child.getData().esDragon()) && (!paro) )
					paro = encontrarPrincesaHelper (child, camino, caminoAct);
			}
			
			caminoAct.remove(caminoAct.size()-1);
			return false;
		}
	}
	
	public static void main(String[] args) {
		Personaje p0 = new Personaje("COYOTE", "Animal");
        Personaje p1 = new Personaje("SIMBA", "Animal");
        Personaje p2 = new Personaje("MUSHU", "Dragón");
        Personaje p3 = new Personaje("TIMON", "Animal");
        Personaje p4 = new Personaje("ELLIOT", "Dragón");
        Personaje p5 = new Personaje("Bella", "Princesa");
        Personaje p6 = new Personaje("ZAZU", "Animal");
        Personaje p7 = new Personaje("RAFIKI", "Animal");
        Personaje p8 = new Personaje("MULAN", "Princesa");
        Personaje p9 = new Personaje("FROZEN", "Princesa");
        Personaje p10 = new Personaje("NALA", "Animal");

        // SIMBA
        GeneralTree<Personaje> a1 = new GeneralTree<>(p1);

        // MUSHU
        GeneralTree<Personaje> a31 = new GeneralTree<>(p3);
        GeneralTree<Personaje> a32 = new GeneralTree<>(p5);
        GeneralTree<Personaje> a33 = new GeneralTree<>(p4);
        List<GeneralTree<Personaje>> hijosMushu = new LinkedList<>();
        hijosMushu.add(a31);
        hijosMushu.add(a32);
        hijosMushu.add(a33);
        GeneralTree<Personaje> a2 = new GeneralTree<>(p2, hijosMushu);

        // ZAZU
        GeneralTree<Personaje> a61 = new GeneralTree<>(p7);
        GeneralTree<Personaje> a62 = new GeneralTree<>(p8);
        List<GeneralTree<Personaje>> hijosZazu = new LinkedList<>();
        hijosZazu.add(a61);
        hijosZazu.add(a62);
        GeneralTree<Personaje> a3 = new GeneralTree<>(p6, hijosZazu);

        // MULAN
        GeneralTree<Personaje> a81 = new GeneralTree<>(p9);
        GeneralTree<Personaje> a82 = new GeneralTree<>(p10);
        List<GeneralTree<Personaje>> hijosMulan = new LinkedList<>();
        hijosMulan.add(a81);
        hijosMulan.add(a82);
        GeneralTree<Personaje> a8 = new GeneralTree<>(p8, hijosMulan);

        // COYOTE
        List<GeneralTree<Personaje>> hijosCoyote = new LinkedList<>();
        hijosCoyote.add(a1);
        hijosCoyote.add(a2);
        hijosCoyote.add(a3);
        GeneralTree<Personaje> arbol = new GeneralTree<>(p0, hijosCoyote);
        
        List<Personaje> result = ParcialPrincesa.encontrarPrincesa(arbol);
		for (Personaje per: result)
			System.out.println (per.getNombre() + ' ' + per.getTipo());
	}
	
}
