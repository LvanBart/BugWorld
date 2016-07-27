
import java.util.ArrayList;

public class World {
	private ArrayList<Bug> bugs;
	private ArrayList<Plant> plants;
	private ArrayList<Obstacle> obstacles;
	private int height;
	private int width;

	// constructors
	public World() {
		bugs = new ArrayList<Bug>();
		this.height = 50;
		this.width = 50;

		/*
		 * Bug bug1 = new Bug("fly", "James", 'B', 12, 10, 50, 7628368); Bug
		 * bug2 = new Bug("cockroach", "Penelope", 'C', 20, 20, 23, 73645); Bug
		 * bug3 = new JumpingBug("grasshopper", "Earl", 'J', 1, 1, 45, 2839847);
		 * Bug bug4 = new CrawlingBug("beetle", "Patty", 'C', 8, 19, 45,
		 * 2839847); Bug bug5 = new FlyingBug("bee", "Lola", 'F', 4, 7, 45,
		 * 2839847); bugs.add(bug1); bugs.add(bug2); bugs.add(bug3);
		 * bugs.add(bug4); bugs.add(bug5);
		 */

		for (int i = 0; i < 10; i++) {
			int randX = (int) (1 + Math.random() * width - 1);
			int randY = (int) (1 + Math.random() * height - 1);

			bugs.add(new Bug("ant", "bug", '1', randX, randY, 50, 2364283));
		}

		this.drawWorld();
	}

	public World(int height, int width) {
		bugs = new ArrayList<Bug>();
		plants = new ArrayList<Plant>();
		obstacles = new ArrayList<Obstacle>();
		this.height = height;
		this.width = width;

		// create bugs, add to bugs ArrayList

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

		// create plants, add to plants ArrayList
		Plant plant1 = new Plant(0, 2, 3);
		Plant plant2 = new Plant(3, 5, 10);
		Plant plant3 = new Plant(6, 12, 5);
		Plant plant4 = new Plant(9, 1, 2);

		plants.add(plant1);
		plants.add(plant2);
		plants.add(plant3);
		plants.add(plant4);

		// create obstacles, add to obstacles ArrayList
		Obstacle obstacle1 = new Obstacle(5, 10);
		Obstacle obstacle2 = new Obstacle(10, 1);
		Obstacle obstacle3 = new Obstacle(2, 2);
		Obstacle obstacle4 = new Obstacle(2, 5);

		obstacles.add(obstacle1);
		obstacles.add(obstacle2);
		obstacles.add(obstacle3);
		obstacles.add(obstacle4);

		this.drawWorld();

		for (int i = 0; i < 5; i++) {
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
		for (int i = 0; i < width; i++) {
			System.out.print("-");
		}
		System.out.println("|");

		// draw grid contents
		for (int row = 1; row < width + 1; row++) {
			System.out.print("|");
			for (int col = 1; col < height + 1; col++) {
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
	 * Makes bugs move in random direction
	 */
	public void updateWorld() {

		for (Bug b : this.bugs) {
			// find random direction
			String direction = "";
			double randNum = Math.random();
			
			// get bug's location
			int bugX = b.getX();
			int bugY = b.getY();
			int bugNewX = 1;
			int bugNewY = 1;
			
			// north
			if (randNum < 0.25) {
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
			} else if (randNum < 0.5) {
				bugNewX = bugX;
				bugNewY = bugY + 1;
				
				if (getPlantAt(bugNewX, bugNewY) != null) {
					getPlantAt(bugNewX, bugNewY).shrink();
				} else if (getBugAt(bugNewX, bugNewY) == null && !obstacleAt(bugNewX, bugNewY)) {
					b.move("S", 1, width, height);
				}
			
			// east
			} else if (randNum < 0.75) {
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

	}

	public Bug getBugAt(int x, int y) {
		Bug bugAt = null;

		for (Bug b : this.bugs) {
			if (b.getX() == x && b.getY() == y) {
				bugAt = b;
			}
		}

		return bugAt;
	}

	public boolean obstacleAt(int x, int y) {
		for (Obstacle o : this.obstacles) {
			if (o.getX() == x && o.getY() == y) {
				return true;
			}
		}
		return false;
	}

	public Plant getPlantAt(int x, int y) {
		Plant plantAt = null;

		for (Plant p : this.plants) {
			if (p.getX() == x && p.getY() == y) {
				plantAt = p;
			}
		}

		return plantAt;
	}
}
