package animals;

public class CheckIfSwimmable implements CheckTrait{

	@Override
	public boolean checkATrait(Animal animal) {
		return animal.isSwimable();
	}

}
