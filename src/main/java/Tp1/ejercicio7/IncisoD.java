
package Tp1.ejercicio7;
import java.util.ArrayList;

public class IncisoD {
    
    public static void main(String[] args) {
        ArrayList<Estudiante> listaEstudiantes = new ArrayList();
        
        Estudiante e1 = new Estudiante ("Federico", "K", "fede.com", "2A", "La Plata");
        listaEstudiantes.add(e1);
        Estudiante e2 = new Estudiante ("Baltazar", "M", "baltu.com", "2B", "Gonnet");
        listaEstudiantes.add(e2);
        Estudiante e3 = new Estudiante ("Valentino", "S", "valen.com", "2C", "City Bell");
        listaEstudiantes.add(e3); 
        
        ArrayList <Estudiante> copia_listaEstudiantes = new ArrayList(listaEstudiantes);
        
        /* OTRAS FORMAS DE COPIAR LISTA: 
            copia_listaEstudiantes = listaEstudiantes; 
            
            copia_listaEstudiantes.addAll(listaEstudiantes) 
        */
        
        System.out.println ("Lista original: ");
        Metodos.ImprimirLista(listaEstudiantes);
        
        System.out.println ("Lista clonada: ");
        Metodos.ImprimirLista(copia_listaEstudiantes);
        
        e1.setNombre("Fedderico");
        System.out.println ("Lista original: ");
        Metodos.ImprimirLista(listaEstudiantes);
        
        System.out.println ("Lista clonada: ");
        Metodos.ImprimirLista(copia_listaEstudiantes);
        /* CONCLUSION: se modifica el objeto E1 y los cambios afectan a ambas listas. De esta forma se puede ver como 
                       todo es a traves de referencias. 
        */
        
        Estudiante e4 = new Estudiante ("Baltazar", "M", "baltu.com", "2B", "Gonnet");
        Metodos.AgregarEstudiante(listaEstudiantes, e4);
        
        Estudiante e5 = new Estudiante ("Ignacio", "B", "nacho.com", "2D", "Centro La Plata");
        Metodos.AgregarEstudiante(listaEstudiantes, e5);
        
        Metodos.ImprimirLista(listaEstudiantes);
    }
}
