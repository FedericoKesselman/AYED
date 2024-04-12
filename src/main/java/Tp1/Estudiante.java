
package Tp1;


public class Estudiante extends Persona{
    private String comision;
    private String direccion;

    
    public String tusDatos() {
        String aux = super.toString() +
                     " Comision:" + getComision() + 
                     " Direccion:" + getDireccion();
        
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
