
package Tp1;


public class Test {
    public static void main(String[] args) {
        Estudiante[] estudiantes = new Estudiante[2];
        Profesor[] profesores = new Profesor[3];
        
        estudiantes[0] = new Estudiante();
        estudiantes[1] = new Estudiante();
        
        estudiantes[0].setNombre("Federico");
        estudiantes[0].setApellido("K");
        estudiantes[0].setComision("2A");
        estudiantes[0].setEmail("fedek@gmail.com");
        estudiantes[0].setDireccion("Argentina");
        
        estudiantes[1].setNombre("Baltazar");
        estudiantes[1].setApellido("M");
        estudiantes[1].setComision("2B");
        estudiantes[1].setEmail("baltum@gmail.com");
        estudiantes[1].setDireccion("Canada");
        
        
        profesores[0] = new Profesor();
        profesores[1] = new Profesor();
        profesores[2] = new Profesor();
        
        profesores[0].setNombre("Laura");
        profesores[0].setApellido("F");
        profesores[0].setEmail("lauraf.com");
        profesores[0].setCatedra("C1");
        profesores[0].setFacultad("UNLP");
        
        profesores[1].setNombre("Pampa");
        profesores[1].setApellido("-");
        profesores[1].setEmail("pampa.com");
        profesores[1].setCatedra("C2");
        profesores[1].setFacultad("UCALP");
        
        profesores[2].setNombre("Claudia");
        profesores[2].setApellido("B");
        profesores[2].setEmail("clau.com");
        profesores[2].setCatedra("C3");
        profesores[2].setFacultad("UADE");
        
        
        System.out.println("Alumnos: ");
        for (Estudiante e: estudiantes) 
            System.out.println (e.tusDatos());
        
        
        System.out.println("Profesores: ");
        for (Profesor p: profesores) 
            System.out.println (p.tusDatos());
        
    }
}
