package slimescape;

public class XpPotion implements Item{

	@Override
	public void UseItem(Slime s) {
		// TODO Auto-generated method stub
		s.setXp(s.getXp()+1);
		s.evolve();
	}
	
}
