package paquete;

public class Monticulo {// MONTICULO DE MINIMO

	private int[] vector;
	private int ult;

	public Monticulo() {
		vector = new int[20];
		ult = 1;
	}
	
	public boolean poner(int n) {
		if (this.ult == this.vector.length)
			return false;// Vector lleno
		this.vector[this.ult] = n;
		int i = this.ult;
		int padre = i / 2;
		while (padre > 0 && this.vector[padre] > this.vector[i]) {
			int aux = this.vector[padre];
			this.vector[padre] = this.vector[i];
			this.vector[i] = aux;
			i = padre;
			padre = i / 2;
		}
		this.ult++;
		return true;
	}

	public int sacar() {
		if (this.ult == 1)
			return -1;// Vector vacio
		int raiz = this.vector[1];

		this.vector[1] = this.vector[this.ult-1];
		this.ult--;
		
		int i = 1;
		int hizq = i * 2;
		int hder = i * 2 + 1;
		while (this.ult > i && this.ult > hizq && ( (this.ult > hder && this.vector[hder] < this.vector[i]) || this.vector[hizq] < this.vector[i] )  ) {// No saque el unico elemento
			int hmin = hizq;
			if (this.ult > hder && this.vector[hder] < this.vector[hizq])
				hmin = hder;
			if (this.vector[hmin] < this.vector[i]) {
				int aux = this.vector[i];
				this.vector[i] = this.vector[hmin];
				this.vector[hmin] = aux;
			}
			i = hmin;
			hizq = i * 2;
			hder = i * 2 + 1;
		}

		return raiz;
	}

	public boolean isEmpty() {
		return this.ult == 1;
	}
	
	public void mostrar() {
		System.out.println("Vector: " + this.ult);
		for (int i = 1; i < this.ult; i++) {
			System.out.print(this.vector[i]+",");
		}
		System.out.println();
	}
}
