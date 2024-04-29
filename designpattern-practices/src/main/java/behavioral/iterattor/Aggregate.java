package behavioral.iterattor;

public interface Aggregate<E> {
	Iterator<E> creatorIterator();
}
