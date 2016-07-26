import java.awt.List;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class World {
	private ArrayList<Bug> bugs;
	private double height;
	private double width;
	
	// constructors
	public World () {
		bugs = new ArrayList<Bug>();
		this.height = 50;
		this.width = 50;
		
		/* Bug bug1 = new Bug("fly", "James", 'B', 12, 10, 50, 7628368);
		Bug bug2 = new Bug("cockroach", "Penelope", 'C', 20, 20, 23, 73645);
		Bug bug3 = new JumpingBug("grasshopper", "Earl", 'J', 1, 1, 45, 2839847);
		Bug bug4 = new CrawlingBug("beetle", "Patty", 'C', 8, 19, 45, 2839847);
		Bug bug5 = new FlyingBug("bee", "Lola", 'F', 4, 7, 45, 2839847); 
		bugs.add(bug1);
		bugs.add(bug2);
		bugs.add(bug3);
		bugs.add(bug4);
		bugs.add(bug5);
		*/
		
		for (int i = 0; i < 10; i++) {
			int randX = (int)(1 + Math.random() * width - 1);
			int randY = (int)(1 + Math.random() * height - 1);
			
			bugs.add(new Bug("ant", "bug", '1', randX, randY, 50, 2364283 ));
		}
		
		
		this.drawWorld();
	}
	
	public World (double height, double width) {
		bugs = new ArrayList<Bug>();
		this.height = height;
		this.width = width;
		
		Bug bug1 = new Bug("fly", "James", 'A', 12, 10, 50, 7628368);
		Bug bug2 = new Bug("cockroach", "Penelope", 'B', 20, 20, 23, 73645);
		Bug bug3 = new JumpingBug("grasshopper", "Earl", 'C', 1, 1, 45, 2839847);
		Bug bug4 = new CrawlingBug("beetle", "Patty", 'D', 8, 19, 45, 2839847);
		Bug bug5 = new FlyingBug("bee", "Lola", 'E', 4, 7, 45, 2839847); 
		bugs.add(bug1);
		bugs.add(bug2);
		bugs.add(bug3);
		bugs.add(bug4);
		bugs.add(bug5);
		
		
		/*for (int i = 0; i < 10; i++) {
			int randX = (int)(1 + Math.random() * width - 1);
			int randY = (int)(1 + Math.random() * height - 1);
			
			bugs.add(new Bug("ant", "bug", '1', randX, randY, 50, 2364283 ));
		} */
		
		this.drawWorld();
		
		for (int i = 0; i < 5; i++) {
			this.updateWorld();
			this.drawWorld();
		}
		
		
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
			for (int col = 1; col < height + 1; col++) {
				String letter = " ";
				for (Bug b: this.bugs) {
					
					if (b.getX() == col && b.getY() == row) {
						letter = b.getSymbol() + "";
					}	
					
				}
				System.out.print(letter);
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
	
	
	/*
	 * Randomly decides whether each bug will move
	 * if bug moves, randomly picks a direction for bug to move in
	 */
	public void updateWorld () {
		
		for (Bug b: this.bugs) {
			// find random direction
			String direction = "";
			double randNum = Math.random();
								
							if (randNum < 0.25) {
								direction = "N";
							} else if (randNum < 0.5) {
								direction = "S";
							} else if (randNum < 0.75) {
								direction = "E";
							} else {
								direction = "W";
							}
								
				
			// decide if bug will move (50/50 chance)
			/* randNum = Math.random();
			
			if (randNum < 0.5) {
				b.move(direction, 3, (int)width, (int)height);
			} */
				
			b.move(direction, 2, (int)width, (int)height);
		}
	
	
	
}
}
