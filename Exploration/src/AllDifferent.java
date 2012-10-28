import java.util.Set;


public class AllDifferent {
	
	public AllDifferent(Set<Variable> variables) {
		this.variables = variables;
	}
	
	public Set<Variable> variables() {
		return variables;
	}
	
	private final Set<Variable> variables;
	
	public boolean satisfied() {
		boolean result = true;
		for(Variable a : variables) 
			for(Variable b : variables)
				result &= (a==b) || (a.value() != b.value());
		return result;
	}
	
	

}
