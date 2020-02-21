import java.util.Enumeration;
import java.util.Iterator;

public class CSVEumerator<T> implements Enumeration<T> {
	Iterator<T> iterator;

	public CSVEumerator(Iterator<T> iterator) {
		this.iterator = iterator;
	}

	@Override
	public boolean hasMoreElements() {
		return iterator.hasNext();
	}

	@Override
	public T nextElement() {
		return iterator.next();
	}
}
