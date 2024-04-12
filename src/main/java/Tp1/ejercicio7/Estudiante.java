
package Tp1.ejercicio7;


public class Estudiante extends Persona{
    private String comision;
    private String direccion;
    
    
    public Estudiante (String unNombre, String unApellido, String unEmail, String Comision, String Direccion) {
        super (unNombre, unApellido, unEmail);
        setComision(Comision);
        setDireccion(Direccion);
    }

    public String tusDatos() {
        String aux = super.toString() +
                     ", Comision :" + getComision() + 
                     ", Direccion :" + getDireccion();
        
        return aux;
    }
    
    public String getComision() {
        return comision;
    }

    public void setComision(String comision) {
        this.comision = comision;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
