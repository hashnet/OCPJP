package animals;

public class CheckIfHoppable implements CheckTrait{

	@Override
	public boolean checkATrait(Animal animal) {
		return animal.isHoppable();
	}

}
