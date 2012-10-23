import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

	public class Domain<T> {
		
		public Domain(List<T> possibleValues, int n) {
			populateFrom(possibleValues, n);
		}
		
		public Domain(List<T> possibleValues) {
			this(possibleValues, (int)Math.random());
		}
		
		
		private void populateFrom(List<T> possibleValues, int n) {
			int upperBound = possibleValues.size();
			Random generator = new Random();
				while(values.size() < n) {
					T randElement = possibleValues.get(generator.nextInt(upperBound));
					if(! values.contains(randElement))
						values.add(randElement);
				}
		}
		
		public boolean contains(T element) {
			return values.contains(element);
		}
		
		public Set<T> values() {
			return values;
		}
		
		private final Set<T> values = new HashSet<T>();
		
		public String toString() {
			String result = "{";
				for(T i : values())
					result += i + ", ";
				return result.substring(0, result.lastIndexOf(',')) + "}";
		}
	}