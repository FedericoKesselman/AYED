
package Tp1.ejercicio9;


public class Ej9 {

    
    public static void main(String[] args) {
       String s1 = "{()[()]}";
       System.out.println("La expresión 1 está balanceada? " + TestBalanceo.TestBalanceo(s1));
       
       String s2 = "([)]";
       System.out.println("La expresión 2 está balanceada? " + TestBalanceo.TestBalanceo(s2));
        
    }
    
}
