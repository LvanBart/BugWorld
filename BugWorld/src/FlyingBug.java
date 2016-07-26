
public class FlyingBug extends Bug {

	public FlyingBug () {
		super();
		this.species = "fly";
		this.symbol = 'F';
		
	}
	
	public FlyingBug(String species, String name, char symbol, int x, int y, int energy, int id) {
		super(species, name, symbol, x, y, energy, id);
	}
}
