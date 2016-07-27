
import java.util.ArrayList;
import java.util.Scanner;

public class World {
	private char[] symbols = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j'}; 
	private ArrayList<Bug> bugs;
	private ArrayList<Plant> plants;
	private ArrayList<Obstacle> obstacles;
	private int height;
	private int width;


	public World(int width, int height) {
		bugs = new ArrayList<Bug>();
		plants = new ArrayList<Plant>();
		obstacles = new ArrayList<Obstacle>();
		this.height = height;
		this.width = width;

		// create bugs, add to bugs ArrayList

		Bug bug1 = new Bug("ant", "dsfg", 'a', 2, 3, 20, 7465386, 2);
		bugs.add(bug1);
		
		Plant plant1 = new Plant(6, 3, 2);
		plants.add(plant1);

		
		// set up text based menu
		Scanner scan = new Scanner(System.in); 
		
		System.out.println("How many times do you want world to refresh?: ");
		int numRefreshes = scan.nextInt();
		
		scan.close();
		
		this.drawWorld();
		
		// refresh world specified number of times
		for (int i = 0; i < numRefreshes; i++) {
			this.updateWorld();
			this.drawWorld();
		}

	}

	/*
	 * draws bugs and plants in world plants are drawn over bugs
	 */
	public void drawWorld() {
		// draw top border
		System.out.print("|");
		for (int i = 0; i < this.width; i++) {
			System.out.print("-");
		}
		System.out.println("|");

		// draw grid contents
		for (int row = 1; row < this.height + 1; row++) {
			System.out.print("|");
			for (int col = 1; col < width + 1; col++) {
				String letter = " ";
				// check if there is a bug at current position
				for (Bug b : this.bugs) {

					if (b.getX() == col && b.getY() == row) {
						letter = b.getSymbol() + "";
					}

				}
				// check if there is a plant at current position
				for (Plant p : this.plants) {
					if (p.getX() == col && p.getY() == row) {
						letter = p.getSize() + "";
					}
				}

				// check if there is an obstacle at current position
				for (Obstacle o : this.obstacles) {
					if (o.getX() == col && o.getY() == row) {
						letter = "Ø";
					}
				}

				// draw symbol of object at current location
				System.out.print(letter.charAt(0));
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
	 * Makes bugs move
	 */
	public void updateWorld() {
		// make each bug move
		for (Bug b : this.bugs) {
			String direction = b.smellFood(this);
			
			// if bug doesn't smell food, pick random direction
			if (direction.equals("none")) {
			
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
			}
			
			System.out.println(direction);
			moveBug(b, direction);
		}
		
		// make plants grow
		for (Plant p: this.plants) {
			p.grow();
		}

	}
	
	/*
	 * moves the bug in specified direction, if the space there is free
	 * if there is a plant there, bug eats the plant
	 */
	public void moveBug(Bug b, String direction) {
		// get bug's location
		int bugX = b.getX();
		int bugY = b.getY();
		int bugNewX = 1;
		int bugNewY = 1;
		
		// north
		if (direction.equals("N")) {
			bugNewX = bugX;
			bugNewY = bugY - 1;
			// make sure bugs don't move to where another plant, bug, or obstacle is
			// if there is a plant there, shrink it, as it is eaten by bug
			if (getPlantAt(bugNewX, bugNewY) != null) {
				getPlantAt(bugNewX, bugNewY).shrink();
			// if no other bug or obstacle is there, bug moves
			} else if (getBugAt(bugNewX, bugNewY) == null && !obstacleAt(bugNewX, bugNewY)) {
				b.move("N", 1, width, height);
			}
		// south
		} else if (direction.equals("S")) {
			bugNewX = bugX;
			bugNewY = bugY + 1;
			
			if (getPlantAt(bugNewX, bugNewY) != null) {
				getPlantAt(bugNewX, bugNewY).shrink();
			} else if (getBugAt(bugNewX, bugNewY) == null && !obstacleAt(bugNewX, bugNewY)) {
				b.move("S", 1, width, height);
			}
		
		// east
		} else if (direction.equals("E")) {
			bugNewX = bugX + 1;
			bugNewY = bugY;
			
			if (getPlantAt(bugNewX, bugNewY) != null) {
				getPlantAt(bugNewX, bugNewY).shrink();
			} else if (getBugAt(bugNewX, bugNewY) == null && !obstacleAt(bugNewX, bugNewY)) {
				b.move("E", 1, width, height);
			}
			
		// west
		} else {
			bugNewX = bugX - 1;
			bugNewY = bugY;
			
			if (getPlantAt(bugNewX, bugNewY) != null) {
				getPlantAt(bugNewX, bugNewY).shrink();
			} else if (getBugAt(bugNewX, bugNewY) == null && !obstacleAt(bugNewX, bugNewY)) {
				b.move("W", 1, width, height);
			}	
		}
		
	}
	
	/*
	 * returns the bug which is at the specified location
	 */
	public Bug getBugAt(int x, int y) {
		Bug bugAt = null;

		for (Bug b : this.bugs) {
			if (b.getX() == x && b.getY() == y) {
				bugAt = b;
			}
		}

		return bugAt;
	}
	
	
	/*
	 * returns whether there is an obstacle at the specified location
	 */
	public boolean obstacleAt(int x, int y) {
		for (Obstacle o : this.obstacles) {
			if (o.getX() == x && o.getY() == y) {
				return true;
			}
		}
		return false;
	}
	
	/*
	 * returns the plant which as at the specified location
	 */
	public Plant getPlantAt(int x, int y) {
		Plant plantAt = null;

		for (Plant p : this.plants) {
			if (p.getX() == x && p.getY() == y) {
				plantAt = p;
			}
		}

		return plantAt;
	}
	
	// getters
	public ArrayList<Bug> getBugs() {
		return this.bugs;
	}
	
	public ArrayList<Plant> getPlants() {
		return this.plants;
	}
	
	public ArrayList<Obstacle> getObstaclces() {
		return this.obstacles;
	}
}
