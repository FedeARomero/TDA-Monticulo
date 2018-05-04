package paquete;

public class Main {

	public static void main(String[] args) {
		ColaPrioridad cola = new ColaPrioridad();
		int[] nums = {50,20,15,6,3,2,60,70,55};
		
		System.out.println("Agregar");
		for (int i = 0; i < nums.length; i++) {
			cola.add(nums[i]);
			cola.ver();
		}
		
//		cola.ver();
//		cola.add(50);
//		cola.ver();
//		cola.add(20);
//		cola.ver();
//		cola.add(70);
//		cola.ver();
//		cola.pull();
//		cola.ver();
//		cola.add(0);
//		cola.ver();
//		cola.pull();
//		cola.ver();
		System.out.println("Sacar");
		while(!cola.isEmpty()) {
			cola.pull();
			cola.ver();
		}
	}

}
