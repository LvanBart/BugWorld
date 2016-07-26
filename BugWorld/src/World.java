import java.awt.List;
import java.util.ArrayList;

public class World {
	private ArrayList<Bug> bugs;
	private double height;
	private double width;
	
	// constructors
	public World () {
		bugs = new ArrayList<Bug>();
		this.height = 50;
		this.width = 50;
		
		Bug bug1 = new Bug();
		Bug bug2 = new Bug("cockroach", "Penelope", 'C', 150, 150, 23, 73645);
		Bug bug3 = new JumpingBug();
		Bug bug4 = new CrawlingBug();
		Bug bug5 = new FlyingBug();
		
		bugs.add(bug1);
		bugs.add(bug2);
		bugs.add(bug3);
		bugs.add(bug4);
		bugs.add(bug5);
		
		this.drawWorld();
	}
	
	public World (double height, double width) {
		bugs = new ArrayList<Bug>();
		this.height = height;
		this.width = width;
		
		Bug bug1 = new Bug();
		Bug bug2 = new Bug("cockroach", "Penelope", 'C', 150, 150, 23, 73645);
		Bug bug3 = new JumpingBug();
		Bug bug4 = new CrawlingBug();
		Bug bug5 = new FlyingBug();
		
		bugs.add(bug1);
		bugs.add(bug2);
		bugs.add(bug3);
		bugs.add(bug4);
		bugs.add(bug5);
		
		
	}
	
	// drawWorld
	public void drawWorld () {
		// draw top border
		System.out.print("|");
		for (int i = 0; i < width; i++) {
			System.out.print("-");
		}
		System.out.println("|");
		
		// draw grid contents
		for (int row = 1; row < width + 1; row++) {
			System.out.print("|");
			for (int col = 0; col < height; col++) {
				System.out.print(" ");
			}
			System.out.println("|");
		}
		
		// draw bottom border
		System.out.print("|");
		for (int i = 0; i < width; i++) {
			System.out.print("-");
		}
		System.out.println("|");
	}
	
	
	// updateWorld
	public void updateWorld () {
		
	}
	
	
	
}
