package homework3;

public class App {

	public static void main(String[] args) {
		
		LinkedDataList<Integer> list = new LinkedDataList<>();
		System.out.println(list.currentSize());

		for(int i = 0; i < 10; i++) {
			list.addToEnd(i);
		}
		System.out.println(list.currentSize());

		//for(int i = 0; i < 10; i++) {
			list.add(Integer.valueOf(100), 0);
			list.add(Integer.valueOf(100), 1);

		//}
		System.out.println(list.currentSize());
		Object[] a = list.lookAll();
		for(int i = 0; i < list.currentSize(); i++) {
			System.out.println(i + " " + a[i]);
		}

		

		a = list.lookAll();
		for(int i = 0; i < list.currentSize(); i++) {
			System.out.println(i + " " + a[i]);
		}
		System.out.println("currentSize "+list.currentSize());
		System.out.println("remove ");

		list.addToEnd(-1);
		a = list.lookAll();
		for(int i = 0; i < list.currentSize(); i++) {
			System.out.println(i + " " + a[i]);
		}
		System.out.println("currentSize "+list.currentSize());
		System.out.println(list.checkExistence(-1));


	}

}
