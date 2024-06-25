package TP_Grafos;

public class lugar {
    private String nombre;
    private int minutos;

    public lugar(String nombre, int minutos) {
        this.nombre = nombre;
        this.minutos = minutos;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getMinutos() {
        return minutos;
    }
    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }
}