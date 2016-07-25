import java.util.ArrayList;


public class Test {

	public static void main (String[] args) {
		Bug bug1 = new Bug();
		Bug bug2 = new Bug("cockroach", "Penelope", 'C', 150, 150, 23, 73645);
		Bug bug3 = new Bug();
		Bug bug4 = new Bug("ladybug", "John", 'L', 200, 200, 95, 45377);
		
		ArrayList<Bug> bugs = new ArrayList<Bug>();
		
		bugs.add(bug1);
		bugs.add(bug2);
		bugs.add(bug4);
		
		double randNum;
		String direction = "N";
		
for (Bug b : bugs) {
	System.out.println(b.toText());
}
		
for (int i = 0; i < bugs.size(); i++)
{
	System.out.println(bugs.get(i).toText());
}
		
		
		
		for (int i = 0; i < 100; i++) {
			randNum = Math.random();
			
			if (randNum < 0.25) {
				direction = "N";
			} else if (randNum < 0.5) {
				direction = "S";
			} else if (randNum < 0.75) {
				direction = "E";
			} else {
				direction = "W";
			}
			
			bug3.move(direction, 1);
			
			
			
			
		}
		
		
	}
}

