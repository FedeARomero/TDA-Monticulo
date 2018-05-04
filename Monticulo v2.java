package paquete;

public class Monticulo {

	private int[] vector;
	private int ultimo;
	
	public Monticulo(int tam) {
		vector = new int[tam];
		ultimo = 1;
	}
	
	public Monticulo() {
		this(25);
	}
	
	public boolean poner(int n) {
		if( this.ultimo == this.vector.length ) return false;
		
		this.vector[this.ultimo] = n;
		
		for( int hijo = this.ultimo , padre = hijo / 2 ; 0 < padre && this.vector[padre] > this.vector[hijo] ; hijo = padre , padre = hijo / 2) {
			int aux = this.vector[padre];
			this.vector[padre] = this.vector[hijo];
			this.vector[hijo] = aux;
		}
		
		this.ultimo++;
		return true;
	}
	
	public int sacar() {
		if( this.ultimo == 1 ) return -1;
		
		int raiz = this.vector[1]; 
		this.vector[1] = this.vector[--this.ultimo];
		
		int padre = 1;
		int hizq = padre * 2;
		int hder = padre * 2 + 1;
		
		while( padre < this.ultimo &&
			 (( hder < this.ultimo && this.vector[hder] < this.vector[padre] ) || 
			  ( hizq < this.ultimo && this.vector[hizq] < this.vector[padre] ) )){
			
			int hmenor = ( hder < this.ultimo && this.vector[hder] < this.vector[hizq] ) ? hder : hizq;
			
			int aux = this.vector[padre];
			this.vector[padre] = this.vector[hmenor];
			this.vector[hmenor] = aux;
			
			padre = hmenor;
			hizq = padre * 2;
			hder = padre * 2 + 1;
		}
		
		return raiz;
	}
	
	public boolean isEmpty() {
		return this.ultimo == 1;
	}
	
	public void mostrar() {
		System.out.print("Vector: ");
		for (int i = 1; i < this.ultimo; i++)
			System.out.print(this.vector[i] + ",");
		System.out.println();
	}
	
	public static void main(String[] args) {
		
		Monticulo m = new Monticulo();
		int[] nums = {50,20,15,6,3,2,60,70,55};
		
		System.out.println("       AGREGAR");
		for (int i = 0; i < nums.length; i++) {
			m.poner(nums[i]);
			m.mostrar();
		}
		
		System.out.println("       SACAR");
		while(!m.isEmpty()) {
//			m.mostrar();
			System.out.println("Pull: " + m.sacar());
		}

	}

}
























	//for(int padre = 1, hizq = padre * 2, hder = padre * 2 + 1, hmenor;
	//
	//padre < this.ultimo &&
	//hizq < this.ultimo && 
	//(( hder < this.ultimo && this.vector[hder] < this.vector[padre] ) || 
	//				   	  this.vector[hizq] < this.vector[padre] );
	//
	//padre = hmenor,	hizq = padre * 2, hder = padre * 2 + 1){
	//
	//hmenor = ( hder < this.ultimo && this.vector[hder] < this.vector[hizq] ) ? hder : hizq;
	//
	//int aux = this.vector[padre];
	//this.vector[padre] = this.vector[hmenor];
	//this.vector[hmenor] = aux;
	//}