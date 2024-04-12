
package Tp1.ejercicio9;


public class TestBalanceo {
    
    public static boolean TestBalanceo (String cadena) {
        Stack <Character> stack = new Stack<Character> ();
        char c;
        char tope;
        
        for (int i=0; i < cadena.length(); i++){ 
            c = cadena.charAt(i);
          
            if ((c == '(')||(c == '{')||(c == '[')) 
                stack.push(c);
            else {
                if (stack.isEmpty())
                    return false;
                
                tope = stack.top();
                if ( ((c == ')') && (tope == '(')) || ((c == ']') && (tope == '[')) || ((c == '}') && (tope == '{')) ) 
                    stack.pop();
                else
                    return false;
            }   
        }
        return stack.isEmpty();
    }
    
    
}
