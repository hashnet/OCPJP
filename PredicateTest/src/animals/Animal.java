package animals;

public class Animal {
	private String species;
	private boolean hoppable;
	private boolean swimable;
	
	public Animal(String species, boolean hoppable, boolean swimable) {
		this.species = species;
		this.hoppable = hoppable;
		this.swimable = swimable;
	}
	
	public String getSpecies() { return species; }
	public boolean isHoppable() { return hoppable; }
	public boolean isSwimable() { return swimable; }
}
