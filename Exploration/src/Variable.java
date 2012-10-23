import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;


public class Variable {
	
	public static final List<Integer> LIST;
	
	static {
		int n = 10;
		LIST = new ArrayList<Integer>(n);
		for(int i = 0; i < n; i++)
			LIST.add(i, i);
	}
	
	public Variable(String name) {
		this.name = name;
	}
	
	public final String name;
	
	public Domain<Integer> domain() {
		return domain;
	}
	
	private final int amount = 5;
	private Domain<Integer> domain = new Domain<Integer>(LIST, amount);

	public String toString() {
		return "D("+name+")" + " = "+ domain;
		
	}

}
