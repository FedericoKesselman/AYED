package ArbolesG.Princesa;

public class Personaje {
	private String nombre;
	private String tipo;  
	
	public Personaje (String nombre, String tipo) {
		this.nombre = nombre;
		this.tipo = tipo;
	}
	
	public String getNombre () {
		return this.nombre;
	}
	
	public void setNombre (String nombre) {
		this.nombre = nombre;
	}
	
	public String getTipo() {
		return this.tipo;
	}
	
	public void setTipo (String tipo) {
		this.tipo = tipo;
	}
	
	public boolean esDragon() {
		return this.tipo.equals("Dragón");
	}
	
	public boolean esPrincesa() {
		return this.tipo.equals("Princesa");
	}
}
