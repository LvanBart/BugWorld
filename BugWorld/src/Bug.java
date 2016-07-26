
import java.util.Scanner;

public class Bug {
	
	protected String species;
	protected String name;
	protected char symbol;
	protected int x;
	protected int y;
	protected int energy;
	protected int id;
	
	// constructors
	
	//default constructor
	public Bug () {
		this.species = "ant";
		this.name = "Gerald";
		this.symbol = 'B';
		this.x = 100;
		this.y = 100;
		this.energy = 100;
		this.id = 12345;
		
	}
	
	public Bug (String species, String name, char symbol, int x, int y, int energy, int id) {
		this.species = species;
		this.name = name;
		this.symbol = symbol; 
		this.x = x;
		this.y = y;
		this.energy = energy;
		this.id = id;
		
	}
	
	public String toString() {
		return "species: the bug's species, name: The bug's name, symbol: a character which represents the bug , "
				+ "x: The bug's horizontal position, y: the bug's vertical position, energy: how much energy the bug has left"
				+ ", id: a unique combination of digits which identifies the bug "; 
	}
	
	public String toText() {
		return this.species + " " + this.name + " " + this.symbol + " " + this.x + " " + this.y + " " + this.energy + " "
				+ " " + this.id;
	}
	
	// getters
	
	public String getSpecies() {
		return this.species;
	}
	
	public String getName() {
		return this.name;
	}
	
	public char getSymbol() {
		return this.symbol;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public int getEnergy() {
		return this.energy;
	}
	
	public int getId() {
		return this.id;
	}
	
	// setters
	
	public void setSpecies(String species) {
		this.species = species;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setSymbol(char symbol) {
		this.symbol = symbol;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public void setEnergy(int energy) {
		this.energy = energy;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	// other methods
	
	public void move(String direction, int distance) {
		if (direction.equals("N")) {
			this.y -= distance;			
		} else if (direction.equals("S")) {
			this.y += distance;
		} else if (direction.equals("E")) {
			this.x += distance;
		} else if (direction.equals("W")) {
			this.x -= distance;
		}
		
		
	}
	
	/**
	 *  Prompts the user for attributes, then sets bug's attributes to the provided values
	 */
	
	public void setAllAttributes() {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter a species: ");
		String newSpecies = scan.next();
		this.species = newSpecies;
		
		System.out.println("Enter a name: ");
		String newName = scan.next();
		this.name = newName;
		
		System.out.println("Enter a symbol: ");
		char newSymbol = scan.next().charAt(0);
		this.symbol = newSymbol;
		
		System.out.println("Enter x coordinate (integer): ");
		int newX = scan.nextInt();
		this.x = newX;

		System.out.println("Enter y coordinate (integer): ");
		int newY = scan.nextInt();
		this.y = newY;
		
		System.out.println("Enter energy level (integer): ");
		int newEnergy = scan.nextInt();
		this.energy = newEnergy;
		
		System.out.println("Enter id (integer): ");
		int newId = scan.nextInt();
		this.id = newId;
		
		scan.close();
		
	}
	
	

}

