package paquete;

public class ColaPrioridad {
	Monticulo m;
	
	public ColaPrioridad() {
		m = new Monticulo();
	}
	
	public boolean add(int n) {
		return m.poner(n);
	}
	
	public int pull() {
		return m.sacar();
	}
	
	public boolean isEmpty() {
		return m.isEmpty();
	}
	
	public void ver() {
		m.mostrar();
	}
}
