import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;


public class Main {
	
	
	public static void main(String[] args) {
		ArrayList<Variable> variables = new ArrayList<Variable>();
		for(int i = 0; i < 10; i++) {
			variables.add(new Variable("x"+i));
		}
		
		Set<Variable> set1, set2, set3;
		set1 = populateFrom(variables);
		set2 = populateFrom(variables);
		set3 = populateFrom(variables);
		
		solve(variables, new AllDifferent(set1), new AllDifferent(set2), new AllDifferent(set3));
	}
	
	private static Set<Variable> populateFrom(List<Variable> possibleVariables) {
		int upperBound = possibleVariables.size();
		HashSet<Variable> variables = new HashSet<Variable>();
		Random generator = new Random();
		int amount = generator.nextInt(upperBound);
		for(int i = 0; i < amount; i++) 
			variables.add(possibleVariables.get(generator.nextInt(upperBound)));
		return variables;
	}
	
	@SafeVarargs
	private static void solve(List<Variable> variables, AllDifferent... allDiff) {	
		boolean[] satisfied = new boolean[allDiff.length];
		while(! check(satisfied, allDiff)) {
			for(Variable v : variables) {
				for(int i = 0; i < v.domain().size(); i++) {
					v.nextValue();
					if(check(satisfied, allDiff))
						break;
				}
				v.nextValue();
			}	
		}
//		for(AllDifferent ad : allDiff) {
//			System.out.println(ad.satisfied());
//			while(! ad.satisfied())
//				for(Variable v : ad.variables()) {
//					v.nextValue();
//					if(ad.satisfied())
//						break;
//				}
//		}
		for(AllDifferent ad : allDiff) {
			System.out.println(ad.variables());
			System.out.println(ad.satisfied());
		}
					
	}

	private static boolean check(boolean[] satisfied, AllDifferent... allDiff) {
		boolean done = true;
		for(int i = 0; i < allDiff.length; i++) {
			satisfied[i] = allDiff[i].satisfied();
			done &= satisfied[i];
		}
		return done;
	}
	
}
