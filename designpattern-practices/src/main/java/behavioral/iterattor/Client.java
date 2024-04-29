package behavioral.iterattor;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Aggregate<String> fruits = new AggregateImpl<>(new String[] {"Mango", "Banana", "Apple"});
		Iterator<String> it = fruits.creatorIterator();
		
		while(it.hasNext()) {
			String fruit = it.next();
			System.out.println(fruit);
		}

	}

}
