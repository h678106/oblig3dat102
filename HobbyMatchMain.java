package oblig3;

import java.util.HashSet;
import java.util.Set;

public class HobbyMatchMain {
		public static double match(Person a, Person b) {
			Set<String> felles = new HashSet<>(a.getHobbyer());
			felles.retainAll(b.getHobbyer());
			
			int antallFelles = felles.size();
			int antallKunHosA = a.getHobbyer().size() - antallFelles;
			int antallKunHosB = b.getHobbyer().size() - antallFelles;
			int antallTotalt = a.getHobbyer().size() + b.getHobbyer().size();
			
			return antallFelles - (antallKunHosA + antallKunHosB) / (double) antallTotalt;
		}
		
		public static void main(String[]args) {
			Person person1 = new Person("Arne", "jakt", "sykling", "venner", "data");
	        Person person2 = new Person("Bjørn", "jakt", "fiske", "venner", "friluftsliv");
	        Person person3 = new Person("Cathrine", "friluftsliv", "trening", "musikk");

	        double match1to2 = match(person1, person2);
	        double match1to3 = match(person1, person3);
	        double match2to3 = match(person2, person3);
	        
	        System.out.println("Match-score mellom Arne og Bjørn: " + match1to2);
	        System.out.println("Match-score mellom Arne og Cathrine: " + match1to3);
	        System.out.println("Match-score mellom Bjørn og Cathrine: " + match2to3);
	    
		}
	

}
