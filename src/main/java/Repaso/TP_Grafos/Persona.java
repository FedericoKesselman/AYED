package TP_Grafos;

public class Persona {
	private boolean jubilado;
	private String nombre;
	private String domicilio;
	private boolean cobro;
	
	public Persona(boolean jubilado, String nombre, String domicilio, boolean cobro) {
		this.jubilado = jubilado;
		this.nombre = nombre;
		this.domicilio = domicilio;
		this.cobro = cobro;
	}
	
	public boolean esJubilado() {
		return this.jubilado;
	}
	
	public boolean cumple() {
		return (jubilado && !cobro);
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public void cobro() {
		this.cobro = true;
	}
}
